package com.synapse.reading.dto.result;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.synapse.common.ann.DictFormat;
import com.synapse.reading.dto.param.AudioParam;
import com.synapse.reading.model.Album;
import com.synapse.reading.model.Audio;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * AlbumResult
 * </p>
 *
 * @author wangyifan
 * @since 2018-11-20
 */
@ApiModel(value = "AlbumResult对象", description = "")
public class AlbumResult {

    private Album album = new Album();

    private List<Audio> audioList = new ArrayList<>();// 子列表

    public List<Audio> getAudioList() {
        return audioList;
    }

    public void setAudioList(List<Audio> audioList) {
        this.audioList = audioList;
    }

    public AlbumResult() {
    }

    public String getBanner() {
        return album.getBanner();
    }

    public void setBanner(String banner) {
        album.setBanner(banner);
    }

    public AlbumResult(Album album) {
        if (album != null) {
            this.album = album;
        }
    }

    @JsonIgnore
    public Album getModel() {
        return album;
    }

    public void setModel(Album album) {
        this.album = album;
    }

    @ApiModelProperty(value = "")
    public String getRecId() {
        return album.getRecId();
    }

    public void setRecId(String rec_id) {
        album.setRecId(rec_id);
    }

    @ApiModelProperty(value = "")
    public String getName() {
        return album.getName();
    }

    public void setName(String name) {
        album.setName(name);
    }

    @ApiModelProperty(value = "")
    public String getIntro() {
        return album.getIntro();
    }

    public void setIntro(String intro) {
        album.setIntro(intro);
    }

    @ApiModelProperty(value = "1 音频，2视频，3 书籍，4音频+视频，5音频+书籍，6视频+书籍，7音频+视频+书籍")
    @DictFormat(type = "ALBUM_TYPE", field = "typeTxt")
    public String getType() {
        return album.getType();
    }

    public void setType(String type) {
        album.setType(type);
    }

    public Integer getOrderNum() {
        return album.getOrderNum();
    }

    public void setOrderNum(Integer orderNum) {
        album.setOrderNum(orderNum);
    }

    @ApiModelProperty(value = "封面图片URL")
    public String getCover() {
        return album.getCover();
    }

    public void setCover(String cover) {
        album.setCover(cover);
    }

    public String getSlogan() {
        return album.getSlogan();
    }

    public void setSlogan(String slogan) {
        album.setSlogan(slogan);
    }

    @ApiModelProperty(value = "0 未发布，1已发布")
    @DictFormat(type = "ALBUM_TYPE", field = "typeTxt")
    public String getPublishStatus() {
        return album.getPublishStatus();
    }

    public void setPublishStatus(String publish_status) {
        album.setPublishStatus(publish_status);
    }

    @ApiModelProperty(value = "0 删除，1正常")
    @DictFormat(type = "ALBUM_TYPE", field = "typeTxt")
    public String getStatus() {
        return album.getStatus();
    }

    public void setStatus(String status) {
        album.setStatus(status);
    }

    @ApiModelProperty(value = "")
    public Long getVisitNum() {
        return album.getVisitNum();
    }

    public void setVisitNum(Long visit_num) {
        album.setVisitNum(visit_num);
    }

    @ApiModelProperty(value = "")
    public String getCreateId() {
        return album.getCreateId();
    }

    public void setCreateId(String create_id) {
        album.setCreateId(create_id);
    }

    @ApiModelProperty(value = "")
    public String getCreateTime() {
        return album.getCreateTime();
    }

    public void setCreateTime(String create_time) {
        album.setCreateTime(create_time);
    }

    @ApiModelProperty(value = "")
    public String getUpdateId() {
        return album.getUpdateId();
    }

    public void setUpdateId(String update_id) {
        album.setUpdateId(update_id);
    }

    @ApiModelProperty(value = "")
    public String getUpdateTime() {
        return album.getUpdateTime();
    }

    public void setUpdateTime(String update_time) {
        album.setUpdateTime(update_time);
    }

    public String getTag() {
        return album.getTag();
    }

    public void setTag(String tag) {
        album.setTag(tag);
    }

    public String getSimpleIntro() {
        return album.getSimpleIntro();
    }

    public void setSimpleIntro(String simpleIntro) {
        album.setSimpleIntro(simpleIntro);
    }

    public String getTopicId() {
        return album.getTopicId();
    }

    public void setTopicId(String topicId) {
        album.setTopicId(topicId);
    }

    public String getPcCover() {
        return album.getPcCover();
    }

    public void setPcCover(String pcCover) {
        album.setPcCover(pcCover);
    }

    public String getPcBanner() {
        return album.getPcBanner();
    }

    public void setPcBanner(String pcBanner) {
        album.setPcBanner(pcBanner);
    }
}
