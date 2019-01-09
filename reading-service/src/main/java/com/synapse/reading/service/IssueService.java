package com.synapse.reading.service;

import com.synapse.common.constants.PageInfo;
import com.synapse.reading.dto.param.IssueItemParam;
import com.synapse.reading.model.Issue;
import com.synapse.reading.model.IssueAnswer;
import com.synapse.reading.model.IssueItem;
import com.synapse.reading.respository.IssueRespository;
import com.synapse.reading.dto.param.IssueParam;
import com.synapse.reading.dto.result.IssueResult;
import com.synapse.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.synapse.reading.constants.IssueConstants;
import com.synapse.reading.remote.IdService;

import java.util.ArrayList;
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
    @Autowired
    private IssueItemService issueItemService;
    @Autowired
    private  IssueAnswerService issueAnswerService;
    @Autowired
    private IssueService issueService;

    public Issue find(String recId) {
        return issueRespository.selectByPrimaryKey(recId);
    }

    public Integer update(Issue param) {
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
        Map<String, Object> params = prepareParams(issueParam);
        params.put("startIndex", pageInfo.getCurrentStartIndex());
        params.put("pageSize", pageInfo.getPerPageNum());
        return issueRespository.list(params);
    }

    public Integer count(Issue issueParam) {
        issueParam.setStatus(IssueConstants.STATUS.OK.num());
        Map<String, Object> params = prepareParams(issueParam);
        return issueRespository.count(params);
    }

    public String createIssueAll(Issue issueParam, List<IssueItemParam> issueItemParamList) {
        create(issueParam);
        String issueId = issueParam.getRecId();
        for (IssueItemParam issueItemParam : issueItemParamList
                ) {
            IssueItem issueItem = issueItemParam.getModel();
            issueItem.setIssueId(issueId);
            issueItemService.create(issueItem);
        }
        return issueParam.getRecId();
    }


    public Integer updateIssueAll(Issue param, List<IssueItemParam> issueItemParamList) {
        String now = DateUtils.getNowStr(DateUtils.FORMAT_DATE_TIME);
        param.setUpdateTime(now);
        String issueId = param.getRecId();
        IssueAnswer issueAnswer =new IssueAnswer();
        issueAnswer.setIssueId(issueId);
        if(issueAnswerService.count(issueAnswer)>0){
            return  0;
        }else{
            if (!"".equals(issueItemService.find(issueId)) && issueItemService.find(issueId) != null) {
                issueItemService.delete(issueId);
                for (IssueItemParam issueItemParam : issueItemParamList
                        ) {
                    IssueItem issueItem = issueItemParam.getModel();
                    issueItem.setIssueId(issueId);
                    issueItemService.create(issueItem);
                }
            }
            return issueRespository.updateByPrimaryKeySelective(param);
        }
    }

    public List<IssueResult> getIssueList(String recId) {

        List<Issue> issueList = issueRespository.selectBybelongToId(recId);
        List<IssueResult> issueResultList = new ArrayList<IssueResult>();
        IssueResult issueResult = new IssueResult();
        for (Issue issue:
        issueList ) {
            List<IssueItem> issueItemList = issueItemService.findByIssueId(issue.getRecId());
            issueResult.setModel(issue);
            issueResult.setIssueItemList(issueItemList);
            issueResultList.add(issueResult);
        }
        return issueResultList;
    }



}