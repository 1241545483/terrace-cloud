package com.synapse.reading.service.auth;

import com.synapse.common.constants.PageInfo;
import com.synapse.reading.model.auth.RoleModelMapping;
import com.synapse.reading.respository.auth.RoleModelMappingRespository;
import com.synapse.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.synapse.reading.constants.auth.RoleModelMappingConstants;
import com.synapse.reading.remote.IdService;

import java.util.List;
import java.util.Map;


/**
 * <p>
 * 系统模块和角色的关系 服务实现类
 * </p>
 *
 * @author liuguangfu
 * @since 2019-05-28
 */
@Service
@Transactional
public class RoleModelMappingService extends RoleModelMappingBaseService {

	@Autowired
	private IdService idService;

    @Autowired
    private RoleModelMappingRespository roleModelMappingRespository;

    public RoleModelMapping find(String recId){
	    return roleModelMappingRespository.selectByPrimaryKey(recId);
    }

	public Integer update(RoleModelMapping param){
        String now = DateUtils.getNowStr(DateUtils.FORMAT_DATE_TIME);
        param.setUpdateTime(now);
		return roleModelMappingRespository.updateByPrimaryKeySelective(param);
    }

    public String create(RoleModelMapping param) {
        String now = DateUtils.getNowStr(DateUtils.FORMAT_DATE_TIME);
        param.setRecId(idService.gen("ID"));
		param.setCreateTime(now);
		param.setUpdateTime(now);
		param.setStatus(RoleModelMappingConstants.STATUS.OK.num());
        roleModelMappingRespository.insert(param);
        return param.getRecId();
    }

	public Integer delete(String recId, String updateId) {
        String now = DateUtils.getNowStr(DateUtils.FORMAT_DATE_TIME);
        RoleModelMapping model = new RoleModelMapping();
        model.setRecId(recId);
        model.setUpdateId(updateId);
        model.setUpdateTime(now);
        model.setStatus(RoleModelMappingConstants.STATUS.DELETED.num());
        return roleModelMappingRespository.updateByPrimaryKeySelective(model);
    }

	public List<RoleModelMapping> list(RoleModelMapping roleModelMappingParam, PageInfo pageInfo) {
		roleModelMappingParam.setStatus(RoleModelMappingConstants.STATUS.OK.num());
        Map<String,Object> params = prepareParams(roleModelMappingParam);
        params.put("startIndex", pageInfo.getCurrentStartIndex());
        params.put("pageSize", pageInfo.getPerPageNum());
        return roleModelMappingRespository.list(params);
	}

	public Integer count(RoleModelMapping roleModelMappingParam) {
		roleModelMappingParam.setStatus(RoleModelMappingConstants.STATUS.OK.num());
        Map<String,Object> params = prepareParams(roleModelMappingParam);
        return roleModelMappingRespository.count(params);
    }

}
