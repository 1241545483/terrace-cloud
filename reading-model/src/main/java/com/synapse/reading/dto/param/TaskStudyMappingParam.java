package com.synapse.reading.dto.param;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.synapse.reading.model.TaskStudyMapping;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotNull;
import com.synapse.reading.web.valid.group.Update;
import com.synapse.reading.web.valid.group.Create;
import com.synapse.reading.web.valid.group.Search;

/**
 * <p>
 * TaskStudyMappingParam
 * </p>
 *
 * @author liuguangfu
 * @since 2019-06-11
 */
@ApiModel(value = "TaskStudyMappingParam对象", description = "任务和学习课程的关系")
public class TaskStudyMappingParam  {

    private TaskStudyMapping  taskStudyMapping = new TaskStudyMapping();

    public TaskStudyMappingParam(){}

    public TaskStudyMappingParam(TaskStudyMapping  taskStudyMapping){
        this.taskStudyMapping = taskStudyMapping;
    }

    @JsonIgnore
    public TaskStudyMapping getModel() {
        return taskStudyMapping;
    }

    public void setModel(TaskStudyMapping  taskStudyMapping) {
        this.taskStudyMapping = taskStudyMapping;
    }

    @ApiModelProperty(value = "")
public String getRecId() {
    return taskStudyMapping.getRecId();
}

	public void setRecId(String rec_id) {
		taskStudyMapping.setRecId(rec_id);
	}

        @ApiModelProperty(value = "")
public String getTaskId() {
    return taskStudyMapping.getTaskId();
}

	public void setTaskId(String task_id) {
		taskStudyMapping.setTaskId(task_id);
	}

        @ApiModelProperty(value = "")
public String getStudyId() {
    return taskStudyMapping.getStudyId();
}

	public void setStudyId(String study_id) {
		taskStudyMapping.setStudyId(study_id);
	}

        @ApiModelProperty(value = "学习相关类型")
public String getStudyType() {
    return taskStudyMapping.getStudyType();
}

	public void setStudyType(String study_type) {
		taskStudyMapping.setStudyType(study_type);
	}

        @ApiModelProperty(value = "")
public String getStatus() {
    return taskStudyMapping.getStatus();
}

	public void setStatus(String status) {
		taskStudyMapping.setStatus(status);
	}

        @ApiModelProperty(value = "")
public String getCreateId() {
    return taskStudyMapping.getCreateId();
}

	public void setCreateId(String create_id) {
		taskStudyMapping.setCreateId(create_id);
	}

        @ApiModelProperty(value = "")
public String getUpdateId() {
    return taskStudyMapping.getUpdateId();
}

	public void setUpdateId(String update_id) {
		taskStudyMapping.setUpdateId(update_id);
	}

        @ApiModelProperty(value = "")
public String getCreateTime() {
    return taskStudyMapping.getCreateTime();
}

	public void setCreateTime(String create_time) {
		taskStudyMapping.setCreateTime(create_time);
	}

        @ApiModelProperty(value = "")
public String getUpdateTime() {
    return taskStudyMapping.getUpdateTime();
}

	public void setUpdateTime(String update_time) {
		taskStudyMapping.setUpdateTime(update_time);
	}

    }
