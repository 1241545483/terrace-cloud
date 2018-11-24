package com.synapse.reading.service;

import com.synapse.reading.model.Video;

import java.util.Map;
import java.util.HashMap;

/**
 * <p>
 * 视频 服务实现类
 * </p>
 *
 * @author wangyifan
 * @since 2018-11-24
 */
public class VideoBaseService {

	protected Map<String,Object> prepareParams(Video videoParam) {
        Map<String,Object> params = new HashMap<>();
        if (videoParam.getRecId() != null && !videoParam.getRecId().trim().equals("")) {
            params.put("recId", videoParam.getRecId());
        }
        if (videoParam.getName() != null && !videoParam.getName().trim().equals("")) {
            params.put("name", videoParam.getName());
        }
        if (videoParam.getUrl() != null && !videoParam.getUrl().trim().equals("")) {
            params.put("url", videoParam.getUrl());
        }
        if (videoParam.getBelongTo() != null && !videoParam.getBelongTo().trim().equals("")) {
            params.put("belongTo", videoParam.getBelongTo());
        }
        if (videoParam.getBelongToId() != null && !videoParam.getBelongToId().trim().equals("")) {
            params.put("belongToId", videoParam.getBelongToId());
        }
        if (videoParam.getPlayNum() != null) {
            params.put("playNum", videoParam.getPlayNum());
        }
        if (videoParam.getCreateId() != null && !videoParam.getCreateId().trim().equals("")) {
            params.put("createId", videoParam.getCreateId());
        }
        if (videoParam.getCreateTime() != null && !videoParam.getCreateTime().trim().equals("")) {
            params.put("createTime", videoParam.getCreateTime());
        }
        if (videoParam.getUpdateId() != null && !videoParam.getUpdateId().trim().equals("")) {
            params.put("updateId", videoParam.getUpdateId());
        }
        if (videoParam.getUpdateTime() != null && !videoParam.getUpdateTime().trim().equals("")) {
            params.put("updateTime", videoParam.getUpdateTime());
        }
        return params;
    }

}