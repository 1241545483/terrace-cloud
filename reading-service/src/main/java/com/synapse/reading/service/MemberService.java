package com.synapse.reading.service;

import com.synapse.common.constants.PageInfo;
import com.synapse.common.sso.model.User;
import com.synapse.common.trans.BizTrans;
import com.synapse.common.trans.BizTransUtils;
import com.synapse.reading.constants.MemberConstants;
import com.synapse.reading.dto.param.RegistParam;
import com.synapse.reading.model.*;
import com.synapse.reading.remote.GatwayService;
import com.synapse.reading.remote.UserService;
import com.synapse.reading.respository.MemberRespository;
import com.synapse.reading.dto.param.MemberParam;
import com.synapse.common.utils.DateUtils;
import net.logstash.logback.encoder.org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.synapse.reading.remote.IdService;
import org.springframework.util.CollectionUtils;

import java.util.*;


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

    @Autowired
    private IdService idService;

    @Autowired
    private MemberRespository memberRespository;

    @Autowired
    private MySigninService mySigninService;

    @Autowired
    private UserService userService;
    @Autowired
    private  GatwayService gatwayService;

    @Autowired
    private BaseSystemParameterService baseSystemParameterService;

    @Autowired
    private TradeOrderService tradeOrderService;

    @Autowired
    private TradeOrderDetailService tradeOrderDetailService;


    public Member find(String recId) {
        if (recId == null) {
            return null;
        }
        return memberRespository.selectByPrimaryKey(recId);
    }

    public Member selectByUserId(String recId) {
        if (recId == null) {
            return null;
        }
        return memberRespository.selectByUserId(recId);
    }

    public Integer update(Member param) {
        String now = DateUtils.getNowStr(DateUtils.FORMAT_DATE_TIME);
        param.setUpdateTime(now);
        return memberRespository.updateByPrimaryKeySelective(param);
    }

    public List<Member> listMember(String issueItemId) {
        return memberRespository.listMember(issueItemId);
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

    public List<Member> listTeacher(String roleId, PageInfo pageInfo) {
        Map<String, Object> params = new HashMap<>();
        params.put("roleId", roleId);
        params.put("startIndex", pageInfo.getCurrentStartIndex());
        params.put("pageSize", pageInfo.getPerPageNum());
        return memberRespository.listTeacher(params);
    }


    public Integer count(Member memberParam) {
        Map<String, Object> params = prepareParams(memberParam);
        return memberRespository.count(params);
    }

    public Integer countTeacher(String roleId) {
        return memberRespository.countTeacher(roleId);
    }


//    public void doExcelImport(List<Member> successImport, User currentUser, String organization, Map<String, List<ExcelRowModel>> result, String role) {
//        List<ExcelRowModel> excelRowModels = result.get("excel_members");
//        for (ExcelRowModel excelRowModel : excelRowModels) {
//            Map<String, Object> registParams = new HashMap<String, Object>();
//            registParams.put("userName", excelRowModel.getUserName());
//            registParams.put("subject", excelRowModel.getSubject());
////            registParams.put("organization", organization);
//            registParams.put("mobilePhone", excelRowModel.getPhone());
//            registParams.put("loginAlais", excelRowModel.getPhone());
//            registParams.put("idCard", excelRowModel.getIdCard());
//            registParams.put("orgId", organization);
//            registParams.put("registFlag", 1);
//            registParams.put("regRoletype", excelRowModel.getRegRoletype());
//            registParams.put("bizroleId", role);
//            String userId = null;
//            //登录账号为：身份证后六位
//            String idCard = (String) registParams.get("idCard");
////				String loginName = idCard.substring(idCard.length() - 6, idCard.length());
//            //登录帐号为身份证号
//            String loginName = idCard.toUpperCase();
//            String loginName_mobilePhone = excelRowModel.getPhone();
//
//            Member memberByIdCard = getMemberByIdCard(idCard);
//            if (memberByIdCard != null) {
//                userId = memberByIdCard.getUserId() + "";
//                logger.info("member {} is not exist!", idCard);
//            } else {
//                if (!userService.userNameIsExist(loginName) && !userService.userNameIsExist(loginName_mobilePhone)) {
//                    userId = importregist(registParams);
//                    logger.info("member {} is not exist remote!", idCard);
//                } else {
//                    //存在这个用户，查询用户主键ID
//                    userId = getUserId(loginName);
//                    if (StringUtils.trim(userId).equals("")) {
//                        userId = getUserId(loginName_mobilePhone);
//                    }
//                    //TODO 判断用户角色和是否是培训班的创建者？先放开
//                }
//                logger.info("member {} userId is {}!", idCard, userId);
//            }
//
//            Member member = new Member();
//            member.setUserId(userId);
//            member.setIdCard(excelRowModel.getIdCard());
//            //在职状态、教师性质查询对应key 在字段表里
////            String office_status_type = "OFFICE_STATUS";
////            String officeStatus = baseSystemParameterService.getKeyByTypeAndValue(office_status_type, StringUtils.trimToEmpty(excelRowModel.getOfficeStatus()));
////            member.setOfficeStatus(officeStatus);
////            String teacher_nature_type = "TEACHER_NATURE";
////            String nature = baseSystemParameterService.getKeyByTypeAndValue(teacher_nature_type, StringUtils.trimToEmpty(excelRowModel.getTeacherNature()));
////            member.setNature(nature);
//            String subject_type = "SUBJECT";
//            String subject = baseSystemParameterService.getKeyByTypeAndValue(subject_type, StringUtils.trimToEmpty(excelRowModel.getSubject()));
//            member.setSubject(subject);
//            String phase_type = "PHASE";
//            String phase = baseSystemParameterService.getKeyByTypeAndValue(phase_type, StringUtils.trimToEmpty(excelRowModel.getPhase()));
//            member.setPhase(phase);
////            member.setMemberType(MemberConstants.TYPE.TEACHER.vlaue()); //学员类型 1-专家，2-老师
//            member.setName(excelRowModel.getUserName());
//            member.setOrganization(organization);
//            member.setMobile(excelRowModel.getPhone());
//            String nowStr = DateUtils.getNowStr("yyyy-MM-dd HH:mm:ss");
//            member.setCreateId(userId);
//            member.setRole(role);
//            member.setCreateTime(nowStr);
//            member.setUpdateTime(nowStr);
//            member.setStatus(MemberConstants.STATUS.OK.num());
//            logger.info("userId is 6666666666666666666666666666666" + userId);
//            Member isExist = memberRespository.selectByUserId(userId);
//            if (isExist != null) {
//                logger.info("member {} userId is {} exists!", idCard, userId);
//                update(member);
//            } else {
//                logger.info("member {} userId is {} not exists!", idCard, userId);
//                create(member);
//            }
//            successImport.add(member);
////            String now = DateUtils.getNowStr(DateUtils.FORMAT_DATE_TIME);
////            TradeOrder tradeOrder = tradeOrderService.findByBuyId(currentUser.getRecId());
////            tradeOrder.setRecId(idService.gen("ID"));
////            tradeOrder.setBuyId(userId);
////            tradeOrder.setCreateTime(now);
////            tradeOrder.setCreateId(currentUser.getRecId());
////            tradeOrderService.create(tradeOrder);
////            TradeOrderDetail tradeOrderDetail =tradeOrderDetailService.findByTradeOrder(tradeOrder.getRecId());
////            tradeOrderDetail.setRecId(idService.gen("ID"));
////            tradeOrderDetail.setTrateOrderId(tradeOrder.getRecId());
////            tradeOrderDetail.setCreateTime(now);
////            tradeOrderDetail.setCreateId(currentUser.getRecId());
////            tradeOrderDetailService.create(tradeOrderDetail);
//
//        }
//    }

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

//    public Member addMember(User user, String type, MemberParam param, String roletype) {
//
//        type = StringUtils.trimToEmpty(type);
//        String organization = param.getOrganization();
//        Member member = param.getModel();
//        member.setStatus("1");
//        member.setOrganization(organization);
//        String memberId = null;
//        String idCard = StringUtils.trimToEmpty(member.getIdCard());
//        String idCard_6 = idCard.toUpperCase();
//        Map<String, Object> registParams = new HashMap<String, Object>();
//
//
//        private String password;
//        private String passwordAgain;
//        private String nickName;
//
//        registParams.put("userName", member.getName());
//        registParams.put("organization", organization);
//        registParams.put("mobile", StringUtils.trimToEmpty(member.getMobile()));
//        registParams.put("idCard", StringUtils.trimToEmpty(member.getIdCard()));
//        registParams.put("orgId", param.getOrganization());
//        registParams.put("regRoletype", roletype);
//        String mobile = org.apache.commons.lang.StringUtils.trimToEmpty(member.getMobile());
//        String lName = "";
//        //如果手机号和电话都为空则直接新增用户名, 用名称去判断 且是专家
//        String name = StringUtils.trimToEmpty(param.getName());
//        User userInfo= new User();
//        userInfo.setUsername(param.getName());
//        userInfo.setPassword();
//
//
//        importregist(registParams);
//        if (idCard.length() == 0 && mobile.length() == 0 && type.length() > 0 && name.length() > 0 && !userService.userNameIsExist(name)) {
//            System.err.println("jinru 1111111111");
//            lName = name;
//            //查询name为用户名的客户是否存在
//            registParams.put("userName", name);
//            registParams.put("loginName", name);
//            //专家默认的密码为123456
//            registParams.put("loginPass", "123456");
//            //密码设置为123456
//            memberId = importregist(registParams);
//            member.setUserId(memberId);
//        } else if (idCard.length() == 0 && mobile.length() != 0 && type.length() > 0 && !userService.userNameIsExist(mobile)) {
//            lName = mobile;
//            registParams.put("userName", name);
//            registParams.put("loginName", mobile);
//            //专家默认的密码为123456
//            registParams.put("loginPass", "123456");
//            memberId = importregist(registParams);
//            member.setUserId(memberId);
//        } else if (idCard.length() != 0 && mobile.length() == 0 && type.length() > 0 && !userService.userNameIsExist(idCard)) {
//            lName = idCard_6;
//            registParams.put("userName", name);
//            registParams.put("loginName", idCard_6);
//            //专家默认的密码为123456
//            registParams.put("loginPass", "123456");
//            memberId = importregist(registParams);
//            member.setUserId(memberId);
//        } else if (!userService.userNameIsExist(idCard_6) && !userService.userNameIsExist(member.getMobile())) {
//            lName = idCard_6;
//            memberId = importregist(registParams);
//            member.setUserId(memberId);
//        } else {//存在这个用户，查询用户主键ID
//            lName = idCard_6;
//            memberId = getUserId(lName);
//            if (StringUtils.trim(memberId).equals("")) {
//                memberId = getUserId(member.getMobile());
//            }
//            member = getMember(memberId);
//            if (member == null) {
//                member.setUserId(memberId);
//                try {
//                    create(member);
//                } catch (Exception e) {
//                    throw new RuntimeException("新增失败");
//                }
//            }
////            throw new RuntimeException("已存在");
//        }
//        return member;
//    }

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

}