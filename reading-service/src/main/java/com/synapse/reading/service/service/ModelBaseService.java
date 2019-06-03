package com.synapse.reading.service.service;

import com.synapse.reading.model.model.Model;

import java.util.Map;
import java.util.HashMap;

/**
 * <p>
 * 系统模块 服务实现类
 * </p>
 *
 * @author liuguangfu
 * @since 2019-05-28
 */
public class ModelBaseService {

	protected Map<String,Object> prepareParams(Model modelParam) {
        Map<String,Object> params = new HashMap<>();
        if (modelParam.getRecId() != null && !modelParam.getRecId().trim().equals("")) {
            params.put("recId", modelParam.getRecId());
        }
        if (modelParam.getMenuId() != null && !modelParam.getMenuId().trim().equals("")) {
            params.put("menuId", modelParam.getMenuId());
        }
        if (modelParam.getOperateDesc() != null && !modelParam.getOperateDesc().trim().equals("")) {
            params.put("operateDesc", modelParam.getOperateDesc());
        }
        if (modelParam.getName() != null && !modelParam.getName().trim().equals("")) {
            params.put("name", modelParam.getName());
        }
        if (modelParam.getStatus() != null && !modelParam.getStatus().trim().equals("")) {
            params.put("status", modelParam.getStatus());
        }
        if (modelParam.getCreateId() != null && !modelParam.getCreateId().trim().equals("")) {
            params.put("createId", modelParam.getCreateId());
        }
        if (modelParam.getCreateTime() != null && !modelParam.getCreateTime().trim().equals("")) {
            params.put("createTime", modelParam.getCreateTime());
        }
        if (modelParam.getUpdateId() != null && !modelParam.getUpdateId().trim().equals("")) {
            params.put("updateId", modelParam.getUpdateId());
        }
        if (modelParam.getUpdateTime() != null && !modelParam.getUpdateTime().trim().equals("")) {
            params.put("updateTime", modelParam.getUpdateTime());
        }
        return params;
    }

}