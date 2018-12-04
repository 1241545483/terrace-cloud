package com.synapse.reading.service;

import com.synapse.reading.model.MyLike;

import java.util.Map;
import java.util.HashMap;

/**
 * <p>
 * 我的点赞 服务实现类
 * </p>
 *
 * @author liuguangfu
 * @since 2018-12-01
 */
public class MyLikeBaseService {

	protected Map<String,Object> prepareParams(MyLike myLikeParam) {
        Map<String,Object> params = new HashMap<>();
        if (myLikeParam.getRecId() != null && !myLikeParam.getRecId().trim().equals("")) {
            params.put("recId", myLikeParam.getRecId());
        }
        if (myLikeParam.getLikeType() != null && !myLikeParam.getLikeType().trim().equals("")) {
            params.put("likeType", myLikeParam.getLikeType());
        }
        if (myLikeParam.getLikeId() != null && !myLikeParam.getLikeId().trim().equals("")) {
            params.put("likeId", myLikeParam.getLikeId());
        }
        if (myLikeParam.getCreateId() != null && !myLikeParam.getCreateId().trim().equals("")) {
            params.put("createId", myLikeParam.getCreateId());
        }
        if (myLikeParam.getCreateTime() != null && !myLikeParam.getCreateTime().trim().equals("")) {
            params.put("createTime", myLikeParam.getCreateTime());
        }
        return params;
    }

}