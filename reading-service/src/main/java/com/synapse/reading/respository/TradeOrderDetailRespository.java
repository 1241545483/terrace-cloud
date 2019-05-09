package com.synapse.reading.respository;

import com.synapse.reading.mapper.TradeOrderDetailMapper;
import com.synapse.reading.model.TradeOrderDetail;
import org.apache.ibatis.annotations.Param;

import java.util.List;

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
}
