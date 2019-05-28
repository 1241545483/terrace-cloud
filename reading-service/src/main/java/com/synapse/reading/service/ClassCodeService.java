package com.synapse.reading.service;

import com.synapse.common.constants.PageInfo;
import com.synapse.reading.model.ClassCode;
import com.synapse.reading.respository.ClassCodeRespository;
import com.synapse.reading.dto.param.ClassCodeParam;
import com.synapse.reading.dto.result.ClassCodeResult;
import com.synapse.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.synapse.reading.constants.ClassCodeConstants;
import com.synapse.reading.remote.IdService;

import java.util.List;
import java.util.Map;
import java.util.HashMap;


/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author liuguangfu
 * @since 2019-05-28
 */
@Service
@Transactional
public class ClassCodeService extends ClassCodeBaseService {

	@Autowired
	private IdService idService;

    @Autowired
    private ClassCodeRespository classCodeRespository;

    public ClassCode find(String recId){
	    return classCodeRespository.selectByPrimaryKey(recId);
    }

	public Integer update(ClassCode param){
        String now = DateUtils.getNowStr(DateUtils.FORMAT_DATE_TIME);
        param.setUpdateTime(now);
		return classCodeRespository.updateByPrimaryKeySelective(param);
    }

    public String create(ClassCode param) {
        String now = DateUtils.getNowStr(DateUtils.FORMAT_DATE_TIME);
		param.setCreateTime(now);
		param.setUpdateTime(now);
		param.setStatus(ClassCodeConstants.STATUS.OK.num());
        classCodeRespository.insert(param);
        return param.getClassCode().toString();
    }

	public Integer delete(String recId, String updateId) {
        String now = DateUtils.getNowStr(DateUtils.FORMAT_DATE_TIME);
        ClassCode model = new ClassCode();
        model.setClassCode(Integer.parseInt(recId));
        model.setUpdateId(updateId);
        model.setUpdateTime(now);
        model.setStatus(ClassCodeConstants.STATUS.DELETED.num());
        return classCodeRespository.updateByPrimaryKeySelective(model);
    }

	public List<ClassCode> list(ClassCode classCodeParam, PageInfo pageInfo) {
		classCodeParam.setStatus(ClassCodeConstants.STATUS.OK.num());
        Map<String,Object> params = prepareParams(classCodeParam);
        params.put("startIndex", pageInfo.getCurrentStartIndex());
        params.put("pageSize", pageInfo.getPerPageNum());
        return classCodeRespository.list(params);
	}

	public Integer count(ClassCode classCodeParam) {
		classCodeParam.setStatus(ClassCodeConstants.STATUS.OK.num());
        Map<String,Object> params = prepareParams(classCodeParam);
        return classCodeRespository.count(params);
    }

}