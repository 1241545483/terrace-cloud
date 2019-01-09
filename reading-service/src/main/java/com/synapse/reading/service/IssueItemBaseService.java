package com.synapse.reading.service;

import com.synapse.reading.model.IssueItem;

import java.util.Map;
import java.util.HashMap;

/**
 * <p>
 * 题目选项 服务实现类
 * </p>
 *
 * @author liuguangfu
 * @since 2019-01-09
 */
public class IssueItemBaseService {

	protected Map<String,Object> prepareParams(IssueItem issueItemParam) {
        Map<String,Object> params = new HashMap<>();
        if (issueItemParam.getRecId() != null && !issueItemParam.getRecId().trim().equals("")) {
            params.put("recId", issueItemParam.getRecId());
        }
        if (issueItemParam.getIssueId() != null && !issueItemParam.getIssueId().trim().equals("")) {
            params.put("issueId", issueItemParam.getIssueId());
        }
        if (issueItemParam.getContent() != null && !issueItemParam.getContent().trim().equals("")) {
            params.put("content", issueItemParam.getContent());
        }
        if (issueItemParam.getImg1() != null && !issueItemParam.getImg1().trim().equals("")) {
            params.put("img1", issueItemParam.getImg1());
        }
        if (issueItemParam.getImg2() != null && !issueItemParam.getImg2().trim().equals("")) {
            params.put("img2", issueItemParam.getImg2());
        }
        if (issueItemParam.getImg3() != null && !issueItemParam.getImg3().trim().equals("")) {
            params.put("img3", issueItemParam.getImg3());
        }
        if (issueItemParam.getIsAnswer() != null && !issueItemParam.getIsAnswer().trim().equals("")) {
            params.put("isAnswer", issueItemParam.getIsAnswer());
        }
        if (issueItemParam.getCreateId() != null && !issueItemParam.getCreateId().trim().equals("")) {
            params.put("createId", issueItemParam.getCreateId());
        }
        if (issueItemParam.getCreateTime() != null && !issueItemParam.getCreateTime().trim().equals("")) {
            params.put("createTime", issueItemParam.getCreateTime());
        }
        if (issueItemParam.getUpdateId() != null && !issueItemParam.getUpdateId().trim().equals("")) {
            params.put("updateId", issueItemParam.getUpdateId());
        }
        if (issueItemParam.getUpdateTime() != null && !issueItemParam.getUpdateTime().trim().equals("")) {
            params.put("updateTime", issueItemParam.getUpdateTime());
        }
        return params;
    }

}