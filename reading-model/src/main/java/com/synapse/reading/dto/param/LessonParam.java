package com.synapse.reading.dto.param;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.synapse.reading.model.Lesson;
import com.synapse.reading.model.Section;
import com.synapse.reading.model.Video;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotNull;
import com.synapse.reading.web.valid.group.Update;
import com.synapse.reading.web.valid.group.Create;
import com.synapse.reading.web.valid.group.Search;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * LessonParam
 * </p>
 *
 * @author liuguangfu
 * @since 2019-02-15
 */
@ApiModel(value = "LessonParam对象", description = "课程")
public class LessonParam  {

    private Lesson  lesson = new Lesson();

	private List<SectionParam> sectionList = new ArrayList<>();// 子列表

	private List<VideoParam> videoList = new ArrayList<>();// 子列表

	public List<SectionParam> getSectionList() {
		return sectionList;
	}

	public void setSectionList(List<SectionParam> sectionList) {
		this.sectionList = sectionList;
	}

	public List<VideoParam> getVideoList() {
		return videoList;
	}

	public void setVideoList(List<VideoParam> videoList) {
		this.videoList = videoList;
	}

	public LessonParam(){}

    public LessonParam(Lesson  lesson){
        this.lesson = lesson;
    }

    @JsonIgnore
    public Lesson getModel() {
        return lesson;
    }

    public void setModel(Lesson  lesson) {
        this.lesson = lesson;
    }

    @ApiModelProperty(value = "主键")
public String getRecId() {
    return lesson.getRecId();
}

	public void setRecId(String rec_id) {
		lesson.setRecId(rec_id);
	}

        @ApiModelProperty(value = "课程名称")
public String getName() {
    return lesson.getName();
}

	public void setName(String name) {
		lesson.setName(name);
	}

        @ApiModelProperty(value = "课程描述")
public String getIntro() {
    return lesson.getIntro();
}

	public void setIntro(String intro) {
		lesson.setIntro(intro);
	}

	public String getSimpleIntro() {
		return lesson.getSimpleIntro();
	}

	public String getQrCode() {
		return lesson.getQrCode();
	}

	public void setQrCode(String qrCode) {
		lesson.setQrCode(qrCode);
	}

	public void setSimpleIntro(String simpleIntro) {
		lesson.setSimpleIntro(simpleIntro);
	}

	public String getAudioIntro() {
		return lesson.getAudioIntro();
	}

	public void setAudioIntro(String audioIntro) {
		lesson.setAudioIntro(audioIntro);
	}

	public String getVideoIntro() {
		return lesson.getVideoIntro();
	}

	public void setVideoIntro(String videoIntro) {
		lesson.setVideoIntro(videoIntro);
	}

	public String getDiscount() {
		return lesson.getDiscount();
	}

	public void setDiscount(String discount) {
		lesson.setDiscount(discount);
	}

	public String getTag() {
		return lesson.getTag();
	}

	public void setTag(String tag) {
		lesson.setTag(tag);
	}

	public String getOriginalPrice() {
		return lesson.getOriginalPrice();
	}

	public void setOriginalPrice(String originalPrice) {
		lesson.setOriginalPrice(originalPrice);
	}

	public String getPresentPrice() {
		return lesson.getPresentPrice();
	}

	public void setPresentPrice(String presentPrice) {
		lesson.setPresentPrice(presentPrice);
	}

	public String getExpertId() {
		return lesson.getExpertId();
	}

	public void setExpertId(String expertId) {
		lesson.setExpertId(expertId);
	}

	@ApiModelProperty(value = "图片URL")
public String getImage() {
    return lesson.getImage();
}

	public void setImage(String image) {
		lesson.setImage(image);
	}

        @ApiModelProperty(value = "banner")
public String getBanner() {
    return lesson.getBanner();
}

	public void setBanner(String banner) {
		lesson.setBanner(banner);
	}

        @ApiModelProperty(value = "发布状态(0 未发布，1已发布)")
public String getPublishStatus() {
    return lesson.getPublishStatus();
}

	public void setPublishStatus(String publish_status) {
		lesson.setPublishStatus(publish_status);
	}

        @ApiModelProperty(value = "状态(0 删除，1正常)")
public String getStatus() {
    return lesson.getStatus();
}

	public void setStatus(String status) {
		lesson.setStatus(status);
	}

        @ApiModelProperty(value = "排序")
public Integer getOrderNum() {
    return lesson.getOrderNum();
}

	public void setOrderNum(Integer order_num) {
		lesson.setOrderNum(order_num);
	}

        @ApiModelProperty(value = "访问数量")
public Long getVisitNum() {
    return lesson.getVisitNum();
}

	public void setVisitNum(Long visit_num) {
		lesson.setVisitNum(visit_num);
	}

        @ApiModelProperty(value = "创建人")
public String getCreateId() {
    return lesson.getCreateId();
}

	public void setCreateId(String create_id) {
		lesson.setCreateId(create_id);
	}

        @ApiModelProperty(value = "创建时间")
public String getCreateTime() {
    return lesson.getCreateTime();
}

	public void setCreateTime(String create_time) {
		lesson.setCreateTime(create_time);
	}

        @ApiModelProperty(value = "更新人")
public String getUpdateId() {
    return lesson.getUpdateId();
}

	public void setUpdateId(String update_id) {
		lesson.setUpdateId(update_id);
	}

        @ApiModelProperty(value = "更新时间")
public String getUpdateTime() {
    return lesson.getUpdateTime();
}

	public void setUpdateTime(String update_time) {
		lesson.setUpdateTime(update_time);
	}

    }
