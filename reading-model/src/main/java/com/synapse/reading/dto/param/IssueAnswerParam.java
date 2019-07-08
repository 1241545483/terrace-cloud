package com.synapse.reading.dto.param;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.synapse.reading.model.IssueAnswer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotNull;
import com.synapse.reading.web.valid.group.Update;
import com.synapse.reading.web.valid.group.Create;
import com.synapse.reading.web.valid.group.Search;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * IssueAnswerParam
 * </p>
 *
 * @author liuguangfu
 * @since 2019-01-09
 */
@ApiModel(value = "IssueAnswerParam对象", description = "问题回答")
public class IssueAnswerParam  {

    private IssueAnswer  issueAnswer = new IssueAnswer();

    private List<String> itemIdList = new ArrayList<>();

    public IssueAnswerParam(){}

    public IssueAnswerParam(IssueAnswer  issueAnswer){
        this.issueAnswer = issueAnswer;
    }

    @JsonIgnore
    public IssueAnswer getModel() {
        return issueAnswer;
    }

    public void setModel(IssueAnswer  issueAnswer) {
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

    public List<String> getItemIdList() {
        return itemIdList;
    }

    public void setItemIdList(List<String> itemIdList) {
        this.itemIdList = itemIdList;
    }
}
