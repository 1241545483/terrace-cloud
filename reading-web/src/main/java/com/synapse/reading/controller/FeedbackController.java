package com.synapse.reading.controller;

import com.synapse.common.constants.PageInfo;
import com.synapse.common.trans.Result;
import com.synapse.common.sso.context.UserContext;
import com.synapse.common.sso.model.User;
import com.synapse.reading.model.Feedback;
import com.synapse.reading.dto.param.FeedbackParam;
import com.synapse.reading.dto.result.FeedbackResult;
import com.synapse.reading.service.FeedbackService;
import com.synapse.reading.web.valid.group.Update;
import com.synapse.reading.web.valid.group.Create;
import com.synapse.reading.web.valid.group.Search;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import com.synapse.common.exception.BusinessException;
import com.synapse.reading.exception.common.ValidException;
import org.springframework.validation.BindingResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import com.synapse.reading.constants.CommonConstants;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.synapse.reading.controller.BaseController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * <p>
 * 意见反馈 Controller
 * </p>
 * @author liuguangfu
 * @since 2018-12-26
 */
@Api(tags = "FeedbackController")
@RestController
@RequestMapping("/reading")
public class FeedbackController extends BaseController{

    private Logger logger = LoggerFactory.getLogger(FeedbackController.class);

    @Autowired
    private FeedbackService feedbackService;

	@ApiOperation(value = "查询Feedback列表(分页)")
    @ApiResponses({
            @ApiResponse(code = 200, response = FeedbackResult.class, message = "Feedback列表"),
            @ApiResponse(code = 1002, response = String.class, message = "字段校验错误"),
            @ApiResponse(code = 500, response = String.class, message = "服务器错误")
    })
	@RequestMapping(value = "/v1/feedback",method = RequestMethod.GET)
	public ResponseEntity list(PageInfo pageInfo, @Validated(Search.class) FeedbackParam param, BindingResult bindingResult) {
        try {
	        //验证失败
	        if (bindingResult.hasErrors()) {
	            throw new ValidException(bindingResult.getFieldError().getDefaultMessage());
	        }
	        int totalNum = feedbackService.count(param.getModel());
	        preparePageInfo(pageInfo, totalNum);
	        List<Feedback> models = feedbackService.list(param.getModel(),pageInfo);
	        List<FeedbackResult> results = models.stream().map(it -> new FeedbackResult(it)).collect(Collectors.toList());
	        Map<String, Object> map = new HashMap();
            map.put("feedbackList", results);
            map.put("totalNum", totalNum);
	        return ResponseEntity.ok(map);
        } catch (BusinessException e) {
	        logger.error("list Feedback Error!", e);
	        return ResponseEntity.status(CommonConstants.SERVER_ERROR).body(Result.error(e));
        } catch (Exception e) {
	        logger.error("list Feedback Error!", e);
	        return ResponseEntity.status(CommonConstants.SERVER_ERROR)
		.body(Result.error(CommonConstants.SERVER_ERROR, e.getMessage()));
        }
	}

	@ApiOperation(value = "根据主键查询Feedback详情")
    @ApiResponses({
            @ApiResponse(code = 200, response = FeedbackResult.class, message = "Feedback对象"),
            @ApiResponse(code = 500, response = String.class, message = "服务器错误")
    })
    @RequestMapping(value = "/v1/feedback/{recId}",method = RequestMethod.GET)
    public ResponseEntity get(@PathVariable("recId") String recId){
        try {
            Feedback feedback = feedbackService.find(recId);
            return ResponseEntity.ok(new FeedbackResult(feedback));
        } catch (BusinessException e) {
            logger.error("get Feedback Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR).body(Result.error(e));
        } catch (Exception e) {
            logger.error("get Feedback Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR)
        .body(Result.error(CommonConstants.SERVER_ERROR, e.getMessage()));
        }
    }

	@ApiOperation(value = "创建Feedback")
    @ApiResponses({
            @ApiResponse(code = 200, response = String.class, message = "主键"),
            @ApiResponse(code = 1002, response = String.class, message = "字段校验错误"),
            @ApiResponse(code = 500, response = String.class, message = "服务器错误")
    })
    @RequestMapping(value = "/v1/feedback", method = RequestMethod.POST)
    public ResponseEntity create(@RequestBody @Validated(Create.class) FeedbackParam param, BindingResult bindingResult) {
        try {
            //验证失败
            if (bindingResult.hasErrors()) {
                throw new ValidException(bindingResult.getFieldError().getDefaultMessage());
            }
            User user = UserContext.getUser();
            //todo 根据角色判断权限

	        Feedback model = param.getModel();
                model.setCreateId(user.getRecId());
            String recId = feedbackService.create(model);
            return ResponseEntity.ok(recId);
        } catch (BusinessException e) {
            logger.error("create Feedback Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR).body(Result.error(e));
        } catch (Exception e) {
            logger.error("create Feedback Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR)
        .body(Result.error(CommonConstants.SERVER_ERROR, e.getMessage()));
        }
    }

	@ApiOperation(value = "根据主键删除Feedback")
    @ApiResponses({
            @ApiResponse(code = 200, response = Integer.class, message = "删除数量"),
            @ApiResponse(code = 500, response = String.class, message = "服务器错误")
    })
	@RequestMapping(value = "/v1/feedback/{recId}",method = RequestMethod.DELETE)
	public ResponseEntity delete(@PathVariable("recId") String recId){
        try {
            User user = UserContext.getUser();
            //todo 根据角色判断权限

			Integer num = feedbackService.delete(recId);
            return ResponseEntity.ok(num);
        } catch (BusinessException e) {
            logger.error("delete Feedback Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR).body(Result.error(e));
        } catch (Exception e) {
            logger.error("delete Feedback Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR)
        .body(Result.error(CommonConstants.SERVER_ERROR, e.getMessage()));
        }
    }

	@ApiOperation(value = "根据主键更新Feedback")
    @ApiResponses({
            @ApiResponse(code = 200, response = Integer.class, message = "更新数量"),
            @ApiResponse(code = 1002, response = String.class, message = "字段校验错误"),
            @ApiResponse(code = 500, response = String.class, message = "服务器错误")
    })
	@RequestMapping(value = "/v1/feedback/{recId}", method = RequestMethod.PUT)
    public ResponseEntity update(@PathVariable("recId") String recId, @RequestBody @Validated(Update.class) FeedbackParam param, BindingResult bindingResult){
        try {
	        //验证失败
	        if (bindingResult.hasErrors()) {
	            throw new ValidException(bindingResult.getFieldError().getDefaultMessage());
	        }
            User user = UserContext.getUser();
            //todo 根据角色判断权限

	        Feedback model = param.getModel();
	        model.setRecId(recId);
	        Integer num = feedbackService.update(model);
	        return ResponseEntity.ok(num);
        } catch (BusinessException e) {
	        logger.error("update Feedback Error!", e);
	        return ResponseEntity.status(CommonConstants.SERVER_ERROR).body(Result.error(e));
        } catch (Exception e) {
	        logger.error("update Feedback Error!", e);
	        return ResponseEntity.status(CommonConstants.SERVER_ERROR)
        .body(Result.error(CommonConstants.SERVER_ERROR, e.getMessage()));
        }
	}

}