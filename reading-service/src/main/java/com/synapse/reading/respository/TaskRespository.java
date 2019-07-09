package com.synapse.reading.respository;

import com.synapse.reading.dto.result.TaskResult;
import com.synapse.reading.mapper.TaskMapper;
import com.synapse.reading.model.Task;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 任务 Respository 接口
 * </p>
 *
 * @author liuguangfu
 * @since 2019-06-11
 */
public interface TaskRespository extends TaskMapper {
    List<TaskResult> listByTaskOrTeacher(Map<String, Object> params);

    List<TaskResult> listByUser(Map<String, Object> params);

    Integer countListByUser(String userId);

    Integer countListByTaskOrTeacher(Map<String, Object> params);

    TaskResult selectTask(String recId);

    List<Task> listByClass(Map<String, Object> params);

}
