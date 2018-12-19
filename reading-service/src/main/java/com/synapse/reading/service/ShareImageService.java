package com.synapse.reading.service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.synapse.common.constants.PageInfo;
import com.synapse.common.sso.model.User;
import com.synapse.common.utils.DateUtils;
import com.synapse.reading.mapper.ShareImageMapper;
import com.synapse.reading.model.Audio;
import com.synapse.reading.model.ShareImage;
import com.synapse.reading.remote.IdService;
import com.synapse.reading.respository.ShareImageRespository;
import com.synapse.reading.util.ImgUtil;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;


/**
 * <p>
 * 分享图片 服务实现类
 * </p>
 *
 * @author liuguangfu
 * @since 2018-12-14
 */
@Service
@Transactional
public class ShareImageService extends ShareImageBaseService {

    @Autowired
    private IdService idService;

    @Autowired
    private ShareImageRespository shareImageRespository;
    @Autowired
    private AudioService audioService;
    @Autowired
    private AlbumService albumService;
    @Autowired
    private ShareImageMapper shareImageMapper;
    @Autowired
    private MiniQrcodeService miniQrcodeService;


    protected static org.slf4j.Logger logger = LoggerFactory.getLogger(ShareImageService.class);

    public ShareImage find(String recId) {
        return shareImageRespository.selectByPrimaryKey(recId);
    }

    public Integer update(ShareImage param) {
        String now = DateUtils.getNowStr(DateUtils.FORMAT_DATE_TIME);
        param.setUpdateTime(now);
        return shareImageRespository.updateByPrimaryKeySelective(param);
    }

    public String create(ShareImage param) {
        String now = DateUtils.getNowStr(DateUtils.FORMAT_DATE_TIME);
        param.setRecId(idService.gen("ID"));
        param.setCreateTime(now);
        param.setUpdateTime(now);
        shareImageRespository.insert(param);
        return param.getRecId();
    }

    public Integer delete(String recId) {
        return shareImageRespository.deleteByPrimaryKey(recId);
    }

    public List<ShareImage> list(ShareImage shareImageParam, PageInfo pageInfo) {
        Map<String, Object> params = prepareParams(shareImageParam);
        params.put("startIndex", pageInfo.getCurrentStartIndex());
        params.put("pageSize", pageInfo.getPerPageNum());
        return shareImageRespository.list(params);
    }

    public Integer count(ShareImage shareImageParam) {
        Map<String, Object> params = prepareParams(shareImageParam);
        return shareImageRespository.count(params);
    }

    public String getShareUrl(String id, User user) throws IOException {
        String shareType = "audio";
        ShareImage shareImageParam = new ShareImage();
        Map<String, Object> params = prepareParams(shareImageParam);
        params.put("userId", user.getRecId());
        params.put("shareType", shareType);
        params.put("shareId", id);
        if (shareImageRespository.count(params) > 0) {
            return shareImageRespository.selectByShareTypeAndUserId(user.getRecId(), shareType).getUrl();
        } else {
            if ("audio".equals(shareType)) {
                Audio audio = audioService.find(id);
                String modelUrl = "http://img.jssns.cn/SHILU/1/b2572a8da5d47d586a04cae64168b649.png";
                String url = audio.getCover();
                String qrcodeUrl = audio.getQrCode();
                String wxNickName = user.getUsername();
                String solgan = albumService.find(audio.getBelongToId()).getSlogan();
                String albumName = albumService.find(audio.getBelongToId()).getName();
                String audioName = audio.getName();
                Path tempPng = ImgUtil.DrawSuccessPoster(modelUrl, url, qrcodeUrl, wxNickName, solgan, albumName, audioName);
                FileInputStream fis = new FileInputStream(tempPng.toFile());
                String infos = miniQrcodeService.inputStreamUpload(fis, "shareUrl.png");
                Gson gson = new Gson();
                Type memberType = new TypeToken<Map<String, Object>>() {
                }.getType();
                Map<String, Map<String, List<Map<String, String>>>> map = gson.fromJson(infos, memberType);
                String shareUrl = map.get("bizInfo").get("models").get(0).get("url");
                String now = DateUtils.getNowStr(DateUtils.FORMAT_DATE_TIME);
                ShareImage param = new ShareImage();
                param.setRecId(idService.gen("ID"));
                // param.setRecId("66");
                param.setCreateTime(now);
                param.setShareId(id);
                param.setShareType(shareType);
                param.setUrl(shareUrl);
                param.setUserId(user.getRecId());
                param.setCreateId(user.getRecId());
                shareImageMapper.insertSelective(param);


            }
            return shareImageRespository.selectByShareTypeAndUserId(user.getRecId(), shareType).getUrl();
        }

    }

}