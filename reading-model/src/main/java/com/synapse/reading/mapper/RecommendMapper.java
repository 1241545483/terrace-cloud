package com.synapse.reading.mapper;

import com.synapse.reading.model.Recommend;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 推荐 Mapper 接口
 * </p>
 *
 * @author liuguangfu
 * @since 2019-01-22
 */
public interface RecommendMapper {
    Recommend selectByPrimaryKey(String recId);

    Integer deleteByPrimaryKey(String recId);

    void insert(Recommend model);

    void insertSelective(Recommend model);

    Integer updateByPrimaryKeySelective(Recommend model);

    Integer updateByPrimaryKey(Recommend model);

    List<Recommend> list(Map<String, Object> params);

    Integer count(Map<String, Object> params);
}
