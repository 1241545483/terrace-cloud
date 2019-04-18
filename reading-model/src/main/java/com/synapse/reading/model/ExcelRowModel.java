package com.synapse.reading.model;

/**
 * Created by huwei on 2017/12/1.
 */
public class ExcelRowModel {

    private String userName;

    private String subject;

    private String phone;

    private String idCard;

    private String phase;

    private String officeStatus;

    private String teacherNature;

    private String regRoletype;

    private String errMsg;



    public String getRegRoletype() {
        return regRoletype;
    }

    public void setRegRoletype(String regRoletype) {
        this.regRoletype = regRoletype;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPhase() {
        return phase;
    }

    public void setPhase(String phase) {
        this.phase = phase;
    }

    public String getOfficeStatus() {
        return officeStatus;
    }

    public void setOfficeStatus(String officeStatus) {
        this.officeStatus = officeStatus;
    }

    public String getTeacherNature() {
        return teacherNature;
    }

    public void setTeacherNature(String teacherNature) {
        this.teacherNature = teacherNature;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }
}
