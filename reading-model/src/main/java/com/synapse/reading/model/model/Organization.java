package com.synapse.reading.model.model;

import java.util.Date;
import java.io.Serializable;


/**
 * <p>
 * 组织机构
 * </p>
 *
 * @author liuguangfu
 * @since 2019-05-28
 */
public class Organization implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 机构id
     */
    private String orgId;
    private String orgName;
    private String status;
    /**
     * 1. 管理性质
     */
    private String orgNature;
    /**
     * 上级单位是指： 行政上的隶属关系
     */
    private String parentOrgId;
    private String orgLocation;
    /**
     * 创建人
     */
    private String createId;
    /**
     * 创建时间
     */
    private String createTime;
    /**
     * 更新人
     */
    private String updateId;
    /**
     * 更新时间
     */
    private String updateTime;


    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getOrgNature() {
        return orgNature;
    }

    public void setOrgNature(String orgNature) {
        this.orgNature = orgNature;
    }

    public String getParentOrgId() {
        return parentOrgId;
    }

    public void setParentOrgId(String parentOrgId) {
        this.parentOrgId = parentOrgId;
    }

    public String getOrgLocation() {
        return orgLocation;
    }

    public void setOrgLocation(String orgLocation) {
        this.orgLocation = orgLocation;
    }

    public String getCreateId() {
        return createId;
    }

    public void setCreateId(String createId) {
        this.createId = createId;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateId() {
        return updateId;
    }

    public void setUpdateId(String updateId) {
        this.updateId = updateId;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

}
