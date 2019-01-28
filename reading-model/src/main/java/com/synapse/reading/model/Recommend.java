package com.synapse.reading.model;

import java.util.Date;
import java.io.Serializable;


/**
 * <p>
 * 推荐
 * </p>
 *
 * @author liuguangfu
 * @since 2019-01-25
 */
public class Recommend implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private String recId;
    /**
     * 被推荐类型(info:资讯,audio:音频,vedio:视频)
     */
    private String recommendType;
    /**
     * 被推荐主键
     */
    private String recommendId;
    /**
     * 推荐年级
     */
    private String level;
    /**
     * 推荐栏目
     */
    private String menu;
    /**
     * 推荐人
     */
    private String createId;
    /**
     * 推荐时间
     */
    private String createTime;
    /**
     * 开始时间
     */
    private String startTime;
    /**
     * 结束时间
     */
    private String endTime;


    public String getRecId() {
        return recId;
    }

    public void setRecId(String recId) {
        this.recId = recId;
    }

    public String getRecommendType() {
        return recommendType;
    }

    public void setRecommendType(String recommendType) {
        this.recommendType = recommendType;
    }

    public String getRecommendId() {
        return recommendId;
    }

    public void setRecommendId(String recommendId) {
        this.recommendId = recommendId;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getMenu() {
        return menu;
    }

    public void setMenu(String menu) {
        this.menu = menu;
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

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

}
