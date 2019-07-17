package com.synapse.reading.mapper.auth;

import com.synapse.reading.model.auth.UserRole;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 阅读这边目前就只有老师，学生 Mapper 接口
 * </p>
 *
 * @author liuguangfu
 * @since 2019-05-30
 */
public interface UserRoleMapper {
    UserRole selectByPrimaryKey(String recId);

    Integer deleteByPrimaryKey(String recId);

    void insert(UserRole model);

    void insertSelective(UserRole model);

    Integer updateByPrimaryKeySelective(UserRole model);

    Integer updateByPrimaryKey(UserRole model);

    List<UserRole> list(Map<String, Object> params);

    Integer count(Map<String, Object> params);
}
