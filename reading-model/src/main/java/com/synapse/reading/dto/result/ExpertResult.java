package com.synapse.reading.dto.result;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.synapse.reading.model.Expert;
import com.synapse.reading.model.Lesson;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * ExpertResult
 * </p>
 *
 * @author liuguangfu
 * @since 2019-04-09
 */
@ApiModel(value = "ExpertResult对象", description = "专家")
public class ExpertResult {

    private Expert  expert = new Expert();

	private List<Lesson> lessonList = new ArrayList<>();// 子列表

    public ExpertResult(){}

    public ExpertResult(Expert  expert){
		if (expert != null) {
			this.expert = expert;
		}
    }

	public List<Lesson> getLessonList() {
		return lessonList;
	}

	public void setLessonList(List<Lesson> lessonList) {
		this.lessonList = lessonList;
	}

	@JsonIgnore
    public Expert getModel() {
        return expert;
    }

    public void setModel(Expert expert) {
        this.expert = expert;
    }

@ApiModelProperty(value = "主键")
public String getRecId() {
    return expert.getRecId();
}

	public void setRecId(String rec_id) {
		expert.setRecId(rec_id);
	}

		@ApiModelProperty(value = "专家自己id，以后专家登录使用（暂时用不上）")
public String getUserId() {
    return expert.getUserId();
}

	public void setUserId(String user_id) {
		expert.setUserId(user_id);
	}

		@ApiModelProperty(value = "专家名称")
public String getName() {
    return expert.getName();
}

	public void setName(String name) {
		expert.setName(name);
	}

		@ApiModelProperty(value = "专家描述")
public String getIntro() {
    return expert.getIntro();
}

	public void setIntro(String intro) {
		expert.setIntro(intro);
	}

		@ApiModelProperty(value = "专家头像")
public String getImage() {
    return expert.getImage();
}

	public void setImage(String image) {
		expert.setImage(image);
	}

		@ApiModelProperty(value = "专家头衔")
public String getTitle() {
    return expert.getTitle();
}

	public void setTitle(String title) {
		expert.setTitle(title);
	}

		@ApiModelProperty(value = "状态(0 删除，1正常)")
public String getStatus() {
    return expert.getStatus();
}

	public void setStatus(String status) {
		expert.setStatus(status);
	}

		@ApiModelProperty(value = "排序")
public Integer getOrderNum() {
    return expert.getOrderNum();
}

	public void setOrderNum(Integer order_num) {
		expert.setOrderNum(order_num);
	}

		@ApiModelProperty(value = "创建人")
public String getCreateId() {
    return expert.getCreateId();
}

	public void setCreateId(String create_id) {
		expert.setCreateId(create_id);
	}

		@ApiModelProperty(value = "创建时间")
public String getCreateTime() {
    return expert.getCreateTime();
}

	public void setCreateTime(String create_time) {
		expert.setCreateTime(create_time);
	}

		@ApiModelProperty(value = "更新人")
public String getUpdateId() {
    return expert.getUpdateId();
}

	public void setUpdateId(String update_id) {
		expert.setUpdateId(update_id);
	}

		@ApiModelProperty(value = "更新时间")
public String getUpdateTime() {
    return expert.getUpdateTime();
}

	public void setUpdateTime(String update_time) {
		expert.setUpdateTime(update_time);
	}

		
}
