package com.synapse.reading.mapper.mapper;

import com.synapse.reading.model.model.Organization;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 组织机构 Mapper 接口
 * </p>
 *
 * @author liuguangfu
 * @since 2019-05-28
 */
public interface OrganizationMapper {
    Organization selectByPrimaryKey(String recId);

    Integer deleteByPrimaryKey(String recId);

    void insert(Organization model);

    void insertSelective(Organization model);

    Integer updateByPrimaryKeySelective(Organization model);

    Integer updateByPrimaryKey(Organization model);

    List<Organization> list(Map<String, Object> params);

    Integer count(Map<String, Object> params);
}
