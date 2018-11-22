package com.synapse.reading.respository;

import com.synapse.reading.mapper.MediaListMapper;
import com.synapse.reading.model.MediaList;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Respository 接口
 * </p>
 *
 * @author wangyifan
 * @since 2018-11-20
 */
public interface MediaListRespository extends MediaListMapper {

    boolean updatePlayMediaNum(@Param("recId") String recId);

}
