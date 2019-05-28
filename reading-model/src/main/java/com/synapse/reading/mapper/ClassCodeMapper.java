package com.synapse.reading.mapper;

import com.synapse.reading.model.ClassCode;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author liuguangfu
 * @since 2019-05-28
 */
public interface ClassCodeMapper {
    ClassCode selectByPrimaryKey(String recId);

    Integer deleteByPrimaryKey(String recId);

    void insert(ClassCode model);

    void insertSelective(ClassCode model);

    Integer updateByPrimaryKeySelective(ClassCode model);

    Integer updateByPrimaryKey(ClassCode model);

    List<ClassCode> list(Map<String, Object> params);

    Integer count(Map<String, Object> params);
}
