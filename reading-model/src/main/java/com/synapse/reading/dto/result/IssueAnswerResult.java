package com.synapse.reading.dto.result;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.synapse.reading.model.IssueAnswer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * IssueAnswerResult
 * </p>
 *
 * @author liuguangfu
 * @since 2019-01-09
 */
@ApiModel(value = "IssueAnswerResult对象", description = "问题回答")
public class IssueAnswerResult {

    private IssueAnswer  issueAnswer = new IssueAnswer();

    public IssueAnswerResult(){}

    public IssueAnswerResult(IssueAnswer  issueAnswer){
		if (issueAnswer != null) {
			this.issueAnswer = issueAnswer;
		}
    }

    @JsonIgnore
    public IssueAnswer getModel() {
        return issueAnswer;
    }

    public void setModel(IssueAnswer issueAnswer) {
        this.issueAnswer = issueAnswer;
    }

@ApiModelProperty(value = "主键")
public String getRecId() {
    return issueAnswer.getRecId();
}

	public void setRecId(String rec_id) {
		issueAnswer.setRecId(rec_id);
	}

		@ApiModelProperty(value = "题目主键")
public String getIssueId() {
    return issueAnswer.getIssueId();
}

	public void setIssueId(String issue_id) {
		issueAnswer.setIssueId(issue_id);
	}

		@ApiModelProperty(value = "选项主键")
public String getItemId() {
    return issueAnswer.getItemId();
}

	public void setItemId(String item_id) {
		issueAnswer.setItemId(item_id);
	}

		@ApiModelProperty(value = "状态(0 删除，1正常)")
public String getStatus() {
    return issueAnswer.getStatus();
}

	public void setStatus(String status) {
		issueAnswer.setStatus(status);
	}

		@ApiModelProperty(value = "回答人")
public String getCreateId() {
    return issueAnswer.getCreateId();
}

	public void setCreateId(String create_id) {
		issueAnswer.setCreateId(create_id);
	}

		@ApiModelProperty(value = "回答时间")
public String getCreateTime() {
    return issueAnswer.getCreateTime();
}

	public void setCreateTime(String create_time) {
		issueAnswer.setCreateTime(create_time);
	}

	public String getAnswer() {
		return issueAnswer.getAnswer();
	}

	public void setAnswer(String answer) {
		issueAnswer.setAnswer(answer);
	}
}
