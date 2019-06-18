package com.synapse.reading.model;

import com.synapse.pay.dto.PayTransInfo;
import com.synapse.reading.dto.param.TradeOrderParam;
import org.springframework.aop.TargetSource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 目录及其下面的item（目录或具体的信息（书籍，音频，视频等））的信息
 */
public class Pay {

    private  String  item_type;

    private PayTransInfo payInfo = new PayTransInfo();

private TradeOrderParam tradeOrderParam =new TradeOrderParam();

    public PayTransInfo getPayInfo() {
        return payInfo;
    }

    public void setPayInfo(PayTransInfo payInfo) {
        this.payInfo = payInfo;
    }

    public TradeOrderParam getTradeOrderParam() {
        return tradeOrderParam;
    }

    public void setTradeOrderParam(TradeOrderParam tradeOrderParam) {
        this.tradeOrderParam = tradeOrderParam;
    }

    public String getItem_type() {
        return item_type;
    }

    public void setItem_type(String item_type) {
        this.item_type = item_type;
    }
}
