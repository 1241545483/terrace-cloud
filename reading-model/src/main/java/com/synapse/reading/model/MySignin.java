package com.synapse.reading.model;

import java.util.Date;
import java.io.Serializable;


/**
 * <p>
 * 我的签到
 * </p>
 *
 * @author liuguangfu
 * @since 2018-12-29
 */
public class MySignin implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private String recId;
    /**
     * 签到获得的积分
     */
    private Integer point;
    /**
     * 签到人
     */
    private String createId;
    /**
     * 签到时间
     */
    private String createTime;


    public String getRecId() {
        return recId;
    }

    public void setRecId(String recId) {
        this.recId = recId;
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

}
