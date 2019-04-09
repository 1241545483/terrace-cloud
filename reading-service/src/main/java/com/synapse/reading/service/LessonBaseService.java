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
 * @since 2019-04-09
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
        if (lessonParam.getSimpleIntro() != null && !lessonParam.getSimpleIntro().trim().equals("")) {
            params.put("simpleIntro", lessonParam.getSimpleIntro());
        }
        if (lessonParam.getIntro() != null && !lessonParam.getIntro().trim().equals("")) {
            params.put("intro", lessonParam.getIntro());
        }
        if (lessonParam.getAudioIntro() != null && !lessonParam.getAudioIntro().trim().equals("")) {
            params.put("audioIntro", lessonParam.getAudioIntro());
        }
        if (lessonParam.getVideoIntro() != null && !lessonParam.getVideoIntro().trim().equals("")) {
            params.put("videoIntro", lessonParam.getVideoIntro());
        }
        if (lessonParam.getImage() != null && !lessonParam.getImage().trim().equals("")) {
            params.put("image", lessonParam.getImage());
        }
        if (lessonParam.getQrCode() != null && !lessonParam.getQrCode().trim().equals("")) {
            params.put("qrCode", lessonParam.getQrCode());
        }
        if (lessonParam.getBanner() != null && !lessonParam.getBanner().trim().equals("")) {
            params.put("banner", lessonParam.getBanner());
        }
        if (lessonParam.getDiscount() != null && !lessonParam.getDiscount().trim().equals("")) {
            params.put("discount", lessonParam.getDiscount());
        }
        if (lessonParam.getTag() != null && !lessonParam.getTag().trim().equals("")) {
            params.put("tag", lessonParam.getTag());
        }
        if (lessonParam.getOriginalPrice() != null && !lessonParam.getOriginalPrice().trim().equals("")) {
            params.put("originalPrice", lessonParam.getOriginalPrice());
        }
        if (lessonParam.getPresentPrice() != null && !lessonParam.getPresentPrice().trim().equals("")) {
            params.put("presentPrice", lessonParam.getPresentPrice());
        }
        if (lessonParam.getExpertId() != null && !lessonParam.getExpertId().trim().equals("")) {
            params.put("expertId", lessonParam.getExpertId());
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