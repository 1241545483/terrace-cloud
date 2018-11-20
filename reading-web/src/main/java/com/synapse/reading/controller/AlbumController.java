package com.synapse.reading.controller;

import com.synapse.common.constants.PageInfo;
import com.synapse.common.trans.Result;
import com.synapse.common.sso.context.UserContext;
import com.synapse.common.sso.model.User;
import com.synapse.reading.model.Album;
import com.synapse.reading.dto.param.AlbumParam;
import com.synapse.reading.dto.result.AlbumResult;
import com.synapse.reading.service.AlbumService;
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
@Api(tags = "AlbumController")
@RestController
@RequestMapping("/reading")
public class AlbumController extends BaseController{

    private Logger logger = LoggerFactory.getLogger(AlbumController.class);

    @Autowired
    private AlbumService albumService;

	@ApiOperation(value = "查询Album列表(分页)")
    @ApiResponses({
            @ApiResponse(code = 200, response = AlbumResult.class, message = "Album列表"),
            @ApiResponse(code = 1002, response = String.class, message = "字段校验错误"),
            @ApiResponse(code = 500, response = String.class, message = "服务器错误")
    })
	@RequestMapping(value = "/v1/album",method = RequestMethod.GET)
	public Result list(PageInfo pageInfo, @Validated(Search.class) AlbumParam param, BindingResult bindingResult) {
        try {
	        //验证失败
	        if (bindingResult.hasErrors()) {
	            throw new ValidException(bindingResult.getFieldError().getDefaultMessage());
	        }
	        int totalNum = albumService.count(param.getModel());
	        preparePageInfo(pageInfo, totalNum);
	        List<Album> models = albumService.list(param.getModel(),pageInfo);
	        List<AlbumResult> results = models.stream().map(it -> new AlbumResult(it)).collect(Collectors.toList());
	        Map<String, Object> map = new HashMap();
            map.put("albumList", results);
            map.put("totalNum", totalNum);
	        return Result.ok(map);
        } catch (BusinessException e) {
	        logger.error("list Album Error!", e);
	        return Result.error(e);
        } catch (Exception e) {
	        logger.error("list Album Error!", e);
	        return Result.error(CommonConstants.SERVER_ERROR, e.getMessage());
        }
	}

	@ApiOperation(value = "根据主键查询Album详情")
    @ApiResponses({
            @ApiResponse(code = 200, response = AlbumResult.class, message = "Album对象"),
            @ApiResponse(code = 500, response = String.class, message = "服务器错误")
    })
    @RequestMapping(value = "/v1/album/{recId}",method = RequestMethod.GET)
    public Result get(@PathVariable("recId") String recId){
        try {
            Album album = albumService.find(recId);
            return Result.ok(new AlbumResult(album));
        } catch (BusinessException e) {
            logger.error("get Album Error!", e);
            return Result.error(e);
        } catch (Exception e) {
            logger.error("get Album Error!", e);
            return Result.error(CommonConstants.SERVER_ERROR, e.getMessage());
        }
    }

	@ApiOperation(value = "创建Album")
    @ApiResponses({
            @ApiResponse(code = 200, response = String.class, message = "主键"),
            @ApiResponse(code = 1002, response = String.class, message = "字段校验错误"),
            @ApiResponse(code = 500, response = String.class, message = "服务器错误")
    })
    @RequestMapping(value = "/v1/album", method = RequestMethod.POST)
    public Result create(@RequestBody @Validated(Create.class) AlbumParam param, BindingResult bindingResult) {
        try {
            //验证失败
            if (bindingResult.hasErrors()) {
                throw new ValidException(bindingResult.getFieldError().getDefaultMessage());
            }
            User user = UserContext.getUser();
            //todo 根据角色判断权限

	        Album model = param.getModel();
                model.setCreateId(user.getRecId());
                model.setUpdateId(user.getRecId());
            String recId = albumService.create(model);
            return Result.ok(recId);
        } catch (BusinessException e) {
            logger.error("create Album Error!", e);
            return Result.error(e);
        } catch (Exception e) {
            logger.error("create Album Error!", e);
            return Result.error(CommonConstants.SERVER_ERROR, e.getMessage());
        }
    }

	@ApiOperation(value = "根据主键删除Album")
    @ApiResponses({
            @ApiResponse(code = 200, response = Integer.class, message = "删除数量"),
            @ApiResponse(code = 500, response = String.class, message = "服务器错误")
    })
	@RequestMapping(value = "/v1/album/{recId}",method = RequestMethod.DELETE)
	public Result delete(@PathVariable("recId") String recId){
        try {
            User user = UserContext.getUser();
            //todo 根据角色判断权限

			Integer num = albumService.delete(recId,user.getRecId());
            return Result.ok(num);
        } catch (BusinessException e) {
            logger.error("delete Album Error!", e);
            return Result.error(e);
        } catch (Exception e) {
            logger.error("delete Album Error!", e);
            return Result.error(CommonConstants.SERVER_ERROR, e.getMessage());
        }
    }

	@ApiOperation(value = "根据主键更新Album")
    @ApiResponses({
            @ApiResponse(code = 200, response = Integer.class, message = "更新数量"),
            @ApiResponse(code = 1002, response = String.class, message = "字段校验错误"),
            @ApiResponse(code = 500, response = String.class, message = "服务器错误")
    })
	@RequestMapping(value = "/v1/album/{recId}", method = RequestMethod.PUT)
    public Result update(@PathVariable("recId") String recId, @RequestBody @Validated(Update.class) AlbumParam param, BindingResult bindingResult){
        try {
	        //验证失败
	        if (bindingResult.hasErrors()) {
	            throw new ValidException(bindingResult.getFieldError().getDefaultMessage());
	        }
            User user = UserContext.getUser();
            //todo 根据角色判断权限

	        Album model = param.getModel();
	        model.setRecId(recId);
            model.setUpdateId(user.getRecId());
	        Integer num = albumService.update(model);
	        return Result.ok(num);
        } catch (BusinessException e) {
	        logger.error("update Album Error!", e);
	        return Result.error(e);
        } catch (Exception e) {
	        logger.error("update Album Error!", e);
	        return Result.error(CommonConstants.SERVER_ERROR, e.getMessage());
        }
	}

}