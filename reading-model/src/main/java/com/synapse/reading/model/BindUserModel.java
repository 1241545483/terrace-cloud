package com.synapse.reading.model;

import com.synapse.reading.web.valid.group.Dict;



public class BindUserModel {
    private String recId;

    private String unionId;

    private String openId;

    private String password;

    private String phone;

    private String name;
    
    private String organization;

    @Dict("PROJECT_APPLY_PEOPLE_SEXY")
    private Integer sexy;

    private String sexyTxt;

    @Dict("SUBJECT")
    private String subject;

    private String subjectTxt;

    @Dict("IDENTITY")
    private String identity;

    private String identityTxt;

    @Dict("PROJECT_APPLY_PEOPLE_STATUS")
    private Integer status;

    private String statusTxt;

    private Integer checkStatus;

    private String checkTime;

    @Dict("PHASE")
    private String phase;

    private String phaseTxt;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUnionId() {
        return unionId;
    }

    public void setUnionId(String unionId) {
        this.unionId = unionId;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRecId() {
        return recId;
    }

    public void setRecId(String recId) {
        this.recId = recId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getSexy() {
        return sexy;
    }

    public void setSexy(Integer sexy) {
        this.sexy = sexy;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject == null ? null : subject.trim();
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity == null ? null : identity.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getCheckStatus() {
        return checkStatus;
    }

    public void setCheckStatus(Integer checkStatus) {
        this.checkStatus = checkStatus;
    }

    public String getCheckTime() {
        return checkTime;
    }

    public void setCheckTime(String checkTime) {
        this.checkTime = checkTime == null ? null : checkTime.trim();
    }

    public String getSexyTxt() {
        return sexyTxt;
    }

    public void setSexyTxt(String sexyTxt) {
        this.sexyTxt = sexyTxt;
    }

    public String getSubjectTxt() {
        return subjectTxt;
    }

    public void setSubjectTxt(String subjectTxt) {
        this.subjectTxt = subjectTxt;
    }

    public String getIdentityTxt() {
        return identityTxt;
    }

    public void setIdentityTxt(String identityTxt) {
        this.identityTxt = identityTxt;
    }

    public String getStatusTxt() {
        return statusTxt;
    }

    public void setStatusTxt(String statusTxt) {
        this.statusTxt = statusTxt;
    }

	public String getOrganization() {
		return organization;
	}

	public void setOrganization(String organization) {
		this.organization = organization;
	}

    public String getPhase() {
        return phase;
    }

    public void setPhase(String phase) {
        this.phase = phase;
    }

    public String getPhaseTxt() {
        return phaseTxt;
    }

    public void setPhaseTxt(String phaseTxt) {
        this.phaseTxt = phaseTxt;
    }
}