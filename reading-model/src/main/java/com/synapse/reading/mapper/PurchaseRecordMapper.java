package com.synapse.reading.mapper;

import com.synapse.reading.model.PurchaseRecord;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 购买记录 Mapper 接口
 * </p>
 *
 * @author liuguangfu
 * @since 2019-04-09
 */
public interface PurchaseRecordMapper {
    PurchaseRecord selectByPrimaryKey(String recId);

    PurchaseRecord selectByPay(PurchaseRecord model);

    Integer deleteByPrimaryKey(String recId);

    void insert(PurchaseRecord model);

    void insertSelective(PurchaseRecord model);

    Integer updateByPrimaryKeySelective(PurchaseRecord model);

    Integer updateByPrimaryKey(PurchaseRecord model);

    List<PurchaseRecord> list(Map<String, Object> params);

    Integer count(Map<String, Object> params);
}
