package com.synapse.reading.respository;

import com.synapse.reading.mapper.OrgCodeMapper;
import com.synapse.reading.model.OrgCode;

/**
 * <p>
 *  Respository 接口
 * </p>
 *
 * @author liuguangfu
 * @since 2019-07-08
 */
public interface OrgCodeRespository extends OrgCodeMapper {
    void insertAndGet(OrgCode model);
}
