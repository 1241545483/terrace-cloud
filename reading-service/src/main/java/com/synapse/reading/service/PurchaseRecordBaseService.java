package com.synapse.reading.service;

import com.synapse.reading.model.PurchaseRecord;

import java.util.Map;
import java.util.HashMap;

/**
 * <p>
 * 购买记录 服务实现类
 * </p>
 *
 * @author liuguangfu
 * @since 2019-04-09
 */
public class PurchaseRecordBaseService {

	protected Map<String,Object> prepareParams(PurchaseRecord purchaseRecordParam) {
        Map<String,Object> params = new HashMap<>();
        if (purchaseRecordParam.getRecId() != null && !purchaseRecordParam.getRecId().trim().equals("")) {
            params.put("recId", purchaseRecordParam.getRecId());
        }
        if (purchaseRecordParam.getUserId() != null && !purchaseRecordParam.getUserId().trim().equals("")) {
            params.put("userId", purchaseRecordParam.getUserId());
        }
        if (purchaseRecordParam.getLessonId() != null && !purchaseRecordParam.getLessonId().trim().equals("")) {
            params.put("lessonId", purchaseRecordParam.getLessonId());
        }
        if (purchaseRecordParam.getPrice() != null && !purchaseRecordParam.getPrice().trim().equals("")) {
            params.put("price", purchaseRecordParam.getPrice());
        }
        if (purchaseRecordParam.getPayWay() != null && !purchaseRecordParam.getPayWay().trim().equals("")) {
            params.put("payWay", purchaseRecordParam.getPayWay());
        }
        if (purchaseRecordParam.getOperations() != null && !purchaseRecordParam.getOperations().trim().equals("")) {
            params.put("operations", purchaseRecordParam.getOperations());
        }
        if (purchaseRecordParam.getCreateId() != null && !purchaseRecordParam.getCreateId().trim().equals("")) {
            params.put("createId", purchaseRecordParam.getCreateId());
        }
        if (purchaseRecordParam.getCreateTime() != null && !purchaseRecordParam.getCreateTime().trim().equals("")) {
            params.put("createTime", purchaseRecordParam.getCreateTime());
        }
        return params;
    }

}