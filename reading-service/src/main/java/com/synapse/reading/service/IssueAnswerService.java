package com.synapse.reading.service;

import com.synapse.common.constants.PageInfo;
import com.synapse.common.sso.model.User;
import com.synapse.reading.model.IssueAnswer;
import com.synapse.reading.respository.IssueAnswerRespository;
import com.synapse.reading.dto.param.IssueAnswerParam;
import com.synapse.reading.dto.result.IssueAnswerResult;
import com.synapse.common.utils.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.synapse.reading.constants.IssueAnswerConstants;
import com.synapse.reading.remote.IdService;

import java.util.List;
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
@Service
@Transactional
public class IssueAnswerService extends IssueAnswerBaseService {

	@Autowired
	private IdService idService;

    @Autowired
    private IssueAnswerRespository issueAnswerRespository;

    @Autowired
    private  ShareImageService shareImageService;

    private Logger logger = LoggerFactory.getLogger(IssueAnswerService.class);

    public IssueAnswer find(String recId){
	    return issueAnswerRespository.selectByPrimaryKey(recId);
    }

	public Integer update(IssueAnswer param){
        String now = DateUtils.getNowStr(DateUtils.FORMAT_DATE_TIME);
		return issueAnswerRespository.updateByPrimaryKeySelective(param);
    }

    public String create(IssueAnswer param) {
        String now = DateUtils.getNowStr(DateUtils.FORMAT_DATE_TIME);
        param.setRecId(idService.gen("ID"));
        param.setCreateTime(now);
        param.setStatus(IssueAnswerConstants.STATUS.OK.num());
        issueAnswerRespository.insert(param);
        return param.getRecId();
    }

    public String createAnswer(IssueAnswerParam param) {
        IssueAnswer model = param.getModel();
        logger.info("----------------------param.getItemId model  =" + param.getItemId());
        if(param.getItemIdList()!=null&&param.getItemIdList().size()>0){
            for (String itemId:param.getItemIdList()) {
                model.setItemId(itemId);
                create(model);
            }
        }else {
            create(model);
        }
        return param.getRecId();
    }

	public Integer delete(String recId, String updateId) {
        String now = DateUtils.getNowStr(DateUtils.FORMAT_DATE_TIME);
        IssueAnswer model = new IssueAnswer();
        model.setRecId(recId);
        model.setStatus(IssueAnswerConstants.STATUS.DELETED.num());
        return issueAnswerRespository.updateByPrimaryKeySelective(model);
    }
    public Integer deleteByCreateId(User user, String belongToId, String belongTo){
        Integer num1 = shareImageService.deleteByUserId(user.getRecId(),belongToId);
        Integer num2 = issueAnswerRespository.deleteByCreateId(user.getRecId(),belongToId,belongTo);
        return num1+num2;
    }

	public List<IssueAnswer> list(IssueAnswer issueAnswerParam, PageInfo pageInfo) {
		issueAnswerParam.setStatus(IssueAnswerConstants.STATUS.OK.num());
        Map<String,Object> params = prepareParams(issueAnswerParam);
        params.put("startIndex", pageInfo.getCurrentStartIndex());
        params.put("pageSize", pageInfo.getPerPageNum());
        return issueAnswerRespository.list(params);
	}

    public List<String> listUser(Map<String,String> map) {
        return issueAnswerRespository.listUser(map);
    }

	public Integer count(IssueAnswer issueAnswerParam) {
		issueAnswerParam.setStatus(IssueAnswerConstants.STATUS.OK.num());
        Map<String,Object> params = prepareParams(issueAnswerParam);
        return issueAnswerRespository.count(params);
    }

}