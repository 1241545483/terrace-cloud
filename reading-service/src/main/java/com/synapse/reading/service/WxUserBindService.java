package com.synapse.reading.service;

import com.synapse.common.formatter.Encoder;
import com.synapse.common.trans.Result;
import com.synapse.common.utils.DateUtils;
import com.synapse.common.utils.JsonUtils;
import com.synapse.reading.constants.TradeOrderConstants;
import com.synapse.reading.dto.param.TradeOrderDetailParam;
import com.synapse.reading.dto.param.TradeOrderParam;
import com.synapse.reading.model.BindUserModel;
import com.synapse.reading.model.Member;
import com.synapse.reading.model.TradeOrder;
import com.synapse.reading.remote.BindService;
import com.synapse.reading.remote.IdService;
import com.synapse.reading.remote.UserService;
import com.synapse.reading.respository.TradeOrderDetailRespository;
import com.synapse.reading.respository.TradeOrderRespository;
import com.synapse.reading.util.AESDecodeUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;


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
    private BindService bindService;
    @Autowired
    private Encoder encoder;

    public Map<String, String> handleApply(BindUserModel param, String currentUserId) {
        try {
            Map<String, String> resultMap = new HashMap<>();
            Map<String, String> findUser = userService.selectByUserNameOrAlais(param.getPhone());
            if (findUser != null) {
                String findUserId = findUser.get("userId");
                //该手机号已提交信息没有密码；返回要求用户填写密码;
                if (!findUserId.equals(currentUserId)) {
                    //有密码；去校验密码
//                    Map<String, String> bindParam = new HashMap<>();
//                    bindParam.put("userId", encoder.encryptStr(currentUserId));
//                    bindParam.put("existUserId", encoder.encryptStr(findUserId));
                    resultMap.put("flag", "7");
                    resultMap.put("userId", encoder.encryptStr(currentUserId));
                    resultMap.put("existUserId", encoder.encryptStr(findUserId));
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
                updateUser(param, currentUserId);
                return resultMap;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    public Integer updateUser(BindUserModel param, String currentUserId) {
        logger.warn("=----------------==---=-=2222" + currentUserId);
        Member member = memberService.getMember(currentUserId);
        logger.warn("=----------------==---=-=2222" + member.getUserId());
        logger.warn("=----------------==---=-=1111" + param.getName());
        if (member != null) {
            if (param.getName() != null) {
                member.setName(param.getName());
            }
            if (param.getPhase() != null) {
                member.setIdCard(param.getPhase());
            }
            if (param.getPhase() != null) {
                member.setSubject(param.getPhase());
            }
            if (param.getPhase() != null) {
                member.setPhase(param.getPhase());
            }
            return memberService.update(member);
        } else {
            return 0;
        }
    }


}
