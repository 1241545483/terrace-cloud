package com.synapse.reading.service;

import com.synapse.reading.model.TaskStudyMapping;

import java.util.Map;
import java.util.HashMap;

/**
 * <p>
 * 任务和学习课程的关系 服务实现类
 * </p>
 *
 * @author liuguangfu
 * @since 2019-06-12
 */
public class TaskStudyMappingBaseService {

	protected Map<String,Object> prepareParams(TaskStudyMapping taskStudyMappingParam) {
        Map<String,Object> params = new HashMap<>();
        if (taskStudyMappingParam.getRecId() != null && !taskStudyMappingParam.getRecId().trim().equals("")) {
            params.put("recId", taskStudyMappingParam.getRecId());
        }
        if (taskStudyMappingParam.getTaskId() != null && !taskStudyMappingParam.getTaskId().trim().equals("")) {
            params.put("taskId", taskStudyMappingParam.getTaskId());
        }
        if (taskStudyMappingParam.getStudyId() != null && !taskStudyMappingParam.getStudyId().trim().equals("")) {
            params.put("studyId", taskStudyMappingParam.getStudyId());
        }
        if (taskStudyMappingParam.getStudyType() != null && !taskStudyMappingParam.getStudyType().trim().equals("")) {
            params.put("studyType", taskStudyMappingParam.getStudyType());
        }
        if (taskStudyMappingParam.getStatus() != null && !taskStudyMappingParam.getStatus().trim().equals("")) {
            params.put("status", taskStudyMappingParam.getStatus());
        }
        if (taskStudyMappingParam.getCreateId() != null && !taskStudyMappingParam.getCreateId().trim().equals("")) {
            params.put("createId", taskStudyMappingParam.getCreateId());
        }
        if (taskStudyMappingParam.getUpdateId() != null && !taskStudyMappingParam.getUpdateId().trim().equals("")) {
            params.put("updateId", taskStudyMappingParam.getUpdateId());
        }
        if (taskStudyMappingParam.getCreateTime() != null && !taskStudyMappingParam.getCreateTime().trim().equals("")) {
            params.put("createTime", taskStudyMappingParam.getCreateTime());
        }
        if (taskStudyMappingParam.getUpdateTime() != null && !taskStudyMappingParam.getUpdateTime().trim().equals("")) {
            params.put("updateTime", taskStudyMappingParam.getUpdateTime());
        }
        return params;
    }

}