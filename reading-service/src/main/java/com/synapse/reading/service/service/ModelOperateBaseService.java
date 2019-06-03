package com.synapse.reading.service.service;

import com.synapse.reading.model.model.ModelOperate;

import java.util.Map;
import java.util.HashMap;

/**
 * <p>
 * 系统模块和code的关系 服务实现类
 * </p>
 *
 * @author liuguangfu
 * @since 2019-05-28
 */
public class ModelOperateBaseService {

	protected Map<String,Object> prepareParams(ModelOperate modelOperateParam) {
        Map<String,Object> params = new HashMap<>();
        if (modelOperateParam.getRecId() != null && !modelOperateParam.getRecId().trim().equals("")) {
            params.put("recId", modelOperateParam.getRecId());
        }
        if (modelOperateParam.getModelId() != null && !modelOperateParam.getModelId().trim().equals("")) {
            params.put("modelId", modelOperateParam.getModelId());
        }
        if (modelOperateParam.getCode() != null && !modelOperateParam.getCode().trim().equals("")) {
            params.put("code", modelOperateParam.getCode());
        }
        if (modelOperateParam.getDesc() != null && !modelOperateParam.getDesc().trim().equals("")) {
            params.put("desc", modelOperateParam.getDesc());
        }
        if (modelOperateParam.getStatus() != null && !modelOperateParam.getStatus().trim().equals("")) {
            params.put("status", modelOperateParam.getStatus());
        }
        if (modelOperateParam.getCreateId() != null && !modelOperateParam.getCreateId().trim().equals("")) {
            params.put("createId", modelOperateParam.getCreateId());
        }
        if (modelOperateParam.getUpdateId() != null && !modelOperateParam.getUpdateId().trim().equals("")) {
            params.put("updateId", modelOperateParam.getUpdateId());
        }
        if (modelOperateParam.getCreateTime() != null && !modelOperateParam.getCreateTime().trim().equals("")) {
            params.put("createTime", modelOperateParam.getCreateTime());
        }
        if (modelOperateParam.getUpdateTime() != null && !modelOperateParam.getUpdateTime().trim().equals("")) {
            params.put("updateTime", modelOperateParam.getUpdateTime());
        }
        return params;
    }

}