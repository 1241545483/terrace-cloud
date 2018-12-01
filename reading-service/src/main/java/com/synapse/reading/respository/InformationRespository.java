package com.synapse.reading.respository;

import com.synapse.reading.mapper.InformationMapper;
import com.synapse.reading.model.Information;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 资讯模块 Respository 接口
 * </p>
 *
 * @author liuguangfu
 * @since 2018-12-01
 */
public interface InformationRespository extends InformationMapper {

    Integer updateReadNum(@Param("recId") String recId);

    Integer updateLikeAddNum(@Param("recId") String recId);

    Integer updateLikeReduceNum(@Param("recId") String recId);
}
