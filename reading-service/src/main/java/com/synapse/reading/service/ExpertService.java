package com.synapse.reading.service;

import com.synapse.common.constants.PageInfo;
import com.synapse.reading.model.Expert;
import com.synapse.reading.respository.ExpertRespository;
import com.synapse.reading.dto.param.ExpertParam;
import com.synapse.reading.dto.result.ExpertResult;
import com.synapse.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.synapse.reading.constants.ExpertConstants;
import com.synapse.reading.remote.IdService;

import java.util.List;
import java.util.Map;
import java.util.HashMap;


/**
 * <p>
 * 专家 服务实现类
 * </p>
 *
 * @author liuguangfu
 * @since 2019-04-09
 */
@Service
@Transactional
public class ExpertService extends ExpertBaseService {

	@Autowired
	private IdService idService;

    @Autowired
    private ExpertRespository expertRespository;

    public Expert find(String recId){
	    return expertRespository.selectByPrimaryKey(recId);
    }

	public Integer update(Expert param){
        String now = DateUtils.getNowStr(DateUtils.FORMAT_DATE_TIME);
        param.setUpdateTime(now);
		return expertRespository.updateByPrimaryKeySelective(param);
    }

    public String create(Expert param) {
        String now = DateUtils.getNowStr(DateUtils.FORMAT_DATE_TIME);
        param.setRecId(idService.gen("ID"));
		param.setCreateTime(now);
		param.setUpdateTime(now);
		param.setStatus(ExpertConstants.STATUS.OK.num());
        expertRespository.insert(param);
        return param.getRecId();
    }

	public Integer delete(String recId, String updateId) {
        String now = DateUtils.getNowStr(DateUtils.FORMAT_DATE_TIME);
        Expert model = new Expert();
        model.setRecId(recId);
        model.setUpdateId(updateId);
        model.setUpdateTime(now);
        model.setStatus(ExpertConstants.STATUS.DELETED.num());
        return expertRespository.updateByPrimaryKeySelective(model);
    }

	public List<Expert> list(Expert expertParam, PageInfo pageInfo) {
		expertParam.setStatus(ExpertConstants.STATUS.OK.num());
        Map<String,Object> params = prepareParams(expertParam);
        params.put("startIndex", pageInfo.getCurrentStartIndex());
        params.put("pageSize", pageInfo.getPerPageNum());
        return expertRespository.list(params);
	}

	public Integer count(Expert expertParam) {
		expertParam.setStatus(ExpertConstants.STATUS.OK.num());
        Map<String,Object> params = prepareParams(expertParam);
        return expertRespository.count(params);
    }
}