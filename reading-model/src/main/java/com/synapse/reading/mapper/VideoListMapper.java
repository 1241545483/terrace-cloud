package com.synapse.reading.mapper;

import com.synapse.reading.model.VideoList;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author wangyifan
 * @since 2018-11-20
 */
public interface VideoListMapper {
    VideoList selectByPrimaryKey(String recId);

    Integer deleteByPrimaryKey(String recId);

    void insert(VideoList model);

    void insertSelective(VideoList model);

    Integer updateByPrimaryKeySelective(VideoList model);

    Integer updateByPrimaryKey(VideoList model);

    List<VideoList> list(Map<String, Object> params);

    Integer count(Map<String, Object> params);
}
