package com.synapse.reading.service;

import com.synapse.common.constants.PageInfo;
import com.synapse.reading.model.Issue;
import com.synapse.reading.respository.IssueRespository;
import com.synapse.reading.dto.param.IssueParam;
import com.synapse.reading.dto.result.IssueResult;
import com.synapse.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.synapse.reading.constants.IssueConstants;
import com.synapse.reading.remote.IdService;

import java.util.List;
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
@Service
@Transactional
public class IssueService extends IssueBaseService {

	@Autowired
	private IdService idService;

    @Autowired
    private IssueRespository issueRespository;

    public Issue find(String recId){
	    return issueRespository.selectByPrimaryKey(recId);
    }

	public Integer update(Issue param){
        String now = DateUtils.getNowStr(DateUtils.FORMAT_DATE_TIME);
        param.setUpdateTime(now);
		return issueRespository.updateByPrimaryKeySelective(param);
    }

    public String create(Issue param) {
        String now = DateUtils.getNowStr(DateUtils.FORMAT_DATE_TIME);
        param.setRecId(idService.gen("ID"));
		param.setCreateTime(now);
		param.setUpdateTime(now);
		param.setStatus(IssueConstants.STATUS.OK.num());
        issueRespository.insert(param);
        return param.getRecId();
    }

	public Integer delete(String recId, String updateId) {
        String now = DateUtils.getNowStr(DateUtils.FORMAT_DATE_TIME);
        Issue model = new Issue();
        model.setRecId(recId);
        model.setUpdateId(updateId);
        model.setUpdateTime(now);
        model.setStatus(IssueConstants.STATUS.DELETED.num());
        return issueRespository.updateByPrimaryKeySelective(model);
    }

	public List<Issue> list(Issue issueParam, PageInfo pageInfo) {
		issueParam.setStatus(IssueConstants.STATUS.OK.num());
        Map<String,Object> params = prepareParams(issueParam);
        params.put("startIndex", pageInfo.getCurrentStartIndex());
        params.put("pageSize", pageInfo.getPerPageNum());
        return issueRespository.list(params);
	}

	public Integer count(Issue issueParam) {
		issueParam.setStatus(IssueConstants.STATUS.OK.num());
        Map<String,Object> params = prepareParams(issueParam);
        return issueRespository.count(params);
    }

    public  Integer  insertIssueAll(Issue params){
        issueRespository.insert(params);


        return 1;
    }


}