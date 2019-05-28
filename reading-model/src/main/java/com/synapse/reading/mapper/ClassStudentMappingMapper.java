package com.synapse.reading.mapper;

import com.synapse.reading.model.ClassStudentMapping;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 班级和学生的关系 Mapper 接口
 * </p>
 *
 * @author liuguangfu
 * @since 2019-05-28
 */
public interface ClassStudentMappingMapper {
    ClassStudentMapping selectByPrimaryKey(String recId);

    Integer deleteByPrimaryKey(String recId);

    void insert(ClassStudentMapping model);

    void insertSelective(ClassStudentMapping model);

    Integer updateByPrimaryKeySelective(ClassStudentMapping model);

    Integer updateByPrimaryKey(ClassStudentMapping model);

    List<ClassStudentMapping> list(Map<String, Object> params);

    Integer count(Map<String, Object> params);
}
