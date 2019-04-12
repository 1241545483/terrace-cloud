package com.synapse.reading.dto.result;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.synapse.reading.model.ShareImage;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * ShareImageResult
 * </p>
 *
 * @author liuguangfu
 * @since 2018-12-14
 */
@ApiModel(value = "ShareImageResult对象", description = "分享图片")
public class ShareImageResult {

    private ShareImage  shareImage = new ShareImage();

    public ShareImageResult(){}

    public ShareImageResult(ShareImage  shareImage) {
		if (shareImage != null) {
			this.shareImage = shareImage;
		}
	}
    @JsonIgnore
    public ShareImage getModel() {
        return shareImage;
    }

    public void setModel(ShareImage shareImage) {
        this.shareImage = shareImage;
    }

@ApiModelProperty(value = "主键")
public String getRecId() {
    return shareImage.getRecId();
}

	public void setRecId(String rec_id) {
		shareImage.setRecId(rec_id);
	}

		@ApiModelProperty(value = "用户（当前登录的用户信息）")
public String getUserId() {
    return shareImage.getUserId();
}

	public void setUserId(String user_id) {
		shareImage.setUserId(user_id);
	}

		@ApiModelProperty(value = "被分享的类型(audio:音频,video:视频)")
public String getShareType() {
    return shareImage.getShareType();
}

	public void setShareType(String share_type) {
		shareImage.setShareType(share_type);
	}

		@ApiModelProperty(value = "被分享主键")
public String getShareId() {
    return shareImage.getShareId();
}

	public void setShareId(String share_id) {
		shareImage.setShareId(share_id);
	}

		@ApiModelProperty(value = "分享图片URL")
public String getUrl() {
    return shareImage.getUrl();
}

	public void setUrl(String url) {
		shareImage.setUrl(url);
	}

		@ApiModelProperty(value = "创建人")
public String getCreateId() {
    return shareImage.getCreateId();
}

	public void setCreateId(String create_id) {
		shareImage.setCreateId(create_id);
	}

		@ApiModelProperty(value = "创建时间")
public String getCreateTime() {
    return shareImage.getCreateTime();
}

	public void setCreateTime(String create_time) {
		shareImage.setCreateTime(create_time);
	}

		@ApiModelProperty(value = "更新人")
public String getUpdateId() {
    return shareImage.getUpdateId();
}

	public void setUpdateId(String update_id) {
		shareImage.setUpdateId(update_id);
	}

		@ApiModelProperty(value = "更新时间")
public String getUpdateTime() {
    return shareImage.getUpdateTime();
}

	public void setUpdateTime(String update_time) {
		shareImage.setUpdateTime(update_time);
	}

		
}
