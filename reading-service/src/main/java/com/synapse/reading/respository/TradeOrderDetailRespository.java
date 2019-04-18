package com.synapse.reading.respository;

import com.synapse.reading.mapper.TradeOrderDetailMapper;
import com.synapse.reading.model.TradeOrderDetail;

/**
 * <p>
 * 订单详情 Respository 接口
 * </p>
 *
 * @author liuguangfu
 * @since 2019-04-10
 */
public interface TradeOrderDetailRespository extends TradeOrderDetailMapper {

    TradeOrderDetail findByTradeOrder(String tradeOrderId);

}
