package com.synapse.reading.model.model;

import java.util.Date;
import java.io.Serializable;


/**
 * <p>
 * 系统模块
 * </p>
 *
 * @author liuguangfu
 * @since 2019-05-28
 */
public class Model implements Serializable {

    private static final long serialVersionUID = 1L;

    private String recId;
    /**
     * 菜单ID
     */
    private String menuId;
    private String operateDesc;
    /**
     * 模块名称
     */
    private String name;
    private String status;
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

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }

    public String getOperateDesc() {
        return operateDesc;
    }

    public void setOperateDesc(String operateDesc) {
        this.operateDesc = operateDesc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
