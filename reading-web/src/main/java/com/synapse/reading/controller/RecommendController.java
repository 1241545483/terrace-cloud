package com.synapse.reading.controller;

import com.synapse.common.constants.PageInfo;
import com.synapse.common.trans.Result;
import com.synapse.common.sso.context.UserContext;
import com.synapse.common.sso.model.User;
import com.synapse.reading.model.BaseSystemParameter;
import com.synapse.reading.model.Book;
import com.synapse.reading.model.CatItem;
import com.synapse.reading.model.Recommend;
import com.synapse.reading.dto.param.RecommendParam;
import com.synapse.reading.dto.result.RecommendResult;
import com.synapse.reading.service.RecommendService;
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
import com.synapse.reading.controller.BaseController;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * <p>
 * 推荐 Controller
 * </p>
 * @author liuguangfu
 * @since 2019-01-25
 */
@Api(tags = "RecommendController")
@RestController
@RequestMapping("/reading")
public class RecommendController extends BaseController{

    private Logger logger = LoggerFactory.getLogger(RecommendController.class);

    @Autowired
    private RecommendService recommendService;

	@ApiOperation(value = "查询Recommend列表(分页)")
    @ApiResponses({
            @ApiResponse(code = 200, response = RecommendResult.class, message = "Recommend列表"),
            @ApiResponse(code = 1002, response = String.class, message = "字段校验错误"),
            @ApiResponse(code = 500, response = String.class, message = "服务器错误")
    })
    @ApiImplicitParams({
        @ApiImplicitParam(name = "recId" , paramType = "query"),
        @ApiImplicitParam(name = "recommendType" , paramType = "query"),
        @ApiImplicitParam(name = "recommendId" , paramType = "query"),
        @ApiImplicitParam(name = "level" , paramType = "query"),
        @ApiImplicitParam(name = "menu" , paramType = "query"),
        @ApiImplicitParam(name = "createId" , paramType = "query"),
        @ApiImplicitParam(name = "createTime" , paramType = "query"),
        @ApiImplicitParam(name = "startTime" , paramType = "query"),
        @ApiImplicitParam(name = "endTime" , paramType = "query")    })
	@RequestMapping(value = "/v1/recommend",method = RequestMethod.GET)
	public ResponseEntity list(PageInfo pageInfo, @Validated(Search.class) RecommendParam param, BindingResult bindingResult) {
        try {
	        //验证失败
	        if (bindingResult.hasErrors()) {
	            throw new ValidException(bindingResult.getFieldError().getDefaultMessage());
	        }
	        int totalNum = recommendService.count(param.getModel());
	        preparePageInfo(pageInfo, totalNum);
	        List<Recommend> models = recommendService.list(param.getModel(),pageInfo);
	        List<RecommendResult> results = models.stream().map(it -> new RecommendResult(it)).collect(Collectors.toList());
	        Map<String, Object> map = new HashMap();
            map.put("recommendList", results);
            map.put("totalNum", totalNum);
	        return ResponseEntity.ok(map);
        } catch (BusinessException e) {
	        logger.error("list Recommend Error!", e);
	        return ResponseEntity.status(CommonConstants.SERVER_ERROR).body(Result.error(e));
        } catch (Exception e) {
	        logger.error("list Recommend Error!", e);
	        return ResponseEntity.status(CommonConstants.SERVER_ERROR)
		.body(Result.error(CommonConstants.SERVER_ERROR, e.getMessage()));
        }
	}

	@ApiOperation(value = "根据主键查询Recommend详情")
    @ApiResponses({
            @ApiResponse(code = 200, response = RecommendResult.class, message = "Recommend对象"),
            @ApiResponse(code = 500, response = String.class, message = "服务器错误")
    })
    @RequestMapping(value = "/v1/recommend/{recId}",method = RequestMethod.GET)
    public ResponseEntity get(@PathVariable("recId") String recId){
        try {
            Recommend recommend = recommendService.find(recId);
            return ResponseEntity.ok(new RecommendResult(recommend));
        } catch (BusinessException e) {
            logger.error("get Recommend Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR).body(Result.error(e));
        } catch (Exception e) {
            logger.error("get Recommend Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR)
        .body(Result.error(CommonConstants.SERVER_ERROR, e.getMessage()));
        }
    }

	@ApiOperation(value = "创建Recommend")
    @ApiResponses({
            @ApiResponse(code = 200, response = String.class, message = "主键"),
            @ApiResponse(code = 1002, response = String.class, message = "字段校验错误"),
            @ApiResponse(code = 500, response = String.class, message = "服务器错误")
    })
    @RequestMapping(value = "/v1/recommend", method = RequestMethod.POST)
    public ResponseEntity create(@RequestBody @Validated(Create.class) RecommendParam param, BindingResult bindingResult) {
        try {
            //验证失败
            if (bindingResult.hasErrors()) {
                throw new ValidException(bindingResult.getFieldError().getDefaultMessage());
            }
            User user = UserContext.getUser();
            //todo 根据角色判断权限

	        Recommend model = param.getModel();
                model.setCreateId(user.getRecId());
            String recId = recommendService.create(model);
            return ResponseEntity.ok(recId);
        } catch (BusinessException e) {
            logger.error("create Recommend Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR).body(Result.error(e));
        } catch (Exception e) {
            logger.error("create Recommend Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR)
        .body(Result.error(CommonConstants.SERVER_ERROR, e.getMessage()));
        }
    }

	@ApiOperation(value = "根据主键删除Recommend")
    @ApiResponses({
            @ApiResponse(code = 200, response = Integer.class, message = "删除数量"),
            @ApiResponse(code = 500, response = String.class, message = "服务器错误")
    })
	@RequestMapping(value = "/v1/recommend/{recId}",method = RequestMethod.DELETE)
	public ResponseEntity delete(@PathVariable("recId") String recId){
        try {
            User user = UserContext.getUser();
            //todo 根据角色判断权限

			Integer num = recommendService.delete(recId);
            return ResponseEntity.ok(num);
        } catch (BusinessException e) {
            logger.error("delete Recommend Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR).body(Result.error(e));
        } catch (Exception e) {
            logger.error("delete Recommend Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR)
        .body(Result.error(CommonConstants.SERVER_ERROR, e.getMessage()));
        }
    }


    @ApiOperation(value = "查询推荐")
    @ApiResponses({
            @ApiResponse(code = 200, response = Integer.class, message = "推荐列表"),
            @ApiResponse(code = 500, response = String.class, message = "服务器错误")
    })
    @RequestMapping(value = "/v1/selectByRecommendType/{recommendType}",method = RequestMethod.GET)
    public ResponseEntity selectByRecommendType(@PathVariable("recommendType") String recommendType,String menu){
        try {
            User user = UserContext.getUser();
            //todo 根据角色判断权限
            List<Book> book = recommendService.selectByRecommendType(recommendType,menu);
            return ResponseEntity.ok(book);
        } catch (BusinessException e) {
            logger.error("selectByRecommendType Recommend Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR).body(Result.error(e));
        } catch (Exception e) {
            logger.error("selectByRecommendType Recommend Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR)
                    .body(Result.error(CommonConstants.SERVER_ERROR, e.getMessage()));
        }
    }


    @ApiOperation(value = "查询所有可推荐的栏目")
    @ApiResponses({
            @ApiResponse(code = 200, response = Integer.class, message = "栏目列表"),
            @ApiResponse(code = 500, response = String.class, message = "服务器错误")
    })
    @RequestMapping(value = "/v1/recommendMeun",method = RequestMethod.GET)
    public ResponseEntity selectRecommendMeun(){
        try {
            List<BaseSystemParameter> baseSystemParameters = recommendService.selectRecommendMeun();
            return ResponseEntity.ok(baseSystemParameters);
        } catch (BusinessException e) {
            logger.error("select recommendMeun Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR).body(Result.error(e));
        } catch (Exception e) {
            logger.error("select recommendMeun Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR)
                    .body(Result.error(CommonConstants.SERVER_ERROR, e.getMessage()));
        }
    }




    @ApiOperation(value = "根据主键更新Recommend")
    @ApiResponses({
            @ApiResponse(code = 200, response = Integer.class, message = "更新数量"),
            @ApiResponse(code = 1002, response = String.class, message = "字段校验错误"),
            @ApiResponse(code = 500, response = String.class, message = "服务器错误")
    })
	@RequestMapping(value = "/v1/recommend/{recId}", method = RequestMethod.PUT)
    public ResponseEntity update(@PathVariable("recId") String recId, @RequestBody @Validated(Update.class) RecommendParam param, BindingResult bindingResult){
        try {
	        //验证失败
	        if (bindingResult.hasErrors()) {
	            throw new ValidException(bindingResult.getFieldError().getDefaultMessage());
	        }
            User user = UserContext.getUser();
            //todo 根据角色判断权限

	        Recommend model = param.getModel();
	        model.setRecId(recId);
	        Integer num = recommendService.update(model);
	        return ResponseEntity.ok(num);
        } catch (BusinessException e) {
	        logger.error("update Recommend Error!", e);
	        return ResponseEntity.status(CommonConstants.SERVER_ERROR).body(Result.error(e));
        } catch (Exception e) {
	        logger.error("update Recommend Error!", e);
	        return ResponseEntity.status(CommonConstants.SERVER_ERROR)
        .body(Result.error(CommonConstants.SERVER_ERROR, e.getMessage()));
        }
	}

    @ApiOperation(value = "查询教育部推荐书目")
    @ApiResponses({
            @ApiResponse(code = 200, response = Integer.class, message = "推荐列表"),
            @ApiResponse(code = 500, response = String.class, message = "服务器错误")
    })
    @RequestMapping(value = "/v1/selectByRecommend/{recommendType}",method = RequestMethod.GET)
    public ResponseEntity selectByRecommend(@PathVariable("recommendType") String recommendType,String menu){
        try {
            User user = UserContext.getUser();
            //todo 根据角色判断权限

            List<CatItem> booklist = recommendService.selectByRecommend(recommendType,menu);
            return ResponseEntity.ok(booklist);
        } catch (BusinessException e) {
            logger.error("selectByRecommendType Recommend Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR).body(Result.error(e));
        } catch (Exception e) {
            logger.error("selectByRecommendType Recommend Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR)
                    .body(Result.error(CommonConstants.SERVER_ERROR, e.getMessage()));
        }
    }






}