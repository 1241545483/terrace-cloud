package com.synapse.reading.mapper.auth;

import com.synapse.reading.model.auth.RoleModelMapping;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 系统模块和角色的关系 Mapper 接口
 * </p>
 *
 * @author liuguangfu
 * @since 2019-05-28
 */
public interface RoleModelMappingMapper {
    RoleModelMapping selectByPrimaryKey(String recId);

    Integer deleteByPrimaryKey(String recId);

    void insert(RoleModelMapping model);

    void insertSelective(RoleModelMapping model);

    Integer updateByPrimaryKeySelective(RoleModelMapping model);

    Integer updateByPrimaryKey(RoleModelMapping model);

    List<RoleModelMapping> list(Map<String, Object> params);

    Integer count(Map<String, Object> params);
}
