package com.synapse.reading.dto.result;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.synapse.reading.model.Recommend;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * RecommendResult
 * </p>
 *
 * @author liuguangfu
 * @since 2018-12-27
 */
@ApiModel(value = "RecommendResult对象", description = "推荐")
public class RecommendResult {

    private Recommend  recommend = new Recommend();

    public RecommendResult(){}

    public RecommendResult(Recommend  recommend){
        this.recommend = recommend;
    }

    @JsonIgnore
    public Recommend getModel() {
        return recommend;
    }

    public void setModel(Recommend recommend) {
        this.recommend = recommend;
    }

@ApiModelProperty(value = "主键")
public String getRecId() {
    return recommend.getRecId();
}

	public void setRecId(String rec_id) {
		recommend.setRecId(rec_id);
	}

		@ApiModelProperty(value = "被推荐类型(info:资讯,audio:音频,vedio:视频)")
public String getRecommendtType() {
    return recommend.getRecommendtType();
}

	public void setRecommendtType(String recommendt_type) {
		recommend.setRecommendtType(recommendt_type);
	}

		@ApiModelProperty(value = "被推荐主键")
public String getRecommendId() {
    return recommend.getRecommendId();
}

	public void setRecommendId(String recommend_id) {
		recommend.setRecommendId(recommend_id);
	}

		@ApiModelProperty(value = "推荐人")
public String getCreateId() {
    return recommend.getCreateId();
}

	public void setCreateId(String create_id) {
		recommend.setCreateId(create_id);
	}

		@ApiModelProperty(value = "推荐时间")
public String getCreateTime() {
    return recommend.getCreateTime();
}

	public void setCreateTime(String create_time) {
		recommend.setCreateTime(create_time);
	}

		@ApiModelProperty(value = "开始时间")
public String getStartTime() {
    return recommend.getStartTime();
}

	public void setStartTime(String start_time) {
		recommend.setStartTime(start_time);
	}

		@ApiModelProperty(value = "结束时间")
public String getEndTime() {
    return recommend.getEndTime();
}

	public void setEndTime(String end_time) {
		recommend.setEndTime(end_time);
	}

		
}
