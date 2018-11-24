package com.synapse.reading.respository;

import com.synapse.reading.mapper.VideoMapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 视频 Respository 接口
 * </p>
 *
 * @author wangyifan
 * @since 2018-11-24
 */
public interface VideoRespository extends VideoMapper {

    /**
     * 视频观看量加1
     * @param recId
     * @return
     */
    Integer increasePlayNum(@Param("recId") String recId);
}
