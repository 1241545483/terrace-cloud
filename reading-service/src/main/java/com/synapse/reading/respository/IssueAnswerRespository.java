package com.synapse.reading.respository;

import com.synapse.reading.mapper.IssueAnswerMapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 问题回答 Respository 接口
 * </p>
 *
 * @author liuguangfu
 * @since 2019-01-09
 */
public interface IssueAnswerRespository extends IssueAnswerMapper {
    Integer deleteByCreateId(@Param("createId") String createId, @Param("belongToId") String belongToId, @Param("belongTo") String belongTo);
}
