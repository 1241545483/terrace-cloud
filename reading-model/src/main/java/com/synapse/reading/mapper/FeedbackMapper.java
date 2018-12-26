package com.synapse.reading.mapper;

import com.synapse.reading.model.Feedback;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 意见反馈 Mapper 接口
 * </p>
 *
 * @author liuguangfu
 * @since 2018-12-26
 */
public interface FeedbackMapper {
    Feedback selectByPrimaryKey(String recId);

    Integer deleteByPrimaryKey(String recId);

    void insert(Feedback model);

    void insertSelective(Feedback model);

    Integer updateByPrimaryKeySelective(Feedback model);

    Integer updateByPrimaryKey(Feedback model);

    List<Feedback> list(Map<String, Object> params);

    Integer count(Map<String, Object> params);
}
