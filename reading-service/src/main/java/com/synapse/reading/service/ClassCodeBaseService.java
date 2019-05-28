package com.synapse.reading.service;

import com.synapse.reading.model.ClassCode;

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
public class ClassCodeBaseService {

	protected Map<String,Object> prepareParams(ClassCode classCodeParam) {
        Map<String,Object> params = new HashMap<>();
        if (classCodeParam.getClassCode() != null) {
            params.put("classCode", classCodeParam.getClassCode());
        }
        if (classCodeParam.getStatus() != null && !classCodeParam.getStatus().trim().equals("")) {
            params.put("status", classCodeParam.getStatus());
        }
        if (classCodeParam.getCreateId() != null && !classCodeParam.getCreateId().trim().equals("")) {
            params.put("createId", classCodeParam.getCreateId());
        }
        if (classCodeParam.getCreateTime() != null && !classCodeParam.getCreateTime().trim().equals("")) {
            params.put("createTime", classCodeParam.getCreateTime());
        }
        if (classCodeParam.getUpdateId() != null && !classCodeParam.getUpdateId().trim().equals("")) {
            params.put("updateId", classCodeParam.getUpdateId());
        }
        if (classCodeParam.getUpdateTime() != null && !classCodeParam.getUpdateTime().trim().equals("")) {
            params.put("updateTime", classCodeParam.getUpdateTime());
        }
        return params;
    }

}