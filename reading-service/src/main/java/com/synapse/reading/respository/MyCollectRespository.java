package com.synapse.reading.respository;

import com.synapse.reading.mapper.MyCollectMapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 我的收藏 Respository 接口
 * </p>
 *
 * @author liuguangfu
 * @since 2018-12-01
 */
public interface MyCollectRespository extends MyCollectMapper {
    Integer deleteCollectByCreateId(@Param("recId") String recId, @Param("userId")String userId);
    Integer countIsCollect(@Param("recId") String recId, @Param("userId")String userId);
   // Integer addByCreateId(@Param("recId") String recId, @Param("userId")String userId);
   // Integer cancelByCreateId(@Param("recId") String recId, @Param("userId")String userId);
}
