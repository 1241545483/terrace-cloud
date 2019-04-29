package com.synapse.reading.controller;

import com.synapse.common.exception.BusinessException;
import com.synapse.common.sso.context.UserContext;
import com.synapse.common.sso.model.User;
import com.synapse.common.trans.BizTrans;
import com.synapse.common.trans.Result;
import com.synapse.pay.dto.PayItemInfo;
import com.synapse.reading.constants.CommonConstants;
import com.synapse.reading.model.BindUserModel;
import com.synapse.reading.model.Pay;
import com.synapse.reading.remote.PayService;
import com.synapse.reading.remote.UserService;
import com.synapse.reading.service.WxPayService;
import com.synapse.reading.service.WxUserBindService;
import com.synapse.user.model.api.UserPwdUpdateModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


@Api(tags = "WxUserBindController")
@RestController
@RequestMapping("/reading")
public class WxUserBindController {

    private Logger logger = LoggerFactory.getLogger(WxUserBindController.class);
    @Autowired
    private WxUserBindService wxUserBindService;
    @Autowired
    private  UserService userService;

    @ApiOperation(value = "修改个人信息，如果已绑定则直接修改，如果没有就提醒用户进行修改")
    @ApiResponses({
            @ApiResponse(code = 200, response = Integer.class, message = "绑定用户信息"),
            @ApiResponse(code = 1002, response = String.class, message = "字段校验错误"),
            @ApiResponse(code = 500, response = String.class, message = "服务器错误")
    })
    @RequestMapping(value = "/v1/bind", method = RequestMethod.POST)
    public ResponseEntity bind(@RequestBody BindUserModel param) {

        try {
            User user = UserContext.getUser();
            Map<String, String> handleApplyResult =  wxUserBindService.handleApply(param ,user.getRecId());
            if (handleApplyResult == null) {
                //绑定出错
                return ResponseEntity.status(CommonConstants.SERVER_ERROR)
                        .body(Result.error(CommonConstants.SERVER_ERROR,"绑定出错"));
            } else if (handleApplyResult.get("flag").equals("7")) {
                //请输入密码
                return ResponseEntity.status(CommonConstants.BIND_NOPASSWORD)
                        .body(handleApplyResult);
//            } else if (handleApplyResult.get("flag").equals("7")) {
//                //密码错误
//                return ResponseEntity.ok(handleApplyResult);
//                return ResponseEntity.status(CommonConstants.SERVER_ERROR)
//                        .body(Result.error(CommonConstants.SERVER_ERROR,"密码错误"));
            } else if (handleApplyResult.get("flag").equals("8")) {
                //同一用户，修改信息成功
                return ResponseEntity.status(CommonConstants.BIND_SUCCESS)
                        .body(Result.error(CommonConstants.BIND_SUCCESS,"更新信息成功"));
//            } else if (handleApplyResult.get("flag").equals("6")) {
//                //密码成功
//                return ResponseEntity.status(CommonConstants.BIND_SUCCESS)
//                        .body(Result.error(CommonConstants.BIND_SUCCESS,"绑定成功"));
            }else {
                return ResponseEntity.status(CommonConstants.SERVER_ERROR)
                        .body(Result.error(CommonConstants.SERVER_ERROR,"绑定出错"));
            }
//            return ResponseEntity.ok("");
        } catch (BusinessException e) {
            logger.error("create Info Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR).body(Result.error(e));
        } catch (Exception e) {
                logger.error("create Info Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR)
                    .body(Result.error(CommonConstants.SERVER_ERROR, e.getMessage()));
        }
    }



    @ApiOperation(value = "修改个人信息(账号，密码)")
    @ApiResponses({
            @ApiResponse(code = 200, response = Integer.class, message = "修改用户信息"),
            @ApiResponse(code = 1002, response = String.class, message = "字段校验错误"),
            @ApiResponse(code = 500, response = String.class, message = "服务器错误")
    })
    @RequestMapping(value = "/v1/user/info", method = RequestMethod.PUT)
    public ResponseEntity updatePsw(@RequestBody UserPwdUpdateModel param) {

        try {
            BizTrans bizTrans=  userService.updateUserPassword(param);
           return ResponseEntity.ok(bizTrans.getBizInfo());
        } catch (BusinessException e) {
            logger.error("update Info Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR).body(Result.error(e));
        } catch (Exception e) {
            logger.error("update Info Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR)
                    .body(Result.error(CommonConstants.SERVER_ERROR, e.getMessage()));
        }
    }



}
