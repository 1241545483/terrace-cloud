package com.synapse.reading.mapper;

import com.synapse.reading.model.MySignin;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 我的签到 Mapper 接口
 * </p>
 *
 * @author liuguangfu
 * @since 2018-12-27
 */
public interface MySigninMapper {
    MySignin selectByPrimaryKey(String recId);

    Integer deleteByPrimaryKey(String recId);

    void insert(MySignin model);

    void insertSelective(MySignin model);

    Integer updateByPrimaryKeySelective(MySignin model);

    Integer updateByPrimaryKey(MySignin model);

    List<MySignin> list(Map<String, Object> params);

    Integer count(Map<String, Object> params);
}
