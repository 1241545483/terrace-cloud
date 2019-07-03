package com.synapse.reading.respository;

import com.synapse.reading.mapper.IssueAnswerMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

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
    List<String> listUser(Map<String,String> map);

}
