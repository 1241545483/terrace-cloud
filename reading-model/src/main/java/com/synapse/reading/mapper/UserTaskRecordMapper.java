package com.synapse.reading.mapper;

import com.synapse.reading.model.UserTaskRecord;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 任务接受记录 Mapper 接口
 * </p>
 *
 * @author liuguangfu
 * @since 2019-06-12
 */
public interface UserTaskRecordMapper {
    UserTaskRecord selectByPrimaryKey(String recId);

    Integer deleteByPrimaryKey(String recId);

    void insert(UserTaskRecord model);

    void insertSelective(UserTaskRecord model);

    Integer updateByPrimaryKeySelective(UserTaskRecord model);

    Integer updateByPrimaryKey(UserTaskRecord model);

    List<UserTaskRecord> list(Map<String, Object> params);

    Integer count(Map<String, Object> params);
}
