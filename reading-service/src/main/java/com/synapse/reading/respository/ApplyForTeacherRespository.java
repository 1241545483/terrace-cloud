package com.synapse.reading.respository;

import com.synapse.reading.dto.result.ApplyForTeacherResult;
import com.synapse.reading.mapper.ApplyForTeacherMapper;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 申请成为老师 Respository 接口
 * </p>
 *
 * @author liuguangfu
 * @since 2019-06-19
 */
public interface ApplyForTeacherRespository extends ApplyForTeacherMapper {

    List<ApplyForTeacherResult> listByUser(Map<String, Object> params);

}
