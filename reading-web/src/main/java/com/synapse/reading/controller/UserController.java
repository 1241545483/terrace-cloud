package com.synapse.reading.controller;

import com.synapse.common.exception.BusinessException;
import com.synapse.common.sso.context.UserContext;
import com.synapse.common.sso.model.User;
import com.synapse.common.trans.Result;
import com.synapse.reading.constants.CommonConstants;
import com.synapse.reading.exception.common.NotLoginException;
import com.synapse.reading.model.Member;
import com.synapse.reading.service.MemberService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户相关接口
 */
@Api(tags = "UserController")
@RestController("userControllerV1")
@RequestMapping("/reading")
public class UserController {

    private static Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private MemberService memberService;

    @ApiOperation("返回当前登录用户信息")
    @ApiResponses({
            @ApiResponse(code = 200, response = com.synapse.common.sso.model.User.class, message = "当前登录用户信息"),
            @ApiResponse(code = 1001, response = String.class, message = "用户未登录"),
            @ApiResponse(code = 500, response = String.class, message = "服务器错误")
    })
    @GetMapping("/v1/currentUser")
    public Result currentUser() {
        try {
            User user = UserContext.getUser();
            Member member =memberService.getMember(user.getRecId());
            user.setUsername(member.getName());
//            user.setUserImg();
            if (user == null) {
                throw new NotLoginException();
            }
            return Result.ok(user);
        } catch (BusinessException e) {
            logger.error("Get CurrentUser Error!", e);
            return Result.error(e);
        } catch (Exception e) {
            logger.error("Get CurrentUser Error!", e);
            return Result.error(CommonConstants.SERVER_ERROR, e.getMessage());
        }
    }


}
