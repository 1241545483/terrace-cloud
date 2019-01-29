package com.synapse.reading.dto.param;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.synapse.reading.model.Topic;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotNull;
import com.synapse.reading.web.valid.group.Update;
import com.synapse.reading.web.valid.group.Create;
import com.synapse.reading.web.valid.group.Search;

/**
 * <p>
 * TopicParam
 * </p>
 *
 * @author liuguangfu
 * @since 2019-01-28
 */
@ApiModel(value = "TopicParam对象", description = "主题，关联专辑")
public class TopicParam  {

    private Topic  topic = new Topic();

    public TopicParam(){}

    public TopicParam(Topic  topic){
        this.topic = topic;
    }

    @JsonIgnore
    public Topic getModel() {
        return topic;
    }

    public String getCover() {
        return topic.getCover();
    }

    public void setCover(String cover) {
        topic.setCover(cover);
    }

    public String getPcCover() {
        return topic.getPcCover();
    }

    public void setPcCover(String pcCover) {
        topic.setPcCover(pcCover);
    }

    public String getPcBanner() {
        return topic.getPcBanner();
    }

    public void setPcBanner(String pcBanner) {
        topic.setPcBanner(pcBanner);
    }

    public String getIntro() {
        return topic.getIntro();
    }

    public void setIntro(String intro) {
        topic.setIntro(intro);
    }

    public String getSlogan() {
        return topic.getSlogan();
    }

    public void setSlogan(String slogan) {
        topic.setSlogan(slogan);
    }

    public String getPublishStatus() {
        return topic.getPublishStatus();
    }

    public void setPublishStatus(String publishStatus) {
        topic.setPublishStatus(publishStatus);
    }

    public String getStatus() {
        return topic.getStatus();
    }

    public void setStatus(String status) {
        topic.setStatus(status);
    }

    public String getDetail() {
        return topic.getDetail();
    }

    public void setDetail(String detail) {
        topic.setDetail(detail);
    }

    public void setModel(Topic  topic) {
        this.topic = topic;
    }

    @ApiModelProperty(value = "主键")
public String getRecId() {
    return topic.getRecId();
}

	public void setRecId(String rec_id) {
		topic.setRecId(rec_id);
	}

        @ApiModelProperty(value = "目录名字")
public String getName() {
    return topic.getName();
}

	public void setName(String name) {
		topic.setName(name);
	}

        @ApiModelProperty(value = "封面url")
public String getBanner() {
    return topic.getBanner();
}

	public void setBanner(String banner) {
		topic.setBanner(banner);
	}

        @ApiModelProperty(value = "排序")
public Integer getOrderNum() {
    return topic.getOrderNum();
}

	public void setOrderNum(Integer order_num) {
		topic.setOrderNum(order_num);
	}

        @ApiModelProperty(value = "创建人")
public String getCreateId() {
    return topic.getCreateId();
}

	public void setCreateId(String create_id) {
		topic.setCreateId(create_id);
	}

        @ApiModelProperty(value = "创建时间")
public String getCreateTime() {
    return topic.getCreateTime();
}

	public void setCreateTime(String create_time) {
		topic.setCreateTime(create_time);
	}

        @ApiModelProperty(value = "更新人")
public String getUpdateId() {
    return topic.getUpdateId();
}

	public void setUpdateId(String update_id) {
		topic.setUpdateId(update_id);
	}

        @ApiModelProperty(value = "更新时间")
public String getUpdateTime() {
    return topic.getUpdateTime();
}

	public void setUpdateTime(String update_time) {
		topic.setUpdateTime(update_time);
	}

    }
