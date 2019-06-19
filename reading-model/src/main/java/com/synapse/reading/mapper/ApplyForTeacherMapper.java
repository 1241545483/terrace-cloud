package com.synapse.reading.mapper;

import com.synapse.reading.model.ApplyForTeacher;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 申请成为老师 Mapper 接口
 * </p>
 *
 * @author liuguangfu
 * @since 2019-06-19
 */
public interface ApplyForTeacherMapper {
    ApplyForTeacher selectByPrimaryKey(String recId);

    Integer deleteByPrimaryKey(String recId);

    void insert(ApplyForTeacher model);

    void insertSelective(ApplyForTeacher model);

    Integer updateByPrimaryKeySelective(ApplyForTeacher model);

    Integer updateByPrimaryKey(ApplyForTeacher model);

    List<ApplyForTeacher> list(Map<String, Object> params);

    Integer count(Map<String, Object> params);
}
