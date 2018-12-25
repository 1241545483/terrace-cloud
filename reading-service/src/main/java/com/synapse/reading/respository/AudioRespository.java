package com.synapse.reading.respository;

import com.synapse.reading.dto.result.AudioResult;
import com.synapse.reading.dto.result.InformationResult;
import com.synapse.reading.mapper.AudioMapper;
import com.synapse.reading.model.Audio;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 音频 Respository 接口
 * </p>
 *
 * @author wangyifan
 * @since 2018-11-24
 */
public interface AudioRespository extends AudioMapper {

    /**
     * 音频观看量加1
     *
     * @param recId
     * @return
     */
    Integer increasePlayNum(@Param("recId") String recId);
    /**
     * 音频观看量加1
     *
     * @param recId
     * @return
     */
    Integer increaseFinishNum(@Param("recId") String recId);

    List<Audio> listSortByOrderNum(Map<String, Object> params);

    List<AudioResult> listAudioAddIsCollect(Map<String, Object> params);

    List<AudioResult> listMyCollectByAudio(@Param("userId") String userId);

    AudioResult selectIsCollect(@Param("userId") String userId,@Param("recId") String recId);
}
