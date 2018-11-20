package com.synapse.reading.dto.param;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.synapse.reading.model.VideoList;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotNull;
import com.synapse.reading.web.valid.group.Update;
import com.synapse.reading.web.valid.group.Create;
import com.synapse.reading.web.valid.group.Search;

/**
 * <p>
 * VideoListParam
 * </p>
 *
 * @author wangyifan
 * @since 2018-11-20
 */
@ApiModel(value = "VideoListParam对象", description = "")
public class VideoListParam  {

    private VideoList  videoList = new VideoList();

    public VideoListParam(){}

    public VideoListParam(VideoList  videoList){
        this.videoList = videoList;
    }

    @JsonIgnore
    public VideoList getModel() {
        return videoList;
    }

    public void setModel(VideoList  videoList) {
        this.videoList = videoList;
    }

    @ApiModelProperty(value = "")
public String getRecId() {
    return videoList.getRecId();
}

	public void setRecId(String rec_id) {
		videoList.setRecId(rec_id);
	}

        @ApiModelProperty(value = "")
public String getName() {
    return videoList.getName();
}

	public void setName(String name) {
		videoList.setName(name);
	}

        @ApiModelProperty(value = "")
public String getUrl() {
    return videoList.getUrl();
}

	public void setUrl(String url) {
		videoList.setUrl(url);
	}

        @ApiModelProperty(value = "album 专辑，book书籍")
public String getBelongTo() {
    return videoList.getBelongTo();
}

	public void setBelongTo(String belong_to) {
		videoList.setBelongTo(belong_to);
	}

        @ApiModelProperty(value = "专辑或书籍主键")
public String getBelongToId() {
    return videoList.getBelongToId();
}

	public void setBelongToId(String belong_to_id) {
		videoList.setBelongToId(belong_to_id);
	}

        @ApiModelProperty(value = "")
public Long getPlayNum() {
    return videoList.getPlayNum();
}

	public void setPlayNum(Long play_num) {
		videoList.setPlayNum(play_num);
	}

        @ApiModelProperty(value = "")
public String getCreateId() {
    return videoList.getCreateId();
}

	public void setCreateId(String create_id) {
		videoList.setCreateId(create_id);
	}

        @ApiModelProperty(value = "")
public String getCreateTime() {
    return videoList.getCreateTime();
}

	public void setCreateTime(String create_time) {
		videoList.setCreateTime(create_time);
	}

        @ApiModelProperty(value = "")
public String getUpdateId() {
    return videoList.getUpdateId();
}

	public void setUpdateId(String update_id) {
		videoList.setUpdateId(update_id);
	}

        @ApiModelProperty(value = "")
public String getUpdateTime() {
    return videoList.getUpdateTime();
}

	public void setUpdateTime(String update_time) {
		videoList.setUpdateTime(update_time);
	}

    }
