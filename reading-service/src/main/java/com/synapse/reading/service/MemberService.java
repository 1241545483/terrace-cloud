package com.synapse.reading.service;

import com.synapse.common.constants.PageInfo;
import com.synapse.common.sso.model.User;
import com.synapse.common.trans.BizTrans;
import com.synapse.common.trans.BizTransUtils;
import com.synapse.reading.constants.MemberConstants;
import com.synapse.reading.dto.param.RegistParam;
import com.synapse.reading.dto.result.MemberResult;
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
    private GatwayService gatwayService;

    @Autowired
    private BaseSystemParameterService baseSystemParameterService;

    @Autowired
    private TradeOrderService tradeOrderService;

    @Autowired
    private TradeOrderDetailService tradeOrderDetailService;
    @Autowired
    private OrgCodeService orgCodeService;

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
        if(model != null &&! "".equals(model)){
            Member member1 = memberRespository.selectByUserId(model.getCreateId());
            Member member2 = memberRespository.selectByUserId(user.getRecId());
            if (member2 != null &&! "".equals(member2)) {
                member2.setOrganization(member1.getOrganization());
                update(member2);
            }else {
                member2.setUserId(user.getRecId());
                member2.setOrganization(member1.getOrganization());
                create(member2);
            }
            return  member2.getUserId();
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

    public List<MemberResult> listByShchool(Member memberParam, PageInfo pageInfo) {
        Map<String, Object> params = prepareParams(memberParam);
        params.put("startIndex", pageInfo.getCurrentStartIndex());
        params.put("pageSize", pageInfo.getPerPageNum());
        return memberRespository.listByShchool(params);
    }

    public List<Member> listTeacher(String roleId, PageInfo pageInfo) {
        Map<String, Object> params = new HashMap<>();
        params.put("roleId", roleId);
        params.put("startIndex", pageInfo.getCurrentStartIndex());
        params.put("pageSize", pageInfo.getPerPageNum());
        return memberRespository.listTeacher(params);
    }

    public List<MemberResult> listTeacherBySchool(User user, PageInfo pageInfo,String name) {
        Member member = memberRespository.selectByUserId(user.getRecId());
        logger.info("----------------------user.getRecId()="+user.getRecId());
        logger.info("----------------------member.getRecId()="+member.getUserId());
        List<MemberResult> memberList = new ArrayList<>();
        if (member != null && !"".equals(member)) {
            if (member.getOrganization() != null && "".equals(member.getOrganization())) {
                Member member1 = new Member();
                member1.setOrganization(member.getOrganization());
                logger.info("----------------------0rg="+member1.getOrganization());
                if(name!=null&&!"".equals(name)){
                    member1.setName(name);
                }
                memberList = listByShchool(member1, pageInfo);
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

    public Integer countTeacherBySchool(User user,String name) {
        Member member = memberRespository.selectByUserId(user.getRecId());
        if (member != null && !"".equals(member)) {
            if (member.getOrganization() != null && "".equals(member.getOrganization())) {
                Member member1 = new Member();
                member1.setOrganization(member.getOrganization());
                if(name!=null&&!"".equals(name)){
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

}