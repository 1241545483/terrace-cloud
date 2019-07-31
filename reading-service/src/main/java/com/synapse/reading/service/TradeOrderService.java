package com.synapse.reading.service;

import com.synapse.common.constants.PageInfo;
import com.synapse.common.sso.model.User;
import com.synapse.reading.constants.TradeOrderDetailConstants;
import com.synapse.reading.dto.param.*;
import com.synapse.reading.dto.result.TradeOrderDetailResult;
import com.synapse.reading.model.*;
import com.synapse.reading.model.auth.UserRole;
import com.synapse.reading.respository.BookRespository;
import com.synapse.reading.respository.LessonRespository;
import com.synapse.reading.respository.TradeOrderDetailRespository;
import com.synapse.reading.respository.TradeOrderRespository;
import com.synapse.reading.dto.result.TradeOrderResult;
import com.synapse.common.utils.DateUtils;
import com.synapse.reading.service.auth.UserRoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.synapse.reading.constants.TradeOrderConstants;
import com.synapse.reading.remote.IdService;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;


/**
 * <p>
 * 订单 服务实现类
 * </p>
 *
 * @author liuguangfu
 * @since 2019-04-10
 */
@Service
@Transactional
public class TradeOrderService extends TradeOrderBaseService {
    private Logger logger = LoggerFactory.getLogger(TradeOrderService.class);
    @Autowired
    private IdService idService;

    @Autowired
    private TradeOrderRespository tradeOrderRespository;

    @Autowired
    private TradeOrderDetailService tradeOrderDetailService;

    @Autowired
    private LessonService lessonService;
    @Autowired
    private BookService bookService;
    @Autowired
    private TradeOrderDetailRespository tradeOrderDetailRespository;
    @Autowired
    private LessonRespository lessonRespository;
    @Autowired
    private BookRespository bookRespository;
    @Autowired
    private UserRoleService userRoleService;

    public TradeOrder find(String recId) {
        return tradeOrderRespository.selectByPrimaryKey(recId);
    }


    public Boolean getUserBuy(BuyByUserParam param, User user) {
        Map<String, String> params = new HashMap<>();
        params.put("userId", user.getRecId());
        params.put("studyId", param.getStudyId());
        params.put("studyType", param.getStudyType());
        String now = DateUtils.getNowStr(DateUtils.FORMAT_DATE_TIME);
        params.put("now", now);
        Integer num = tradeOrderRespository.getUserBuy(params);
        if (num > 0) {
            return true;
        } else {
            return false;
        }
    }


    public TradeOrderDetailResult findUserOrder(String recId) {
        List<TradeOrderDetail> tradeOrderDetail = tradeOrderDetailRespository.findByTradeOrder(recId);
        if (tradeOrderDetail != null && tradeOrderDetail.size() > 0) {
            if (tradeOrderDetail.get(0).getProdType().equals(TradeOrderConstants.ORDERTYPE.LESSON.value())) {
                return tradeOrderDetailRespository.findUserOrderLesson(recId);
            }
            if (tradeOrderDetail.get(0).getProdType().equals(TradeOrderConstants.ORDERTYPE.BOOK.value())) {
                return tradeOrderDetailRespository.findUserOrderBook(recId);
            }
            if (tradeOrderDetail.get(0).getProdType().equals(TradeOrderConstants.ORDERTYPE.VIP.value())) {
                return tradeOrderDetailRespository.findUserOrderVip(recId);
            }
        }

        return null;
    }

    public List<TradeOrder> findByBuyId(String BuyId) {
        return tradeOrderRespository.findByBuyId(BuyId);
    }

    public List<TradeOrder> findVipByBuyId(String BuyId) {
        return tradeOrderRespository.findVipByBuyId(BuyId);
    }

    public  String createOrderByVipCode(String userId,String price) {
        try {
            String days ="365";
            List<String> roleIds = userRoleService.listUserBizRoles(userId);
            if (roleIds != null && roleIds.size() > 0) {
                Map<String, String> map = new HashMap<String, String>();
                for (String roleId : roleIds) {
                    map.put(roleId, roleId);
                }
                if (map.get("vip") == null || "".equals(map.get("vip"))) {
                    userRoleCreate(userId);
                }
            } else {
                userRoleCreate(userId);
            }
            List<TradeOrder> tradeOrderList = findVipByBuyId(userId);
            if (tradeOrderList != null && tradeOrderList.size() > 0) {
                //获取时间加一年
                if (!vipPast(tradeOrderList.get(0).getEndTime())) {
                    String endTime = addYear(tradeOrderList.get(0).getEndTime(), days);
                    vipTradeOrder(tradeOrderList.get(0).getEndTime(), endTime, userId,price);
                } else {
                    String now = DateUtils.getNowStr(DateUtils.FORMAT_DATE_TIME);
                    String endTime = addYear(now, days);
                    vipTradeOrder(now, endTime, userId, price);
                }
            } else {
                String now = DateUtils.getNowStr(DateUtils.FORMAT_DATE_TIME);
                String endTime = addYear(now, days);
                vipTradeOrder(now, endTime, userId, price);
            }
            return "1";
        } catch (Exception e) {
            e.printStackTrace();
            return "系统时间异常";
        }
    }

    //比较用户会员是否过期
    public Boolean vipPast(String endTime) {
        try {
            DateFormat sdf = new SimpleDateFormat(DateUtils.FORMAT_DATE_TIME);
            String now = DateUtils.getNowStr(DateUtils.FORMAT_DATE_TIME);
            Date startTime = sdf.parse(now);
            Date lastTime = sdf.parse(endTime);
            if (lastTime.getTime() < startTime.getTime()) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return false;
    }


    //创建用户角色
    public void userRoleCreate(String userId) {
        UserRole userRole = new UserRole();
        userRole.setUserId(userId);
        userRole.setRoleId("vip");
        userRole.setCreateId(userId);
        userRoleService.create(userRole);
    }


    //生成vip订单
    public void vipTradeOrder(String startTime, String endTime, String userId, String price) {
        TradeOrder tradeOrder = new TradeOrder();
        tradeOrder.setName("购买vip");
        tradeOrder.setBuyId(userId);
        tradeOrder.setStatus(TradeOrderConstants.STATUS.UNPAID.num());
        tradeOrder.setCreateId(userId);
        tradeOrder.setStartTime(startTime);
        tradeOrder.setEndTime(endTime);
        tradeOrder.setPrice(price);
        tradeOrder.setPayWay("weixin");
        tradeOrder.setIntro("购买vip");
        String tradeOrderId = create(tradeOrder);
        //生成VIP订单详情
        TradeOrderDetail tradeOrderDetail = new TradeOrderDetail();
        tradeOrderDetail.setTrateOrderId(tradeOrderId);
        tradeOrderDetail.setCreateId(userId);
        tradeOrderDetail.setProdType("vip");
        tradeOrderDetail.setPresentPrice(price);
        tradeOrderDetail.setName("购买VIP");
        tradeOrderDetailService.create(tradeOrderDetail);
    }

    //增加时间
    public String addYear(String startTime, String days) throws Exception {
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date createTime = sdf.parse(startTime); //String转Date
        Calendar cal = Calendar.getInstance();
        cal.setTime(createTime);//设置起时间
        cal.add(Calendar.DATE, Integer.parseInt(days));//增加天数
        return sdf.format(cal.getTime());
    }


    public Integer update(TradeOrder param) {
        String now = DateUtils.getNowStr(DateUtils.FORMAT_DATE_TIME);
        param.setUpdateTime(now);
        return tradeOrderRespository.updateByPrimaryKeySelective(param);
    }

    public String create(TradeOrder param) {
        String now = DateUtils.getNowStr(DateUtils.FORMAT_DATE_TIME);
        param.setRecId(idService.gen("ID"));
        param.setCreateTime(now);
        param.setUpdateTime(now);
        param.setStatus(TradeOrderConstants.STATUS.OK.num());
        tradeOrderRespository.insert(param);
        return param.getRecId();
    }

    public String createBySchool(SchoolTradeOrderParam param, User user) {
        String now = DateUtils.getNowStr(DateUtils.FORMAT_DATE_TIME);
        int price = 0;
        TradeOrder tradeOrder = new TradeOrder();
        tradeOrder.setRecId(idService.gen("ID"));
        tradeOrder.setImportData("2");
        tradeOrder.setName("后台创建");
        tradeOrder.setBuyId(param.getSchoolUserId());
        tradeOrder.setCreateTime(now);
        tradeOrder.setPayNo("后台创建");
        tradeOrder.setPayWay("后台创建");
        tradeOrder.setUpdateTime(now);
        tradeOrder.setCreateId(user.getRecId());
        tradeOrder.setStatus(TradeOrderConstants.STATUS.OK.num());
        List<SchoolTradeOrder> schoolTradeOrderList = param.getSchoolTradeOrderList();
        if (schoolTradeOrderList.size() > 0 && schoolTradeOrderList != null) {
            for (SchoolTradeOrder schoolTradeOrder : schoolTradeOrderList) {
                if (schoolTradeOrder.getType().equals(TradeOrderConstants.ORDERTYPE.BOOK.value())) {
                    Book book = bookService.find(schoolTradeOrder.getRecId());
                    TradeOrderDetail tradeOrderDetail = new TradeOrderDetail();
                    tradeOrderDetail.setRecId(idService.gen("ID"));
                    tradeOrderDetail.setTrateOrderId(tradeOrder.getRecId());
//                    tradeOrderDetail.setOriginalPrice(book.getOriginalPrice());
//                    tradeOrderDetail.setPresentPrice(book.getPresentPrice());
                    tradeOrderDetail.setName(book.getName());
                    tradeOrderDetail.setProdType(schoolTradeOrder.getType());
                    tradeOrderDetail.setProdId(book.getRecId());
                    tradeOrderDetail.setStatus(TradeOrderConstants.STATUS.OK.num());
                    tradeOrderDetail.setCreateId(user.getRecId());
                    tradeOrderDetail.setCreateTime(now);
                    tradeOrderDetailService.create(tradeOrderDetail);
//                    price=price+Integer.parseInt(book.getPresentPrice());
                }
                if (schoolTradeOrder.getType().equals(TradeOrderConstants.ORDERTYPE.LESSON.value())) {
                    Lesson lesson = lessonService.find(schoolTradeOrder.getRecId());
                    TradeOrderDetail tradeOrderDetail = new TradeOrderDetail();
                    tradeOrderDetail.setRecId(idService.gen("ID"));
                    tradeOrderDetail.setTrateOrderId(tradeOrder.getRecId());
                    tradeOrderDetail.setOriginalPrice(lesson.getOriginalPrice());
                    tradeOrderDetail.setPresentPrice(lesson.getPresentPrice());
                    tradeOrderDetail.setName(lesson.getName());
                    tradeOrderDetail.setProdType(schoolTradeOrder.getType());
                    tradeOrderDetail.setProdId(lesson.getRecId());
                    tradeOrderDetail.setStatus(TradeOrderConstants.STATUS.OK.num());
                    tradeOrderDetail.setCreateId(user.getRecId());
                    tradeOrderDetail.setCreateTime(now);
                    tradeOrderDetailService.create(tradeOrderDetail);
                    if (lesson.getPresentPrice() != null && !"".equals(lesson.getPresentPrice())) {
                        price = price + Integer.parseInt(lesson.getPresentPrice());
                    }

                }
            }
        }
        tradeOrder.setPrice(price + "");
        tradeOrderRespository.insert(tradeOrder);

        return tradeOrder.getRecId();
    }

    public Integer delete(String recId, String updateId) {
        String now = DateUtils.getNowStr(DateUtils.FORMAT_DATE_TIME);
        TradeOrder model = new TradeOrder();
        model.setRecId(recId);
        model.setUpdateId(updateId);
        model.setUpdateTime(now);
        model.setStatus(TradeOrderConstants.STATUS.DELETED.num());
        return tradeOrderRespository.updateByPrimaryKeySelective(model);
    }

    public Integer deleteBySchool(String recId, String updateId) {
        String now = DateUtils.getNowStr(DateUtils.FORMAT_DATE_TIME);
        TradeOrder model = new TradeOrder();
        model.setRecId(recId);
        model.setUpdateId(updateId);
        model.setUpdateTime(now);
        model.setStatus(TradeOrderConstants.STATUS.DELETED.num());
        List<TradeOrderDetail> tradeOrderDetailList = tradeOrderDetailService.findByTradeOrder(recId);
        if (tradeOrderDetailList != null && tradeOrderDetailList.size() > 0) {
            for (TradeOrderDetail tradeOrderDetail : tradeOrderDetailList) {
                tradeOrderDetail.setUpdateId(updateId);
                tradeOrderDetail.setStatus(TradeOrderDetailConstants.STATUS.DELETED.num());
                tradeOrderDetailService.update(tradeOrderDetail);
            }
        }
        return tradeOrderRespository.updateByPrimaryKeySelective(model);
    }


    public List<TradeOrder> list(TradeOrder tradeOrderParam, PageInfo pageInfo) {
        tradeOrderParam.setStatus(TradeOrderConstants.STATUS.OK.num());
        Map<String, Object> params = prepareParams(tradeOrderParam);
        params.put("startIndex", pageInfo.getCurrentStartIndex());
        params.put("pageSize", pageInfo.getPerPageNum());
        return tradeOrderRespository.list(params);
    }

    public List<TradeOrderResult> listOrder(TradeOrder tradeOrderParam, PageInfo pageInfo) {
        tradeOrderParam.setStatus(TradeOrderConstants.STATUS.OK.num());
        Map<String, Object> params = prepareParams(tradeOrderParam);
        params.put("startIndex", pageInfo.getCurrentStartIndex());
        params.put("pageSize", pageInfo.getPerPageNum());
        List<TradeOrder> orders = tradeOrderRespository.list(params);
        List<TradeOrderResult> results = orders.stream().map(it -> new TradeOrderResult(it)).collect(Collectors.toList());
        if (results.size() > 0 && results != null) {
            for (TradeOrderResult tradeOrder : results) {
                List<TradeOrderDetail> tradeOrderDetails = tradeOrderDetailService.findByTradeOrder(tradeOrder.getRecId());
                tradeOrder.setTradeOrderDetailParamArrayList(tradeOrderDetails);
            }
        }
        return results;
    }

    public List<TradeOrderDetailResult> listUserBuyVip(User user, String type, PageInfo pageInfo) {

        Map<String, Object> params = new HashMap<>();
        params.put("startIndex", pageInfo.getCurrentStartIndex());
        params.put("pageSize", pageInfo.getPerPageNum());
        params.put("type", type);
        params.put("userId", user.getRecId());
        return tradeOrderDetailRespository.listradeOrderProdIdVip(params);
    }

    public List<TradeOrderDetailResult> listUserBuyLesson(User user, String type, PageInfo pageInfo) {

        Map<String, Object> params = new HashMap<>();
        params.put("startIndex", pageInfo.getCurrentStartIndex());
        params.put("pageSize", pageInfo.getPerPageNum());
        params.put("type", type);
        params.put("userId", user.getRecId());
        return tradeOrderDetailRespository.listradeOrderProdIdLesson(params);
    }

    public Integer countListUserBuyLesson(User user, String type) {

        return tradeOrderDetailRespository.countListUserBuyLesson(user.getRecId(), type);
    }

    public Integer countListUserBuyBook(User user, String type) {

        return tradeOrderDetailRespository.countListUserBuyBook(user.getRecId(), type);
    }

    public List<TradeOrderDetailResult> listUserBuyBook(User user, String type, PageInfo pageInfo) {

        Map<String, Object> params = new HashMap<>();
        params.put("startIndex", pageInfo.getCurrentStartIndex());
        params.put("pageSize", pageInfo.getPerPageNum());
        params.put("type", type);
        params.put("userId", user.getRecId());
        return tradeOrderDetailRespository.listradeOrderProdIdBook(params);
    }

    public List<Lesson> listBuyLesson(SchoolTradeOrderParam schoolTradeOrderParam, PageInfo pageInfo) {

        List<TradeOrder> results = tradeOrderRespository.findByBuyId(schoolTradeOrderParam.getSchoolUserId());
//        List<TradeOrderResult> results = orders.stream().map(it -> new TradeOrderResult(it)).collect(Collectors.toList());
        List<Lesson> lessons = new ArrayList<>();
        if (results.size() > 0 && results != null) {
            for (TradeOrder tradeOrder : results) {
                List<String> prodIds = tradeOrderDetailRespository.findTradeOrderProdId(tradeOrder.getRecId(), schoolTradeOrderParam.getType());
                if (prodIds.size() > 0 && prodIds != null) {
                    for (String prodId : prodIds) {
                        Lesson lesson = lessonService.find(prodId);
                        if (lesson != null && !"".equals(lesson)) {
                            lessons.add(lesson);
                        }

                    }
                }
            }
        }
        return lessons;
    }

    public List<Book> listBuyBook(SchoolTradeOrderParam schoolTradeOrderParam, PageInfo pageInfo) {
        List<TradeOrder> results = tradeOrderRespository.findByBuyId(schoolTradeOrderParam.getSchoolUserId());
//        List<TradeOrderResult> results = orders.stream().map(it -> new TradeOrderResult(it)).collect(Collectors.toList());
        List<Book> books = new ArrayList<>();
        if (results.size() > 0 && results != null) {
            for (TradeOrder tradeOrder : results) {
                List<String> prodIds = tradeOrderDetailRespository.findTradeOrderProdId(tradeOrder.getRecId(), schoolTradeOrderParam.getType());
                if (prodIds.size() > 0 && prodIds != null) {
                    for (String prodId : prodIds) {
                        Book book = bookService.find(prodId);
                        if (book != null && !"".equals(book)) {
                            books.add(book);
                        }
                    }
                }
            }
        }
        return books;
    }

    public Integer count(TradeOrder tradeOrderParam) {
        tradeOrderParam.setStatus(TradeOrderConstants.STATUS.OK.num());
        Map<String, Object> params = prepareParams(tradeOrderParam);
        return tradeOrderRespository.count(params);
    }

}