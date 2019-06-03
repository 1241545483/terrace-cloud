package com.synapse.reading.mapper.mapper;

import com.synapse.reading.model.Bind;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 储存用户绑定关系表，用户和对应的openId，unionId等 Mapper 接口
 * </p>
 *
 * @author liuguangfu
 * @since 2019-05-28
 */
public interface BindMapper {
    Bind selectByPrimaryKey(String recId);

    Integer deleteByPrimaryKey(String recId);

    void insert(Bind model);

    void insertSelective(Bind model);

    Integer updateByPrimaryKeySelective(Bind model);

    Integer updateByPrimaryKey(Bind model);

    List<Bind> list(Map<String, Object> params);

    Integer count(Map<String, Object> params);
}
