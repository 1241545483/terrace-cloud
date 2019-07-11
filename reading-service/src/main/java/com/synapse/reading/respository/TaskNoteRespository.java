package com.synapse.reading.respository;

import com.synapse.reading.dto.result.TaskNoteResult;
import com.synapse.reading.mapper.TaskNoteMapper;
import com.synapse.reading.model.TaskNote;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 任务笔记 Respository 接口
 * </p>
 *
 * @author liuguangfu
 * @since 2019-06-13
 */
public interface TaskNoteRespository extends TaskNoteMapper {

    List<TaskNoteResult> listByUser(Map<String, Object> params);

    TaskNoteResult findByUser(String recId);

    List<Map<String,String>> countFinishNum (Map<String, Object> params);

}
