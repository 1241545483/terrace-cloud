package com.synapse.reading.service;

import com.synapse.reading.model.Discuss;

import java.util.Map;
import java.util.HashMap;

/**
 * <p>
 * 评论表 服务实现类
 * </p>
 *
 * @author liuguangfu
 * @since 2018-12-27
 */
public class DiscussBaseService {

	protected Map<String,Object> prepareParams(Discuss discussParam) {
        Map<String,Object> params = new HashMap<>();
        if (discussParam.getRecId() != null && !discussParam.getRecId().trim().equals("")) {
            params.put("recId", discussParam.getRecId());
        }
        if (discussParam.getCommentType() != null && !discussParam.getCommentType().trim().equals("")) {
            params.put("commentType", discussParam.getCommentType());
        }
        if (discussParam.getCommentId() != null && !discussParam.getCommentId().trim().equals("")) {
            params.put("commentId", discussParam.getCommentId());
        }
        if (discussParam.getContent() != null && !discussParam.getContent().trim().equals("")) {
            params.put("content", discussParam.getContent());
        }
        if (discussParam.getLikeNum() != null) {
            params.put("likeNum", discussParam.getLikeNum());
        }
        if (discussParam.getStatus() != null && !discussParam.getStatus().trim().equals("")) {
            params.put("status", discussParam.getStatus());
        }
        if (discussParam.getCreateId() != null && !discussParam.getCreateId().trim().equals("")) {
            params.put("createId", discussParam.getCreateId());
        }
        if (discussParam.getCreateTime() != null && !discussParam.getCreateTime().trim().equals("")) {
            params.put("createTime", discussParam.getCreateTime());
        }
        return params;
    }

}