package com.synapse.reading.service;

import com.synapse.common.constants.PageInfo;
import com.synapse.reading.model.Video;
import com.synapse.reading.respository.VideoRespository;
import com.synapse.reading.dto.param.VideoParam;
import com.synapse.reading.dto.result.VideoResult;
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
 * 视频 服务实现类
 * </p>
 *
 * @author wangyifan
 * @since 2018-11-24
 */
@Service
@Transactional
public class VideoService extends VideoBaseService {

    @Autowired
    private IdService idService;

    @Autowired
    private VideoRespository videoRespository;

    public Video find(String recId) {
        return videoRespository.selectByPrimaryKey(recId);
    }

    public Integer update(Video param) {
        String now = DateUtils.getNowStr(DateUtils.FORMAT_DATE_TIME);
        param.setUpdateTime(now);
        return videoRespository.updateByPrimaryKeySelective(param);
    }

    public String create(Video param) {
        String now = DateUtils.getNowStr(DateUtils.FORMAT_DATE_TIME);
        param.setRecId(idService.gen("ID"));
        param.setCreateTime(now);
        param.setUpdateTime(now);
        videoRespository.insert(param);
        return param.getRecId();
    }

    public Integer delete(String recId) {
        return videoRespository.deleteByPrimaryKey(recId);
    }

    public List<Video> list(Video videoParam, PageInfo pageInfo) {
        Map<String, Object> params = prepareParams(videoParam);
        params.put("startIndex", pageInfo.getCurrentStartIndex());
        params.put("pageSize", pageInfo.getPerPageNum());
        return videoRespository.list(params);
    }

    public Integer count(Video videoParam) {
        Map<String, Object> params = prepareParams(videoParam);
        return videoRespository.count(params);
    }

    public boolean increasePlayNum(String recId) {
        return videoRespository.increasePlayNum(recId) > 0;
    }
}