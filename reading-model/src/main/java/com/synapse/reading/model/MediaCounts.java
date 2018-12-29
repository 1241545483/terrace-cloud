package com.synapse.reading.model;

import java.util.Date;
import java.io.Serializable;


/**
 * <p>
 * 统计播放量
 * </p>
 *
 * @author liuguangfu
 * @since 2018-12-29
 */
public class MediaCounts implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private String recId;
    /**
     * 被播放ID
     */
    private String mediaId;
    /**
     * 播放类型
     */
    private String mediaType;
    /**
     * 点击音频，未播放完成
     */
    private String clicked;
    /**
     * 音频播放完成
     */
    private String finished;
    /**
     * 创建时间
     */
    private String createTime;


    public String getRecId() {
        return recId;
    }

    public void setRecId(String recId) {
        this.recId = recId;
    }

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }

    public String getMediaType() {
        return mediaType;
    }

    public void setMediaType(String mediaType) {
        this.mediaType = mediaType;
    }

    public String getClicked() {
        return clicked;
    }

    public void setClicked(String clicked) {
        this.clicked = clicked;
    }

    public String getFinished() {
        return finished;
    }

    public void setFinished(String finished) {
        this.finished = finished;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

}
