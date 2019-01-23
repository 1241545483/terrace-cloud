package com.synapse.reading.dto.result;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.synapse.reading.model.RelevanceItem;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * RelevanceItemResult
 * </p>
 *
 * @author liuguangfu
 * @since 2019-01-23
 */
@ApiModel(value = "RelevanceItemResult对象", description = "书籍与目录对应关系")
public class RelevanceItemResult {

    private RelevanceItem  relevanceItem = new RelevanceItem();

    public RelevanceItemResult(){}

    public RelevanceItemResult(RelevanceItem  relevanceItem){
        this.relevanceItem = relevanceItem;
    }

    @JsonIgnore
    public RelevanceItem getModel() {
        return relevanceItem;
    }

    public void setModel(RelevanceItem relevanceItem) {
        this.relevanceItem = relevanceItem;
    }

@ApiModelProperty(value = "主键")
public String getRecId() {
    return relevanceItem.getRecId();
}

	public void setRecId(String rec_id) {
		relevanceItem.setRecId(rec_id);
	}

		@ApiModelProperty(value = "目录id")
public String getCategoryId() {
    return relevanceItem.getCategoryId();
}

	public void setCategoryId(String category_id) {
		relevanceItem.setCategoryId(category_id);
	}

		@ApiModelProperty(value = "项目id")
public String getItemId() {
    return relevanceItem.getItemId();
}

	public void setItemId(String item_id) {
		relevanceItem.setItemId(item_id);
	}

		@ApiModelProperty(value = "类型")
public String getItemType() {
    return relevanceItem.getItemType();
}

	public void setItemType(String item_type) {
		relevanceItem.setItemType(item_type);
	}

		@ApiModelProperty(value = "目录排序")
public String getWeight() {
    return relevanceItem.getWeight();
}

	public void setWeight(String weight) {
		relevanceItem.setWeight(weight);
	}

		@ApiModelProperty(value = "创建人")
public String getCreateId() {
    return relevanceItem.getCreateId();
}

	public void setCreateId(String create_id) {
		relevanceItem.setCreateId(create_id);
	}

		@ApiModelProperty(value = "创建时间")
public String getCreateTime() {
    return relevanceItem.getCreateTime();
}

	public void setCreateTime(String create_time) {
		relevanceItem.setCreateTime(create_time);
	}

		@ApiModelProperty(value = "更新人")
public String getUpdateId() {
    return relevanceItem.getUpdateId();
}

	public void setUpdateId(String update_id) {
		relevanceItem.setUpdateId(update_id);
	}

		@ApiModelProperty(value = "更新时间")
public String getUpdateTime() {
    return relevanceItem.getUpdateTime();
}

	public void setUpdateTime(String update_time) {
		relevanceItem.setUpdateTime(update_time);
	}

		
}
