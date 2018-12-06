package com.synapse.reading.mapper;

import com.synapse.reading.model.MyCollect;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 我的收藏 Mapper 接口
 * </p>
 *
 * @author liuguangfu
 * @since 2018-12-01
 */
public interface MyCollectMapper {
        MyCollect selectByPrimaryKey(String recId);

    Integer deleteByPrimaryKey(String recId);

    void insert(MyCollect model);

    void insertSelective(MyCollect model);

    Integer updateByPrimaryKeySelective(MyCollect model);

    Integer updateByPrimaryKey(MyCollect model);

    List<MyCollect> list(Map<String, Object> params);

    Integer count(Map<String, Object> params);
}
