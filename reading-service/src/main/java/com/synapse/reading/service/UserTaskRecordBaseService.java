package com.synapse.reading.service;

import com.synapse.reading.model.UserTaskRecord;

import java.util.Map;
import java.util.HashMap;

/**
 * <p>
 * 任务接受记录 服务实现类
 * </p>
 *
 * @author liuguangfu
 * @since 2019-06-12
 */
public class UserTaskRecordBaseService {

	protected Map<String,Object> prepareParams(UserTaskRecord userTaskRecordParam) {
        Map<String,Object> params = new HashMap<>();
        if (userTaskRecordParam.getRecId() != null && !userTaskRecordParam.getRecId().trim().equals("")) {
            params.put("recId", userTaskRecordParam.getRecId());
        }
        if (userTaskRecordParam.getTaskId() != null && !userTaskRecordParam.getTaskId().trim().equals("")) {
            params.put("taskId", userTaskRecordParam.getTaskId());
        }
        if (userTaskRecordParam.getUserId() != null && !userTaskRecordParam.getUserId().trim().equals("")) {
            params.put("userId", userTaskRecordParam.getUserId());
        }
        if (userTaskRecordParam.getStatus() != null && !userTaskRecordParam.getStatus().trim().equals("")) {
            params.put("status", userTaskRecordParam.getStatus());
        }
        if (userTaskRecordParam.getCreateId() != null && !userTaskRecordParam.getCreateId().trim().equals("")) {
            params.put("createId", userTaskRecordParam.getCreateId());
        }
        if (userTaskRecordParam.getCreateTime() != null && !userTaskRecordParam.getCreateTime().trim().equals("")) {
            params.put("createTime", userTaskRecordParam.getCreateTime());
        }
        if (userTaskRecordParam.getUpdateId() != null && !userTaskRecordParam.getUpdateId().trim().equals("")) {
            params.put("updateId", userTaskRecordParam.getUpdateId());
        }
        if (userTaskRecordParam.getUpdateTime() != null && !userTaskRecordParam.getUpdateTime().trim().equals("")) {
            params.put("updateTime", userTaskRecordParam.getUpdateTime());
        }
        return params;
    }

}