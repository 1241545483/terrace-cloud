package com.synapse.reading.mapper;

import com.synapse.reading.model.Topic;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 主题，关联专辑 Mapper 接口
 * </p>
 *
 * @author liuguangfu
 * @since 2019-02-15
 */
public interface TopicMapper {
    Topic selectByPrimaryKey(String recId);

    Integer deleteByPrimaryKey(String recId);

    void insert(Topic model);

    void insertSelective(Topic model);

    Integer updateByPrimaryKeySelective(Topic model);

    Integer updateByPrimaryKey(Topic model);

    List<Topic> list(Map<String, Object> params);

    Integer count(Map<String, Object> params);
}
