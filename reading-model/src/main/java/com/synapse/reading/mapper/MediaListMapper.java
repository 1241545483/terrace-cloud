package com.synapse.reading.mapper;

import com.synapse.reading.model.MediaList;

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
public interface MediaListMapper {
    MediaList selectByPrimaryKey(String recId);

    Integer deleteByPrimaryKey(String recId);

    void insert(MediaList model);

    void insertSelective(MediaList model);

    Integer updateByPrimaryKeySelective(MediaList model);

    Integer updateByPrimaryKey(MediaList model);

    List<MediaList> list(Map<String, Object> params);

    Integer count(Map<String, Object> params);
}
