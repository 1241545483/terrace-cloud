package com.synapse.reading.mapper;

import com.synapse.reading.model.TaskStudyMapping;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 任务和学习课程的关系 Mapper 接口
 * </p>
 *
 * @author liuguangfu
 * @since 2019-06-12
 */
public interface TaskStudyMappingMapper {
    TaskStudyMapping selectByPrimaryKey(String recId);

    Integer deleteByPrimaryKey(String recId);

    void insert(TaskStudyMapping model);

    void insertSelective(TaskStudyMapping model);

    Integer updateByPrimaryKeySelective(TaskStudyMapping model);

    Integer updateByPrimaryKey(TaskStudyMapping model);

    List<TaskStudyMapping> list(Map<String, Object> params);

    Integer count(Map<String, Object> params);
}
