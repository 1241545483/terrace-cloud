package com.synapse.reading.dto.result;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.synapse.common.ann.DictFormat;
import com.synapse.reading.model.Member;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * MemberResult
 * </p>
 *
 * @author liuguangfu
 * @since 2018-12-06
 */
@ApiModel(value = "MemberResult对象", description = "用户信息")
public class MemberResult {

    private Member  member = new Member();

    private  String orgName;

    public MemberResult(){}

    public MemberResult(Member  member) {
		if (member != null) {
			this.member = member;
		}
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public String getRole() {
		return member.getRole();
	}

	public void setRole(String role) {
		member.setRole(role);
	}

	public String getImportData() {
		return member.getImportData();
	}

	public void setImportData(String importData) {
		member.setImportData(importData);
	}

	public String getMobile() {
		return member.getMobile();
	}

	public void setMobile(String mobile) {
		member.setMobile(mobile);
	}

	public String getOfficeStatus() {
		return member.getOfficeStatus();
	}

	public void setOfficeStatus(String officeStatus) {
		member.setOfficeStatus(officeStatus);
	}

	public String getOrganization() {
		return member.getOrganization();
	}

	public void setOrganization(String organization) {
		member.setOrganization(organization);
	}

	public String getIdCard() {
		return member.getIdCard();
	}

	public void setIdCard(String idCard) {
		member.setIdCard(idCard);
	}

	public String getStatus() {
		return member.getStatus();
	}

	public void setStatus(String status) {
		member.setStatus(status);
	}
	@DictFormat(type = "PHASE_TYPE", field = "typeTxt")
	public String getPhase() {
		return member.getPhase();
	}

	public void setPhase(String phase) {
		member.setPhase(phase);
	}
	@DictFormat(type = "SUBJECT_TYPE", field = "typeTxt")
	public String getSubject() {
		return member.getSubject();
	}

	public void setSubject(String subject) {
		member.setSubject(subject);
	}

	public String getName() {
		return member.getName();
	}

	public void setName(String name) {
		member.setName(name);
	}

	@JsonIgnore
    public Member getModel() {
        return member;
    }

    public void setModel(Member member) {
        this.member = member;
    }

@ApiModelProperty(value = "用户（当前登录的用户信息）")
public String getUserId() {
    return member.getUserId();
}

	public void setUserId(String user_id) {
		member.setUserId(user_id);
	}

		@ApiModelProperty(value = "积分")
public Integer getPoint() {
    return member.getPoint();
}

	public void setPoint(Integer point) {
		member.setPoint(point);
	}

		@ApiModelProperty(value = "创建人")
public String getCreateId() {
    return member.getCreateId();
}

	public void setCreateId(String create_id) {
		member.setCreateId(create_id);
	}

		@ApiModelProperty(value = "创建时间")
public String getCreateTime() {
    return member.getCreateTime();
}

	public void setCreateTime(String create_time) {
		member.setCreateTime(create_time);
	}

		@ApiModelProperty(value = "更新人")
public String getUpdateId() {
    return member.getUpdateId();
}

	public void setUpdateId(String update_id) {
		member.setUpdateId(update_id);
	}

		@ApiModelProperty(value = "更新时间")
public String getUpdateTime() {
    return member.getUpdateTime();
}

	public void setUpdateTime(String update_time) {
		member.setUpdateTime(update_time);
	}

		
}
