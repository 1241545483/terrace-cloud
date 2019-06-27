package com.synapse.reading.respository;

import com.synapse.reading.mapper.ClassStudentMappingMapper;
import com.synapse.reading.model.ClassStudentMapping;

/**
 * <p>
 * 班级和学生的关系 Respository 接口
 * </p>
 *
 * @author liuguangfu
 * @since 2019-05-28
 */
public interface ClassStudentMappingRespository extends ClassStudentMappingMapper {

    ClassStudentMapping selectByClassId(ClassStudentMapping model);

}
