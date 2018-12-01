package com.synapse.reading.dto.result;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.synapse.reading.model.MyCollect;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * MyCollectResult
 * </p>
 *
 * @author liuguangfu
 * @since 2018-12-01
 */
@ApiModel(value = "MyCollectResult对象", description = "我的收藏")
public class MyCollectResult {

    private MyCollect  myCollect = new MyCollect();

    public MyCollectResult(){}

    public MyCollectResult(MyCollect  myCollect){
        this.myCollect = myCollect;
    }

    @JsonIgnore
    public MyCollect getModel() {
        return myCollect;
    }

    public void setModel(MyCollect myCollect) {
        this.myCollect = myCollect;
    }

@ApiModelProperty(value = "主键")
public String getRecId() {
    return myCollect.getRecId();
}

	public void setRecId(String rec_id) {
		myCollect.setRecId(rec_id);
	}

		@ApiModelProperty(value = "被收藏类型(info:资讯,audio:音频,vedio:视频)")
public String getCollectType() {
    return myCollect.getCollectType();
}

	public void setCollectType(String collect_type) {
		myCollect.setCollectType(collect_type);
	}

		@ApiModelProperty(value = "被收藏主键")
public String getCollectId() {
    return myCollect.getCollectId();
}

	public void setCollectId(String collect_id) {
		myCollect.setCollectId(collect_id);
	}

		@ApiModelProperty(value = "收藏人")
public String getCreateId() {
    return myCollect.getCreateId();
}

	public void setCreateId(String create_id) {
		myCollect.setCreateId(create_id);
	}

		@ApiModelProperty(value = "收藏时间")
public String getCreateTime() {
    return myCollect.getCreateTime();
}

	public void setCreateTime(String create_time) {
		myCollect.setCreateTime(create_time);
	}

		
}
