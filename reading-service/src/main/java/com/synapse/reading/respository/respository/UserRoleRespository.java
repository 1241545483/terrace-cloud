package com.synapse.reading.respository.respository;

import com.synapse.reading.mapper.mapper.UserRoleMapper;
import com.synapse.reading.model.model.UserRole;

/**
 * <p>
 * 阅读这边目前就只有老师，学生 Respository 接口
 * </p>
 *
 * @author liuguangfu
 * @since 2019-05-30
 */
public interface UserRoleRespository extends UserRoleMapper {

    String listUserBizRoles(String userId);

}
