package com.synapse.reading.service;

import com.synapse.reading.model.Expert;

import java.util.Map;
import java.util.HashMap;

/**
 * <p>
 * 专家 服务实现类
 * </p>
 *
 * @author liuguangfu
 * @since 2019-04-09
 */
public class ExpertBaseService {

	protected Map<String,Object> prepareParams(Expert expertParam) {
        Map<String,Object> params = new HashMap<>();
        if (expertParam.getRecId() != null && !expertParam.getRecId().trim().equals("")) {
            params.put("recId", expertParam.getRecId());
        }
        if (expertParam.getUserId() != null && !expertParam.getUserId().trim().equals("")) {
            params.put("userId", expertParam.getUserId());
        }
        if (expertParam.getName() != null && !expertParam.getName().trim().equals("")) {
            params.put("name", expertParam.getName());
        }
        if (expertParam.getIntro() != null && !expertParam.getIntro().trim().equals("")) {
            params.put("intro", expertParam.getIntro());
        }
        if (expertParam.getImage() != null && !expertParam.getImage().trim().equals("")) {
            params.put("image", expertParam.getImage());
        }
        if (expertParam.getTitle() != null && !expertParam.getTitle().trim().equals("")) {
            params.put("title", expertParam.getTitle());
        }
        if (expertParam.getStatus() != null && !expertParam.getStatus().trim().equals("")) {
            params.put("status", expertParam.getStatus());
        }
        if (expertParam.getOrderNum() != null) {
            params.put("orderNum", expertParam.getOrderNum());
        }
        if (expertParam.getCreateId() != null && !expertParam.getCreateId().trim().equals("")) {
            params.put("createId", expertParam.getCreateId());
        }
        if (expertParam.getCreateTime() != null && !expertParam.getCreateTime().trim().equals("")) {
            params.put("createTime", expertParam.getCreateTime());
        }
        if (expertParam.getUpdateId() != null && !expertParam.getUpdateId().trim().equals("")) {
            params.put("updateId", expertParam.getUpdateId());
        }
        if (expertParam.getUpdateTime() != null && !expertParam.getUpdateTime().trim().equals("")) {
            params.put("updateTime", expertParam.getUpdateTime());
        }
        return params;
    }

}