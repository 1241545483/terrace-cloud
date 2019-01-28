package com.synapse.reading.dto.param;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.synapse.reading.model.Book;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotNull;
import com.synapse.reading.web.valid.group.Update;
import com.synapse.reading.web.valid.group.Create;
import com.synapse.reading.web.valid.group.Search;

/**
 * <p>
 * BookParam
 * </p>
 *
 * @author liuguangfu
 * @since 2018-12-27
 */
@ApiModel(value = "BookParam对象", description = "")
public class BookParam  {

    private Book  book = new Book();

    public BookParam(){}

    public BookParam(Book  book){
        this.book = book;
    }

    @JsonIgnore
    public Book getModel() {
        return book;
    }

    public void setModel(Book  book) {
        this.book = book;
    }

	public String getNote() {
		return book.getNote();
	}

	public void setNote(String note) {
		book.setNote(note);
	}

	public String getPcCover() {
		return book.getPcCover();
	}

	public void setPcCover(String pcCover) {
		book.setPcCover(pcCover);
	}

	public String getPcBanner() {
		return book.getPcBanner();
	}

	public void setPcBanner(String pcBanner) {
		book.setPcBanner(pcBanner);
	}

	public String getMenu() {
		return book.getMenu();
	}

	public void setMenu(String menu) {
		book.setMenu(menu);
	}

	@ApiModelProperty(value = "主键")
public String getRecId() {
    return book.getRecId();
}

	public void setRecId(String rec_id) {
		book.setRecId(rec_id);
	}

        @ApiModelProperty(value = "书籍名称")
public String getName() {
    return book.getName();
}

	public void setName(String name) {
		book.setName(name);
	}

        @ApiModelProperty(value = "书籍描述")
public String getIntro() {
    return book.getIntro();
}

	public void setIntro(String intro) {
		book.setIntro(intro);
	}

        @ApiModelProperty(value = "slogan")
public String getSlogan() {
    return book.getSlogan();
}

	public void setSlogan(String slogan) {
		book.setSlogan(slogan);
	}

        @ApiModelProperty(value = "书籍类型(1 音频，2视频，3音频+视频）")
public String getType() {
    return book.getType();
}

	public void setType(String type) {
		book.setType(type);
	}

        @ApiModelProperty(value = "书籍封面(封面图片URL)")
public String getCover() {
    return book.getCover();
}

	public void setCover(String cover) {
		book.setCover(cover);
	}

        @ApiModelProperty(value = "banner")
public String getBanner() {
    return book.getBanner();
}

	public void setBanner(String banner) {
		book.setBanner(banner);
	}

        @ApiModelProperty(value = "发布状态(0 未发布，1已发布)")
public String getPublishStatus() {
    return book.getPublishStatus();
}

	public void setPublishStatus(String publish_status) {
		book.setPublishStatus(publish_status);
	}

        @ApiModelProperty(value = "状态(0 删除，1正常)")
public String getStatus() {
    return book.getStatus();
}

	public void setStatus(String status) {
		book.setStatus(status);
	}

        @ApiModelProperty(value = "排序")
public Integer getOrderNum() {
    return book.getOrderNum();
}

	public void setOrderNum(Integer order_num) {
		book.setOrderNum(order_num);
	}

        @ApiModelProperty(value = "访问数量")
public Long getVisitNum() {
    return book.getVisitNum();
}

	public void setVisitNum(Long visit_num) {
		book.setVisitNum(visit_num);
	}

        @ApiModelProperty(value = "创建人")
public String getCreateId() {
    return book.getCreateId();
}

	public void setCreateId(String create_id) {
		book.setCreateId(create_id);
	}

        @ApiModelProperty(value = "创建时间")
public String getCreateTime() {
    return book.getCreateTime();
}

	public void setCreateTime(String create_time) {
		book.setCreateTime(create_time);
	}

        @ApiModelProperty(value = "更新人")
public String getUpdateId() {
    return book.getUpdateId();
}

	public void setUpdateId(String update_id) {
		book.setUpdateId(update_id);
	}

        @ApiModelProperty(value = "更新时间")
public String getUpdateTime() {
    return book.getUpdateTime();
}

	public void setUpdateTime(String update_time) {
		book.setUpdateTime(update_time);
	}

	public String getAuthor() {
		return book.getAuthor();
	}

	public void setAuthor(String author) {
		book.setAuthor(author);
	}

	public String getQrCode() {
		return book.getQrCode();
	}

	public void setQrCode(String qrCode) {
		book.setQrCode(qrCode);
	}
}
