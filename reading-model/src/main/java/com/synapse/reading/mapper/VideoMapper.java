package com.synapse.reading.mapper;

import com.synapse.reading.model.Video;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 视频 Mapper 接口
 * </p>
 *
 * @author liuguangfu
 * @since 2018-11-29
 */
public interface VideoMapper {
    Video selectByPrimaryKey(String recId);

    Integer deleteByPrimaryKey(String recId);

    void insert(Video model);

    void insertSelective(Video model);

    Integer updateByPrimaryKeySelective(Video model);

    Integer updateByPrimaryKey(Video model);

    List<Video> list(Map<String, Object> params);

    Integer count(Map<String, Object> params);
}
