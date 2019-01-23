package com.synapse.reading.service;

import com.synapse.reading.model.RelevanceItem;

import java.util.Map;
import java.util.HashMap;

/**
 * <p>
 * 书籍与目录对应关系 服务实现类
 * </p>
 *
 * @author liuguangfu
 * @since 2019-01-23
 */
public class RelevanceItemBaseService {

	protected Map<String,Object> prepareParams(RelevanceItem relevanceItemParam) {
        Map<String,Object> params = new HashMap<>();
        if (relevanceItemParam.getRecId() != null && !relevanceItemParam.getRecId().trim().equals("")) {
            params.put("recId", relevanceItemParam.getRecId());
        }
        if (relevanceItemParam.getCategoryId() != null && !relevanceItemParam.getCategoryId().trim().equals("")) {
            params.put("categoryId", relevanceItemParam.getCategoryId());
        }
        if (relevanceItemParam.getItemId() != null && !relevanceItemParam.getItemId().trim().equals("")) {
            params.put("itemId", relevanceItemParam.getItemId());
        }
        if (relevanceItemParam.getItemType() != null && !relevanceItemParam.getItemType().trim().equals("")) {
            params.put("itemType", relevanceItemParam.getItemType());
        }
        if (relevanceItemParam.getWeight() != null && !relevanceItemParam.getWeight().trim().equals("")) {
            params.put("weight", relevanceItemParam.getWeight());
        }
        if (relevanceItemParam.getCreateId() != null && !relevanceItemParam.getCreateId().trim().equals("")) {
            params.put("createId", relevanceItemParam.getCreateId());
        }
        if (relevanceItemParam.getCreateTime() != null && !relevanceItemParam.getCreateTime().trim().equals("")) {
            params.put("createTime", relevanceItemParam.getCreateTime());
        }
        if (relevanceItemParam.getUpdateId() != null && !relevanceItemParam.getUpdateId().trim().equals("")) {
            params.put("updateId", relevanceItemParam.getUpdateId());
        }
        if (relevanceItemParam.getUpdateTime() != null && !relevanceItemParam.getUpdateTime().trim().equals("")) {
            params.put("updateTime", relevanceItemParam.getUpdateTime());
        }
        return params;
    }

}