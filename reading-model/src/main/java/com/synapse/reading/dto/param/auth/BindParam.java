package com.synapse.reading.dto.param.auth;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.synapse.reading.model.auth.Bind;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * BindParam
 * </p>
 *
 * @author liuguangfu
 * @since 2019-05-28
 */
@ApiModel(value = "BindParam对象", description = "储存用户绑定关系表，用户和对应的openId，unionId等")
public class BindParam  {

    private Bind  bind = new Bind();

    public BindParam(){}

    public BindParam(Bind  bind){
        this.bind = bind;
    }

    @JsonIgnore
    public Bind getModel() {
        return bind;
    }

    public void setModel(Bind  bind) {
        this.bind = bind;
    }

    @ApiModelProperty(value = "")
public String getRecId() {
    return bind.getRecId();
}

	public void setRecId(String rec_id) {
		bind.setRecId(rec_id);
	}

        @ApiModelProperty(value = "")
public String getUserId() {
    return bind.getUserId();
}

	public void setUserId(String user_id) {
		bind.setUserId(user_id);
	}

        @ApiModelProperty(value = "来源，目前来WEIXIN")
public String getPrivide() {
    return bind.getPrivide();
}

	public void setPrivide(String privide) {
		bind.setPrivide(privide);
	}

        @ApiModelProperty(value = "")
public String getOpenId() {
    return bind.getOpenId();
}

	public void setOpenId(String open_id) {
		bind.setOpenId(open_id);
	}

        @ApiModelProperty(value = "")
public String getUnionId() {
    return bind.getUnionId();
}

	public void setUnionId(String union_id) {
		bind.setUnionId(union_id);
	}

        @ApiModelProperty(value = "创建人")
public String getCreateId() {
    return bind.getCreateId();
}

	public void setCreateId(String create_id) {
		bind.setCreateId(create_id);
	}

        @ApiModelProperty(value = "创建时间")
public String getCreateTime() {
    return bind.getCreateTime();
}

	public void setCreateTime(String create_time) {
		bind.setCreateTime(create_time);
	}

        @ApiModelProperty(value = "更新人")
public String getUpdateId() {
    return bind.getUpdateId();
}

	public void setUpdateId(String update_id) {
		bind.setUpdateId(update_id);
	}

        @ApiModelProperty(value = "更新时间")
public String getUpdateTime() {
    return bind.getUpdateTime();
}

	public void setUpdateTime(String update_time) {
		bind.setUpdateTime(update_time);
	}

    }
