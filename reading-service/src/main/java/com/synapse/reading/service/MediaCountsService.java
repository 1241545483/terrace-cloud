package com.synapse.reading.service;

import com.synapse.common.constants.PageInfo;
import com.synapse.common.sso.model.User;
import com.synapse.reading.model.MediaCounts;
import com.synapse.reading.respository.MediaCountsRespository;
import com.synapse.reading.dto.param.MediaCountsParam;
import com.synapse.reading.dto.result.MediaCountsResult;
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
 * 统计播放量 服务实现类
 * </p>
 *
 * @author liuguangfu
 * @since 2018-12-25
 */
@Service
@Transactional
public class MediaCountsService extends MediaCountsBaseService {

    @Autowired
    private IdService idService;

    @Autowired
    private MediaCountsRespository mediaCountsRespository;

    @Autowired
    private AudioService audioService;

    public MediaCounts find(String recId) {
        return mediaCountsRespository.selectByPrimaryKey(recId);
    }

    public Integer update(MediaCounts param) {
        String now = DateUtils.getNowStr(DateUtils.FORMAT_DATE_TIME);
        return mediaCountsRespository.updateByPrimaryKeySelective(param);
    }

    public Integer updateFinishedByCreateId(String mediaId, User user) {
        String now = DateUtils.getNowStr(DateUtils.FORMAT_DATE_TIME);
        String createTime = now + "%";
        if (mediaCountsRespository.countByCreateId(mediaId, user.getRecId(), createTime) > 0) {
            audioService.increaseFinishNum(mediaId);
            return mediaCountsRespository.updateFinishedByCreateId(mediaId, user.getRecId(), createTime);
        } else {
            MediaCounts mediaCounts = new MediaCounts();
            mediaCounts.setRecId(idService.gen("ID"));
            mediaCounts.setMediaId(mediaId);
            mediaCounts.setClicked("0");
            mediaCounts.setCreateId(user.getRecId());
            mediaCounts.setCreateTime(now);
            mediaCounts.setMediaType("audio");
            mediaCounts.setFinished("1");
            audioService.increaseFinishNum(mediaId);
            mediaCountsRespository.insertSelective(mediaCounts);
            return 1;
        }
    }

    public Integer updateByCreateId(String mediaId, User user) {
        String now = DateUtils.getNowStr(DateUtils.FORMAT_DATE_TIME);
        String createTime = now + "%";
        if (mediaCountsRespository.countByCreateId(mediaId, user.getRecId(), createTime) > 0) {
            audioService.increasePlayNum(mediaId);
            return mediaCountsRespository.updateByCreateId(mediaId, user.getRecId(), createTime);
        } else {
            MediaCounts mediaCounts = new MediaCounts();
            mediaCounts.setRecId(idService.gen("ID"));
            mediaCounts.setMediaId(mediaId);
            mediaCounts.setClicked("1");
            mediaCounts.setCreateId(user.getRecId());
            mediaCounts.setCreateTime(now);
            mediaCounts.setMediaType("audio");
            mediaCounts.setFinished("0");
            mediaCountsRespository.insert(mediaCounts);
            audioService.increasePlayNum(mediaId);
            return 1;
        }
    }

    public List<Map<String, String>> clickCountByTime(String startTime, String endTime, String mediaId) {
        System.err.println(mediaCountsRespository.clickCountByTime(startTime, endTime, mediaId));
        return mediaCountsRespository.clickCountByTime(startTime, endTime, mediaId);
    }

    public List<Map<String, String>> finishCountByTime(String startTime, String endTime, String mediaId) {
        return mediaCountsRespository.finishCountByTime(startTime, endTime, mediaId);
    }

    public List<Map<String, String>> finishRateByTime(String startTime, String endTime, String mediaId) {
        return mediaCountsRespository.finishRateByTime(startTime, endTime, mediaId);
    }

    public String create(MediaCounts param) {
        String now = DateUtils.getNowStr(DateUtils.FORMAT_DATE_TIME);
        param.setRecId(idService.gen("ID"));
        param.setCreateTime(now);
        mediaCountsRespository.insert(param);
        return param.getRecId();
    }

    public Integer delete(String recId) {
        return mediaCountsRespository.deleteByPrimaryKey(recId);
    }

    public List<MediaCounts> list(MediaCounts mediaCountsParam, PageInfo pageInfo) {
        Map<String, Object> params = prepareParams(mediaCountsParam);
        params.put("startIndex", pageInfo.getCurrentStartIndex());
        params.put("pageSize", pageInfo.getPerPageNum());
        return mediaCountsRespository.list(params);
    }

    public Integer count(MediaCounts mediaCountsParam) {
        Map<String, Object> params = prepareParams(mediaCountsParam);
        return mediaCountsRespository.count(params);
    }

}