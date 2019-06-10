package com.synapse.reading.mapper.mapper;

import com.synapse.reading.model.model.WxLoginState;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author liuguangfu
 * @since 2019-05-28
 */
public interface WxLoginStateMapper {
    WxLoginState selectByPrimaryKey(String recId);

    Integer deleteByPrimaryKey(String recId);

    void insert(WxLoginState model);

    void insertSelective(WxLoginState model);

    Integer updateByPrimaryKeySelective(WxLoginState model);

    Integer updateByPrimaryKey(WxLoginState model);

    List<WxLoginState> list(Map<String, Object> params);

    Integer count(Map<String, Object> params);
}
