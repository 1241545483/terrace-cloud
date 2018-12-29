package com.synapse.reading.mapper;

import com.synapse.reading.model.Discuss;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 评论表 Mapper 接口
 * </p>
 *
 * @author liuguangfu
 * @since 2018-12-29
 */
public interface DiscussMapper {
    Discuss selectByPrimaryKey(String recId);

    Integer deleteByPrimaryKey(String recId);

    void insert(Discuss model);

    void insertSelective(Discuss model);

    Integer updateByPrimaryKeySelective(Discuss model);

    Integer updateByPrimaryKey(Discuss model);

    List<Discuss> list(Map<String, Object> params);

    Integer count(Map<String, Object> params);
}
