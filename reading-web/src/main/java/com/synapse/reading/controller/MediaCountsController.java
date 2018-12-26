package com.synapse.reading.controller;

import com.synapse.common.constants.PageInfo;
import com.synapse.common.trans.Result;
import com.synapse.common.sso.context.UserContext;
import com.synapse.common.sso.model.User;
import com.synapse.reading.model.MediaCounts;
import com.synapse.reading.dto.param.MediaCountsParam;
import com.synapse.reading.dto.result.MediaCountsResult;
import com.synapse.reading.service.MediaCountsService;
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
 * 统计播放量 Controller
 * </p>
 * @author liuguangfu
 * @since 2018-12-25
 */
@Api(tags = "MediaCountsController")
@RestController
@RequestMapping("/reading")
public class MediaCountsController extends BaseController{

    private Logger logger = LoggerFactory.getLogger(MediaCountsController.class);

    @Autowired
    private MediaCountsService mediaCountsService;

	@ApiOperation(value = "查询MediaCounts列表(分页)")
    @ApiResponses({
            @ApiResponse(code = 200, response = MediaCountsResult.class, message = "MediaCounts列表"),
            @ApiResponse(code = 1002, response = String.class, message = "字段校验错误"),
            @ApiResponse(code = 500, response = String.class, message = "服务器错误")
    })
	@RequestMapping(value = "/v1/mediaCounts",method = RequestMethod.GET)
	public ResponseEntity list(PageInfo pageInfo, @Validated(Search.class) MediaCountsParam param, BindingResult bindingResult) {
        try {
	        //验证失败
	        if (bindingResult.hasErrors()) {
	            throw new ValidException(bindingResult.getFieldError().getDefaultMessage());
	        }
	        int totalNum = mediaCountsService.count(param.getModel());
	        preparePageInfo(pageInfo, totalNum);
	        List<MediaCounts> models = mediaCountsService.list(param.getModel(),pageInfo);
	        List<MediaCountsResult> results = models.stream().map(it -> new MediaCountsResult(it)).collect(Collectors.toList());
	        Map<String, Object> map = new HashMap();
            map.put("mediaCountsList", results);
            map.put("totalNum", totalNum);
	        return ResponseEntity.ok(map);
        } catch (BusinessException e) {
	        logger.error("list MediaCounts Error!", e);
	        return ResponseEntity.status(CommonConstants.SERVER_ERROR).body(Result.error(e));
        } catch (Exception e) {
	        logger.error("list MediaCounts Error!", e);
	        return ResponseEntity.status(CommonConstants.SERVER_ERROR)
		.body(Result.error(CommonConstants.SERVER_ERROR, e.getMessage()));
        }
	}

	@ApiOperation(value = "根据主键查询MediaCounts详情")
    @ApiResponses({
            @ApiResponse(code = 200, response = MediaCountsResult.class, message = "MediaCounts对象"),
            @ApiResponse(code = 500, response = String.class, message = "服务器错误")
    })
    @RequestMapping(value = "/v1/mediaCounts/{recId}",method = RequestMethod.GET)
    public ResponseEntity get(@PathVariable("recId") String recId){
        try {
            MediaCounts mediaCounts = mediaCountsService.find(recId);
            return ResponseEntity.ok(new MediaCountsResult(mediaCounts));
        } catch (BusinessException e) {
            logger.error("get MediaCounts Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR).body(Result.error(e));
        } catch (Exception e) {
            logger.error("get MediaCounts Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR)
        .body(Result.error(CommonConstants.SERVER_ERROR, e.getMessage()));
        }
    }

	@ApiOperation(value = "创建MediaCounts")
    @ApiResponses({
            @ApiResponse(code = 200, response = String.class, message = "主键"),
            @ApiResponse(code = 1002, response = String.class, message = "字段校验错误"),
            @ApiResponse(code = 500, response = String.class, message = "服务器错误")
    })
    @RequestMapping(value = "/v1/mediaCounts", method = RequestMethod.POST)
    public ResponseEntity create(@RequestBody @Validated(Create.class) MediaCountsParam param, BindingResult bindingResult) {
        try {
            //验证失败
            if (bindingResult.hasErrors()) {
                throw new ValidException(bindingResult.getFieldError().getDefaultMessage());
            }
            User user = UserContext.getUser();
            //todo 根据角色判断权限

	        MediaCounts model = param.getModel();
            String recId = mediaCountsService.create(model);
            return ResponseEntity.ok(recId);
        } catch (BusinessException e) {
            logger.error("create MediaCounts Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR).body(Result.error(e));
        } catch (Exception e) {
            logger.error("create MediaCounts Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR)
        .body(Result.error(CommonConstants.SERVER_ERROR, e.getMessage()));
        }
    }

	@ApiOperation(value = "根据主键删除MediaCounts")
    @ApiResponses({
            @ApiResponse(code = 200, response = Integer.class, message = "删除数量"),
            @ApiResponse(code = 500, response = String.class, message = "服务器错误")
    })
	@RequestMapping(value = "/v1/mediaCounts/{recId}",method = RequestMethod.DELETE)
	public ResponseEntity delete(@PathVariable("recId") String recId){
        try {
            User user = UserContext.getUser();
            //todo 根据角色判断权限

			Integer num = mediaCountsService.delete(recId);
            return ResponseEntity.ok(num);
        } catch (BusinessException e) {
            logger.error("delete MediaCounts Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR).body(Result.error(e));
        } catch (Exception e) {
            logger.error("delete MediaCounts Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR)
        .body(Result.error(CommonConstants.SERVER_ERROR, e.getMessage()));
        }
    }

    @ApiOperation(value = "增加点击音频或视频数量")
    @ApiResponses({
            @ApiResponse(code = 200, response = Integer.class, message = "增加数量"),
            @ApiResponse(code = 500, response = String.class, message = "服务器错误")
    })
    @RequestMapping(value = "/v1/updateByCreateId/{mediaId}",method = RequestMethod.POST)
    public ResponseEntity updateByCreateId(@PathVariable("mediaId") String mediaId ,MediaCounts mediaCounts){
        try {
            User user = UserContext.getUser();
            //todo 根据角色判断权限

            Integer num = mediaCountsService.updateByCreateId(mediaId,mediaCounts);
            return ResponseEntity.ok(num);
        } catch (BusinessException e) {
            logger.error("updateByCreateId MediaCounts Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR).body(Result.error(e));
        } catch (Exception e) {
            logger.error("updateByCreateId MediaCounts Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR)
                    .body(Result.error(CommonConstants.SERVER_ERROR, e.getMessage()));
        }
    }

    @ApiOperation(value = "增加当前音频或音频播放完成数量")
    @ApiResponses({
            @ApiResponse(code = 200, response = Integer.class, message = "增加数量"),
            @ApiResponse(code = 500, response = String.class, message = "服务器错误")
    })
    @RequestMapping(value = "/v1/updateFinishedByCreateId/{mediaId}",method = RequestMethod.POST)
    public ResponseEntity updateFinishedByCreateId(@PathVariable("mediaId") String mediaId,MediaCounts mediaCounts){
        try {
            User user = UserContext.getUser();
            //todo 根据角色判断权限

            Integer num = mediaCountsService.updateFinishedByCreateId(mediaId,mediaCounts);
            return ResponseEntity.ok(num);
        } catch (BusinessException e) {
            logger.error("updateFinishedByCreateId MediaCounts Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR).body(Result.error(e));
        } catch (Exception e) {
            logger.error("updateFinishedByCreateId MediaCounts Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR)
                    .body(Result.error(CommonConstants.SERVER_ERROR, e.getMessage()));
        }
    }

    @ApiOperation(value = "每日点击数量")
    @ApiResponses({
            @ApiResponse(code = 200, response = Integer.class, message = "增加数量"),
            @ApiResponse(code = 500, response = String.class, message = "服务器错误")
    })
    @RequestMapping(value = "/v1/clickCountByTime/{mediaId}",method = RequestMethod.GET)
    public ResponseEntity clickCountByTime(@PathVariable("mediaId") String mediaId,String startTime,String endTime){
        try {
            User user = UserContext.getUser();
            //todo 根据角色判断权限

            List<Map<String,String>> num = mediaCountsService.clickCountByTime(startTime,endTime,mediaId);
            return ResponseEntity.ok(num);
        } catch (BusinessException e) {
            logger.error("clickCountByTime MediaCounts Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR).body(Result.error(e));
        } catch (Exception e) {
            logger.error("clickCountByTime MediaCounts Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR)
                    .body(Result.error(CommonConstants.SERVER_ERROR, e.getMessage()));
        }
    }

    @ApiOperation(value = "每日播放完成数量")
    @ApiResponses({
            @ApiResponse(code = 200, response = Integer.class, message = "完成数量"),
            @ApiResponse(code = 500, response = String.class, message = "服务器错误")
    })
    @RequestMapping(value = "/v1/finishCountByTime/{mediaId}",method = RequestMethod.GET)
    public ResponseEntity finishCountByTime(@PathVariable("mediaId") String mediaId,String startTime,String endTime){
        try {
            User user = UserContext.getUser();
            //todo 根据角色判断权限

                List<Map<String,String>> num = mediaCountsService.finishCountByTime(startTime,endTime,mediaId);
            return ResponseEntity.ok(num);
        } catch (BusinessException e) {
            logger.error("finishCountByTime MediaCounts Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR).body(Result.error(e));
        } catch (Exception e) {
            logger.error("finishCountByTime MediaCounts Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR)
                    .body(Result.error(CommonConstants.SERVER_ERROR, e.getMessage()));
        }
    }

    @ApiOperation(value = "每日播放完成率")
    @ApiResponses({
            @ApiResponse(code = 200, response = Integer.class, message = "完成率"),
            @ApiResponse(code = 500, response = String.class, message = "服务器错误")
    })
    @RequestMapping(value = "/v1/finishRateByTime/{mediaId}",method = RequestMethod.GET)
    public ResponseEntity finishRateByTime(@PathVariable("mediaId") String mediaId,String startTime,String endTime){
        try {
            User user = UserContext.getUser();
            //todo 根据角色判断权限

            List<Map<String,String>> num = mediaCountsService.finishRateByTime(startTime,endTime,mediaId);
            return ResponseEntity.ok(num);
        } catch (BusinessException e) {
            logger.error("finishRateByTime MediaCounts Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR).body(Result.error(e));
        } catch (Exception e) {
            logger.error("finishRateByTime MediaCounts Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR)
                    .body(Result.error(CommonConstants.SERVER_ERROR, e.getMessage()));
        }
    }


    @ApiOperation(value = "根据主键更新MediaCounts")
    @ApiResponses({
            @ApiResponse(code = 200, response = Integer.class, message = "更新数量"),
            @ApiResponse(code = 1002, response = String.class, message = "字段校验错误"),
            @ApiResponse(code = 500, response = String.class, message = "服务器错误")
    })
	@RequestMapping(value = "/v1/mediaCounts/{recId}", method = RequestMethod.PUT)
    public ResponseEntity update(@PathVariable("recId") String recId, @RequestBody @Validated(Update.class) MediaCountsParam param, BindingResult bindingResult){
        try {
	        //验证失败
	        if (bindingResult.hasErrors()) {
	            throw new ValidException(bindingResult.getFieldError().getDefaultMessage());
	        }
            User user = UserContext.getUser();
            //todo 根据角色判断权限

	        MediaCounts model = param.getModel();
	        model.setRecId(recId);
	        Integer num = mediaCountsService.update(model);
	        return ResponseEntity.ok(num);
        } catch (BusinessException e) {
	        logger.error("update MediaCounts Error!", e);
	        return ResponseEntity.status(CommonConstants.SERVER_ERROR).body(Result.error(e));
        } catch (Exception e) {
	        logger.error("update MediaCounts Error!", e);
	        return ResponseEntity.status(CommonConstants.SERVER_ERROR)
        .body(Result.error(CommonConstants.SERVER_ERROR, e.getMessage()));
        }
	}




}