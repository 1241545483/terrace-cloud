package com.synapse.reading.controller;

import com.synapse.common.exception.BusinessException;
import com.synapse.common.trans.Result;

import com.synapse.reading.constants.CommonConstants;
import com.synapse.reading.dto.param.MiniQrcodeParam;
import com.synapse.reading.service.MiniQrcodeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @Author:zhanyang
 * @DATE: 2018/7/18
 */
@Api(tags = "MiniQrcodeController")
@RestController
@RequestMapping("/reading")
public class MiniQrcodeController {

    private Logger logger = LoggerFactory.getLogger(MiniQrcodeController.class);

    @Autowired
    private MiniQrcodeService miniQrcodeService;



    @ApiOperation(value = "生成小程序二维码")
    @ApiResponses({
            @ApiResponse(code = 200, response = MiniQrcodeParam.class, message = "Action列表"),
            @ApiResponse(code = 1002, response = String.class, message = "字段校验错误"),
            @ApiResponse(code = 500, response = String.class, message = "服务器错误")
    })
    @RequestMapping(value = "/v1/miniQrcode",method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    public Result queryActionList(String itemId) {
        try {
            Map<String, Object> map = miniQrcodeService.generateMiniQrcode(itemId);
            return Result.ok(map);
        } catch (BusinessException e) {
            logger.error("list Action Error!", e);
            return Result.error(e);
        } catch (Exception e) {
            logger.error("list Action Error!", e);
            return Result.error(CommonConstants.SERVER_ERROR, e.getMessage());
        }
    }


    @ApiOperation(value = "生成小程序二维码")
    @ApiResponses({
            @ApiResponse(code = 200, response = MiniQrcodeParam.class, message = "Action列表"),
            @ApiResponse(code = 1002, response = String.class, message = "字段校验错误"),
            @ApiResponse(code = 500, response = String.class, message = "服务器错误")
    })
    @RequestMapping(value = "/v1/miniQrcode/create",method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    public Result queryQr(@RequestBody MiniQrcodeParam param) {
        try {
            String map = miniQrcodeService.generate(param);
            return Result.ok(map);
        } catch (BusinessException e) {
            logger.error("list Action Error!", e);
            return Result.error(e);
        } catch (Exception e) {
            logger.error("list Action Error!", e);
            return Result.error(CommonConstants.SERVER_ERROR, e.getMessage());
        }
    }
}
