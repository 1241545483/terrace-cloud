package com.synapse.reading.mapper;

import com.synapse.reading.model.TradeOrderDetail;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 订单详情 Mapper 接口
 * </p>
 *
 * @author liuguangfu
 * @since 2019-04-10
 */
public interface TradeOrderDetailMapper {
    TradeOrderDetail selectByPrimaryKey(String recId);

    Integer deleteByPrimaryKey(String recId);

    void insert(TradeOrderDetail model);

    void insertSelective(TradeOrderDetail model);

    Integer updateByPrimaryKeySelective(TradeOrderDetail model);

    Integer updateByPrimaryKey(TradeOrderDetail model);

    List<TradeOrderDetail> list(Map<String, Object> params);

    Integer count(Map<String, Object> params);
}
