package com.synapse.reading.service;

import com.synapse.reading.model.VideoList;

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
public class VideoListBaseService {

	protected Map<String,Object> prepareParams(VideoList videoListParam) {
        Map<String,Object> params = new HashMap<>();
        if (videoListParam.getRecId() != null && !videoListParam.getRecId().trim().equals("")) {
            params.put("recId", videoListParam.getRecId());
        }
        if (videoListParam.getName() != null && !videoListParam.getName().trim().equals("")) {
            params.put("name", videoListParam.getName());
        }
        if (videoListParam.getUrl() != null && !videoListParam.getUrl().trim().equals("")) {
            params.put("url", videoListParam.getUrl());
        }
        if (videoListParam.getBelongTo() != null && !videoListParam.getBelongTo().trim().equals("")) {
            params.put("belongTo", videoListParam.getBelongTo());
        }
        if (videoListParam.getBelongToId() != null && !videoListParam.getBelongToId().trim().equals("")) {
            params.put("belongToId", videoListParam.getBelongToId());
        }
        if (videoListParam.getPlayNum() != null) {
            params.put("playNum", videoListParam.getPlayNum());
        }
        if (videoListParam.getCreateId() != null && !videoListParam.getCreateId().trim().equals("")) {
            params.put("createId", videoListParam.getCreateId());
        }
        if (videoListParam.getCreateTime() != null && !videoListParam.getCreateTime().trim().equals("")) {
            params.put("createTime", videoListParam.getCreateTime());
        }
        if (videoListParam.getUpdateId() != null && !videoListParam.getUpdateId().trim().equals("")) {
            params.put("updateId", videoListParam.getUpdateId());
        }
        if (videoListParam.getUpdateTime() != null && !videoListParam.getUpdateTime().trim().equals("")) {
            params.put("updateTime", videoListParam.getUpdateTime());
        }
        return params;
    }

}