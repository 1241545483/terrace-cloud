package com.synapse.reading.model;

import java.util.Date;
import java.io.Serializable;


/**
 * <p>
 * 我的收藏
 * </p>
 *
 * @author liuguangfu
 * @since 2018-12-29
 */
public class MyCollect implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private String recId;
    /**
     * 被收藏类型(info:资讯,audio:音频,vedio:视频)
     */
    private String collectType;
    /**
     * 被收藏主键
     */
    private String collectId;
    /**
     * 收藏人
     */
    private String createId;
    /**
     * 收藏时间
     */
    private String createTime;


    public String getRecId() {
        return recId;
    }

    public void setRecId(String recId) {
        this.recId = recId;
    }

    public String getCollectType() {
        return collectType;
    }

    public void setCollectType(String collectType) {
        this.collectType = collectType;
    }

    public String getCollectId() {
        return collectId;
    }

    public void setCollectId(String collectId) {
        this.collectId = collectId;
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

}
