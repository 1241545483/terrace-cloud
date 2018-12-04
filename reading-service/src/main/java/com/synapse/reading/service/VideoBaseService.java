package com.synapse.reading.service;

import com.synapse.reading.model.Video;

import java.util.Map;
import java.util.HashMap;

/**
 * <p>
 * 视频 服务实现类
 * </p>
 *
 * @author liuguangfu
 * @since 2018-12-01
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
        if (videoParam.getIntro() != null && !videoParam.getIntro().trim().equals("")) {
            params.put("intro", videoParam.getIntro());
        }
        if (videoParam.getQrCode() != null && !videoParam.getQrCode().trim().equals("")) {
            params.put("qrCode", videoParam.getQrCode());
        }
        if (videoParam.getCover() != null && !videoParam.getCover().trim().equals("")) {
            params.put("cover", videoParam.getCover());
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
        if (videoParam.getOrderNum() != null) {
            params.put("orderNum", videoParam.getOrderNum());
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