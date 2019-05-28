package com.synapse.reading.mapper;

import com.synapse.reading.model.ClassInfo;

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
public interface ClassInfoMapper {
    ClassInfo selectByPrimaryKey(String recId);

    Integer deleteByPrimaryKey(String recId);

    void insert(ClassInfo model);

    void insertSelective(ClassInfo model);

    Integer updateByPrimaryKeySelective(ClassInfo model);

    Integer updateByPrimaryKey(ClassInfo model);

    List<ClassInfo> list(Map<String, Object> params);

    Integer count(Map<String, Object> params);
}
