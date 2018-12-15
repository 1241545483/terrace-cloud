package com.synapse.reading.mapper;

import com.synapse.reading.model.ShareImage;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 分享图片 Mapper 接口
 * </p>
 *
 * @author liuguangfu
 * @since 2018-12-14
 */
public interface ShareImageMapper {
    ShareImage selectByPrimaryKey(String recId);

    Integer deleteByPrimaryKey(String recId);

    void insert(ShareImage model);

    void insertSelective(ShareImage model);

    Integer updateByPrimaryKeySelective(ShareImage model);

    Integer updateByPrimaryKey(ShareImage model);

    List<ShareImage> list(Map<String, Object> params);

    Integer count(Map<String, Object> params);
}
