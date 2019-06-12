package com.synapse.reading.service;

import com.synapse.reading.model.TradeOrder;

import java.util.Map;
import java.util.HashMap;

/**
 * <p>
 * 订单 服务实现类
 * </p>
 *
 * @author liuguangfu
 * @since 2019-06-12
 */
public class TradeOrderBaseService {

	protected Map<String,Object> prepareParams(TradeOrder tradeOrderParam) {
        Map<String,Object> params = new HashMap<>();
        if (tradeOrderParam.getRecId() != null && !tradeOrderParam.getRecId().trim().equals("")) {
            params.put("recId", tradeOrderParam.getRecId());
        }
        if (tradeOrderParam.getImportData() != null && !tradeOrderParam.getImportData().trim().equals("")) {
            params.put("importData", tradeOrderParam.getImportData());
        }
        if (tradeOrderParam.getSellId() != null && !tradeOrderParam.getSellId().trim().equals("")) {
            params.put("sellId", tradeOrderParam.getSellId());
        }
        if (tradeOrderParam.getBuyId() != null && !tradeOrderParam.getBuyId().trim().equals("")) {
            params.put("buyId", tradeOrderParam.getBuyId());
        }
        if (tradeOrderParam.getName() != null && !tradeOrderParam.getName().trim().equals("")) {
            params.put("name", tradeOrderParam.getName());
        }
        if (tradeOrderParam.getIntro() != null && !tradeOrderParam.getIntro().trim().equals("")) {
            params.put("intro", tradeOrderParam.getIntro());
        }
        if (tradeOrderParam.getPayNo() != null && !tradeOrderParam.getPayNo().trim().equals("")) {
            params.put("payNo", tradeOrderParam.getPayNo());
        }
        if (tradeOrderParam.getPayWay() != null && !tradeOrderParam.getPayWay().trim().equals("")) {
            params.put("payWay", tradeOrderParam.getPayWay());
        }
        if (tradeOrderParam.getPrice() != null && !tradeOrderParam.getPrice().trim().equals("")) {
            params.put("price", tradeOrderParam.getPrice());
        }
        if (tradeOrderParam.getStatus() != null && !tradeOrderParam.getStatus().trim().equals("")) {
            params.put("status", tradeOrderParam.getStatus());
        }
        if (tradeOrderParam.getCreateId() != null && !tradeOrderParam.getCreateId().trim().equals("")) {
            params.put("createId", tradeOrderParam.getCreateId());
        }
        if (tradeOrderParam.getCreateTime() != null && !tradeOrderParam.getCreateTime().trim().equals("")) {
            params.put("createTime", tradeOrderParam.getCreateTime());
        }
        if (tradeOrderParam.getFinishTime() != null && !tradeOrderParam.getFinishTime().trim().equals("")) {
            params.put("finishTime", tradeOrderParam.getFinishTime());
        }
        if (tradeOrderParam.getUpdateId() != null && !tradeOrderParam.getUpdateId().trim().equals("")) {
            params.put("updateId", tradeOrderParam.getUpdateId());
        }
        if (tradeOrderParam.getUpdateTime() != null && !tradeOrderParam.getUpdateTime().trim().equals("")) {
            params.put("updateTime", tradeOrderParam.getUpdateTime());
        }
        return params;
    }

}