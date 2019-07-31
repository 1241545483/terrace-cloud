package com.synapse.reading.controller;

import com.synapse.common.constants.PageInfo;
import com.synapse.common.trans.Result;
import com.synapse.common.sso.context.UserContext;
import com.synapse.common.sso.model.User;
import com.synapse.reading.constants.TradeOrderConstants;
import com.synapse.reading.dto.param.BuyByUserParam;
import com.synapse.reading.dto.param.SchoolTradeOrderParam;
import com.synapse.reading.dto.result.TradeOrderDetailResult;
import com.synapse.reading.model.Book;
import com.synapse.reading.model.Lesson;
import com.synapse.reading.model.TradeOrder;
import com.synapse.reading.dto.param.TradeOrderParam;
import com.synapse.reading.dto.result.TradeOrderResult;
import com.synapse.reading.service.BaseSystemParameterBaseService;
import com.synapse.reading.service.BaseSystemParameterService;
import com.synapse.reading.service.MemberService;
import com.synapse.reading.service.TradeOrderService;
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
 * 订单 Controller
 * </p>
 *
 * @author liuguangfu
 * @since 2019-04-10
 */
@Api(tags = "TradeOrderController")
@RestController
@RequestMapping("/reading")
public class TradeOrderController extends BaseController {

    private Logger logger = LoggerFactory.getLogger(TradeOrderController.class);

    @Autowired
    private TradeOrderService tradeOrderService;
    @Autowired
    private MemberService memberService;
    @Autowired
    private BaseSystemParameterService baseSystemParameterService;

    @ApiOperation(value = "查询TradeOrder列表(分页)")
    @ApiResponses({
            @ApiResponse(code = 200, response = TradeOrderResult.class, message = "TradeOrder列表"),
            @ApiResponse(code = 1002, response = String.class, message = "字段校验错误"),
            @ApiResponse(code = 500, response = String.class, message = "服务器错误")
    })
    @ApiImplicitParams({
            @ApiImplicitParam(name = "recId", paramType = "query"),
            @ApiImplicitParam(name = "name", paramType = "query"),
            @ApiImplicitParam(name = "intro", paramType = "query"),
            @ApiImplicitParam(name = "payWay", paramType = "query"),
            @ApiImplicitParam(name = "price", paramType = "query"),
            @ApiImplicitParam(name = "status", paramType = "query"),
            @ApiImplicitParam(name = "createId", paramType = "query"),
            @ApiImplicitParam(name = "createTime", paramType = "query"),
            @ApiImplicitParam(name = "updateId", paramType = "query"),
            @ApiImplicitParam(name = "updateTime", paramType = "query")})
    @RequestMapping(value = "/v1/tradeOrder", method = RequestMethod.GET)
    public ResponseEntity list(PageInfo pageInfo, @Validated(Search.class) TradeOrderParam param, BindingResult bindingResult) {
        try {
            //验证失败
            if (bindingResult.hasErrors()) {
                throw new ValidException(bindingResult.getFieldError().getDefaultMessage());
            }
            int totalNum = tradeOrderService.count(param.getModel());
            preparePageInfo(pageInfo, totalNum);
            List<TradeOrder> models = tradeOrderService.list(param.getModel(), pageInfo);
            List<TradeOrderResult> results = models.stream().map(it -> new TradeOrderResult(it)).collect(Collectors.toList());
            Map<String, Object> map = new HashMap();
            map.put("tradeOrderList", results);
            map.put("totalNum", totalNum);
            return ResponseEntity.ok(map);
        } catch (BusinessException e) {
            logger.error("list TradeOrder Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR).body(Result.error(e));
        } catch (Exception e) {
            logger.error("list TradeOrder Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR)
                    .body(Result.error(CommonConstants.SERVER_ERROR, e.getMessage()));
        }
    }

    @ApiOperation(value = "查询TradeOrder列表(分页，校管理员)")
    @ApiResponses({
            @ApiResponse(code = 200, response = TradeOrderResult.class, message = "TradeOrder列表"),
            @ApiResponse(code = 1002, response = String.class, message = "字段校验错误"),
            @ApiResponse(code = 500, response = String.class, message = "服务器错误")
    })
    @ApiImplicitParams({
            @ApiImplicitParam(name = "recId", paramType = "query"),
            @ApiImplicitParam(name = "name", paramType = "query"),
            @ApiImplicitParam(name = "intro", paramType = "query"),
            @ApiImplicitParam(name = "payWay", paramType = "query"),
            @ApiImplicitParam(name = "price", paramType = "query"),
            @ApiImplicitParam(name = "status", paramType = "query"),
            @ApiImplicitParam(name = "createId", paramType = "query"),
            @ApiImplicitParam(name = "createTime", paramType = "query"),
            @ApiImplicitParam(name = "updateId", paramType = "query"),
            @ApiImplicitParam(name = "updateTime", paramType = "query")})
    @RequestMapping(value = "/v1/tradeOrder/school", method = RequestMethod.GET)
    public ResponseEntity listOrder(PageInfo pageInfo, @Validated(Search.class) TradeOrderParam param, BindingResult bindingResult) {
        try {
            //验证失败
            if (bindingResult.hasErrors()) {
                throw new ValidException(bindingResult.getFieldError().getDefaultMessage());
            }
            int totalNum = tradeOrderService.count(param.getModel());
            preparePageInfo(pageInfo, totalNum);
            List<TradeOrderResult> results = tradeOrderService.listOrder(param.getModel(), pageInfo);
            Map<String, Object> map = new HashMap();
            map.put("tradeOrderList", results);
            map.put("totalNum", totalNum);
            return ResponseEntity.ok(map);
        } catch (BusinessException e) {
            logger.error("list TradeOrder Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR).body(Result.error(e));
        } catch (Exception e) {
            logger.error("list TradeOrder Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR)
                    .body(Result.error(CommonConstants.SERVER_ERROR, e.getMessage()));
        }
    }

    @ApiOperation(value = "查询学校已购买课程或书籍)")
    @ApiResponses({
            @ApiResponse(code = 200, response = TradeOrderResult.class, message = "TradeOrder列表"),
            @ApiResponse(code = 1002, response = String.class, message = "字段校验错误"),
            @ApiResponse(code = 500, response = String.class, message = "服务器错误")
    })
    @RequestMapping(value = "/v1/tradeOrder/school/buy", method = RequestMethod.GET)
    public ResponseEntity listBuy(PageInfo pageInfo, @Validated(Search.class) SchoolTradeOrderParam param, BindingResult bindingResult) {
        try {
            //验证失败
            if (bindingResult.hasErrors()) {
                throw new ValidException(bindingResult.getFieldError().getDefaultMessage());
            }
            int totalNum = 0;
            if (param.getType().equals(TradeOrderConstants.ORDERTYPE.LESSON.value())) {
                preparePageInfo(pageInfo, totalNum);
                List<Lesson> results = tradeOrderService.listBuyLesson(param, pageInfo);
                totalNum = results.size();
                Map<String, Object> map = new HashMap();
                map.put("ProdList", results);
                map.put("totalNum", totalNum);
                return ResponseEntity.ok(map);
            }
            if (param.getType().equals(TradeOrderConstants.ORDERTYPE.BOOK.value())) {
                preparePageInfo(pageInfo, totalNum);
                List<Book> results = tradeOrderService.listBuyBook(param, pageInfo);
                totalNum = results.size();
                Map<String, Object> map = new HashMap();
                map.put("orderList", results);
                map.put("totalNum", totalNum);
                return ResponseEntity.ok(map);
            }
            return ResponseEntity.ok(null);
        } catch (BusinessException e) {
            logger.error("list TradeOrder Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR).body(Result.error(e));
        } catch (Exception e) {
            logger.error("list TradeOrder Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR)
                    .body(Result.error(CommonConstants.SERVER_ERROR, e.getMessage()));
        }
    }

    @ApiOperation(value = "查询用户已购买课程和书籍)")
    @ApiResponses({
            @ApiResponse(code = 200, response = TradeOrderResult.class, message = "TradeOrder列表"),
            @ApiResponse(code = 1002, response = String.class, message = "字段校验错误"),
            @ApiResponse(code = 500, response = String.class, message = "服务器错误")
    })
    @RequestMapping(value = "/v1/tradeOrder/user/buy", method = RequestMethod.GET)
    public ResponseEntity listUserBuy(PageInfo pageInfo, String type, BindingResult bindingResult) {
        try {
            //验证失败
            if (bindingResult.hasErrors()) {
                throw new ValidException(bindingResult.getFieldError().getDefaultMessage());
            }
            User user = UserContext.getUser();
            int totalNum = 0;
            if (type.equals(TradeOrderConstants.ORDERTYPE.LESSON.value())) {
                preparePageInfo(pageInfo, totalNum);
                List<TradeOrderDetailResult> results = tradeOrderService.listUserBuyLesson(user, type, pageInfo);
                totalNum = tradeOrderService.countListUserBuyLesson(user, type);
                Map<String, Object> map = new HashMap();
                map.put("orderList", results);
                map.put("totalNum", totalNum);
                return ResponseEntity.ok(map);
            }
            if (type.equals(TradeOrderConstants.ORDERTYPE.VIP.value())) {
                preparePageInfo(pageInfo, totalNum);
                List<TradeOrderDetailResult> results = tradeOrderService.listUserBuyVip(user, type, pageInfo);
                totalNum = tradeOrderService.countListUserBuyLesson(user, type);
                Map<String, Object> map = new HashMap();
                map.put("orderList", results);
                map.put("totalNum", totalNum);
                return ResponseEntity.ok(map);
            }
            if (type.equals(TradeOrderConstants.ORDERTYPE.BOOK.value())) {
                preparePageInfo(pageInfo, totalNum);
                List<TradeOrderDetailResult> results = tradeOrderService.listUserBuyBook(user, type, pageInfo);
                totalNum = tradeOrderService.countListUserBuyBook(user, type);
                Map<String, Object> map = new HashMap();
                map.put("orderList", results);
                map.put("totalNum", totalNum);
                return ResponseEntity.ok(map);
            }
            return ResponseEntity.ok(null);
        } catch (BusinessException e) {
            logger.error("list TradeOrder Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR).body(Result.error(e));
        } catch (Exception e) {
            logger.error("list TradeOrder Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR)
                    .body(Result.error(CommonConstants.SERVER_ERROR, e.getMessage()));
        }
    }


    @ApiOperation(value = "根据主键查询TradeOrder详情")
    @ApiResponses({
            @ApiResponse(code = 200, response = TradeOrderResult.class, message = "TradeOrder对象"),
            @ApiResponse(code = 500, response = String.class, message = "服务器错误")
    })
    @RequestMapping(value = "/v1/tradeOrder/{recId}", method = RequestMethod.GET)
    public ResponseEntity get(@PathVariable("recId") String recId) {
        try {
            TradeOrder tradeOrder = tradeOrderService.find(recId);
            return ResponseEntity.ok(new TradeOrderResult(tradeOrder));
        } catch (BusinessException e) {
            logger.error("get TradeOrder Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR).body(Result.error(e));
        } catch (Exception e) {
            logger.error("get TradeOrder Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR)
                    .body(Result.error(CommonConstants.SERVER_ERROR, e.getMessage()));
        }
    }


    @ApiOperation(value = "查询当前课程或书籍是否已购买")
    @ApiResponses({
            @ApiResponse(code = 200, response = TradeOrderResult.class, message = "是否购买"),
            @ApiResponse(code = 500, response = String.class, message = "服务器错误")
    })
    @RequestMapping(value = "/v1/user/buy", method = RequestMethod.GET)
    public ResponseEntity getUserBuy(@Validated(Search.class) BuyByUserParam param) {
        try {
            User user = UserContext.getUser();
            Boolean valid = tradeOrderService.getUserBuy(param, user);
            return ResponseEntity.ok(valid);
        } catch (BusinessException e) {
            logger.error("get TradeOrder Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR).body(Result.error(e));
        } catch (Exception e) {
            logger.error("get TradeOrder Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR)
                    .body(Result.error(CommonConstants.SERVER_ERROR, e.getMessage()));
        }
    }


    @ApiOperation(value = "根据主键查询TradeOrder详情（当前用户订单）")
    @ApiResponses({
            @ApiResponse(code = 200, response = TradeOrderResult.class, message = "TradeOrder对象"),
            @ApiResponse(code = 500, response = String.class, message = "服务器错误")
    })
    @RequestMapping(value = "/v1/user/tradeOrder/{recId}", method = RequestMethod.GET)
    public ResponseEntity getUserOrder(@PathVariable("recId") String recId) {
        try {
            TradeOrderDetailResult tradeOrder = tradeOrderService.findUserOrder(recId);
            return ResponseEntity.ok(tradeOrder);
        } catch (BusinessException e) {
            logger.error("get TradeOrder Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR).body(Result.error(e));
        } catch (Exception e) {
            logger.error("get TradeOrder Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR)
                    .body(Result.error(CommonConstants.SERVER_ERROR, e.getMessage()));
        }
    }



    @ApiOperation(value = "创建Vip TradeOrder,默认为一年")
    @ApiResponses({
            @ApiResponse(code = 200, response = String.class, message = "主键"),
            @ApiResponse(code = 1002, response = String.class, message = "字段校验错误"),
            @ApiResponse(code = 500, response = String.class, message = "服务器错误")
    })
    @RequestMapping(value = "/v1/tradeOrder/vip", method = RequestMethod.POST)
    public ResponseEntity createVip(@RequestBody  Map<String,String> map) {
        try {

            User user = UserContext.getUser();
            //todo 根据角色判断权限
            logger.info("________________________parameterValue"+baseSystemParameterService.getMapByType("Vip_Price").get(0).get("parameterValue"));
            logger.info("________________________price"+map.get("price"));
           if(map.get("price")!=null&&map.get("price").equals(baseSystemParameterService.getMapByType("Vip_Price").get(0).get("parameterValue"))){
                String num = tradeOrderService.createOrderByVipCode( user.getRecId(),map.get("price"));
                return ResponseEntity.ok(num);
            }
            return ResponseEntity.ok(0);
        } catch (BusinessException e) {
            logger.error("create TradeOrder Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR).body(Result.error(e));
        } catch (Exception e) {
            logger.error("create TradeOrder Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR)
                    .body(Result.error(CommonConstants.SERVER_ERROR, e.getMessage()));
        }
    }


    @ApiOperation(value = "创建TradeOrder")
    @ApiResponses({
            @ApiResponse(code = 200, response = String.class, message = "主键"),
            @ApiResponse(code = 1002, response = String.class, message = "字段校验错误"),
            @ApiResponse(code = 500, response = String.class, message = "服务器错误")
    })
    @RequestMapping(value = "/v1/tradeOrder", method = RequestMethod.POST)
    public ResponseEntity create(@RequestBody @Validated(Create.class) TradeOrderParam param, BindingResult bindingResult) {
        try {
            //验证失败
            if (bindingResult.hasErrors()) {
                throw new ValidException(bindingResult.getFieldError().getDefaultMessage());
            }
            User user = UserContext.getUser();
            //todo 根据角色判断权限

            TradeOrder model = param.getModel();
            model.setCreateId(user.getRecId());
            model.setUpdateId(user.getRecId());
            String recId = tradeOrderService.create(model);
            return ResponseEntity.ok(recId);
        } catch (BusinessException e) {
            logger.error("create TradeOrder Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR).body(Result.error(e));
        } catch (Exception e) {
            logger.error("create TradeOrder Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR)
                    .body(Result.error(CommonConstants.SERVER_ERROR, e.getMessage()));
        }
    }


    @ApiOperation(value = "创建TradeOrder,校管理员导入")
    @ApiResponses({
            @ApiResponse(code = 200, response = String.class, message = "主键"),
            @ApiResponse(code = 1002, response = String.class, message = "字段校验错误"),
            @ApiResponse(code = 500, response = String.class, message = "服务器错误")
    })
    @RequestMapping(value = "/v1/tradeOrder/school", method = RequestMethod.POST)
    public ResponseEntity createBySchool(@RequestBody @Validated(Create.class) SchoolTradeOrderParam param, BindingResult bindingResult) {
        try {
            //验证失败
            if (bindingResult.hasErrors()) {
                throw new ValidException(bindingResult.getFieldError().getDefaultMessage());
            }
            User user = UserContext.getUser();
            //todo 根据角色判断权限
            String recId = tradeOrderService.createBySchool(param, user);
            return ResponseEntity.ok(recId);
        } catch (BusinessException e) {
            logger.error("create TradeOrder Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR).body(Result.error(e));
        } catch (Exception e) {
            logger.error("create TradeOrder Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR)
                    .body(Result.error(CommonConstants.SERVER_ERROR, e.getMessage()));
        }
    }

    @ApiOperation(value = "根据主键删除TradeOrder")
    @ApiResponses({
            @ApiResponse(code = 200, response = Integer.class, message = "删除数量"),
            @ApiResponse(code = 500, response = String.class, message = "服务器错误")
    })
    @RequestMapping(value = "/v1/tradeOrder/{recId}", method = RequestMethod.DELETE)
    public ResponseEntity delete(@PathVariable("recId") String recId) {
        try {
            User user = UserContext.getUser();
            //todo 根据角色判断权限

            Integer num = tradeOrderService.delete(recId, user.getRecId());
            return ResponseEntity.ok(num);
        } catch (BusinessException e) {
            logger.error("delete TradeOrder Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR).body(Result.error(e));
        } catch (Exception e) {
            logger.error("delete TradeOrder Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR)
                    .body(Result.error(CommonConstants.SERVER_ERROR, e.getMessage()));
        }
    }

    @ApiOperation(value = "根据主键删除TradeOrder,校管理员导入")
    @ApiResponses({
            @ApiResponse(code = 200, response = Integer.class, message = "删除数量"),
            @ApiResponse(code = 500, response = String.class, message = "服务器错误")
    })
    @RequestMapping(value = "/v1/tradeOrder/school/{recId}", method = RequestMethod.DELETE)
    public ResponseEntity deleteBySchool(@PathVariable("recId") String recId) {
        try {
            User user = UserContext.getUser();
            //todo 根据角色判断权限

            Integer num = tradeOrderService.deleteBySchool(recId, user.getRecId());
            return ResponseEntity.ok(num);
        } catch (BusinessException e) {
            logger.error("delete TradeOrder Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR).body(Result.error(e));
        } catch (Exception e) {
            logger.error("delete TradeOrder Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR)
                    .body(Result.error(CommonConstants.SERVER_ERROR, e.getMessage()));
        }
    }


    @ApiOperation(value = "根据主键更新TradeOrder")
    @ApiResponses({
            @ApiResponse(code = 200, response = Integer.class, message = "更新数量"),
            @ApiResponse(code = 1002, response = String.class, message = "字段校验错误"),
            @ApiResponse(code = 500, response = String.class, message = "服务器错误")
    })
    @RequestMapping(value = "/v1/tradeOrder/{recId}", method = RequestMethod.PUT)
    public ResponseEntity update(@PathVariable("recId") String recId, @RequestBody @Validated(Update.class) TradeOrderParam param, BindingResult bindingResult) {
        try {
            //验证失败
            if (bindingResult.hasErrors()) {
                throw new ValidException(bindingResult.getFieldError().getDefaultMessage());
            }
            User user = UserContext.getUser();
            //todo 根据角色判断权限

            TradeOrder model = param.getModel();
            model.setRecId(recId);
            model.setUpdateId(user.getRecId());
            Integer num = tradeOrderService.update(model);
            return ResponseEntity.ok(num);
        } catch (BusinessException e) {
            logger.error("update TradeOrder Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR).body(Result.error(e));
        } catch (Exception e) {
            logger.error("update TradeOrder Error!", e);
            return ResponseEntity.status(CommonConstants.SERVER_ERROR)
                    .body(Result.error(CommonConstants.SERVER_ERROR, e.getMessage()));
        }
    }


}