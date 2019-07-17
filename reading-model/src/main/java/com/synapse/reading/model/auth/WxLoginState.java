package com.synapse.reading.model.auth;

import java.util.Date;
import java.io.Serializable;


/**
 * <p>
 *
 * </p>
 *
 * @author liuguangfu
 * @since 2019-05-28
 */
public class WxLoginState implements Serializable {

    private static final long serialVersionUID = 1L;

    private String recId;
    private String openId;
    private String unionId;
    /**
     * 登陆成功token
     */
    private String token;
    /**
     * 登陆状态
     */
    private String status;
    private String statusDesc;


    public String getRecId() {
        return recId;
    }

    public void setRecId(String recId) {
        this.recId = recId;
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

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatusDesc() {
        return statusDesc;
    }

    public void setStatusDesc(String statusDesc) {
        this.statusDesc = statusDesc;
    }

}
