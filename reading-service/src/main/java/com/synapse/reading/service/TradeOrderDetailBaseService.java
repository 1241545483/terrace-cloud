package com.synapse.reading.service;

import com.synapse.reading.model.TradeOrderDetail;

import java.util.Map;
import java.util.HashMap;

/**
 * <p>
 * 订单详情 服务实现类
 * </p>
 *
 * @author liuguangfu
 * @since 2019-04-10
 */
public class TradeOrderDetailBaseService {

	protected Map<String,Object> prepareParams(TradeOrderDetail tradeOrderDetailParam) {
        Map<String,Object> params = new HashMap<>();
        if (tradeOrderDetailParam.getRecId() != null && !tradeOrderDetailParam.getRecId().trim().equals("")) {
            params.put("recId", tradeOrderDetailParam.getRecId());
        }
        if (tradeOrderDetailParam.getTrateOrderId() != null && !tradeOrderDetailParam.getTrateOrderId().trim().equals("")) {
            params.put("trateOrderId", tradeOrderDetailParam.getTrateOrderId());
        }
        if (tradeOrderDetailParam.getOriginalPrice() != null && !tradeOrderDetailParam.getOriginalPrice().trim().equals("")) {
            params.put("originalPrice", tradeOrderDetailParam.getOriginalPrice());
        }
        if (tradeOrderDetailParam.getPresentPrice() != null && !tradeOrderDetailParam.getPresentPrice().trim().equals("")) {
            params.put("presentPrice", tradeOrderDetailParam.getPresentPrice());
        }
        if (tradeOrderDetailParam.getName() != null && !tradeOrderDetailParam.getName().trim().equals("")) {
            params.put("name", tradeOrderDetailParam.getName());
        }
        if (tradeOrderDetailParam.getProdType() != null && !tradeOrderDetailParam.getProdType().trim().equals("")) {
            params.put("prodType", tradeOrderDetailParam.getProdType());
        }
        if (tradeOrderDetailParam.getProdId() != null && !tradeOrderDetailParam.getProdId().trim().equals("")) {
            params.put("prodId", tradeOrderDetailParam.getProdId());
        }
        if (tradeOrderDetailParam.getIntro() != null && !tradeOrderDetailParam.getIntro().trim().equals("")) {
            params.put("intro", tradeOrderDetailParam.getIntro());
        }
        if (tradeOrderDetailParam.getPreferentialWay() != null && !tradeOrderDetailParam.getPreferentialWay().trim().equals("")) {
            params.put("preferentialWay", tradeOrderDetailParam.getPreferentialWay());
        }
        if (tradeOrderDetailParam.getStatus() != null && !tradeOrderDetailParam.getStatus().trim().equals("")) {
            params.put("status", tradeOrderDetailParam.getStatus());
        }
        if (tradeOrderDetailParam.getCreateId() != null && !tradeOrderDetailParam.getCreateId().trim().equals("")) {
            params.put("createId", tradeOrderDetailParam.getCreateId());
        }
        if (tradeOrderDetailParam.getCreateTime() != null && !tradeOrderDetailParam.getCreateTime().trim().equals("")) {
            params.put("createTime", tradeOrderDetailParam.getCreateTime());
        }
        if (tradeOrderDetailParam.getUpdateId() != null && !tradeOrderDetailParam.getUpdateId().trim().equals("")) {
            params.put("updateId", tradeOrderDetailParam.getUpdateId());
        }
        if (tradeOrderDetailParam.getUpdateTime() != null && !tradeOrderDetailParam.getUpdateTime().trim().equals("")) {
            params.put("updateTime", tradeOrderDetailParam.getUpdateTime());
        }
        return params;
    }

}