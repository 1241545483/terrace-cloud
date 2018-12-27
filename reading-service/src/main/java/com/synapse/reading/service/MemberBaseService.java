package com.synapse.reading.service;

import com.synapse.reading.model.Member;

import java.util.Map;
import java.util.HashMap;

/**
 * <p>
 * 用户信息 服务实现类
 * </p>
 *
 * @author liuguangfu
 * @since 2018-12-27
 */
public class MemberBaseService {

	protected Map<String,Object> prepareParams(Member memberParam) {
        Map<String,Object> params = new HashMap<>();
        if (memberParam.getUserId() != null && !memberParam.getUserId().trim().equals("")) {
            params.put("userId", memberParam.getUserId());
        }
        if (memberParam.getPoint() != null) {
            params.put("point", memberParam.getPoint());
        }
        if (memberParam.getCreateId() != null && !memberParam.getCreateId().trim().equals("")) {
            params.put("createId", memberParam.getCreateId());
        }
        if (memberParam.getCreateTime() != null && !memberParam.getCreateTime().trim().equals("")) {
            params.put("createTime", memberParam.getCreateTime());
        }
        if (memberParam.getUpdateId() != null && !memberParam.getUpdateId().trim().equals("")) {
            params.put("updateId", memberParam.getUpdateId());
        }
        if (memberParam.getUpdateTime() != null && !memberParam.getUpdateTime().trim().equals("")) {
            params.put("updateTime", memberParam.getUpdateTime());
        }
        return params;
    }

}