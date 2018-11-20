package com.synapse.reading.service;

import com.synapse.reading.model.BaseSystemParameter;

import java.util.Map;
import java.util.HashMap;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wangyifan
 * @since 2018-11-20
 */
public class BaseSystemParameterBaseService {

	protected Map<String,Object> prepareParams(BaseSystemParameter baseSystemParameterParam) {
        Map<String,Object> params = new HashMap<>();
        if (baseSystemParameterParam.getRecId() != null && !baseSystemParameterParam.getRecId().trim().equals("")) {
            params.put("recId", baseSystemParameterParam.getRecId());
        }
        if (baseSystemParameterParam.getParameterType() != null && !baseSystemParameterParam.getParameterType().trim().equals("")) {
            params.put("parameterType", baseSystemParameterParam.getParameterType());
        }
        if (baseSystemParameterParam.getParameterKey() != null && !baseSystemParameterParam.getParameterKey().trim().equals("")) {
            params.put("parameterKey", baseSystemParameterParam.getParameterKey());
        }
        if (baseSystemParameterParam.getParameterName() != null && !baseSystemParameterParam.getParameterName().trim().equals("")) {
            params.put("parameterName", baseSystemParameterParam.getParameterName());
        }
        if (baseSystemParameterParam.getParameterValue() != null && !baseSystemParameterParam.getParameterValue().trim().equals("")) {
            params.put("parameterValue", baseSystemParameterParam.getParameterValue());
        }
        if (baseSystemParameterParam.getWeight() != null) {
            params.put("weight", baseSystemParameterParam.getWeight());
        }
        if (baseSystemParameterParam.getParentParameterType() != null && !baseSystemParameterParam.getParentParameterType().trim().equals("")) {
            params.put("parentParameterType", baseSystemParameterParam.getParentParameterType());
        }
        if (baseSystemParameterParam.getParentParameterKey() != null && !baseSystemParameterParam.getParentParameterKey().trim().equals("")) {
            params.put("parentParameterKey", baseSystemParameterParam.getParentParameterKey());
        }
        if (baseSystemParameterParam.getAddTime() != null && !baseSystemParameterParam.getAddTime().trim().equals("")) {
            params.put("addTime", baseSystemParameterParam.getAddTime());
        }
        if (baseSystemParameterParam.getUpdateTime() != null && !baseSystemParameterParam.getUpdateTime().trim().equals("")) {
            params.put("updateTime", baseSystemParameterParam.getUpdateTime());
        }
        return params;
    }

}