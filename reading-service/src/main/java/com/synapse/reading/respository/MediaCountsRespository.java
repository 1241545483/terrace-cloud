package com.synapse.reading.respository;

import com.synapse.reading.mapper.MediaCountsMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 统计播放量 Respository 接口
 * </p>
 *
 * @author liuguangfu
 * @since 2018-12-25
 */
public interface MediaCountsRespository extends MediaCountsMapper {


    Integer updateByCreateId(@Param("mediaId") String mediaId,@Param("createId")String createId,@Param("createTime")String createTime);
    List<Map<String,String>> clickCountByTime(@Param("startTime")String startTime, @Param("endTime") String endTime, @Param("mediaId") String mediaId);
    List<Map<String,String>> finishCountByTime(@Param("startTime")String startTime, @Param("endTime") String endTime, @Param("mediaId") String mediaId);
    List<Map<String,String>> finishRateByTime(@Param("startTime")String startTime, @Param("endTime") String endTime, @Param("mediaId") String mediaId);

}
