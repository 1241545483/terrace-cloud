package com.synapse.reading.respository;

import com.synapse.reading.mapper.MyLikeMapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 我的点赞 Respository 接口
 * </p>
 *
 * @author liuguangfu
 * @since 2018-12-01
 */
public interface MyLikeRespository extends MyLikeMapper {

    Integer deleteByCreateId( String createId);

}
