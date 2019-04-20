package com.synapse.reading.controller;

import com.google.gson.Gson;
import com.synapse.common.constants.PageInfo;
import com.synapse.common.trans.Result;
import com.synapse.common.sso.context.UserContext;
import com.synapse.common.sso.model.User;
import com.synapse.reading.constants.MemberConstants;
import com.synapse.reading.constants.TradeOrderConstants;
import com.synapse.reading.constants.TradeOrderDetailConstants;
import com.synapse.reading.dto.result.ApiResponseResult;
import com.synapse.reading.model.ExcelRowModel;
import com.synapse.reading.model.Member;
import com.synapse.reading.dto.param.MemberParam;
import com.synapse.reading.dto.result.MemberResult;
import com.synapse.reading.model.TradeOrder;
import com.synapse.reading.model.TradeOrderDetail;
import com.synapse.reading.remote.UserService;
import com.synapse.reading.service.ExcelImportService;
import com.synapse.reading.service.MemberService;
import com.synapse.reading.service.TradeOrderDetailService;
import com.synapse.reading.service.TradeOrderService;
import com.synapse.reading.web.valid.group.Update;
import com.synapse.reading.web.valid.group.Create;
import com.synapse.reading.web.valid.group.Search;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import net.logstash.logback.encoder.org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * <p>
 * 用户信息 Controller
 * </p>
 *
 * @author liuguangfu
 * @since 2018-12-06
 */
@Api(tags = "MemberController")
@RestController
@RequestMapping("/reading")
public class MemberController extends BaseController {

    private Logger logger = LoggerFactory.getLogger(MemberController.class);

    @Autowired
    private MemberService memberService;

    @Autowired
    ExcelImportService excelImportService;
    @Autowired
    private UserService userService;
    @Autowired
    private TradeOrderDetailService tradeOrderDetailService;
    @Autowired
    private TradeOrderService tradeOrderService;


    @ApiOperation(value = "查询Member列表(分页)")
    @ApiResponses({
            @ApiResponse(code = 200, response = MemberResult.class, message = "Member列表"),
            @ApiResponse(code = 1002, response = String.class, message = "字段校验错误"),
            @ApiResponse(code = 500, response = String.class, message = "服务器错误")
    })
    @RequestMapping(value = "/v1/member", method = RequestMethod.GET)
    public ResponseEntity list(PageInfo pageInfo, @Validated(Search.class) MemberParam param, BindingResult bindingResult) {
        try {
            //验证失败
            if (bindingResult.hasErrors()) {
                throw new ValidException(bindingResult.getFieldError().getDefaultMessage());
            }
            int totalNum = memberService.count(param.getModel());
            preparePageInfo(pageInfo, totalNum);
            List<Member> models = memberService.list(param.getModel(), pageInfo);
            List<MemberResult> results = models.stream().map(it -> new MemberResult(it)).collect(Collectors.toList());
            Map<String, Object> map = new HashMap();
            map.put("memberList", results);
            map.put("totalNum", totalNum);
            return ResponseEntity.ok(map);
        } catch (BusinessException e) {
            logger.error("list Member Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR).body(Result.error(e));
        } catch (Exception e) {
            logger.error("list Member Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR)
                    .body(Result.error(CommonConstants.SERVER_ERROR, e.getMessage()));
        }
    }

    @ApiOperation(value = "根据主键查询Member详情")
    @ApiResponses({
            @ApiResponse(code = 200, response = MemberResult.class, message = "Member对象"),
            @ApiResponse(code = 500, response = String.class, message = "服务器错误")
    })
    @RequestMapping(value = "/v1/member/{recId}", method = RequestMethod.GET)
    public ResponseEntity get(@PathVariable("recId") String recId) {
        try {
            Member member = memberService.find(recId);
            return ResponseEntity.ok(new MemberResult(member));
        } catch (BusinessException e) {
            logger.error("get Member Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR).body(Result.error(e));
        } catch (Exception e) {
            logger.error("get Member Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR)
                    .body(Result.error(CommonConstants.SERVER_ERROR, e.getMessage()));
        }
    }

    @ApiOperation(value = "创建Member")
    @ApiResponses({
            @ApiResponse(code = 200, response = String.class, message = "主键"),
            @ApiResponse(code = 1002, response = String.class, message = "字段校验错误"),
            @ApiResponse(code = 500, response = String.class, message = "服务器错误")
    })

    @RequestMapping(value = "/v1/member", method = RequestMethod.POST)
    public ResponseEntity create(@RequestBody @Validated(Create.class) MemberParam param, BindingResult bindingResult) {
        try {
            //验证失败
            if (bindingResult.hasErrors()) {
                throw new ValidException(bindingResult.getFieldError().getDefaultMessage());
            }
            User user = UserContext.getUser();
            //todo 根据角色判断权限

            Member model = param.getModel();
            model.setCreateId(user.getRecId());
            model.setUpdateId(user.getRecId());
            String recId = memberService.create(model);
            return ResponseEntity.ok(recId);
        } catch (BusinessException e) {
            logger.error("create Member Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR).body(Result.error(e));
        } catch (Exception e) {
            logger.error("create Member Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR)
                    .body(Result.error(CommonConstants.SERVER_ERROR, e.getMessage()));
        }
    }

    @ApiOperation(value = "创建Member")
    @ApiResponses({
            @ApiResponse(code = 200, response = String.class, message = "主键"),
            @ApiResponse(code = 1002, response = String.class, message = "字段校验错误"),
            @ApiResponse(code = 500, response = String.class, message = "服务器错误")
    })
    @RequestMapping(value = "/v1/member/createByUserId", method = RequestMethod.POST)
    public ResponseEntity createByUserId(@RequestBody @Validated(Create.class) MemberParam param, BindingResult bindingResult) {
        try {
            //验证失败
            if (bindingResult.hasErrors()) {
                throw new ValidException(bindingResult.getFieldError().getDefaultMessage());
            }
            User user = UserContext.getUser();
            //todo 根据角色判断权限

            Member model = param.getModel();
            model.setCreateId(user.getRecId());
            model.setUpdateId(user.getRecId());
            String recId = memberService.createByUserId(model, user);
            return ResponseEntity.ok(recId);
        } catch (BusinessException e) {
            logger.error("create Member Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR).body(Result.error(e));
        } catch (Exception e) {
            logger.error("create Member Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR)
                    .body(Result.error(CommonConstants.SERVER_ERROR, e.getMessage()));
        }
    }

    @ApiOperation(value = "返回用户id")
    @ApiResponses({
            @ApiResponse(code = 200, response = String.class, message = "用户id"),
            @ApiResponse(code = 1002, response = String.class, message = "字段校验错误"),
            @ApiResponse(code = 500, response = String.class, message = "服务器错误")
    })
    @RequestMapping(value = "/v1/member/userId", method = RequestMethod.GET)
    public ResponseEntity userId() {
        try {

            User user = UserContext.getUser();
            return ResponseEntity.ok(user.getRecId());
        } catch (BusinessException e) {
            logger.error("create Member Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR).body(Result.error(e));
        } catch (Exception e) {
            logger.error("create Member Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR)
                    .body(Result.error(CommonConstants.SERVER_ERROR, e.getMessage()));
        }
    }


    @ApiOperation(value = "根据主键删除Member")
    @ApiResponses({
            @ApiResponse(code = 200, response = Integer.class, message = "删除数量"),
            @ApiResponse(code = 500, response = String.class, message = "服务器错误")
    })
    @RequestMapping(value = "/v1/member/{recId}", method = RequestMethod.DELETE)
    public ResponseEntity delete(@PathVariable("recId") String recId) {
        try {
            User user = UserContext.getUser();
            //todo 根据角色判断权限

            Integer num = memberService.delete(recId);
            return ResponseEntity.ok(num);
        } catch (BusinessException e) {
            logger.error("delete Member Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR).body(Result.error(e));
        } catch (Exception e) {
            logger.error("delete Member Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR)
                    .body(Result.error(CommonConstants.SERVER_ERROR, e.getMessage()));
        }
    }

    @ApiOperation(value = "根据主键删除Member(校管理员操作)")
    @ApiResponses({
            @ApiResponse(code = 200, response = Integer.class, message = "删除数量"),
            @ApiResponse(code = 500, response = String.class, message = "服务器错误")
    })
    @RequestMapping(value = "/v1/member/admin/{recId}", method = RequestMethod.DELETE)
    public ResponseEntity deleteByMember(@PathVariable("recId") String recId) {
        try {
            User user = UserContext.getUser();
            //todo 根据角色判断权限
            Member member = memberService.getMember(recId);
            member.setOrganization(MemberConstants.ORG.DEFAULT.num());
            memberService.update(member);
            userService.modifyUserOrg(recId, MemberConstants.ORG.DEFAULT.num(), member.getName(), member.getMobile(), member.getMobile(), member.getIdCard(), member.getIdCard());
            TradeOrder tradeOrder = tradeOrderService.findByBuyId(recId);
            TradeOrderDetail tradeOrderDetail = tradeOrderDetailService.findByTradeOrder(tradeOrder.getRecId());
            tradeOrder.setStatus(TradeOrderConstants.STATUS.DELETED.num());
            Integer num1 = tradeOrderService.update(tradeOrder);
            tradeOrderDetail.setStatus(TradeOrderDetailConstants.STATUS.DELETED.num());
            Integer num2 = tradeOrderDetailService.update(tradeOrderDetail);
            return ResponseEntity.ok(num2);
        } catch (BusinessException e) {
            logger.error("delete Member Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR).body(Result.error(e));
        } catch (Exception e) {
            logger.error("delete Member Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR)
                    .body(Result.error(CommonConstants.SERVER_ERROR, e.getMessage()));
        }
    }

    @ApiOperation(value = "增加用户积分")
    @ApiResponses({
            @ApiResponse(code = 200, response = Integer.class, message = "更新数量"),
            @ApiResponse(code = 1002, response = String.class, message = "字段校验错误"),
            @ApiResponse(code = 500, response = String.class, message = "服务器错误")
    })
    @RequestMapping(value = "/v1/member/addPoint/{point}", method = RequestMethod.PUT)
    public ResponseEntity addPoint(@PathVariable("point") Integer point) {
        try {

            User user = UserContext.getUser();
            //todo 根据角色判断权限

            boolean valid = memberService.addPoint(user, point);
            return ResponseEntity.ok(valid);
        } catch (BusinessException e) {
            logger.error("update Member Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR).body(Result.error(e));
        } catch (Exception e) {
            logger.error("update Member Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR)
                    .body(Result.error(CommonConstants.SERVER_ERROR, e.getMessage()));
        }
    }

    @ApiOperation(value = "根据主键更新Member")
    @ApiResponses({
            @ApiResponse(code = 200, response = Integer.class, message = "更新数量"),
            @ApiResponse(code = 1002, response = String.class, message = "字段校验错误"),
            @ApiResponse(code = 500, response = String.class, message = "服务器错误")
    })
    @RequestMapping(value = "/v1/member/{recId}", method = RequestMethod.PUT)
    public ResponseEntity update(@PathVariable("recId") String recId, @RequestBody @Validated(Update.class) MemberParam param, BindingResult bindingResult) {
        try {
            //验证失败
            if (bindingResult.hasErrors()) {
                throw new ValidException(bindingResult.getFieldError().getDefaultMessage());
            }
            User user = UserContext.getUser();
            //todo 根据角色判断权限

            Member model = param.getModel();
            model.setUserId(recId);
            model.setUpdateId(user.getRecId());
            Integer num = memberService.update(model);
            return ResponseEntity.ok(num);
        } catch (BusinessException e) {
            logger.error("update Member Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR).body(Result.error(e));
        } catch (Exception e) {
            logger.error("update Member Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR)
                    .body(Result.error(CommonConstants.SERVER_ERROR, e.getMessage()));
        }
    }

    /**
     * excel导入老师信息
     *
     * @param excelUrl
     * @return
     */
    @ApiOperation(value = "excel导入老师信息")
    @ApiResponses({
            @ApiResponse(code = 200, response = Integer.class, message = "导入学员"),
            @ApiResponse(code = 1002, response = String.class, message = "字段校验错误"),
            @ApiResponse(code = 500, response = String.class, message = "服务器错误")
    })
    @RequestMapping(value = "/v1/teacher/import_members", method = RequestMethod.GET)
    public ResponseEntity addTeacherMembers(String excelUrl) {
        if (!org.apache.commons.lang3.StringUtils.isEmpty(excelUrl)) {
            excelUrl = excelUrl.split(".tmp")[0];
        }
        Map<String, Object> importResult = new HashMap<String, Object>();
        List<Member> successImport = new ArrayList<>();

        List<ExcelRowModel> errorInfo = new ArrayList<>();

        try {
            //获取登录的学校负责人的学校信息
            User currentUser = UserContext.getUser();
            if (currentUser == null || StringUtils.trimToEmpty(currentUser.getRecId()).equals("")) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("未登录");
            }
            //登录人为校方负责人，他为学员导入报名，这些学员的学校就和校方负责人的学校一致
//            Long schoolLeaderId = Long.parseLong(currentUser.getRecId());
            Member schoolLeaderMember = memberService.find(currentUser.getRecId());
            if (schoolLeaderMember == null) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("导入权限的管理员无组织信息");
            }

            String organization = currentUser.getGroupId();

            Map<String, List<ExcelRowModel>> result = excelImportService.excelAnalysis(excelUrl);
            if (result == null) {
                return ResponseEntity.ok(new ApiResponseResult("1002", "excel读取异常", excelUrl));
            }
            errorInfo = result.get("error_info");

            //执行导入用户的操作
            memberService.doExcelImport(successImport, currentUser, organization, result, MemberConstants.ROLE.TEACHER.num());

        } catch (Exception e) {
            logger.error("导入数据失败!", e);
            return ResponseEntity.ok(new ApiResponseResult("1002", "excel读取失败", e.getMessage()));
        }
        List<MemberResult> successImportModels = successImport.stream().map(it -> new MemberResult(it)).collect(Collectors.toList());
//        List<MemberResult> successImportModels = Converter.convert(successImport, Member.class);
        importResult.put("successNum", successImport.size());
        importResult.put("successList", successImportModels);
        importResult.put("failureNum", errorInfo.size());
        importResult.put("failureList", errorInfo);
        return ResponseEntity.ok(importResult);

    }


    /**
     * excel导入学生信息
     *
     * @param excelUrl
     * @return
     */
    @ApiOperation(value = "excel导入学生信息")
    @ApiResponses({
            @ApiResponse(code = 200, response = Integer.class, message = "导入学员"),
            @ApiResponse(code = 1002, response = String.class, message = "字段校验错误"),
            @ApiResponse(code = 500, response = String.class, message = "服务器错误")
    })
    @RequestMapping(value = "/v1/student/import_members", method = RequestMethod.GET)
    public ResponseEntity addStudentMembers(String excelUrl) {
        if (!org.apache.commons.lang3.StringUtils.isEmpty(excelUrl)) {
            excelUrl = excelUrl.split(".tmp")[0];
        }
        Map<String, Object> importResult = new HashMap<String, Object>();
        List<Member> successImport = new ArrayList<>();

        List<ExcelRowModel> errorInfo = new ArrayList<>();

        try {
            //获取登录的学校负责人的学校信息
            User currentUser = UserContext.getUser();
            if (currentUser == null || StringUtils.trimToEmpty(currentUser.getRecId()).equals("")) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("未登录");
            }
            //登录人为校方负责人，他为学员导入报名，这些学员的学校就和校方负责人的学校一致
//            Long schoolLeaderId = Long.parseLong(currentUser.getRecId());
            Member schoolLeaderMember = memberService.find(currentUser.getRecId());
            if (schoolLeaderMember == null) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("导入权限的管理员无组织信息");
            }

            String organization = currentUser.getGroupId();

            Map<String, List<ExcelRowModel>> result = excelImportService.excelAnalysis(excelUrl);
            if (result == null) {
                return ResponseEntity.ok(new ApiResponseResult("1002", "excel读取异常", excelUrl));
            }
            errorInfo = result.get("error_info");

            //执行导入用户的操作
            memberService.doExcelImport(successImport, currentUser, organization, result, MemberConstants.ROLE.STUDENT.num());

        } catch (Exception e) {
            logger.error("导入数据失败!", e);
            return ResponseEntity.ok(new ApiResponseResult("1002", "excel读取失败", e.getMessage()));
        }
        List<MemberResult> successImportModels = successImport.stream().map(it -> new MemberResult(it)).collect(Collectors.toList());
//        List<MemberResult> successImportModels = Converter.convert(successImport, Member.class);
        importResult.put("successNum", successImport.size());
        importResult.put("successList", successImportModels);
        importResult.put("failureNum", errorInfo.size());
        importResult.put("failureList", errorInfo);
        return ResponseEntity.ok(importResult);

    }


    /**
     * 新增一个老师信息
     *
     * @return
     */
    @ApiOperation(value = "新增一个老师信息")
    @ApiResponses({
            @ApiResponse(code = 200, response = Integer.class, message = "导入教师"),
            @ApiResponse(code = 1002, response = String.class, message = "字段校验错误"),
            @ApiResponse(code = 500, response = String.class, message = "服务器错误")
    })
    @RequestMapping(value = "/v1/member/teacher/add_one", method = RequestMethod.POST)
    public ResponseEntity addTeacherMember(@Validated(Create.class) @RequestBody MemberParam param, BindingResult bindingResult, String type) {
        User user = UserContext.getUser();
        if (user == null) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("未登录");
        }
        if (param == null) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("缺少学员信息");
        }
        try {
            Member member = memberService.addMember(user, type, param,MemberConstants.ROLETYPE.READ_TEACHER.value());
            memberService.create(member);
            //如果是专家则增加专家的关系信息
//            if (type.length() > 0) {
//                memberService.addMemberRelation(type, member.getUserId());
//            }
            Map<String, String> map = new HashMap<>();
            map.put("memberId", member.getUserId() == null ? "" : String.valueOf(member.getUserId()));
            return ResponseEntity.ok(map);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("新增失败");
        }
    }

    /**
     * 新增一个学生信息
     *
     * @return
     */
    @ApiOperation(value = "新增一个学生信息")
    @ApiResponses({
            @ApiResponse(code = 200, response = Integer.class, message = "导入学生"),
            @ApiResponse(code = 1002, response = String.class, message = "字段校验错误"),
            @ApiResponse(code = 500, response = String.class, message = "服务器错误")
    })
    @RequestMapping(value = "/v1/member/student/add_one", method = RequestMethod.POST)
    public ResponseEntity addStudentMember(@Validated(Create.class) @RequestBody MemberParam param, BindingResult bindingResult, String type) {
        User user = UserContext.getUser();
        if (user == null) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("未登录");
        }
        if (param == null) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("缺少学员信息");
        }
        try {
            Member member = memberService.addMember(user, type, param,MemberConstants.ROLETYPE.READ_STUDENT.value());
            memberService.create(member);
            //如果是专家则增加专家的关系信息
//            if (type.length() > 0) {
//                memberService.addMemberRelation(type, member.getUserId());
//            }
            Map<String, String> map = new HashMap<>();
            map.put("memberId", member.getUserId() == null ? "" : String.valueOf(member.getUserId()));
            return ResponseEntity.ok(map);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("新增失败");
        }
    }

    /**
     * 更新学员信息
     *
     * @param
     * @return
     */
    @ApiOperation(value = "更新学员信息")
    @ApiResponses({
            @ApiResponse(code = 200, response = Integer.class, message = "更新学员信息"),
            @ApiResponse(code = 1002, response = String.class, message = "字段校验错误"),
            @ApiResponse(code = 500, response = String.class, message = "服务器错误")
    })
    @RequestMapping(value = "/v1/member/add_one", method = RequestMethod.PUT)
    public ResponseEntity updateMember(@RequestBody @Validated(Search.class) MemberParam param, BindingResult bindingResult) {
        Gson gson = new Gson();
        User user = UserContext.getUser();
        if (user == null) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("未登录");
        }

        if (user.getRecId() == null) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("缺少学员信息主键");
        }
        try {
            memberService.update(param.getModel());
            Map<String, String> map = new HashMap<>();
            map.put("memberId", param.getModel().getUserId() == null ? "" : String.valueOf(param.getModel().getUserId()));
            return ResponseEntity.ok(map);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("修改失败");
        }

    }

    @ApiOperation(value = "查询老师Member列表(分页)")
    @ApiResponses({
            @ApiResponse(code = 200, response = MemberResult.class, message = "Member列表"),
            @ApiResponse(code = 1002, response = String.class, message = "字段校验错误"),
            @ApiResponse(code = 500, response = String.class, message = "服务器错误")
    })
    @RequestMapping(value = "/v1/member/teacher", method = RequestMethod.GET)
    public ResponseEntity listTeacher(PageInfo pageInfo, @Validated(Search.class) MemberParam param, BindingResult bindingResult) {
        try {
            //验证失败
            if (bindingResult.hasErrors()) {
                throw new ValidException(bindingResult.getFieldError().getDefaultMessage());
            }
            param.getModel().setRole(MemberConstants.ROLE.TEACHER.num());
            int totalNum = memberService.count(param.getModel());
            preparePageInfo(pageInfo, totalNum);
            List<Member> models = memberService.list(param.getModel(), pageInfo);
            List<MemberResult> results = models.stream().map(it -> new MemberResult(it)).collect(Collectors.toList());
            Map<String, Object> map = new HashMap();
            map.put("memberList", results);
            map.put("totalNum", totalNum);
            return ResponseEntity.ok(map);
        } catch (BusinessException e) {
            logger.error("list Member Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR).body(Result.error(e));
        } catch (Exception e) {
            logger.error("list Member Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR)
                    .body(Result.error(CommonConstants.SERVER_ERROR, e.getMessage()));
        }
    }


    @ApiOperation(value = "查询学生Member列表(分页)")
    @ApiResponses({
            @ApiResponse(code = 200, response = MemberResult.class, message = "Member列表"),
            @ApiResponse(code = 1002, response = String.class, message = "字段校验错误"),
            @ApiResponse(code = 500, response = String.class, message = "服务器错误")
    })
    @RequestMapping(value = "/v1/member/student", method = RequestMethod.GET)
    public ResponseEntity listStudent(PageInfo pageInfo, @Validated(Search.class) MemberParam param, BindingResult bindingResult) {
        try {
            //验证失败
            if (bindingResult.hasErrors()) {
                throw new ValidException(bindingResult.getFieldError().getDefaultMessage());
            }
            param.getModel().setRole(MemberConstants.ROLE.STUDENT.num());
            int totalNum = memberService.count(param.getModel());
            preparePageInfo(pageInfo, totalNum);
            List<Member> models = memberService.list(param.getModel(), pageInfo);
            List<MemberResult> results = models.stream().map(it -> new MemberResult(it)).collect(Collectors.toList());
            Map<String, Object> map = new HashMap();
            map.put("memberList", results);
            map.put("totalNum", totalNum);
            return ResponseEntity.ok(map);
        } catch (BusinessException e) {
            logger.error("list Member Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR).body(Result.error(e));
        } catch (Exception e) {
            logger.error("list Member Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR)
                    .body(Result.error(CommonConstants.SERVER_ERROR, e.getMessage()));
        }
    }


}