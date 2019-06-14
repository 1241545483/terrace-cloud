package com.synapse.reading.service;

import com.synapse.reading.model.TaskNote;

import java.util.Map;
import java.util.HashMap;

/**
 * <p>
 * 任务笔记 服务实现类
 * </p>
 *
 * @author liuguangfu
 * @since 2019-06-13
 */
public class TaskNoteBaseService {

	protected Map<String,Object> prepareParams(TaskNote taskNoteParam) {
        Map<String,Object> params = new HashMap<>();
        if (taskNoteParam.getRecId() != null && !taskNoteParam.getRecId().trim().equals("")) {
            params.put("recId", taskNoteParam.getRecId());
        }
        if (taskNoteParam.getNote() != null && !taskNoteParam.getNote().trim().equals("")) {
            params.put("note", taskNoteParam.getNote());
        }
        if (taskNoteParam.getUserId() != null && !taskNoteParam.getUserId().trim().equals("")) {
            params.put("userId", taskNoteParam.getUserId());
        }
        if (taskNoteParam.getTaskId() != null && !taskNoteParam.getTaskId().trim().equals("")) {
            params.put("taskId", taskNoteParam.getTaskId());
        }
        if (taskNoteParam.getImg1() != null && !taskNoteParam.getImg1().trim().equals("")) {
            params.put("img1", taskNoteParam.getImg1());
        }
        if (taskNoteParam.getImg2() != null && !taskNoteParam.getImg2().trim().equals("")) {
            params.put("img2", taskNoteParam.getImg2());
        }
        if (taskNoteParam.getImg3() != null && !taskNoteParam.getImg3().trim().equals("")) {
            params.put("img3", taskNoteParam.getImg3());
        }
        if (taskNoteParam.getStatus() != null && !taskNoteParam.getStatus().trim().equals("")) {
            params.put("status", taskNoteParam.getStatus());
        }
        if (taskNoteParam.getCreateId() != null && !taskNoteParam.getCreateId().trim().equals("")) {
            params.put("createId", taskNoteParam.getCreateId());
        }
        if (taskNoteParam.getCreateTime() != null && !taskNoteParam.getCreateTime().trim().equals("")) {
            params.put("createTime", taskNoteParam.getCreateTime());
        }
        if (taskNoteParam.getUpdateId() != null && !taskNoteParam.getUpdateId().trim().equals("")) {
            params.put("updateId", taskNoteParam.getUpdateId());
        }
        if (taskNoteParam.getUpdateTime() != null && !taskNoteParam.getUpdateTime().trim().equals("")) {
            params.put("updateTime", taskNoteParam.getUpdateTime());
        }
        return params;
    }

}