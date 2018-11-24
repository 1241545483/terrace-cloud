package com.synapse.reading.mapper;

import com.synapse.reading.model.Audio;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 音频 Mapper 接口
 * </p>
 *
 * @author wangyifan
 * @since 2018-11-24
 */
public interface AudioMapper {
    Audio selectByPrimaryKey(String recId);

    Integer deleteByPrimaryKey(String recId);

    void insert(Audio model);

    void insertSelective(Audio model);

    Integer updateByPrimaryKeySelective(Audio model);

    Integer updateByPrimaryKey(Audio model);

    List<Audio> list(Map<String, Object> params);

    Integer count(Map<String, Object> params);
}
