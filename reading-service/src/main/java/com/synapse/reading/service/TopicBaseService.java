package com.synapse.reading.service;

import com.synapse.reading.model.Topic;

import java.util.Map;
import java.util.HashMap;

/**
 * <p>
 * 主题，关联专辑 服务实现类
 * </p>
 *
 * @author liuguangfu
 * @since 2019-01-29
 */
public class TopicBaseService {

	protected Map<String,Object> prepareParams(Topic topicParam) {
        Map<String,Object> params = new HashMap<>();
        if (topicParam.getRecId() != null && !topicParam.getRecId().trim().equals("")) {
            params.put("recId", topicParam.getRecId());
        }
        if (topicParam.getName() != null && !topicParam.getName().trim().equals("")) {
            params.put("name", topicParam.getName());
        }
        if (topicParam.getCover() != null && !topicParam.getCover().trim().equals("")) {
            params.put("cover", topicParam.getCover());
        }
        if (topicParam.getPcCover() != null && !topicParam.getPcCover().trim().equals("")) {
            params.put("pcCover", topicParam.getPcCover());
        }
        if (topicParam.getBanner() != null && !topicParam.getBanner().trim().equals("")) {
            params.put("banner", topicParam.getBanner());
        }
        if (topicParam.getPcBanner() != null && !topicParam.getPcBanner().trim().equals("")) {
            params.put("pcBanner", topicParam.getPcBanner());
        }
        if (topicParam.getIntro() != null && !topicParam.getIntro().trim().equals("")) {
            params.put("intro", topicParam.getIntro());
        }
        if (topicParam.getSlogan() != null && !topicParam.getSlogan().trim().equals("")) {
            params.put("slogan", topicParam.getSlogan());
        }
        if (topicParam.getPublishStatus() != null && !topicParam.getPublishStatus().trim().equals("")) {
            params.put("publishStatus", topicParam.getPublishStatus());
        }
        if (topicParam.getStatus() != null && !topicParam.getStatus().trim().equals("")) {
            params.put("status", topicParam.getStatus());
        }
        if (topicParam.getOrderNum() != null) {
            params.put("orderNum", topicParam.getOrderNum());
        }
        if (topicParam.getDetail() != null && !topicParam.getDetail().trim().equals("")) {
            params.put("detail", topicParam.getDetail());
        }
        if (topicParam.getCreateId() != null && !topicParam.getCreateId().trim().equals("")) {
            params.put("createId", topicParam.getCreateId());
        }
        if (topicParam.getCreateTime() != null && !topicParam.getCreateTime().trim().equals("")) {
            params.put("createTime", topicParam.getCreateTime());
        }
        if (topicParam.getUpdateId() != null && !topicParam.getUpdateId().trim().equals("")) {
            params.put("updateId", topicParam.getUpdateId());
        }
        if (topicParam.getUpdateTime() != null && !topicParam.getUpdateTime().trim().equals("")) {
            params.put("updateTime", topicParam.getUpdateTime());
        }
        return params;
    }

}