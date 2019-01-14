package com.synapse.reading.controller;

import com.synapse.common.constants.PageInfo;
import com.synapse.common.trans.Result;
import com.synapse.common.sso.context.UserContext;
import com.synapse.common.sso.model.User;
import com.synapse.reading.dto.param.IssueItemParam;
import com.synapse.reading.model.Issue;
import com.synapse.reading.dto.param.IssueParam;
import com.synapse.reading.dto.result.IssueResult;
import com.synapse.reading.model.IssueItem;
import com.synapse.reading.service.IssueItemService;
import com.synapse.reading.service.IssueService;
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
import springfox.documentation.annotations.ApiIgnore;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * <p>
 * 观看视频回答题目 Controller
 * </p>
 *
 * @author liuguangfu
 * @since 2019-01-09
 */
@Api(tags = "IssueController")
@RestController
@RequestMapping("/reading")
public class IssueController extends BaseController {

    private Logger logger = LoggerFactory.getLogger(IssueController.class);

    @Autowired
    private IssueService issueService;

    @Autowired
    private IssueItemService issueItemService;

    @ApiOperation(value = "查询Issue列表(分页)")
    @ApiResponses({
            @ApiResponse(code = 200, response = IssueResult.class, message = "Issue列表"),
            @ApiResponse(code = 1002, response = String.class, message = "字段校验错误"),
            @ApiResponse(code = 500, response = String.class, message = "服务器错误")
    })
    @ApiImplicitParams({
            @ApiImplicitParam(name = "recId", value = "用户ID", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "content", value = "content", dataType = "String", paramType = "query")
    })
    @RequestMapping(value = "/v1/issue", method = RequestMethod.GET)
    public ResponseEntity list(PageInfo pageInfo, @Validated(Search.class) @ApiIgnore IssueParam param, BindingResult bindingResult) {
        try {
            //验证失败
            if (bindingResult.hasErrors()) {
                throw new ValidException(bindingResult.getFieldError().getDefaultMessage());
            }
            int totalNum = issueService.count(param.getModel());
            preparePageInfo(pageInfo, totalNum);
            List<Issue> models = issueService.list(param.getModel(), pageInfo);
            List<IssueResult> results = models.stream().map(it -> new IssueResult(it)).collect(Collectors.toList());
            Map<String, Object> map = new HashMap();
            map.put("issueList", results);
            map.put("totalNum", totalNum);
            return ResponseEntity.ok(map);
        } catch (BusinessException e) {
            logger.error("list Issue Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR).body(Result.error(e));
        } catch (Exception e) {
            logger.error("list Issue Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR)
                    .body(Result.error(CommonConstants.SERVER_ERROR, e.getMessage()));
        }
    }

    @ApiOperation(value = "根据主键查询Issue详情")
    @ApiResponses({
            @ApiResponse(code = 200, response = IssueResult.class, message = "Issue对象"),
            @ApiResponse(code = 500, response = String.class, message = "服务器错误")
    })
    @RequestMapping(value = "/v1/issue/{recId}", method = RequestMethod.GET)
    public ResponseEntity get(@PathVariable("recId") String recId) {
        try {
            Issue issue = issueService.find(recId);
            return ResponseEntity.ok(new IssueResult(issue));
        } catch (BusinessException e) {
            logger.error("get Issue Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR).body(Result.error(e));
        } catch (Exception e) {
            logger.error("get Issue Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR)
                    .body(Result.error(CommonConstants.SERVER_ERROR, e.getMessage()));
        }
    }

    @ApiOperation(value = "创建Issue")
    @ApiResponses({
            @ApiResponse(code = 200, response = String.class, message = "主键"),
            @ApiResponse(code = 1002, response = String.class, message = "字段校验错误"),
            @ApiResponse(code = 500, response = String.class, message = "服务器错误")
    })
    @RequestMapping(value = "/v1/issue", method = RequestMethod.POST)
    public ResponseEntity create(@RequestBody @Validated(Create.class) IssueParam param, BindingResult bindingResult) {
        try {
            //验证失败
            if (bindingResult.hasErrors()) {
                throw new ValidException(bindingResult.getFieldError().getDefaultMessage());
            }
            User user = UserContext.getUser();
            //todo 根据角色判断权限

            Issue model = param.getModel();
            model.setCreateId(user.getRecId());
            model.setUpdateId(user.getRecId());
            String recId = issueService.create(model);
            return ResponseEntity.ok(recId);
        } catch (BusinessException e) {
            logger.error("create Issue Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR).body(Result.error(e));
        } catch (Exception e) {
            logger.error("create Issue Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR)
                    .body(Result.error(CommonConstants.SERVER_ERROR, e.getMessage()));
        }
    }


    @ApiOperation(value = "根据书籍主键查询所有Issue详情")
    @ApiResponses({
            @ApiResponse(code = 200, response = IssueResult.class, message = "Issue对象列表包含选项"),
            @ApiResponse(code = 500, response = String.class, message = "服务器错误")
    })
    @RequestMapping(value = "/v1/getIssueList", method = RequestMethod.GET)
    public ResponseEntity getIssueList(PageInfo pageInfo, @Validated(Search.class) IssueParam param, BindingResult bindingResult) {
        try {
            if (bindingResult.hasErrors()) {
                throw new ValidException(bindingResult.getFieldError().getDefaultMessage());
            }
            int totalNum = issueService.count(param.getModel());
            preparePageInfo(pageInfo, totalNum);
            List<IssueResult> results = issueService.getIssueList(param.getBelongToId(), param.getBelongTo());
            Map<String, Object> map = new HashMap();
            map.put("issueList", results);
            map.put("totalNum", totalNum);
            return ResponseEntity.ok(map);

        } catch (BusinessException e) {
            logger.error("get issueResult Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR).body(Result.error(e));
        } catch (Exception e) {
            logger.error("get issueResult Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR)
                    .body(Result.error(CommonConstants.SERVER_ERROR, e.getMessage()));
        }
    }


//    @ApiOperation(value = "根据主键查询单个Issue详情")
//    @ApiResponses({
//            @ApiResponse(code = 200, response = IssueResult.class, message = "Issue对象包含选项"),
//            @ApiResponse(code = 500, response = String.class, message = "服务器错误")
//    })
//    @RequestMapping(value = "/v1/getIssueAll/{recId}", method = RequestMethod.GET)
//    public ResponseEntity getIssueAll(@PathVariable("recId") String recId) {
//        try {
//            IssueResult issueResult = new IssueResult();
//            Issue issue = issueService.find(recId);
//            List<IssueItem> issueItemList = issueItemService.findByIssueId(recId);
//            issueResult.setModel(issue);
//            issueResult.setIssueItemList(issueItemList);
//            return ResponseEntity.ok(issueResult);
//        } catch (BusinessException e) {
//            logger.error("get issueResult Error!", e);
//            return ResponseEntity.status(CommonConstants.SERVER_ERROR).body(Result.error(e));
//        } catch (Exception e) {
//            logger.error("get issueResult Error!", e);
//            return ResponseEntity.status(CommonConstants.SERVER_ERROR)
//                    .body(Result.error(CommonConstants.SERVER_ERROR, e.getMessage()));
//        }
//    }

    @ApiOperation(value = "创建Issue和IssueItem")
    @ApiResponses({
            @ApiResponse(code = 200, response = String.class, message = "Issue主键"),
            @ApiResponse(code = 1002, response = String.class, message = "字段校验错误"),
            @ApiResponse(code = 500, response = String.class, message = "服务器错误")
    })
    @RequestMapping(value = "/v1/createIssueAll", method = RequestMethod.POST)
    public ResponseEntity createIssueAll(@RequestBody @Validated(Create.class) List<IssueParam> param, BindingResult bindingResult) {
        try {
            //验证失败
            if (bindingResult.hasErrors()) {
                throw new ValidException(bindingResult.getFieldError().getDefaultMessage());
            }
            User user = UserContext.getUser();
            //todo 根据角色判断权限

            return ResponseEntity.ok(issueService.createIssueAll(param, user));
        } catch (BusinessException e) {
            logger.error("create createIssueAll Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR).body(Result.error(e));
        } catch (Exception e) {
            logger.error("create createIssueAll Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR)
                    .body(Result.error(CommonConstants.SERVER_ERROR, e.getMessage()));
        }
    }


    @ApiOperation(value = "根据主键删除Issue和IssueItem")
    @ApiResponses({
            @ApiResponse(code = 200, response = Integer.class, message = "删除数量"),
            @ApiResponse(code = 500, response = String.class, message = "服务器错误")
    })
    @RequestMapping(value = "/v1/deleteIssueAll/{recId}", method = RequestMethod.DELETE)
    public ResponseEntity deleteIssueAll(@PathVariable("recId") String recId) {
        try {
            User user = UserContext.getUser();
            //todo 根据角色判断权限


            Boolean valid = issueService.delete(recId, user.getRecId()) > 0;
            Boolean valid2 = issueItemService.deleteByIssueId(recId) > 0;
            return ResponseEntity.ok(valid && valid2);
        } catch (BusinessException e) {
            logger.error("delete deleteIssueAll Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR).body(Result.error(e));
        } catch (Exception e) {
            logger.error("delete deleteIssueAll Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR)
                    .body(Result.error(CommonConstants.SERVER_ERROR, e.getMessage()));
        }
    }


    @ApiOperation(value = "根据主键更新Issue和IssueItem")
    @ApiResponses({
            @ApiResponse(code = 200, response = Integer.class, message = "更新数量"),
            @ApiResponse(code = 1002, response = String.class, message = "字段校验错误"),
            @ApiResponse(code = 500, response = String.class, message = "服务器错误")
    })
    @RequestMapping(value = "/v1/updateIssueAll/{recId}", method = RequestMethod.PUT)
    public ResponseEntity updateIssueAll(@PathVariable("recId") String recId, @RequestBody @Validated(Update.class) IssueParam param, BindingResult bindingResult) {
        try {
            //验证失败
            if (bindingResult.hasErrors()) {
                throw new ValidException(bindingResult.getFieldError().getDefaultMessage());
            }
            User user = UserContext.getUser();
            //todo 根据角色判断权限
            List<IssueItemParam> issueItemParam = param.getModelList();
            Issue model = param.getModel();
            model.setRecId(recId);
            model.setUpdateId(user.getRecId());
            Integer num = issueService.updateIssueAll(model, issueItemParam);
            return ResponseEntity.ok(num);
        } catch (BusinessException e) {
            logger.error("update updateIssueAll Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR).body(Result.error(e));
        } catch (Exception e) {
            logger.error("update updateIssueAll Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR)
                    .body(Result.error(CommonConstants.SERVER_ERROR, e.getMessage()));
        }
    }

    @ApiOperation(value = "根据主键删除Issue")
    @ApiResponses({
            @ApiResponse(code = 200, response = Integer.class, message = "删除数量"),
            @ApiResponse(code = 500, response = String.class, message = "服务器错误")
    })
    @RequestMapping(value = "/v1/issue/{recId}", method = RequestMethod.DELETE)
    public ResponseEntity delete(@PathVariable("recId") String recId) {
        try {
            User user = UserContext.getUser();
            //todo 根据角色判断权限

            Integer num = issueService.delete(recId, user.getRecId());
            return ResponseEntity.ok(num);
        } catch (BusinessException e) {
            logger.error("delete Issue Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR).body(Result.error(e));
        } catch (Exception e) {
            logger.error("delete Issue Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR)
                    .body(Result.error(CommonConstants.SERVER_ERROR, e.getMessage()));
        }
    }

    @ApiOperation(value = "根据主键更新Issue")
    @ApiResponses({
            @ApiResponse(code = 200, response = Integer.class, message = "更新数量"),
            @ApiResponse(code = 1002, response = String.class, message = "字段校验错误"),
            @ApiResponse(code = 500, response = String.class, message = "服务器错误")
    })
    @RequestMapping(value = "/v1/issue/{recId}", method = RequestMethod.PUT)
    public ResponseEntity update(@PathVariable("recId") String recId, @RequestBody @Validated(Update.class) IssueParam param, BindingResult bindingResult) {
        try {
            //验证失败
            if (bindingResult.hasErrors()) {
                throw new ValidException(bindingResult.getFieldError().getDefaultMessage());
            }
            User user = UserContext.getUser();
            //todo 根据角色判断权限

            Issue model = param.getModel();
            model.setRecId(recId);
            model.setUpdateId(user.getRecId());
            Integer num = issueService.update(model);
            return ResponseEntity.ok(num);
        } catch (BusinessException e) {
            logger.error("update Issue Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR).body(Result.error(e));
        } catch (Exception e) {
            logger.error("update Issue Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR)
                    .body(Result.error(CommonConstants.SERVER_ERROR, e.getMessage()));
        }
    }

    @ApiOperation(value = "获取用户答题分数")
    @ApiResponses({
            @ApiResponse(code = 200, response = Integer.class, message = "分数"),
            @ApiResponse(code = 1002, response = String.class, message = "字段校验错误"),
            @ApiResponse(code = 500, response = String.class, message = "服务器错误")
    })
    @RequestMapping(value = "/v1/selectScoreByUserId", method = RequestMethod.GET)
    public ResponseEntity selectScoreByUserId(IssueParam param, BindingResult bindingResult) {
        try {
            //验证失败
            if (bindingResult.hasErrors()) {
                throw new ValidException(bindingResult.getFieldError().getDefaultMessage());
            }
            User user = UserContext.getUser();
            //todo 根据角色判断权限

            Double num = issueService.selectScoreByUserId(user, param.getBelongToId(), param.getBelongTo());
            return ResponseEntity.ok(num);
        } catch (BusinessException e) {
            logger.error("get selectScoreByUserId Error!!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR).body(Result.error(e));
        } catch (Exception e) {
            logger.error("get selectScoreByUserId Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR)
                    .body(Result.error(CommonConstants.SERVER_ERROR, e.getMessage()));
        }
    }

    @ApiOperation(value = "获取用户答题数")
    @ApiResponses({
            @ApiResponse(code = 200, response = Integer.class, message = "答对数量"),
            @ApiResponse(code = 1002, response = String.class, message = "字段校验错误"),
            @ApiResponse(code = 500, response = String.class, message = "服务器错误")
    })
    @RequestMapping(value = "/v1/selectCountByUserId", method = RequestMethod.GET)
    public ResponseEntity selectCountByUserId(IssueParam param, BindingResult bindingResult) {
        try {
            //验证失败
            if (bindingResult.hasErrors()) {
                throw new ValidException(bindingResult.getFieldError().getDefaultMessage());
            }
            User user = UserContext.getUser();
            //todo 根据角色判断权限

            int num = issueService.selectCountByUserId(user, param.getBelongToId(), param.getBelongTo());
            return ResponseEntity.ok(num);
        } catch (BusinessException e) {
            logger.error("get selectCountByUserId Error!!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR).body(Result.error(e));
        } catch (Exception e) {
            logger.error("get selectCountByUserId Error!!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR)
                    .body(Result.error(CommonConstants.SERVER_ERROR, e.getMessage()));
        }
    }

}