package com.synapse.reading.respository;

import com.synapse.reading.mapper.TopicMapper;
import com.synapse.reading.model.Audio;

import java.util.List;

/**
 * <p>
 * 主题，关联专辑 Respository 接口
 * </p>
 *
 * @author liuguangfu
 * @since 2019-01-28
 */
public interface TopicRespository extends TopicMapper {

    List<Audio> getAllAudioList(String recId);

}
