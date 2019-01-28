package com.synapse.reading.dto.param;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.synapse.reading.model.Video;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

import com.synapse.reading.web.valid.group.Update;
import com.synapse.reading.web.valid.group.Create;
import com.synapse.reading.web.valid.group.Search;

/**
 * <p>
 * VideoParam
 * </p>
 *
 * @author wangyifan
 * @since 2018-11-24
 */
@ApiModel(value = "VideoParam对象", description = "视频")
public class VideoParam {
    public String getIntro() {
        return video.getIntro();
    }

    public void setIntro(String intro) {
        video.setIntro(intro);
    }

    private Video video = new Video();

    public String getPcCover() {
        return video.getPcCover();
    }

    public void setPcCover(String pcCover) {
        video.setPcCover(pcCover);
    }

    public VideoParam() {
    }

    public VideoParam(Video video) {
        this.video = video;
    }

    @JsonIgnore
    public Video getModel() {
        return video;
    }

    public String getTag() {
        return video.getTag();
    }

    public void setTag(String tag) {
        video.setTag(tag);
    }

    public Long getFinishNum() {
        return video.getFinishNum();
    }

    public void setFinishNum(Long finishNum) {
        video.setFinishNum(finishNum);
    }

    public void setModel(Video video) {
        this.video = video;
    }

    public String getCover() {
        return video.getCover();
    }

    public void setCover(String cover) {
        video.setCover(cover);
    }

    public Integer getOrderNum() {
        return video.getOrderNum();
    }

    public void setOrderNum(Integer orderNum) {
        video.setOrderNum(orderNum);
    }

    public String getQrCode() {
        return video.getQrCode();
    }

    public void setQrCode(String qrCode) {
        video.setQrCode(qrCode);
    }

    @ApiModelProperty(value = "")
    public String getRecId() {
        return video.getRecId();
    }

    public void setRecId(String rec_id) {
        video.setRecId(rec_id);
    }

    @ApiModelProperty(value = "")
    public String getName() {
        return video.getName();
    }

    public void setName(String name) {
        video.setName(name);
    }

    @ApiModelProperty(value = "")
    public String getUrl() {
        return video.getUrl();
    }

    public void setUrl(String url) {
        video.setUrl(url);
    }

    @ApiModelProperty(value = "album 专辑，book书籍")
    public String getBelongTo() {
        return video.getBelongTo();
    }

    public void setBelongTo(String belong_to) {
        video.setBelongTo(belong_to);
    }

    @ApiModelProperty(value = "专辑或书籍主键")
    public String getBelongToId() {
        return video.getBelongToId();
    }

    public void setBelongToId(String belong_to_id) {
        video.setBelongToId(belong_to_id);
    }

    @ApiModelProperty(value = "")
    public Long getPlayNum() {
        return video.getPlayNum();
    }

    public void setPlayNum(Long play_num) {
        video.setPlayNum(play_num);
    }

    @ApiModelProperty(value = "")
    public String getCreateId() {
        return video.getCreateId();
    }

    public void setCreateId(String create_id) {
        video.setCreateId(create_id);
    }

    @ApiModelProperty(value = "")
    public String getCreateTime() {
        return video.getCreateTime();
    }

    public void setCreateTime(String create_time) {
        video.setCreateTime(create_time);
    }

    @ApiModelProperty(value = "")
    public String getUpdateId() {
        return video.getUpdateId();
    }

    public void setUpdateId(String update_id) {
        video.setUpdateId(update_id);
    }

    @ApiModelProperty(value = "")
    public String getUpdateTime() {
        return video.getUpdateTime();
    }

    public void setUpdateTime(String update_time) {
        video.setUpdateTime(update_time);
    }

}
