package com.synapse.reading.service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.synapse.common.constants.PageInfo;
import com.synapse.common.sso.model.User;
import com.synapse.common.utils.DateUtils;
import com.synapse.reading.mapper.ShareImageMapper;
import com.synapse.reading.model.*;
import com.synapse.reading.remote.IdService;
import com.synapse.reading.respository.ShareImageRespository;
import com.synapse.reading.util.ImgUtil;
import org.apache.ibatis.javassist.ClassPath;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.net.URL;
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
    @Autowired
    private VideoService videoService;
    @Autowired
    private BookService bookService;
    @Autowired
    private IssueService issueService;
    @Autowired
    private LessonService lessonService;
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

    public Integer deleteByUserId(String userId, String belongToId) {
        return shareImageRespository.deleteByUserId(userId, belongToId);
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

    public String getShareUrl(String id, User user, String shareType) throws IOException {
        ShareImage shareImageParam = new ShareImage();
        Map<String, Object> params = prepareParams(shareImageParam);
        params.put("userId", user.getRecId());
        params.put("shareType", shareType);
        params.put("shareId", id);
        if (shareImageRespository.count(params) > 0) {
            return shareImageRespository.list(params).get(0).getUrl();
        } else {
            if ("audio".equals(shareType)) {
                Audio audio = audioService.find(id);
                ClassPathResource classPath = new ClassPathResource("/imgs/audioModelUrl.png");
//                InputStream modelUrl = classPath.getInputStream();
                BufferedImage modelUrl = ImageIO.read(classPath.getInputStream());
                BufferedImage url = null;
                if (!"".equals(audio.getCover()) && audio.getCover() != null) {
                    URL audioModelCover = new URL(audio.getCover());
                    url = ImageIO.read(audioModelCover);
                } else {
                    ClassPathResource urlClassPath = new ClassPathResource("/imgs/audioModelCover.png");
                    url = ImageIO.read(urlClassPath.getInputStream());
                }
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
                //    param.setRecId("66");
                param.setCreateTime(now);
                param.setShareId(id);
                param.setShareType(shareType);
                param.setUrl(shareUrl);
                param.setUserId(user.getRecId());
                param.setCreateId(user.getRecId());
                shareImageMapper.insertSelective(param);
            }
            if ("bookAudio".equals(shareType)) {
                Audio audio = audioService.find(id);
                ClassPathResource classPath = new ClassPathResource("/imgs/audioModelUrl.png");
//                InputStream modelUrl = classPath.getInputStream();
                BufferedImage modelUrl = ImageIO.read(classPath.getInputStream());
                BufferedImage url = null;
                if (!"".equals(audio.getCover()) && audio.getCover() != null) {
                    URL audioModelCover = new URL(audio.getCover());
                    url = ImageIO.read(audioModelCover);
                } else {
                    ClassPathResource urlClassPath = new ClassPathResource("/imgs/audioModelCover.png");
                    url = ImageIO.read(urlClassPath.getInputStream());
                }
                String qrcodeUrl = audio.getQrCode();
                String wxNickName = user.getUsername();
                String solgan = bookService.find(audio.getBelongToId()).getSlogan();
                String albumName = bookService.find(audio.getBelongToId()).getName();
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
                //    param.setRecId("66");
                param.setCreateTime(now);
                param.setShareId(id);
                param.setShareType(shareType);
                param.setUrl(shareUrl);
                param.setUserId(user.getRecId());
                param.setCreateId(user.getRecId());
                shareImageMapper.insertSelective(param);
            }
            if ("book".equals(shareType)) {
                Book book = bookService.find(id);
                ClassPathResource classPath = new ClassPathResource("/imgs/bookModelUrl.png");
                BufferedImage modelUrl = ImageIO.read(classPath.getInputStream());
                ClassPathResource classPathDropUrl = new ClassPathResource("/imgs/bookBackdropUrl.png");
                BufferedImage backdropUrl = ImageIO.read(classPathDropUrl.getInputStream());
                BufferedImage url = null;
                if (!"".equals(book.getCover()) && book.getCover() != null) {
                    URL audioModelCover = new URL(book.getCover());
                    url = ImageIO.read(audioModelCover);
                } else {
                    ClassPathResource urlClassPath = new ClassPathResource("/imgs/bookModelCover.png");
                    url = ImageIO.read(urlClassPath.getInputStream());
                }
                String qrcodeUrl = book.getQrCode();
                String wxNickName = user.getUsername();
                String solgan = book.getSlogan();
                String bookName = book.getName();
                Path tempPng = ImgUtil.DrawSuccessPosterByBook(modelUrl, url, qrcodeUrl, wxNickName, solgan, bookName, backdropUrl);
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
                //    param.setRecId("66");
                param.setCreateTime(now);
                param.setShareId(id);
                param.setShareType(shareType);
                param.setUrl(shareUrl);
                param.setUserId(user.getRecId());
                param.setCreateId(user.getRecId());
                shareImageMapper.insertSelective(param);
            }
            return shareImageRespository.list(params).get(0).getUrl();
        }

    }

    public String getLessonShareUrl(String id, User user, String shareType) throws IOException {
        ShareImage shareImageParam = new ShareImage();
        Map<String, Object> params = prepareParams(shareImageParam);
        params.put("userId", user.getRecId());
        params.put("shareType", shareType);
        params.put("shareId", id);
        if (shareImageRespository.count(params) > 0) {
            return shareImageRespository.list(params).get(0).getUrl();
        } else {
            if ("lesson".equals(shareType)) {
                Lesson lesson = lessonService.find(id);
                String modelUrl = lesson.getImage();
                String qrcodeUrl = lesson.getQrCode();
                String wxNickName = user.getUsername();
                Path tempPng = ImgUtil.DrawSuccessPosterByLesson(modelUrl,  qrcodeUrl, wxNickName);
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
                //    param.setRecId("66");
                param.setCreateTime(now);
                param.setShareId(id);
                param.setShareType(shareType);
                param.setUrl(shareUrl);
                param.setUserId(user.getRecId());
                param.setCreateId(user.getRecId());
                shareImageMapper.insertSelective(param);
            }
            return shareImageRespository.list(params).get(0).getUrl();
        }

    }

    public String getIssueShareUrl(User user, String shareType, String belongTo, String belongToId) throws IOException {
        ShareImage shareImageParam = new ShareImage();
        Map<String, Object> params = prepareParams(shareImageParam);
        params.put("userId", user.getRecId());
        params.put("shareType", shareType);
        params.put("shareId", belongToId);
        if (shareImageRespository.count(params) > 0) {
            return shareImageRespository.list(params).get(0).getUrl();
        } else {
            if ("issue".equals(shareType)) {
                Book book = bookService.find(belongToId);
                ClassPathResource classPath = new ClassPathResource("/imgs/issueModelUrl.png");
                BufferedImage modelUrl = ImageIO.read(classPath.getInputStream());
                ClassPathResource classPathDropUrl = new ClassPathResource("/imgs/logo.png");
                BufferedImage logoUrl = ImageIO.read(classPathDropUrl.getInputStream());
                String qrcodeUrl = book.getQrCode();
                String wxNickName = user.getUsername();
                String bookName = book.getName();
                int rightNum = issueService.selectCountByUserId(user, belongToId, belongTo);
                int starNum = (int) issueService.selectScoreByUserId(user, belongToId, belongTo);
//                String slognName ="在"+bookName+"习题闯关中答对"+rightNum+"题，获取"+starNum+"颗星";
                ClassPathResource classPathStarUrl = new ClassPathResource("/imgs/star/" + starNum + ".png");
                BufferedImage starUrl = ImageIO.read(classPathStarUrl.getInputStream());
                Path tempPng = ImgUtil.DrawSuccessPosterByIssue(modelUrl, logoUrl, qrcodeUrl, starUrl, wxNickName, bookName, rightNum, starNum);
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
                //    param.setRecId("66");
                param.setCreateTime(now);
                param.setShareId(belongToId);
                param.setShareType(shareType);
                param.setUrl(shareUrl);
                param.setUserId(user.getRecId());
                param.setCreateId(user.getRecId());
                shareImageMapper.insertSelective(param);
            }
            return shareImageRespository.list(params).get(0).getUrl();
        }

    }
}