package com.synapse.reading.respository;

import com.synapse.reading.mapper.MemberMapper;
import com.synapse.reading.model.Member;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 用户信息 Respository 接口
 * </p>
 *
 * @author liuguangfu
 * @since 2018-12-06
 */
public interface MemberRespository extends MemberMapper {


    Integer addPoint(Member member);

    public List<Member> selectByIdCard(@Param("idCard") String idCard);

    Member selectByUserId(String userId);
}
