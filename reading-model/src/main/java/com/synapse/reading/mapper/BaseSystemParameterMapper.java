package com.synapse.reading.mapper;

import com.synapse.reading.model.BaseSystemParameter;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author wangyifan
 * @since 2018-11-20
 */
public interface BaseSystemParameterMapper {
    BaseSystemParameter selectByPrimaryKey(String recId);

    Integer deleteByPrimaryKey(String recId);

    void insert(BaseSystemParameter model);

    void insertSelective(BaseSystemParameter model);

    Integer updateByPrimaryKeySelective(BaseSystemParameter model);

    Integer updateByPrimaryKey(BaseSystemParameter model);

    List<BaseSystemParameter> list(Map<String, Object> params);

    Integer count(Map<String, Object> params);
}
