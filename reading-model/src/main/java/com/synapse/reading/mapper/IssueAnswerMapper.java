package com.synapse.reading.mapper;

import com.synapse.reading.model.IssueAnswer;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 问题回答 Mapper 接口
 * </p>
 *
 * @author liuguangfu
 * @since 2019-01-09
 */
public interface IssueAnswerMapper {
    IssueAnswer selectByPrimaryKey(String recId);

    Integer deleteByPrimaryKey(String recId);

    void insert(IssueAnswer model);

    void insertSelective(IssueAnswer model);

    Integer updateByPrimaryKeySelective(IssueAnswer model);

    Integer updateByPrimaryKey(IssueAnswer model);

    List<IssueAnswer> list(Map<String, Object> params);

    Integer count(Map<String, Object> params);
}
