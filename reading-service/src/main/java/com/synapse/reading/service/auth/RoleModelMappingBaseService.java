package com.synapse.reading.service.auth;

import com.synapse.reading.model.auth.RoleModelMapping;

import java.util.Map;
import java.util.HashMap;

/**
 * <p>
 * 系统模块和角色的关系 服务实现类
 * </p>
 *
 * @author liuguangfu
 * @since 2019-05-28
 */
public class RoleModelMappingBaseService {

	protected Map<String,Object> prepareParams(RoleModelMapping roleModelMappingParam) {
        Map<String,Object> params = new HashMap<>();
        if (roleModelMappingParam.getRecId() != null && !roleModelMappingParam.getRecId().trim().equals("")) {
            params.put("recId", roleModelMappingParam.getRecId());
        }
        if (roleModelMappingParam.getModelId() != null && !roleModelMappingParam.getModelId().trim().equals("")) {
            params.put("modelId", roleModelMappingParam.getModelId());
        }
        if (roleModelMappingParam.getRoleId() != null && !roleModelMappingParam.getRoleId().trim().equals("")) {
            params.put("roleId", roleModelMappingParam.getRoleId());
        }
        if (roleModelMappingParam.getStatus() != null && !roleModelMappingParam.getStatus().trim().equals("")) {
            params.put("status", roleModelMappingParam.getStatus());
        }
        if (roleModelMappingParam.getCreateId() != null && !roleModelMappingParam.getCreateId().trim().equals("")) {
            params.put("createId", roleModelMappingParam.getCreateId());
        }
        if (roleModelMappingParam.getUpdateId() != null && !roleModelMappingParam.getUpdateId().trim().equals("")) {
            params.put("updateId", roleModelMappingParam.getUpdateId());
        }
        if (roleModelMappingParam.getCreateTime() != null && !roleModelMappingParam.getCreateTime().trim().equals("")) {
            params.put("createTime", roleModelMappingParam.getCreateTime());
        }
        if (roleModelMappingParam.getUpdateTime() != null && !roleModelMappingParam.getUpdateTime().trim().equals("")) {
            params.put("updateTime", roleModelMappingParam.getUpdateTime());
        }
        return params;
    }

}
