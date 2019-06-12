package com.synapse.reading.controller;

import com.synapse.common.constants.PageInfo;
import com.synapse.common.trans.Result;
import com.synapse.common.sso.context.UserContext;
import com.synapse.common.sso.model.User;
import com.synapse.reading.dto.param.OrderNumParam;
import com.synapse.reading.dto.result.ExpertResult;
import com.synapse.reading.dto.result.MemberResult;
import com.synapse.reading.event.EventBus;
import com.synapse.reading.event.message.ClickLessonEvent;
import com.synapse.reading.model.Lesson;
import com.synapse.reading.dto.param.LessonParam;
import com.synapse.reading.dto.result.LessonResult;
import com.synapse.reading.model.Member;
import com.synapse.reading.service.LessonService;
import com.synapse.reading.service.MemberService;
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
 * 课程 Controller
 * </p>
 *
 * @author liuguangfu
 * @since 2019-02-15
 */
@Api(tags = "LessonController")
@RestController
@RequestMapping("/reading")
public class LessonController extends BaseController {

    private Logger logger = LoggerFactory.getLogger(LessonController.class);

    @Autowired
    private LessonService lessonService;

    @Autowired
    private MemberService memberService;
    @Autowired
    private EventBus eventBus;

    @ApiOperation(value = "查询Lesson列表(分页)")
    @ApiResponses({
            @ApiResponse(code = 200, response = LessonResult.class, message = "Lesson列表"),
            @ApiResponse(code = 1002, response = String.class, message = "字段校验错误"),
            @ApiResponse(code = 500, response = String.class, message = "服务器错误")
    })
    @ApiImplicitParams({
            @ApiImplicitParam(name = "recId", paramType = "query"),
            @ApiImplicitParam(name = "name", paramType = "query"),
            @ApiImplicitParam(name = "intro", paramType = "query"),
            @ApiImplicitParam(name = "presentation", paramType = "query"),
            @ApiImplicitParam(name = "image", paramType = "query"),
            @ApiImplicitParam(name = "banner", paramType = "query"),
            @ApiImplicitParam(name = "publishStatus", paramType = "query"),
            @ApiImplicitParam(name = "status", paramType = "query"),
            @ApiImplicitParam(name = "orderNum", paramType = "query"),
            @ApiImplicitParam(name = "visitNum", paramType = "query"),
            @ApiImplicitParam(name = "createId", paramType = "query"),
            @ApiImplicitParam(name = "createTime", paramType = "query"),
            @ApiImplicitParam(name = "updateId", paramType = "query"),
            @ApiImplicitParam(name = "updateTime", paramType = "query")})
    @RequestMapping(value = "/v1/lesson", method = RequestMethod.GET)
    public ResponseEntity list(PageInfo pageInfo, @Validated(Search.class) LessonParam param, BindingResult bindingResult) {
        try {
            //验证失败
            if (bindingResult.hasErrors()) {
                throw new ValidException(bindingResult.getFieldError().getDefaultMessage());
            }
            int totalNum = lessonService.count(param.getModel());
            preparePageInfo(pageInfo, totalNum);
            List<Lesson> models = lessonService.list(param.getModel(), pageInfo);
            List<LessonResult> results = models.stream().map(it -> new LessonResult(it)).collect(Collectors.toList());
            Map<String, Object> map = new HashMap();
            map.put("lessonList", results);
            map.put("totalNum", totalNum);
            return ResponseEntity.ok(map);
        } catch (BusinessException e) {
            logger.error("list Lesson Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR).body(Result.error(e));
        } catch (Exception e) {
            logger.error("list Lesson Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR)
                    .body(Result.error(CommonConstants.SERVER_ERROR, e.getMessage()));
        }
    }

    @ApiOperation(value = "查询专家的Lesson列表(目前查询每个专家两个视频分页)")
    @ApiResponses({
            @ApiResponse(code = 200, response = LessonResult.class, message = "Lesson列表"),
            @ApiResponse(code = 1002, response = String.class, message = "字段校验错误"),
            @ApiResponse(code = 500, response = String.class, message = "服务器错误")
    })

    @RequestMapping(value = "/v1/lesson/expert", method = RequestMethod.GET)
    public ResponseEntity listbyexpert(PageInfo pageInfo,BindingResult bindingResult) {
        try {
            //验证失败
            if (bindingResult.hasErrors()) {
                throw new ValidException(bindingResult.getFieldError().getDefaultMessage());
            }
            logger.warn("-------------------------------pageInfo"+pageInfo.getCurrentPageIndex());
            logger.warn("-------------------------------pageInfo"+pageInfo.getCurrentStartIndex());
            int totalNum = lessonService.countListbyexpert();
            preparePageInfo(pageInfo, totalNum);
            List<ExpertResult> results = lessonService.listbyexpert(pageInfo);
            Map<String, Object> map = new HashMap();
            map.put("memberList", results);
            map.put("totalNum", totalNum);
            return ResponseEntity.ok(map);
        } catch (BusinessException e) {
            logger.error("list Lesson Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR).body(Result.error(e));
        } catch (Exception e) {
            logger.error("list Lesson Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR)
                    .body(Result.error(CommonConstants.SERVER_ERROR, e.getMessage()));
        }
    }

    @ApiOperation(value = "查询专家的Lesson列表(目前查询专家所有课程分页)")
    @ApiResponses({
            @ApiResponse(code = 200, response = LessonResult.class, message = "Lesson列表"),
            @ApiResponse(code = 1002, response = String.class, message = "字段校验错误"),
            @ApiResponse(code = 500, response = String.class, message = "服务器错误")
    })

    @RequestMapping(value = "/v1/lesson/expertAll/{expertId}", method = RequestMethod.GET)
    public ResponseEntity listbyexpertAll(PageInfo pageInfo,@PathVariable("expertId") String expertId) {
        try {
            //验证失败
            int totalNum = lessonService.countListbyexpertAll(expertId);
            preparePageInfo(pageInfo, totalNum);
            List<Lesson> models = lessonService.listbyexpertAll(expertId,pageInfo);
            List<LessonResult> results = models.stream().map(it -> new LessonResult(it)).collect(Collectors.toList());
            Map<String, Object> map = new HashMap();
            map.put("lessonList", results);
            map.put("totalNum", totalNum);
            return ResponseEntity.ok(map);
        } catch (BusinessException e) {
            logger.error("list Lesson Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR).body(Result.error(e));
        } catch (Exception e) {
            logger.error("list Lesson Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR)
                    .body(Result.error(CommonConstants.SERVER_ERROR, e.getMessage()));
        }
    }


    @ApiOperation(value = "根据主键查询Lesson详情")
    @ApiResponses({
            @ApiResponse(code = 200, response = LessonResult.class, message = "Lesson对象"),
            @ApiResponse(code = 500, response = String.class, message = "服务器错误")
    })
    @RequestMapping(value = "/v1/lesson/{recId}", method = RequestMethod.GET)
    public ResponseEntity get(@PathVariable("recId") String recId) {
        try {
            Lesson lesson = lessonService.find(recId);
            return ResponseEntity.ok(new LessonResult(lesson));
        } catch (BusinessException e) {
            logger.error("get Lesson Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR).body(Result.error(e));
        } catch (Exception e) {
            logger.error("get Lesson Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR)
                    .body(Result.error(CommonConstants.SERVER_ERROR, e.getMessage()));
        }
    }

    @ApiOperation(value = "创建Lesson")
    @ApiResponses({
            @ApiResponse(code = 200, response = String.class, message = "主键"),
            @ApiResponse(code = 1002, response = String.class, message = "字段校验错误"),
            @ApiResponse(code = 500, response = String.class, message = "服务器错误")
    })
    @RequestMapping(value = "/v1/lesson", method = RequestMethod.POST)
    public ResponseEntity create(@RequestBody @Validated(Create.class) LessonParam param, BindingResult bindingResult) {
        try {
            //验证失败
            if (bindingResult.hasErrors()) {
                throw new ValidException(bindingResult.getFieldError().getDefaultMessage());
            }
            User user = UserContext.getUser();
            //todo 根据角色判断权限

            Lesson model = param.getModel();
            model.setCreateId(user.getRecId());
            model.setUpdateId(user.getRecId());
            String recId = lessonService.create(model);
            return ResponseEntity.ok(recId);
        } catch (BusinessException e) {
            logger.error("create Lesson Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR).body(Result.error(e));
        } catch (Exception e) {
            logger.error("create Lesson Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR)
                    .body(Result.error(CommonConstants.SERVER_ERROR, e.getMessage()));
        }
    }

    @ApiOperation(value = "根据主键删除Lesson")
    @ApiResponses({
            @ApiResponse(code = 200, response = Integer.class, message = "删除数量"),
            @ApiResponse(code = 500, response = String.class, message = "服务器错误")
    })
    @RequestMapping(value = "/v1/lesson/{recId}", method = RequestMethod.DELETE)
    public ResponseEntity delete(@PathVariable("recId") String recId) {
        try {
            User user = UserContext.getUser();
            //todo 根据角色判断权限

            Integer num = lessonService.delete(recId, user.getRecId());
            return ResponseEntity.ok(num);
        } catch (BusinessException e) {
            logger.error("delete Lesson Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR).body(Result.error(e));
        } catch (Exception e) {
            logger.error("delete Lesson Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR)
                    .body(Result.error(CommonConstants.SERVER_ERROR, e.getMessage()));
        }
    }


    @ApiOperation(value = "根据主键删除Lesson(包含章节，视频)")
    @ApiResponses({
            @ApiResponse(code = 200, response = Integer.class, message = "删除数量"),
            @ApiResponse(code = 500, response = String.class, message = "服务器错误")
    })
    @RequestMapping(value = "/v1/deleteAll/{recId}", method = RequestMethod.DELETE)
    public ResponseEntity deleteAll(@PathVariable("recId") String recId) {
        try {
            User user = UserContext.getUser();
            //todo 根据角色判断权限

            Integer num = lessonService.deleteAll(recId, user.getRecId());
            return ResponseEntity.ok(num);
        } catch (BusinessException e) {
            logger.error("delete Lesson Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR).body(Result.error(e));
        } catch (Exception e) {
            logger.error("delete Lesson Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR)
                    .body(Result.error(CommonConstants.SERVER_ERROR, e.getMessage()));
        }
    }

    @ApiOperation(value = "根据主键更新Lesson")
    @ApiResponses({
            @ApiResponse(code = 200, response = Integer.class, message = "更新数量"),
            @ApiResponse(code = 1002, response = String.class, message = "字段校验错误"),
            @ApiResponse(code = 500, response = String.class, message = "服务器错误")
    })
    @RequestMapping(value = "/v1/lesson/{recId}", method = RequestMethod.PUT)
    public ResponseEntity update(@PathVariable("recId") String recId, @RequestBody @Validated(Update.class) LessonParam param, BindingResult bindingResult) {
        try {
            //验证失败
            if (bindingResult.hasErrors()) {
                throw new ValidException(bindingResult.getFieldError().getDefaultMessage());
            }
            User user = UserContext.getUser();
            //todo 根据角色判断权限

            Lesson model = param.getModel();
            model.setRecId(recId);
            model.setUpdateId(user.getRecId());
            Integer num = lessonService.update(model);
            return ResponseEntity.ok(num);
        } catch (BusinessException e) {
            logger.error("update Lesson Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR).body(Result.error(e));
        } catch (Exception e) {
            logger.error("update Lesson Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR)
                    .body(Result.error(CommonConstants.SERVER_ERROR, e.getMessage()));
        }
    }

    @ApiOperation(value = "拖拽更新课程排列顺序")
    @ApiResponses({
            @ApiResponse(code = 200, response = Integer.class, message = "更新数量"),
            @ApiResponse(code = 1002, response = String.class, message = "字段校验错误"),
            @ApiResponse(code = 500, response = String.class, message = "服务器错误")
    })
    @RequestMapping(value = "/v1/lesson/updatByorderNum", method = RequestMethod.PUT)
    public ResponseEntity updatByorderNum(@RequestBody @Validated(Update.class)  List<OrderNumParam> list, BindingResult bindingResult) {
        try {
            //验证失败
            if (bindingResult.hasErrors()) {
                throw new ValidException(bindingResult.getFieldError().getDefaultMessage());
            }
            User user = UserContext.getUser();
            //todo 根据角色判断权限
            Integer num = lessonService.updatByorderNum(list);
            return ResponseEntity.ok(num);
        } catch (BusinessException e) {
            logger.error("update Lesson Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR).body(Result.error(e));
        } catch (Exception e) {
            logger.error("update Lesson Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR)
                    .body(Result.error(CommonConstants.SERVER_ERROR, e.getMessage()));
        }
    }


    @ApiOperation(value = "创建课程，若需要章节，则创建，视频是添加进章节或课程")
    @ApiResponses({
            @ApiResponse(code = 200, response = String.class, message = "主键"),
            @ApiResponse(code = 1002, response = String.class, message = "字段校验错误"),
            @ApiResponse(code = 500, response = String.class, message = "服务器错误")
    })
    @RequestMapping(value = "/v1/lessonDetail", method = RequestMethod.POST)
    public ResponseEntity createLesson(@RequestBody @Validated(Create.class) LessonParam param, BindingResult bindingResult) {
        try {
            //验证失败
            if (bindingResult.hasErrors()) {
                throw new ValidException(bindingResult.getFieldError().getDefaultMessage());
            }
            User user = UserContext.getUser();
            //todo 根据角色判断权限

            Lesson model = param.getModel();
            model.setCreateId(user.getRecId());
            model.setUpdateId(user.getRecId());
            String recId = lessonService.createLesson(model, param.getSectionList(), param.getVideoList());
            return ResponseEntity.ok(recId);
        } catch (BusinessException e) {
            logger.error("create lessonDetail Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR).body(Result.error(e));
        } catch (Exception e) {
            logger.error("create lessonDetail Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR)
                    .body(Result.error(CommonConstants.SERVER_ERROR, e.getMessage()));
        }
    }

    @ApiOperation(value = "更新课程，若需要章节，则创建，视频是添加进章节或课程")
    @ApiResponses({
            @ApiResponse(code = 200, response = String.class, message = "主键"),
            @ApiResponse(code = 1002, response = String.class, message = "字段校验错误"),
            @ApiResponse(code = 500, response = String.class, message = "服务器错误")
    })
    @RequestMapping(value = "/v1/lessonDetail", method = RequestMethod.PUT)
    public ResponseEntity updateLesson(@RequestBody @Validated(Create.class) LessonParam param, BindingResult bindingResult) {
        try {
            //验证失败
            if (bindingResult.hasErrors()) {
                throw new ValidException(bindingResult.getFieldError().getDefaultMessage());
            }
            User user = UserContext.getUser();
            //todo 根据角色判断权限

            Lesson model = param.getModel();
            model.setCreateId(user.getRecId());
            model.setUpdateId(user.getRecId());
            String recId = lessonService.updateLesson(model, param.getSectionList(), param.getVideoList());
            return ResponseEntity.ok(recId);
        } catch (BusinessException e) {
            logger.error("create lessonDetail Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR).body(Result.error(e));
        } catch (Exception e) {
            logger.error("create lessonDetail Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR)
                    .body(Result.error(CommonConstants.SERVER_ERROR, e.getMessage()));
        }
    }

    @ApiOperation(value = "查询Lesson详情")
    @ApiResponses({
            @ApiResponse(code = 200, response = LessonResult.class, message = "Lesson对象"),
            @ApiResponse(code = 500, response = String.class, message = "服务器错误")
    })
    @RequestMapping(value = "/v1/lessonDetail/{recId}", method = RequestMethod.GET)
    public ResponseEntity getLesson(@PathVariable("recId") String recId) {
        try {
            LessonResult lesson = lessonService.getLesson(recId);
            eventBus.add(new ClickLessonEvent(this, recId));
            return ResponseEntity.ok(lesson);
        } catch (BusinessException e) {
            logger.error("get Lesson Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR).body(Result.error(e));
        } catch (Exception e) {
            logger.error("get Lesson Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR)
                    .body(Result.error(CommonConstants.SERVER_ERROR, e.getMessage()));
        }
    }

    @ApiOperation(value = "判断Lesson是否已经购买")
    @ApiResponses({
            @ApiResponse(code = 200, response = LessonResult.class, message = "是否查询到记录"),
            @ApiResponse(code = 500, response = String.class, message = "服务器错误")
    })
    @RequestMapping(value = "/v1/lessonDetail/buy/{recId}", method = RequestMethod.GET)
    public ResponseEntity lessonBuy(@PathVariable("recId") String recId) {
        try {
            User user = UserContext.getUser();
            Member member = memberService.getMember(user.getRecId());
            int totalNum = lessonService.lessonBuy(recId, member);
            return ResponseEntity.ok(totalNum);
        } catch (BusinessException e) {
            logger.error("get Lesson Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR).body(Result.error(e));
        } catch (Exception e) {
            logger.error("get Lesson Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR)
                    .body(Result.error(CommonConstants.SERVER_ERROR, e.getMessage()));
        }
    }

    @ApiOperation(value = "查询Lesson列表(查询当前用户的可观看的课程)")
    @ApiResponses({
            @ApiResponse(code = 200, response = LessonResult.class, message = "Lesson列表"),
            @ApiResponse(code = 1002, response = String.class, message = "字段校验错误"),
            @ApiResponse(code = 500, response = String.class, message = "服务器错误")
    })
    @ApiImplicitParams({
            @ApiImplicitParam(name = "recId", paramType = "query"),
            @ApiImplicitParam(name = "name", paramType = "query"),
            @ApiImplicitParam(name = "intro", paramType = "query"),
            @ApiImplicitParam(name = "presentation", paramType = "query"),
            @ApiImplicitParam(name = "image", paramType = "query"),
            @ApiImplicitParam(name = "banner", paramType = "query"),
            @ApiImplicitParam(name = "publishStatus", paramType = "query"),
            @ApiImplicitParam(name = "status", paramType = "query"),
            @ApiImplicitParam(name = "orderNum", paramType = "query"),
            @ApiImplicitParam(name = "visitNum", paramType = "query"),
            @ApiImplicitParam(name = "createId", paramType = "query"),
            @ApiImplicitParam(name = "createTime", paramType = "query"),
            @ApiImplicitParam(name = "updateId", paramType = "query"),
            @ApiImplicitParam(name = "updateTime", paramType = "query")})
    @RequestMapping(value = "/v1/lesson/buyOrg", method = RequestMethod.GET)
    public ResponseEntity listLessonByOrg(PageInfo pageInfo) {
        try {
            User user = UserContext.getUser();
            Member member = memberService.getMember(user.getRecId());
            int totalNum = lessonService.countListLessonByOrg(member);
            preparePageInfo(pageInfo, totalNum);
            List<Lesson> models = lessonService.listLessonByOrg(member, pageInfo);
            List<LessonResult> results = models.stream().map(it -> new LessonResult(it)).collect(Collectors.toList());
            Map<String, Object> map = new HashMap();
            map.put("lessonList", results);
            map.put("totalNum", totalNum);
            return ResponseEntity.ok(map);
        } catch (BusinessException e) {
            logger.error("list Lesson Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR).body(Result.error(e));
        } catch (Exception e) {
            logger.error("list Lesson Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR)
                    .body(Result.error(CommonConstants.SERVER_ERROR, e.getMessage()));
        }
    }

    @ApiOperation(value = "查询Lesson列表(查询当前用户的可观看的课程)")
    @ApiResponses({
            @ApiResponse(code = 200, response = LessonResult.class, message = "Lesson列表"),
            @ApiResponse(code = 1002, response = String.class, message = "字段校验错误"),
            @ApiResponse(code = 500, response = String.class, message = "服务器错误")
    })
    @ApiImplicitParams({
            @ApiImplicitParam(name = "recId", paramType = "query"),
            @ApiImplicitParam(name = "name", paramType = "query"),
            @ApiImplicitParam(name = "intro", paramType = "query"),
            @ApiImplicitParam(name = "presentation", paramType = "query"),
            @ApiImplicitParam(name = "image", paramType = "query"),
            @ApiImplicitParam(name = "banner", paramType = "query"),
            @ApiImplicitParam(name = "publishStatus", paramType = "query"),
            @ApiImplicitParam(name = "status", paramType = "query"),
            @ApiImplicitParam(name = "orderNum", paramType = "query"),
            @ApiImplicitParam(name = "visitNum", paramType = "query"),
            @ApiImplicitParam(name = "createId", paramType = "query"),
            @ApiImplicitParam(name = "createTime", paramType = "query"),
            @ApiImplicitParam(name = "updateId", paramType = "query"),
            @ApiImplicitParam(name = "updateTime", paramType = "query")})
    @RequestMapping(value = "/v1/lesson/buyMyself", method = RequestMethod.GET)
    public ResponseEntity listLessonByMyself(PageInfo pageInfo) {
        try {
            User user = UserContext.getUser();
            Member member = memberService.getMember(user.getRecId());
            int totalNum = lessonService.countListLessonByMyself(member);
            preparePageInfo(pageInfo, totalNum);
            List<Lesson> models = lessonService.listLessonByMyself(member, pageInfo);
            List<LessonResult> results = models.stream().map(it -> new LessonResult(it)).collect(Collectors.toList());
            Map<String, Object> map = new HashMap();
            map.put("lessonList", results);
            map.put("totalNum", totalNum);
            return ResponseEntity.ok(map);
        } catch (BusinessException e) {
            logger.error("list Lesson Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR).body(Result.error(e));
        } catch (Exception e) {
            logger.error("list Lesson Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR)
                    .body(Result.error(CommonConstants.SERVER_ERROR, e.getMessage()));
        }
    }

}