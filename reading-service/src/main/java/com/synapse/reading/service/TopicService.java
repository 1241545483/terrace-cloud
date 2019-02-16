package com.synapse.reading.service;

import com.synapse.common.constants.PageInfo;
import com.synapse.reading.constants.AlbumConstants;
import com.synapse.reading.constants.AudioConstants;
import com.synapse.reading.constants.TopicConstants;
import com.synapse.reading.dto.param.AlbumParam;
import com.synapse.reading.dto.param.AudioParam;
import com.synapse.reading.dto.result.AlbumResult;
import com.synapse.reading.dto.result.SectionResult;
import com.synapse.reading.model.Album;
import com.synapse.reading.model.Audio;
import com.synapse.reading.model.Topic;
import com.synapse.reading.respository.AlbumRespository;
import com.synapse.reading.respository.AudioRespository;
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
import java.util.stream.Collectors;


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

    @Autowired
    private AlbumRespository albumRespository;

    @Autowired
    private AudioRespository audioRespository;

    @Autowired
    private  AlbumBaseService albumBaseService;

    @Autowired
    private  AudioBaseService audioBaseService;


    public Topic find(String recId) {
        return topicRespository.selectByPrimaryKey(recId);
    }

    public List<Audio> getAllAudioList(Topic topicParam, PageInfo pageInfo) {
        Map<String, Object> params = prepareParams(topicParam);
        params.put("startIndex", pageInfo.getCurrentStartIndex());
        params.put("pageSize", pageInfo.getPerPageNum());
        return topicRespository.getAllAudioList(params);
    }

    public Integer update(Topic param) {
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

    public Integer delete(String recId) {
        return topicRespository.deleteByPrimaryKey(recId);
    }

    public List<Topic> list(Topic topicParam, PageInfo pageInfo) {
        Map<String, Object> params = prepareParams(topicParam);
        params.put("startIndex", pageInfo.getCurrentStartIndex());
        params.put("pageSize", pageInfo.getPerPageNum());
        return topicRespository.list(params);
    }

    public Integer count(Topic topicParam) {
        Map<String, Object> params = prepareParams(topicParam);
        return topicRespository.count(params);
    }

    public Integer countAudioNum(Topic topicParam) {
        Map<String, Object> params = prepareParams(topicParam);
        return topicRespository.countAudioNum(params);
    }

    /*
        修改专辑为发布状态
        */
    public boolean topicPublished(String recId) {
        return topicRespository.topicPublished(recId) > 0;
    }

    /*
    修改专辑为未发布状态
    */
    public boolean topicUnPublished(String recId) {
        return topicRespository.topicUnPublished(recId) > 0;
    }

    /*
    创建电台，并创建电台下的专辑，并在专辑下添加已经创建好的音频
     */
    public String createTopic(Topic param, List<AlbumParam> albumParamList) {
        String now = DateUtils.getNowStr(DateUtils.FORMAT_DATE_TIME);
        param.setRecId(idService.gen("ID"));
        param.setCreateTime(now);
        param.setUpdateTime(now);
        param.setStatus(TopicConstants.STATUS.OK.num());
        topicRespository.insert(param);
        if (albumParamList != null && !albumParamList.isEmpty()) {
            for (AlbumParam albumParam : albumParamList) {
                albumParam.setTopicId(param.getRecId());
                albumParam.setRecId(idService.gen("ID"));
                albumParam.setCreateTime(now);
                albumParam.setUpdateTime(now);
                albumParam.setStatus(TopicConstants.STATUS.OK.num());
                albumParam.setPublishStatus(param.getPublishStatus());
                albumRespository.insert(albumParam.getModel());
                if (albumParam.getAudioParamList() != null && !albumParam.getAudioParamList().isEmpty()) {
                    for (AudioParam audioParam : albumParam.getAudioParamList()) {
                        audioParam.setBelongTo(AudioConstants.BelongToType.ALBUM.value());
                        audioParam.setBelongToId(albumParam.getRecId());
                        audioRespository.updateByPrimaryKeySelective(audioParam.getModel());
                    }
                }
            }
        }
        return param.getRecId();
    }

    /*
   更新电台，并创建电台下的专辑，并在专辑下添加已经创建好的音频
    */
    public String updateTopic(Topic param, List<AlbumParam> albumParamList) {
        String now = DateUtils.getNowStr(DateUtils.FORMAT_DATE_TIME);
        param.setUpdateTime(now);
        param.setStatus(TopicConstants.STATUS.OK.num());
        topicRespository.updateByPrimaryKeySelective(param);
        if (albumParamList != null && !albumParamList.isEmpty()) {
            for (AlbumParam albumParam : albumParamList) {
                albumParam.setTopicId(param.getRecId());
                albumParam.setUpdateTime(now);
                albumParam.setStatus(TopicConstants.STATUS.OK.num());
                albumParam.setPublishStatus(param.getPublishStatus());
                if (albumParam.getModel().getRecId()!=null&&!"".equals(albumParam.getModel().getRecId())){
                    albumRespository.updateByPrimaryKeySelective(albumParam.getModel());
                }else {
                    albumParam.setRecId(idService.gen("ID"));
                    albumParam.setCreateTime(now);
                    albumRespository.insert(albumParam.getModel());
                }
                if (albumParam.getAudioParamList() != null && !albumParam.getAudioParamList().isEmpty()) {
                    for (AudioParam audioParam : albumParam.getAudioParamList()) {
                        audioParam.setBelongTo(AudioConstants.BelongToType.ALBUM.value());
                        audioParam.setBelongToId(albumParam.getRecId());
                        audioRespository.updateByPrimaryKeySelective(audioParam.getModel());
                    }
                }
            }
        }
        return param.getRecId();
    }

    public TopicResult getTopic(String recId){
        Album model = new Album();
        model.setTopicId(recId);
        model.setStatus(AlbumConstants.STATUS.OK.num());
        Map<String,Object> params =albumBaseService.prepareParams(model);
        List<Album> albumList= albumRespository.list(params);
        TopicResult topicResult = new TopicResult();
        Topic topic =  topicRespository.selectByPrimaryKey(recId);
        topicResult.setModel(topic);
        Audio audio =new Audio();
        if (albumList!=null && !albumList.isEmpty()){
            List<AlbumResult> albumResultList = albumList.stream().map(alb -> new AlbumResult(alb)).collect(Collectors.toList());
            for (AlbumResult albumResult : albumResultList) {
                audio.setBelongToId(albumResult.getRecId());
                Map<String,Object> audioParams =audioBaseService.prepareParams(audio);
                List<Audio> audioList = audioRespository.list(audioParams);
                albumResult.setAudioList(audioList);
            }
            topicResult.setAlbumParamList(albumList);
        }

        return topicResult;
    }


    public Integer deleteAll(String recId, String updateId) {
        String now = DateUtils.getNowStr(DateUtils.FORMAT_DATE_TIME);
        Topic model = new Topic();
        model.setRecId(recId);
        model.setUpdateId(updateId);
        model.setUpdateTime(now);
        model.setStatus(TopicConstants.STATUS.DELETED.num());
        Album album = new Album();
        Map<String,Object> params =albumBaseService.prepareParams(album);
        List<Album> albumList= albumRespository.list(params);
        if (albumList!=null && !albumList.isEmpty()){
            for (Album album1 : albumList) {
                audioRespository.changeBelongToIdAndBelongTo(album1.getRecId());
                album1.setTopicId(recId);
                album1.setUpdateId(updateId);
                album1.setUpdateTime(now);
                album1.setStatus(TopicConstants.STATUS.DELETED.num());
                albumRespository.updateByPrimaryKeySelective(album1);
            }
        }
        return topicRespository.updateByPrimaryKeySelective(model);
    }

}