package com.synapse.reading.respository;

import com.synapse.reading.dto.result.MyLikeResult;
import com.synapse.reading.mapper.MyLikeMapper;
import com.synapse.reading.model.MyLike;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 我的点赞 Respository 接口
 * </p>
 *
 * @author liuguangfu
 * @since 2018-12-01
 */
public interface MyLikeRespository extends MyLikeMapper {

    Integer deleteByCreateId(Map<String, Object> params);

    List<String> listAndUserName(Map<String, Object> params);

}
