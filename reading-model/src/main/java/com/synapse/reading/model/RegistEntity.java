package com.synapse.reading.model;

/**
 * Created by Administrator on 2017/6/30 0030.
 */
public class RegistEntity {
    //machine 机器码  loginName 登录名 loginPass 密码
    //regRoletype角色类型  cache 缓存 valia 验证码
    private String machine;
    private String lbslng;
    private String userId;
    private String loginName;
    private String loginAlais;
    private String loginPass;
    private String regRoletype;
    private String orgId;
    private String cacheKey;
    private String valia;
    private String userName;
    private String schoolName;
    private String trueName;
    private String mobile;
    private String idCard;
    private String nickName;

    private String regWay; //20180112  review增加。

    public String getRegWay() {
        return regWay;
    }

    public void setRegWay(String regWay) {
        this.regWay = regWay;
    }

    public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	public String getTrueName() {
		return trueName;
	}

	public void setTrueName(String trueName) {
		this.trueName = trueName;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	private Integer registFlag = 0; //注册标志：0-单独注册，1-excel批量注册

    public String getMachine() {
        return machine;
    }

    public void setMachine(String machine) {
        this.machine = machine;
    }

    public String getLbslng() {
        return lbslng;
    }

    public void setLbslng(String lbslng) {
        this.lbslng = lbslng;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getLoginAlais() {
        return loginAlais;
    }

    public void setLoginAlais(String loginAlais) {
        this.loginAlais = loginAlais;
    }

    public String getLoginPass() {
        return loginPass;
    }

    public void setLoginPass(String loginPass) {
        this.loginPass = loginPass;
    }

    public String getRegRoletype() {
        return regRoletype;
    }

    public void setRegRoletype(String regRoletype) {
        this.regRoletype = regRoletype;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getCacheKey() {
        return cacheKey;
    }

    public void setCacheKey(String cacheKey) {
        this.cacheKey = cacheKey;
    }

    public String getValia() {
        return valia;
    }

    public void setValia(String valia) {
        this.valia = valia;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getRegistFlag() {
        return registFlag;
    }

    public void setRegistFlag(Integer registFlag) {
        this.registFlag = registFlag;
    }
}
