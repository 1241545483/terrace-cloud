package com.synapse.reading.model;

import java.util.Date;
import java.io.Serializable;


/**
 * <p>
 * 分享图片
 * </p>
 *
 * @author liuguangfu
 * @since 2018-12-29
 */
public class ShareImage implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private String recId;
    /**
     * 用户（当前登录的用户信息）
     */
    private String userId;
    /**
     * 被分享的类型(audio:音频,video:视频)
     */
    private String shareType;
    /**
     * 被分享主键
     */
    private String shareId;
    /**
     * 分享图片URL
     */
    private String url;
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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getShareType() {
        return shareType;
    }

    public void setShareType(String shareType) {
        this.shareType = shareType;
    }

    public String getShareId() {
        return shareId;
    }

    public void setShareId(String shareId) {
        this.shareId = shareId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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
