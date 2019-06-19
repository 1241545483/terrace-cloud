package com.synapse.reading.service;

import com.synapse.common.constants.PageInfo;
import com.synapse.reading.model.ApplyForTeacher;
import com.synapse.reading.respository.ApplyForTeacherRespository;
import com.synapse.reading.dto.param.ApplyForTeacherParam;
import com.synapse.reading.dto.result.ApplyForTeacherResult;
import com.synapse.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.synapse.reading.constants.ApplyForTeacherConstants;
import com.synapse.reading.remote.IdService;

import java.util.List;
import java.util.Map;
import java.util.HashMap;


/**
 * <p>
 * 申请成为老师 服务实现类
 * </p>
 *
 * @author liuguangfu
 * @since 2019-06-19
 */
@Service
@Transactional
public class ApplyForTeacherService extends ApplyForTeacherBaseService {

	@Autowired
	private IdService idService;

    @Autowired
    private ApplyForTeacherRespository applyForTeacherRespository;

    public ApplyForTeacher find(String recId){
	    return applyForTeacherRespository.selectByPrimaryKey(recId);
    }

	public Integer update(ApplyForTeacher param){
        String now = DateUtils.getNowStr(DateUtils.FORMAT_DATE_TIME);
        param.setUpdateTime(now);
		return applyForTeacherRespository.updateByPrimaryKeySelective(param);
    }

    public String create(ApplyForTeacher param) {
        String now = DateUtils.getNowStr(DateUtils.FORMAT_DATE_TIME);
        param.setRecId(idService.gen("ID"));
		param.setCreateTime(now);
		param.setUpdateTime(now);
		param.setStatus(ApplyForTeacherConstants.STATUS.OK.num());
        applyForTeacherRespository.insert(param);
        return param.getRecId();
    }

	public Integer delete(String recId, String updateId) {
        String now = DateUtils.getNowStr(DateUtils.FORMAT_DATE_TIME);
        ApplyForTeacher model = new ApplyForTeacher();
        model.setRecId(recId);
        model.setUpdateId(updateId);
        model.setUpdateTime(now);
        model.setStatus(ApplyForTeacherConstants.STATUS.DELETED.num());
        return applyForTeacherRespository.updateByPrimaryKeySelective(model);
    }

	public List<ApplyForTeacher> list(ApplyForTeacher applyForTeacherParam, PageInfo pageInfo) {
		applyForTeacherParam.setStatus(ApplyForTeacherConstants.STATUS.OK.num());
        Map<String,Object> params = prepareParams(applyForTeacherParam);
        params.put("startIndex", pageInfo.getCurrentStartIndex());
        params.put("pageSize", pageInfo.getPerPageNum());
        return applyForTeacherRespository.list(params);
	}

	public Integer count(ApplyForTeacher applyForTeacherParam) {
		applyForTeacherParam.setStatus(ApplyForTeacherConstants.STATUS.OK.num());
        Map<String,Object> params = prepareParams(applyForTeacherParam);
        return applyForTeacherRespository.count(params);
    }

}