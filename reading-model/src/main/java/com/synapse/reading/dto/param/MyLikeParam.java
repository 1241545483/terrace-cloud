package com.synapse.reading.dto.param;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.synapse.reading.model.MyLike;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotNull;
import com.synapse.reading.web.valid.group.Update;
import com.synapse.reading.web.valid.group.Create;
import com.synapse.reading.web.valid.group.Search;

/**
 * <p>
 * MyLikeParam
 * </p>
 *
 * @author liuguangfu
 * @since 2018-12-01
 */
@ApiModel(value = "MyLikeParam对象", description = "我的点赞")
public class MyLikeParam  {

    private MyLike  myLike = new MyLike();

    public MyLikeParam(){}

    public MyLikeParam(MyLike  myLike){
        this.myLike = myLike;
    }

    @JsonIgnore
    public MyLike getModel() {
        return myLike;
    }

    public void setModel(MyLike  myLike) {
        this.myLike = myLike;
    }

    @ApiModelProperty(value = "主键")
public String getRecId() {
    return myLike.getRecId();
}

	public void setRecId(String rec_id) {
		myLike.setRecId(rec_id);
	}

        @ApiModelProperty(value = "被点赞类型(info:资讯,audio:音频,vedio:视频)")
public String getLikeType() {
    return myLike.getLikeType();
}

	public void setLikeType(String like_type) {
		myLike.setLikeType(like_type);
	}

        @ApiModelProperty(value = "被点赞主键")
public String getLikeId() {
    return myLike.getLikeId();
}

	public void setLikeId(String like_id) {
		myLike.setLikeId(like_id);
	}

        @ApiModelProperty(value = "点赞人")
public String getCreateId() {
    return myLike.getCreateId();
}

	public void setCreateId(String create_id) {
		myLike.setCreateId(create_id);
	}

        @ApiModelProperty(value = "点赞时间")
public String getCreateTime() {
    return myLike.getCreateTime();
}

	public void setCreateTime(String create_time) {
		myLike.setCreateTime(create_time);
	}

    }
