package com.synapse.reading.respository;

import com.synapse.reading.dto.result.ClassInfoResult;
import com.synapse.reading.mapper.ClassInfoMapper;
import com.synapse.reading.model.ClassInfo;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  Respository 接口
 * </p>
 *
 * @author liuguangfu
 * @since 2019-05-28
 */
public interface ClassInfoRespository extends ClassInfoMapper {

    List<Map<String,String>> countClassNum (Map<String, Object> params);
    Integer countListByClass(Map<String, Object> params);
    Integer countByTeacherCreate(String userId);
    Integer countByStudentJoin(String userId);
    List<ClassInfoResult> listByTeacherCreate(Map<String, Object> params);
    List<ClassInfoResult> listByClass(Map<String, Object> params);
    List<ClassInfoResult> listByStudentJoin(Map<String, Object> params);
    ClassInfoResult getByClassCode(String classCode);

}
