package com.synapse.reading.mapper;

import com.synapse.reading.model.Expert;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 专家 Mapper 接口
 * </p>
 *
 * @author liuguangfu
 * @since 2019-04-09
 */
public interface ExpertMapper {
    Expert selectByPrimaryKey(String recId);

    Integer deleteByPrimaryKey(String recId);

    void insert(Expert model);

    void insertSelective(Expert model);

    Integer updateByPrimaryKeySelective(Expert model);

    Integer updateByPrimaryKey(Expert model);

    List<Expert> list(Map<String, Object> params);

    Integer count(Map<String, Object> params);
}
