package com.synapse.reading.mapper;

import com.synapse.reading.model.Album;

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
public interface AlbumMapper {
    Album selectByPrimaryKey(String recId);

    Integer deleteByPrimaryKey(String recId);

    void insert(Album model);

    void insertSelective(Album model);

    Integer updateByPrimaryKeySelective(Album model);

    Integer updateByPrimaryKey(Album model);

    List<Album> list(Map<String, Object> params);

    Integer count(Map<String, Object> params);
}
