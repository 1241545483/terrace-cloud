package com.synapse.reading.respository;

import com.synapse.reading.mapper.TradeOrderMapper;
import com.synapse.reading.model.TradeOrder;

/**
 * <p>
 * 订单 Respository 接口
 * </p>
 *
 * @author liuguangfu
 * @since 2019-04-10
 */
public interface TradeOrderRespository extends TradeOrderMapper {

    TradeOrder findByBuyId(String buyId);
}
