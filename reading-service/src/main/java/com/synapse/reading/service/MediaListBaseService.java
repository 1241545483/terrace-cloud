package com.synapse.reading.service;

import com.synapse.reading.model.MediaList;

import java.util.Map;
import java.util.HashMap;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wangyifan
 * @since 2018-11-20
 */
public class MediaListBaseService {

	protected Map<String,Object> prepareParams(MediaList mediaListParam) {
        Map<String,Object> params = new HashMap<>();
        if (mediaListParam.getRecId() != null && !mediaListParam.getRecId().trim().equals("")) {
            params.put("recId", mediaListParam.getRecId());
        }
        if (mediaListParam.getName() != null && !mediaListParam.getName().trim().equals("")) {
            params.put("name", mediaListParam.getName());
        }
        if (mediaListParam.getUrl() != null && !mediaListParam.getUrl().trim().equals("")) {
            params.put("url", mediaListParam.getUrl());
        }
        if (mediaListParam.getBelongTo() != null && !mediaListParam.getBelongTo().trim().equals("")) {
            params.put("belongTo", mediaListParam.getBelongTo());
        }
        if (mediaListParam.getBelongToId() != null && !mediaListParam.getBelongToId().trim().equals("")) {
            params.put("belongToId", mediaListParam.getBelongToId());
        }
        if (mediaListParam.getPlayNum() != null) {
            params.put("playNum", mediaListParam.getPlayNum());
        }
        if (mediaListParam.getCreateId() != null && !mediaListParam.getCreateId().trim().equals("")) {
            params.put("createId", mediaListParam.getCreateId());
        }
        if (mediaListParam.getCreateTime() != null && !mediaListParam.getCreateTime().trim().equals("")) {
            params.put("createTime", mediaListParam.getCreateTime());
        }
        if (mediaListParam.getUpdateId() != null && !mediaListParam.getUpdateId().trim().equals("")) {
            params.put("updateId", mediaListParam.getUpdateId());
        }
        if (mediaListParam.getUpdateTime() != null && !mediaListParam.getUpdateTime().trim().equals("")) {
            params.put("updateTime", mediaListParam.getUpdateTime());
        }
        return params;
    }

}