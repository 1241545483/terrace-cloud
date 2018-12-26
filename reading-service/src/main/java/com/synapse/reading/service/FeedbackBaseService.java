package com.synapse.reading.service;

import com.synapse.reading.model.Feedback;

import java.util.Map;
import java.util.HashMap;

/**
 * <p>
 * 意见反馈 服务实现类
 * </p>
 *
 * @author liuguangfu
 * @since 2018-12-26
 */
public class FeedbackBaseService {

	protected Map<String,Object> prepareParams(Feedback feedbackParam) {
        Map<String,Object> params = new HashMap<>();
        if (feedbackParam.getRecId() != null && !feedbackParam.getRecId().trim().equals("")) {
            params.put("recId", feedbackParam.getRecId());
        }
        if (feedbackParam.getContent() != null && !feedbackParam.getContent().trim().equals("")) {
            params.put("content", feedbackParam.getContent());
        }
        if (feedbackParam.getCreateId() != null && !feedbackParam.getCreateId().trim().equals("")) {
            params.put("createId", feedbackParam.getCreateId());
        }
        if (feedbackParam.getCreateTime() != null && !feedbackParam.getCreateTime().trim().equals("")) {
            params.put("createTime", feedbackParam.getCreateTime());
        }
        return params;
    }

}