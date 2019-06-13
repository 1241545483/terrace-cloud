package com.synapse.reading.service;

import com.synapse.common.constants.PageInfo;
import com.synapse.reading.model.UserTaskRecord;
import com.synapse.reading.respository.UserTaskRecordRespository;
import com.synapse.reading.dto.param.UserTaskRecordParam;
import com.synapse.reading.dto.result.UserTaskRecordResult;
import com.synapse.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.synapse.reading.constants.UserTaskRecordConstants;
import com.synapse.reading.remote.IdService;

import java.util.List;
import java.util.Map;
import java.util.HashMap;


/**
 * <p>
 * 任务接受记录 服务实现类
 * </p>
 *
 * @author liuguangfu
 * @since 2019-06-12
 */
@Service
@Transactional
public class UserTaskRecordService extends UserTaskRecordBaseService {

	@Autowired
	private IdService idService;

    @Autowired
    private UserTaskRecordRespository userTaskRecordRespository;

    public UserTaskRecord find(String recId){
	    return userTaskRecordRespository.selectByPrimaryKey(recId);
    }

	public Integer update(UserTaskRecord param){
        String now = DateUtils.getNowStr(DateUtils.FORMAT_DATE_TIME);
        param.setUpdateTime(now);
		return userTaskRecordRespository.updateByPrimaryKeySelective(param);
    }

    public String create(UserTaskRecord param) {
        String now = DateUtils.getNowStr(DateUtils.FORMAT_DATE_TIME);
        param.setRecId(idService.gen("ID"));
		param.setCreateTime(now);
		param.setUpdateTime(now);
		param.setStatus(UserTaskRecordConstants.STATUS.OK.num());
        userTaskRecordRespository.insert(param);
        return param.getRecId();
    }

	public Integer delete(String recId, String updateId) {
        String now = DateUtils.getNowStr(DateUtils.FORMAT_DATE_TIME);
        UserTaskRecord model = new UserTaskRecord();
        model.setRecId(recId);
        model.setUpdateId(updateId);
        model.setUpdateTime(now);
        model.setStatus(UserTaskRecordConstants.STATUS.DELETED.num());
        return userTaskRecordRespository.updateByPrimaryKeySelective(model);
    }

	public List<UserTaskRecord> list(UserTaskRecord userTaskRecordParam, PageInfo pageInfo) {
		userTaskRecordParam.setStatus(UserTaskRecordConstants.STATUS.OK.num());
        Map<String,Object> params = prepareParams(userTaskRecordParam);
        params.put("startIndex", pageInfo.getCurrentStartIndex());
        params.put("pageSize", pageInfo.getPerPageNum());
        return userTaskRecordRespository.list(params);
	}

	public Integer count(UserTaskRecord userTaskRecordParam) {
		userTaskRecordParam.setStatus(UserTaskRecordConstants.STATUS.OK.num());
        Map<String,Object> params = prepareParams(userTaskRecordParam);
        return userTaskRecordRespository.count(params);
    }

}