package com.synapse.reading.service;

import com.synapse.reading.model.ClassStudentMapping;

import java.util.Map;
import java.util.HashMap;

/**
 * <p>
 * 班级和学生的关系 服务实现类
 * </p>
 *
 * @author liuguangfu
 * @since 2019-06-04
 */
public class ClassStudentMappingBaseService {

	protected Map<String,Object> prepareParams(ClassStudentMapping classStudentMappingParam) {
        Map<String,Object> params = new HashMap<>();
        if (classStudentMappingParam.getRecId() != null && !classStudentMappingParam.getRecId().trim().equals("")) {
            params.put("recId", classStudentMappingParam.getRecId());
        }
        if (classStudentMappingParam.getClassId() != null && !classStudentMappingParam.getClassId().trim().equals("")) {
            params.put("classId", classStudentMappingParam.getClassId());
        }
        if (classStudentMappingParam.getStudentId() != null && !classStudentMappingParam.getStudentId().trim().equals("")) {
            params.put("studentId", classStudentMappingParam.getStudentId());
        }
        if (classStudentMappingParam.getRealName() != null && !classStudentMappingParam.getRealName().trim().equals("")) {
            params.put("realName", classStudentMappingParam.getRealName());
        }
        if (classStudentMappingParam.getStatus() != null && !classStudentMappingParam.getStatus().trim().equals("")) {
            params.put("status", classStudentMappingParam.getStatus());
        }
        if (classStudentMappingParam.getCreateId() != null && !classStudentMappingParam.getCreateId().trim().equals("")) {
            params.put("createId", classStudentMappingParam.getCreateId());
        }
        if (classStudentMappingParam.getUpdateId() != null && !classStudentMappingParam.getUpdateId().trim().equals("")) {
            params.put("updateId", classStudentMappingParam.getUpdateId());
        }
        if (classStudentMappingParam.getCreateTime() != null && !classStudentMappingParam.getCreateTime().trim().equals("")) {
            params.put("createTime", classStudentMappingParam.getCreateTime());
        }
        if (classStudentMappingParam.getUpdateTime() != null && !classStudentMappingParam.getUpdateTime().trim().equals("")) {
            params.put("updateTime", classStudentMappingParam.getUpdateTime());
        }
        return params;
    }

}