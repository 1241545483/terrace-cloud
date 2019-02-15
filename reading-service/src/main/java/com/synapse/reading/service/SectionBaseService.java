package com.synapse.reading.service;

import com.synapse.reading.model.Section;

import java.util.Map;
import java.util.HashMap;

/**
 * <p>
 * 章节 服务实现类
 * </p>
 *
 * @author liuguangfu
 * @since 2019-02-15
 */
public class SectionBaseService {

	protected Map<String,Object> prepareParams(Section sectionParam) {
        Map<String,Object> params = new HashMap<>();
        if (sectionParam.getRecId() != null && !sectionParam.getRecId().trim().equals("")) {
            params.put("recId", sectionParam.getRecId());
        }
        if (sectionParam.getName() != null && !sectionParam.getName().trim().equals("")) {
            params.put("name", sectionParam.getName());
        }
        if (sectionParam.getIntro() != null && !sectionParam.getIntro().trim().equals("")) {
            params.put("intro", sectionParam.getIntro());
        }
        if (sectionParam.getLessionId() != null && !sectionParam.getLessionId().trim().equals("")) {
            params.put("lessionId", sectionParam.getLessionId());
        }
        if (sectionParam.getImage() != null && !sectionParam.getImage().trim().equals("")) {
            params.put("image", sectionParam.getImage());
        }
        if (sectionParam.getBanner() != null && !sectionParam.getBanner().trim().equals("")) {
            params.put("banner", sectionParam.getBanner());
        }
        if (sectionParam.getPublishStatus() != null && !sectionParam.getPublishStatus().trim().equals("")) {
            params.put("publishStatus", sectionParam.getPublishStatus());
        }
        if (sectionParam.getStatus() != null && !sectionParam.getStatus().trim().equals("")) {
            params.put("status", sectionParam.getStatus());
        }
        if (sectionParam.getOrderNum() != null) {
            params.put("orderNum", sectionParam.getOrderNum());
        }
        if (sectionParam.getVisitNum() != null) {
            params.put("visitNum", sectionParam.getVisitNum());
        }
        if (sectionParam.getCreateId() != null && !sectionParam.getCreateId().trim().equals("")) {
            params.put("createId", sectionParam.getCreateId());
        }
        if (sectionParam.getCreateTime() != null && !sectionParam.getCreateTime().trim().equals("")) {
            params.put("createTime", sectionParam.getCreateTime());
        }
        if (sectionParam.getUpdateId() != null && !sectionParam.getUpdateId().trim().equals("")) {
            params.put("updateId", sectionParam.getUpdateId());
        }
        if (sectionParam.getUpdateTime() != null && !sectionParam.getUpdateTime().trim().equals("")) {
            params.put("updateTime", sectionParam.getUpdateTime());
        }
        return params;
    }

}