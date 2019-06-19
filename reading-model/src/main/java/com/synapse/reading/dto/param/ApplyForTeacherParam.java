package com.synapse.reading.dto.param;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.synapse.reading.model.ApplyForTeacher;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotNull;
import com.synapse.reading.web.valid.group.Update;
import com.synapse.reading.web.valid.group.Create;
import com.synapse.reading.web.valid.group.Search;

/**
 * <p>
 * ApplyForTeacherParam
 * </p>
 *
 * @author liuguangfu
 * @since 2019-06-19
 */
@ApiModel(value = "ApplyForTeacherParam对象", description = "申请成为老师")
public class ApplyForTeacherParam  {

    private ApplyForTeacher  applyForTeacher = new ApplyForTeacher();

    public ApplyForTeacherParam(){}

    public ApplyForTeacherParam(ApplyForTeacher  applyForTeacher){
        this.applyForTeacher = applyForTeacher;
    }

    @JsonIgnore
    public ApplyForTeacher getModel() {
        return applyForTeacher;
    }

    public void setModel(ApplyForTeacher  applyForTeacher) {
        this.applyForTeacher = applyForTeacher;
    }

    @ApiModelProperty(value = "")
public String getRecId() {
    return applyForTeacher.getRecId();
}

	public void setRecId(String rec_id) {
		applyForTeacher.setRecId(rec_id);
	}

        @ApiModelProperty(value = "用户名")
public String getName() {
    return applyForTeacher.getName();
}

	public void setName(String name) {
		applyForTeacher.setName(name);
	}

        @ApiModelProperty(value = "用户id")
public String getUserId() {
    return applyForTeacher.getUserId();
}

	public void setUserId(String user_id) {
		applyForTeacher.setUserId(user_id);
	}

        @ApiModelProperty(value = "申请原因")
public String getReason() {
    return applyForTeacher.getReason();
}

	public void setReason(String reason) {
		applyForTeacher.setReason(reason);
	}

        @ApiModelProperty(value = "状态")
public String getStatus() {
    return applyForTeacher.getStatus();
}

	public void setStatus(String status) {
		applyForTeacher.setStatus(status);
	}

        @ApiModelProperty(value = "创建人")
public String getCreateId() {
    return applyForTeacher.getCreateId();
}

	public void setCreateId(String create_id) {
		applyForTeacher.setCreateId(create_id);
	}

        @ApiModelProperty(value = "创建时间")
public String getCreateTime() {
    return applyForTeacher.getCreateTime();
}

	public void setCreateTime(String create_time) {
		applyForTeacher.setCreateTime(create_time);
	}

        @ApiModelProperty(value = "更新人")
public String getUpdateId() {
    return applyForTeacher.getUpdateId();
}

	public void setUpdateId(String update_id) {
		applyForTeacher.setUpdateId(update_id);
	}

        @ApiModelProperty(value = "更新时间")
public String getUpdateTime() {
    return applyForTeacher.getUpdateTime();
}

	public void setUpdateTime(String update_time) {
		applyForTeacher.setUpdateTime(update_time);
	}

    }
