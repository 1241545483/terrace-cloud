package com.synapse.reading.dto.param;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.synapse.reading.model.OrgCode;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotNull;
import com.synapse.reading.web.valid.group.Update;
import com.synapse.reading.web.valid.group.Create;
import com.synapse.reading.web.valid.group.Search;

/**
 * <p>
 * OrgCodeParam
 * </p>
 *
 * @author liuguangfu
 * @since 2019-07-08
 */
@ApiModel(value = "OrgCodeParam对象", description = "")
public class OrgCodeParam  {

    private OrgCode  orgCode = new OrgCode();

    public OrgCodeParam(){}

    public OrgCodeParam(OrgCode  orgCode){
        this.orgCode = orgCode;
    }

    @JsonIgnore
    public OrgCode getModel() {
        return orgCode;
    }

    public void setModel(OrgCode  orgCode) {
        this.orgCode = orgCode;
    }

    @ApiModelProperty(value = "自增用于作为班级code码")
public Integer getOrgCode() {
    return orgCode.getOrgCode();
}

	public void setOrgCode(Integer org_code) {
		orgCode.setOrgCode(org_code);
	}

        @ApiModelProperty(value = "班级状态")
public String getStatus() {
    return orgCode.getStatus();
}

	public void setStatus(String status) {
		orgCode.setStatus(status);
	}

        @ApiModelProperty(value = "创建人")
public String getCreateId() {
    return orgCode.getCreateId();
}

	public void setCreateId(String create_id) {
		orgCode.setCreateId(create_id);
	}

        @ApiModelProperty(value = "创建时间")
public String getCreateTime() {
    return orgCode.getCreateTime();
}

	public void setCreateTime(String create_time) {
		orgCode.setCreateTime(create_time);
	}

        @ApiModelProperty(value = "更新人")
public String getUpdateId() {
    return orgCode.getUpdateId();
}

	public void setUpdateId(String update_id) {
		orgCode.setUpdateId(update_id);
	}

        @ApiModelProperty(value = "更新时间")
public String getUpdateTime() {
    return orgCode.getUpdateTime();
}

	public void setUpdateTime(String update_time) {
		orgCode.setUpdateTime(update_time);
	}

    public String getQrCode() {
        return orgCode.getQrCode();
    }

    public void setQrCode(String qrCode) {
        orgCode.setQrCode(qrCode);
    }
}
