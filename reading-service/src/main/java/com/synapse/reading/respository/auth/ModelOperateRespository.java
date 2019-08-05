package com.synapse.reading.respository.auth;

import com.synapse.reading.mapper.auth.ModelOperateMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 系统模块和code的关系 Respository 接口
 * </p>
 *
 * @author liuguangfu
 * @since 2019-05-28
 */
public interface ModelOperateRespository extends ModelOperateMapper {

    /**
     * 列出用户的操作指令
     *
     * @param userId
     * @return
     */
    List<String> listUserOperate(@Param("userId") String userId);
}
