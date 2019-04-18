package com.synapse.reading.mapper;

import com.synapse.reading.model.TradeOrder;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 订单 Mapper 接口
 * </p>
 *
 * @author liuguangfu
 * @since 2019-04-17
 */
public interface TradeOrderMapper {
    TradeOrder selectByPrimaryKey(String recId);

    Integer deleteByPrimaryKey(String recId);

    void insert(TradeOrder model);

    void insertSelective(TradeOrder model);

    Integer updateByPrimaryKeySelective(TradeOrder model);

    Integer updateByPrimaryKey(TradeOrder model);

    List<TradeOrder> list(Map<String, Object> params);

    Integer count(Map<String, Object> params);
}
