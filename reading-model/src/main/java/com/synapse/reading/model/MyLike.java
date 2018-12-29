package com.synapse.reading.model;

import java.util.Date;
import java.io.Serializable;


/**
 * <p>
 * 我的点赞
 * </p>
 *
 * @author liuguangfu
 * @since 2018-12-29
 */
public class MyLike implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private String recId;
    /**
     * 被点赞类型(info:资讯,audio:音频,vedio:视频)
     */
    private String likeType;
    /**
     * 被点赞主键
     */
    private String likeId;
    /**
     * 点赞人
     */
    private String createId;
    /**
     * 点赞时间
     */
    private String createTime;


    public String getRecId() {
        return recId;
    }

    public void setRecId(String recId) {
        this.recId = recId;
    }

    public String getLikeType() {
        return likeType;
    }

    public void setLikeType(String likeType) {
        this.likeType = likeType;
    }

    public String getLikeId() {
        return likeId;
    }

    public void setLikeId(String likeId) {
        this.likeId = likeId;
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
