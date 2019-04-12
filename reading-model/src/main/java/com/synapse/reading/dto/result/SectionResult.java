package com.synapse.reading.dto.result;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.synapse.reading.model.Section;
import com.synapse.reading.model.Video;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * SectionResult
 * </p>
 *
 * @author liuguangfu
 * @since 2019-02-15
 */
@ApiModel(value = "SectionResult对象", description = "章节")
public class SectionResult {

    private Section  section = new Section();

	private List<Video> videoList= new ArrayList<>();// 子列表

	public List<Video> getVideoList() {
		return videoList;
	}

	public void setVideoList(List<Video> videoList) {
		this.videoList = videoList;
	}

	public SectionResult(){}

    public SectionResult(Section  section) {
		if (section != null) {
			this.section = section;
		}
	}
    @JsonIgnore
    public Section getModel() {
        return section;
    }

    public void setModel(Section section) {
        this.section = section;
    }

@ApiModelProperty(value = "主键")
public String getRecId() {
    return section.getRecId();
}

	public void setRecId(String rec_id) {
		section.setRecId(rec_id);
	}

		@ApiModelProperty(value = "章节名称")
public String getName() {
    return section.getName();
}

	public void setName(String name) {
		section.setName(name);
	}

		@ApiModelProperty(value = "章节描述")
public String getIntro() {
    return section.getIntro();
}

	public void setIntro(String intro) {
		section.setIntro(intro);
	}

		@ApiModelProperty(value = "课程id ")
public String getLessionId() {
    return section.getLessionId();
}

	public void setLessionId(String lession_id) {
		section.setLessionId(lession_id);
	}

		@ApiModelProperty(value = "图片URL")
public String getImage() {
    return section.getImage();
}

	public void setImage(String image) {
		section.setImage(image);
	}

		@ApiModelProperty(value = "banner")
public String getBanner() {
    return section.getBanner();
}

	public void setBanner(String banner) {
		section.setBanner(banner);
	}

		@ApiModelProperty(value = "发布状态(0 未发布，1已发布)")
public String getPublishStatus() {
    return section.getPublishStatus();
}

	public void setPublishStatus(String publish_status) {
		section.setPublishStatus(publish_status);
	}

		@ApiModelProperty(value = "状态(0 删除，1正常)")
public String getStatus() {
    return section.getStatus();
}

	public void setStatus(String status) {
		section.setStatus(status);
	}

		@ApiModelProperty(value = "排序")
public Integer getOrderNum() {
    return section.getOrderNum();
}

	public void setOrderNum(Integer order_num) {
		section.setOrderNum(order_num);
	}

		@ApiModelProperty(value = "访问数量")
public Long getVisitNum() {
    return section.getVisitNum();
}

	public void setVisitNum(Long visit_num) {
		section.setVisitNum(visit_num);
	}

		@ApiModelProperty(value = "创建人")
public String getCreateId() {
    return section.getCreateId();
}

	public void setCreateId(String create_id) {
		section.setCreateId(create_id);
	}

		@ApiModelProperty(value = "创建时间")
public String getCreateTime() {
    return section.getCreateTime();
}

	public void setCreateTime(String create_time) {
		section.setCreateTime(create_time);
	}

		@ApiModelProperty(value = "更新人")
public String getUpdateId() {
    return section.getUpdateId();
}

	public void setUpdateId(String update_id) {
		section.setUpdateId(update_id);
	}

		@ApiModelProperty(value = "更新时间")
public String getUpdateTime() {
    return section.getUpdateTime();
}

	public void setUpdateTime(String update_time) {
		section.setUpdateTime(update_time);
	}

		
}
