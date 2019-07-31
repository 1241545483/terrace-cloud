package com.synapse.reading.respository;

import com.synapse.reading.dto.result.TradeOrderDetailResult;
import com.synapse.reading.mapper.TradeOrderDetailMapper;
import com.synapse.reading.model.Lesson;
import com.synapse.reading.model.TradeOrderDetail;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 订单详情 Respository 接口
 * </p>
 *
 * @author liuguangfu
 * @since 2019-04-10
 */
public interface TradeOrderDetailRespository extends TradeOrderDetailMapper {

    List<TradeOrderDetail> findByTradeOrder(String tradeOrderId);

    List<String> findTradeOrderProdId(@Param("tradeOrderId") String tradeOrderId, @Param("prodType") String prodType);

    List<TradeOrderDetailResult> listradeOrderProdIdLesson(Map<String, Object> params);

    List<TradeOrderDetailResult> listradeOrderProdIdVip(Map<String, Object> params);

    List<TradeOrderDetailResult> listradeOrderProdIdBook(Map<String, Object> params);

    Integer countListUserBuyLesson(@Param("userId") String userId, @Param("type") String type);

    Integer countListUserBuyBook(@Param("userId") String userId, @Param("type") String type);

    TradeOrderDetailResult findUserOrderBook(String tradeOrderId);
    TradeOrderDetailResult findUserOrderLesson(String tradeOrderId);
    TradeOrderDetailResult findUserOrderVip(String tradeOrderId);
}
