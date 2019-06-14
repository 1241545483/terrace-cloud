package com.synapse.reading.dto.param;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.synapse.reading.model.TaskNote;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotNull;
import com.synapse.reading.web.valid.group.Update;
import com.synapse.reading.web.valid.group.Create;
import com.synapse.reading.web.valid.group.Search;

/**
 * <p>
 * TaskNoteParam
 * </p>
 *
 * @author liuguangfu
 * @since 2019-06-13
 */
@ApiModel(value = "TaskNoteParam对象", description = "任务笔记")
public class TaskNoteParam  {

    private TaskNote  taskNote = new TaskNote();

    public TaskNoteParam(){}

    public TaskNoteParam(TaskNote  taskNote){
        this.taskNote = taskNote;
    }

    @JsonIgnore
    public TaskNote getModel() {
        return taskNote;
    }

    public void setModel(TaskNote  taskNote) {
        this.taskNote = taskNote;
    }

    @ApiModelProperty(value = "")
public String getRecId() {
    return taskNote.getRecId();
}

	public void setRecId(String rec_id) {
		taskNote.setRecId(rec_id);
	}

        @ApiModelProperty(value = "笔记")
public String getNote() {
    return taskNote.getNote();
}

	public void setNote(String note) {
		taskNote.setNote(note);
	}

        @ApiModelProperty(value = "用户id")
public String getUserId() {
    return taskNote.getUserId();
}

	public void setUserId(String user_id) {
		taskNote.setUserId(user_id);
	}

        @ApiModelProperty(value = "任务主键")
public String getTaskId() {
    return taskNote.getTaskId();
}

	public void setTaskId(String task_id) {
		taskNote.setTaskId(task_id);
	}

        @ApiModelProperty(value = "图片1")
public String getImg1() {
    return taskNote.getImg1();
}

	public void setImg1(String img1) {
		taskNote.setImg1(img1);
	}

        @ApiModelProperty(value = "图片2")
public String getImg2() {
    return taskNote.getImg2();
}

	public void setImg2(String img2) {
		taskNote.setImg2(img2);
	}

        @ApiModelProperty(value = "图片3")
public String getImg3() {
    return taskNote.getImg3();
}

	public void setImg3(String img3) {
		taskNote.setImg3(img3);
	}

        @ApiModelProperty(value = "班级状态")
public String getStatus() {
    return taskNote.getStatus();
}

	public void setStatus(String status) {
		taskNote.setStatus(status);
	}

        @ApiModelProperty(value = "创建人")
public String getCreateId() {
    return taskNote.getCreateId();
}

	public void setCreateId(String create_id) {
		taskNote.setCreateId(create_id);
	}

        @ApiModelProperty(value = "创建时间")
public String getCreateTime() {
    return taskNote.getCreateTime();
}

	public void setCreateTime(String create_time) {
		taskNote.setCreateTime(create_time);
	}

        @ApiModelProperty(value = "更新人")
public String getUpdateId() {
    return taskNote.getUpdateId();
}

	public void setUpdateId(String update_id) {
		taskNote.setUpdateId(update_id);
	}

        @ApiModelProperty(value = "更新时间")
public String getUpdateTime() {
    return taskNote.getUpdateTime();
}

	public void setUpdateTime(String update_time) {
		taskNote.setUpdateTime(update_time);
	}

    }
