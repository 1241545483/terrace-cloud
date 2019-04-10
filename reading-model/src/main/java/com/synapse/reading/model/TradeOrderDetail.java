package com.synapse.reading.model;

import java.util.Date;
import java.io.Serializable;


/**
 * <p>
 * 订单详情
 * </p>
 *
 * @author liuguangfu
 * @since 2019-04-10
 */
public class TradeOrderDetail implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private String recId;
    /**
     * 订单名称
     */
    private String trateOrderId;
    /**
     * 原价
     */
    private String originalPrice;
    /**
     * 购买金额
     */
    private String presentPrice;
    /**
     * 商品名称
     */
    private String name;
    /**
     * 商品类型
     */
    private String prodType;
    /**
     * 商品id
     */
    private String prodId;
    /**
     * 商品描述
     */
    private String intro;
    /**
     * 优惠方式
     */
    private String preferentialWay;
    /**
     * 状态(0 删除，1正常)
     */
    private String status;
    /**
     * 创建人
     */
    private String createId;
    /**
     * 创建时间
     */
    private String createTime;
    /**
     * 更新人
     */
    private String updateId;
    /**
     * 更新时间
     */
    private String updateTime;


    public String getRecId() {
        return recId;
    }

    public void setRecId(String recId) {
        this.recId = recId;
    }

    public String getTrateOrderId() {
        return trateOrderId;
    }

    public void setTrateOrderId(String trateOrderId) {
        this.trateOrderId = trateOrderId;
    }

    public String getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(String originalPrice) {
        this.originalPrice = originalPrice;
    }

    public String getPresentPrice() {
        return presentPrice;
    }

    public void setPresentPrice(String presentPrice) {
        this.presentPrice = presentPrice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProdType() {
        return prodType;
    }

    public void setProdType(String prodType) {
        this.prodType = prodType;
    }

    public String getProdId() {
        return prodId;
    }

    public void setProdId(String prodId) {
        this.prodId = prodId;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getPreferentialWay() {
        return preferentialWay;
    }

    public void setPreferentialWay(String preferentialWay) {
        this.preferentialWay = preferentialWay;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCreateId() {
        return createId;
    }

    public void setCreateId(String createId) {
        this.createId = createId;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateId() {
        return updateId;
    }

    public void setUpdateId(String updateId) {
        this.updateId = updateId;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

}
