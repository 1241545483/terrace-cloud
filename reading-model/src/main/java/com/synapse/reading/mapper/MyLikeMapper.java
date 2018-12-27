package com.synapse.reading.mapper;

import com.synapse.reading.model.MyLike;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 我的点赞 Mapper 接口
 * </p>
 *
 * @author liuguangfu
 * @since 2018-12-27
 */
public interface MyLikeMapper {
    MyLike selectByPrimaryKey(String recId);

    Integer deleteByPrimaryKey(String recId);

    void insert(MyLike model);

    void insertSelective(MyLike model);

    Integer updateByPrimaryKeySelective(MyLike model);

    Integer updateByPrimaryKey(MyLike model);

    List<MyLike> list(Map<String, Object> params);

    Integer count(Map<String, Object> params);
}
