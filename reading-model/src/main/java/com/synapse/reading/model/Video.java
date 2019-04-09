package com.synapse.reading.model;

import java.util.Date;
import java.io.Serializable;


/**
 * <p>
 * 视频
 * </p>
 *
 * @author liuguangfu
 * @since 2019-04-09
 */
public class Video implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private String recId;
    /**
     * 视频名称
     */
    private String name;
    /**
     * 视频链接
     */
    private String url;
    /**
     * 简介
     */
    private String intro;
    /**
     * 标签( 研读，导读)
     */
    private String tag;
    /**
     * 二维码
     */
    private String qrCode;
    /**
     * 封面
     */
    private String cover;
    /**
     * pc端封面视频图片URL
     */
    private String pcCover;
    /**
     * 属于哪个栏目(album 专辑，book书籍)
     */
    private String belongTo;
    /**
     * 属于哪个栏目ID(专辑或书籍主键)
     */
    private String belongToId;
    /**
     * 免费观看
     */
    private String free;
    /**
     * 播放完成总数
     */
    private Long finishNum;
    /**
     * 播放量
     */
    private Long playNum;
    /**
     * 排序
     */
    private Integer orderNum;
    /**
     * 创建人
     */
    private String createId;
    /**
     * 创建时间
     */
    private String createTime;
    /**
     * 更新人
     */
    private String updateId;
    /**
     * 更新时间
     */
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

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
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

    public String getPcCover() {
        return pcCover;
    }

    public void setPcCover(String pcCover) {
        this.pcCover = pcCover;
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

    public String getFree() {
        return free;
    }

    public void setFree(String free) {
        this.free = free;
    }

    public Long getFinishNum() {
        return finishNum;
    }

    public void setFinishNum(Long finishNum) {
        this.finishNum = finishNum;
    }

    public Long getPlayNum() {
        return playNum;
    }

    public void setPlayNum(Long playNum) {
        this.playNum = playNum;
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
