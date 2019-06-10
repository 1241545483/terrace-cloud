package com.synapse.reading.respository;

import com.synapse.reading.mapper.ClassCodeMapper;
import com.synapse.reading.model.ClassCode;

/**
 * <p>
 *  Respository 接口
 * </p>
 *
 * @author liuguangfu
 * @since 2019-05-28
 */
public interface ClassCodeRespository extends ClassCodeMapper {
    void insertAndGet(ClassCode model);
}
