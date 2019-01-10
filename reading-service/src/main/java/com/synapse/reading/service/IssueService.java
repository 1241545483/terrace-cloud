package com.synapse.reading.service;

import com.synapse.common.constants.PageInfo;
import com.synapse.common.sso.model.User;
import com.synapse.reading.dto.param.IssueItemParam;
import com.synapse.reading.dto.result.IssueItemResult;
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
    private IssueAnswerService issueAnswerService;
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

    public Integer createIssueAll(List<IssueParam> param, User user) {
        if (!"".equals(param) && param != null) {

            for (IssueParam issueParam : param) {
                if("".equals(issueParam.getRecId())||issueParam.getRecId()==null){
                    Issue model = issueParam.getModel();
                    model.setCreateId(user.getRecId());
                    model.setUpdateId(user.getRecId());
                    create(model);
                }else {
                    issueRespository.updateByPrimaryKeySelective(issueParam.getModel());
                }
                List<IssueItemParam> issueItemParamList = issueParam.getModelList();
                String issueId = issueParam.getRecId();
                issueItemService.deleteByIssueId(issueId);
                for (IssueItemParam issueItemParam : issueItemParamList) {
                    IssueItem issueItem = issueItemParam.getModel();
                    issueItem.setIssueId(issueId);
                    issueItem.setCreateId(user.getRecId());
                    issueItemService.create(issueItem);
                }
            }
            return 1;
        } else {
            return 0;
        }

    }


    public Integer updateIssueAll(Issue param, List<IssueItemParam> issueItemParamList) {
        String now = DateUtils.getNowStr(DateUtils.FORMAT_DATE_TIME);
        param.setUpdateTime(now);
        String issueId = param.getRecId();
        IssueAnswer issueAnswer = new IssueAnswer();
        issueAnswer.setIssueId(issueId);
        if (issueAnswerService.count(issueAnswer) > 0) {
            return 0;
        } else {
            if (!"".equals(issueItemService.findByIssueId(issueId)) && issueItemService.find(issueId) != null) {
                issueItemService.deleteByIssueId(issueId);
                for (IssueItemParam issueItemParam : issueItemParamList) {
                    IssueItem issueItem = issueItemParam.getModel();
                    issueItem.setIssueId(issueId);
                    issueItemService.create(issueItem);
                }
            }
            return issueRespository.updateByPrimaryKeySelective(param);
        }
    }

    public List<IssueResult> getIssueList(String recId, String belongTo) {

        List<Map<String, String>> issueLists = issueRespository.selectBybelongToId(recId, belongTo);
        List<IssueResult> list = new ArrayList<IssueResult>();
        IssueResult issueResult = null;
        for (Map<String, String> map : issueLists) {
            if (issueResult == null || !map.get("rec_id").equals(issueResult.getRecId())) {
                issueResult = new IssueResult();
                list.add(issueResult);
                issueResult.setRecId(map.get("rec_id"));
                issueResult.setContent(map.get("content"));
                issueResult.setBelongTo(map.get("belong_to"));
                issueResult.setBelongToId(map.get("belong_to_id"));
                issueResult.setImg1(map.get("img1"));
                issueResult.setImg2(map.get("img2"));
                issueResult.setImg3(map.get("img3"));
                issueResult.setType(map.get("type"));
                issueResult.setAnalysis(map.get("analysis"));
                issueResult.setDifficulty(map.get("difficulty"));
                issueResult.setCreateId(map.get("create_id"));
                issueResult.setCreateTime(map.get("create_time"));
                issueResult.setUpdateId(map.get("update_id"));
                issueResult.setUpdateTime(map.get("update_time"));
            }
            IssueItemResult item = new IssueItemResult();
            issueResult.getIssueItemList().add(item);
            //设置选项
            item.setRecId(map.get("item_rec_id"));
            item.setIssueId(map.get("issue_id"));
            item.setContent(map.get("item_content"));
            item.setImg1(map.get("item_img1"));
            item.setImg2(map.get("item_img2"));
            item.setImg3(map.get("item_img3"));
            item.setIsAnswer(map.get("is_answer"));
            item.setCreateId(map.get("item_create_id"));
            item.setCreateTime(map.get("item_create_time"));
            item.setUpdateId(map.get("item_update_id"));
            item.setUpdateTime(map.get("item_update_time"));


        }
        return list;
    }


}