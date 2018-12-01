package com.synapse.reading.dto.result;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.synapse.reading.model.Discuss;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * DiscussResult
 * </p>
 *
 * @author liuguangfu
 * @since 2018-12-01
 */
@ApiModel(value = "DiscussResult对象", description = "评论表")
public class DiscussResult {

    private Discuss  discuss = new Discuss();

    public DiscussResult(){}

    public DiscussResult(Discuss  discuss){
        this.discuss = discuss;
    }

    @JsonIgnore
    public Discuss getModel() {
        return discuss;
    }

    public void setModel(Discuss discuss) {
        this.discuss = discuss;
    }

@ApiModelProperty(value = "主键")
public String getRecId() {
    return discuss.getRecId();
}

	public void setRecId(String rec_id) {
		discuss.setRecId(rec_id);
	}

		@ApiModelProperty(value = "被评论类型(info:资讯,reply:评论回复)")
public String getCommentType() {
    return discuss.getCommentType();
}

	public void setCommentType(String comment_type) {
		discuss.setCommentType(comment_type);
	}

		@ApiModelProperty(value = "被评论主键")
public String getCommentId() {
    return discuss.getCommentId();
}

	public void setCommentId(String comment_id) {
		discuss.setCommentId(comment_id);
	}

		@ApiModelProperty(value = "评论内容")
public String getContent() {
    return discuss.getContent();
}

	public void setContent(String content) {
		discuss.setContent(content);
	}

		@ApiModelProperty(value = "点赞数量")
public Long getLikeNum() {
    return discuss.getLikeNum();
}

	public void setLikeNum(Long like_num) {
		discuss.setLikeNum(like_num);
	}

		@ApiModelProperty(value = "评论状态(0:删除,1正常)")
public String getStatus() {
    return discuss.getStatus();
}

	public void setStatus(String status) {
		discuss.setStatus(status);
	}

		@ApiModelProperty(value = "评论人")
public String getCreateId() {
    return discuss.getCreateId();
}

	public void setCreateId(String create_id) {
		discuss.setCreateId(create_id);
	}

		@ApiModelProperty(value = "评论时间")
public String getCreateTime() {
    return discuss.getCreateTime();
}

	public void setCreateTime(String create_time) {
		discuss.setCreateTime(create_time);
	}

		
}