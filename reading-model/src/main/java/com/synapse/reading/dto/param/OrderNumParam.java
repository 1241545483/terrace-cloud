package com.synapse.reading.dto.param;

import io.swagger.annotations.ApiModel;

/**
 * <p>
 * TopicParam
 * </p>
 *
 * @author liuguangfu
 * @since 2019-01-28
 */
@ApiModel(value = "OrderNumParam对象", description = "主题，关联专辑")
public class OrderNumParam {
    private String recId;
    private String orderNum;

    public String getRecId() {
        return recId;
    }

    public void setRecId(String recId) {
        this.recId = recId;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }
}
