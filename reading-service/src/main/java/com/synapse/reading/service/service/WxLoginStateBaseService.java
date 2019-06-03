package com.synapse.reading.service.service;

import com.synapse.reading.model.model.WxLoginState;

import java.util.Map;
import java.util.HashMap;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author liuguangfu
 * @since 2019-05-28
 */
public class WxLoginStateBaseService {

	protected Map<String,Object> prepareParams(WxLoginState wxLoginStateParam) {
        Map<String,Object> params = new HashMap<>();
        if (wxLoginStateParam.getRecId() != null && !wxLoginStateParam.getRecId().trim().equals("")) {
            params.put("recId", wxLoginStateParam.getRecId());
        }
        if (wxLoginStateParam.getOpenId() != null && !wxLoginStateParam.getOpenId().trim().equals("")) {
            params.put("openId", wxLoginStateParam.getOpenId());
        }
        if (wxLoginStateParam.getUnionId() != null && !wxLoginStateParam.getUnionId().trim().equals("")) {
            params.put("unionId", wxLoginStateParam.getUnionId());
        }
        if (wxLoginStateParam.getToken() != null && !wxLoginStateParam.getToken().trim().equals("")) {
            params.put("token", wxLoginStateParam.getToken());
        }
        if (wxLoginStateParam.getStatus() != null && !wxLoginStateParam.getStatus().trim().equals("")) {
            params.put("status", wxLoginStateParam.getStatus());
        }
        if (wxLoginStateParam.getStatusDesc() != null && !wxLoginStateParam.getStatusDesc().trim().equals("")) {
            params.put("statusDesc", wxLoginStateParam.getStatusDesc());
        }
        return params;
    }

}