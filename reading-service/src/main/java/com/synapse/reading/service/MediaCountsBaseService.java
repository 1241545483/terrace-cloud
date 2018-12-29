package com.synapse.reading.service;

import com.synapse.reading.model.MediaCounts;

import java.util.Map;
import java.util.HashMap;

/**
 * <p>
 * 统计播放量 服务实现类
 * </p>
 *
 * @author liuguangfu
 * @since 2018-12-29
 */
public class MediaCountsBaseService {

	protected Map<String,Object> prepareParams(MediaCounts mediaCountsParam) {
        Map<String,Object> params = new HashMap<>();
        if (mediaCountsParam.getRecId() != null && !mediaCountsParam.getRecId().trim().equals("")) {
            params.put("recId", mediaCountsParam.getRecId());
        }
        if (mediaCountsParam.getMediaId() != null && !mediaCountsParam.getMediaId().trim().equals("")) {
            params.put("mediaId", mediaCountsParam.getMediaId());
        }
        if (mediaCountsParam.getMediaType() != null && !mediaCountsParam.getMediaType().trim().equals("")) {
            params.put("mediaType", mediaCountsParam.getMediaType());
        }
        if (mediaCountsParam.getClicked() != null && !mediaCountsParam.getClicked().trim().equals("")) {
            params.put("clicked", mediaCountsParam.getClicked());
        }
        if (mediaCountsParam.getFinished() != null && !mediaCountsParam.getFinished().trim().equals("")) {
            params.put("finished", mediaCountsParam.getFinished());
        }
        if (mediaCountsParam.getCreateTime() != null && !mediaCountsParam.getCreateTime().trim().equals("")) {
            params.put("createTime", mediaCountsParam.getCreateTime());
        }
        return params;
    }

}