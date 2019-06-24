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
import com.synapse.reading.dto.param.TradeOrderDetailParam;
import com.synapse.reading.exception.common.ValidException;
import com.synapse.reading.model.Audio;
import com.synapse.reading.model.Lesson;
import com.synapse.reading.model.Pay;
import com.synapse.reading.model.TradeOrderDetail;
import com.synapse.reading.model.model.Bind;
import com.synapse.reading.remote.PayService;
import com.synapse.reading.service.LessonService;
import com.synapse.reading.service.WxPayService;
import com.synapse.reading.service.service.BindService;
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
import org.springframework.util.MultiValueMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.xml.crypto.Data;
import java.util.*;


@Api(tags = "WxPayController")
@RestController
@RequestMapping("/reading")
public class WxPayController {

    private Logger logger = LoggerFactory.getLogger(WxPayController.class);
    @Autowired
    private PayService payService;
    @Autowired
    private WxPayService wxPayService;
    @Autowired
    private BindService bindService;
    @Autowired
    private LessonService lessonService;

    @Value("${mini.app.appid}")
    private String appId;
    @Value("${mini.app.secret}")
    private String secret;

    @ApiOperation(value = "调用统一下单接口")
    @ApiResponses({
            @ApiResponse(code = 200, response = Integer.class, message = "支付参数"),
            @ApiResponse(code = 1002, response = String.class, message = "字段校验错误"),
            @ApiResponse(code = 500, response = String.class, message = "服务器错误")
    })
    @RequestMapping(value = "/v1/pay", method = RequestMethod.POST)
    public ResponseEntity pay(@RequestBody Pay pay) {
        try {
            //todo 20190621 根据ItemType 查询出订单总价，合适前台订单
            Integer totalFee = 0;
            List<TradeOrderDetailParam> tradeOrderDetailParamList = pay.getTradeOrderParam().getTradeOrderDetailParamArrayList();
            if (tradeOrderDetailParamList.size() >= 0) {
                for (TradeOrderDetailParam tradeOrderDetailParam : tradeOrderDetailParamList) {
                    if (tradeOrderDetailParam.getProdType().equals("lesson")) {
                        Lesson lesson = lessonService.find(tradeOrderDetailParam.getProdId());
                        totalFee += Integer.parseInt(lesson.getPresentPrice());
                    }
                    if (tradeOrderDetailParam.getProdType().equals("book")) {
                    //TODO   书籍暂时没有支付，待完成  20190624
                    }
                }
            }
            User user = UserContext.getUser();
            Date now = new Date();
            pay.getTradeOrderParam().setCreateId(user.getRecId());
            pay.getTradeOrderParam().setBuyId(user.getRecId());
            pay.getTradeOrderParam().setPayWay("weixin");
            pay.getTradeOrderParam().setPrice("1");
            String ids = wxPayService.create(pay.getTradeOrderParam());
            pay.getPayInfo().setOrderNo(ids);
            //订单总金额
            Bind bind = bindService.isUser(user.getRecId());
            logger.warn("------------openId=" + bind.getOpenId());
            pay.getPayInfo().setOpenId(bind.getOpenId());
            pay.getPayInfo().setTotalFee(totalFee.toString());
            pay.getPayInfo().setChannelId(1L);
            pay.getPayInfo().setService("W1");
            pay.getPayInfo().setSubAppid(appId);
//            pay.getPayInfo().setSubOpenid(user.getRegWay());
            pay.getPayInfo().setPartnerId(2L);
            pay.getPayInfo().setSecurityKey(secret);
            pay.getPayInfo().setPartnerSign("商户验签");
            pay.getPayInfo().setTradeType("1");
            pay.getPayInfo().setPayType("1");
            pay.getPayInfo().setPayerAccId(1L);
//            payInfo.setShowUrl("服务URL");
            pay.getPayInfo().setDeviceType("JSAPI");
            pay.getPayInfo().setActiveIndate(now);
            BizTrans<Map<String, Object>> bizTrans = payService.prePay(pay.getPayInfo());
            return ResponseEntity.ok(bizTrans);
        } catch (Exception e) {
            logger.error("prePay pay error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR)
                    .body(Result.error(CommonConstants.SERVER_ERROR, e.getMessage()));
        }
    }


    // 配置文件配置为该接口等待支付成功后回调 pay.service.contract.updateorder.url=http://SERVICE-CONTRACT/contract/api/v1/paysuccess
    @ApiOperation(value = "pay后台回调")
    @ApiResponses({
            @ApiResponse(code = 200, response = Integer.class, message = "更新状态条数"),
            @ApiResponse(code = 1002, response = String.class, message = "字段校验错误"),
            @ApiResponse(code = 500, response = String.class, message = "服务器错误")
    })
    @RequestMapping(value = "/v1/payBack", method = RequestMethod.POST)
    public Result payBack(@RequestParam Map<String, Object> map) {
        try {
            Integer num = wxPayService.updateOrder(map);
            return Result.ok(num > 0 ? 1 : 0);
        } catch (BusinessException e) {
            logger.error("update payBack Error!", e);
            return Result.error(CommonConstants.SERVER_ERROR).body(Result.error(e));
        } catch (Exception e) {
            logger.error("update payBack Error!", e);
            return Result.error(CommonConstants.SERVER_ERROR)
                    .body(Result.error(CommonConstants.SERVER_ERROR, e.getMessage()));
        }
    }
}
