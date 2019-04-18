package com.synapse.reading.service;

import com.synapse.reading.model.Member;

import java.util.Map;
import java.util.HashMap;

/**
 * <p>
 * 用户信息 服务实现类
 * </p>
 *
 * @author liuguangfu
 * @since 2019-04-18
 */
public class MemberBaseService {

	protected Map<String,Object> prepareParams(Member memberParam) {
        Map<String,Object> params = new HashMap<>();
        if (memberParam.getUserId() != null && !memberParam.getUserId().trim().equals("")) {
            params.put("userId", memberParam.getUserId());
        }
        if (memberParam.getRole() != null && !memberParam.getRole().trim().equals("")) {
            params.put("role", memberParam.getRole());
        }
        if (memberParam.getImportData() != null && !memberParam.getImportData().trim().equals("")) {
            params.put("importData", memberParam.getImportData());
        }
        if (memberParam.getMobile() != null && !memberParam.getMobile().trim().equals("")) {
            params.put("mobile", memberParam.getMobile());
        }
        if (memberParam.getOfficeStatus() != null && !memberParam.getOfficeStatus().trim().equals("")) {
            params.put("officeStatus", memberParam.getOfficeStatus());
        }
        if (memberParam.getOrganization() != null && !memberParam.getOrganization().trim().equals("")) {
            params.put("organization", memberParam.getOrganization());
        }
        if (memberParam.getIdCard() != null && !memberParam.getIdCard().trim().equals("")) {
            params.put("idCard", memberParam.getIdCard());
        }
        if (memberParam.getStatus() != null && !memberParam.getStatus().trim().equals("")) {
            params.put("status", memberParam.getStatus());
        }
        if (memberParam.getPhase() != null && !memberParam.getPhase().trim().equals("")) {
            params.put("phase", memberParam.getPhase());
        }
        if (memberParam.getSubject() != null && !memberParam.getSubject().trim().equals("")) {
            params.put("subject", memberParam.getSubject());
        }
        if (memberParam.getName() != null && !memberParam.getName().trim().equals("")) {
            params.put("name", memberParam.getName());
        }
        if (memberParam.getPoint() != null) {
            params.put("point", memberParam.getPoint());
        }
        if (memberParam.getCreateId() != null && !memberParam.getCreateId().trim().equals("")) {
            params.put("createId", memberParam.getCreateId());
        }
        if (memberParam.getCreateTime() != null && !memberParam.getCreateTime().trim().equals("")) {
            params.put("createTime", memberParam.getCreateTime());
        }
        if (memberParam.getUpdateId() != null && !memberParam.getUpdateId().trim().equals("")) {
            params.put("updateId", memberParam.getUpdateId());
        }
        if (memberParam.getUpdateTime() != null && !memberParam.getUpdateTime().trim().equals("")) {
            params.put("updateTime", memberParam.getUpdateTime());
        }
        return params;
    }

}