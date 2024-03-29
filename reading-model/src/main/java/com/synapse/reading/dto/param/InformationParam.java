package com.synapse.reading.dto.param;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.synapse.reading.model.Information;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotNull;
import com.synapse.reading.web.valid.group.Update;
import com.synapse.reading.web.valid.group.Create;
import com.synapse.reading.web.valid.group.Search;

/**
 * <p>
 * InformationParam
 * </p>
 *
 * @author liuguangfu
 * @since 2018-12-01
 */
@ApiModel(value = "InformationParam对象", description = "资讯模块")
public class InformationParam  {

    private Information  information = new Information();

    public InformationParam(){}

    public InformationParam(Information  information){
        this.information = information;
    }

    public String getUrl() {
        return information.getUrl();
    }

    public void setUrl(String url) {
        information.setUrl(url);
    }

    @JsonIgnore
    public Information getModel() {
        return information;
    }

    public void setModel(Information  information) {
        this.information = information;
    }

    @ApiModelProperty(value = "主键")
public String getRecId() {
    return information.getRecId();
}

	public void setRecId(String rec_id) {
		information.setRecId(rec_id);
	}

        @ApiModelProperty(value = "标题")
public String getTitle() {
    return information.getTitle();
}

	public void setTitle(String title) {
		information.setTitle(title);
	}

        @ApiModelProperty(value = "作者")
public String getAuthor() {
    return information.getAuthor();
}

	public void setAuthor(String author) {
		information.setAuthor(author);
	}

        @ApiModelProperty(value = "内容")
public String getContent() {
    return information.getContent();
}

	public void setContent(String content) {
		information.setContent(content);
	}

        @ApiModelProperty(value = "封面")
public String getCover() {
    return information.getCover();
}

	public void setCover(String cover) {
		information.setCover(cover);
	}

        @ApiModelProperty(value = "阅读数量")
public Long getReadNum() {
    return information.getReadNum();
}

	public void setReadNum(Long read_num) {
		information.setReadNum(read_num);
	}

        @ApiModelProperty(value = "点赞数量")
public Long getLikeNum() {
    return information.getLikeNum();
}

	public void setLikeNum(Long like_num) {
		information.setLikeNum(like_num);
	}

        @ApiModelProperty(value = "0 未发布，1已发布")
public String getPublishStatus() {
    return information.getPublishStatus();
}

	public void setPublishStatus(String publish_status) {
		information.setPublishStatus(publish_status);
	}

        @ApiModelProperty(value = "0 删除，1正常")
public String getStatus() {
    return information.getStatus();
}

	public void setStatus(String status) {
		information.setStatus(status);
	}

        @ApiModelProperty(value = "创建人")
public String getCreateId() {
    return information.getCreateId();
}

	public void setCreateId(String create_id) {
		information.setCreateId(create_id);
	}

        @ApiModelProperty(value = "创建时间")
public String getCreateTime() {
    return information.getCreateTime();
}

	public void setCreateTime(String create_time) {
		information.setCreateTime(create_time);
	}

        @ApiModelProperty(value = "更新人")
public String getUpdateId() {
    return information.getUpdateId();
}

	public void setUpdateId(String update_id) {
		information.setUpdateId(update_id);
	}

        @ApiModelProperty(value = "更新时间")
public String getUpdateTime() {
    return information.getUpdateTime();
}

	public void setUpdateTime(String update_time) {
		information.setUpdateTime(update_time);
	}

    }
