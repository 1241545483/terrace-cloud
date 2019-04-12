package com.synapse.reading.dto.result;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.synapse.reading.model.TradeOrderDetail;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * TradeOrderDetailResult
 * </p>
 *
 * @author liuguangfu
 * @since 2019-04-10
 */
@ApiModel(value = "TradeOrderDetailResult对象", description = "订单详情")
public class TradeOrderDetailResult {

    private TradeOrderDetail tradeOrderDetail = new TradeOrderDetail();

    public TradeOrderDetailResult() {
    }

    public TradeOrderDetailResult(TradeOrderDetail tradeOrderDetail) {
        if (tradeOrderDetail != null) {
            this.tradeOrderDetail = tradeOrderDetail;
        }
    }

    @JsonIgnore
    public TradeOrderDetail getModel() {
        return tradeOrderDetail;
    }

    public void setModel(TradeOrderDetail tradeOrderDetail) {
        this.tradeOrderDetail = tradeOrderDetail;
    }

    @ApiModelProperty(value = "主键")
    public String getRecId() {
        return tradeOrderDetail.getRecId();
    }

    public void setRecId(String rec_id) {
        tradeOrderDetail.setRecId(rec_id);
    }

    @ApiModelProperty(value = "订单名称")
    public String getTrateOrderId() {
        return tradeOrderDetail.getTrateOrderId();
    }

    public void setTrateOrderId(String trate_order_id) {
        tradeOrderDetail.setTrateOrderId(trate_order_id);
    }

    @ApiModelProperty(value = "原价")
    public String getOriginalPrice() {
        return tradeOrderDetail.getOriginalPrice();
    }

    public void setOriginalPrice(String original_price) {
        tradeOrderDetail.setOriginalPrice(original_price);
    }

    @ApiModelProperty(value = "购买金额")
    public String getPresentPrice() {
        return tradeOrderDetail.getPresentPrice();
    }

    public void setPresentPrice(String present_price) {
        tradeOrderDetail.setPresentPrice(present_price);
    }

    @ApiModelProperty(value = "商品名称")
    public String getName() {
        return tradeOrderDetail.getName();
    }

    public void setName(String name) {
        tradeOrderDetail.setName(name);
    }

    @ApiModelProperty(value = "商品类型")
    public String getProdType() {
        return tradeOrderDetail.getProdType();
    }

    public void setProdType(String prod_type) {
        tradeOrderDetail.setProdType(prod_type);
    }

    @ApiModelProperty(value = "商品id")
    public String getProdId() {
        return tradeOrderDetail.getProdId();
    }

    public void setProdId(String prod_id) {
        tradeOrderDetail.setProdId(prod_id);
    }

    @ApiModelProperty(value = "商品描述")
    public String getIntro() {
        return tradeOrderDetail.getIntro();
    }

    public void setIntro(String intro) {
        tradeOrderDetail.setIntro(intro);
    }

    @ApiModelProperty(value = "优惠方式")
    public String getPreferentialWay() {
        return tradeOrderDetail.getPreferentialWay();
    }

    public void setPreferentialWay(String preferential_way) {
        tradeOrderDetail.setPreferentialWay(preferential_way);
    }

    @ApiModelProperty(value = "状态(0 删除，1正常)")
    public String getStatus() {
        return tradeOrderDetail.getStatus();
    }

    public void setStatus(String status) {
        tradeOrderDetail.setStatus(status);
    }

    @ApiModelProperty(value = "创建人")
    public String getCreateId() {
        return tradeOrderDetail.getCreateId();
    }

    public void setCreateId(String create_id) {
        tradeOrderDetail.setCreateId(create_id);
    }

    @ApiModelProperty(value = "创建时间")
    public String getCreateTime() {
        return tradeOrderDetail.getCreateTime();
    }

    public void setCreateTime(String create_time) {
        tradeOrderDetail.setCreateTime(create_time);
    }

    @ApiModelProperty(value = "更新人")
    public String getUpdateId() {
        return tradeOrderDetail.getUpdateId();
    }

    public void setUpdateId(String update_id) {
        tradeOrderDetail.setUpdateId(update_id);
    }

    @ApiModelProperty(value = "更新时间")
    public String getUpdateTime() {
        return tradeOrderDetail.getUpdateTime();
    }

    public void setUpdateTime(String update_time) {
        tradeOrderDetail.setUpdateTime(update_time);
    }


}
