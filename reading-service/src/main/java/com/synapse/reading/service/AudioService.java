package com.synapse.reading.service;

import com.synapse.common.constants.PageInfo;
import com.synapse.reading.model.Audio;
import com.synapse.reading.respository.AudioRespository;
import com.synapse.reading.dto.param.AudioParam;
import com.synapse.reading.dto.result.AudioResult;
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
 * 音频 服务实现类
 * </p>
 *
 * @author wangyifan
 * @since 2018-11-24
 */
@Service
@Transactional
public class AudioService extends AudioBaseService {

    @Autowired
    private IdService idService;

    @Autowired
    private AudioRespository audioRespository;

    public Audio find(String recId) {
        return audioRespository.selectByPrimaryKey(recId);
    }

    public Integer update(Audio param) {
        String now = DateUtils.getNowStr(DateUtils.FORMAT_DATE_TIME);
        param.setUpdateTime(now);
        return audioRespository.updateByPrimaryKeySelective(param);
    }

    public String create(Audio param) {
        String now = DateUtils.getNowStr(DateUtils.FORMAT_DATE_TIME);
        param.setRecId(idService.gen("ID"));
        param.setCreateTime(now);
        param.setUpdateTime(now);
        audioRespository.insert(param);
        return param.getRecId();
    }

    public Integer delete(String recId) {
        return audioRespository.deleteByPrimaryKey(recId);
    }

    public List<Audio> list(Audio audioParam, PageInfo pageInfo) {
        Map<String, Object> params = prepareParams(audioParam);
        params.put("startIndex", pageInfo.getCurrentStartIndex());
        params.put("pageSize", pageInfo.getPerPageNum());
        return audioRespository.list(params);
    }

    public Integer count(Audio audioParam) {
        Map<String, Object> params = prepareParams(audioParam);
        return audioRespository.count(params);
    }

    public boolean increasePlayNum(String recId) {
        return audioRespository.increasePlayNum(recId) > 0;
    }
}