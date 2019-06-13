package com.synapse.reading.service;

import com.synapse.common.constants.PageInfo;
import com.synapse.reading.model.TaskStudyMapping;
import com.synapse.reading.respository.TaskStudyMappingRespository;
import com.synapse.reading.dto.param.TaskStudyMappingParam;
import com.synapse.reading.dto.result.TaskStudyMappingResult;
import com.synapse.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.synapse.reading.constants.TaskStudyMappingConstants;
import com.synapse.reading.remote.IdService;

import java.util.List;
import java.util.Map;
import java.util.HashMap;


/**
 * <p>
 * 任务和学习课程的关系 服务实现类
 * </p>
 *
 * @author liuguangfu
 * @since 2019-06-11
 */
@Service
@Transactional
public class TaskStudyMappingService extends TaskStudyMappingBaseService {

    @Autowired
    private IdService idService;

    @Autowired
    private TaskStudyMappingRespository taskStudyMappingRespository;

    public TaskStudyMapping find(String recId) {
        return taskStudyMappingRespository.selectByPrimaryKey(recId);
    }

    public Integer update(TaskStudyMapping param) {
        String now = DateUtils.getNowStr(DateUtils.FORMAT_DATE_TIME);
        param.setUpdateTime(now);
        return taskStudyMappingRespository.updateByPrimaryKeySelective(param);
    }

    public String create(TaskStudyMapping param) {
        String now = DateUtils.getNowStr(DateUtils.FORMAT_DATE_TIME);
        param.setRecId(idService.gen("ID"));
        param.setCreateTime(now);
        param.setUpdateTime(now);
        param.setStatus(TaskStudyMappingConstants.STATUS.OK.num());
        taskStudyMappingRespository.insert(param);
        return param.getRecId();
    }

    public Integer delete(String recId, String updateId) {
        String now = DateUtils.getNowStr(DateUtils.FORMAT_DATE_TIME);
        TaskStudyMapping model = new TaskStudyMapping();
        model.setRecId(recId);
        model.setUpdateId(updateId);
        model.setUpdateTime(now);
        model.setStatus(TaskStudyMappingConstants.STATUS.DELETED.num());
        return taskStudyMappingRespository.updateByPrimaryKeySelective(model);
    }

    public Integer deleteByStudyId(String taskId) {
        String now = DateUtils.getNowStr(DateUtils.FORMAT_DATE_TIME);
        TaskStudyMapping model = new TaskStudyMapping();
        model.setTaskId(taskId);
        model.setUpdateTime(now);
        model.setStatus(TaskStudyMappingConstants.STATUS.DELETED.num());
        return taskStudyMappingRespository.deleteByStudyId(model);
    }

    public List<TaskStudyMapping> list(TaskStudyMapping taskStudyMappingParam, PageInfo pageInfo) {
        taskStudyMappingParam.setStatus(TaskStudyMappingConstants.STATUS.OK.num());
        Map<String, Object> params = prepareParams(taskStudyMappingParam);
        params.put("startIndex", pageInfo.getCurrentStartIndex());
        params.put("pageSize", pageInfo.getPerPageNum());
        return taskStudyMappingRespository.list(params);
    }

    public Integer count(TaskStudyMapping taskStudyMappingParam) {
        taskStudyMappingParam.setStatus(TaskStudyMappingConstants.STATUS.OK.num());
        Map<String, Object> params = prepareParams(taskStudyMappingParam);
        return taskStudyMappingRespository.count(params);
    }

    //获取关联的资源idS
    public List<String> getStudyIds(String taskId, String type) {
        return taskStudyMappingRespository.getStudyIds(taskId, type);
    }

}