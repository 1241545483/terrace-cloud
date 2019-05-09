package com.synapse.reading.dto.param;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.synapse.reading.model.SchoolTradeOrder;
import com.synapse.reading.model.TradeOrder;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * TradeOrderParam
 * </p>
 *
 * @author liuguangfu
 * @since 2019-04-10
 */
@ApiModel(value = "TradeOrderParam对象", description = "订单")
public class SchoolTradeOrderParam {

    private SchoolTradeOrder schoolTradeOrder = new SchoolTradeOrder();

    private List<SchoolTradeOrder> schoolTradeOrderList = new ArrayList<>();// 提交购买记录列表

    private String  schoolUserId;

    public SchoolTradeOrderParam(){

    }

    public SchoolTradeOrderParam(SchoolTradeOrder schoolTradeOrder) {
        this.schoolTradeOrder = schoolTradeOrder;
    }

    public List<SchoolTradeOrder> getSchoolTradeOrderList() {
        return schoolTradeOrderList;
    }

    public void setSchoolTradeOrderList(List<SchoolTradeOrder> schoolTradeOrderList) {
        this.schoolTradeOrderList = schoolTradeOrderList;
    }

    public String getRecId() {
        return schoolTradeOrder.getRecId();
    }

    public void setRecId(String recId) {
        schoolTradeOrder.setRecId(recId);
    }

    public String getType() {
        return schoolTradeOrder.getType();
    }

    public void setType(String type) {
        schoolTradeOrder.setType(type);
    }

    public String getSchoolUserId() {
        return schoolUserId;
    }

    public void setSchoolUserId(String schoolUserId) {
        this.schoolUserId = schoolUserId;
    }
}
