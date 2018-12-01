package com.synapse.reading.service;

import com.synapse.reading.model.Information;

import java.util.Map;
import java.util.HashMap;

/**
 * <p>
 * 资讯模块 服务实现类
 * </p>
 *
 * @author liuguangfu
 * @since 2018-12-01
 */
public class InformationBaseService {

	protected Map<String,Object> prepareParams(Information informationParam) {
        Map<String,Object> params = new HashMap<>();
        if (informationParam.getRecId() != null && !informationParam.getRecId().trim().equals("")) {
            params.put("recId", informationParam.getRecId());
        }
        if (informationParam.getTitle() != null && !informationParam.getTitle().trim().equals("")) {
            params.put("title", informationParam.getTitle());
        }
        if (informationParam.getAuthor() != null && !informationParam.getAuthor().trim().equals("")) {
            params.put("author", informationParam.getAuthor());
        }
        if (informationParam.getContent() != null && !informationParam.getContent().trim().equals("")) {
            params.put("content", informationParam.getContent());
        }
        if (informationParam.getCover() != null && !informationParam.getCover().trim().equals("")) {
            params.put("cover", informationParam.getCover());
        }
        if (informationParam.getReadNum() != null) {
            params.put("readNum", informationParam.getReadNum());
        }
        if (informationParam.getLikeNum() != null) {
            params.put("likeNum", informationParam.getLikeNum());
        }
        if (informationParam.getPublishStatus() != null && !informationParam.getPublishStatus().trim().equals("")) {
            params.put("publishStatus", informationParam.getPublishStatus());
        }
        if (informationParam.getStatus() != null && !informationParam.getStatus().trim().equals("")) {
            params.put("status", informationParam.getStatus());
        }
        if (informationParam.getCreateId() != null && !informationParam.getCreateId().trim().equals("")) {
            params.put("createId", informationParam.getCreateId());
        }
        if (informationParam.getCreateTime() != null && !informationParam.getCreateTime().trim().equals("")) {
            params.put("createTime", informationParam.getCreateTime());
        }
        if (informationParam.getUpdateId() != null && !informationParam.getUpdateId().trim().equals("")) {
            params.put("updateId", informationParam.getUpdateId());
        }
        if (informationParam.getUpdateTime() != null && !informationParam.getUpdateTime().trim().equals("")) {
            params.put("updateTime", informationParam.getUpdateTime());
        }
        return params;
    }

}