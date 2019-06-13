package com.synapse.reading.respository;

import com.synapse.reading.mapper.TaskStudyMappingMapper;
import com.synapse.reading.model.TaskStudyMapping;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 任务和学习课程的关系 Respository 接口
 * </p>
 *
 * @author liuguangfu
 * @since 2019-06-11
 */
public interface TaskStudyMappingRespository extends TaskStudyMappingMapper {

    Integer deleteByStudyId(TaskStudyMapping model);

    List<String> getStudyIds(@Param("taskId") String taskId,@Param("type") String type);

    Integer getNum(String userId);
}
