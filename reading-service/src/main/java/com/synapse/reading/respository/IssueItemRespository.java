package com.synapse.reading.respository;

import com.synapse.reading.mapper.IssueItemMapper;
import com.synapse.reading.model.IssueItem;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 题目选项 Respository 接口
 * </p>
 *
 * @author liuguangfu
 * @since 2019-01-09
 */
public interface IssueItemRespository extends IssueItemMapper {

    Integer deleteByIssueId(String issueId);

   List<IssueItem>  selectByPrimaryIssueId(String issueId);
}
