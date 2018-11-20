package com.synapse.reading.dto.result;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.synapse.reading.model.BaseSystemParameter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * BaseSystemParameterResult
 * </p>
 *
 * @author wangyifan
 * @since 2018-11-20
 */
@ApiModel(value = "BaseSystemParameterResult对象", description = "")
public class BaseSystemParameterResult {

    private BaseSystemParameter  baseSystemParameter = new BaseSystemParameter();

    public BaseSystemParameterResult(){}

    public BaseSystemParameterResult(BaseSystemParameter  baseSystemParameter){
        this.baseSystemParameter = baseSystemParameter;
    }

    @JsonIgnore
    public BaseSystemParameter getModel() {
        return baseSystemParameter;
    }

    public void setModel(BaseSystemParameter baseSystemParameter) {
        this.baseSystemParameter = baseSystemParameter;
    }

@ApiModelProperty(value = "")
public String getRecId() {
    return baseSystemParameter.getRecId();
}

	public void setRecId(String rec_id) {
		baseSystemParameter.setRecId(rec_id);
	}

		@ApiModelProperty(value = "")
public String getParameterType() {
    return baseSystemParameter.getParameterType();
}

	public void setParameterType(String parameter_type) {
		baseSystemParameter.setParameterType(parameter_type);
	}

		@ApiModelProperty(value = "")
public String getParameterKey() {
    return baseSystemParameter.getParameterKey();
}

	public void setParameterKey(String parameter_key) {
		baseSystemParameter.setParameterKey(parameter_key);
	}

		@ApiModelProperty(value = "")
public String getParameterName() {
    return baseSystemParameter.getParameterName();
}

	public void setParameterName(String parameter_name) {
		baseSystemParameter.setParameterName(parameter_name);
	}

		@ApiModelProperty(value = "")
public String getParameterValue() {
    return baseSystemParameter.getParameterValue();
}

	public void setParameterValue(String parameter_value) {
		baseSystemParameter.setParameterValue(parameter_value);
	}

		@ApiModelProperty(value = "")
public Integer getWeight() {
    return baseSystemParameter.getWeight();
}

	public void setWeight(Integer weight) {
		baseSystemParameter.setWeight(weight);
	}

		@ApiModelProperty(value = "")
public String getParentParameterType() {
    return baseSystemParameter.getParentParameterType();
}

	public void setParentParameterType(String parent_parameter_type) {
		baseSystemParameter.setParentParameterType(parent_parameter_type);
	}

		@ApiModelProperty(value = "")
public String getParentParameterKey() {
    return baseSystemParameter.getParentParameterKey();
}

	public void setParentParameterKey(String parent_parameter_key) {
		baseSystemParameter.setParentParameterKey(parent_parameter_key);
	}

		@ApiModelProperty(value = "")
public String getAddTime() {
    return baseSystemParameter.getAddTime();
}

	public void setAddTime(String add_time) {
		baseSystemParameter.setAddTime(add_time);
	}

		@ApiModelProperty(value = "")
public String getUpdateTime() {
    return baseSystemParameter.getUpdateTime();
}

	public void setUpdateTime(String update_time) {
		baseSystemParameter.setUpdateTime(update_time);
	}

		
}
