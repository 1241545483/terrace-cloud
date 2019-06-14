package com.synapse.reading.service;

import com.synapse.reading.model.Task;

import java.util.Map;
import java.util.HashMap;

/**
 * <p>
 * 任务 服务实现类
 * </p>
 *
 * @author liuguangfu
 * @since 2019-06-14
 */
public class TaskBaseService {

	protected Map<String,Object> prepareParams(Task taskParam) {
        Map<String,Object> params = new HashMap<>();
        if (taskParam.getRecId() != null && !taskParam.getRecId().trim().equals("")) {
            params.put("recId", taskParam.getRecId());
        }
        if (taskParam.getName() != null && !taskParam.getName().trim().equals("")) {
            params.put("name", taskParam.getName());
        }
        if (taskParam.getCover() != null && !taskParam.getCover().trim().equals("")) {
            params.put("cover", taskParam.getCover());
        }
        if (taskParam.getStartTime() != null && !taskParam.getStartTime().trim().equals("")) {
            params.put("startTime", taskParam.getStartTime());
        }
        if (taskParam.getEndTime() != null && !taskParam.getEndTime().trim().equals("")) {
            params.put("endTime", taskParam.getEndTime());
        }
        if (taskParam.getIntro() != null && !taskParam.getIntro().trim().equals("")) {
            params.put("intro", taskParam.getIntro());
        }
        if (taskParam.getStudyType() != null && !taskParam.getStudyType().trim().equals("")) {
            params.put("studyType", taskParam.getStudyType());
        }
        if (taskParam.getStudyId() != null && !taskParam.getStudyId().trim().equals("")) {
            params.put("studyId", taskParam.getStudyId());
        }
        if (taskParam.getClassId() != null && !taskParam.getClassId().trim().equals("")) {
            params.put("classId", taskParam.getClassId());
        }
        if (taskParam.getStatus() != null && !taskParam.getStatus().trim().equals("")) {
            params.put("status", taskParam.getStatus());
        }
        if (taskParam.getCreateId() != null && !taskParam.getCreateId().trim().equals("")) {
            params.put("createId", taskParam.getCreateId());
        }
        if (taskParam.getCreateTime() != null && !taskParam.getCreateTime().trim().equals("")) {
            params.put("createTime", taskParam.getCreateTime());
        }
        if (taskParam.getUpdateId() != null && !taskParam.getUpdateId().trim().equals("")) {
            params.put("updateId", taskParam.getUpdateId());
        }
        if (taskParam.getUpdateTime() != null && !taskParam.getUpdateTime().trim().equals("")) {
            params.put("updateTime", taskParam.getUpdateTime());
        }
        return params;
    }

}