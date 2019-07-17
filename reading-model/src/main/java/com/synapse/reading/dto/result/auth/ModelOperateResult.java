package com.synapse.reading.dto.result.auth;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.synapse.reading.model.auth.ModelOperate;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * ModelOperateResult
 * </p>
 *
 * @author liuguangfu
 * @since 2019-05-28
 */
@ApiModel(value = "ModelOperateResult对象", description = "系统模块和code的关系")
public class ModelOperateResult {

    private ModelOperate  modelOperate = new ModelOperate();

    public ModelOperateResult(){}

    public ModelOperateResult(ModelOperate  modelOperate){
        this.modelOperate = modelOperate;
    }

    @JsonIgnore
    public ModelOperate getModel() {
        return modelOperate;
    }

    public void setModel(ModelOperate modelOperate) {
        this.modelOperate = modelOperate;
    }

@ApiModelProperty(value = "")
public String getRecId() {
    return modelOperate.getRecId();
}

	public void setRecId(String rec_id) {
		modelOperate.setRecId(rec_id);
	}

		@ApiModelProperty(value = "")
public String getModelId() {
    return modelOperate.getModelId();
}

	public void setModelId(String model_id) {
		modelOperate.setModelId(model_id);
	}

		@ApiModelProperty(value = "组装的请求方式和方法，用来判断是否有访问权限")
public String getCode() {
    return modelOperate.getCode();
}

	public void setCode(String code) {
		modelOperate.setCode(code);
	}

		@ApiModelProperty(value = "")
public String getDesc() {
    return modelOperate.getDesc();
}

	public void setDesc(String desc) {
		modelOperate.setDesc(desc);
	}

		@ApiModelProperty(value = "")
public String getStatus() {
    return modelOperate.getStatus();
}

	public void setStatus(String status) {
		modelOperate.setStatus(status);
	}

		@ApiModelProperty(value = "")
public String getCreateId() {
    return modelOperate.getCreateId();
}

	public void setCreateId(String create_id) {
		modelOperate.setCreateId(create_id);
	}

		@ApiModelProperty(value = "")
public String getUpdateId() {
    return modelOperate.getUpdateId();
}

	public void setUpdateId(String update_id) {
		modelOperate.setUpdateId(update_id);
	}

		@ApiModelProperty(value = "")
public String getCreateTime() {
    return modelOperate.getCreateTime();
}

	public void setCreateTime(String create_time) {
		modelOperate.setCreateTime(create_time);
	}

		@ApiModelProperty(value = "")
public String getUpdateTime() {
    return modelOperate.getUpdateTime();
}

	public void setUpdateTime(String update_time) {
		modelOperate.setUpdateTime(update_time);
	}


}
