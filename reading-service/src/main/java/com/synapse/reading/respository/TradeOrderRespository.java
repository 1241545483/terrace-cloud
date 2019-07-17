package com.synapse.reading.respository;

import com.synapse.reading.dto.result.TradeOrderResult;
import com.synapse.reading.mapper.TradeOrderMapper;
import com.synapse.reading.model.TradeOrder;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 订单 Respository 接口
 * </p>
 *
 * @author liuguangfu
 * @since 2019-04-10
 */
public interface TradeOrderRespository extends TradeOrderMapper {

    List<TradeOrder>  findByBuyId(String buyId);

    List<TradeOrder>  findVipByBuyId(String buyId);
    List<String>  findVipUser();
    Integer getUserBuy(Map<String, String> params);
}
