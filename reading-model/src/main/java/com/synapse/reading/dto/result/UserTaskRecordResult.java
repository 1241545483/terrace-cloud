package com.synapse.reading.dto.result;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.synapse.reading.model.UserTaskRecord;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * UserTaskRecordResult
 * </p>
 *
 * @author liuguangfu
 * @since 2019-06-12
 */
@ApiModel(value = "UserTaskRecordResult对象", description = "任务接受记录")
public class UserTaskRecordResult {

    private UserTaskRecord  userTaskRecord = new UserTaskRecord();

    public UserTaskRecordResult(){}

    public UserTaskRecordResult(UserTaskRecord  userTaskRecord){
        this.userTaskRecord = userTaskRecord;
    }

    @JsonIgnore
    public UserTaskRecord getModel() {
        return userTaskRecord;
    }

    public void setModel(UserTaskRecord userTaskRecord) {
        this.userTaskRecord = userTaskRecord;
    }

@ApiModelProperty(value = "")
public String getRecId() {
    return userTaskRecord.getRecId();
}

	public void setRecId(String rec_id) {
		userTaskRecord.setRecId(rec_id);
	}

		@ApiModelProperty(value = "学习相关id")
public String getTaskId() {
    return userTaskRecord.getTaskId();
}

	public void setTaskId(String task_id) {
		userTaskRecord.setTaskId(task_id);
	}

		@ApiModelProperty(value = "班级id")
public String getUserId() {
    return userTaskRecord.getUserId();
}

	public void setUserId(String user_id) {
		userTaskRecord.setUserId(user_id);
	}

		@ApiModelProperty(value = "班级状态")
public String getStatus() {
    return userTaskRecord.getStatus();
}

	public void setStatus(String status) {
		userTaskRecord.setStatus(status);
	}

		@ApiModelProperty(value = "创建人")
public String getCreateId() {
    return userTaskRecord.getCreateId();
}

	public void setCreateId(String create_id) {
		userTaskRecord.setCreateId(create_id);
	}

		@ApiModelProperty(value = "创建时间")
public String getCreateTime() {
    return userTaskRecord.getCreateTime();
}

	public void setCreateTime(String create_time) {
		userTaskRecord.setCreateTime(create_time);
	}

		@ApiModelProperty(value = "更新人")
public String getUpdateId() {
    return userTaskRecord.getUpdateId();
}

	public void setUpdateId(String update_id) {
		userTaskRecord.setUpdateId(update_id);
	}

		@ApiModelProperty(value = "更新时间")
public String getUpdateTime() {
    return userTaskRecord.getUpdateTime();
}

	public void setUpdateTime(String update_time) {
		userTaskRecord.setUpdateTime(update_time);
	}

		
}
