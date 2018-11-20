package com.synapse.reading.dto.result;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.synapse.reading.model.MediaList;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * MediaListResult
 * </p>
 *
 * @author wangyifan
 * @since 2018-11-20
 */
@ApiModel(value = "MediaListResult对象", description = "")
public class MediaListResult {

    private MediaList  mediaList = new MediaList();

    public MediaListResult(){}

    public MediaListResult(MediaList  mediaList){
        this.mediaList = mediaList;
    }

    @JsonIgnore
    public MediaList getModel() {
        return mediaList;
    }

    public void setModel(MediaList mediaList) {
        this.mediaList = mediaList;
    }

@ApiModelProperty(value = "")
public String getRecId() {
    return mediaList.getRecId();
}

	public void setRecId(String rec_id) {
		mediaList.setRecId(rec_id);
	}

		@ApiModelProperty(value = "")
public String getName() {
    return mediaList.getName();
}

	public void setName(String name) {
		mediaList.setName(name);
	}

		@ApiModelProperty(value = "")
public String getUrl() {
    return mediaList.getUrl();
}

	public void setUrl(String url) {
		mediaList.setUrl(url);
	}

		@ApiModelProperty(value = "album 专辑，book书籍")
public String getBelongTo() {
    return mediaList.getBelongTo();
}

	public void setBelongTo(String belong_to) {
		mediaList.setBelongTo(belong_to);
	}

		@ApiModelProperty(value = "专辑或书籍主键")
public String getBelongToId() {
    return mediaList.getBelongToId();
}

	public void setBelongToId(String belong_to_id) {
		mediaList.setBelongToId(belong_to_id);
	}

		@ApiModelProperty(value = "")
public Long getPlayNum() {
    return mediaList.getPlayNum();
}

	public void setPlayNum(Long play_num) {
		mediaList.setPlayNum(play_num);
	}

		@ApiModelProperty(value = "")
public String getCreateId() {
    return mediaList.getCreateId();
}

	public void setCreateId(String create_id) {
		mediaList.setCreateId(create_id);
	}

		@ApiModelProperty(value = "")
public String getCreateTime() {
    return mediaList.getCreateTime();
}

	public void setCreateTime(String create_time) {
		mediaList.setCreateTime(create_time);
	}

		@ApiModelProperty(value = "")
public String getUpdateId() {
    return mediaList.getUpdateId();
}

	public void setUpdateId(String update_id) {
		mediaList.setUpdateId(update_id);
	}

		@ApiModelProperty(value = "")
public String getUpdateTime() {
    return mediaList.getUpdateTime();
}

	public void setUpdateTime(String update_time) {
		mediaList.setUpdateTime(update_time);
	}

		
}
