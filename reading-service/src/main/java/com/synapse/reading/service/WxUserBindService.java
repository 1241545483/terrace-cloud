package com.synapse.reading.service;

import com.synapse.common.codec.EncryptTool;
import com.synapse.common.formatter.Encoder;
import com.synapse.common.sso.model.User;
import com.synapse.common.utils.DateUtils;
import com.synapse.reading.constants.MemberConstants;
import com.synapse.reading.model.BindUserModel;
import com.synapse.reading.model.Member;
import com.synapse.reading.model.model.Bind;
import com.synapse.reading.remote.GatwayService;
import com.synapse.reading.remote.UserService;
import com.synapse.reading.respository.MemberRespository;
import com.synapse.reading.respository.respository.BindRespository;
import com.synapse.user.model.UserInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * <p>
 * 支付 服务实现类
 * </p>
 *
 * @author liuguangfu
 * @since 2019-04-10
 */
@Service
@Transactional
public class WxUserBindService {

    private Logger logger = LoggerFactory.getLogger(WxUserBindService.class);

    @Autowired
    private UserService userService;
    @Autowired
    private MemberService memberService;
    @Autowired
    private BindRespository bindRespository;
    @Autowired
    private Encoder encoder;
    @Autowired
    private MemberRespository memberRespository;
    @Autowired
    private GatwayService gatwayService;
    @Value("${encrypt.salt}")
    private String salt;

    public Map<String, String> handleApply(BindUserModel param, String currentUserId) {
        try {
            Map<String, String> resultMap = new HashMap<>();

            String UserId = memberService.selectByPhone(param.getPhone());
            logger.warn("findByUserName--------------------currentUserId=" + currentUserId);
            logger.warn("findByUserName--------------------UserId=" + UserId);
            if (UserId != null) {
//                String findUserId = findUser.get("userId");
                //该手机号已提交信息没有密码；返回要求用户填写密码;
                if (!UserId.equals(currentUserId)) {
                    //有密码；去校验密码
//                    Map<String, String> bindParam = new HashMap<>();
//                    bindParam.put("userId", encoder.encryptStr(currentUserId));
//                    bindParam.put("existUserId", encoder.encryptStr(findUserId));
                    resultMap.put("flag", "7");
                    resultMap.put("userId", encoder.encryptStr(currentUserId));
                    resultMap.put("existUserId", encoder.encryptStr(UserId));
                    Member member = memberService.getMember(currentUserId);
                    //todo 待修改成调用reading接口
                    if (member == null) {
                        member = new Member();
                        String now = DateUtils.getNowStr(DateUtils.FORMAT_DATE_TIME);
                        member.setUserId(currentUserId);
                        member.setCreateId(currentUserId);
                        member.setCreateTime(now);
                        member.setStatus(MemberConstants.STATUS.OK.num());
                        memberRespository.insert(member);
                    }

//                    updateUser(param, currentUserId);
                    return resultMap;
                }
                //是同一个用户走正常逻辑.
                resultMap.put("flag", "8");
                updateUser(param, currentUserId);
                return resultMap;
            } else {
                //该手机没有注册系统，走正常逻辑；
                resultMap.put("flag", "8");
//                updateUser(param, currentUserId);
                return resultMap;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    public Integer updateUser(BindUserModel param, String currentUserId) {
        Member member = memberService.getMember(currentUserId);
        if (member != null) {
            if (param.getName() != null) {
                member.setName(param.getName());
            }
            if (param.getPhase() != null) {
                member.setPhase(param.getPhase());
            }
            if (param.getSubject() != null) {
                member.setSubject(param.getSubject());
            }
            if (param.getPhone() != null) {
                member.setMobile(param.getPhone());
            }
            return memberService.update(member);
        } else {
            member = new Member();
            String now = DateUtils.getNowStr(DateUtils.FORMAT_DATE_TIME);
            member.setUserId(currentUserId);
            member.setMobile(param.getPhone());
            member.setOrganization(param.getOrganization());
            member.setName(param.getName());
            member.setPhase(param.getPhase());
            member.setSubject(param.getSubject());
            member.setCreateId(currentUserId);
            member.setCreateTime(now);
            member.setStatus(MemberConstants.STATUS.OK.num());
            memberRespository.insert(member);
            return 1;
        }
    }


    public int miniBind(Map<String, String> param) {
        String userId = param.get("userId");
        String existUserId = param.get("existUserId");
        String decrypt = EncryptTool.decrypt(userId, salt);
        String decryptExistUserId = EncryptTool.decrypt(existUserId, salt);
        logger.info(">>>>>>>=----------------decryptExistUserId" + decryptExistUserId);
        String passWord = gatwayService.findByUserId(decryptExistUserId);
        logger.info(">>>>>>>=----------------passWord" + passWord);
        BCryptPasswordEncoder encode = new BCryptPasswordEncoder();
        if (null == passWord) {
            return 3;
        }
        if (!encode.matches(param.get("password"), passWord)) {
            return 2;
        }
        List<Bind> eduConnectionList = bindRespository.selectByUserIdAndOpenId(param.get("openId"), decrypt);
        logger.info(">>>>>>>----------------eduConnectionList" + eduConnectionList.get(0).getOpenId());
        Bind connection = eduConnectionList.get(0);
        connection.setUserId(decryptExistUserId);
        return bindRespository.updateByPrimaryKeySelective(connection);
    }


}
