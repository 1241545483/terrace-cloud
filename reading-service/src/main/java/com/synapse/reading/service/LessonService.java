package com.synapse.reading.service;

import com.synapse.common.constants.PageInfo;
import com.synapse.reading.constants.VideoConstants;
import com.synapse.reading.dto.param.SectionParam;
import com.synapse.reading.dto.param.VideoParam;
import com.synapse.reading.dto.result.SectionResult;
import com.synapse.reading.dto.result.VideoResult;
import com.synapse.reading.model.Lesson;
import com.synapse.reading.model.Section;
import com.synapse.reading.model.Video;
import com.synapse.reading.respository.LessonRespository;
import com.synapse.reading.dto.param.LessonParam;
import com.synapse.reading.dto.result.LessonResult;
import com.synapse.common.utils.DateUtils;
import com.synapse.reading.respository.SectionRespository;
import com.synapse.reading.respository.VideoRespository;
import com.synapse.reading.util.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.synapse.reading.constants.LessonConstants;
import com.synapse.reading.remote.IdService;

import java.util.List;
import java.util.Map;
import java.util.HashMap;




/**
 * <p>
 * 课程 服务实现类
 * </p>
 *
 * @author liuguangfu
 * @since 2019-02-15
 */
@Service
@Transactional
public class LessonService extends LessonBaseService {

	@Autowired
	private IdService idService;

	@Autowired
    private SectionRespository sectionRespository;

    @Autowired
    private LessonRespository lessonRespository;

    @Autowired
    private VideoRespository videoRespository;

    @Autowired
    private  SectionBaseService sectionBaseService;

    @Autowired
    private  VideoBaseService videoBaseService;

    public Lesson find(String recId){
	    return lessonRespository.selectByPrimaryKey(recId);
    }

	public Integer update(Lesson param){
        String now = DateUtils.getNowStr(DateUtils.FORMAT_DATE_TIME);
        param.setUpdateTime(now);
		return lessonRespository.updateByPrimaryKeySelective(param);
    }

    public String create(Lesson param) {
        String now = DateUtils.getNowStr(DateUtils.FORMAT_DATE_TIME);
        param.setRecId(idService.gen("ID"));
		param.setCreateTime(now);
		param.setUpdateTime(now);
		param.setStatus(LessonConstants.STATUS.OK.num());
        lessonRespository.insert(param);
        return param.getRecId();
    }

    /*
     * 1.保存和保存并发布时，前台需要传递是否发布字段(发布为1，不发布为0)
     * 2.创建课程时，视频是已经创建完成，此处只是之间添加进来，若有章节，则需要新建（章节中的视频也是添加进来）
     * 创建课程，若需要章节，则创建，视频是添加进章节或课程
     */
    public String createLesson(Lesson param, List<SectionParam> sectionList,List<VideoParam> videoList ) {
        String now = DateUtils.getNowStr(DateUtils.FORMAT_DATE_TIME);
        param.setRecId(idService.gen("ID"));
        param.setCreateTime(now);
        param.setUpdateTime(now);
        param.setStatus(LessonConstants.STATUS.OK.num());
        lessonRespository.insert(param);
        if (sectionList!=null && !sectionList.isEmpty()){
            for (SectionParam section : sectionList) {
                section.setLessionId(param.getRecId());
                section.setRecId(idService.gen("ID"));
                section.setCreateTime(now);
                section.setUpdateTime(now);
                section.setStatus(LessonConstants.STATUS.OK.num());
                section.setPublishStatus(param.getPublishStatus());
                sectionRespository.insert(section.getModel());
                if (section.getVideoList()!=null && !sectionList.isEmpty()){
                    for (VideoParam video: section.getVideoList()) {
                        video.setBelongTo(VideoConstants.BelongToType.SECTION.value());
                        video.setBelongToId(section.getRecId());
                        videoRespository.updateByPrimaryKeySelective(video.getModel());
                    }
                }
            }
        }
        if (videoList!=null && !videoList.isEmpty()){
                for (VideoParam video: videoList) {
                    video.setBelongTo(VideoConstants.BelongToType.LESSON.value());
                    video.setBelongToId(param.getRecId());
                    videoRespository.updateByPrimaryKeySelective(video.getModel());
                }
        }
        return param.getRecId();
    }


    /*
   * 1.保存和保存并发布时，前台需要传递是否发布字段(发布为1，不发布为0)
   * 2.创建课程时，视频是已经创建完成，此处只是之间添加进来，若有章节，则需要新建（章节中的视频也是添加进来）
   * 创建课程，若需要章节，则创建，视频是添加进章节或课程
   */
    public String updateLesson(Lesson param, List<SectionParam> sectionList,List<VideoParam> videoList ) {
        String now = DateUtils.getNowStr(DateUtils.FORMAT_DATE_TIME);
        param.setUpdateTime(now);
        param.setStatus(LessonConstants.STATUS.OK.num());
        lessonRespository.updateByPrimaryKeySelective(param);
        if (sectionList!=null && !sectionList.isEmpty()){
            for (SectionParam section : sectionList) {
                section.setLessionId(param.getRecId());
                section.setUpdateTime(now);
                section.setStatus(LessonConstants.STATUS.OK.num());
                section.setPublishStatus(param.getPublishStatus());
                if (section.getModel().getRecId()!=null&&!"".equals(section.getModel().getRecId())){
                    sectionRespository.updateByPrimaryKeySelective(section.getModel());
                }else {
                    section.setRecId(idService.gen("ID"));
                    section.setCreateTime(now);
                    sectionRespository.insert(section.getModel());
                }
                if (section.getVideoList()!=null && !sectionList.isEmpty()){
                    for (VideoParam video: section.getVideoList()) {
                        video.setBelongTo(VideoConstants.BelongToType.SECTION.value());
                        video.setBelongToId(section.getRecId());
                        videoRespository.updateByPrimaryKeySelective(video.getModel());
                    }
                }
            }
        } else if (videoList!=null && !videoList.isEmpty()){
            for (VideoParam video: videoList) {
                video.setBelongTo(VideoConstants.BelongToType.LESSON.value());
                video.setBelongToId(param.getRecId());
                videoRespository.updateByPrimaryKeySelective(video.getModel());
            }
        }
        return param.getRecId();
    }


    public LessonResult getLesson(String recId){
        Section model = new Section();
        model.setLessionId(recId);
        model.setStatus("1");
        Map<String,Object> params =sectionBaseService.prepareParams(model);
        List<Section> sectionList= sectionRespository.list(params);
        Video video = new Video();
        video.setBelongToId(recId);
        Map<String,Object> videoParams1 =videoBaseService.prepareParams(video);
        List<Video> videoList1 = videoRespository.list(videoParams1);
        LessonResult lessonResult = new LessonResult();
        if (sectionList!=null && !sectionList.isEmpty()){
            List<SectionResult>  sectionResultList =Converter.convert(sectionList,SectionResult.class);
            for (SectionResult section : sectionResultList) {
                video.setBelongToId(section.getRecId());
                Map<String,Object> videoParams =videoBaseService.prepareParams(video);
                List<Video> videoList = videoRespository.list(videoParams);
                section.setVideoList(videoList);
            }
            lessonResult.setSectionList(sectionList);
        }else if (videoList1!=null && !videoList1.isEmpty()){
            lessonResult.setVideoList(videoList1);
        }
        return lessonResult;
    }

    public Integer deleteAll(String recId, String updateId) {
        String now = DateUtils.getNowStr(DateUtils.FORMAT_DATE_TIME);
        Lesson model = new Lesson();
        model.setRecId(recId);
        model.setUpdateId(updateId);
        model.setUpdateTime(now);
        model.setStatus(LessonConstants.STATUS.DELETED.num());
        Video video = new Video();
        video.setBelongToId(recId);
        video.setUpdateId(updateId);
        video.setUpdateTime(now);
        Map<String,Object> videoParams1 =videoBaseService.prepareParams(video);
        List<Video> videoList1 = videoRespository.list(videoParams1);
        if (videoList1!=null && !videoList1.isEmpty()){
            for (Video video1 : videoList1) {
                video1.setBelongToId("");
                video1.setBelongTo("");
                videoRespository.updateByPrimaryKeySelective(video1);
            }
        }
        Section section1 = new Section();
        section1.setLessionId(recId);
        section1.setStatus("1");
        Map<String,Object> params =sectionBaseService.prepareParams(section1);
        List<Section> sectionList= sectionRespository.list(params);
        if (sectionList!=null && !sectionList.isEmpty()){
            for (Section section : sectionList) {
                video.setBelongToId(section.getRecId());
                Map<String,Object> videoParams2 =videoBaseService.prepareParams(video);
                List<Video> videoList2 = videoRespository.list(videoParams2);
                if (videoList2!=null && !videoList2.isEmpty()){
                    for (Video video2 : videoList2) {
                        video2.setBelongToId("");
                        video2.setBelongTo("");
                        videoRespository.updateByPrimaryKeySelective(video2);
                    }
                }
            }
        }
        section1.setLessionId(recId);
        section1.setUpdateId(updateId);
        section1.setUpdateTime(now);
        section1.setStatus(LessonConstants.STATUS.DELETED.num());
        sectionRespository.updateByPrimaryKeySelective(section1);
        return lessonRespository.updateByPrimaryKeySelective(model);
    }




	public Integer delete(String recId, String updateId) {
        String now = DateUtils.getNowStr(DateUtils.FORMAT_DATE_TIME);
        Lesson model = new Lesson();
        model.setRecId(recId);
        model.setUpdateId(updateId);
        model.setUpdateTime(now);
        model.setStatus(LessonConstants.STATUS.DELETED.num());
        return lessonRespository.updateByPrimaryKeySelective(model);
    }

	public List<Lesson> list(Lesson lessonParam, PageInfo pageInfo) {
		lessonParam.setStatus(LessonConstants.STATUS.OK.num());
        Map<String,Object> params = prepareParams(lessonParam);
        params.put("startIndex", pageInfo.getCurrentStartIndex());
        params.put("pageSize", pageInfo.getPerPageNum());
        return lessonRespository.list(params);
	}

	public Integer count(Lesson lessonParam) {
		lessonParam.setStatus(LessonConstants.STATUS.OK.num());
        Map<String,Object> params = prepareParams(lessonParam);
        return lessonRespository.count(params);
    }

}