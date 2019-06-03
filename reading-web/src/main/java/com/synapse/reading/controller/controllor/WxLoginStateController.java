package com.synapse.reading.controller.controllor;

import com.synapse.common.constants.PageInfo;
import com.synapse.common.trans.Result;
import com.synapse.common.sso.context.UserContext;
import com.synapse.common.sso.model.User;
import com.synapse.reading.controller.BaseController;
import com.synapse.reading.model.model.WxLoginState;
import com.synapse.reading.dto.param.param.WxLoginStateParam;
import com.synapse.reading.dto.result.result.WxLoginStateResult;
import com.synapse.reading.service.service.WxLoginStateService;
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
 *  Controller
 * </p>
 * @author liuguangfu
 * @since 2019-05-28
 */
@Api(tags = "WxLoginStateController")
@RestController
@RequestMapping("/reading")
public class WxLoginStateController extends BaseController {

    private Logger logger = LoggerFactory.getLogger(WxLoginStateController.class);

    @Autowired
    private WxLoginStateService wxLoginStateService;

	@ApiOperation(value = "查询WxLoginState列表(分页)")
    @ApiResponses({
            @ApiResponse(code = 200, response = WxLoginStateResult.class, message = "WxLoginState列表"),
            @ApiResponse(code = 1002, response = String.class, message = "字段校验错误"),
            @ApiResponse(code = 500, response = String.class, message = "服务器错误")
    })
    @ApiImplicitParams({
        @ApiImplicitParam(name = "recId" , paramType = "query"),
        @ApiImplicitParam(name = "openId" , paramType = "query"),
        @ApiImplicitParam(name = "unionId" , paramType = "query"),
        @ApiImplicitParam(name = "token" , paramType = "query"),
        @ApiImplicitParam(name = "status" , paramType = "query"),
        @ApiImplicitParam(name = "statusDesc" , paramType = "query")    })
	@RequestMapping(value = "/v1/wxLoginState",method = RequestMethod.GET)
	public ResponseEntity list(PageInfo pageInfo, @Validated(Search.class) WxLoginStateParam param, BindingResult bindingResult) {
        try {
	        //验证失败
	        if (bindingResult.hasErrors()) {
	            throw new ValidException(bindingResult.getFieldError().getDefaultMessage());
	        }
	        int totalNum = wxLoginStateService.count(param.getModel());
	        preparePageInfo(pageInfo, totalNum);
	        List<WxLoginState> models = wxLoginStateService.list(param.getModel(),pageInfo);
	        List<WxLoginStateResult> results = models.stream().map(it -> new WxLoginStateResult(it)).collect(Collectors.toList());
	        Map<String, Object> map = new HashMap();
            map.put("wxLoginStateList", results);
            map.put("totalNum", totalNum);
	        return ResponseEntity.ok(map);
        } catch (BusinessException e) {
	        logger.error("list WxLoginState Error!", e);
	        return ResponseEntity.status(CommonConstants.SERVER_ERROR).body(Result.error(e));
        } catch (Exception e) {
	        logger.error("list WxLoginState Error!", e);
	        return ResponseEntity.status(CommonConstants.SERVER_ERROR)
		.body(Result.error(CommonConstants.SERVER_ERROR, e.getMessage()));
        }
	}

	@ApiOperation(value = "根据主键查询WxLoginState详情")
    @ApiResponses({
            @ApiResponse(code = 200, response = WxLoginStateResult.class, message = "WxLoginState对象"),
            @ApiResponse(code = 500, response = String.class, message = "服务器错误")
    })
    @RequestMapping(value = "/v1/wxLoginState/{recId}",method = RequestMethod.GET)
    public ResponseEntity get(@PathVariable("recId") String recId){
        try {
            WxLoginState wxLoginState = wxLoginStateService.find(recId);
            return ResponseEntity.ok(new WxLoginStateResult(wxLoginState));
        } catch (BusinessException e) {
            logger.error("get WxLoginState Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR).body(Result.error(e));
        } catch (Exception e) {
            logger.error("get WxLoginState Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR)
        .body(Result.error(CommonConstants.SERVER_ERROR, e.getMessage()));
        }
    }

	@ApiOperation(value = "创建WxLoginState")
    @ApiResponses({
            @ApiResponse(code = 200, response = String.class, message = "主键"),
            @ApiResponse(code = 1002, response = String.class, message = "字段校验错误"),
            @ApiResponse(code = 500, response = String.class, message = "服务器错误")
    })
    @RequestMapping(value = "/v1/wxLoginState", method = RequestMethod.POST)
    public ResponseEntity create(@RequestBody @Validated(Create.class) WxLoginStateParam param, BindingResult bindingResult) {
        try {
            //验证失败
            if (bindingResult.hasErrors()) {
                throw new ValidException(bindingResult.getFieldError().getDefaultMessage());
            }
            User user = UserContext.getUser();
            //todo 根据角色判断权限

	        WxLoginState model = param.getModel();
            String recId = wxLoginStateService.create(model);
            return ResponseEntity.ok(recId);
        } catch (BusinessException e) {
            logger.error("create WxLoginState Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR).body(Result.error(e));
        } catch (Exception e) {
            logger.error("create WxLoginState Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR)
        .body(Result.error(CommonConstants.SERVER_ERROR, e.getMessage()));
        }
    }

	@ApiOperation(value = "根据主键删除WxLoginState")
    @ApiResponses({
            @ApiResponse(code = 200, response = Integer.class, message = "删除数量"),
            @ApiResponse(code = 500, response = String.class, message = "服务器错误")
    })
	@RequestMapping(value = "/v1/wxLoginState/{recId}",method = RequestMethod.DELETE)
	public ResponseEntity delete(@PathVariable("recId") String recId){
        try {
            User user = UserContext.getUser();
            //todo 根据角色判断权限

			Integer num = wxLoginStateService.delete(recId,user.getRecId());
            return ResponseEntity.ok(num);
        } catch (BusinessException e) {
            logger.error("delete WxLoginState Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR).body(Result.error(e));
        } catch (Exception e) {
            logger.error("delete WxLoginState Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR)
        .body(Result.error(CommonConstants.SERVER_ERROR, e.getMessage()));
        }
    }

	@ApiOperation(value = "根据主键更新WxLoginState")
    @ApiResponses({
            @ApiResponse(code = 200, response = Integer.class, message = "更新数量"),
            @ApiResponse(code = 1002, response = String.class, message = "字段校验错误"),
            @ApiResponse(code = 500, response = String.class, message = "服务器错误")
    })
	@RequestMapping(value = "/v1/wxLoginState/{recId}", method = RequestMethod.PUT)
    public ResponseEntity update(@PathVariable("recId") String recId, @RequestBody @Validated(Update.class) WxLoginStateParam param, BindingResult bindingResult){
        try {
	        //验证失败
	        if (bindingResult.hasErrors()) {
	            throw new ValidException(bindingResult.getFieldError().getDefaultMessage());
	        }
            User user = UserContext.getUser();
            //todo 根据角色判断权限

	        WxLoginState model = param.getModel();
	        model.setRecId(recId);
	        Integer num = wxLoginStateService.update(model);
	        return ResponseEntity.ok(num);
        } catch (BusinessException e) {
	        logger.error("update WxLoginState Error!", e);
	        return ResponseEntity.status(CommonConstants.SERVER_ERROR).body(Result.error(e));
        } catch (Exception e) {
	        logger.error("update WxLoginState Error!", e);
	        return ResponseEntity.status(CommonConstants.SERVER_ERROR)
        .body(Result.error(CommonConstants.SERVER_ERROR, e.getMessage()));
        }
	}

}