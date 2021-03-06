package com.synapse.reading.service;

import com.synapse.reading.model.Album;

import java.util.Map;
import java.util.HashMap;

/**
 * <p>
 * 专辑 服务实现类
 * </p>
 *
 * @author liuguangfu
 * @since 2019-01-31
 */
public class AlbumBaseService {

	protected Map<String,Object> prepareParams(Album albumParam) {
        Map<String,Object> params = new HashMap<>();
        if (albumParam.getRecId() != null && !albumParam.getRecId().trim().equals("")) {
            params.put("recId", albumParam.getRecId());
        }
        if (albumParam.getName() != null && !albumParam.getName().trim().equals("")) {
            params.put("name", albumParam.getName());
        }
        if (albumParam.getIntro() != null && !albumParam.getIntro().trim().equals("")) {
            params.put("intro", albumParam.getIntro());
        }
        if (albumParam.getSimpleIntro() != null && !albumParam.getSimpleIntro().trim().equals("")) {
            params.put("simpleIntro", albumParam.getSimpleIntro());
        }
        if (albumParam.getTag() != null && !albumParam.getTag().trim().equals("")) {
            params.put("tag", albumParam.getTag());
        }
        if (albumParam.getSlogan() != null && !albumParam.getSlogan().trim().equals("")) {
            params.put("slogan", albumParam.getSlogan());
        }
        if (albumParam.getType() != null && !albumParam.getType().trim().equals("")) {
            params.put("type", albumParam.getType());
        }
        if (albumParam.getTopicId() != null && !albumParam.getTopicId().trim().equals("")) {
            params.put("topicId", albumParam.getTopicId());
        }
        if (albumParam.getCover() != null && !albumParam.getCover().trim().equals("")) {
            params.put("cover", albumParam.getCover());
        }
        if (albumParam.getPcCover() != null && !albumParam.getPcCover().trim().equals("")) {
            params.put("pcCover", albumParam.getPcCover());
        }
        if (albumParam.getBanner() != null && !albumParam.getBanner().trim().equals("")) {
            params.put("banner", albumParam.getBanner());
        }
        if (albumParam.getPcBanner() != null && !albumParam.getPcBanner().trim().equals("")) {
            params.put("pcBanner", albumParam.getPcBanner());
        }
        if (albumParam.getPublishStatus() != null && !albumParam.getPublishStatus().trim().equals("")) {
            params.put("publishStatus", albumParam.getPublishStatus());
        }
        if (albumParam.getStatus() != null && !albumParam.getStatus().trim().equals("")) {
            params.put("status", albumParam.getStatus());
        }
        if (albumParam.getOrderNum() != null) {
            params.put("orderNum", albumParam.getOrderNum());
        }
        if (albumParam.getVisitNum() != null) {
            params.put("visitNum", albumParam.getVisitNum());
        }
        if (albumParam.getCreateId() != null && !albumParam.getCreateId().trim().equals("")) {
            params.put("createId", albumParam.getCreateId());
        }
        if (albumParam.getCreateTime() != null && !albumParam.getCreateTime().trim().equals("")) {
            params.put("createTime", albumParam.getCreateTime());
        }
        if (albumParam.getUpdateId() != null && !albumParam.getUpdateId().trim().equals("")) {
            params.put("updateId", albumParam.getUpdateId());
        }
        if (albumParam.getUpdateTime() != null && !albumParam.getUpdateTime().trim().equals("")) {
            params.put("updateTime", albumParam.getUpdateTime());
        }
        return params;
    }

}