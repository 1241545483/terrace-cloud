package com.synapse.reading.respository;

import com.synapse.reading.mapper.UserTaskRecordMapper;
import com.synapse.reading.model.UserTaskRecord;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 任务接受记录 Respository 接口
 * </p>
 *
 * @author liuguangfu
 * @since 2019-06-12
 */
public interface UserTaskRecordRespository extends UserTaskRecordMapper {

    UserTaskRecord selectByTaskId(@Param("taskId") String taskId, @Param("userId")String userId);

}
