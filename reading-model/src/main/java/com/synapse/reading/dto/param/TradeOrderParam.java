package com.synapse.reading.dto.param;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.synapse.reading.model.SchoolTradeOrder;
import com.synapse.reading.model.TradeOrder;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotNull;
import com.synapse.reading.web.valid.group.Update;
import com.synapse.reading.web.valid.group.Create;
import com.synapse.reading.web.valid.group.Search;

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
public class TradeOrderParam  {

    private TradeOrder  tradeOrder = new TradeOrder();

    private List<TradeOrderDetailParam> tradeOrderDetailParamArrayList = new ArrayList<>();// 子列表

    public List<TradeOrderDetailParam> getTradeOrderDetailParamArrayList() {
        return tradeOrderDetailParamArrayList;
    }

    private List<SchoolTradeOrder> schoolTradeOrderList = new ArrayList<>();// 提交购买记录列表

    private String  schoolUserId;

    public List<SchoolTradeOrder> getSchoolTradeOrderList() {
        return schoolTradeOrderList;
    }

    public void setSchoolTradeOrderList(List<SchoolTradeOrder> schoolTradeOrderList) {
        this.schoolTradeOrderList = schoolTradeOrderList;
    }

    public String getFinishTime() {
        return tradeOrder.getFinishTime();
    }

    public void setFinishTime(String finishTime) {
        tradeOrder.setFinishTime(finishTime);
    }

    public String getSchoolUserId() {
        return schoolUserId;
    }

    public void setSchoolUserId(String schoolUserId) {
        this.schoolUserId = schoolUserId;
    }

    public void setTradeOrderDetailParamArrayList(List<TradeOrderDetailParam> tradeOrderDetailParamArrayList) {
        this.tradeOrderDetailParamArrayList = tradeOrderDetailParamArrayList;
    }

    public TradeOrderParam(){}

    public TradeOrderParam(TradeOrder  tradeOrder){
        this.tradeOrder = tradeOrder;
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

    @JsonIgnore
    public TradeOrder getModel() {
        return tradeOrder;
    }

    public void setModel(TradeOrder  tradeOrder) {
        this.tradeOrder = tradeOrder;
    }

    @ApiModelProperty(value = "主键")
public String getRecId() {
    return tradeOrder.getRecId();
}

    public String getPayNo() {
        return tradeOrder.getPayNo();
    }

    public void setPayNo(String payNo) {
        tradeOrder.setPayNo(payNo);
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


    public String getEndTime() {
        return tradeOrder.getEndTime();
    }

    public void setEndTime(String endTime) {
        tradeOrder.setEndTime(endTime);
    }

    public String getStartTime() {
        return tradeOrder.getStartTime();
    }

    public void setStartTime(String startTime) {
        tradeOrder.setStartTime(startTime);
    }
}
