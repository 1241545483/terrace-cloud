package com.synapse.reading.respository.auth;

import com.synapse.reading.mapper.auth.UserRoleMapper;

import java.util.List;

/**
 * <p>
 * 阅读这边目前就只有老师，学生 Respository 接口
 * </p>
 *
 * @author liuguangfu
 * @since 2019-05-30
 */
public interface UserRoleRespository extends UserRoleMapper {
    String vipByUserId(String userId);
    List<String> listUserBizRoles(String userId);
     Integer deleteVipByUserId(String userId);
}
