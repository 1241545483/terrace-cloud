package com.synapse.reading.service;

import com.synapse.reading.model.ShareImage;

import java.util.Map;
import java.util.HashMap;

/**
 * <p>
 * 分享图片 服务实现类
 * </p>
 *
 * @author liuguangfu
 * @since 2018-12-27
 */
public class ShareImageBaseService {

	protected Map<String,Object> prepareParams(ShareImage shareImageParam) {
        Map<String,Object> params = new HashMap<>();
        if (shareImageParam.getRecId() != null && !shareImageParam.getRecId().trim().equals("")) {
            params.put("recId", shareImageParam.getRecId());
        }
        if (shareImageParam.getUserId() != null && !shareImageParam.getUserId().trim().equals("")) {
            params.put("userId", shareImageParam.getUserId());
        }
        if (shareImageParam.getShareType() != null && !shareImageParam.getShareType().trim().equals("")) {
            params.put("shareType", shareImageParam.getShareType());
        }
        if (shareImageParam.getShareId() != null && !shareImageParam.getShareId().trim().equals("")) {
            params.put("shareId", shareImageParam.getShareId());
        }
        if (shareImageParam.getUrl() != null && !shareImageParam.getUrl().trim().equals("")) {
            params.put("url", shareImageParam.getUrl());
        }
        if (shareImageParam.getCreateId() != null && !shareImageParam.getCreateId().trim().equals("")) {
            params.put("createId", shareImageParam.getCreateId());
        }
        if (shareImageParam.getCreateTime() != null && !shareImageParam.getCreateTime().trim().equals("")) {
            params.put("createTime", shareImageParam.getCreateTime());
        }
        if (shareImageParam.getUpdateId() != null && !shareImageParam.getUpdateId().trim().equals("")) {
            params.put("updateId", shareImageParam.getUpdateId());
        }
        if (shareImageParam.getUpdateTime() != null && !shareImageParam.getUpdateTime().trim().equals("")) {
            params.put("updateTime", shareImageParam.getUpdateTime());
        }
        return params;
    }

}