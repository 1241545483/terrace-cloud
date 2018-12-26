package com.synapse.reading.service;

import com.synapse.common.constants.PageInfo;
import com.synapse.reading.model.Feedback;
import com.synapse.reading.respository.FeedbackRespository;
import com.synapse.reading.dto.param.FeedbackParam;
import com.synapse.reading.dto.result.FeedbackResult;
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
 * 意见反馈 服务实现类
 * </p>
 *
 * @author liuguangfu
 * @since 2018-12-26
 */
@Service
@Transactional
public class FeedbackService extends FeedbackBaseService {

	@Autowired
	private IdService idService;

    @Autowired
    private FeedbackRespository feedbackRespository;

    public Feedback find(String recId){
	    return feedbackRespository.selectByPrimaryKey(recId);
    }

	public Integer update(Feedback param){
        String now = DateUtils.getNowStr(DateUtils.FORMAT_DATE_TIME);
		return feedbackRespository.updateByPrimaryKeySelective(param);
    }

    public String create(Feedback param) {
        String now = DateUtils.getNowStr(DateUtils.FORMAT_DATE_TIME);
        param.setRecId(idService.gen("ID"));
		param.setCreateTime(now);
        feedbackRespository.insert(param);
        return param.getRecId();
    }

	public Integer delete(String recId){
        return feedbackRespository.deleteByPrimaryKey(recId);
	}

	public List<Feedback> list(Feedback feedbackParam, PageInfo pageInfo) {
        Map<String,Object> params = prepareParams(feedbackParam);
        params.put("startIndex", pageInfo.getCurrentStartIndex());
        params.put("pageSize", pageInfo.getPerPageNum());
        return feedbackRespository.list(params);
	}

	public Integer count(Feedback feedbackParam) {
        Map<String,Object> params = prepareParams(feedbackParam);
        return feedbackRespository.count(params);
    }

}