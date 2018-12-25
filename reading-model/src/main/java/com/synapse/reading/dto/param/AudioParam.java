package com.synapse.reading.dto.param;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.synapse.reading.model.Audio;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

import com.synapse.reading.web.valid.group.Update;
import com.synapse.reading.web.valid.group.Create;
import com.synapse.reading.web.valid.group.Search;

/**
 * <p>
 * AudioParam
 * </p>
 *
 * @author wangyifan
 * @since 2018-11-24
 */
@ApiModel(value = "AudioParam对象", description = "音频")
public class AudioParam {
    public String getIntro() {
        return audio.getIntro();
    }

    public void setIntro(String intro) {
        audio.setIntro(intro);
    }

    public String getCover() {
        return audio.getCover();
    }

    public void setCover(String cover) {
        audio.setCover(cover);
    }

    public String getQrCode() {
        return audio.getQrCode();
    }

    public void setQrCode(String qrCode) {
        audio.setQrCode(qrCode);
    }

    private Audio audio = new Audio();

    public AudioParam() {
    }

    public Long getFinishNum() {
        return audio.getFinishNum();
    }

    public void setFinishNum(Long finishNum) {
        audio.setFinishNum(finishNum);
    }

    public AudioParam(Audio audio) {
        this.audio = audio;
    }

    @JsonIgnore
    public Audio getModel() {
        return audio;
    }

    public void setModel(Audio audio) {
        this.audio = audio;
    }

    public Integer getOrderNum() {
        return audio.getOrderNum();
    }

    public void setOrderNum(Integer orderNum) {
        audio.setOrderNum(orderNum);
    }

    @ApiModelProperty(value = "")
    public String getRecId() {
        return audio.getRecId();
    }

    public void setRecId(String rec_id) {
        audio.setRecId(rec_id);
    }

    @ApiModelProperty(value = "")
    public String getName() {
        return audio.getName();
    }

    public void setName(String name) {
        audio.setName(name);
    }

    @ApiModelProperty(value = "")
    public String getUrl() {
        return audio.getUrl();
    }

    public void setUrl(String url) {
        audio.setUrl(url);
    }

    @ApiModelProperty(value = "album 专辑，book书籍")
    public String getBelongTo() {
        return audio.getBelongTo();
    }

    public void setBelongTo(String belong_to) {
        audio.setBelongTo(belong_to);
    }

    @ApiModelProperty(value = "专辑或书籍主键")
    public String getBelongToId() {
        return audio.getBelongToId();
    }

    public void setBelongToId(String belong_to_id) {
        audio.setBelongToId(belong_to_id);
    }

    @ApiModelProperty(value = "")
    public Long getPlayNum() {
        return audio.getPlayNum();
    }

    public void setPlayNum(Long play_num) {
        audio.setPlayNum(play_num);
    }

    @ApiModelProperty(value = "")
    public String getCreateId() {
        return audio.getCreateId();
    }

    public void setCreateId(String create_id) {
        audio.setCreateId(create_id);
    }

    @ApiModelProperty(value = "")
    public String getCreateTime() {
        return audio.getCreateTime();
    }

    public void setCreateTime(String create_time) {
        audio.setCreateTime(create_time);
    }

    @ApiModelProperty(value = "")
    public String getUpdateId() {
        return audio.getUpdateId();
    }

    public void setUpdateId(String update_id) {
        audio.setUpdateId(update_id);
    }

    @ApiModelProperty(value = "")
    public String getUpdateTime() {
        return audio.getUpdateTime();
    }

    public void setUpdateTime(String update_time) {
        audio.setUpdateTime(update_time);
    }

}
