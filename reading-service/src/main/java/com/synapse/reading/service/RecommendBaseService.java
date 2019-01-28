package com.synapse.reading.service;

import com.synapse.reading.model.Recommend;

import java.util.Map;
import java.util.HashMap;

/**
 * <p>
 * 推荐 服务实现类
 * </p>
 *
 * @author liuguangfu
 * @since 2019-01-25
 */
public class RecommendBaseService {

	protected Map<String,Object> prepareParams(Recommend recommendParam) {
        Map<String,Object> params = new HashMap<>();
        if (recommendParam.getRecId() != null && !recommendParam.getRecId().trim().equals("")) {
            params.put("recId", recommendParam.getRecId());
        }
        if (recommendParam.getRecommendType() != null && !recommendParam.getRecommendType().trim().equals("")) {
            params.put("recommendType", recommendParam.getRecommendType());
        }
        if (recommendParam.getRecommendId() != null && !recommendParam.getRecommendId().trim().equals("")) {
            params.put("recommendId", recommendParam.getRecommendId());
        }
        if (recommendParam.getLevel() != null && !recommendParam.getLevel().trim().equals("")) {
            params.put("level", recommendParam.getLevel());
        }
        if (recommendParam.getMenu() != null && !recommendParam.getMenu().trim().equals("")) {
            params.put("menu", recommendParam.getMenu());
        }
        if (recommendParam.getCreateId() != null && !recommendParam.getCreateId().trim().equals("")) {
            params.put("createId", recommendParam.getCreateId());
        }
        if (recommendParam.getCreateTime() != null && !recommendParam.getCreateTime().trim().equals("")) {
            params.put("createTime", recommendParam.getCreateTime());
        }
        if (recommendParam.getStartTime() != null && !recommendParam.getStartTime().trim().equals("")) {
            params.put("startTime", recommendParam.getStartTime());
        }
        if (recommendParam.getEndTime() != null && !recommendParam.getEndTime().trim().equals("")) {
            params.put("endTime", recommendParam.getEndTime());
        }
        return params;
    }

}