package com.synapse.reading.mapper;

import com.synapse.reading.model.Issue;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 观看视频回答题目 Mapper 接口
 * </p>
 *
 * @author liuguangfu
 * @since 2019-01-09
 */
public interface IssueMapper {
    Issue selectByPrimaryKey(String recId);

    Integer deleteByPrimaryKey(String recId);

    void insert(Issue model);

    void insertSelective(Issue model);

    Integer updateByPrimaryKeySelective(Issue model);

    Integer updateByPrimaryKey(Issue model);

    List<Issue> list(Map<String, Object> params);

    Integer count(Map<String, Object> params);
}
