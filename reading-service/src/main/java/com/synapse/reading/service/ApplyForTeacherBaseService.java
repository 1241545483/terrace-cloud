package com.synapse.reading.service;

import com.synapse.reading.model.ApplyForTeacher;

import java.util.Map;
import java.util.HashMap;

/**
 * <p>
 * 申请成为老师 服务实现类
 * </p>
 *
 * @author liuguangfu
 * @since 2019-06-19
 */
public class ApplyForTeacherBaseService {

	protected Map<String,Object> prepareParams(ApplyForTeacher applyForTeacherParam) {
        Map<String,Object> params = new HashMap<>();
        if (applyForTeacherParam.getRecId() != null && !applyForTeacherParam.getRecId().trim().equals("")) {
            params.put("recId", applyForTeacherParam.getRecId());
        }
        if (applyForTeacherParam.getName() != null && !applyForTeacherParam.getName().trim().equals("")) {
            params.put("name", applyForTeacherParam.getName());
        }
        if (applyForTeacherParam.getUserId() != null && !applyForTeacherParam.getUserId().trim().equals("")) {
            params.put("userId", applyForTeacherParam.getUserId());
        }
        if (applyForTeacherParam.getReason() != null && !applyForTeacherParam.getReason().trim().equals("")) {
            params.put("reason", applyForTeacherParam.getReason());
        }
        if (applyForTeacherParam.getStatus() != null && !applyForTeacherParam.getStatus().trim().equals("")) {
            params.put("status", applyForTeacherParam.getStatus());
        }
        if (applyForTeacherParam.getCreateId() != null && !applyForTeacherParam.getCreateId().trim().equals("")) {
            params.put("createId", applyForTeacherParam.getCreateId());
        }
        if (applyForTeacherParam.getCreateTime() != null && !applyForTeacherParam.getCreateTime().trim().equals("")) {
            params.put("createTime", applyForTeacherParam.getCreateTime());
        }
        if (applyForTeacherParam.getUpdateId() != null && !applyForTeacherParam.getUpdateId().trim().equals("")) {
            params.put("updateId", applyForTeacherParam.getUpdateId());
        }
        if (applyForTeacherParam.getUpdateTime() != null && !applyForTeacherParam.getUpdateTime().trim().equals("")) {
            params.put("updateTime", applyForTeacherParam.getUpdateTime());
        }
        return params;
    }

}