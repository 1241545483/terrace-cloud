package com.synapse.reading.respository;

import com.synapse.reading.mapper.MySigninMapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 我的签到 Respository 接口
 * </p>
 *
 * @author liuguangfu
 * @since 2018-12-06
 */
public interface MySigninRespository extends MySigninMapper {

    Integer countByCreateTime (@Param("createId") String createId,@Param("createTime") String createTime);
}
