package com.synapse.reading.model;

import java.io.Serializable;


/**
 * <p>
 * 订单
 * </p>
 *
 * @author liuguangfu
 * @since 2019-04-17
 */
public class SchoolTradeOrder implements Serializable {

    private static final long serialVersionUID = 1L;

    private String recId;

    private String type;


    public String getRecId() {
        return recId;
    }

    public void setRecId(String recId) {
        this.recId = recId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


}
