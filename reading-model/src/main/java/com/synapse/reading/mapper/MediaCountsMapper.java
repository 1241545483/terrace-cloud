package com.synapse.reading.mapper;

import com.synapse.reading.model.MediaCounts;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 统计播放量 Mapper 接口
 * </p>
 *
 * @author liuguangfu
 * @since 2018-12-26
 */
public interface MediaCountsMapper {
    MediaCounts selectByPrimaryKey(String recId);

    Integer deleteByPrimaryKey(String recId);

    void insert(MediaCounts model);

    void insertSelective(MediaCounts model);

    Integer updateByPrimaryKeySelective(MediaCounts model);

    Integer updateByPrimaryKey(MediaCounts model);

    List<MediaCounts> list(Map<String, Object> params);

    Integer count(Map<String, Object> params);
}
