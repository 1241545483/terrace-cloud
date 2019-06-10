package com.synapse.reading.dto.param;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.synapse.reading.model.ClassInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotNull;
import com.synapse.reading.web.valid.group.Update;
import com.synapse.reading.web.valid.group.Create;
import com.synapse.reading.web.valid.group.Search;

/**
 * <p>
 * ClassInfoParam
 * </p>
 *
 * @author liuguangfu
 * @since 2019-05-28
 */
@ApiModel(value = "ClassInfoParam对象", description = "")
public class ClassInfoParam  {

    private ClassInfo  classInfo = new ClassInfo();

    public ClassInfoParam(){}

    public ClassInfoParam(ClassInfo  classInfo){
        this.classInfo = classInfo;
    }

    @JsonIgnore
    public ClassInfo getModel() {
        return classInfo;
    }

    public void setModel(ClassInfo  classInfo) {
        this.classInfo = classInfo;
    }

    @ApiModelProperty(value = "")
public String getRecId() {
    return classInfo.getRecId();
}

	public void setRecId(String rec_id) {
		classInfo.setRecId(rec_id);
	}

        @ApiModelProperty(value = "班级码用于学生搜索班级码加入学生")
public String getClassCode() {
    return classInfo.getClassCode();
}

	public void setClassCode(String class_code) {
		classInfo.setClassCode(class_code);
	}

        @ApiModelProperty(value = "班级描述")
public String getIntro() {
    return classInfo.getIntro();
}

	public void setIntro(String intro) {
		classInfo.setIntro(intro);
	}

        @ApiModelProperty(value = "")
public String getQrCode() {
    return classInfo.getQrCode();
}

	public void setQrCode(String qr_code) {
		classInfo.setQrCode(qr_code);
	}

        @ApiModelProperty(value = "班级封面(封面图片URL)")
public String getCover() {
    return classInfo.getCover();
}

	public void setCover(String cover) {
		classInfo.setCover(cover);
	}

        @ApiModelProperty(value = "班级状态")
public String getStatus() {
    return classInfo.getStatus();
}

	public void setStatus(String status) {
		classInfo.setStatus(status);
	}

        @ApiModelProperty(value = "创建人")
public String getCreateId() {
    return classInfo.getCreateId();
}

	public void setCreateId(String create_id) {
		classInfo.setCreateId(create_id);
	}

        @ApiModelProperty(value = "创建时间")
public String getCreateTime() {
    return classInfo.getCreateTime();
}

	public void setCreateTime(String create_time) {
		classInfo.setCreateTime(create_time);
	}

        @ApiModelProperty(value = "更新人")
public String getUpdateId() {
    return classInfo.getUpdateId();
}

	public void setUpdateId(String update_id) {
		classInfo.setUpdateId(update_id);
	}

        @ApiModelProperty(value = "更新时间")
public String getUpdateTime() {
    return classInfo.getUpdateTime();
}

	public void setUpdateTime(String update_time) {
		classInfo.setUpdateTime(update_time);
	}

    public String getName() {
        return classInfo.getName();
    }

    public void setName(String name) {
        classInfo.setName(name);
    }
}
