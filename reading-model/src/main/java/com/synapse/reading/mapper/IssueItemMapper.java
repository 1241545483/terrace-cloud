package com.synapse.reading.mapper;

import com.synapse.reading.model.IssueItem;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 题目选项 Mapper 接口
 * </p>
 *
 * @author liuguangfu
 * @since 2019-01-09
 */
public interface IssueItemMapper {
    IssueItem selectByPrimaryKey(String recId);

    Integer deleteByPrimaryKey(String recId);

    void insert(IssueItem model);

    void insertSelective(IssueItem model);

    Integer updateByPrimaryKeySelective(IssueItem model);

    Integer updateByPrimaryKey(IssueItem model);

    List<IssueItem> list(Map<String, Object> params);

    Integer count(Map<String, Object> params);
}
