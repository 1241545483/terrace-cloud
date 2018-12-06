package com.synapse.reading.controller;

import com.synapse.common.constants.PageInfo;
import com.synapse.common.trans.Result;
import com.synapse.common.sso.context.UserContext;
import com.synapse.common.sso.model.User;
import com.synapse.common.utils.DateUtils;
import com.synapse.reading.model.Information;
import com.synapse.reading.dto.param.InformationParam;
import com.synapse.reading.dto.result.InformationResult;
import com.synapse.reading.model.MyLike;
import com.synapse.reading.service.InformationService;
import com.synapse.reading.web.valid.group.Update;
import com.synapse.reading.web.valid.group.Create;
import com.synapse.reading.web.valid.group.Search;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
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

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * <p>
 * 资讯模块 Controller
 * </p>
 *
 * @author liuguangfu
 * @since 2018-12-01
 */
@Api(tags = "InformationController")
@RestController
@RequestMapping("/reading")
public class InformationController extends BaseController {

    private Logger logger = LoggerFactory.getLogger(InformationController.class);

    @Autowired
    private InformationService informationService;

    @ApiOperation(value = "查询Information列表(分页)")
    @ApiResponses({
            @ApiResponse(code = 200, response = InformationResult.class, message = "Information列表"),
            @ApiResponse(code = 1002, response = String.class, message = "字段校验错误"),
            @ApiResponse(code = 500, response = String.class, message = "服务器错误")
    })
    @RequestMapping(value = "/v1/information", method = RequestMethod.GET)
    public ResponseEntity list(PageInfo pageInfo, @Validated(Search.class) InformationParam param, BindingResult bindingResult) {
        try {
            //验证失败
            if (bindingResult.hasErrors()) {
                throw new ValidException(bindingResult.getFieldError().getDefaultMessage());
            }
            int totalNum = informationService.count(param.getModel());
            preparePageInfo(pageInfo, totalNum);
            User user = UserContext.getUser();
            String userId = user.getRecId();
            List<InformationResult> results = informationService.listAddIsLike(param.getModel(), pageInfo, userId);
            Map<String, Object> map = new HashMap();
            map.put("informationList", results);
            map.put("totalNum", totalNum);
            return ResponseEntity.ok(map);
        } catch (BusinessException e) {
            logger.error("list Information Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR).body(Result.error(e));
        } catch (Exception e) {
            logger.error("list Information Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR)
                    .body(Result.error(CommonConstants.SERVER_ERROR, e.getMessage()));
        }
    }

    @ApiOperation(value = "查询Information列表(收藏分页)")
    @ApiResponses({
            @ApiResponse(code = 200, response = InformationResult.class, message = "Information列表"),
            @ApiResponse(code = 1002, response = String.class, message = "字段校验错误"),
            @ApiResponse(code = 500, response = String.class, message = "服务器错误")
    })
    @RequestMapping(value = "/v1/information/listAddIsCollect", method = RequestMethod.GET)
    public ResponseEntity listAddIsCollect(PageInfo pageInfo, @Validated(Search.class) InformationParam param, BindingResult bindingResult) {
        try {
            //验证失败
            if (bindingResult.hasErrors()) {
                throw new ValidException(bindingResult.getFieldError().getDefaultMessage());
            }
            int totalNum = informationService.count(param.getModel());
            preparePageInfo(pageInfo, totalNum);
            User user = UserContext.getUser();
            String userId = user.getRecId();
            List<InformationResult> results = informationService.listAddIsCollect(param.getModel(), pageInfo, userId);
            Map<String, Object> map = new HashMap();
            map.put("informationList", results);
            map.put("totalNum", totalNum);
            return ResponseEntity.ok(map);
        } catch (BusinessException e) {
            logger.error("list Information Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR).body(Result.error(e));
        } catch (Exception e) {
            logger.error("list Information Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR)
                    .body(Result.error(CommonConstants.SERVER_ERROR, e.getMessage()));
        }
    }

    @ApiOperation(value = "根据主键查询Information详情")
    @ApiResponses({
            @ApiResponse(code = 200, response = InformationResult.class, message = "Information对象"),
            @ApiResponse(code = 500, response = String.class, message = "服务器错误")
    })
    @RequestMapping(value = "/v1/information/{recId}", method = RequestMethod.GET)
    public ResponseEntity get(@PathVariable("recId") String recId) {
        try {
            Information information = informationService.find(recId);
            return ResponseEntity.ok(new InformationResult(information));
        } catch (BusinessException e) {
            logger.error("get Information Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR).body(Result.error(e));
        } catch (Exception e) {
            logger.error("get Information Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR)
                    .body(Result.error(CommonConstants.SERVER_ERROR, e.getMessage()));
        }
    }

    @ApiOperation(value = "创建Information")
    @ApiResponses({
            @ApiResponse(code = 200, response = String.class, message = "主键"),
            @ApiResponse(code = 1002, response = String.class, message = "字段校验错误"),
            @ApiResponse(code = 500, response = String.class, message = "服务器错误")
    })
    @RequestMapping(value = "/v1/information", method = RequestMethod.POST)
    public ResponseEntity create(@RequestBody @Validated(Create.class) InformationParam param, BindingResult bindingResult) {
        try {
            //验证失败
            if (bindingResult.hasErrors()) {
                throw new ValidException(bindingResult.getFieldError().getDefaultMessage());
            }
            User user = UserContext.getUser();
            //todo 根据角色判断权限

            Information model = param.getModel();
            model.setCreateId(user.getRecId());
            model.setUpdateId(user.getRecId());
            String recId = informationService.create(model);
            return ResponseEntity.ok(recId);
        } catch (BusinessException e) {
            logger.error("create Information Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR).body(Result.error(e));
        } catch (Exception e) {
            logger.error("create Information Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR)
                    .body(Result.error(CommonConstants.SERVER_ERROR, e.getMessage()));
        }
    }

    @ApiOperation(value = "根据主键删除Information")
    @ApiResponses({
            @ApiResponse(code = 200, response = Integer.class, message = "删除数量"),
            @ApiResponse(code = 500, response = String.class, message = "服务器错误")
    })
    @RequestMapping(value = "/v1/information/{recId}", method = RequestMethod.DELETE)
    public ResponseEntity delete(@PathVariable("recId") String recId) {
        try {
            User user = UserContext.getUser();
            //todo 根据角色判断权限

            Integer num = informationService.delete(recId, user.getRecId());
            return ResponseEntity.ok(num);
        } catch (BusinessException e) {
            logger.error("delete Information Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR).body(Result.error(e));
        } catch (Exception e) {
            logger.error("delete Information Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR)
                    .body(Result.error(CommonConstants.SERVER_ERROR, e.getMessage()));
        }
    }

    @ApiOperation(value = "根据主键更新Information")
    @ApiResponses({
            @ApiResponse(code = 200, response = Integer.class, message = "更新数量"),
            @ApiResponse(code = 1002, response = String.class, message = "字段校验错误"),
            @ApiResponse(code = 500, response = String.class, message = "服务器错误")
    })
    @RequestMapping(value = "/v1/information/{recId}", method = RequestMethod.PUT)
    public ResponseEntity update(@PathVariable("recId") String recId, @RequestBody @Validated(Update.class) InformationParam param, BindingResult bindingResult) {
        try {
            //验证失败
            if (bindingResult.hasErrors()) {
                throw new ValidException(bindingResult.getFieldError().getDefaultMessage());
            }
            User user = UserContext.getUser();
            //todo 根据角色判断权限

            Information model = param.getModel();
            model.setRecId(recId);
            model.setUpdateId(user.getRecId());
            Integer num = informationService.update(model);
            return ResponseEntity.ok(num);
        } catch (BusinessException e) {
            logger.error("update Information Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR).body(Result.error(e));
        } catch (Exception e) {
            logger.error("update Information Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR)
                    .body(Result.error(CommonConstants.SERVER_ERROR, e.getMessage()));
        }
    }


    @ApiOperation(value = "根据主键更新阅读次数")
    @ApiResponses({
            @ApiResponse(code = 200, response = Integer.class, message = "true"),
            @ApiResponse(code = 1002, response = String.class, message = "字段校验错误"),
            @ApiResponse(code = 500, response = String.class, message = "服务器错误")
    })
    @RequestMapping(value = "/v1/information/updataReadNum/{recId}", method = RequestMethod.PUT)
    public ResponseEntity updateReadNum(@PathVariable("recId") String recId) {
        try {
            User user = UserContext.getUser();
            //todo 根据角色判断权限

            boolean valid = informationService.updateReadNum(recId);
            return ResponseEntity.ok(valid);
        } catch (BusinessException e) {
            logger.error("update Information Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR).body(Result.error(e));
        } catch (Exception e) {
            logger.error("update Information Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR)
                    .body(Result.error(CommonConstants.SERVER_ERROR, e.getMessage()));
        }
    }


    @ApiOperation(value = "增加点赞次数")
    @ApiResponses({
            @ApiResponse(code = 200, response = Integer.class, message = "true"),
            @ApiResponse(code = 1002, response = String.class, message = "字段校验错误"),
            @ApiResponse(code = 500, response = String.class, message = "服务器错误")
    })
    @RequestMapping(value = "/v1/information/updateLikeAddNum/{recId}", method = RequestMethod.PUT)
    public ResponseEntity updateLikeAddNum(@PathVariable("recId") String recId) {
        try {
            String now = DateUtils.getNowStr(DateUtils.FORMAT_DATE_TIME);
            User user = UserContext.getUser();
            //todo 根据角色判断权限


            boolean valid = informationService.updateLikeAddNum(recId, user);
            return ResponseEntity.ok(valid);
        } catch (BusinessException e) {
            logger.error("update Information Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR).body(Result.error(e));
        } catch (Exception e) {
            logger.error("update Information Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR)
                    .body(Result.error(CommonConstants.SERVER_ERROR, e.getMessage()));
        }
    }


    @ApiOperation(value = "减少点赞次数")
    @ApiResponses({
            @ApiResponse(code = 200, response = Integer.class, message = "true"),
            @ApiResponse(code = 1002, response = String.class, message = "字段校验错误"),
            @ApiResponse(code = 500, response = String.class, message = "服务器错误")
    })
    @RequestMapping(value = "/v1/information/updateLikeReduceNum/{recId}", method = RequestMethod.PUT)
    public ResponseEntity updateLikeReduceNum(@PathVariable("recId") String recId) {
        try {
            User user = UserContext.getUser();
            //todo 根据角色判断权限
            String createId = user.getRecId();
            boolean valid = informationService.updateLikeReduceNum(recId, createId);
            return ResponseEntity.ok(valid);
        } catch (BusinessException e) {
            logger.error("update Information Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR).body(Result.error(e));
        } catch (Exception e) {
            logger.error("update Information Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR)
                    .body(Result.error(CommonConstants.SERVER_ERROR, e.getMessage()));
        }
    }

    @ApiOperation(value = "判断是否点赞")
    @ApiResponses({
            @ApiResponse(code = 200, response = Integer.class, message = "true"),
            @ApiResponse(code = 1002, response = String.class, message = "字段校验错误"),
            @ApiResponse(code = 500, response = String.class, message = "服务器错误")
    })
    @RequestMapping(value = "/v1/information/countIsLike/{recId}", method = RequestMethod.GET)
    public ResponseEntity countIsLike(@PathVariable("recId") String recId) {
        try {
            User user = UserContext.getUser();
            //todo 根据角色判断权限
            String userId = user.getRecId();
            System.err.println(userId);
            boolean valid = informationService.countIsLike(recId, userId);
            System.err.println(valid);
            return ResponseEntity.ok(valid);
        } catch (BusinessException e) {
            logger.error("update Information Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR).body(Result.error(e));
        } catch (Exception e) {
            logger.error("update Information Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR)
                    .body(Result.error(CommonConstants.SERVER_ERROR, e.getMessage()));
        }
    }




    @ApiOperation(value = "查询为咨讯的收藏列表")
    @ApiResponses({
            @ApiResponse(code = 200, response = Integer.class, message = "收藏列表"),
            @ApiResponse(code = 1002, response = String.class, message = "字段校验错误"),
            @ApiResponse(code = 500, response = String.class, message = "服务器错误")
    })
    @RequestMapping(value = "/v1/information/listMyCollectByInfo", method = RequestMethod.GET)
    public ResponseEntity listMyCollectByInfo() {
        try {

            User user = UserContext.getUser();
            //todo 根据角色判断权限
            List<InformationResult> results = informationService.listMyCollectByInfo(user);
            return ResponseEntity.ok(results);
        } catch (BusinessException e) {
            logger.error("update Information Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR).body(Result.error(e));
        } catch (Exception e) {
            logger.error("update Information Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR)
                    .body(Result.error(CommonConstants.SERVER_ERROR, e.getMessage()));
        }
    }
}