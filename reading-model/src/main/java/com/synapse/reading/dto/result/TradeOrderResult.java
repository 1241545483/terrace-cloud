package com.synapse.reading.dto.result;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.synapse.reading.dto.param.TradeOrderDetailParam;
import com.synapse.reading.model.TradeOrder;
import com.synapse.reading.model.TradeOrderDetail;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * TradeOrderResult
 * </p>
 *
 * @author liuguangfu
 * @since 2019-04-10
 */
@ApiModel(value = "TradeOrderResult对象", description = "订单")
public class TradeOrderResult {

    private TradeOrder tradeOrder = new TradeOrder();

    private List<TradeOrderDetail> tradeOrderDetailParamArrayList = new ArrayList<>();// 子列表

    public List<TradeOrderDetail> getTradeOrderDetailParamArrayList() {
        return tradeOrderDetailParamArrayList;
    }

    public void setTradeOrderDetailParamArrayList(List<TradeOrderDetail> tradeOrderDetailParamArrayList) {
        this.tradeOrderDetailParamArrayList = tradeOrderDetailParamArrayList;
    }

    public String getPayNo() {
        return tradeOrder.getPayNo();
    }

    public void setPayNo(String payNo) {
        tradeOrder.setPayNo(payNo);
    }

    public TradeOrderResult() {
    }

    public TradeOrderResult(TradeOrder tradeOrder) {

        if (tradeOrder != null) {
            this.tradeOrder = tradeOrder;
        }
    }
        @JsonIgnore
        public TradeOrder getModel () {
            return tradeOrder;
        }

    public void setModel(TradeOrder tradeOrder) {
        this.tradeOrder = tradeOrder;
    }

    @ApiModelProperty(value = "主键")
    public String getRecId() {
        return tradeOrder.getRecId();
    }

    public void setRecId(String rec_id) {
        tradeOrder.setRecId(rec_id);
    }

    @ApiModelProperty(value = "订单名称")
    public String getName() {
        return tradeOrder.getName();
    }

    public void setName(String name) {
        tradeOrder.setName(name);
    }

    public String getSellId() {
        return tradeOrder.getSellId();
    }

    public void setSellId(String sellId) {
        tradeOrder.setSellId(sellId);
    }

    public String getImportData() {
        return tradeOrder.getImportData();
    }

    public void setImportData(String importData) {
        tradeOrder.setImportData(importData);
    }

    public String getBuyId() {
        return tradeOrder.getBuyId();
    }

    public void setBuyId(String buyId) {
        tradeOrder.setBuyId(buyId);
    }

    @ApiModelProperty(value = "订单描述")
    public String getIntro() {
        return tradeOrder.getIntro();
    }

    public void setIntro(String intro) {
        tradeOrder.setIntro(intro);
    }

    @ApiModelProperty(value = "支付页方式")
    public String getPayWay() {
        return tradeOrder.getPayWay();
    }

    public void setPayWay(String pay_way) {
        tradeOrder.setPayWay(pay_way);
    }

    @ApiModelProperty(value = "总价")
    public String getPrice() {
        return tradeOrder.getPrice();
    }

    public void setPrice(String price) {
        tradeOrder.setPrice(price);
    }

    @ApiModelProperty(value = "状态(0 删除，1正常)")
    public String getStatus() {
        return tradeOrder.getStatus();
    }

    public void setStatus(String status) {
        tradeOrder.setStatus(status);
    }

    @ApiModelProperty(value = "创建人")
    public String getCreateId() {
        return tradeOrder.getCreateId();
    }

    public void setCreateId(String create_id) {
        tradeOrder.setCreateId(create_id);
    }

    @ApiModelProperty(value = "创建时间")
    public String getCreateTime() {
        return tradeOrder.getCreateTime();
    }

    public void setCreateTime(String create_time) {
        tradeOrder.setCreateTime(create_time);
    }

    @ApiModelProperty(value = "更新人")
    public String getUpdateId() {
        return tradeOrder.getUpdateId();
    }

    public void setUpdateId(String update_id) {
        tradeOrder.setUpdateId(update_id);
    }

    @ApiModelProperty(value = "更新时间")
    public String getUpdateTime() {
        return tradeOrder.getUpdateTime();
    }

    public void setUpdateTime(String update_time) {
        tradeOrder.setUpdateTime(update_time);
    }


    public String getFinishTime() {
        return tradeOrder.getFinishTime();
    }

    public void setFinishTime(String finishTime) {
        tradeOrder.setFinishTime(finishTime);
    }
}
