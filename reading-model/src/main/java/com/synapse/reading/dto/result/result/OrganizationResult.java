package com.synapse.reading.dto.result.result;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.synapse.reading.model.model.Organization;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * OrganizationResult
 * </p>
 *
 * @author liuguangfu
 * @since 2019-05-28
 */
@ApiModel(value = "OrganizationResult对象", description = "组织机构")
public class OrganizationResult {

    private Organization  organization = new Organization();

    public OrganizationResult(){}

    public OrganizationResult(Organization  organization){
        this.organization = organization;
    }

    @JsonIgnore
    public Organization getModel() {
        return organization;
    }

    public void setModel(Organization organization) {
        this.organization = organization;
    }

@ApiModelProperty(value = "机构id")
public String getOrgId() {
    return organization.getOrgId();
}

	public void setOrgId(String org_id) {
		organization.setOrgId(org_id);
	}

		@ApiModelProperty(value = "")
public String getOrgName() {
    return organization.getOrgName();
}

	public void setOrgName(String org_name) {
		organization.setOrgName(org_name);
	}

		@ApiModelProperty(value = "")
public String getStatus() {
    return organization.getStatus();
}

	public void setStatus(String status) {
		organization.setStatus(status);
	}

		@ApiModelProperty(value = "1. 管理性质")
public String getOrgNature() {
    return organization.getOrgNature();
}

	public void setOrgNature(String org_nature) {
		organization.setOrgNature(org_nature);
	}

		@ApiModelProperty(value = "上级单位是指： 行政上的隶属关系")
public String getParentOrgId() {
    return organization.getParentOrgId();
}

	public void setParentOrgId(String parent_org_id) {
		organization.setParentOrgId(parent_org_id);
	}

		@ApiModelProperty(value = "")
public String getOrgLocation() {
    return organization.getOrgLocation();
}

	public void setOrgLocation(String org_location) {
		organization.setOrgLocation(org_location);
	}

		@ApiModelProperty(value = "创建人")
public String getCreateId() {
    return organization.getCreateId();
}

	public void setCreateId(String create_id) {
		organization.setCreateId(create_id);
	}

		@ApiModelProperty(value = "创建时间")
public String getCreateTime() {
    return organization.getCreateTime();
}

	public void setCreateTime(String create_time) {
		organization.setCreateTime(create_time);
	}

		@ApiModelProperty(value = "更新人")
public String getUpdateId() {
    return organization.getUpdateId();
}

	public void setUpdateId(String update_id) {
		organization.setUpdateId(update_id);
	}

		@ApiModelProperty(value = "更新时间")
public String getUpdateTime() {
    return organization.getUpdateTime();
}

	public void setUpdateTime(String update_time) {
		organization.setUpdateTime(update_time);
	}

		
}
