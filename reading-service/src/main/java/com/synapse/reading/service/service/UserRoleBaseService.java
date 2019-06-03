package com.synapse.reading.service.service;

import com.synapse.reading.model.model.UserRole;

import java.util.Map;
import java.util.HashMap;

/**
 * <p>
 * 阅读这边目前就只有老师，学生 服务实现类
 * </p>
 *
 * @author liuguangfu
 * @since 2019-05-30
 */
public class UserRoleBaseService {

	protected Map<String,Object> prepareParams(UserRole userRoleParam) {
        Map<String,Object> params = new HashMap<>();
        if (userRoleParam.getRecId() != null && !userRoleParam.getRecId().trim().equals("")) {
            params.put("recId", userRoleParam.getRecId());
        }
        if (userRoleParam.getUserId() != null && !userRoleParam.getUserId().trim().equals("")) {
            params.put("userId", userRoleParam.getUserId());
        }
        if (userRoleParam.getRoleId() != null && !userRoleParam.getRoleId().trim().equals("")) {
            params.put("roleId", userRoleParam.getRoleId());
        }
        if (userRoleParam.getAppKey() != null && !userRoleParam.getAppKey().trim().equals("")) {
            params.put("appKey", userRoleParam.getAppKey());
        }
        if (userRoleParam.getOrgId() != null && !userRoleParam.getOrgId().trim().equals("")) {
            params.put("orgId", userRoleParam.getOrgId());
        }
        if (userRoleParam.getCreateId() != null && !userRoleParam.getCreateId().trim().equals("")) {
            params.put("createId", userRoleParam.getCreateId());
        }
        if (userRoleParam.getCreateTime() != null && !userRoleParam.getCreateTime().trim().equals("")) {
            params.put("createTime", userRoleParam.getCreateTime());
        }
        if (userRoleParam.getUpdateId() != null && !userRoleParam.getUpdateId().trim().equals("")) {
            params.put("updateId", userRoleParam.getUpdateId());
        }
        if (userRoleParam.getUpdateTime() != null && !userRoleParam.getUpdateTime().trim().equals("")) {
            params.put("updateTime", userRoleParam.getUpdateTime());
        }
        return params;
    }

}