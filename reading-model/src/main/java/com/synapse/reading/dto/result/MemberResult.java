package com.synapse.reading.dto.result;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.synapse.reading.model.Member;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * MemberResult
 * </p>
 *
 * @author liuguangfu
 * @since 2018-12-06
 */
@ApiModel(value = "MemberResult对象", description = "用户信息")
public class MemberResult {

    private Member  member = new Member();

    public MemberResult(){}

    public MemberResult(Member  member) {
		if (member != null) {
			this.member = member;
		}
	}


    @JsonIgnore
    public Member getModel() {
        return member;
    }

    public void setModel(Member member) {
        this.member = member;
    }

@ApiModelProperty(value = "用户（当前登录的用户信息）")
public String getUserId() {
    return member.getUserId();
}

	public void setUserId(String user_id) {
		member.setUserId(user_id);
	}

		@ApiModelProperty(value = "积分")
public Integer getPoint() {
    return member.getPoint();
}

	public void setPoint(Integer point) {
		member.setPoint(point);
	}

		@ApiModelProperty(value = "创建人")
public String getCreateId() {
    return member.getCreateId();
}

	public void setCreateId(String create_id) {
		member.setCreateId(create_id);
	}

		@ApiModelProperty(value = "创建时间")
public String getCreateTime() {
    return member.getCreateTime();
}

	public void setCreateTime(String create_time) {
		member.setCreateTime(create_time);
	}

		@ApiModelProperty(value = "更新人")
public String getUpdateId() {
    return member.getUpdateId();
}

	public void setUpdateId(String update_id) {
		member.setUpdateId(update_id);
	}

		@ApiModelProperty(value = "更新时间")
public String getUpdateTime() {
    return member.getUpdateTime();
}

	public void setUpdateTime(String update_time) {
		member.setUpdateTime(update_time);
	}

		
}
