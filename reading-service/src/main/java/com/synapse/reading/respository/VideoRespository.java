package com.synapse.reading.respository;

import com.synapse.reading.mapper.VideoMapper;
import com.synapse.reading.model.Video;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

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

    List<Video> listSortByOrderNum(Map<String, Object> params);

    Integer changeBelongToIdAndBelongTo(@Param("belongToId") String belongToId);
}
