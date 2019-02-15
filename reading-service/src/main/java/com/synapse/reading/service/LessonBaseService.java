package com.synapse.reading.service;

import com.synapse.reading.model.Lesson;

import java.util.Map;
import java.util.HashMap;

/**
 * <p>
 * 课程 服务实现类
 * </p>
 *
 * @author liuguangfu
 * @since 2019-02-15
 */
public class LessonBaseService {

	protected Map<String,Object> prepareParams(Lesson lessonParam) {
        Map<String,Object> params = new HashMap<>();
        if (lessonParam.getRecId() != null && !lessonParam.getRecId().trim().equals("")) {
            params.put("recId", lessonParam.getRecId());
        }
        if (lessonParam.getName() != null && !lessonParam.getName().trim().equals("")) {
            params.put("name", lessonParam.getName());
        }
        if (lessonParam.getIntro() != null && !lessonParam.getIntro().trim().equals("")) {
            params.put("intro", lessonParam.getIntro());
        }
        if (lessonParam.getPresentation() != null && !lessonParam.getPresentation().trim().equals("")) {
            params.put("presentation", lessonParam.getPresentation());
        }
        if (lessonParam.getImage() != null && !lessonParam.getImage().trim().equals("")) {
            params.put("image", lessonParam.getImage());
        }
        if (lessonParam.getBanner() != null && !lessonParam.getBanner().trim().equals("")) {
            params.put("banner", lessonParam.getBanner());
        }
        if (lessonParam.getPublishStatus() != null && !lessonParam.getPublishStatus().trim().equals("")) {
            params.put("publishStatus", lessonParam.getPublishStatus());
        }
        if (lessonParam.getStatus() != null && !lessonParam.getStatus().trim().equals("")) {
            params.put("status", lessonParam.getStatus());
        }
        if (lessonParam.getOrderNum() != null) {
            params.put("orderNum", lessonParam.getOrderNum());
        }
        if (lessonParam.getVisitNum() != null) {
            params.put("visitNum", lessonParam.getVisitNum());
        }
        if (lessonParam.getCreateId() != null && !lessonParam.getCreateId().trim().equals("")) {
            params.put("createId", lessonParam.getCreateId());
        }
        if (lessonParam.getCreateTime() != null && !lessonParam.getCreateTime().trim().equals("")) {
            params.put("createTime", lessonParam.getCreateTime());
        }
        if (lessonParam.getUpdateId() != null && !lessonParam.getUpdateId().trim().equals("")) {
            params.put("updateId", lessonParam.getUpdateId());
        }
        if (lessonParam.getUpdateTime() != null && !lessonParam.getUpdateTime().trim().equals("")) {
            params.put("updateTime", lessonParam.getUpdateTime());
        }
        return params;
    }

}