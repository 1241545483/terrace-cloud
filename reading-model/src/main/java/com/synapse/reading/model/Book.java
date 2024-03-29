package com.synapse.reading.model;

import java.util.Date;
import java.io.Serializable;


/**
 * <p>
 * 
 * </p>
 *
 * @author liuguangfu
 * @since 2019-01-28
 */
public class Book implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private String recId;
    /**
     * 书籍名称
     */
    private String name;
    /**
     * 书籍作者名称
     */
    private String author;
    /**
     * 书籍描述
     */
    private String intro;
    /**
     * 笔记
     */
    private String note;
    /**
     * slogan
     */
    private String slogan;
    /**
     * 书籍类型(1 音频，2视频，3音频+视频）
     */
    private String type;
    /**
     * 书籍封面(封面图片URL)
     */
    private String cover;
    /**
     * pc端书籍封面
     */
    private String pcCover;
    /**
     * banner
     */
    private String banner;
    /**
     * pc替换书籍封面
     */
    private String pcBanner;
    /**
     * 二维码
     */
    private String qrCode;
    /**
     * 发布状态(0 未发布，1已发布)
     */
    private String publishStatus;
    /**
     * 栏目
     */
    private String menu;
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getSlogan() {
        return slogan;
    }

    public void setSlogan(String slogan) {
        this.slogan = slogan;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public String getQrCode() {
        return qrCode;
    }

    public void setQrCode(String qrCode) {
        this.qrCode = qrCode;
    }

    public String getPublishStatus() {
        return publishStatus;
    }

    public void setPublishStatus(String publishStatus) {
        this.publishStatus = publishStatus;
    }

    public String getMenu() {
        return menu;
    }

    public void setMenu(String menu) {
        this.menu = menu;
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
