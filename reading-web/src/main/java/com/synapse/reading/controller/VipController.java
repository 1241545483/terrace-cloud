package com.synapse.reading.controller;


import com.synapse.common.exception.BusinessException;
import com.synapse.common.trans.Result;
import com.synapse.reading.constants.CommonConstants;
import com.synapse.reading.dto.result.VideoResult;
import com.synapse.reading.service.VipService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "VipController")
@RestController
@RequestMapping("/reading")
public class VipController {

    private Logger logger = LoggerFactory.getLogger(VideoController.class);
    @Autowired
    private VipService vipService;

    @ApiOperation(value = "查询Video列表(分页)")
    @ApiResponses({
            @ApiResponse(code = 200, response = VideoResult.class, message = "Video列表"),
            @ApiResponse(code = 1002, response = String.class, message = "字段校验错误"),
            @ApiResponse(code = 500, response = String.class, message = "服务器错误")
    })
    @RequestMapping(value = "/v1/vip/task", method = RequestMethod.GET)
    public ResponseEntity task() {
        try {
            vipService.task();
            return ResponseEntity.ok(true);
        } catch (BusinessException e) {
            logger.error("vipTask Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR).body(Result.error(e));
        } catch (Exception e) {
            logger.error("vipTask Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR)
                    .body(Result.error(CommonConstants.SERVER_ERROR, e.getMessage()));
        }
    }

}
