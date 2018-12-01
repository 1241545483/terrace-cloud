package com.synapse.reading.respository;

import com.synapse.reading.mapper.AlbumMapper;
import com.synapse.reading.model.Album;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

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
    List<Album> listSortByOrderNum(Map<String, Object> params);

}
