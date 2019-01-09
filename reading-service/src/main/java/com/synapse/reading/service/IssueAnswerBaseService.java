package com.synapse.reading.service;

import com.synapse.reading.model.IssueAnswer;

import java.util.Map;
import java.util.HashMap;

/**
 * <p>
 * 问题回答 服务实现类
 * </p>
 *
 * @author liuguangfu
 * @since 2019-01-09
 */
public class IssueAnswerBaseService {

	protected Map<String,Object> prepareParams(IssueAnswer issueAnswerParam) {
        Map<String,Object> params = new HashMap<>();
        if (issueAnswerParam.getRecId() != null && !issueAnswerParam.getRecId().trim().equals("")) {
            params.put("recId", issueAnswerParam.getRecId());
        }
        if (issueAnswerParam.getIssueId() != null && !issueAnswerParam.getIssueId().trim().equals("")) {
            params.put("issueId", issueAnswerParam.getIssueId());
        }
        if (issueAnswerParam.getItemId() != null && !issueAnswerParam.getItemId().trim().equals("")) {
            params.put("itemId", issueAnswerParam.getItemId());
        }
        if (issueAnswerParam.getStatus() != null && !issueAnswerParam.getStatus().trim().equals("")) {
            params.put("status", issueAnswerParam.getStatus());
        }
        if (issueAnswerParam.getCreateId() != null && !issueAnswerParam.getCreateId().trim().equals("")) {
            params.put("createId", issueAnswerParam.getCreateId());
        }
        if (issueAnswerParam.getCreateTime() != null && !issueAnswerParam.getCreateTime().trim().equals("")) {
            params.put("createTime", issueAnswerParam.getCreateTime());
        }
        return params;
    }

}