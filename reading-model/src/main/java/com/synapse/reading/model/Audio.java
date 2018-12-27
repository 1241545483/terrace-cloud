package com.synapse.reading.model;

import java.util.Date;
import java.io.Serializable;


/**
 * <p>
 * 音频
 * </p>
 *
 * @author liuguangfu
 * @since 2018-12-27
 */
public class Audio implements Serializable {

    private static final long serialVersionUID = 1L;

    private String recId;
    private String name;
    private String url;
    private String intro;
    private String qrCode;
    /**
     * 封面图片URL
     */
    private String cover;
    /**
     * album 专辑，book书籍
     */
    private String belongTo;
    /**
     * 专辑或书籍主键
     */
    private String belongToId;
    private Long playNum;
    /**
     * 播放完成总数
     */
    private Long finishNum;
    /**
     * 鎺掑簭
     */
    private Integer orderNum;
    private String createId;
    private String createTime;
    private String updateId;
    private String updateTime;


    public String getRecId() {
        return recId;
    }

    public void setRecId(String recId) {
        this.recId = recId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getQrCode() {
        return qrCode;
    }

    public void setQrCode(String qrCode) {
        this.qrCode = qrCode;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getBelongTo() {
        return belongTo;
    }

    public void setBelongTo(String belongTo) {
        this.belongTo = belongTo;
    }

    public String getBelongToId() {
        return belongToId;
    }

    public void setBelongToId(String belongToId) {
        this.belongToId = belongToId;
    }

    public Long getPlayNum() {
        return playNum;
    }

    public void setPlayNum(Long playNum) {
        this.playNum = playNum;
    }

    public Long getFinishNum() {
        return finishNum;
    }

    public void setFinishNum(Long finishNum) {
        this.finishNum = finishNum;
    }

    public Integer getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    public String getCreateId() {
        return createId;
    }

    public void setCreateId(String createId) {
        this.createId = createId;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateId() {
        return updateId;
    }

    public void setUpdateId(String updateId) {
        this.updateId = updateId;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

}
