package com.synapse.reading.respository;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.synapse.reading.mapper.ExpertMapper;
import com.synapse.reading.model.Expert;

/**
 * <p>
 * 专家 Respository 接口
 * </p>
 *
 * @author liuguangfu
 * @since 2019-04-09
 */
public interface ExpertRespository extends ExpertMapper {

    Integer countListbyexpert();
    List<Expert> listMyCollectByExpert(@Param("expertId") String expertId);
}
