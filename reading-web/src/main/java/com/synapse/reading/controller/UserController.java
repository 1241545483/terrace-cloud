package com.synapse.reading.controller;

import com.synapse.common.constants.PageInfo;
import com.synapse.common.exception.BusinessException;
import com.synapse.common.sso.context.UserContext;
import com.synapse.common.sso.model.User;
import com.synapse.common.trans.Result;
import com.synapse.reading.constants.CommonConstants;
import com.synapse.reading.constants.UserConstants;
import com.synapse.reading.dto.param.MemberParam;
import com.synapse.reading.dto.result.MemberResult;
import com.synapse.reading.exception.common.NotLoginException;
import com.synapse.reading.exception.common.ValidException;
import com.synapse.reading.model.Member;
import com.synapse.reading.remote.UserService;
import com.synapse.reading.service.MemberService;
import com.synapse.reading.web.valid.group.Search;
import com.synapse.reading.web.valid.group.Update;
import com.synapse.welcome.model.OrgModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 用户相关接口
 * 阅读超级管理员对学校管理的相关接口（创建校管理员等），校管理员对班级管理的的相关接口（创建老师账号等），以及老师对班级学生管理相关接口
 */
@Api(tags = "UserController")
@RestController("userControllerV1")
@RequestMapping("/reading")
public class UserController {

    private static Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private MemberService memberService;
    @Autowired
    private UserService userService;

    @ApiOperation("返回当前登录用户信息")
    @ApiResponses({
            @ApiResponse(code = 200, response = com.synapse.common.sso.model.User.class, message = "当前登录用户信息"),
            @ApiResponse(code = 1001, response = String.class, message = "用户未登录"),
            @ApiResponse(code = 500, response = String.class, message = "服务器错误")
    })
    @GetMapping("/v1/currentUser")
    public Result currentUser() {
        try {
            User user = UserContext.getUser();
            Member member = memberService.getMember(user.getRecId());
            logger.info("---------------------20190520ueserId"+user.getRecId());
            if (user == null||user.getRecId().equals(UserConstants.UNLOGINID.UNLOGIN.num())) {
                throw new NotLoginException();
            }
            if (member != null && member.getName() != null && !"".equals(member.getName())) {
                user.setUsername(member.getName());
            }
            return Result.ok(user);
        } catch (BusinessException e) {
            logger.error("Get CurrentUser Error!", e);
            return Result.error(e);
        } catch (Exception e) {
            logger.error("Get CurrentUser Error!", e);
            return Result.error(CommonConstants.SERVER_ERROR, e.getMessage());
        }
    }

    @ApiOperation("新增机构")
    @ApiResponses({
            @ApiResponse(code = 200, response = com.synapse.common.sso.model.User.class, message = "新增机构的ID"),
            @ApiResponse(code = 1001, response = String.class, message = "用户未登录"),
            @ApiResponse(code = 500, response = String.class, message = "服务器错误")
    })
    @GetMapping("/v1/addorg")
    public Result addorg(String pId, String name, String phase) {
        try {
            String orgId = userService.addOrg(pId, name, phase);
            return Result.ok(orgId);
        } catch (BusinessException e) {
            logger.error(" addorg Error!", e);
            return Result.error(e);
        } catch (Exception e) {
            logger.error(" addorg Error!", e);
            return Result.error(CommonConstants.SERVER_ERROR, e.getMessage());
        }
    }

    @ApiOperation("新增班级")
    @ApiResponses({
            @ApiResponse(code = 200, response = com.synapse.common.sso.model.User.class, message = "新增班级的ID"),
            @ApiResponse(code = 1001, response = String.class, message = "用户未登录"),
            @ApiResponse(code = 500, response = String.class, message = "服务器错误")
    })
    @GetMapping("/v1/addclass")
    public Result addclass(String pId, String name, String phase) {
        try {
            String orgId = userService.addOrg(pId, name, phase);
            return Result.ok(orgId);
        } catch (BusinessException e) {
            logger.error(" addclass Error!", e);
            return Result.error(e);
        } catch (Exception e) {
            logger.error(" addclass Error!", e);
            return Result.error(CommonConstants.SERVER_ERROR, e.getMessage());
        }
    }


    @ApiOperation(value = "更新机构信息")
    @ApiResponses({
            @ApiResponse(code = 200, response = Integer.class, message = "更新数量"),
            @ApiResponse(code = 1002, response = String.class, message = "字段校验错误"),
            @ApiResponse(code = 500, response = String.class, message = "服务器错误")
    })
    @RequestMapping(value = "/v1/organization", method = RequestMethod.PUT)
    public ResponseEntity update(@RequestBody @Validated(Update.class)OrgModel orgModel) {

        try {
            Integer num = userService.update(orgModel);
            return ResponseEntity.ok(num);
        } catch (BusinessException e) {
            logger.error("update organization Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR).body(Result.error(e));
        } catch (Exception e) {
            logger.error("update organization Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR)
                    .body(Result.error(CommonConstants.SERVER_ERROR, e.getMessage()));
        }
    }

    @ApiOperation(value = "更新班级信息")
    @ApiResponses({
            @ApiResponse(code = 200, response = Integer.class, message = "更新数量"),
            @ApiResponse(code = 1002, response = String.class, message = "字段校验错误"),
            @ApiResponse(code = 500, response = String.class, message = "服务器错误")
    })
    @RequestMapping(value = "/v1/class", method = RequestMethod.PUT)
    public ResponseEntity updateClass(@RequestBody OrgModel orgModel) {

        try {
            Integer num = userService.update(orgModel);
            return ResponseEntity.ok(num);
        } catch (BusinessException e) {
            logger.error("update class Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR).body(Result.error(e));
        } catch (Exception e) {
            logger.error("update class Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR)
                    .body(Result.error(CommonConstants.SERVER_ERROR, e.getMessage()));
        }
    }

    @ApiOperation(value = "查询学校列表")
    @ApiResponses({
            @ApiResponse(code = 200, response = MemberResult.class, message = "学校列表"),
            @ApiResponse(code = 1002, response = String.class, message = "字段校验错误"),
            @ApiResponse(code = 500, response = String.class, message = "服务器错误")
    })
    @RequestMapping(value = "/v1/search", method = RequestMethod.GET)
    public ResponseEntity list(String name, String parentOrgId) {
        try {
            List<OrgModel> orgModels =userService.searchGroups(name,parentOrgId);
            return ResponseEntity.ok(orgModels);
        } catch (BusinessException e) {
            logger.error("list OrgModel Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR).body(Result.error(e));
        } catch (Exception e) {
            logger.error("list OrgModel Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR)
                    .body(Result.error(CommonConstants.SERVER_ERROR, e.getMessage()));
        }
    }


    @ApiOperation(value = "查询班级列表")
    @ApiResponses({
            @ApiResponse(code = 200, response = MemberResult.class, message = "班级列表"),
            @ApiResponse(code = 1002, response = String.class, message = "字段校验错误"),
            @ApiResponse(code = 500, response = String.class, message = "服务器错误")
    })
    @RequestMapping(value = "/v1/searchClass", method = RequestMethod.GET)
    public ResponseEntity listClass(String name, String parentOrgId) {
        try {
            List<OrgModel> orgModels =userService.searchGroups(name,parentOrgId);
            return ResponseEntity.ok(orgModels);
        } catch (BusinessException e) {
            logger.error("list Class Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR).body(Result.error(e));
        } catch (Exception e) {
            logger.error("list Class Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR)
                    .body(Result.error(CommonConstants.SERVER_ERROR, e.getMessage()));
        }
    }


    @ApiOperation(value = "给校管理员注册账号")
    @ApiResponses({
            @ApiResponse(code = 200, response = MemberResult.class, message = "注册成功"),
            @ApiResponse(code = 1002, response = String.class, message = "字段校验错误"),
            @ApiResponse(code = 500, response = String.class, message = "服务器错误")
    })
    @RequestMapping(value="/v1/shoolmanagerregist", method = RequestMethod.POST)
    public ResponseEntity registSchoolManager(HttpServletRequest request, Map<String,Object> params) {
        String username = request.getParameter("username");
        String loginName = request.getParameter("loginname");
        String loginPass = request.getParameter("loginPass");
        String trueName = request.getParameter("trueName");
        String orgId = request.getParameter("orgId");
        //判断是否为管理员，通过code判断，此处无须判断
//        if(!isAdmin() && !isAppointedAuth(UserConstants.ROLE.ADMIN.num)) {
//            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE)
//                    .body("你无权操作。");
//        }
        boolean isExist = userService.userNameIsExist(loginName);
        if(isExist) {
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE)
                    .body("用户名已存在。");
        }
        username = org.apache.commons.lang.StringUtils.trimToEmpty(username);
        orgId = org.apache.commons.lang.StringUtils.trimToEmpty(orgId);
        if(username.length() == 0 && orgId.length() > 0) {
            String orgname = userService.getOrgnization(orgId);
            if(orgname != null && orgname.length() > 0) {
                username = orgname;
            }
        }
        params.put("userName", username);
        params.put("loginName", loginName);
        params.put("loginPass", loginPass);
        params.put("orgId", orgId);
        params.put("trueName", trueName);
        params.put("regRoletype", "school_manager");
        String userId = memberService.regist(params);
        if(org.apache.commons.lang.StringUtils.trimToEmpty(userId).length() == 0 ) {
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE)
                    .body("注册失败。");
        }
        //设置member信息
        Member member = new Member();
        member.setOrganization(orgId);
        member.setRole(UserConstants.ROLE.SCHOOL_MANAGER.code);
        member.setStatus("1");
        member.setName(username);
        member.setUserId(userId);
        memberService.create(member);
        return ResponseEntity.ok(1);
    }


    @ApiOperation(value = "给校老师注册账号")
    @ApiResponses({
            @ApiResponse(code = 200, response = MemberResult.class, message = "注册成功"),
            @ApiResponse(code = 1002, response = String.class, message = "字段校验错误"),
            @ApiResponse(code = 500, response = String.class, message = "服务器错误")
    })
    @RequestMapping(value="/v1/teacherRegist", method = RequestMethod.POST)
    public ResponseEntity registTeacher(HttpServletRequest request, Map<String,Object> params) {
        String username = request.getParameter("username");
        String loginName = request.getParameter("loginname");
        String loginPass = request.getParameter("loginPass");
        String trueName = request.getParameter("trueName");
        String orgId = request.getParameter("orgId");
        //判断是否为管理员，通过code判断，此处无须判断
//        if(!isAdmin() && !isAppointedAuth(UserConstants.ROLE.ADMIN.num)) {
//            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE)
//                    .body("你无权操作。");
//        }
        boolean isExist = userService.userNameIsExist(loginName);
        if(isExist) {
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE)
                    .body("用户名已存在。");
        }
        username = org.apache.commons.lang.StringUtils.trimToEmpty(username);
        orgId = org.apache.commons.lang.StringUtils.trimToEmpty(orgId);
        if(username.length() == 0 && orgId.length() > 0) {
            String orgname = userService.getOrgnization(orgId);
            if(orgname != null && orgname.length() > 0) {
                username = orgname;
            }
        }
        params.put("userName", username);
        params.put("loginName", loginName);
        params.put("loginPass", loginPass);
        params.put("orgId", orgId);
        params.put("trueName", trueName);
        params.put("regRoletype", "school_manager");
        String userId = memberService.regist(params);
        if(org.apache.commons.lang.StringUtils.trimToEmpty(userId).length() == 0 ) {
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE)
                    .body("注册失败。");
        }
        //设置member信息
        Member member = new Member();
        member.setOrganization(orgId);
        member.setRole(UserConstants.ROLE.SCHOOL_MANAGER.code);
        member.setStatus("1");
        member.setName(username);
        member.setUserId(userId);
        memberService.create(member);
        return ResponseEntity.ok(1);
    }

    @ApiOperation(value = "查询学校管理员列表")
    @ApiResponses({
            @ApiResponse(code = 200, response = MemberResult.class, message = "学校管理员列表"),
            @ApiResponse(code = 1002, response = String.class, message = "字段校验错误"),
            @ApiResponse(code = 500, response = String.class, message = "服务器错误")
    })
    @RequestMapping(value = "/v1/listSchoolManager", method = RequestMethod.GET)
    public ResponseEntity listSchoolManager(PageInfo page,String orgId) {
        try {
            Map<String,Object> map =userService.listSchoolManager(page,orgId);
            return ResponseEntity.ok(map);
        } catch (BusinessException e) {
            logger.error("list SchoolManage Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR).body(Result.error(e));
        } catch (Exception e) {
            logger.error("list SchoolManage Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR)
                    .body(Result.error(CommonConstants.SERVER_ERROR, e.getMessage()));
        }
    }

    @ApiOperation(value = "查询班级管理员列表")
    @ApiResponses({
            @ApiResponse(code = 200, response = MemberResult.class, message = "班级管理员列表"),
            @ApiResponse(code = 1002, response = String.class, message = "字段校验错误"),
            @ApiResponse(code = 500, response = String.class, message = "服务器错误")
    })
    @RequestMapping(value = "/v1/listTeacher", method = RequestMethod.GET)
    public ResponseEntity listTeacher(PageInfo page,String orgId) {
        try {
            Map<String,Object> map =userService.listSchoolManager(page,orgId);
            return ResponseEntity.ok(map);
        } catch (BusinessException e) {
            logger.error("list Teacher Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR).body(Result.error(e));
        } catch (Exception e) {
            logger.error("list Teacher Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR)
                    .body(Result.error(CommonConstants.SERVER_ERROR, e.getMessage()));
        }
    }

    @ApiOperation(value = "更新校管理员账户密码")
    @ApiResponses({
            @ApiResponse(code = 200, response = Integer.class, message = "更新数量"),
            @ApiResponse(code = 1002, response = String.class, message = "字段校验错误"),
            @ApiResponse(code = 500, response = String.class, message = "服务器错误")
    })
    @RequestMapping(value = "/v1/modifyUserInfo/{userId}", method = RequestMethod.PUT)
    public ResponseEntity modifyUserInfo(String loginname, String passwd, @PathVariable String userId) {

        try {
            int num = userService.modifyUserInfo(loginname,passwd, userId);
            return ResponseEntity.ok(num);
        } catch (BusinessException e) {
            logger.error("update organization Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR).body(Result.error(e));
        } catch (Exception e) {
            logger.error("update organization Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR)
                    .body(Result.error(CommonConstants.SERVER_ERROR, e.getMessage()));
        }
    }

    @ApiOperation(value = "更新班级管理员账户密码")
    @ApiResponses({
            @ApiResponse(code = 200, response = Integer.class, message = "更新数量"),
            @ApiResponse(code = 1002, response = String.class, message = "字段校验错误"),
            @ApiResponse(code = 500, response = String.class, message = "服务器错误")
    })
    @RequestMapping(value = "/v1/modifyUserInfoByClass/{userId}", method = RequestMethod.PUT)
    public ResponseEntity modifyUserInfoByClass(String loginname, String passwd, @PathVariable String userId) {

        try {
            int num = userService.modifyUserInfo(loginname,passwd, userId);
            return ResponseEntity.ok(num);
        } catch (BusinessException e) {
            logger.error("update modifyUserInfoByClass Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR).body(Result.error(e));
        } catch (Exception e) {
            logger.error("update modifyUserInfoByClass Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR)
                    .body(Result.error(CommonConstants.SERVER_ERROR, e.getMessage()));
        }
    }

}
