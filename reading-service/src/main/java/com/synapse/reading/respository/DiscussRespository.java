package com.synapse.reading.respository;

import com.synapse.reading.dto.result.DiscussResult;
import com.synapse.reading.mapper.DiscussMapper;
import com.synapse.reading.model.Discuss;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 评论表 Respository 接口
 * </p>
 *
 * @author liuguangfu
 * @since 2018-12-01
 */
public interface DiscussRespository extends DiscussMapper {


    Integer updateDiscussLikeAddNum(@Param("recId") String recId);

    Integer updateDiscussLikeReduceNum(@Param("recId") String recId);

    List<DiscussResult> listByCommentType(Map<String, Object> params);

}
