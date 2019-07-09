package com.synapse.reading.service;

import com.synapse.reading.model.OrgCode;

import java.util.Map;
import java.util.HashMap;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author liuguangfu
 * @since 2019-07-08
 */
public class OrgCodeBaseService {

	protected Map<String,Object> prepareParams(OrgCode orgCodeParam) {
        Map<String,Object> params = new HashMap<>();
        if (orgCodeParam.getOrgCode() != null) {
            params.put("orgCode", orgCodeParam.getOrgCode());
        }
        if (orgCodeParam.getStatus() != null && !orgCodeParam.getStatus().trim().equals("")) {
            params.put("status", orgCodeParam.getStatus());
        }
        if (orgCodeParam.getQrCode() != null && !orgCodeParam.getQrCode().trim().equals("")) {
            params.put("qrCode", orgCodeParam.getQrCode());
        }
        if (orgCodeParam.getCreateId() != null && !orgCodeParam.getCreateId().trim().equals("")) {
            params.put("createId", orgCodeParam.getCreateId());
        }
        if (orgCodeParam.getCreateTime() != null && !orgCodeParam.getCreateTime().trim().equals("")) {
            params.put("createTime", orgCodeParam.getCreateTime());
        }
        if (orgCodeParam.getUpdateId() != null && !orgCodeParam.getUpdateId().trim().equals("")) {
            params.put("updateId", orgCodeParam.getUpdateId());
        }
        if (orgCodeParam.getUpdateTime() != null && !orgCodeParam.getUpdateTime().trim().equals("")) {
            params.put("updateTime", orgCodeParam.getUpdateTime());
        }
        return params;
    }

}