package com.synapse.reading.service;

import com.synapse.common.constants.PageInfo;
import com.synapse.reading.model.TaskNote;
import com.synapse.reading.respository.TaskNoteRespository;
import com.synapse.reading.dto.param.TaskNoteParam;
import com.synapse.reading.dto.result.TaskNoteResult;
import com.synapse.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.synapse.reading.constants.TaskNoteConstants;
import com.synapse.reading.remote.IdService;

import java.util.List;
import java.util.Map;
import java.util.HashMap;


/**
 * <p>
 * 任务笔记 服务实现类
 * </p>
 *
 * @author liuguangfu
 * @since 2019-06-13
 */
@Service
@Transactional
public class TaskNoteService extends TaskNoteBaseService {

	@Autowired
	private IdService idService;

    @Autowired
    private TaskNoteRespository taskNoteRespository;

    public TaskNote find(String recId){
	    return taskNoteRespository.selectByPrimaryKey(recId);
    }

	public Integer update(TaskNote param){
        String now = DateUtils.getNowStr(DateUtils.FORMAT_DATE_TIME);
        param.setUpdateTime(now);
		return taskNoteRespository.updateByPrimaryKeySelective(param);
    }

    public String create(TaskNote param) {
        String now = DateUtils.getNowStr(DateUtils.FORMAT_DATE_TIME);
        param.setRecId(idService.gen("ID"));
		param.setCreateTime(now);
		param.setUpdateTime(now);
		param.setStatus(TaskNoteConstants.STATUS.OK.num());
        taskNoteRespository.insert(param);
        return param.getRecId();
    }

	public Integer delete(String recId, String updateId) {
        String now = DateUtils.getNowStr(DateUtils.FORMAT_DATE_TIME);
        TaskNote model = new TaskNote();
        model.setRecId(recId);
        model.setUpdateId(updateId);
        model.setUpdateTime(now);
        model.setStatus(TaskNoteConstants.STATUS.DELETED.num());
        return taskNoteRespository.updateByPrimaryKeySelective(model);
    }

	public List<TaskNote> list(TaskNote taskNoteParam, PageInfo pageInfo) {
		taskNoteParam.setStatus(TaskNoteConstants.STATUS.OK.num());
        Map<String,Object> params = prepareParams(taskNoteParam);
        params.put("startIndex", pageInfo.getCurrentStartIndex());
        params.put("pageSize", pageInfo.getPerPageNum());
        return taskNoteRespository.list(params);
	}

	public Integer count(TaskNote taskNoteParam) {
		taskNoteParam.setStatus(TaskNoteConstants.STATUS.OK.num());
        Map<String,Object> params = prepareParams(taskNoteParam);
        return taskNoteRespository.count(params);
    }

}