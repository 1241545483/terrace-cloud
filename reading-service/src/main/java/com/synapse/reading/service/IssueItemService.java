package com.synapse.reading.service;

import com.synapse.common.constants.PageInfo;
import com.synapse.reading.model.IssueItem;
import com.synapse.reading.respository.IssueItemRespository;
import com.synapse.reading.dto.param.IssueItemParam;
import com.synapse.reading.dto.result.IssueItemResult;
import com.synapse.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.synapse.reading.remote.IdService;

import java.util.List;
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
@Service
@Transactional
public class IssueItemService extends IssueItemBaseService {

	@Autowired
	private IdService idService;

    @Autowired
    private IssueItemRespository issueItemRespository;

    public IssueItem find(String recId){
	    return issueItemRespository.selectByPrimaryKey(recId);
    }

	public Integer update(IssueItem param){
        String now = DateUtils.getNowStr(DateUtils.FORMAT_DATE_TIME);
        param.setUpdateTime(now);
		return issueItemRespository.updateByPrimaryKeySelective(param);
    }

    public String create(IssueItem param) {
        String now = DateUtils.getNowStr(DateUtils.FORMAT_DATE_TIME);
        param.setRecId(idService.gen("ID"));
		param.setCreateTime(now);
		param.setUpdateTime(now);
        issueItemRespository.insert(param);
        return param.getRecId();
    }

	public Integer delete(String recId){
        return issueItemRespository.deleteByPrimaryKey(recId);
	}

	public List<IssueItem> list(IssueItem issueItemParam, PageInfo pageInfo) {
        Map<String,Object> params = prepareParams(issueItemParam);
        params.put("startIndex", pageInfo.getCurrentStartIndex());
        params.put("pageSize", pageInfo.getPerPageNum());
        return issueItemRespository.list(params);
	}

	public Integer count(IssueItem issueItemParam) {
        Map<String,Object> params = prepareParams(issueItemParam);
        return issueItemRespository.count(params);
    }



}