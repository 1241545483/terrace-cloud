package com.synapse.reading.service;

import com.synapse.reading.model.MyCollect;

import java.util.Map;
import java.util.HashMap;

/**
 * <p>
 * 我的收藏 服务实现类
 * </p>
 *
 * @author liuguangfu
 * @since 2018-12-01
 */
public class MyCollectBaseService {

	protected Map<String,Object> prepareParams(MyCollect myCollectParam) {
        Map<String,Object> params = new HashMap<>();
        if (myCollectParam.getRecId() != null && !myCollectParam.getRecId().trim().equals("")) {
            params.put("recId", myCollectParam.getRecId());
        }
        if (myCollectParam.getCollectType() != null && !myCollectParam.getCollectType().trim().equals("")) {
            params.put("collectType", myCollectParam.getCollectType());
        }
        if (myCollectParam.getCollectId() != null && !myCollectParam.getCollectId().trim().equals("")) {
            params.put("collectId", myCollectParam.getCollectId());
        }
        if (myCollectParam.getCreateId() != null && !myCollectParam.getCreateId().trim().equals("")) {
            params.put("createId", myCollectParam.getCreateId());
        }
        if (myCollectParam.getCreateTime() != null && !myCollectParam.getCreateTime().trim().equals("")) {
            params.put("createTime", myCollectParam.getCreateTime());
        }
        return params;
    }

}