package com.synapse.reading.dto.result.auth;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.synapse.reading.model.auth.UserRole;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * UserRoleResult
 * </p>
 *
 * @author liuguangfu
 * @since 2019-05-30
 */
@ApiModel(value = "UserRoleResult对象", description = "阅读这边目前就只有老师，学生")
public class UserRoleResult {

    private UserRole  userRole = new UserRole();

    public UserRoleResult(){}

    public UserRoleResult(UserRole  userRole){
        this.userRole = userRole;
    }

    @JsonIgnore
    public UserRole getModel() {
        return userRole;
    }

    public void setModel(UserRole userRole) {
        this.userRole = userRole;
    }

@ApiModelProperty(value = "")
public String getRecId() {
    return userRole.getRecId();
}

	public void setRecId(String rec_id) {
		userRole.setRecId(rec_id);
	}

		@ApiModelProperty(value = "")
public String getUserId() {
    return userRole.getUserId();
}

	public void setUserId(String user_id) {
		userRole.setUserId(user_id);
	}

		@ApiModelProperty(value = "具体某个角色")
public String getRoleId() {
    return userRole.getRoleId();
}

	public void setRoleId(String role_id) {
		userRole.setRoleId(role_id);
	}

		@ApiModelProperty(value = "业务系统的appkey")
public String getAppKey() {
    return userRole.getAppKey();
}

	public void setAppKey(String app_key) {
		userRole.setAppKey(app_key);
	}

		@ApiModelProperty(value = "不同组织中不同的角色使用到")
public String getOrgId() {
    return userRole.getOrgId();
}

	public void setOrgId(String org_id) {
		userRole.setOrgId(org_id);
	}

		@ApiModelProperty(value = "创建人")
public String getCreateId() {
    return userRole.getCreateId();
}

	public void setCreateId(String create_id) {
		userRole.setCreateId(create_id);
	}

		@ApiModelProperty(value = "创建时间")
public String getCreateTime() {
    return userRole.getCreateTime();
}

	public void setCreateTime(String create_time) {
		userRole.setCreateTime(create_time);
	}

		@ApiModelProperty(value = "更新人")
public String getUpdateId() {
    return userRole.getUpdateId();
}

	public void setUpdateId(String update_id) {
		userRole.setUpdateId(update_id);
	}

		@ApiModelProperty(value = "更新时间")
public String getUpdateTime() {
    return userRole.getUpdateTime();
}

	public void setUpdateTime(String update_time) {
		userRole.setUpdateTime(update_time);
	}


}
