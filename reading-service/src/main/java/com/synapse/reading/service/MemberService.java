package com.synapse.reading.service;

import com.google.gson.Gson;
import com.synapse.common.constants.PageInfo;
import com.synapse.common.sso.model.User;
import com.synapse.common.trans.BizTrans;
import com.synapse.common.trans.BizTransUtils;
import com.synapse.common.trans.Result;
import com.synapse.common.utils.DateUtils;
import com.synapse.reading.constants.MemberConstants;
import com.synapse.reading.constants.TradeOrderConstants;
import com.synapse.reading.dto.param.MiniQrcodeParam;
import com.synapse.reading.dto.param.RegistParam;
import com.synapse.reading.dto.result.MemberResult;
import com.synapse.reading.model.*;
import com.synapse.reading.model.model.UserRole;
import com.synapse.reading.remote.GatwayService;
import com.synapse.reading.remote.IdService;
import com.synapse.reading.remote.ShortLinkApiService;
import com.synapse.reading.remote.UserService;
import com.synapse.reading.respository.AudioRespository;
import com.synapse.reading.respository.MemberRespository;
import com.synapse.reading.service.service.UserRoleService;
import com.synapse.reading.util.ShareCodeUtil;
import net.logstash.logback.encoder.org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;


/**
 * <p>
 * 用户信息 服务实现类
 * </p>
 *
 * @author liuguangfu
 * @since 2018-12-06
 */
@Service
@Transactional
public class MemberService extends MemberBaseService {

    private Logger logger = LoggerFactory.getLogger(MemberService.class);

    @Value("${vipCodeDownload}")
    private String vipCodeDownload;
    @Autowired
    private IdService idService;
    @Autowired
    private MemberRespository memberRespository;
    @Autowired
    private MySigninService mySigninService;
    @Autowired
    private UserService userService;
    @Autowired
    private GatwayService gatwayService;
    @Autowired
    private MiniQrcodeService miniQrcodeService;
    @Autowired
    private AudioRespository audioRespository;
    @Autowired
    private ShortLinkApiService shortLinkApiService;
    @Autowired
    private Gson gson;
    @Autowired
    private BaseSystemParameterService baseSystemParameterService;
    @Autowired
    private TradeOrderService tradeOrderService;
    @Autowired
    private TradeOrderDetailService tradeOrderDetailService;
    @Autowired
    private OrgCodeService orgCodeService;
    @Autowired
    private StringRedisTemplate redisTemplate;
    @Autowired
    private UserRoleService userRoleService;


    public Member find(String recId) {
        if (recId == null) {
            return null;
        }
        return memberRespository.selectByPrimaryKey(recId);
    }


    public List<MemberResult> listByClassId(String classId, PageInfo pageInfo) {
        Map<String, Object> params = new HashMap<>();
        params.put("classId", classId);
        params.put("startIndex", pageInfo.getCurrentStartIndex());
        params.put("pageSize", pageInfo.getPerPageNum());
        return memberRespository.listByClassId(params);
    }

    public Integer countClassMember(String classId) {

        return memberRespository.countClassMember(classId);
    }

    public Member selectByUserId(String recId) {
        if (recId == null) {
            return null;
        }
        return memberRespository.selectByUserId(recId);
    }

    public String selectByPhone(String phone) {

        return memberRespository.selectByPhone(phone);
    }

    public Integer update(Member param) {
        String now = DateUtils.getNowStr(DateUtils.FORMAT_DATE_TIME);
        param.setUpdateTime(now);
        return memberRespository.updateByPrimaryKeySelective(param);
    }

    public String joinSchool(String orgCode, User user) {
        OrgCode model = orgCodeService.find(orgCode);
        if (model != null && !"".equals(model)) {
            Member member1 = memberRespository.selectByUserId(model.getCreateId());
            Member member2 = memberRespository.selectByUserId(user.getRecId());
            if (member2 != null && !"".equals(member2)) {
                member2.setOrganization(member1.getOrganization());
                update(member2);
            } else {
                member2.setUserId(user.getRecId());
                member2.setOrganization(member1.getOrganization());
                create(member2);
            }
            return member2.getUserId();
        }
        return "";
    }


    public List<MemberResult> listMember(Map<String, String> map) {
        return memberRespository.listMember(map);
    }

    public boolean addPoint(User user, Integer point) {
        MySignin mySignin = new MySignin();
        mySignin.setCreateId(user.getRecId());
        mySignin.setPoint(point);
        mySigninService.create(mySignin);
        String now = DateUtils.getNowStr(DateUtils.FORMAT_DATE_TIME);
        Member param = memberRespository.selectByPrimaryKey(user.getRecId());
        if (param == null) {
            param = new Member();
            param.setUserId(user.getRecId());
            param.setCreateId(user.getRecId());
            param.setCreateTime(now);
//            param.setUpdateTime(now);
//            param.setUpdateId(param.getCreateId());
//            param.setPoint(0);
            param.setPoint(point);
            memberRespository.insert(param);
            return true;
        } else {
            param.setUpdateId(user.getRecId());
            param.setUpdateTime(now);
            param.setUpdateId(user.getRecId());
            param.setPoint(point);
            param.setUserId(user.getRecId());
            return memberRespository.addPoint(param) > 0;
        }
    }


    public String create(Member param) {
        String now = DateUtils.getNowStr(DateUtils.FORMAT_DATE_TIME);
        if (param.getUserId() == null || "".equals(param.getUserId())) {
            param.setUserId(idService.gen("ID"));
        }
        param.setCreateTime(now);
        param.setUpdateTime(now);
        memberRespository.insert(param);
        return param.getUserId();
    }

    public String createByUserId(Member param, User user) {
        if (memberRespository.selectByPrimaryKey(user.getRecId()) != null) {
            return user.getRecId();
        }
        String now = DateUtils.getNowStr(DateUtils.FORMAT_DATE_TIME);
        param.setUserId(user.getRecId());
        param.setPoint(0);
        param.setCreateTime(now);
        param.setUpdateTime(now);
        memberRespository.insert(param);
        return param.getUserId();
    }


    public Integer delete(String recId) {
        return memberRespository.deleteByPrimaryKey(recId);
    }

    public List<Member> list(Member memberParam, PageInfo pageInfo) {
        Map<String, Object> params = prepareParams(memberParam);
        params.put("startIndex", pageInfo.getCurrentStartIndex());
        params.put("pageSize", pageInfo.getPerPageNum());
        return memberRespository.list(params);
    }

    public List<MemberResult> listByShchool(Member memberParam, String startTime, String endTime) {
        Map<String, Object> params = prepareParams(memberParam);
        if (startTime != null && !"".equals(startTime)) {
            params.put("startTime", startTime);
        }
        if (endTime != null && !"".equals(endTime)) {
            params.put("endTime", endTime);
        }
        return memberRespository.listByShchool(params);
    }

    public List<Member> listTeacher(String roleId, PageInfo pageInfo) {
        Map<String, Object> params = new HashMap<>();
        params.put("roleId", roleId);
        params.put("startIndex", pageInfo.getCurrentStartIndex());
        params.put("pageSize", pageInfo.getPerPageNum());
        return memberRespository.listTeacher(params);
    }

    public List<MemberResult> listTeacherBySchool(User user, String startTime, String endTime) {
        Member member = memberRespository.selectByUserId(user.getRecId());
        logger.info("----------------------user.getRecId()=" + user.getRecId());
        logger.info("----------------------member.getRecId()=" + member.getUserId());
        List<MemberResult> memberList = new ArrayList<>();
        if (member != null && !"".equals(member)) {
            if (member.getOrganization() != null && !"".equals(member.getOrganization())) {
                Member member1 = new Member();
                member1.setOrganization(member.getOrganization());
                logger.info("----------------------0rg=" + member1.getOrganization());
                memberList = listByShchool(member1, startTime, endTime);
                return memberList;
            }
        }
        return memberList;
    }

    public Integer count(Member memberParam) {
        Map<String, Object> params = prepareParams(memberParam);
        return memberRespository.count(params);
    }


    public Integer countTeacher(String roleId) {
        return memberRespository.countTeacher(roleId);
    }

    public Integer countTeacherBySchool(User user, String name) {
        Member member = memberRespository.selectByUserId(user.getRecId());
        if (member != null && !"".equals(member)) {
            if (member.getOrganization() != null && !"".equals(member.getOrganization())) {
                Member member1 = new Member();
                member1.setOrganization(member.getOrganization());
                if (name != null && !"".equals(name)) {
                    member1.setName(name);
                }
                Map<String, Object> params = prepareParams(member1);
                return memberRespository.countTeacherBySchool(params);
            }
        }
        return 0;

    }


    /**
     * 根据身份证查询学员信息
     *
     * @param idCard
     * @return
     */
    public Member getMemberByIdCard(String idCard) {
        if (StringUtils.trimToEmpty(idCard).equals("")) {
            return null;
        }
        if (CollectionUtils.isEmpty(memberRespository.selectByIdCard(idCard))) {
            return null;
        }
        return memberRespository.selectByIdCard(idCard).get(0);
    }


    /**
     * 根据用户登录名调用edu-welcome接口，查询出用户主键
     *
     * @param loginName
     * @return
     */
    public String getUserId(String loginName) {
        BizTrans<List<LinkedHashMap<String, Object>>> bizTrans = userService.getUserIdByLoginName(loginName);
        Object o = BizTransUtils.parseBizTrans(bizTrans);
        if (!(o instanceof String)) {
            return "";
        }
        if (o instanceof String && ((String) o).length() == 0) {
            return "";
        }
        return (String) o;

    }

    /**
     * 组织member信息
     *
     * @param param
     * @return
     */
    public Member buildMember(RegistParam param) {
        Member member = new Member();
        if (param.getIdCard() != null) {
            member.setIdCard(param.getIdCard());
        }
        member.setRole(MemberConstants.ROLE.STUDENT.num());
        if (param.getMobile() != null) {
            member.setMobile(param.getMobile());
        }
        if (param.getNickName() != null) {
            member.setName(param.getNickName());
        } else {
            member.setName(param.getUserName());
        }
        if (param.getOrganization() != null) {
            member.setOrganization(param.getOrganization());
        }
        member.setStatus(MemberConstants.STATUS.OK.num());
        return member;

    }


    public String importregist(RegistParam params) {
        User user = new User("", params.getUserName(), params.getPassword());
        Map<String, Object> param = new HashMap();
        param.put("regWay", MemberConstants.REGWAY.READING.value());
        user.setParams(param);
        String userid = gatwayService.create(user);
        logger.warn("--------------------userid+" + userid);
        return userid;
    }

    /**
     * 获取expert
     *
     * @param userId
     * @return
     */
    public Member getMember(String userId) {
        if (userId == null) {
            return null;
        }
        Member member = memberRespository.selectByUserId(userId);
        return member;
    }

    public String regist(Map<String, Object> params) {
        //登录账号：身份证后六位
        //密码：身份证后六位
        if (null != params && params.get("regRoletype") == null) {
            params.put("regRoletype", "teacher");
        } else {
            params.put("regRoletype", params.get("regRoletype"));
        }
        params.put("registFlag", params.get("registFlag"));
        BizTrans<List<LinkedHashMap<String, Object>>> bizTrans = userService.shiluregist1(StringUtils.trimToEmpty(params.get("loginName") + ""), StringUtils.trimToEmpty(params.get("loginPass") + ""), StringUtils.trimToEmpty(params.get("regRoletype") + ""), StringUtils.trimToEmpty(params.get("userName") + ""), StringUtils.trimToEmpty(params.get("loginAlais") + ""), StringUtils.trimToEmpty(params.get("regWay") + ""));
        ;
        logger.info("---------------------bizTrans" + bizTrans);
        Object o = BizTransUtils.parseBizTrans(bizTrans);
        if (!(o instanceof String)) {
            return "";
        }
        if (o instanceof String && ((String) o).length() == 0) {
            return "";
        }
        return (String) o;
    }


    //生成单个随机码和二维码
    public String createVipCode() {
        try {
            String now = String.valueOf(System.currentTimeMillis());
            String vipCode = ShareCodeUtil.toSerialCode(now);
            String vipCodeUrl = getQrCode(vipCode);
            redisTemplate.opsForValue().set(vipCode, "1");
            logger.info("--------------------------vipCode"+vipCode);
            logger.info("--------------------------vipCodeUrl"+vipCodeUrl);
            logger.info("--------------------------redisTemplatevipCode"+redisTemplate.opsForValue().get(vipCode));
            return vipCodeUrl;
//            return vipCode;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //    public static void main(String[] args) throws IOException {
//        try {
//            String now = String.valueOf(System.currentTimeMillis());
//            String vipCode = ShareCodeUtil.toSerialCode(now);
//            URL vipCodeUrlRead = new URL("http://img.jssns.cn/SHILU/1/40170672065159539.png");//url 为图片的URL
//            BufferedImage erBuffer = ImageIO.read(vipCodeUrlRead);
//            Path tempPng = Files.createFile(Paths.get("D:\\tupian\\" + vipCode + ".png"));
//            ImageIO.write(erBuffer, "png", tempPng.toFile());
//            System.out.println(tempPng.toAbsolutePath());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
    //批量生成随机码和二维码，将图片保存到本地文件夹中，并返回二维码地址
    public List<String> createVipCodeAll(String num) {
        List<String> vipCodeUrlList = new ArrayList<>();
        try {
            logger.info("--------------------------num"+num);
            if (num!=null&!"".equals(num)) {
                logger.info("--------------------------num"+num);
                for (int i = 1; i <=Integer.parseInt(num); i++) {
                    String now = String.valueOf(System.currentTimeMillis());
                    String vipCode = ShareCodeUtil.toSerialCode(now);
                    String vipCodeUrl = getQrCode(vipCode);
                    redisTemplate.opsForValue().set(vipCode, "1");
                    URL vipCodeUrlRead = new URL(vipCodeUrl);
                    BufferedImage erBuffer = ImageIO.read(vipCodeUrlRead);
                    Path tempPng = Files.createFile(Paths.get(vipCodeDownload + vipCode + ".png"));
                    ImageIO.write(erBuffer, "png", tempPng.toFile());
                    vipCodeUrlList.add(vipCodeUrl);
                    logger.info("--------------------------vipCode"+vipCode);
                    logger.info("--------------------------vipCodeUrl"+vipCodeUrl);
                    logger.info("--------------------------redisTemplatevipCode"+redisTemplate.opsForValue().get(vipCode));
                }
                return vipCodeUrlList;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String createOrderByVipCode(String vipCode, User user) {
        try {
            logger.info("----------------------------vipCode==="+vipCode);
            if (vipCode != null && !"".equals(vipCode)) {
                String vipCodeValue = redisTemplate.opsForValue().get(vipCode);
                if (vipCodeValue != null && "1".equals(vipCodeValue)) {
                    List<TradeOrder> tradeOrderList = tradeOrderService.findVipByBuyId(user.getRecId());
                    if (tradeOrderList != null && tradeOrderList.size() > 0) {
                        //获取时间加一年
                        String endTime = addYear(tradeOrderList.get(0).getEndTime());
                        vipTradeOrder(tradeOrderList.get(0).getEndTime(), endTime, user,vipCode);
                    } else {
                        String now = DateUtils.getNowStr(DateUtils.FORMAT_DATE_TIME);
                        String endTime = addYear(now);
                        vipTradeOrder(now, endTime, user,vipCode);
                    }
                    //查询当前用户角色，看是否有vip权限，若没有则新增
                    List<String> roleIds = userRoleService.listUserBizRoles(user.getRecId());
                    if (roleIds != null && roleIds.size() > 0) {
                        Map<String, String> map = new HashMap<String, String>();
                        for (String roleId : roleIds) {
                            map.put(roleId, roleId);
                        }
                        if (map.get("vip") == null || "".equals(map.get("vip"))) {
                            userRoleCreate(user);
                        }
                    }else {
                        userRoleCreate(user);
                    }
                    redisTemplate.delete(vipCode);
                    return "1";
                } else {
                    return "vip随机码已使用或不存在";
                }
            } else {
                return "vip随机码不存在";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "获取系统时间异常";
        }
    }

    //创建用户角色
    public void userRoleCreate(User user) {
        UserRole userRole = new UserRole();
        userRole.setUserId(user.getRecId());
        userRole.setRoleId("vip");
        userRole.setCreateId(user.getRecId());
        userRoleService.create(userRole);
    }


    //生成vip订单
    public void vipTradeOrder(String startTime, String endTime, User user,String vipCode) {
        TradeOrder tradeOrder = new TradeOrder();
        tradeOrder.setName("购买vip");
        tradeOrder.setBuyId(user.getRecId());
        tradeOrder.setStatus(TradeOrderConstants.STATUS.OK.num());
        tradeOrder.setCreateId(user.getRecId());
        tradeOrder.setStartTime(startTime);
        tradeOrder.setEndTime(endTime);
        String tradeOrderId = tradeOrderService.create(tradeOrder);
        //生成VIP订单详情
        TradeOrderDetail tradeOrderDetail = new TradeOrderDetail();
        tradeOrderDetail.setTrateOrderId(tradeOrderId);
        tradeOrderDetail.setCreateId(user.getRecId());
        tradeOrderDetail.setProdType("vip");
        tradeOrderDetail.setProdId(vipCode);
        tradeOrderDetail.setName("购买VIP");
    tradeOrderDetailService.create(tradeOrderDetail);
    }

    //增加时间一年
    public String addYear(String startTime) throws Exception {
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date createTime = sdf.parse(startTime); //String转Date
        Calendar cal = Calendar.getInstance();
        cal.setTime(createTime);//设置起时间
        cal.add(Calendar.YEAR, 1);//增加一年
        return sdf.format(cal.getTime());
    }


    public String getQrCode(String vipCode) {
        MiniQrcodeParam miniQrcodeParam = new MiniQrcodeParam();
        miniQrcodeParam.setPage("pages/member/vip");
        Map<String, String> params = new HashMap<>();
        params.put("vipCode", vipCode);
        Result result = shortLinkApiService.getCodeByUrl(gson.toJson(params));
        if (result != null && result.getCode() == 200) {
            String body = (String) result.getBody();
            String scene = org.apache.commons.lang3.StringUtils.substringAfterLast(body, "/");
            miniQrcodeParam.setScene(scene);
        } else {
            throw new RuntimeException(result.getMsg());
        }
        miniQrcodeParam.setWidth("110");
        try {
            String generate = miniQrcodeService.generate(miniQrcodeParam);
            return generate;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }


}