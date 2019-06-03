package com.synapse.reading.controller.controllor;

import com.synapse.common.constants.PageInfo;
import com.synapse.common.trans.Result;
import com.synapse.common.sso.context.UserContext;
import com.synapse.common.sso.model.User;
import com.synapse.reading.controller.BaseController;
import com.synapse.reading.model.model.Model;
import com.synapse.reading.dto.param.param.ModelParam;
import com.synapse.reading.dto.result.result.ModelResult;
import com.synapse.reading.service.service.ModelService;
import com.synapse.reading.web.valid.group.Update;
import com.synapse.reading.web.valid.group.Create;
import com.synapse.reading.web.valid.group.Search;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import com.synapse.common.exception.BusinessException;
import com.synapse.reading.exception.common.ValidException;
import org.springframework.validation.BindingResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.synapse.reading.constants.CommonConstants;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * <p>
 * 系统模块 Controller
 * </p>
 * @author liuguangfu
 * @since 2019-05-28
 */
@Api(tags = "ModelController")
@RestController
@RequestMapping("/reading")
public class ModelController extends BaseController {

    private Logger logger = LoggerFactory.getLogger(ModelController.class);

    @Autowired
    private ModelService modelService;

	@ApiOperation(value = "查询Model列表(分页)")
    @ApiResponses({
            @ApiResponse(code = 200, response = ModelResult.class, message = "Model列表"),
            @ApiResponse(code = 1002, response = String.class, message = "字段校验错误"),
            @ApiResponse(code = 500, response = String.class, message = "服务器错误")
    })
    @ApiImplicitParams({
        @ApiImplicitParam(name = "recId" , paramType = "query"),
        @ApiImplicitParam(name = "menuId" , paramType = "query"),
        @ApiImplicitParam(name = "operateDesc" , paramType = "query"),
        @ApiImplicitParam(name = "name" , paramType = "query"),
        @ApiImplicitParam(name = "status" , paramType = "query"),
        @ApiImplicitParam(name = "createId" , paramType = "query"),
        @ApiImplicitParam(name = "createTime" , paramType = "query"),
        @ApiImplicitParam(name = "updateId" , paramType = "query"),
        @ApiImplicitParam(name = "updateTime" , paramType = "query")    })
	@RequestMapping(value = "/v1/model",method = RequestMethod.GET)
	public ResponseEntity list(PageInfo pageInfo, @Validated(Search.class) ModelParam param, BindingResult bindingResult) {
        try {
	        //验证失败
	        if (bindingResult.hasErrors()) {
	            throw new ValidException(bindingResult.getFieldError().getDefaultMessage());
	        }
	        int totalNum = modelService.count(param.getModel());
	        preparePageInfo(pageInfo, totalNum);
	        List<Model> models = modelService.list(param.getModel(),pageInfo);
	        List<ModelResult> results = models.stream().map(it -> new ModelResult(it)).collect(Collectors.toList());
	        Map<String, Object> map = new HashMap();
            map.put("modelList", results);
            map.put("totalNum", totalNum);
	        return ResponseEntity.ok(map);
        } catch (BusinessException e) {
	        logger.error("list Model Error!", e);
	        return ResponseEntity.status(CommonConstants.SERVER_ERROR).body(Result.error(e));
        } catch (Exception e) {
	        logger.error("list Model Error!", e);
	        return ResponseEntity.status(CommonConstants.SERVER_ERROR)
		.body(Result.error(CommonConstants.SERVER_ERROR, e.getMessage()));
        }
	}

	@ApiOperation(value = "根据主键查询Model详情")
    @ApiResponses({
            @ApiResponse(code = 200, response = ModelResult.class, message = "Model对象"),
            @ApiResponse(code = 500, response = String.class, message = "服务器错误")
    })
    @RequestMapping(value = "/v1/model/{recId}",method = RequestMethod.GET)
    public ResponseEntity get(@PathVariable("recId") String recId){
        try {
            Model model = modelService.find(recId);
            return ResponseEntity.ok(new ModelResult(model));
        } catch (BusinessException e) {
            logger.error("get Model Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR).body(Result.error(e));
        } catch (Exception e) {
            logger.error("get Model Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR)
        .body(Result.error(CommonConstants.SERVER_ERROR, e.getMessage()));
        }
    }

	@ApiOperation(value = "创建Model")
    @ApiResponses({
            @ApiResponse(code = 200, response = String.class, message = "主键"),
            @ApiResponse(code = 1002, response = String.class, message = "字段校验错误"),
            @ApiResponse(code = 500, response = String.class, message = "服务器错误")
    })
    @RequestMapping(value = "/v1/model", method = RequestMethod.POST)
    public ResponseEntity create(@RequestBody @Validated(Create.class) ModelParam param, BindingResult bindingResult) {
        try {
            //验证失败
            if (bindingResult.hasErrors()) {
                throw new ValidException(bindingResult.getFieldError().getDefaultMessage());
            }
            User user = UserContext.getUser();
            //todo 根据角色判断权限

	        Model model = param.getModel();
                model.setCreateId(user.getRecId());
                model.setUpdateId(user.getRecId());
            String recId = modelService.create(model);
            return ResponseEntity.ok(recId);
        } catch (BusinessException e) {
            logger.error("create Model Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR).body(Result.error(e));
        } catch (Exception e) {
            logger.error("create Model Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR)
        .body(Result.error(CommonConstants.SERVER_ERROR, e.getMessage()));
        }
    }

	@ApiOperation(value = "根据主键删除Model")
    @ApiResponses({
            @ApiResponse(code = 200, response = Integer.class, message = "删除数量"),
            @ApiResponse(code = 500, response = String.class, message = "服务器错误")
    })
	@RequestMapping(value = "/v1/model/{recId}",method = RequestMethod.DELETE)
	public ResponseEntity delete(@PathVariable("recId") String recId){
        try {
            User user = UserContext.getUser();
            //todo 根据角色判断权限

			Integer num = modelService.delete(recId,user.getRecId());
            return ResponseEntity.ok(num);
        } catch (BusinessException e) {
            logger.error("delete Model Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR).body(Result.error(e));
        } catch (Exception e) {
            logger.error("delete Model Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR)
        .body(Result.error(CommonConstants.SERVER_ERROR, e.getMessage()));
        }
    }

	@ApiOperation(value = "根据主键更新Model")
    @ApiResponses({
            @ApiResponse(code = 200, response = Integer.class, message = "更新数量"),
            @ApiResponse(code = 1002, response = String.class, message = "字段校验错误"),
            @ApiResponse(code = 500, response = String.class, message = "服务器错误")
    })
	@RequestMapping(value = "/v1/model/{recId}", method = RequestMethod.PUT)
    public ResponseEntity update(@PathVariable("recId") String recId, @RequestBody @Validated(Update.class) ModelParam param, BindingResult bindingResult){
        try {
	        //验证失败
	        if (bindingResult.hasErrors()) {
	            throw new ValidException(bindingResult.getFieldError().getDefaultMessage());
	        }
            User user = UserContext.getUser();
            //todo 根据角色判断权限

	        Model model = param.getModel();
	        model.setRecId(recId);
            model.setUpdateId(user.getRecId());
	        Integer num = modelService.update(model);
	        return ResponseEntity.ok(num);
        } catch (BusinessException e) {
	        logger.error("update Model Error!", e);
	        return ResponseEntity.status(CommonConstants.SERVER_ERROR).body(Result.error(e));
        } catch (Exception e) {
	        logger.error("update Model Error!", e);
	        return ResponseEntity.status(CommonConstants.SERVER_ERROR)
        .body(Result.error(CommonConstants.SERVER_ERROR, e.getMessage()));
        }
	}

}