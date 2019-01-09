package com.synapse.reading.service;

import com.synapse.reading.model.Issue;

import java.util.Map;
import java.util.HashMap;

/**
 * <p>
 * 观看视频回答题目 服务实现类
 * </p>
 *
 * @author liuguangfu
 * @since 2019-01-09
 */
public class IssueBaseService {

	protected Map<String,Object> prepareParams(Issue issueParam) {
        Map<String,Object> params = new HashMap<>();
        if (issueParam.getRecId() != null && !issueParam.getRecId().trim().equals("")) {
            params.put("recId", issueParam.getRecId());
        }
        if (issueParam.getContent() != null && !issueParam.getContent().trim().equals("")) {
            params.put("content", issueParam.getContent());
        }
        if (issueParam.getBelongTo() != null && !issueParam.getBelongTo().trim().equals("")) {
            params.put("belongTo", issueParam.getBelongTo());
        }
        if (issueParam.getBelongToId() != null && !issueParam.getBelongToId().trim().equals("")) {
            params.put("belongToId", issueParam.getBelongToId());
        }
        if (issueParam.getImg1() != null && !issueParam.getImg1().trim().equals("")) {
            params.put("img1", issueParam.getImg1());
        }
        if (issueParam.getImg2() != null && !issueParam.getImg2().trim().equals("")) {
            params.put("img2", issueParam.getImg2());
        }
        if (issueParam.getImg3() != null && !issueParam.getImg3().trim().equals("")) {
            params.put("img3", issueParam.getImg3());
        }
        if (issueParam.getType() != null && !issueParam.getType().trim().equals("")) {
            params.put("type", issueParam.getType());
        }
        if (issueParam.getAnalysis() != null && !issueParam.getAnalysis().trim().equals("")) {
            params.put("analysis", issueParam.getAnalysis());
        }
        if (issueParam.getDifficulty() != null && !issueParam.getDifficulty().trim().equals("")) {
            params.put("difficulty", issueParam.getDifficulty());
        }
        if (issueParam.getStatus() != null && !issueParam.getStatus().trim().equals("")) {
            params.put("status", issueParam.getStatus());
        }
        if (issueParam.getCreateId() != null && !issueParam.getCreateId().trim().equals("")) {
            params.put("createId", issueParam.getCreateId());
        }
        if (issueParam.getCreateTime() != null && !issueParam.getCreateTime().trim().equals("")) {
            params.put("createTime", issueParam.getCreateTime());
        }
        if (issueParam.getUpdateId() != null && !issueParam.getUpdateId().trim().equals("")) {
            params.put("updateId", issueParam.getUpdateId());
        }
        if (issueParam.getUpdateTime() != null && !issueParam.getUpdateTime().trim().equals("")) {
            params.put("updateTime", issueParam.getUpdateTime());
        }
        return params;
    }

}