package com.synapse.reading.model.model;

import java.util.Date;
import java.io.Serializable;


/**
 * <p>
 * 系统模块和角色的关系
 * </p>
 *
 * @author liuguangfu
 * @since 2019-05-28
 */
public class RoleModelMapping implements Serializable {

    private static final long serialVersionUID = 1L;

    private String recId;
    private String modelId;
    private String roleId;
    private String status;
    private String createId;
    private String updateId;
    private String createTime;
    private String updateTime;


    public String getRecId() {
        return recId;
    }

    public void setRecId(String recId) {
        this.recId = recId;
    }

    public String getModelId() {
        return modelId;
    }

    public void setModelId(String modelId) {
        this.modelId = modelId;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCreateId() {
        return createId;
    }

    public void setCreateId(String createId) {
        this.createId = createId;
    }

    public String getUpdateId() {
        return updateId;
    }

    public void setUpdateId(String updateId) {
        this.updateId = updateId;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

}
