package com.synapse.reading.mapper;

import com.synapse.reading.model.Information;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 资讯模块 Mapper 接口
 * </p>
 *
 * @author liuguangfu
 * @since 2018-12-27
 */
public interface InformationMapper {
    Information selectByPrimaryKey(String recId);

    Integer deleteByPrimaryKey(String recId);

    void insert(Information model);

    void insertSelective(Information model);

    Integer updateByPrimaryKeySelective(Information model);

    Integer updateByPrimaryKey(Information model);

    List<Information> list(Map<String, Object> params);

    Integer count(Map<String, Object> params);
}
