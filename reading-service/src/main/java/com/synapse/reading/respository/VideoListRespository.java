package com.synapse.reading.respository;

import com.synapse.reading.mapper.VideoListMapper;
import com.synapse.reading.model.VideoList;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Respository 接口
 * </p>
 *
 * @author wangyifan
 * @since 2018-11-20
 */
public interface VideoListRespository extends VideoListMapper {
    boolean updatePlayVideoNum(@Param("recId")String recId);
}
