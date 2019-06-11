package com.synapse.reading.service;

import com.synapse.common.constants.PageInfo;
import com.synapse.reading.model.Task;
import com.synapse.reading.respository.TaskRespository;
import com.synapse.reading.dto.param.TaskParam;
import com.synapse.reading.dto.result.TaskResult;
import com.synapse.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.synapse.reading.constants.TaskConstants;
import com.synapse.reading.remote.IdService;

import java.util.List;
import java.util.Map;
import java.util.HashMap;


/**
 * <p>
 * 任务 服务实现类
 * </p>
 *
 * @author liuguangfu
 * @since 2019-06-11
 */
@Service
@Transactional
public class TaskService extends TaskBaseService {

	@Autowired
	private IdService idService;

    @Autowired
    private TaskRespository taskRespository;

    public Task find(String recId){
	    return taskRespository.selectByPrimaryKey(recId);
    }

	public Integer update(Task param){
        String now = DateUtils.getNowStr(DateUtils.FORMAT_DATE_TIME);
        param.setUpdateTime(now);
		return taskRespository.updateByPrimaryKeySelective(param);
    }

    public String create(Task param) {
        String now = DateUtils.getNowStr(DateUtils.FORMAT_DATE_TIME);
        param.setRecId(idService.gen("ID"));
		param.setCreateTime(now);
		param.setUpdateTime(now);
		param.setStatus(TaskConstants.STATUS.OK.num());
        taskRespository.insert(param);
        return param.getRecId();
    }

	public Integer delete(String recId, String updateId) {
        String now = DateUtils.getNowStr(DateUtils.FORMAT_DATE_TIME);
        Task model = new Task();
        model.setRecId(recId);
        model.setUpdateId(updateId);
        model.setUpdateTime(now);
        model.setStatus(TaskConstants.STATUS.DELETED.num());
        return taskRespository.updateByPrimaryKeySelective(model);
    }

	public List<Task> list(Task taskParam, PageInfo pageInfo) {
		taskParam.setStatus(TaskConstants.STATUS.OK.num());
        Map<String,Object> params = prepareParams(taskParam);
        params.put("startIndex", pageInfo.getCurrentStartIndex());
        params.put("pageSize", pageInfo.getPerPageNum());
        return taskRespository.list(params);
	}

	public Integer count(Task taskParam) {
		taskParam.setStatus(TaskConstants.STATUS.OK.num());
        Map<String,Object> params = prepareParams(taskParam);
        return taskRespository.count(params);
    }

}