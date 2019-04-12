package com.synapse.reading.dto.result;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.synapse.reading.model.MediaCounts;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * MediaCountsResult
 * </p>
 *
 * @author liuguangfu
 * @since 2018-12-25
 */
@ApiModel(value = "MediaCountsResult对象", description = "统计播放量")
public class MediaCountsResult {

    private MediaCounts mediaCounts = new MediaCounts();

    public MediaCountsResult() {
    }

    public MediaCountsResult(MediaCounts mediaCounts) {
        if (mediaCounts != null) {
            this.mediaCounts = mediaCounts;
        }
    }


    @JsonIgnore
    public MediaCounts getModel() {
        return mediaCounts;
    }

    public void setModel(MediaCounts mediaCounts) {
        this.mediaCounts = mediaCounts;
    }

    @ApiModelProperty(value = "主键")
    public String getRecId() {
        return mediaCounts.getRecId();
    }

    public void setRecId(String rec_id) {
        mediaCounts.setRecId(rec_id);
    }

    @ApiModelProperty(value = "被播放ID")
    public String getMediaId() {
        return mediaCounts.getMediaId();
    }

    public void setMediaId(String media_id) {
        mediaCounts.setMediaId(media_id);
    }

    @ApiModelProperty(value = "播放类型")
    public String getMediaType() {
        return mediaCounts.getMediaType();
    }

    public void setMediaType(String media_type) {
        mediaCounts.setMediaType(media_type);
    }

    @ApiModelProperty(value = "点击音频，未播放完成")
    public String getClicked() {
        return mediaCounts.getClicked();
    }

    public void setClicked(String clicked) {
        mediaCounts.setClicked(clicked);
    }

    @ApiModelProperty(value = "音频播放完成")
    public String getFinished() {
        return mediaCounts.getFinished();
    }

    public void setFinished(String finished) {
        mediaCounts.setFinished(finished);
    }


    @ApiModelProperty(value = "创建时间")
    public String getCreateTime() {
        return mediaCounts.getCreateTime();
    }

    public void setCreateTime(String create_time) {
        mediaCounts.setCreateTime(create_time);
    }


}
