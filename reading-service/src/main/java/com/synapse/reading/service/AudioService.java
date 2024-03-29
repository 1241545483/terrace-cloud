package com.synapse.reading.service;

import com.google.gson.Gson;
import com.synapse.common.constants.PageInfo;
import com.synapse.common.sso.model.User;
import com.synapse.common.trans.Result;
import com.synapse.reading.dto.param.MiniQrcodeParam;
import com.synapse.reading.dto.result.AudioResult;
import com.synapse.reading.model.Audio;
import com.synapse.reading.remote.ShortLinkApiService;
import com.synapse.reading.respository.AudioRespository;
import com.synapse.common.utils.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.synapse.reading.remote.IdService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


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

    private Logger logger = LoggerFactory.getLogger(AudioService.class);

    @Autowired
    private IdService idService;

    @Autowired
    private MiniQrcodeService miniQrcodeService;

    @Autowired
    private AudioRespository audioRespository;
    @Autowired
    private ShortLinkApiService shortLinkApiService;

    @Autowired
    private Gson gson;


    public Audio find(String recId) {
        return audioRespository.selectByPrimaryKey(recId);
    }


    public AudioResult selectIsCollect(String recId,User user) {

        return audioRespository.selectIsCollect(user.getRecId(),recId);
    }

    public Integer update(Audio param) {
        String now = DateUtils.getNowStr(DateUtils.FORMAT_DATE_TIME);
        param.setUpdateTime(now);
        Audio par = find(param.getRecId());
        if (par.getQrCode() == null || "".equals(par.getQrCode().trim())) {
            logger.info("enter qrcode");
            param = getAudioQrCode(param);
        }
        logger.info("param"+param);
        return audioRespository.updateByPrimaryKeySelective(param);
    }

    public String create(Audio param) {
        String now = DateUtils.getNowStr(DateUtils.FORMAT_DATE_TIME);
        param.setRecId(idService.gen("ID"));
//        param.setRecId("lgfwewew2232999");
        param.setCreateTime(now);
        param.setUpdateTime(now);
        getAudioQrCode(param);
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

    public List<AudioResult> listAudioAddIsCollect(Audio audioParam, PageInfo pageInfo, String userId) {
        Map<String, Object> params = prepareParams(audioParam);
        params.put("startIndex", pageInfo.getCurrentStartIndex());
        params.put("pageSize", pageInfo.getPerPageNum());
        params.put("userId", userId);
        return audioRespository.listAudioAddIsCollect(params);
    }

    public List<AudioResult> listMyCollectByAudio( User user) {
        String userId =user.getRecId();
        return audioRespository.listMyCollectByAudio(userId);
    }

    public Integer count(Audio audioParam) {
        Map<String, Object> params = prepareParams(audioParam);
        return audioRespository.count(params);
    }

    public boolean increasePlayNum(String recId) {
        return audioRespository.increasePlayNum(recId) > 0;
    }
    public boolean increaseFinishNum(String recId) {
        return audioRespository.increaseFinishNum(recId) > 0;
    }

    public Audio getAudioQrCode(Audio param) {
        MiniQrcodeParam miniQrcodeParam = new MiniQrcodeParam();
        miniQrcodeParam.setPage("pages/audio/audio");
        Map<String, String> params = new HashMap<>();
        params.put("belongToId", param.getBelongToId());
        params.put("audioId", param.getRecId());
        params.put("belongTo",param.getBelongTo());
        Result result = shortLinkApiService.getCodeByUrl(gson.toJson(params));
        if (result != null && result.getCode() == 200) {
            String body = (String) result.getBody();
            String scene = org.apache.commons.lang3.StringUtils.substringAfterLast(body, "/");
            miniQrcodeParam.setScene(scene);
        } else {
            throw new RuntimeException(result.getMsg());
        }
        miniQrcodeParam.setWidth("110");
        try {
            String generate = miniQrcodeService.generate(miniQrcodeParam);
//            String url =null;
//            if("OSS".equals(UploadType)) {
//                url = String.valueOf(generate.get("url"));
//            }else{
//                Map<String, Object> bizInfo = (Map<String, Object>) generate.get("bizInfo");
//                List<Map<String, Object>> models = (List<Map<String, Object>>) bizInfo.get("models");
//                Map<String, Object> urlModel = (Map<String, Object>) models.get(0);
//                url =String.valueOf(urlModel.get("url"));
//            }
            param.setQrCode(generate);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return param;
    }


    public List<Audio> listSortByOrderNum(Audio audioParam, PageInfo pageInfo) {
        Map<String, Object> params = prepareParams(audioParam);
        params.put("startIndex", pageInfo.getCurrentStartIndex());
        params.put("pageSize", pageInfo.getPerPageNum());
        return audioRespository.listSortByOrderNum(params);
    }
}