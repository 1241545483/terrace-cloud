package com.synapse.reading.service;

import com.synapse.common.constants.PageInfo;
import com.synapse.reading.model.ApplyForTeacher;
import com.synapse.reading.model.auth.UserRole;
import com.synapse.reading.respository.ApplyForTeacherRespository;
import com.synapse.reading.dto.result.ApplyForTeacherResult;
import com.synapse.common.utils.DateUtils;
import com.synapse.reading.service.auth.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.synapse.reading.constants.ApplyForTeacherConstants;
import com.synapse.reading.remote.IdService;

import java.util.List;
import java.util.Map;


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
    private UserRoleService userRoleService;

    @Autowired
    private ApplyForTeacherRespository applyForTeacherRespository;

    public ApplyForTeacher find(String recId) {
        return applyForTeacherRespository.selectByPrimaryKey(recId);
    }

    public ApplyForTeacherResult selectByUserId(String recId) {
        return applyForTeacherRespository.selectByUserId(recId);
    }

    public Integer update(ApplyForTeacher param) {
        String now = DateUtils.getNowStr(DateUtils.FORMAT_DATE_TIME);
        param.setUpdateTime(now);
        return applyForTeacherRespository.updateByPrimaryKeySelective(param);
    }

    public Integer updateApply(ApplyForTeacher param) {
        String now = DateUtils.getNowStr(DateUtils.FORMAT_DATE_TIME);
        param.setUpdateTime(now);
        UserRole userRole = new UserRole();
        userRole.setUserId(param.getUserId());
        userRole.setRoleId("teacher");
        int num = userRoleService.update(userRole);
        if (num <= 0) {
            userRoleService.create(userRole);
        }
        return applyForTeacherRespository.updateByPrimaryKeySelective(param);
    }


    public String create(ApplyForTeacher param) {
        String now = DateUtils.getNowStr(DateUtils.FORMAT_DATE_TIME);
        param.setRecId(idService.gen("ID"));
        param.setCreateTime(now);
        param.setUpdateTime(now);
        param.setStatus(ApplyForTeacherConstants.STATUS.UNCHECK.num());
        applyForTeacherRespository.insert(param);
        return param.getRecId();
    }

    public Integer delete(String recId, String updateId) {
        String now = DateUtils.getNowStr(DateUtils.FORMAT_DATE_TIME);
        ApplyForTeacher model = new ApplyForTeacher();
        model.setRecId(recId);
        model.setUpdateId(updateId);
        model.setUpdateTime(now);
        model.setStatus(ApplyForTeacherConstants.STATUS.REJECT.num());
        return applyForTeacherRespository.updateByPrimaryKeySelective(model);
    }

    public List<ApplyForTeacherResult> list(ApplyForTeacher applyForTeacherParam, PageInfo pageInfo) {
        applyForTeacherParam.setStatus(ApplyForTeacherConstants.STATUS.CHECK.num());
        Map<String, Object> params = prepareParams(applyForTeacherParam);
        params.put("startIndex", pageInfo.getCurrentStartIndex());
        params.put("pageSize", pageInfo.getPerPageNum());
        return applyForTeacherRespository.listByUser(params);
    }

    public Integer count(ApplyForTeacher applyForTeacherParam) {
        applyForTeacherParam.setStatus(ApplyForTeacherConstants.STATUS.CHECK.num());
        Map<String, Object> params = prepareParams(applyForTeacherParam);
        return applyForTeacherRespository.count(params);
    }

}
