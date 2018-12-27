package com.synapse.reading.model;

import java.util.Date;
import java.io.Serializable;


/**
 * <p>
 * 用户信息
 * </p>
 *
 * @author liuguangfu
 * @since 2018-12-27
 */
public class Member implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户（当前登录的用户信息）
     */
    private String userId;
    /**
     * 积分
     */
    private Integer point;
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


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getPoint() {
        return point;
    }

    public void setPoint(Integer point) {
        this.point = point;
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
