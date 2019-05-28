package com.synapse.reading.dto.result;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.synapse.reading.model.ClassCode;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * ClassCodeResult
 * </p>
 *
 * @author liuguangfu
 * @since 2019-05-28
 */
@ApiModel(value = "ClassCodeResult对象", description = "")
public class ClassCodeResult {

    private ClassCode  classCode = new ClassCode();

    public ClassCodeResult(){}

    public ClassCodeResult(ClassCode  classCode){
        this.classCode = classCode;
    }

    @JsonIgnore
    public ClassCode getModel() {
        return classCode;
    }

    public void setModel(ClassCode classCode) {
        this.classCode = classCode;
    }

@ApiModelProperty(value = "自增用于作为班级code码")
public Integer getClassCode() {
    return classCode.getClassCode();
}

	public void setClassCode(Integer class_code) {
		classCode.setClassCode(class_code);
	}

		@ApiModelProperty(value = "班级状态")
public String getStatus() {
    return classCode.getStatus();
}

	public void setStatus(String status) {
		classCode.setStatus(status);
	}

		@ApiModelProperty(value = "创建人")
public String getCreateId() {
    return classCode.getCreateId();
}

	public void setCreateId(String create_id) {
		classCode.setCreateId(create_id);
	}

		@ApiModelProperty(value = "创建时间")
public String getCreateTime() {
    return classCode.getCreateTime();
}

	public void setCreateTime(String create_time) {
		classCode.setCreateTime(create_time);
	}

		@ApiModelProperty(value = "更新人")
public String getUpdateId() {
    return classCode.getUpdateId();
}

	public void setUpdateId(String update_id) {
		classCode.setUpdateId(update_id);
	}

		@ApiModelProperty(value = "更新时间")
public String getUpdateTime() {
    return classCode.getUpdateTime();
}

	public void setUpdateTime(String update_time) {
		classCode.setUpdateTime(update_time);
	}

		
}
