package com.synapse.reading.model.auth;

import java.util.Date;
import java.io.Serializable;


/**
 * <p>
 * 储存用户绑定关系表，用户和对应的openId，unionId等
 * </p>
 *
 * @author liuguangfu
 * @since 2019-05-28
 */
public class Bind implements Serializable {

    private static final long serialVersionUID = 1L;

    private String recId;
    private String userId;
    /**
     * 来源，目前来WEIXIN
     */
    private String privide;
    private String openId;
    private String unionId;
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


    public String getRecId() {
        return recId;
    }

    public void setRecId(String recId) {
        this.recId = recId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPrivide() {
        return privide;
    }

    public void setPrivide(String privide) {
        this.privide = privide;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getUnionId() {
        return unionId;
    }

    public void setUnionId(String unionId) {
        this.unionId = unionId;
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
