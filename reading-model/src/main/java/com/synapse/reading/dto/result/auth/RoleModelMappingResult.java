package com.synapse.reading.dto.result.auth;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.synapse.reading.model.auth.RoleModelMapping;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * RoleModelMappingResult
 * </p>
 *
 * @author liuguangfu
 * @since 2019-05-28
 */
@ApiModel(value = "RoleModelMappingResult对象", description = "系统模块和角色的关系")
public class RoleModelMappingResult {

    private RoleModelMapping  roleModelMapping = new RoleModelMapping();

    public RoleModelMappingResult(){}

    public RoleModelMappingResult(RoleModelMapping  roleModelMapping){
        this.roleModelMapping = roleModelMapping;
    }

    @JsonIgnore
    public RoleModelMapping getModel() {
        return roleModelMapping;
    }

    public void setModel(RoleModelMapping roleModelMapping) {
        this.roleModelMapping = roleModelMapping;
    }

@ApiModelProperty(value = "")
public String getRecId() {
    return roleModelMapping.getRecId();
}

	public void setRecId(String rec_id) {
		roleModelMapping.setRecId(rec_id);
	}

		@ApiModelProperty(value = "")
public String getModelId() {
    return roleModelMapping.getModelId();
}

	public void setModelId(String model_id) {
		roleModelMapping.setModelId(model_id);
	}

		@ApiModelProperty(value = "")
public String getRoleId() {
    return roleModelMapping.getRoleId();
}

	public void setRoleId(String role_id) {
		roleModelMapping.setRoleId(role_id);
	}

		@ApiModelProperty(value = "")
public String getStatus() {
    return roleModelMapping.getStatus();
}

	public void setStatus(String status) {
		roleModelMapping.setStatus(status);
	}

		@ApiModelProperty(value = "")
public String getCreateId() {
    return roleModelMapping.getCreateId();
}

	public void setCreateId(String create_id) {
		roleModelMapping.setCreateId(create_id);
	}

		@ApiModelProperty(value = "")
public String getUpdateId() {
    return roleModelMapping.getUpdateId();
}

	public void setUpdateId(String update_id) {
		roleModelMapping.setUpdateId(update_id);
	}

		@ApiModelProperty(value = "")
public String getCreateTime() {
    return roleModelMapping.getCreateTime();
}

	public void setCreateTime(String create_time) {
		roleModelMapping.setCreateTime(create_time);
	}

		@ApiModelProperty(value = "")
public String getUpdateTime() {
    return roleModelMapping.getUpdateTime();
}

	public void setUpdateTime(String update_time) {
		roleModelMapping.setUpdateTime(update_time);
	}


}
