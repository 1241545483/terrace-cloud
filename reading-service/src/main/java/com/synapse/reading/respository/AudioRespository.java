package com.synapse.reading.respository;

import com.synapse.reading.mapper.AudioMapper;
import org.apache.ibatis.annotations.Param;

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

}
