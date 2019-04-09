package com.synapse.reading.controller;

import com.synapse.common.constants.PageInfo;
import com.synapse.common.trans.Result;
import com.synapse.common.sso.context.UserContext;
import com.synapse.common.sso.model.User;
import com.synapse.reading.dto.param.IssueParam;
import com.synapse.reading.model.ShareImage;
import com.synapse.reading.dto.param.ShareImageParam;
import com.synapse.reading.dto.result.ShareImageResult;
import com.synapse.reading.service.ShareImageService;
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
 * 分享图片 Controller
 * </p>
 *
 * @author liuguangfu
 * @since 2018-12-14
 */
@Api(tags = "ShareImageController")
@RestController
@RequestMapping("/reading")
public class ShareImageController extends BaseController {

    private Logger logger = LoggerFactory.getLogger(ShareImageController.class);

    @Autowired
    private ShareImageService shareImageService;

    @ApiOperation(value = "查询ShareImage列表(分页)")
    @ApiResponses({
            @ApiResponse(code = 200, response = ShareImageResult.class, message = "ShareImage列表"),
            @ApiResponse(code = 1002, response = String.class, message = "字段校验错误"),
            @ApiResponse(code = 500, response = String.class, message = "服务器错误")
    })
    @RequestMapping(value = "/v1/shareImage", method = RequestMethod.GET)
    public ResponseEntity list(PageInfo pageInfo, @Validated(Search.class) ShareImageParam param, BindingResult bindingResult) {
        try {
            //验证失败
            if (bindingResult.hasErrors()) {
                throw new ValidException(bindingResult.getFieldError().getDefaultMessage());
            }
            int totalNum = shareImageService.count(param.getModel());
            preparePageInfo(pageInfo, totalNum);
            List<ShareImage> models = shareImageService.list(param.getModel(), pageInfo);
            List<ShareImageResult> results = models.stream().map(it -> new ShareImageResult(it)).collect(Collectors.toList());
            Map<String, Object> map = new HashMap();
            map.put("shareImageList", results);
            map.put("totalNum", totalNum);
            return ResponseEntity.ok(map);
        } catch (BusinessException e) {
            logger.error("list ShareImage Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR).body(Result.error(e));
        } catch (Exception e) {
            logger.error("list ShareImage Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR)
                    .body(Result.error(CommonConstants.SERVER_ERROR, e.getMessage()));
        }
    }

    @ApiOperation(value = "根据主键查询ShareImage详情")
    @ApiResponses({
            @ApiResponse(code = 200, response = ShareImageResult.class, message = "ShareImage对象"),
            @ApiResponse(code = 500, response = String.class, message = "服务器错误")
    })
    @RequestMapping(value = "/v1/shareImage/{recId}", method = RequestMethod.GET)
    public ResponseEntity get(@PathVariable("recId") String recId) {
        try {
            ShareImage shareImage = shareImageService.find(recId);
            return ResponseEntity.ok(new ShareImageResult(shareImage));
        } catch (BusinessException e) {
            logger.error("get ShareImage Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR).body(Result.error(e));
        } catch (Exception e) {
            logger.error("get ShareImage Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR)
                    .body(Result.error(CommonConstants.SERVER_ERROR, e.getMessage()));
        }
    }

    @ApiOperation(value = "创建ShareImage")
    @ApiResponses({
            @ApiResponse(code = 200, response = String.class, message = "主键"),
            @ApiResponse(code = 1002, response = String.class, message = "字段校验错误"),
            @ApiResponse(code = 500, response = String.class, message = "服务器错误")
    })
    @RequestMapping(value = "/v1/shareImage", method = RequestMethod.POST)
    public ResponseEntity create(@RequestBody @Validated(Create.class) ShareImageParam param, BindingResult bindingResult) {
        try {
            //验证失败
            if (bindingResult.hasErrors()) {
                throw new ValidException(bindingResult.getFieldError().getDefaultMessage());
            }
            User user = UserContext.getUser();
            //todo 根据角色判断权限

            ShareImage model = param.getModel();
            model.setCreateId(user.getRecId());
            model.setUpdateId(user.getRecId());
            String recId = shareImageService.create(model);
            return ResponseEntity.ok(recId);
        } catch (BusinessException e) {
            logger.error("create ShareImage Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR).body(Result.error(e));
        } catch (Exception e) {
            logger.error("create ShareImage Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR)
                    .body(Result.error(CommonConstants.SERVER_ERROR, e.getMessage()));
        }
    }

    @ApiOperation(value = "根据主键删除ShareImage")
    @ApiResponses({
            @ApiResponse(code = 200, response = Integer.class, message = "删除数量"),
            @ApiResponse(code = 500, response = String.class, message = "服务器错误")
    })
    @RequestMapping(value = "/v1/shareImage/{recId}", method = RequestMethod.DELETE)
    public ResponseEntity delete(@PathVariable("recId") String recId) {
        try {
            User user = UserContext.getUser();
            //todo 根据角色判断权限

            Integer num = shareImageService.delete(recId);
            return ResponseEntity.ok(num);
        } catch (BusinessException e) {
            logger.error("delete ShareImage Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR).body(Result.error(e));
        } catch (Exception e) {
            logger.error("delete ShareImage Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR)
                    .body(Result.error(CommonConstants.SERVER_ERROR, e.getMessage()));
        }
    }

    @ApiOperation(value = "根据主键更新ShareImage")
    @ApiResponses({
            @ApiResponse(code = 200, response = Integer.class, message = "更新数量"),
            @ApiResponse(code = 1002, response = String.class, message = "字段校验错误"),
            @ApiResponse(code = 500, response = String.class, message = "服务器错误")
    })
    @RequestMapping(value = "/v1/shareImage/{recId}", method = RequestMethod.PUT)
    public ResponseEntity update(@PathVariable("recId") String recId, @RequestBody @Validated(Update.class) ShareImageParam param, BindingResult bindingResult) {
        try {
            //验证失败
            if (bindingResult.hasErrors()) {
                throw new ValidException(bindingResult.getFieldError().getDefaultMessage());
            }
            User user = UserContext.getUser();
            //todo 根据角色判断权限

            ShareImage model = param.getModel();
            model.setRecId(recId);
            model.setUpdateId(user.getRecId());
            Integer num = shareImageService.update(model);
            return ResponseEntity.ok(num);
        } catch (BusinessException e) {
            logger.error("update ShareImage Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR).body(Result.error(e));
        } catch (Exception e) {
            logger.error("update ShareImage Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR)
                    .body(Result.error(CommonConstants.SERVER_ERROR, e.getMessage()));
        }
    }


    @ApiOperation(value = "根据主键查询分享图片详情")
    @ApiResponses({
            @ApiResponse(code = 200, response = ShareImageResult.class, message = "分享图片地址"),
            @ApiResponse(code = 500, response = String.class, message = "服务器错误")
    })
    @RequestMapping(value = "/v1/shareImage/getShareUrl/{recId}", method = RequestMethod.GET)
    public ResponseEntity getShareUrl(@PathVariable("recId") String recId) {
        try {
            User user = UserContext.getUser();
            String shareType = "audio";

            String url = shareImageService.getShareUrl(recId, user,shareType);
            return ResponseEntity.ok(url);
        } catch (BusinessException e) {
            logger.error("get ShareImage Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR).body(Result.error(e));
        } catch (Exception e) {
            logger.error("get ShareImage Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR)
                    .body(Result.error(CommonConstants.SERVER_ERROR, e.getMessage()));
        }
    }

    @ApiOperation(value = "根据主键查询分享图片详情")
    @ApiResponses({
            @ApiResponse(code = 200, response = ShareImageResult.class, message = "分享图片地址"),
            @ApiResponse(code = 500, response = String.class, message = "服务器错误")
    })
    @RequestMapping(value = "/v1/shareImage/getShareBookUrl/{recId}", method = RequestMethod.GET)
    public ResponseEntity getShareBookUrl(@PathVariable("recId") String recId) {
        try {
            User user = UserContext.getUser();
            String shareType = "bookAudio";

            String url = shareImageService.getShareUrl(recId, user,shareType);
            return ResponseEntity.ok(url);
        } catch (BusinessException e) {
            logger.error("get ShareImage Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR).body(Result.error(e));
        } catch (Exception e) {
            logger.error("get ShareImage Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR)
                    .body(Result.error(CommonConstants.SERVER_ERROR, e.getMessage()));
        }
    }

    @ApiOperation(value = "根据主键查询分享图片详情")
    @ApiResponses({
            @ApiResponse(code = 200, response = ShareImageResult.class, message = "分享图片地址"),
            @ApiResponse(code = 500, response = String.class, message = "服务器错误")
    })
    @RequestMapping(value = "/v1/shareImage/getShareUrlByBook/{recId}", method = RequestMethod.GET)
    public ResponseEntity getShareUrlByBook(@PathVariable("recId") String recId) {
        try {
            User user = UserContext.getUser();
            String shareType = "book";

            String url = shareImageService.getShareUrl(recId, user,shareType);
            return ResponseEntity.ok(url);
        } catch (BusinessException e) {
            logger.error("get ShareImage Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR).body(Result.error(e));
        } catch (Exception e) {
            logger.error("get ShareImage Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR)
                    .body(Result.error(CommonConstants.SERVER_ERROR, e.getMessage()));
        }
    }

    @ApiOperation(value = "根据主键查询课程分享图片详情")
    @ApiResponses({
            @ApiResponse(code = 200, response = ShareImageResult.class, message = "分享图片地址"),
            @ApiResponse(code = 500, response = String.class, message = "服务器错误")
    })
    @RequestMapping(value = "/v1/shareImage/getShareUrlByLesson/{recId}", method = RequestMethod.GET)
    public ResponseEntity getShareUrlByLesson(@PathVariable("recId") String recId) {
        try {
            User user = UserContext.getUser();
            String shareType = "lesson";

            String url = shareImageService.getLessonShareUrl(recId, user,shareType);
            return ResponseEntity.ok(url);
        } catch (BusinessException e) {
            logger.error("get ShareImage Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR).body(Result.error(e));
        } catch (Exception e) {
            logger.error("get ShareImage Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR)
                    .body(Result.error(CommonConstants.SERVER_ERROR, e.getMessage()));
        }
    }

    @ApiOperation(value = "根据主键查询issue分享图片详情")
    @ApiResponses({
            @ApiResponse(code = 200, response = ShareImageResult.class, message = "分享issue图片地址"),
            @ApiResponse(code = 500, response = String.class, message = "服务器错误")
    })
    @RequestMapping(value = "/v1/shareImage/getShareUrlByIssue", method = RequestMethod.GET)
    public ResponseEntity getShareUrlByIssue(IssueParam param) {
        try {
            User user = UserContext.getUser();
            String shareType = "issue";

            String url = shareImageService.getIssueShareUrl( user,shareType,param.getBelongTo(),param.getBelongToId());
            return ResponseEntity.ok(url);
        } catch (BusinessException e) {
            logger.error("get ShareImage Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR).body(Result.error(e));
        } catch (Exception e) {
            logger.error("get ShareImage Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR)
                    .body(Result.error(CommonConstants.SERVER_ERROR, e.getMessage()));
        }
    }


}