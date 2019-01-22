package com.synapse.reading.dto.result;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.synapse.reading.model.Category;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * CategoryResult
 * </p>
 *
 * @author liuguangfu
 * @since 2019-01-22
 */
@ApiModel(value = "CategoryResult对象", description = "推荐中高考书籍目录（三级）")
public class CategoryResult {

    private Category  category = new Category();

    public CategoryResult(){}

    public CategoryResult(Category  category){
        this.category = category;
    }

    @JsonIgnore
    public Category getModel() {
        return category;
    }

    public void setModel(Category category) {
        this.category = category;
    }

@ApiModelProperty(value = "主键")
public String getRecId() {
    return category.getRecId();
}

	public void setRecId(String rec_id) {
		category.setRecId(rec_id);
	}

		@ApiModelProperty(value = "目录名字")
public String getName() {
    return category.getName();
}

	public void setName(String name) {
		category.setName(name);
	}

		@ApiModelProperty(value = "父级id")
public String getPid() {
    return category.getPid();
}

	public void setPid(String pid) {
		category.setPid(pid);
	}

		@ApiModelProperty(value = "爷级id")
public String getPpid() {
    return category.getPpid();
}

	public void setPpid(String ppid) {
		category.setPpid(ppid);
	}

		@ApiModelProperty(value = "项目id")
public String getItemId() {
    return category.getItemId();
}

	public void setItemId(String item_id) {
		category.setItemId(item_id);
	}

		@ApiModelProperty(value = "类型")
public String getItemType() {
    return category.getItemType();
}

	public void setItemType(String item_type) {
		category.setItemType(item_type);
	}

		@ApiModelProperty(value = "等级")
public String getLevel() {
    return category.getLevel();
}

	public void setLevel(String level) {
		category.setLevel(level);
	}

		@ApiModelProperty(value = "创建人")
public String getCreateId() {
    return category.getCreateId();
}

	public void setCreateId(String create_id) {
		category.setCreateId(create_id);
	}

		@ApiModelProperty(value = "创建时间")
public String getCreateTime() {
    return category.getCreateTime();
}

	public void setCreateTime(String create_time) {
		category.setCreateTime(create_time);
	}

		@ApiModelProperty(value = "更新人")
public String getUpdateId() {
    return category.getUpdateId();
}

	public void setUpdateId(String update_id) {
		category.setUpdateId(update_id);
	}

		@ApiModelProperty(value = "更新时间")
public String getUpdateTime() {
    return category.getUpdateTime();
}

	public void setUpdateTime(String update_time) {
		category.setUpdateTime(update_time);
	}

		
}
