package com.synapse.reading.respository;

import com.synapse.reading.mapper.AlbumMapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * Respository 接口
 * </p>
 *
 * @author wangyifan
 * @since 2018-11-20
 */
public interface AlbumRespository extends AlbumMapper {
    Integer updatePlayVisitNum(@Param("recId") String recId);
}
