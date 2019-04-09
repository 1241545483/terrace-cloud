package com.synapse.reading.model;

import java.util.Date;
import java.io.Serializable;


/**
 * <p>
 * 课程
 * </p>
 *
 * @author liuguangfu
 * @since 2019-04-09
 */
public class Lesson implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private String recId;
    /**
     * 课程名称
     */
    private String name;
    /**
     * 课程名称
     */
    private String simpleIntro;
    /**
     * 课程描述
     */
    private String intro;
    /**
     * 课程音频介绍
     */
    private String audioIntro;
    /**
     * 课程视频介绍
     */
    private String videoIntro;
    /**
     * 图片URL
     */
    private String image;
    /**
     * banner
     */
    private String banner;
    /**
     * 折扣
     */
    private String discount;
    /**
     * 标签
     */
    private String tag;
    /**
     * 原价
     */
    private String originalPrice;
    /**
     * 现价
     */
    private String presentPrice;
    /**
     * 专家id
     */
    private String expertId;
    /**
     * 发布状态(0 未发布，1已发布)
     */
    private String publishStatus;
    /**
     * 状态(0 删除，1正常)
     */
    private String status;
    /**
     * 排序
     */
    private Integer orderNum;
    /**
     * 访问数量
     */
    private Long visitNum;
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

    public String getSimpleIntro() {
        return simpleIntro;
    }

    public void setSimpleIntro(String simpleIntro) {
        this.simpleIntro = simpleIntro;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getAudioIntro() {
        return audioIntro;
    }

    public void setAudioIntro(String audioIntro) {
        this.audioIntro = audioIntro;
    }

    public String getVideoIntro() {
        return videoIntro;
    }

    public void setVideoIntro(String videoIntro) {
        this.videoIntro = videoIntro;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getBanner() {
        return banner;
    }

    public void setBanner(String banner) {
        this.banner = banner;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(String originalPrice) {
        this.originalPrice = originalPrice;
    }

    public String getPresentPrice() {
        return presentPrice;
    }

    public void setPresentPrice(String presentPrice) {
        this.presentPrice = presentPrice;
    }

    public String getExpertId() {
        return expertId;
    }

    public void setExpertId(String expertId) {
        this.expertId = expertId;
    }

    public String getPublishStatus() {
        return publishStatus;
    }

    public void setPublishStatus(String publishStatus) {
        this.publishStatus = publishStatus;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    public Long getVisitNum() {
        return visitNum;
    }

    public void setVisitNum(Long visitNum) {
        this.visitNum = visitNum;
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
