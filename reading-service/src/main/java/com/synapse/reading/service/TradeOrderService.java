package com.synapse.reading.service;

import com.synapse.common.constants.PageInfo;
import com.synapse.common.sso.model.User;
import com.synapse.reading.constants.TradeOrderDetailConstants;
import com.synapse.reading.dto.param.LessonParam;
import com.synapse.reading.dto.param.SchoolTradeOrderParam;
import com.synapse.reading.dto.param.TradeOrderDetailParam;
import com.synapse.reading.model.*;
import com.synapse.reading.respository.TradeOrderDetailRespository;
import com.synapse.reading.respository.TradeOrderRespository;
import com.synapse.reading.dto.param.TradeOrderParam;
import com.synapse.reading.dto.result.TradeOrderResult;
import com.synapse.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.synapse.reading.constants.TradeOrderConstants;
import com.synapse.reading.remote.IdService;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
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

    public TradeOrder find(String recId) {
        return tradeOrderRespository.selectByPrimaryKey(recId);
    }

    public List<TradeOrderResult> findByBuyId(String BuyId) {
        return tradeOrderRespository.findByBuyId(BuyId);
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

    public List<Lesson> listBuyLesson(SchoolTradeOrderParam schoolTradeOrderParam, PageInfo pageInfo) {

        List<TradeOrderResult> results = tradeOrderRespository.findByBuyId(schoolTradeOrderParam.getSchoolUserId());
//        List<TradeOrderResult> results = orders.stream().map(it -> new TradeOrderResult(it)).collect(Collectors.toList());
        List<Lesson> lessons = null;
        if (results.size() > 0 && results != null) {
            for (TradeOrderResult tradeOrder : results) {
                List<String> prodIds = tradeOrderDetailRespository.findTradeOrderProdId(tradeOrder.getRecId(), schoolTradeOrderParam.getType());
                if (prodIds.size() > 0 && prodIds != null) {
                    for (String prodId : prodIds) {
                        Lesson lesson = lessonService.find(prodId);
                        lessons.add(lesson);
                    }
                }
            }
        }
        return lessons;
    }

    public List<Book> listBuyBook(SchoolTradeOrderParam schoolTradeOrderParam, PageInfo pageInfo) {
        List<TradeOrderResult> results = tradeOrderRespository.findByBuyId(schoolTradeOrderParam.getSchoolUserId());
//        List<TradeOrderResult> results = orders.stream().map(it -> new TradeOrderResult(it)).collect(Collectors.toList());
        List<Book> books = null;
        if (results.size() > 0 && results != null) {
            for (TradeOrderResult tradeOrder : results) {
                List<String> prodIds = tradeOrderDetailRespository.findTradeOrderProdId(tradeOrder.getRecId(), schoolTradeOrderParam.getType());
                if (prodIds.size() > 0 && prodIds != null) {
                    for (String prodId : prodIds) {
                        Book book = bookService.find(prodId);
                        books.add(book);
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