package com.synapse.reading.service;

import com.synapse.common.constants.PageInfo;
import com.synapse.reading.model.Audio;
import com.synapse.reading.model.Topic;
import com.synapse.reading.respository.TopicRespository;
import com.synapse.reading.dto.param.TopicParam;
import com.synapse.reading.dto.result.TopicResult;
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
 * 主题，关联专辑 服务实现类
 * </p>
 *
 * @author liuguangfu
 * @since 2019-01-28
 */
@Service
@Transactional
public class TopicService extends TopicBaseService {

	@Autowired
	private IdService idService;

    @Autowired
    private TopicRespository topicRespository;

    public Topic find(String recId){
	    return topicRespository.selectByPrimaryKey(recId);
    }

    public List<Audio> getAllAudioList(String recId){
        return topicRespository.getAllAudioList(recId);
    }

	public Integer update(Topic param){
        String now = DateUtils.getNowStr(DateUtils.FORMAT_DATE_TIME);
        param.setUpdateTime(now);
		return topicRespository.updateByPrimaryKeySelective(param);
    }

    public String create(Topic param) {
        String now = DateUtils.getNowStr(DateUtils.FORMAT_DATE_TIME);
        param.setRecId(idService.gen("ID"));
		param.setCreateTime(now);
		param.setUpdateTime(now);
        topicRespository.insert(param);
        return param.getRecId();
    }

	public Integer delete(String recId){
        return topicRespository.deleteByPrimaryKey(recId);
	}

	public List<Topic> list(Topic topicParam, PageInfo pageInfo) {
        Map<String,Object> params = prepareParams(topicParam);
        params.put("startIndex", pageInfo.getCurrentStartIndex());
        params.put("pageSize", pageInfo.getPerPageNum());
        return topicRespository.list(params);
	}

	public Integer count(Topic topicParam) {
        Map<String,Object> params = prepareParams(topicParam);
        return topicRespository.count(params);
    }

}