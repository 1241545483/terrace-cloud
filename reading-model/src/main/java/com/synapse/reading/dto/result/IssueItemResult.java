package com.synapse.reading.dto.result;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.synapse.reading.model.IssueItem;
import com.synapse.reading.model.Member;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * IssueItemResult
 * </p>
 *
 * @author liuguangfu
 * @since 2019-01-09
 */
@ApiModel(value = "IssueItemResult对象", description = "题目选项")
public class IssueItemResult {

    private IssueItem  issueItem = new IssueItem();

    private  String selectedCount;

	private List<String> nameList = new ArrayList<>();

    public IssueItemResult(){}

    public IssueItemResult(IssueItem  issueItem) {
		if (issueItem != null) {
			this.issueItem = issueItem;
		}
	}

    @JsonIgnore
    public IssueItem getModel() {
        return issueItem;
    }

    public void setModel(IssueItem issueItem) {
        this.issueItem = issueItem;
    }

@ApiModelProperty(value = "主键")
public String getRecId() {
    return issueItem.getRecId();
}

	public void setRecId(String rec_id) {
		issueItem.setRecId(rec_id);
	}

		@ApiModelProperty(value = "题目主键")
public String getIssueId() {
    return issueItem.getIssueId();
}

	public void setIssueId(String issue_id) {
		issueItem.setIssueId(issue_id);
	}

		@ApiModelProperty(value = "选项内容")
public String getContent() {
    return issueItem.getContent();
}

	public void setContent(String content) {
		issueItem.setContent(content);
	}

		@ApiModelProperty(value = "图片1")
public String getImg1() {
    return issueItem.getImg1();
}

	public void setImg1(String img1) {
		issueItem.setImg1(img1);
	}

		@ApiModelProperty(value = "图片2")
public String getImg2() {
    return issueItem.getImg2();
}

	public void setImg2(String img2) {
		issueItem.setImg2(img2);
	}

		@ApiModelProperty(value = "图片3")
public String getImg3() {
    return issueItem.getImg3();
}

	public void setImg3(String img3) {
		issueItem.setImg3(img3);
	}

		@ApiModelProperty(value = "是否正确答案(0否,1是)")
public String getIsAnswer() {
    return issueItem.getIsAnswer();
}

	public void setIsAnswer(String is_answer) {
		issueItem.setIsAnswer(is_answer);
	}

		@ApiModelProperty(value = "创建人")
public String getCreateId() {
    return issueItem.getCreateId();
}

	public void setCreateId(String create_id) {
		issueItem.setCreateId(create_id);
	}

		@ApiModelProperty(value = "创建时间")
public String getCreateTime() {
    return issueItem.getCreateTime();
}

	public void setCreateTime(String create_time) {
		issueItem.setCreateTime(create_time);
	}

		@ApiModelProperty(value = "更新人")
public String getUpdateId() {
    return issueItem.getUpdateId();
}

	public void setUpdateId(String update_id) {
		issueItem.setUpdateId(update_id);
	}

		@ApiModelProperty(value = "更新时间")
public String getUpdateTime() {
    return issueItem.getUpdateTime();
}

	public void setUpdateTime(String update_time) {
		issueItem.setUpdateTime(update_time);
	}

	public String getSelectedCount() {
		return selectedCount;
	}

	public void setSelectedCount(String selectedCount) {
		this.selectedCount = selectedCount;
	}

	public List<String> getNameList() {
		return nameList;
	}

	public void setNameList(List<String> nameList) {
		this.nameList = nameList;
	}

	public IssueItem getIssueItem() {
		return issueItem;
	}

	public void setIssueItem(IssueItem issueItem) {
		this.issueItem = issueItem;
	}
}
