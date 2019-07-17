package com.synapse.reading.service.auth;

import com.synapse.reading.model.auth.Bind;

import java.util.Map;
import java.util.HashMap;

/**
 * <p>
 * 储存用户绑定关系表，用户和对应的openId，unionId等 服务实现类
 * </p>
 *
 * @author liuguangfu
 * @since 2019-05-28
 */
public class BindBaseService {

	protected Map<String,Object> prepareParams(Bind bindParam) {
        Map<String,Object> params = new HashMap<>();
        if (bindParam.getRecId() != null && !bindParam.getRecId().trim().equals("")) {
            params.put("recId", bindParam.getRecId());
        }
        if (bindParam.getUserId() != null && !bindParam.getUserId().trim().equals("")) {
            params.put("userId", bindParam.getUserId());
        }
        if (bindParam.getPrivide() != null && !bindParam.getPrivide().trim().equals("")) {
            params.put("privide", bindParam.getPrivide());
        }
        if (bindParam.getOpenId() != null && !bindParam.getOpenId().trim().equals("")) {
            params.put("openId", bindParam.getOpenId());
        }
        if (bindParam.getUnionId() != null && !bindParam.getUnionId().trim().equals("")) {
            params.put("unionId", bindParam.getUnionId());
        }
        if (bindParam.getCreateId() != null && !bindParam.getCreateId().trim().equals("")) {
            params.put("createId", bindParam.getCreateId());
        }
        if (bindParam.getCreateTime() != null && !bindParam.getCreateTime().trim().equals("")) {
            params.put("createTime", bindParam.getCreateTime());
        }
        if (bindParam.getUpdateId() != null && !bindParam.getUpdateId().trim().equals("")) {
            params.put("updateId", bindParam.getUpdateId());
        }
        if (bindParam.getUpdateTime() != null && !bindParam.getUpdateTime().trim().equals("")) {
            params.put("updateTime", bindParam.getUpdateTime());
        }
        return params;
    }

}
