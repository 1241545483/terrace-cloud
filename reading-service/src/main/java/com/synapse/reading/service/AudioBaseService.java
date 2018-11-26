package com.synapse.reading.service;

import com.synapse.reading.model.Audio;

import java.util.Map;
import java.util.HashMap;

/**
 * <p>
 * 音频 服务实现类
 * </p>
 *
 * @author liuguangfu
 * @since 2018-11-26
 */
public class AudioBaseService {

	protected Map<String,Object> prepareParams(Audio audioParam) {
        Map<String,Object> params = new HashMap<>();
        if (audioParam.getRecId() != null && !audioParam.getRecId().trim().equals("")) {
            params.put("recId", audioParam.getRecId());
        }
        if (audioParam.getName() != null && !audioParam.getName().trim().equals("")) {
            params.put("name", audioParam.getName());
        }
        if (audioParam.getUrl() != null && !audioParam.getUrl().trim().equals("")) {
            params.put("url", audioParam.getUrl());
        }
        if (audioParam.getIntro() != null && !audioParam.getIntro().trim().equals("")) {
            params.put("intro", audioParam.getIntro());
        }
        if (audioParam.getBelongTo() != null && !audioParam.getBelongTo().trim().equals("")) {
            params.put("belongTo", audioParam.getBelongTo());
        }
        if (audioParam.getBelongToId() != null && !audioParam.getBelongToId().trim().equals("")) {
            params.put("belongToId", audioParam.getBelongToId());
        }
        if (audioParam.getPlayNum() != null) {
            params.put("playNum", audioParam.getPlayNum());
        }
        if (audioParam.getCreateId() != null && !audioParam.getCreateId().trim().equals("")) {
            params.put("createId", audioParam.getCreateId());
        }
        if (audioParam.getCreateTime() != null && !audioParam.getCreateTime().trim().equals("")) {
            params.put("createTime", audioParam.getCreateTime());
        }
        if (audioParam.getUpdateId() != null && !audioParam.getUpdateId().trim().equals("")) {
            params.put("updateId", audioParam.getUpdateId());
        }
        if (audioParam.getUpdateTime() != null && !audioParam.getUpdateTime().trim().equals("")) {
            params.put("updateTime", audioParam.getUpdateTime());
        }
        return params;
    }

}