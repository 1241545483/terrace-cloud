package com.synapse.reading.controller.controllor;

import com.synapse.common.constants.PageInfo;
import com.synapse.common.trans.Result;
import com.synapse.common.sso.context.UserContext;
import com.synapse.common.sso.model.User;
import com.synapse.reading.controller.BaseController;
import com.synapse.reading.model.model.Organization;
import com.synapse.reading.dto.param.param.OrganizationParam;
import com.synapse.reading.dto.result.result.OrganizationResult;
import com.synapse.reading.service.service.OrganizationService;
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
 * 组织机构 Controller
 * </p>
 * @author liuguangfu
 * @since 2019-05-28
 */
@Api(tags = "OrganizationController")
@RestController
@RequestMapping("/reading")
public class OrganizationController extends BaseController {

    private Logger logger = LoggerFactory.getLogger(OrganizationController.class);

    @Autowired
    private OrganizationService organizationService;

	@ApiOperation(value = "查询Organization列表(分页)")
    @ApiResponses({
            @ApiResponse(code = 200, response = OrganizationResult.class, message = "Organization列表"),
            @ApiResponse(code = 1002, response = String.class, message = "字段校验错误"),
            @ApiResponse(code = 500, response = String.class, message = "服务器错误")
    })
    @ApiImplicitParams({
        @ApiImplicitParam(name = "orgId" , paramType = "query"),
        @ApiImplicitParam(name = "orgName" , paramType = "query"),
        @ApiImplicitParam(name = "status" , paramType = "query"),
        @ApiImplicitParam(name = "orgNature" , paramType = "query"),
        @ApiImplicitParam(name = "parentOrgId" , paramType = "query"),
        @ApiImplicitParam(name = "orgLocation" , paramType = "query"),
        @ApiImplicitParam(name = "createId" , paramType = "query"),
        @ApiImplicitParam(name = "createTime" , paramType = "query"),
        @ApiImplicitParam(name = "updateId" , paramType = "query"),
        @ApiImplicitParam(name = "updateTime" , paramType = "query")    })
	@RequestMapping(value = "/v1/organization",method = RequestMethod.GET)
	public ResponseEntity list(PageInfo pageInfo, @Validated(Search.class) OrganizationParam param, BindingResult bindingResult) {
        try {
	        //验证失败
	        if (bindingResult.hasErrors()) {
	            throw new ValidException(bindingResult.getFieldError().getDefaultMessage());
	        }
	        int totalNum = organizationService.count(param.getModel());
	        preparePageInfo(pageInfo, totalNum);
	        List<Organization> models = organizationService.list(param.getModel(),pageInfo);
	        List<OrganizationResult> results = models.stream().map(it -> new OrganizationResult(it)).collect(Collectors.toList());
	        Map<String, Object> map = new HashMap();
            map.put("organizationList", results);
            map.put("totalNum", totalNum);
	        return ResponseEntity.ok(map);
        } catch (BusinessException e) {
	        logger.error("list Organization Error!", e);
	        return ResponseEntity.status(CommonConstants.SERVER_ERROR).body(Result.error(e));
        } catch (Exception e) {
	        logger.error("list Organization Error!", e);
	        return ResponseEntity.status(CommonConstants.SERVER_ERROR)
		.body(Result.error(CommonConstants.SERVER_ERROR, e.getMessage()));
        }
	}

	@ApiOperation(value = "根据主键查询Organization详情")
    @ApiResponses({
            @ApiResponse(code = 200, response = OrganizationResult.class, message = "Organization对象"),
            @ApiResponse(code = 500, response = String.class, message = "服务器错误")
    })
    @RequestMapping(value = "/v1/organization/{recId}",method = RequestMethod.GET)
    public ResponseEntity get(@PathVariable("recId") String recId){
        try {
            Organization organization = organizationService.find(recId);
            return ResponseEntity.ok(new OrganizationResult(organization));
        } catch (BusinessException e) {
            logger.error("get Organization Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR).body(Result.error(e));
        } catch (Exception e) {
            logger.error("get Organization Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR)
        .body(Result.error(CommonConstants.SERVER_ERROR, e.getMessage()));
        }
    }

	@ApiOperation(value = "创建Organization")
    @ApiResponses({
            @ApiResponse(code = 200, response = String.class, message = "主键"),
            @ApiResponse(code = 1002, response = String.class, message = "字段校验错误"),
            @ApiResponse(code = 500, response = String.class, message = "服务器错误")
    })
    @RequestMapping(value = "/v1/organization", method = RequestMethod.POST)
    public ResponseEntity create(@RequestBody @Validated(Create.class) OrganizationParam param, BindingResult bindingResult) {
        try {
            //验证失败
            if (bindingResult.hasErrors()) {
                throw new ValidException(bindingResult.getFieldError().getDefaultMessage());
            }
            User user = UserContext.getUser();
            //todo 根据角色判断权限

	        Organization model = param.getModel();
                model.setCreateId(user.getRecId());
                model.setUpdateId(user.getRecId());
            String recId = organizationService.create(model);
            return ResponseEntity.ok(recId);
        } catch (BusinessException e) {
            logger.error("create Organization Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR).body(Result.error(e));
        } catch (Exception e) {
            logger.error("create Organization Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR)
        .body(Result.error(CommonConstants.SERVER_ERROR, e.getMessage()));
        }
    }

	@ApiOperation(value = "根据主键删除Organization")
    @ApiResponses({
            @ApiResponse(code = 200, response = Integer.class, message = "删除数量"),
            @ApiResponse(code = 500, response = String.class, message = "服务器错误")
    })
	@RequestMapping(value = "/v1/organization/{recId}",method = RequestMethod.DELETE)
	public ResponseEntity delete(@PathVariable("recId") String recId){
        try {
            User user = UserContext.getUser();
            //todo 根据角色判断权限

			Integer num = organizationService.delete(recId,user.getRecId());
            return ResponseEntity.ok(num);
        } catch (BusinessException e) {
            logger.error("delete Organization Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR).body(Result.error(e));
        } catch (Exception e) {
            logger.error("delete Organization Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR)
        .body(Result.error(CommonConstants.SERVER_ERROR, e.getMessage()));
        }
    }

	@ApiOperation(value = "根据主键更新Organization")
    @ApiResponses({
            @ApiResponse(code = 200, response = Integer.class, message = "更新数量"),
            @ApiResponse(code = 1002, response = String.class, message = "字段校验错误"),
            @ApiResponse(code = 500, response = String.class, message = "服务器错误")
    })
	@RequestMapping(value = "/v1/organization/{recId}", method = RequestMethod.PUT)
    public ResponseEntity update(@PathVariable("recId") String recId, @RequestBody @Validated(Update.class) OrganizationParam param, BindingResult bindingResult){
        try {
	        //验证失败
	        if (bindingResult.hasErrors()) {
	            throw new ValidException(bindingResult.getFieldError().getDefaultMessage());
	        }
            User user = UserContext.getUser();
            //todo 根据角色判断权限

	        Organization model = param.getModel();
	        model.setRecId(recId);
            model.setUpdateId(user.getRecId());
	        Integer num = organizationService.update(model);
	        return ResponseEntity.ok(num);
        } catch (BusinessException e) {
	        logger.error("update Organization Error!", e);
	        return ResponseEntity.status(CommonConstants.SERVER_ERROR).body(Result.error(e));
        } catch (Exception e) {
	        logger.error("update Organization Error!", e);
	        return ResponseEntity.status(CommonConstants.SERVER_ERROR)
        .body(Result.error(CommonConstants.SERVER_ERROR, e.getMessage()));
        }
	}

}