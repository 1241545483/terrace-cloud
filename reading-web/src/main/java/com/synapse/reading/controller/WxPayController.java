package com.synapse.reading.controller;

import com.synapse.common.exception.BusinessException;
import com.synapse.common.sso.context.UserContext;
import com.synapse.common.sso.model.User;
import com.synapse.common.trans.BizTrans;
import com.synapse.common.trans.Result;
import com.synapse.common.utils.DateUtils;
import com.synapse.pay.dto.PayItemInfo;
import com.synapse.pay.dto.PayTransInfo;
import com.synapse.reading.constants.CommonConstants;
import com.synapse.reading.dto.param.AudioParam;
import com.synapse.reading.exception.common.ValidException;
import com.synapse.reading.model.Audio;
import com.synapse.reading.model.Pay;
import com.synapse.reading.remote.PayService;
import com.synapse.reading.service.WxPayService;
import com.synapse.reading.web.valid.group.Update;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.Map;
import java.util.Random;


@Api(tags = "WxPayController")
@RestController
@RequestMapping("/reading")
public class WxPayController {

    private Logger logger = LoggerFactory.getLogger(WxPayController.class);
    @Autowired
    private PayService payService;
    @Autowired
    private WxPayService wxPayService;
    @Value("${mini.app.appid}")
    private String appId;

    @ApiOperation(value = "调用统一下单接口")
    @ApiResponses({
            @ApiResponse(code = 200, response = Integer.class, message = "支付参数"),
            @ApiResponse(code = 1002, response = String.class, message = "字段校验错误"),
            @ApiResponse(code = 500, response = String.class, message = "服务器错误")
    })
    @RequestMapping(value = "/v1/pay", method = RequestMethod.GET)
    public ResponseEntity pay(@RequestBody Pay pay) {
        try {
            User user = UserContext.getUser();
            String ids = wxPayService.getRandomOrderId();
            Date now = new Date();
            pay.getPayInfo().setDesc("交易订单内容描述");
            pay.getPayInfo().setAttach("请转给小刘同学：13814516352");
            pay.getPayInfo().setOrderNo(ids);
            pay.getPayInfo().setTotalFee("1");
            pay.getPayInfo().setRemoteIP("123.12.12.123");
            pay.getPayInfo().setChannelId(1L);
            pay.getPayInfo().setService("W1");
            pay.getPayInfo().setSubAppid(appId);
            pay.getPayInfo().setSubOpenid(user.getRegWay());
            pay.getPayInfo().setPartnerId(111L);
//            payInfo.setSecurityKey("");
            pay.getPayInfo().setTradeName("交易订单名称");
            pay.getPayInfo().setPartnerSign("商户验签");
            pay.getPayInfo().setTradeType("交易方式");
            pay.getPayInfo().setPayType("2");
            pay.getPayInfo().setPayerAccId(8888l);
//            payInfo.setShowUrl("服务URL");
            pay.getPayInfo().setDeviceType("JSAPI");
            pay.getPayInfo().setActiveIndate(now);
            return ResponseEntity.ok(payService.prePay(pay.getPayInfo()));
        } catch (Exception e) {
            logger.error("prePay pay error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR)
                    .body(Result.error(CommonConstants.SERVER_ERROR, e.getMessage()));
        }
    }

}
