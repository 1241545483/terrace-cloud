package com.synapse.reading.respository.respository;

import com.synapse.reading.mapper.mapper.BindMapper;
import com.synapse.reading.model.model.Bind;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 储存用户绑定关系表，用户和对应的openId，unionId等 Respository 接口
 * </p>
 *
 * @author liuguangfu
 * @since 2019-05-28
 */
public interface BindRespository extends BindMapper {
    List<Bind> selectByUserIdAndOpenId(@Param("openId") String openId, @Param("userId") String userId);
    List<Bind> selectByOpenId(@Param("openId") String openId);
    List<Bind> selectByUnionId(@Param("unionId") String unionId);
    List<Bind> selectByUserId(@Param("userId") String userId);
}
