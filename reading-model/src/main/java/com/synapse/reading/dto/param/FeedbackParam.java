package com.synapse.reading.dto.param;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.synapse.reading.model.Feedback;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotNull;
import com.synapse.reading.web.valid.group.Update;
import com.synapse.reading.web.valid.group.Create;
import com.synapse.reading.web.valid.group.Search;

/**
 * <p>
 * FeedbackParam
 * </p>
 *
 * @author liuguangfu
 * @since 2018-12-26
 */
@ApiModel(value = "FeedbackParam对象", description = "意见反馈")
public class FeedbackParam  {

    private Feedback  feedback = new Feedback();

    public FeedbackParam(){}

    public FeedbackParam(Feedback  feedback){
        this.feedback = feedback;
    }

    @JsonIgnore
    public Feedback getModel() {
        return feedback;
    }

    public void setModel(Feedback  feedback) {
        this.feedback = feedback;
    }

    @ApiModelProperty(value = "主键")
public String getRecId() {
    return feedback.getRecId();
}

	public void setRecId(String rec_id) {
		feedback.setRecId(rec_id);
	}

        @ApiModelProperty(value = "意见")
public String getContent() {
    return feedback.getContent();
}

	public void setContent(String content) {
		feedback.setContent(content);
	}

        @ApiModelProperty(value = "用户（当前登录的用户信息）")
public String getCreateId() {
    return feedback.getCreateId();
}

	public void setCreateId(String create_id) {
		feedback.setCreateId(create_id);
	}

        @ApiModelProperty(value = "创建时间")
public String getCreateTime() {
    return feedback.getCreateTime();
}

	public void setCreateTime(String create_time) {
		feedback.setCreateTime(create_time);
	}

    }
