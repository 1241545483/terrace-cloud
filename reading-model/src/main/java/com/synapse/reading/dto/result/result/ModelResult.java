package com.synapse.reading.dto.result.result;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.synapse.reading.model.model.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * ModelResult
 * </p>
 *
 * @author liuguangfu
 * @since 2019-05-28
 */
@ApiModel(value = "ModelResult对象", description = "系统模块")
public class ModelResult {

    private Model  model = new Model();

    public ModelResult(){}

    public ModelResult(Model  model){
        this.model = model;
    }

    @JsonIgnore
    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

@ApiModelProperty(value = "")
public String getRecId() {
    return model.getRecId();
}

	public void setRecId(String rec_id) {
		model.setRecId(rec_id);
	}

		@ApiModelProperty(value = "菜单ID")
public String getMenuId() {
    return model.getMenuId();
}

	public void setMenuId(String menu_id) {
		model.setMenuId(menu_id);
	}

		@ApiModelProperty(value = "")
public String getOperateDesc() {
    return model.getOperateDesc();
}

	public void setOperateDesc(String operate_desc) {
		model.setOperateDesc(operate_desc);
	}

		@ApiModelProperty(value = "模块名称")
public String getName() {
    return model.getName();
}

	public void setName(String name) {
		model.setName(name);
	}

		@ApiModelProperty(value = "")
public String getStatus() {
    return model.getStatus();
}

	public void setStatus(String status) {
		model.setStatus(status);
	}

		@ApiModelProperty(value = "创建人")
public String getCreateId() {
    return model.getCreateId();
}

	public void setCreateId(String create_id) {
		model.setCreateId(create_id);
	}

		@ApiModelProperty(value = "创建时间")
public String getCreateTime() {
    return model.getCreateTime();
}

	public void setCreateTime(String create_time) {
		model.setCreateTime(create_time);
	}

		@ApiModelProperty(value = "更新人")
public String getUpdateId() {
    return model.getUpdateId();
}

	public void setUpdateId(String update_id) {
		model.setUpdateId(update_id);
	}

		@ApiModelProperty(value = "更新时间")
public String getUpdateTime() {
    return model.getUpdateTime();
}

	public void setUpdateTime(String update_time) {
		model.setUpdateTime(update_time);
	}

		
}
