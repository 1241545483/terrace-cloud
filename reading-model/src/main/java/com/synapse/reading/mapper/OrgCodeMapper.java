package com.synapse.reading.mapper;

import com.synapse.reading.model.OrgCode;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author liuguangfu
 * @since 2019-07-08
 */
public interface OrgCodeMapper {
    OrgCode selectByPrimaryKey(String recId);

    Integer deleteByPrimaryKey(String recId);

    void insert(OrgCode model);

    void insertSelective(OrgCode model);

    Integer updateByPrimaryKeySelective(OrgCode model);

    Integer updateByPrimaryKey(OrgCode model);

    List<OrgCode> list(Map<String, Object> params);

    Integer count(Map<String, Object> params);
}
