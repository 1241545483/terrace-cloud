package com.synapse.reading.controller;

import com.synapse.common.constants.PageInfo;
import com.synapse.common.trans.Result;
import com.synapse.common.sso.context.UserContext;
import com.synapse.common.sso.model.User;
import com.synapse.reading.model.BaseSystemParameter;
import com.synapse.reading.dto.param.BaseSystemParameterParam;
import com.synapse.reading.dto.result.BaseSystemParameterResult;
import com.synapse.reading.service.BaseSystemParameterService;
import com.synapse.reading.web.valid.group.Update;
import com.synapse.reading.web.valid.group.Create;
import com.synapse.reading.web.valid.group.Search;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
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
 *  Controller
 * </p>
 * @author wangyifan
 * @since 2018-11-20
 */
@Api(tags = "BaseSystemParameterController")
@RestController
@RequestMapping("/reading")
public class BaseSystemParameterController extends BaseController{

    private Logger logger = LoggerFactory.getLogger(BaseSystemParameterController.class);

    @Autowired
    private BaseSystemParameterService baseSystemParameterService;

	@ApiOperation(value = "查询BaseSystemParameter列表(分页)")
    @ApiResponses({
            @ApiResponse(code = 200, response = BaseSystemParameterResult.class, message = "BaseSystemParameter列表"),
            @ApiResponse(code = 1002, response = String.class, message = "字段校验错误"),
            @ApiResponse(code = 500, response = String.class, message = "服务器错误")
    })
	@RequestMapping(value = "/v1/baseSystemParameter",method = RequestMethod.GET)
	public Result list(PageInfo pageInfo, @Validated(Search.class) BaseSystemParameterParam param, BindingResult bindingResult) {
        try {
	        //验证失败
	        if (bindingResult.hasErrors()) {
	            throw new ValidException(bindingResult.getFieldError().getDefaultMessage());
	        }
	        int totalNum = baseSystemParameterService.count(param.getModel());
	        preparePageInfo(pageInfo, totalNum);
	        List<BaseSystemParameter> models = baseSystemParameterService.list(param.getModel(),pageInfo);
	        List<BaseSystemParameterResult> results = models.stream().map(it -> new BaseSystemParameterResult(it)).collect(Collectors.toList());
	        Map<String, Object> map = new HashMap();
            map.put("baseSystemParameterList", results);
            map.put("totalNum", totalNum);
	        return Result.ok(map);
        } catch (BusinessException e) {
	        logger.error("list BaseSystemParameter Error!", e);
	        return Result.error(e);
        } catch (Exception e) {
	        logger.error("list BaseSystemParameter Error!", e);
	        return Result.error(CommonConstants.SERVER_ERROR, e.getMessage());
        }
	}

	@ApiOperation(value = "根据主键查询BaseSystemParameter详情")
    @ApiResponses({
            @ApiResponse(code = 200, response = BaseSystemParameterResult.class, message = "BaseSystemParameter对象"),
            @ApiResponse(code = 500, response = String.class, message = "服务器错误")
    })
    @RequestMapping(value = "/v1/baseSystemParameter/{recId}",method = RequestMethod.GET)
    public Result get(@PathVariable("recId") String recId){
        try {
            BaseSystemParameter baseSystemParameter = baseSystemParameterService.view(recId);
            return Result.ok(new BaseSystemParameterResult(baseSystemParameter));
        } catch (BusinessException e) {
            logger.error("get BaseSystemParameter Error!", e);
            return Result.error(e);
        } catch (Exception e) {
            logger.error("get BaseSystemParameter Error!", e);
            return Result.error(CommonConstants.SERVER_ERROR, e.getMessage());
        }
    }

	@ApiOperation(value = "创建BaseSystemParameter")
    @ApiResponses({
            @ApiResponse(code = 200, response = String.class, message = "主键"),
            @ApiResponse(code = 1002, response = String.class, message = "字段校验错误"),
            @ApiResponse(code = 500, response = String.class, message = "服务器错误")
    })
    @RequestMapping(value = "/v1/baseSystemParameter", method = RequestMethod.POST)
    public Result create(@RequestBody @Validated(Create.class) BaseSystemParameterParam param, BindingResult bindingResult) {
        try {
            //验证失败
            if (bindingResult.hasErrors()) {
                throw new ValidException(bindingResult.getFieldError().getDefaultMessage());
            }
            User user = UserContext.getUser();
            //todo 根据角色判断权限

	        BaseSystemParameter model = param.getModel();
            String recId = baseSystemParameterService.create(model);
            return Result.ok(recId);
        } catch (BusinessException e) {
            logger.error("create BaseSystemParameter Error!", e);
            return Result.error(e);
        } catch (Exception e) {
            logger.error("create BaseSystemParameter Error!", e);
            return Result.error(CommonConstants.SERVER_ERROR, e.getMessage());
        }
    }

	@ApiOperation(value = "根据主键删除BaseSystemParameter")
    @ApiResponses({
            @ApiResponse(code = 200, response = Integer.class, message = "删除数量"),
            @ApiResponse(code = 500, response = String.class, message = "服务器错误")
    })
	@RequestMapping(value = "/v1/baseSystemParameter/{recId}",method = RequestMethod.DELETE)
	public Result delete(@PathVariable("recId") String recId){
        try {
            User user = UserContext.getUser();
            //todo 根据角色判断权限

			Integer num = baseSystemParameterService.delete(recId);
            return Result.ok(num);
        } catch (BusinessException e) {
            logger.error("delete BaseSystemParameter Error!", e);
            return Result.error(e);
        } catch (Exception e) {
            logger.error("delete BaseSystemParameter Error!", e);
            return Result.error(CommonConstants.SERVER_ERROR, e.getMessage());
        }
    }

	@ApiOperation(value = "根据主键更新BaseSystemParameter")
    @ApiResponses({
            @ApiResponse(code = 200, response = Integer.class, message = "更新数量"),
            @ApiResponse(code = 1002, response = String.class, message = "字段校验错误"),
            @ApiResponse(code = 500, response = String.class, message = "服务器错误")
    })
	@RequestMapping(value = "/v1/baseSystemParameter/{recId}", method = RequestMethod.PUT)
    public Result update(@PathVariable("recId") String recId, @RequestBody @Validated(Update.class) BaseSystemParameterParam param, BindingResult bindingResult){
        try {
	        //验证失败
	        if (bindingResult.hasErrors()) {
	            throw new ValidException(bindingResult.getFieldError().getDefaultMessage());
	        }
            User user = UserContext.getUser();
            //todo 根据角色判断权限

	        BaseSystemParameter model = param.getModel();
	        model.setRecId(recId);
	        Integer num = baseSystemParameterService.update(model);
	        return Result.ok(num);
        } catch (BusinessException e) {
	        logger.error("update BaseSystemParameter Error!", e);
	        return Result.error(e);
        } catch (Exception e) {
	        logger.error("update BaseSystemParameter Error!", e);
	        return Result.error(CommonConstants.SERVER_ERROR, e.getMessage());
        }
	}

}