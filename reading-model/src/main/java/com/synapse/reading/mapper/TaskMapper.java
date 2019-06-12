package com.synapse.reading.mapper;

import com.synapse.reading.model.Task;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 任务 Mapper 接口
 * </p>
 *
 * @author liuguangfu
 * @since 2019-06-12
 */
public interface TaskMapper {
    Task selectByPrimaryKey(String recId);

    Integer deleteByPrimaryKey(String recId);

    void insert(Task model);

    void insertSelective(Task model);

    Integer updateByPrimaryKeySelective(Task model);

    Integer updateByPrimaryKey(Task model);

    List<Task> list(Map<String, Object> params);

    Integer count(Map<String, Object> params);
}
