package com.synapse.reading.respository;

import com.synapse.reading.mapper.ExpertMapper;

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
}
