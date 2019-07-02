package com.synapse.reading.mapper;

import com.synapse.reading.model.Member;
import feign.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 用户信息 Mapper 接口
 * </p>
 *
 * @author liuguangfu
 * @since 2019-05-09
 */
public interface MemberMapper {
    Member selectByPrimaryKey(String recId);

    Integer deleteByPrimaryKey(String recId);

    void insert(Member model);

    void insertSelective(Member model);

    Integer updateByPrimaryKeySelective(Member model);

    Integer updateByPrimaryKey(Member model);

    List<Member> list(Map<String, Object> params);

    Integer count(Map<String, Object> params);
}
