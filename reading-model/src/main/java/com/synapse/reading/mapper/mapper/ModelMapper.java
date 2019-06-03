package com.synapse.reading.mapper.mapper;

import com.synapse.reading.model.Model;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 系统模块 Mapper 接口
 * </p>
 *
 * @author liuguangfu
 * @since 2019-05-28
 */
public interface ModelMapper {
    Model selectByPrimaryKey(String recId);

    Integer deleteByPrimaryKey(String recId);

    void insert(Model model);

    void insertSelective(Model model);

    Integer updateByPrimaryKeySelective(Model model);

    Integer updateByPrimaryKey(Model model);

    List<Model> list(Map<String, Object> params);

    Integer count(Map<String, Object> params);
}
