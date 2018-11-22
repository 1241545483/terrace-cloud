package com.synapse.reading.service;

import com.synapse.common.constants.PageInfo;
import com.synapse.reading.model.VideoList;
import com.synapse.reading.respository.VideoListRespository;
import com.synapse.reading.dto.param.VideoListParam;
import com.synapse.reading.dto.result.VideoListResult;
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
 * 服务实现类
 * </p>
 *
 * @author wangyifan
 * @since 2018-11-20
 */
@Service
@Transactional
public class VideoListService extends VideoListBaseService {

    @Autowired
    private IdService idService;

    @Autowired
    private VideoListRespository videoListRespository;

    public VideoList find(String recId) {
        return videoListRespository.selectByPrimaryKey(recId);
    }

    public Integer update(VideoList param) {
        String now = DateUtils.getNowStr(DateUtils.FORMAT_DATE_TIME);
        param.setUpdateTime(now);
        return videoListRespository.updateByPrimaryKeySelective(param);
    }

    public String create(VideoList param) {
        String now = DateUtils.getNowStr(DateUtils.FORMAT_DATE_TIME);
        param.setRecId(idService.gen("ID"));
        param.setCreateTime(now);
        param.setUpdateTime(now);
        videoListRespository.insert(param);
        return param.getRecId();
    }

    public Integer delete(String recId) {
        return videoListRespository.deleteByPrimaryKey(recId);
    }

    public List<VideoList> list(VideoList videoListParam, PageInfo pageInfo) {
        Map<String, Object> params = prepareParams(videoListParam);
        params.put("startIndex", pageInfo.getCurrentStartIndex());
        params.put("pageSize", pageInfo.getPerPageNum());
        return videoListRespository.list(params);
    }

    public Integer count(VideoList videoListParam) {
        Map<String, Object> params = prepareParams(videoListParam);
        return videoListRespository.count(params);
    }

    public boolean updatePlayVideoNum(String recId) {
        return videoListRespository.updatePlayVideoNum(recId)>0;
    }
}