package com.synapse.reading.respository;

import com.synapse.reading.mapper.ShareImageMapper;
import com.synapse.reading.model.ShareImage;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 分享图片 Respository 接口
 * </p>
 *
 * @author liuguangfu
 * @since 2018-12-14
 */
public interface ShareImageRespository extends ShareImageMapper {

    ShareImage selectByShareTypeAndUserId(@Param("userId")String userId, @Param("shareType")String shareType);
    Integer deleteByUserId(@Param("userId") String userId, @Param("belongToId") String belongToId);

}
