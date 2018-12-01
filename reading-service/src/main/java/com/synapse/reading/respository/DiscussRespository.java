package com.synapse.reading.respository;

import com.synapse.reading.mapper.DiscussMapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 评论表 Respository 接口
 * </p>
 *
 * @author liuguangfu
 * @since 2018-12-01
 */
public interface DiscussRespository extends DiscussMapper {

    Integer updateDiscussLikeAddNum(@Param("recId") String recId);

    Integer updateDiscussLikeReduceNum(@Param("recId") String recId);



}
