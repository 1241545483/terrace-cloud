package com.synapse.reading.remote;

import com.synapse.common.trans.BizTrans;
import com.synapse.pay.dto.PayTransInfo;
import com.synapse.user.model.UserInfo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Map;

/**
 * 根据支付信息调用支付
 * Created by liugf on 19-4-8.
 */
@FeignClient(name = "${pay.url}")
public interface PayService {

    @RequestMapping(value = "/pay/v1/checkout/submit", method = RequestMethod.GET
            , produces = "application/json;charset=UTF-8", consumes = "application/json;charset=UTF-8")
    public BizTrans<Map<String, Object>> prePay(@RequestBody PayTransInfo payInfo);
}
