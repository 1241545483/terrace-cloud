package com.synapse.reading.dto.param;



import com.synapse.reading.web.valid.group.Create;
import com.synapse.reading.web.valid.group.Search;
import com.synapse.reading.web.valid.group.Update;

import javax.validation.constraints.NotNull;

public class RegistParam {
	@NotNull(groups = {Create.class, Search.class, Update.class}, message = "登录名不能为空")
	public String userName;
	
    @NotNull(groups = {Create.class, Search.class, Update.class}, message = "密码不能为空")
	private String password;
	
	private String organization;
	@NotNull(groups = {Create.class, Search.class, Update.class}, message = "确认密码不能为空")
	private String passwordAgain;

	private String mobile;
	
	private String nickName;

	private String idCard;
	
	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getOrganization() {
		return organization;
	}

	public void setOrganization(String organization) {
		this.organization = organization;
	}

	public String getPasswordAgain() {
		return passwordAgain;
	}

	public void setPasswordAgain(String passwordAgain) {
		this.passwordAgain = passwordAgain;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

}
