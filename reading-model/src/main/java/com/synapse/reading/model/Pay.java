package com.synapse.reading.model;

import com.synapse.pay.dto.PayTransInfo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 目录及其下面的item（目录或具体的信息（书籍，音频，视频等））的信息
 */
public class Pay {

    private PayTransInfo payInfo = new PayTransInfo();

    private Map<String,String> param = new HashMap<>();

    public PayTransInfo getPayInfo() {
        return payInfo;
    }

    public void setPayInfo(PayTransInfo payInfo) {
        this.payInfo = payInfo;
    }

    public Map<String, String> getParam() {
        return param;
    }

    public void setParam(Map<String, String> param) {
        this.param = param;
    }
}
