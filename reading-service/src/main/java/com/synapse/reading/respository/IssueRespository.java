package com.synapse.reading.respository;

import com.synapse.reading.dto.result.IssueResult;
import com.synapse.reading.mapper.IssueMapper;
import com.synapse.reading.model.Issue;
import com.synapse.reading.model.IssueItem;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 观看视频回答题目 Respository 接口
 * </p>
 *
 * @author liuguangfu
 * @since 2019-01-09
 */
public interface IssueRespository extends IssueMapper {

List<Map<String,String>>  selectBybelongToId(@Param("recId") String recId, @Param("belongTo") String  belongTo);

Double  selectScoreByUserId(@Param("userId") String userId,@Param("belongToId") String belongToId,@Param("belongTo") String belongTo);

Integer  selectCountByUserId(@Param("userId") String userId,@Param("belongToId") String belongToId,@Param("belongTo") String belongTo);

}
