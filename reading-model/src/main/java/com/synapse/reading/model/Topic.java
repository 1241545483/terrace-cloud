package com.synapse.reading.model;

import java.util.Date;
import java.io.Serializable;


/**
 * <p>
 * 主题，关联专辑
 * </p>
 *
 * @author liuguangfu
 * @since 2019-01-29
 */
public class Topic implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private String recId;
    /**
     * 目录名字
     */
    private String name;
    /**
     * 替换封面url
     */
    private String cover;
    /**
     * pc端封面图片URL
     */
    private String pcCover;
    /**
     * 替换封面图片URL
     */
    private String banner;
    /**
     * pc替换封面图片URL
     */
    private String pcBanner;
    private String intro;
    private String slogan;
    /**
     * 0 未发布，1已发布
     */
    private String publishStatus;
    /**
     * 0 删除，1正常
     */
    private String status;
    /**
     * 排序
     */
    private Integer orderNum;
    private String detail;
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

    public String getBanner() {
        return banner;
    }

    public void setBanner(String banner) {
        this.banner = banner;
    }

    public String getPcBanner() {
        return pcBanner;
    }

    public void setPcBanner(String pcBanner) {
        this.pcBanner = pcBanner;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getSlogan() {
        return slogan;
    }

    public void setSlogan(String slogan) {
        this.slogan = slogan;
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

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
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
