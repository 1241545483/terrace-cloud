package com.synapse.reading.mapper;

import com.synapse.reading.model.Lesson;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 课程 Mapper 接口
 * </p>
 *
 * @author liuguangfu
 * @since 2019-04-09
 */
public interface LessonMapper {
    Lesson selectByPrimaryKey(String recId);

    Integer deleteByPrimaryKey(String recId);

    void insert(Lesson model);

    void insertSelective(Lesson model);

    Integer updateByPrimaryKeySelective(Lesson model);

    Integer updateByPrimaryKey(Lesson model);

    List<Lesson> list(Map<String, Object> params);

    Integer count(Map<String, Object> params);
}
