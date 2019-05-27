package com.synapse.reading.service;

import com.google.gson.Gson;
import com.synapse.common.constants.PageInfo;
import com.synapse.common.sso.model.User;
import com.synapse.common.trans.Result;
import com.synapse.reading.constants.AudioConstants;
import com.synapse.reading.constants.LessonConstants;
import com.synapse.reading.constants.VideoConstants;
import com.synapse.reading.dto.param.*;
import com.synapse.reading.dto.result.LessonResult;
import com.synapse.reading.dto.result.SectionResult;
import com.synapse.reading.model.*;
import com.synapse.reading.remote.FileUploadApiService;
import com.synapse.reading.remote.ShortLinkApiService;
import com.synapse.reading.respository.AudioRespository;
import com.synapse.reading.respository.BookRespository;
import com.synapse.reading.dto.result.BookResult;
import com.synapse.common.utils.DateUtils;
import com.synapse.reading.respository.VideoRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.synapse.reading.constants.BookConstants;
import com.synapse.reading.remote.IdService;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.stream.Collectors;


/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author liuguangfu
 * @since 2018-12-27
 */
@Service
@Transactional
public class BookService extends BookBaseService {

    @Autowired
    private IdService idService;

    @Autowired
    private BookRespository bookRespository;
    @Autowired
    private MiniQrcodeService miniQrcodeService;

    @Autowired
    private ShortLinkApiService shortLinkApiService;

    @Autowired
    private FileUploadApiService fileUploadApiService;

    @Autowired
    private Gson gson;

    @Autowired
    private VideoRespository videoRespository;

    @Autowired
    private AudioRespository audioRespository;

    @Autowired
    private VideoBaseService videoBaseService;

    @Autowired
    private AudioBaseService audioBaseService;

    public Book find(String recId) {
        return bookRespository.selectByPrimaryKey(recId);
    }

    public Integer update(Book param) {
        String now = DateUtils.getNowStr(DateUtils.FORMAT_DATE_TIME);
        param.setUpdateTime(now);
        Book par = find(param.getRecId());
        if (par.getQrCode() == null || "".equals(par.getQrCode().trim())) {
            param = getVidaoQrCode(param);
        }
        return bookRespository.updateByPrimaryKeySelective(param);
    }

    public String create(Book param) {
        String now = DateUtils.getNowStr(DateUtils.FORMAT_DATE_TIME);
        param.setRecId(idService.gen("ID"));
        param.setCreateTime(now);
        param.setUpdateTime(now);
        param.setStatus(BookConstants.STATUS.OK.num());
        getVidaoQrCode(param);
        bookRespository.insert(param);
        return param.getRecId();
    }

    public Integer delete(String recId, String updateId) {
        String now = DateUtils.getNowStr(DateUtils.FORMAT_DATE_TIME);
        Book model = new Book();
        model.setRecId(recId);
        model.setUpdateId(updateId);
        model.setUpdateTime(now);
        model.setStatus(BookConstants.STATUS.DELETED.num());
        return bookRespository.updateByPrimaryKeySelective(model);
    }

    public List<Book> list(Book bookParam, PageInfo pageInfo) {
        bookParam.setStatus(BookConstants.STATUS.OK.num());
        Map<String, Object> params = prepareParams(bookParam);
        params.put("startIndex", pageInfo.getCurrentStartIndex());
        params.put("pageSize", pageInfo.getPerPageNum());
        return bookRespository.list(params);
    }


    public Integer count(Book bookParam) {
        bookParam.setStatus(BookConstants.STATUS.OK.num());
        Map<String, Object> params = prepareParams(bookParam);
        return bookRespository.count(params);
    }

    public List<BookResult> listMyCollectByBook(User user) {
        String userId = user.getRecId();
        return bookRespository.listMyCollectByBook(userId);
    }

    /*
        修改专辑为发布状态
        */
    public boolean bookPublished(String recId) {
        return bookRespository.bookPublished(recId) > 0;
    }

    /*
    修改专辑为未发布状态
    */
    public boolean bookUnPublished(String recId) {
        return bookRespository.bookUnPublished(recId) > 0;
    }

    public BookResult selectIsCollect(String recId, User user) {

        return bookRespository.selectIsCollect(user.getRecId(), recId);
    }

    public Book getVidaoQrCode(Book param) {
        MiniQrcodeParam miniQrcodeParam = new MiniQrcodeParam();
        miniQrcodeParam.setPage("pages/book/index");
        Map<String, String> params = new HashMap<>();
        params.put("bookId", param.getRecId());
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
//            Map<String, Object> bizInfo = (Map<String, Object>) generate.get("bizInfo");
//            List<Map<String, Object>> models = (List<Map<String, Object>>) bizInfo.get("models");
//            Map<String, Object> url = (Map<String, Object>) models.get(0);
            param.setQrCode(generate);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return param;
    }

    /*
    * 创建书籍，已创建完成的音频和视频添加进书籍
    */
    public String createBook(Book param, List<AudioParam> audioList, List<VideoParam> videoList) {
        String now = DateUtils.getNowStr(DateUtils.FORMAT_DATE_TIME);
        param.setRecId(idService.gen("ID"));
        param.setCreateTime(now);
        param.setUpdateTime(now);
        param.setStatus(LessonConstants.STATUS.OK.num());
        bookRespository.insert(param);
        if (audioList != null && !audioList.isEmpty()) {
            for (AudioParam audio : audioList) {
                audio.setBelongTo(AudioConstants.BelongToType.BOOK.value());
                audio.setBelongToId(param.getRecId());
                audioRespository.updateByPrimaryKeySelective(audio.getModel());
            }
        }
        if (videoList != null && !videoList.isEmpty()) {
            for (VideoParam video : videoList) {
                video.setBelongTo(VideoConstants.BelongToType.BOOK.value());
                video.setBelongToId(param.getRecId());
                videoRespository.updateByPrimaryKeySelective(video.getModel());
            }
        }
        return param.getRecId();
    }

    /*
    后台更新书籍详情
     */
    public String updateBook(Book param, List<AudioParam> audioList, List<VideoParam> videoList) {
        String now = DateUtils.getNowStr(DateUtils.FORMAT_DATE_TIME);
        param.setUpdateTime(now);
        param.setStatus(LessonConstants.STATUS.OK.num());
        bookRespository.updateByPrimaryKeySelective(param);
        if (audioList != null && !audioList.isEmpty()) {
            for (AudioParam audio : audioList) {
                audio.setBelongTo(AudioConstants.BelongToType.BOOK.value());
                audio.setBelongToId(param.getRecId());
                audioRespository.updateByPrimaryKeySelective(audio.getModel());
            }
        }
        if (videoList != null && !videoList.isEmpty()) {
            for (VideoParam video : videoList) {
                video.setBelongTo(VideoConstants.BelongToType.BOOK.value());
                video.setBelongToId(param.getRecId());
                videoRespository.updateByPrimaryKeySelective(video.getModel());
            }
        }
        return param.getRecId();
    }

    /*
    后台查询书籍详情
     */
    public BookResult getBook(String recId) {

        Video video = new Video();
        video.setBelongToId(recId);
        Map<String, Object> videoParams = videoBaseService.prepareParams(video);
        List<Video> videoList = videoRespository.list(videoParams);
        Audio audio = new Audio();
        audio.setBelongToId(recId);
        Map<String, Object> audioParams = audioBaseService.prepareParams(audio);
        List<Audio> audioList = audioRespository.list(audioParams);
        BookResult bookResult = new BookResult();
        Book book = bookRespository.selectByPrimaryKey(recId);
        bookResult.setModel(book);
        if (videoList != null && !videoList.isEmpty()) {
            bookResult.setVideoList(videoList);
        }
        if (audioList != null && !audioList.isEmpty()) {
            bookResult.setAudioList(audioList);
        }
        return bookResult;
    }

    public Integer deleteAll(String recId, String updateId) {
        String now = DateUtils.getNowStr(DateUtils.FORMAT_DATE_TIME);
        Book model = new Book();
        model.setRecId(recId);
        model.setUpdateId(updateId);
        model.setUpdateTime(now);
        model.setStatus(LessonConstants.STATUS.DELETED.num());
        videoRespository.changeBelongToIdAndBelongTo(recId);
        audioRespository.changeBelongToIdAndBelongTo(recId);
        return bookRespository.updateByPrimaryKeySelective(model);
    }




}