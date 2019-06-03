package com.synapse.reading.dto.result.result;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.synapse.reading.model.WxLoginState;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * WxLoginStateResult
 * </p>
 *
 * @author liuguangfu
 * @since 2019-05-28
 */
@ApiModel(value = "WxLoginStateResult对象", description = "")
public class WxLoginStateResult {

    private WxLoginState  wxLoginState = new WxLoginState();

    public WxLoginStateResult(){}

    public WxLoginStateResult(WxLoginState  wxLoginState){
        this.wxLoginState = wxLoginState;
    }

    @JsonIgnore
    public WxLoginState getModel() {
        return wxLoginState;
    }

    public void setModel(WxLoginState wxLoginState) {
        this.wxLoginState = wxLoginState;
    }

@ApiModelProperty(value = "")
public String getRecId() {
    return wxLoginState.getRecId();
}

	public void setRecId(String rec_id) {
		wxLoginState.setRecId(rec_id);
	}

		@ApiModelProperty(value = "")
public String getOpenId() {
    return wxLoginState.getOpenId();
}

	public void setOpenId(String openid) {
		wxLoginState.setOpenId(openid);
	}

		@ApiModelProperty(value = "")
public String getUnionId() {
    return wxLoginState.getUnionId();
}

	public void setUnionId(String unionid) {
		wxLoginState.setUnionId(unionid);
	}

		@ApiModelProperty(value = "登陆成功token")
public String getToken() {
    return wxLoginState.getToken();
}

	public void setToken(String token) {
		wxLoginState.setToken(token);
	}

		@ApiModelProperty(value = "登陆状态")
public String getStatus() {
    return wxLoginState.getStatus();
}

	public void setStatus(String status) {
		wxLoginState.setStatus(status);
	}

		@ApiModelProperty(value = "")
public String getStatusDesc() {
    return wxLoginState.getStatusDesc();
}

	public void setStatusDesc(String status_desc) {
		wxLoginState.setStatusDesc(status_desc);
	}

		
}
