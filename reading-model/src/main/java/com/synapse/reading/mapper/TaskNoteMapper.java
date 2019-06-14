package com.synapse.reading.mapper;

import com.synapse.reading.model.TaskNote;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 任务笔记 Mapper 接口
 * </p>
 *
 * @author liuguangfu
 * @since 2019-06-13
 */
public interface TaskNoteMapper {
    TaskNote selectByPrimaryKey(String recId);

    Integer deleteByPrimaryKey(String recId);

    void insert(TaskNote model);

    void insertSelective(TaskNote model);

    Integer updateByPrimaryKeySelective(TaskNote model);

    Integer updateByPrimaryKey(TaskNote model);

    List<TaskNote> list(Map<String, Object> params);

    Integer count(Map<String, Object> params);
}
