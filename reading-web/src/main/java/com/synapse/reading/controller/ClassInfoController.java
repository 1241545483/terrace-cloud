package com.synapse.reading.controller;

import com.synapse.common.constants.PageInfo;
import com.synapse.common.trans.Result;
import com.synapse.common.sso.context.UserContext;
import com.synapse.common.sso.model.User;
import com.synapse.reading.dto.param.JoinClassParam;
import com.synapse.reading.dto.param.SelectTaskParam;
import com.synapse.reading.model.ClassInfo;
import com.synapse.reading.dto.param.ClassInfoParam;
import com.synapse.reading.dto.result.ClassInfoResult;
import com.synapse.reading.service.ClassInfoService;
import com.synapse.reading.web.valid.group.Update;
import com.synapse.reading.web.valid.group.Create;
import com.synapse.reading.web.valid.group.Search;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.synapse.common.exception.BusinessException;
import com.synapse.reading.exception.common.ValidException;
import org.springframework.validation.BindingResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.synapse.reading.constants.CommonConstants;
import org.springframework.validation.annotation.Validated;
import com.synapse.reading.controller.BaseController;

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
@Api(tags = "ClassInfoController")
@RestController
@RequestMapping("/reading")
public class ClassInfoController extends BaseController{

    private Logger logger = LoggerFactory.getLogger(ClassInfoController.class);

    @Autowired
    private ClassInfoService classInfoService;

	@ApiOperation(value = "查询ClassInfo列表(分页)")
    @ApiResponses({
            @ApiResponse(code = 200, response = ClassInfoResult.class, message = "ClassInfo列表"),
            @ApiResponse(code = 1002, response = String.class, message = "字段校验错误"),
            @ApiResponse(code = 500, response = String.class, message = "服务器错误")
    })
    @ApiImplicitParams({
        @ApiImplicitParam(name = "recId" , paramType = "query"),
        @ApiImplicitParam(name = "classCode" , paramType = "query"),
        @ApiImplicitParam(name = "intro" , paramType = "query"),
        @ApiImplicitParam(name = "qrCode" , paramType = "query"),
        @ApiImplicitParam(name = "cover" , paramType = "query"),
        @ApiImplicitParam(name = "status" , paramType = "query"),
        @ApiImplicitParam(name = "createId" , paramType = "query"),
        @ApiImplicitParam(name = "createTime" , paramType = "query"),
        @ApiImplicitParam(name = "updateId" , paramType = "query"),
        @ApiImplicitParam(name = "updateTime" , paramType = "query")    })
	@RequestMapping(value = "/v1/classInfo",method = RequestMethod.GET)
	public ResponseEntity list(PageInfo pageInfo, @Validated(Search.class) ClassInfoParam param, BindingResult bindingResult) {
        try {
	        //验证失败
	        if (bindingResult.hasErrors()) {
	            throw new ValidException(bindingResult.getFieldError().getDefaultMessage());
	        }
	        int totalNum = classInfoService.count(param.getModel());
	        preparePageInfo(pageInfo, totalNum);
	        List<ClassInfo> models = classInfoService.list(param.getModel(),pageInfo);
	        List<ClassInfoResult> results = models.stream().map(it -> new ClassInfoResult(it)).collect(Collectors.toList());
	        Map<String, Object> map = new HashMap();
            map.put("classInfoList", results);
            map.put("totalNum", totalNum);
	        return ResponseEntity.ok(map);
        } catch (BusinessException e) {
	        logger.error("list ClassInfo Error!", e);
	        return ResponseEntity.status(CommonConstants.SERVER_ERROR).body(Result.error(e));
        } catch (Exception e) {
	        logger.error("list ClassInfo Error!", e);
	        return ResponseEntity.status(CommonConstants.SERVER_ERROR)
		.body(Result.error(CommonConstants.SERVER_ERROR, e.getMessage()));
        }
	}

    @ApiOperation(value = "查询ClassInfo列表(分页,老师自己创建的列表)")
    @ApiResponses({
            @ApiResponse(code = 200, response = ClassInfoResult.class, message = "ClassInfo列表"),
            @ApiResponse(code = 1002, response = String.class, message = "字段校验错误"),
            @ApiResponse(code = 500, response = String.class, message = "服务器错误")
    })
    @RequestMapping(value = "/v1/classInfo/teacher/{userId}",method = RequestMethod.GET)
    public ResponseEntity listByTeacher(PageInfo pageInfo,  @PathVariable("userId")String userId, BindingResult bindingResult) {
        try {
            //验证失败
            if (bindingResult.hasErrors()) {
                throw new ValidException(bindingResult.getFieldError().getDefaultMessage());
            }
            int totalNum = classInfoService.countByTeacherCreate(userId);
            preparePageInfo(pageInfo, totalNum);
            List<ClassInfoResult> results = classInfoService.listByTeacherCreate(userId,pageInfo);
//            List<ClassInfoResult> results = models.stream().map(it -> new ClassInfoResult(it)).collect(Collectors.toList());
            Map<String, Object> map = new HashMap();
            map.put("classInfoList", results);
            map.put("totalNum", totalNum);
            return ResponseEntity.ok(map);
        } catch (BusinessException e) {
            logger.error("list ClassInfo Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR).body(Result.error(e));
        } catch (Exception e) {
            logger.error("list ClassInfo Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR)
                    .body(Result.error(CommonConstants.SERVER_ERROR, e.getMessage()));
        }
    }

    @ApiOperation(value = "查询ClassInfo列表(分页,支持查询老师，班级模糊查询)")
    @ApiResponses({
            @ApiResponse(code = 200, response = ClassInfoResult.class, message = "ClassInfo列表"),
            @ApiResponse(code = 1002, response = String.class, message = "字段校验错误"),
            @ApiResponse(code = 500, response = String.class, message = "服务器错误")
    })
    @RequestMapping(value = "/v1/classInfo/teacher",method = RequestMethod.GET)
    public ResponseEntity listByClass(String startTime,String endTime,String teacherId) {
        try {

            List<ClassInfoResult> results = classInfoService.listByClass(startTime,endTime,teacherId);
//            List<ClassInfoResult> results = models.stream().map(it -> new ClassInfoResult(it)).collect(Collectors.toList());
            Map<String, Object> map = new HashMap();
            map.put("classInfoList", results);
            return ResponseEntity.ok(map);
        } catch (BusinessException e) {
            logger.error("list ClassInfo Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR).body(Result.error(e));
        } catch (Exception e) {
            logger.error("list ClassInfo Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR)
                    .body(Result.error(CommonConstants.SERVER_ERROR, e.getMessage()));
        }
    }


    @ApiOperation(value = "查询ClassInfo列表(分页,学生参加的列表)")
    @ApiResponses({
            @ApiResponse(code = 200, response = ClassInfoResult.class, message = "ClassInfo列表"),
            @ApiResponse(code = 1002, response = String.class, message = "字段校验错误"),
            @ApiResponse(code = 500, response = String.class, message = "服务器错误")
    })
    @RequestMapping(value = "/v1/classInfo/student/{userId}",method = RequestMethod.GET)
    public ResponseEntity listByStudent(PageInfo pageInfo,  @PathVariable("userId")String userId, BindingResult bindingResult) {
        try {
            //验证失败
            if (bindingResult.hasErrors()) {
                throw new ValidException(bindingResult.getFieldError().getDefaultMessage());
            }
            int totalNum = classInfoService.countByStudentJoin(userId);
            preparePageInfo(pageInfo, totalNum);
            List<ClassInfoResult> results = classInfoService.listByStudentJoin(userId,pageInfo);
//            List<ClassInfoResult> results = models.stream().map(it -> new ClassInfoResult(it)).collect(Collectors.toList());
            Map<String, Object> map = new HashMap();
            map.put("classInfoList", results);
            map.put("totalNum", totalNum);
            return ResponseEntity.ok(map);
        } catch (BusinessException e) {
            logger.error("list ClassInfo Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR).body(Result.error(e));
        } catch (Exception e) {
            logger.error("list ClassInfo Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR)
                    .body(Result.error(CommonConstants.SERVER_ERROR, e.getMessage()));
        }
    }


	@ApiOperation(value = "根据主键查询ClassInfo详情")
    @ApiResponses({
            @ApiResponse(code = 200, response = ClassInfoResult.class, message = "ClassInfo对象"),
            @ApiResponse(code = 500, response = String.class, message = "服务器错误")
    })
    @RequestMapping(value = "/v1/classInfo/{recId}",method = RequestMethod.GET)
    public ResponseEntity get(@PathVariable("recId") String recId){
        try {
            ClassInfo classInfo = classInfoService.find(recId);
            return ResponseEntity.ok(new ClassInfoResult(classInfo));
        } catch (BusinessException e) {
            logger.error("get ClassInfo Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR).body(Result.error(e));
        } catch (Exception e) {
            logger.error("get ClassInfo Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR)
        .body(Result.error(CommonConstants.SERVER_ERROR, e.getMessage()));
        }
    }

	@ApiOperation(value = "创建ClassInfo")
    @ApiResponses({
            @ApiResponse(code = 200, response = String.class, message = "主键"),
            @ApiResponse(code = 1002, response = String.class, message = "字段校验错误"),
            @ApiResponse(code = 500, response = String.class, message = "服务器错误")
    })
    @RequestMapping(value = "/v1/classInfo", method = RequestMethod.POST)
    public ResponseEntity create(@RequestBody @Validated(Create.class) ClassInfoParam param, BindingResult bindingResult) {
        try {
            //验证失败
            if (bindingResult.hasErrors()) {
                throw new ValidException(bindingResult.getFieldError().getDefaultMessage());
            }
            User user = UserContext.getUser();
            //todo 根据角色判断权限

	        ClassInfo model = param.getModel();
                model.setCreateId(user.getRecId());
                model.setUpdateId(user.getRecId());
            String recId = classInfoService.create(model);
            return ResponseEntity.ok(recId);
        } catch (BusinessException e) {
            logger.error("create ClassInfo Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR).body(Result.error(e));
        } catch (Exception e) {
            logger.error("create ClassInfo Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR)
        .body(Result.error(CommonConstants.SERVER_ERROR, e.getMessage()));
        }
    }


    @ApiOperation(value = "将学生添加进班级")
    @ApiResponses({
            @ApiResponse(code = 200, response = String.class, message = "主键"),
            @ApiResponse(code = 1002, response = String.class, message = "字段校验错误"),
            @ApiResponse(code = 500, response = String.class, message = "服务器错误")
    })
    @RequestMapping(value = "/v1/ClassStudentInfo", method = RequestMethod.POST)
    public ResponseEntity createClassStudent(@RequestBody JoinClassParam joinClassParam) {
        try {
            User user = UserContext.getUser();
            //todo 根据角色判断权限
            String recId = classInfoService.createClassStudent(joinClassParam.getClassCode(),joinClassParam.getStudentId(),joinClassParam.getRealName());
            return ResponseEntity.ok(recId);
        } catch (BusinessException e) {
            logger.error("create ClassInfo Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR).body(Result.error(e));
        } catch (Exception e) {
            logger.error("create ClassInfo Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR)
                    .body(Result.error(CommonConstants.SERVER_ERROR, e.getMessage()));
        }
    }


    @ApiOperation(value = "根据班级码查询班级")
    @ApiResponses({
            @ApiResponse(code = 200, response = ClassInfoResult.class, message = "ClassInfo对象"),
            @ApiResponse(code = 500, response = String.class, message = "服务器错误")
    })
    @RequestMapping(value = "/v1/classInfo/classCode/{classCode}",method = RequestMethod.GET)
    public ResponseEntity getByClassCode(@PathVariable("classCode") String classCode){
        try {
            ClassInfoResult classInfo = classInfoService.getByClassCode(classCode);
            return ResponseEntity.ok(classInfo);
        } catch (BusinessException e) {
            logger.error("get ClassInfo Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR).body(Result.error(e));
        } catch (Exception e) {
            logger.error("get ClassInfo Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR)
                    .body(Result.error(CommonConstants.SERVER_ERROR, e.getMessage()));
        }
    }


	@ApiOperation(value = "根据主键删除ClassInfo")
    @ApiResponses({
            @ApiResponse(code = 200, response = Integer.class, message = "删除数量"),
            @ApiResponse(code = 500, response = String.class, message = "服务器错误")
    })
	@RequestMapping(value = "/v1/classInfo/{recId}",method = RequestMethod.DELETE)
	public ResponseEntity delete(@PathVariable("recId") String recId){
        try {
            User user = UserContext.getUser();
            //todo 根据角色判断权限

			Integer num = classInfoService.delete(recId,user.getRecId());
            return ResponseEntity.ok(num);
        } catch (BusinessException e) {
            logger.error("delete ClassInfo Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR).body(Result.error(e));
        } catch (Exception e) {
            logger.error("delete ClassInfo Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR)
        .body(Result.error(CommonConstants.SERVER_ERROR, e.getMessage()));
        }
    }

	@ApiOperation(value = "根据主键更新ClassInfo")
    @ApiResponses({
            @ApiResponse(code = 200, response = Integer.class, message = "更新数量"),
            @ApiResponse(code = 1002, response = String.class, message = "字段校验错误"),
            @ApiResponse(code = 500, response = String.class, message = "服务器错误")
    })
	@RequestMapping(value = "/v1/classInfo/{recId}", method = RequestMethod.PUT)
    public ResponseEntity update(@PathVariable("recId") String recId, @RequestBody @Validated(Update.class) ClassInfoParam param, BindingResult bindingResult){
        try {
	        //验证失败
	        if (bindingResult.hasErrors()) {
	            throw new ValidException(bindingResult.getFieldError().getDefaultMessage());
	        }
            User user = UserContext.getUser();
            //todo 根据角色判断权限

	        ClassInfo model = param.getModel();
	        model.setRecId(recId);
            model.setUpdateId(user.getRecId());
	        Integer num = classInfoService.update(model);
	        return ResponseEntity.ok(num);
        } catch (BusinessException e) {
	        logger.error("update ClassInfo Error!", e);
	        return ResponseEntity.status(CommonConstants.SERVER_ERROR).body(Result.error(e));
        } catch (Exception e) {
	        logger.error("update ClassInfo Error!", e);
	        return ResponseEntity.status(CommonConstants.SERVER_ERROR)
        .body(Result.error(CommonConstants.SERVER_ERROR, e.getMessage()));
        }
	}




}