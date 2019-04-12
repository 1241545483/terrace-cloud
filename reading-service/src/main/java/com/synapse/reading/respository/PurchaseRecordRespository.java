package com.synapse.reading.respository;

import com.synapse.reading.mapper.PurchaseRecordMapper;
import com.synapse.reading.model.PurchaseRecord;

/**
 * <p>
 * 购买记录 Respository 接口
 * </p>
 *
 * @author liuguangfu
 * @since 2019-04-09
 */
public interface PurchaseRecordRespository extends PurchaseRecordMapper {
    PurchaseRecord selectByPay(PurchaseRecord model);
}
