package com.synapse.reading.service;

import com.synapse.reading.model.ClassInfo;

import java.util.Map;
import java.util.HashMap;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author liuguangfu
 * @since 2019-05-28
 */
public class ClassInfoBaseService {

	protected Map<String,Object> prepareParams(ClassInfo classInfoParam) {
        Map<String,Object> params = new HashMap<>();
        if (classInfoParam.getRecId() != null && !classInfoParam.getRecId().trim().equals("")) {
            params.put("recId", classInfoParam.getRecId());
        }
        if (classInfoParam.getClassCode() != null && !classInfoParam.getClassCode().trim().equals("")) {
            params.put("classCode", classInfoParam.getClassCode());
        }
        if (classInfoParam.getIntro() != null && !classInfoParam.getIntro().trim().equals("")) {
            params.put("intro", classInfoParam.getIntro());
        }
        if (classInfoParam.getQrCode() != null && !classInfoParam.getQrCode().trim().equals("")) {
            params.put("qrCode", classInfoParam.getQrCode());
        }
        if (classInfoParam.getCover() != null && !classInfoParam.getCover().trim().equals("")) {
            params.put("cover", classInfoParam.getCover());
        }
        if (classInfoParam.getStatus() != null && !classInfoParam.getStatus().trim().equals("")) {
            params.put("status", classInfoParam.getStatus());
        }
        if (classInfoParam.getCreateId() != null && !classInfoParam.getCreateId().trim().equals("")) {
            params.put("createId", classInfoParam.getCreateId());
        }
        if (classInfoParam.getCreateTime() != null && !classInfoParam.getCreateTime().trim().equals("")) {
            params.put("createTime", classInfoParam.getCreateTime());
        }
        if (classInfoParam.getUpdateId() != null && !classInfoParam.getUpdateId().trim().equals("")) {
            params.put("updateId", classInfoParam.getUpdateId());
        }
        if (classInfoParam.getUpdateTime() != null && !classInfoParam.getUpdateTime().trim().equals("")) {
            params.put("updateTime", classInfoParam.getUpdateTime());
        }
        return params;
    }

}