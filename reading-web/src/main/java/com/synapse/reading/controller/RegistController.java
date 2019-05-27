package com.synapse.reading.controller;

import com.synapse.common.trans.Result;
import com.synapse.reading.constants.CommonConstants;
import com.synapse.reading.dto.param.RegistParam;
import com.synapse.reading.model.Member;
import com.synapse.reading.remote.UserService;
import com.synapse.reading.service.MemberService;
import com.synapse.reading.web.valid.group.Create;
import io.swagger.annotations.ApiOperation;
import net.logstash.logback.encoder.org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/regist")
public class RegistController extends BaseController {

    private static Logger logger = LoggerFactory.getLogger(RegistController.class);
    @Autowired
    private UserService userService;
    @Autowired
    private MemberService memberService;

    @ApiOperation(value = "用户注册")
    @RequestMapping(value = "/v2/membershow/regist", method = RequestMethod.POST)
    public Result regist(@RequestBody @Validated(Create.class) RegistParam param) {
        try {
            //判断密码是否正确
            if (param.getPassword() == null || !param.getPassword().equals(param.getPasswordAgain())) {
                return Result.error(CommonConstants.SERVER_ERROR, "两次密码输入不正确。");
            }
            //注册时如果机构为空，则默认为-1
            if (com.synapse.common.utils.StringUtils.trimToEmpty(param.getOrganization()).equals("")) {
                param.setOrganization("-1");
            }
            //注册时如果用户名为空，则默认为手机号
            if (com.synapse.common.utils.StringUtils.trimToEmpty(param.getUserName()).equals("")) {
                param.setUserName(StringUtils.trimToEmpty(param.getMobile()));
            }
            Map<String, Object> registParams = new HashMap<String, Object>();
            registParams.put("userName", param.getUserName());
            registParams.put("organization", param.getOrganization());
            registParams.put("mobilePhone", StringUtils.trimToEmpty(param.getMobile()));
            registParams.put("idCard", StringUtils.trimToEmpty(param.getIdCard()));
            registParams.put("orgId", param.getOrganization());
            registParams.put("password", param.getPassword());
            registParams.put("loginPass", param.getPassword());// importregist获取的是loginPass,如果不存在则使用手机或身份证后六位
            System.out.println("password is " + param.getPassword());
            registParams.put("registFlag", 1);
            registParams.put("loginAlais", param.getMobile());
            //判断是否存在
            if (!StringUtils.isEmpty(param.getIdCard()) && userService.userNameIsExist(param.getIdCard())) {
                return Result.error(CommonConstants.SERVER_ERROR, "身份证已经存在。");
            }
            if (userService.userNameIsExist(param.getMobile())) {
                return Result.error(CommonConstants.SERVER_ERROR, "手机号已经存在。");
            }
            String memberId = memberService.importregist(registParams);
            if (memberId == null || StringUtils.trimToEmpty(memberId).length() == 0) {
                return Result.error(CommonConstants.SERVER_ERROR, "注册失败。");
            }
            Member member = memberService.buildMember(param);
            member.setUserId(memberId);
            memberService.create(member);
            return Result.ok("1");
        } catch (Exception e) {
            logger.error("regist error!", e);
            return Result.error(500, e.getMessage());
        }
    }


}
