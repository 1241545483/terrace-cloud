package com.synapse.reading.dto.result;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.synapse.reading.model.PurchaseRecord;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * PurchaseRecordResult
 * </p>
 *
 * @author liuguangfu
 * @since 2019-04-09
 */
@ApiModel(value = "PurchaseRecordResult对象", description = "购买记录")
public class PurchaseRecordResult {

    private PurchaseRecord purchaseRecord = new PurchaseRecord();

    public PurchaseRecordResult() {
    }

    public PurchaseRecordResult(PurchaseRecord purchaseRecord) {
        if (purchaseRecord != null) {
            this.purchaseRecord = purchaseRecord;
        }
    }

    @JsonIgnore
    public PurchaseRecord getModel() {
        return purchaseRecord;
    }

    public void setModel(PurchaseRecord purchaseRecord) {
        this.purchaseRecord = purchaseRecord;
    }

    @ApiModelProperty(value = "主键")
    public String getRecId() {
        return purchaseRecord.getRecId();
    }

    public void setRecId(String rec_id) {
        purchaseRecord.setRecId(rec_id);
    }

    @ApiModelProperty(value = "购买者id")
    public String getUserId() {
        return purchaseRecord.getUserId();
    }

    public void setUserId(String user_id) {
        purchaseRecord.setUserId(user_id);
    }

    @ApiModelProperty(value = "课程id")
    public String getLessonId() {
        return purchaseRecord.getLessonId();
    }

    public void setLessonId(String lesson_id) {
        purchaseRecord.setLessonId(lesson_id);
    }

    @ApiModelProperty(value = "价格")
    public String getPrice() {
        return purchaseRecord.getPrice();
    }

    public void setPrice(String price) {
        purchaseRecord.setPrice(price);
    }

    @ApiModelProperty(value = "支付方式（1.微信 ，2.支付宝，3.其他三方）")
    public String getPayWay() {
        return purchaseRecord.getPayWay();
    }

    public void setPayWay(String pay_way) {
        purchaseRecord.setPayWay(pay_way);
    }

    @ApiModelProperty(value = "购买方式（1.正常购买， 2.学校统一购买）")
    public String getOperations() {
        return purchaseRecord.getOperations();
    }

    public void setOperations(String operations) {
        purchaseRecord.setOperations(operations);
    }

    @ApiModelProperty(value = "创建人")
    public String getCreateId() {
        return purchaseRecord.getCreateId();
    }

    public void setCreateId(String create_id) {
        purchaseRecord.setCreateId(create_id);
    }

    @ApiModelProperty(value = "创建时间")
    public String getCreateTime() {
        return purchaseRecord.getCreateTime();
    }

    public void setCreateTime(String create_time) {
        purchaseRecord.setCreateTime(create_time);
    }


}
