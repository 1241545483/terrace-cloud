package com.synapse.reading.mapper.mapper;

import com.synapse.reading.model.model.ModelOperate;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 系统模块和code的关系 Mapper 接口
 * </p>
 *
 * @author liuguangfu
 * @since 2019-05-28
 */
public interface ModelOperateMapper {
    ModelOperate selectByPrimaryKey(String recId);

    Integer deleteByPrimaryKey(String recId);

    void insert(ModelOperate model);

    void insertSelective(ModelOperate model);

    Integer updateByPrimaryKeySelective(ModelOperate model);

    Integer updateByPrimaryKey(ModelOperate model);

    List<ModelOperate> list(Map<String, Object> params);

    Integer count(Map<String, Object> params);
}
