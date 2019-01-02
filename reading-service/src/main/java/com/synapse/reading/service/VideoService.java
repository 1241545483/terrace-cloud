package com.synapse.reading.service;

import com.google.gson.Gson;
import com.synapse.common.constants.PageInfo;
import com.synapse.common.trans.Result;
import com.synapse.common.utils.JsonUtils;
import com.synapse.reading.dto.param.MiniQrcodeParam;
import com.synapse.reading.model.Video;
import com.synapse.reading.remote.FileUploadApiService;
import com.synapse.reading.remote.ShortLinkApiService;
import com.synapse.reading.respository.VideoRespository;
import com.synapse.reading.dto.param.VideoParam;
import com.synapse.reading.dto.result.VideoResult;
import com.synapse.common.utils.DateUtils;
import org.apache.commons.lang.StringUtils;
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

    @Autowired
    private MiniQrcodeService miniQrcodeService;

    @Autowired
    private ShortLinkApiService shortLinkApiService;

    @Autowired
    private FileUploadApiService  fileUploadApiService;

    @Autowired
    private Gson gson;

    public Video find(String recId) {
        return videoRespository.selectByPrimaryKey(recId);
    }

    public Integer update(Video param) {
        String now = DateUtils.getNowStr(DateUtils.FORMAT_DATE_TIME);
        param.setUpdateTime(now);
        Video par = find(param.getRecId());
        if (par.getQrCode() == null || "".equals(par.getQrCode().trim())) {
            param = getVidaoQrCode(param);
        }
        return videoRespository.updateByPrimaryKeySelective(param);
    }

    public String create(Video param) {
        String now = DateUtils.getNowStr(DateUtils.FORMAT_DATE_TIME);
        param.setRecId(idService.gen("ID"));
        param.setCreateTime(now);
        param.setUpdateTime(now);
        videoRespository.insert(param);
        getVidaoQrCode(param);
        return param.getRecId();
    }

    public String createAndUploudUrl(Video param) {
        String now = DateUtils.getNowStr(DateUtils.FORMAT_DATE_TIME);
       // param.setRecId(idService.gen("ID"));
        param.setRecId("696");
        param.setCreateTime(now);
        param.setUpdateTime(now);
        String attach = param.getUrl();
        if(StringUtils.endsWithIgnoreCase(attach,".tmp")){
            Map<String, String> stringStringMap = fileUploadApiService.realUrl(attach);
            attach = stringStringMap.get("realPath");
            param.setUrl(attach);
            videoRespository.insert(param);
        }
        getVidaoQrCode(param);
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

    public Video getVidaoQrCode(Video param) {
        MiniQrcodeParam miniQrcodeParam = new MiniQrcodeParam();
        miniQrcodeParam.setPage("pages/video/video");
        Map<String, String> params = new HashMap<>();
        params.put("albumId", param.getBelongToId());
        params.put("videoId", param.getRecId());
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
            Map<String, Object> generate = miniQrcodeService.generate(miniQrcodeParam);
            Map<String, Object> bizInfo = (Map<String, Object>) generate.get("bizInfo");
            List<Map<String, Object>> models = (List<Map<String, Object>>) bizInfo.get("models");
            Map<String, Object> url = (Map<String, Object>) models.get(0);
            param.setQrCode(String.valueOf(url.get("url")));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return param;
    }

    public List<Video> listSortByOrderNum(Video videoParam, PageInfo pageInfo) {
        Map<String, Object> params = prepareParams(videoParam);
        params.put("startIndex", pageInfo.getCurrentStartIndex());
        params.put("pageSize", pageInfo.getPerPageNum());
        return videoRespository.listSortByOrderNum(params);
    }
}