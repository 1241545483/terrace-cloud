package com.synapse.reading.model.auth;

import java.util.Date;
import java.io.Serializable;


/**
 * <p>
 * 系统模块和code的关系
 * </p>
 *
 * @author liuguangfu
 * @since 2019-05-28
 */
public class ModelOperate implements Serializable {

    private static final long serialVersionUID = 1L;

    private String recId;
    private String modelId;
    /**
     * 组装的请求方式和方法，用来判断是否有访问权限
     */
    private String code;
    private String desc;
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
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
