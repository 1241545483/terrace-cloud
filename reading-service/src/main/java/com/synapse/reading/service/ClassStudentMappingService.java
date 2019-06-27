package com.synapse.reading.service;

import com.synapse.common.constants.PageInfo;
import com.synapse.reading.model.ClassStudentMapping;
import com.synapse.reading.respository.ClassStudentMappingRespository;
import com.synapse.reading.dto.param.ClassStudentMappingParam;
import com.synapse.reading.dto.result.ClassStudentMappingResult;
import com.synapse.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.synapse.reading.constants.ClassStudentMappingConstants;
import com.synapse.reading.remote.IdService;

import java.util.List;
import java.util.Map;
import java.util.HashMap;


/**
 * <p>
 * 班级和学生的关系 服务实现类
 * </p>
 *
 * @author liuguangfu
 * @since 2019-05-28
 */
@Service
@Transactional
public class ClassStudentMappingService extends ClassStudentMappingBaseService {

    @Autowired
    private IdService idService;

    @Autowired
    private ClassStudentMappingRespository classStudentMappingRespository;

    public ClassStudentMapping find(String recId) {
        return classStudentMappingRespository.selectByPrimaryKey(recId);
    }

    public Integer update(ClassStudentMapping param) {
        String now = DateUtils.getNowStr(DateUtils.FORMAT_DATE_TIME);
        param.setUpdateTime(now);
        return classStudentMappingRespository.updateByPrimaryKeySelective(param);
    }

    public String create(ClassStudentMapping param) {
        ClassStudentMapping classStudentMapping = classStudentMappingRespository.selectByClassId(param);
        if (classStudentMapping != null && !"".equals(classStudentMapping)) {
            classStudentMappingRespository.updateByPrimaryKeySelective(param);
            return classStudentMapping.getRecId();
        } else {
            String now = DateUtils.getNowStr(DateUtils.FORMAT_DATE_TIME);
            param.setRecId(idService.gen("ID"));
            param.setCreateTime(now);
            param.setUpdateTime(now);
            param.setStatus(ClassStudentMappingConstants.STATUS.OK.num());
            classStudentMappingRespository.insert(param);
            return param.getRecId();
        }


    }

    public Integer delete(String recId, String updateId) {
        String now = DateUtils.getNowStr(DateUtils.FORMAT_DATE_TIME);
        ClassStudentMapping model = new ClassStudentMapping();
        model.setRecId(recId);
        model.setUpdateId(updateId);
        model.setUpdateTime(now);
        model.setStatus(ClassStudentMappingConstants.STATUS.DELETED.num());
        return classStudentMappingRespository.updateByPrimaryKeySelective(model);
    }

    public List<ClassStudentMapping> list(ClassStudentMapping classStudentMappingParam, PageInfo pageInfo) {
        classStudentMappingParam.setStatus(ClassStudentMappingConstants.STATUS.OK.num());
        Map<String, Object> params = prepareParams(classStudentMappingParam);
        params.put("startIndex", pageInfo.getCurrentStartIndex());
        params.put("pageSize", pageInfo.getPerPageNum());
        return classStudentMappingRespository.list(params);
    }

    public Integer count(ClassStudentMapping classStudentMappingParam) {
        classStudentMappingParam.setStatus(ClassStudentMappingConstants.STATUS.OK.num());
        Map<String, Object> params = prepareParams(classStudentMappingParam);
        return classStudentMappingRespository.count(params);
    }

}