package com.synapse.reading.controller;

import com.synapse.common.constants.PageInfo;
import com.synapse.common.trans.Result;
import com.synapse.common.sso.context.UserContext;
import com.synapse.common.sso.model.User;
import com.synapse.reading.model.MediaList;
import com.synapse.reading.dto.param.MediaListParam;
import com.synapse.reading.dto.result.MediaListResult;
import com.synapse.reading.service.MediaListService;
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
 * Controller
 * </p>
 *
 * @author wangyifan
 * @since 2018-11-20
 */
@Api(tags = "MediaListController")
@RestController
@RequestMapping("/reading")
public class MediaListController extends BaseController {

    private Logger logger = LoggerFactory.getLogger(MediaListController.class);

    @Autowired
    private MediaListService mediaListService;

    @ApiOperation(value = "查询MediaList列表(分页)")
    @ApiResponses({
            @ApiResponse(code = 200, response = MediaListResult.class, message = "MediaList列表"),
            @ApiResponse(code = 1002, response = String.class, message = "字段校验错误"),
            @ApiResponse(code = 500, response = String.class, message = "服务器错误")
    })
    @RequestMapping(value = "/v1/mediaList", method = RequestMethod.GET)
    public ResponseEntity list(PageInfo pageInfo, @Validated(Search.class) MediaListParam param, BindingResult bindingResult) {
        try {
            //验证失败
            if (bindingResult.hasErrors()) {
                throw new ValidException(bindingResult.getFieldError().getDefaultMessage());
            }
            int totalNum = mediaListService.count(param.getModel());
            preparePageInfo(pageInfo, totalNum);
            List<MediaList> models = mediaListService.list(param.getModel(), pageInfo);
            List<MediaListResult> results = models.stream().map(it -> new MediaListResult(it)).collect(Collectors.toList());
            Map<String, Object> map = new HashMap();
            map.put("mediaListList", results);
            map.put("totalNum", totalNum);
            return ResponseEntity.ok(map);
        } catch (BusinessException e) {
            logger.error("list MediaList Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR).body(Result.error(e));
        } catch (Exception e) {
            logger.error("list MediaList Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR)
                    .body(Result.error(CommonConstants.SERVER_ERROR, e.getMessage()));
        }
    }

    @ApiOperation(value = "根据主键查询MediaList详情")
    @ApiResponses({
            @ApiResponse(code = 200, response = MediaListResult.class, message = "MediaList对象"),
            @ApiResponse(code = 500, response = String.class, message = "服务器错误")
    })
    @RequestMapping(value = "/v1/mediaList/{recId}", method = RequestMethod.GET)
    public ResponseEntity get(@PathVariable("recId") String recId) {
        try {
            MediaList mediaList = mediaListService.find(recId);
            return ResponseEntity.ok(new MediaListResult(mediaList));
        } catch (BusinessException e) {
            logger.error("get MediaList Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR).body(Result.error(e));
        } catch (Exception e) {
            logger.error("get MediaList Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR)
                    .body(Result.error(CommonConstants.SERVER_ERROR, e.getMessage()));
        }
    }

    @ApiOperation(value = "创建MediaList")
    @ApiResponses({
            @ApiResponse(code = 200, response = String.class, message = "主键"),
            @ApiResponse(code = 1002, response = String.class, message = "字段校验错误"),
            @ApiResponse(code = 500, response = String.class, message = "服务器错误")
    })
    @RequestMapping(value = "/v1/mediaList", method = RequestMethod.POST)
    public ResponseEntity create(@RequestBody @Validated(Create.class) MediaListParam param, BindingResult bindingResult) {
        try {
            //验证失败
            if (bindingResult.hasErrors()) {
                throw new ValidException(bindingResult.getFieldError().getDefaultMessage());
            }
            User user = UserContext.getUser();
            //todo 根据角色判断权限

            MediaList model = param.getModel();
            model.setCreateId(user.getRecId());
            model.setUpdateId(user.getRecId());
            String recId = mediaListService.create(model);
            return ResponseEntity.ok(recId);
        } catch (BusinessException e) {
            logger.error("create MediaList Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR).body(Result.error(e));
        } catch (Exception e) {
            logger.error("create MediaList Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR)
                    .body(Result.error(CommonConstants.SERVER_ERROR, e.getMessage()));
        }
    }

    @ApiOperation(value = "根据主键删除MediaList")
    @ApiResponses({
            @ApiResponse(code = 200, response = Integer.class, message = "删除数量"),
            @ApiResponse(code = 500, response = String.class, message = "服务器错误")
    })
    @RequestMapping(value = "/v1/mediaList/{recId}", method = RequestMethod.DELETE)
    public ResponseEntity delete(@PathVariable("recId") String recId) {
        try {
            User user = UserContext.getUser();
            //todo 根据角色判断权限

            Integer num = mediaListService.delete(recId);
            return ResponseEntity.ok(num);
        } catch (BusinessException e) {
            logger.error("delete MediaList Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR).body(Result.error(e));
        } catch (Exception e) {
            logger.error("delete MediaList Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR)
                    .body(Result.error(CommonConstants.SERVER_ERROR, e.getMessage()));
        }
    }

    @ApiOperation(value = "根据主键更新MediaList")
    @ApiResponses({
            @ApiResponse(code = 200, response = Integer.class, message = "更新数量"),
            @ApiResponse(code = 1002, response = String.class, message = "字段校验错误"),
            @ApiResponse(code = 500, response = String.class, message = "服务器错误")
    })
    @RequestMapping(value = "/v1/mediaList/{recId}", method = RequestMethod.PUT)
    public ResponseEntity update(@PathVariable("recId") String recId, @RequestBody @Validated(Update.class) MediaListParam param, BindingResult bindingResult) {
        try {
            //验证失败
            if (bindingResult.hasErrors()) {
                throw new ValidException(bindingResult.getFieldError().getDefaultMessage());
            }
            User user = UserContext.getUser();
            //todo 根据角色判断权限

            MediaList model = param.getModel();
            model.setRecId(recId);
            model.setUpdateId(user.getRecId());
            Integer num = mediaListService.update(model);
            return ResponseEntity.ok(num);
        } catch (BusinessException e) {
            logger.error("update MediaList Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR).body(Result.error(e));
        } catch (Exception e) {
            logger.error("update MediaList Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR)
                    .body(Result.error(CommonConstants.SERVER_ERROR, e.getMessage()));
        }
    }


    @ApiOperation(value = "根据播放次数更新playNum")
    @ApiResponses({
            @ApiResponse(code = 200, response = Integer.class, message = "true"),
            @ApiResponse(code = 500, response = String.class, message = "服务器错误")
    })
    @RequestMapping(value = "/v1/mediaList/updataNum/{recId}", method = RequestMethod.PUT)
    public ResponseEntity updatePlayMediaNum(@PathVariable("recId") String recId) {
        try {
            User user = UserContext.getUser();
            //todo 根据角色判断权限

            Boolean valid = mediaListService.updatePlayMediaNum(recId);
            return ResponseEntity.ok(valid);
        } catch (BusinessException e) {
            logger.error("updatePlayMediaNum MediaList Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR).body(Result.error(e));
        } catch (Exception e) {
            logger.error("updatePlayMediaNum MediaList Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR)
                    .body(Result.error(CommonConstants.SERVER_ERROR, e.getMessage()));
        }
    }


}