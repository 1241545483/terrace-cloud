package com.synapse.reading.dto.result;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.synapse.reading.model.ClassStudentMapping;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * ClassStudentMappingResult
 * </p>
 *
 * @author liuguangfu
 * @since 2019-05-28
 */
@ApiModel(value = "ClassStudentMappingResult对象", description = "班级和学生的关系")
public class ClassStudentMappingResult {

    private ClassStudentMapping  classStudentMapping = new ClassStudentMapping();

    public ClassStudentMappingResult(){}

    public ClassStudentMappingResult(ClassStudentMapping  classStudentMapping){
        this.classStudentMapping = classStudentMapping;
    }

    @JsonIgnore
    public ClassStudentMapping getModel() {
        return classStudentMapping;
    }

    public void setModel(ClassStudentMapping classStudentMapping) {
        this.classStudentMapping = classStudentMapping;
    }

@ApiModelProperty(value = "")
public String getRecId() {
    return classStudentMapping.getRecId();
}

	public void setRecId(String rec_id) {
		classStudentMapping.setRecId(rec_id);
	}

		@ApiModelProperty(value = "")
public String getClassId() {
    return classStudentMapping.getClassId();
}

	public void setClassId(String class_id) {
		classStudentMapping.setClassId(class_id);
	}

		@ApiModelProperty(value = "")
public String getStudentId() {
    return classStudentMapping.getStudentId();
}

	public void setStudentId(String student_id) {
		classStudentMapping.setStudentId(student_id);
	}

		@ApiModelProperty(value = "")
public String getStatus() {
    return classStudentMapping.getStatus();
}

	public void setStatus(String status) {
		classStudentMapping.setStatus(status);
	}

		@ApiModelProperty(value = "")
public String getCreateId() {
    return classStudentMapping.getCreateId();
}

	public void setCreateId(String create_id) {
		classStudentMapping.setCreateId(create_id);
	}

		@ApiModelProperty(value = "")
public String getUpdateId() {
    return classStudentMapping.getUpdateId();
}

	public void setUpdateId(String update_id) {
		classStudentMapping.setUpdateId(update_id);
	}

		@ApiModelProperty(value = "")
public String getCreateTime() {
    return classStudentMapping.getCreateTime();
}

	public void setCreateTime(String create_time) {
		classStudentMapping.setCreateTime(create_time);
	}

		@ApiModelProperty(value = "")
public String getUpdateTime() {
    return classStudentMapping.getUpdateTime();
}

	public void setUpdateTime(String update_time) {
		classStudentMapping.setUpdateTime(update_time);
	}

	public String getRealName() {
		return classStudentMapping.getRealName();
	}

	public void setRealName(String realName) {
		classStudentMapping.setRealName(realName);
	}
}
