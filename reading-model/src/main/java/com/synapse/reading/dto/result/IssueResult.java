package com.synapse.reading.dto.result;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.synapse.reading.dto.param.IssueItemParam;
import com.synapse.reading.model.Issue;
import com.synapse.reading.model.IssueItem;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * IssueResult
 * </p>
 *
 * @author liuguangfu
 * @since 2019-01-09
 */
@ApiModel(value = "IssueResult对象", description = "观看视频回答题目")
public class IssueResult {

    private Issue  issue = new Issue();
	private List<IssueItem> issueItemList = new ArrayList<>();

    public IssueResult(){}

    public IssueResult(Issue  issue){
        this.issue = issue;
    }
	@JsonIgnore
	public List<IssueItem>  getModelList() {
		return issueItemList;
	}

	public void setModelList(List<IssueItem>  issueItemList) {
		this.issueItemList=issueItemList;
	}

    @JsonIgnore
    public Issue getModel() {
        return issue;
    }

    public void setModel(Issue issue) {
        this.issue = issue;
    }

@ApiModelProperty(value = "主键")
public String getRecId() {
    return issue.getRecId();
}

	public void setRecId(String rec_id) {
		issue.setRecId(rec_id);
	}

		@ApiModelProperty(value = "题目内容")
public String getContent() {
    return issue.getContent();
}

	public void setContent(String content) {
		issue.setContent(content);
	}

		@ApiModelProperty(value = "属于哪个栏目(album 专辑，book书籍)")
public String getBelongTo() {
    return issue.getBelongTo();
}

	public void setBelongTo(String belong_to) {
		issue.setBelongTo(belong_to);
	}

		@ApiModelProperty(value = "属于哪个栏目ID(专辑或书籍主键)")
public String getBelongToId() {
    return issue.getBelongToId();
}

	public void setBelongToId(String belong_to_id) {
		issue.setBelongToId(belong_to_id);
	}

		@ApiModelProperty(value = "图片1")
public String getImg1() {
    return issue.getImg1();
}

	public void setImg1(String img1) {
		issue.setImg1(img1);
	}

		@ApiModelProperty(value = "图片2")
public String getImg2() {
    return issue.getImg2();
}

	public void setImg2(String img2) {
		issue.setImg2(img2);
	}

		@ApiModelProperty(value = "图片3")
public String getImg3() {
    return issue.getImg3();
}

	public void setImg3(String img3) {
		issue.setImg3(img3);
	}

		@ApiModelProperty(value = "题目类型(single 单选，multi多选)")
public String getType() {
    return issue.getType();
}

	public void setType(String type) {
		issue.setType(type);
	}

		@ApiModelProperty(value = "题目解析")
public String getAnalysis() {
    return issue.getAnalysis();
}

	public void setAnalysis(String analysis) {
		issue.setAnalysis(analysis);
	}

		@ApiModelProperty(value = "难度系数")
public String getDifficulty() {
    return issue.getDifficulty();
}

	public void setDifficulty(String difficulty) {
		issue.setDifficulty(difficulty);
	}

		@ApiModelProperty(value = "状态(0 删除，1正常)")
public String getStatus() {
    return issue.getStatus();
}

	public void setStatus(String status) {
		issue.setStatus(status);
	}

		@ApiModelProperty(value = "创建人")
public String getCreateId() {
    return issue.getCreateId();
}

	public void setCreateId(String create_id) {
		issue.setCreateId(create_id);
	}

		@ApiModelProperty(value = "创建时间")
public String getCreateTime() {
    return issue.getCreateTime();
}

	public void setCreateTime(String create_time) {
		issue.setCreateTime(create_time);
	}

		@ApiModelProperty(value = "更新人")
public String getUpdateId() {
    return issue.getUpdateId();
}

	public void setUpdateId(String update_id) {
		issue.setUpdateId(update_id);
	}

		@ApiModelProperty(value = "更新时间")
public String getUpdateTime() {
    return issue.getUpdateTime();
}

	public void setUpdateTime(String update_time) {
		issue.setUpdateTime(update_time);
	}

	public List<IssueItem> getIssueItemList() {
		return issueItemList;
	}

	public void setIssueItemList(List<IssueItem> issueItemList) {
		this.issueItemList = issueItemList;
	}
}
