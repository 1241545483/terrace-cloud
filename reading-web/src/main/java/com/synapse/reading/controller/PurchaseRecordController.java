package com.synapse.reading.controller;

import com.synapse.common.constants.PageInfo;
import com.synapse.common.trans.Result;
import com.synapse.common.sso.context.UserContext;
import com.synapse.common.sso.model.User;
import com.synapse.reading.model.PurchaseRecord;
import com.synapse.reading.dto.param.PurchaseRecordParam;
import com.synapse.reading.dto.result.PurchaseRecordResult;
import com.synapse.reading.service.PurchaseRecordService;
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

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * <p>
 * 购买记录 Controller
 * </p>
 * @author liuguangfu
 * @since 2019-04-09
 */
@Api(tags = "PurchaseRecordController")
@RestController
@RequestMapping("/reading")
public class PurchaseRecordController extends BaseController{

    private Logger logger = LoggerFactory.getLogger(PurchaseRecordController.class);

    @Autowired
    private PurchaseRecordService purchaseRecordService;

	@ApiOperation(value = "查询PurchaseRecord列表(分页)")
    @ApiResponses({
            @ApiResponse(code = 200, response = PurchaseRecordResult.class, message = "PurchaseRecord列表"),
            @ApiResponse(code = 1002, response = String.class, message = "字段校验错误"),
            @ApiResponse(code = 500, response = String.class, message = "服务器错误")
    })
    @ApiImplicitParams({
        @ApiImplicitParam(name = "recId" , paramType = "query"),
        @ApiImplicitParam(name = "userId" , paramType = "query"),
        @ApiImplicitParam(name = "lessonId" , paramType = "query"),
        @ApiImplicitParam(name = "price" , paramType = "query"),
        @ApiImplicitParam(name = "payWay" , paramType = "query"),
        @ApiImplicitParam(name = "operations" , paramType = "query"),
        @ApiImplicitParam(name = "createId" , paramType = "query"),
        @ApiImplicitParam(name = "createTime" , paramType = "query")    })
	@RequestMapping(value = "/v1/purchaseRecord",method = RequestMethod.GET)
	public ResponseEntity list(PageInfo pageInfo, @Validated(Search.class) PurchaseRecordParam param, BindingResult bindingResult) {
        try {
	        //验证失败
	        if (bindingResult.hasErrors()) {
	            throw new ValidException(bindingResult.getFieldError().getDefaultMessage());
	        }
	        int totalNum = purchaseRecordService.count(param.getModel());
	        preparePageInfo(pageInfo, totalNum);
	        List<PurchaseRecord> models = purchaseRecordService.list(param.getModel(),pageInfo);
	        List<PurchaseRecordResult> results = models.stream().map(it -> new PurchaseRecordResult(it)).collect(Collectors.toList());
	        Map<String, Object> map = new HashMap();
            map.put("purchaseRecordList", results);
            map.put("totalNum", totalNum);
	        return ResponseEntity.ok(map);
        } catch (BusinessException e) {
	        logger.error("list PurchaseRecord Error!", e);
	        return ResponseEntity.status(CommonConstants.SERVER_ERROR).body(Result.error(e));
        } catch (Exception e) {
	        logger.error("list PurchaseRecord Error!", e);
	        return ResponseEntity.status(CommonConstants.SERVER_ERROR)
		.body(Result.error(CommonConstants.SERVER_ERROR, e.getMessage()));
        }
	}

	@ApiOperation(value = "根据主键查询PurchaseRecord详情")
    @ApiResponses({
            @ApiResponse(code = 200, response = PurchaseRecordResult.class, message = "PurchaseRecord对象"),
            @ApiResponse(code = 500, response = String.class, message = "服务器错误")
    })
    @RequestMapping(value = "/v1/purchaseRecord/{recId}",method = RequestMethod.GET)
    public ResponseEntity get(@PathVariable("recId") String recId){
        try {
            PurchaseRecord purchaseRecord = purchaseRecordService.find(recId);
            return ResponseEntity.ok(new PurchaseRecordResult(purchaseRecord));
        } catch (BusinessException e) {
            logger.error("get PurchaseRecord Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR).body(Result.error(e));
        } catch (Exception e) {
            logger.error("get PurchaseRecord Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR)
        .body(Result.error(CommonConstants.SERVER_ERROR, e.getMessage()));
        }
    }


    @ApiOperation(value = "根据课程id和用户判断出是否购买过该课程")
    @ApiResponses({
            @ApiResponse(code = 200, response = PurchaseRecordResult.class, message = "PurchaseRecord对象"),
            @ApiResponse(code = 500, response = String.class, message = "服务器错误")
    })
    @RequestMapping(value = "/v1/purchaseRecord/pay/{lessonId}",method = RequestMethod.GET)
    public ResponseEntity getPurchaseRecord(@PathVariable("lessonId") String lessonId){
        try {
            User user = UserContext.getUser();
            PurchaseRecord purchaseRecord = purchaseRecordService.findPay(lessonId,user);
            return ResponseEntity.ok(new PurchaseRecordResult(purchaseRecord));
        } catch (BusinessException e) {
            logger.error("get PurchaseRecord Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR).body(Result.error(e));
        } catch (Exception e) {
            logger.error("get PurchaseRecord Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR)
                    .body(Result.error(CommonConstants.SERVER_ERROR, e.getMessage()));
        }
    }


	@ApiOperation(value = "创建PurchaseRecord")
    @ApiResponses({
            @ApiResponse(code = 200, response = String.class, message = "主键"),
            @ApiResponse(code = 1002, response = String.class, message = "字段校验错误"),
            @ApiResponse(code = 500, response = String.class, message = "服务器错误")
    })
    @RequestMapping(value = "/v1/purchaseRecord", method = RequestMethod.POST)
    public ResponseEntity create(@RequestBody @Validated(Create.class) PurchaseRecordParam param, BindingResult bindingResult) {
        try {
            //验证失败
            if (bindingResult.hasErrors()) {
                throw new ValidException(bindingResult.getFieldError().getDefaultMessage());
            }
            User user = UserContext.getUser();
            //todo 根据角色判断权限

	        PurchaseRecord model = param.getModel();
                model.setCreateId(user.getRecId());
            String recId = purchaseRecordService.create(model);
            return ResponseEntity.ok(recId);
        } catch (BusinessException e) {
            logger.error("create PurchaseRecord Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR).body(Result.error(e));
        } catch (Exception e) {
            logger.error("create PurchaseRecord Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR)
        .body(Result.error(CommonConstants.SERVER_ERROR, e.getMessage()));
        }
    }

	@ApiOperation(value = "根据主键删除PurchaseRecord")
    @ApiResponses({
            @ApiResponse(code = 200, response = Integer.class, message = "删除数量"),
            @ApiResponse(code = 500, response = String.class, message = "服务器错误")
    })
	@RequestMapping(value = "/v1/purchaseRecord/{recId}",method = RequestMethod.DELETE)
	public ResponseEntity delete(@PathVariable("recId") String recId){
        try {
            User user = UserContext.getUser();
            //todo 根据角色判断权限

			Integer num = purchaseRecordService.delete(recId);
            return ResponseEntity.ok(num);
        } catch (BusinessException e) {
            logger.error("delete PurchaseRecord Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR).body(Result.error(e));
        } catch (Exception e) {
            logger.error("delete PurchaseRecord Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR)
        .body(Result.error(CommonConstants.SERVER_ERROR, e.getMessage()));
        }
    }

	@ApiOperation(value = "根据主键更新PurchaseRecord")
    @ApiResponses({
            @ApiResponse(code = 200, response = Integer.class, message = "更新数量"),
            @ApiResponse(code = 1002, response = String.class, message = "字段校验错误"),
            @ApiResponse(code = 500, response = String.class, message = "服务器错误")
    })
	@RequestMapping(value = "/v1/purchaseRecord/{recId}", method = RequestMethod.PUT)
    public ResponseEntity update(@PathVariable("recId") String recId, @RequestBody @Validated(Update.class) PurchaseRecordParam param, BindingResult bindingResult){
        try {
	        //验证失败
	        if (bindingResult.hasErrors()) {
	            throw new ValidException(bindingResult.getFieldError().getDefaultMessage());
	        }
            User user = UserContext.getUser();
            //todo 根据角色判断权限

	        PurchaseRecord model = param.getModel();
	        model.setRecId(recId);
	        Integer num = purchaseRecordService.update(model);
	        return ResponseEntity.ok(num);
        } catch (BusinessException e) {
	        logger.error("update PurchaseRecord Error!", e);
	        return ResponseEntity.status(CommonConstants.SERVER_ERROR).body(Result.error(e));
        } catch (Exception e) {
	        logger.error("update PurchaseRecord Error!", e);
	        return ResponseEntity.status(CommonConstants.SERVER_ERROR)
        .body(Result.error(CommonConstants.SERVER_ERROR, e.getMessage()));
        }
	}

}