package com.synapse.reading.service.service;

import com.synapse.reading.model.model.Organization;

import java.util.Map;
import java.util.HashMap;

/**
 * <p>
 * 组织机构 服务实现类
 * </p>
 *
 * @author liuguangfu
 * @since 2019-05-28
 */
public class OrganizationBaseService {

	protected Map<String,Object> prepareParams(Organization organizationParam) {
        Map<String,Object> params = new HashMap<>();
        if (organizationParam.getOrgId() != null && !organizationParam.getOrgId().trim().equals("")) {
            params.put("orgId", organizationParam.getOrgId());
        }
        if (organizationParam.getOrgName() != null && !organizationParam.getOrgName().trim().equals("")) {
            params.put("orgName", organizationParam.getOrgName());
        }
        if (organizationParam.getStatus() != null && !organizationParam.getStatus().trim().equals("")) {
            params.put("status", organizationParam.getStatus());
        }
        if (organizationParam.getOrgNature() != null && !organizationParam.getOrgNature().trim().equals("")) {
            params.put("orgNature", organizationParam.getOrgNature());
        }
        if (organizationParam.getParentOrgId() != null && !organizationParam.getParentOrgId().trim().equals("")) {
            params.put("parentOrgId", organizationParam.getParentOrgId());
        }
        if (organizationParam.getOrgLocation() != null && !organizationParam.getOrgLocation().trim().equals("")) {
            params.put("orgLocation", organizationParam.getOrgLocation());
        }
        if (organizationParam.getCreateId() != null && !organizationParam.getCreateId().trim().equals("")) {
            params.put("createId", organizationParam.getCreateId());
        }
        if (organizationParam.getCreateTime() != null && !organizationParam.getCreateTime().trim().equals("")) {
            params.put("createTime", organizationParam.getCreateTime());
        }
        if (organizationParam.getUpdateId() != null && !organizationParam.getUpdateId().trim().equals("")) {
            params.put("updateId", organizationParam.getUpdateId());
        }
        if (organizationParam.getUpdateTime() != null && !organizationParam.getUpdateTime().trim().equals("")) {
            params.put("updateTime", organizationParam.getUpdateTime());
        }
        return params;
    }

}