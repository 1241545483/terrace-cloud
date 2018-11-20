package com.synapse.reading.model;

import java.util.Date;
import java.io.Serializable;


/**
 * <p>
 * 
 * </p>
 *
 * @author wangyifan
 * @since 2018-11-20
 */
public class BaseSystemParameter implements Serializable {

    private static final long serialVersionUID = 1L;

    private String recId;
    private String parameterType;
    private String parameterKey;
    private String parameterName;
    private String parameterValue;
    private Integer weight;
    private String parentParameterType;
    private String parentParameterKey;
    private String createTime;
    private String updateTime;


    public String getRecId() {
        return recId;
    }

    public void setRecId(String recId) {
        this.recId = recId;
    }

    public String getParameterType() {
        return parameterType;
    }

    public void setParameterType(String parameterType) {
        this.parameterType = parameterType;
    }

    public String getParameterKey() {
        return parameterKey;
    }

    public void setParameterKey(String parameterKey) {
        this.parameterKey = parameterKey;
    }

    public String getParameterName() {
        return parameterName;
    }

    public void setParameterName(String parameterName) {
        this.parameterName = parameterName;
    }

    public String getParameterValue() {
        return parameterValue;
    }

    public void setParameterValue(String parameterValue) {
        this.parameterValue = parameterValue;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public String getParentParameterType() {
        return parentParameterType;
    }

    public void setParentParameterType(String parentParameterType) {
        this.parentParameterType = parentParameterType;
    }

    public String getParentParameterKey() {
        return parentParameterKey;
    }

    public void setParentParameterKey(String parentParameterKey) {
        this.parentParameterKey = parentParameterKey;
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
