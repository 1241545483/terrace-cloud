package com.synapse.reading.service.service;

import com.synapse.common.constants.PageInfo;
import com.synapse.reading.model.model.Organization;
import com.synapse.reading.respository.respository.OrganizationRespository;
import com.synapse.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.synapse.reading.constants.constants.OrganizationConstants;
import com.synapse.reading.remote.IdService;

import java.util.List;
import java.util.Map;


/**
 * <p>
 * 组织机构 服务实现类
 * </p>
 *
 * @author liuguangfu
 * @since 2019-05-28
 */
@Service
@Transactional
public class OrganizationService extends OrganizationBaseService {

	@Autowired
	private IdService idService;

    @Autowired
    private OrganizationRespository organizationRespository;

    public Organization find(String recId){
	    return organizationRespository.selectByPrimaryKey(recId);
    }

	public Integer update(Organization param){
        String now = DateUtils.getNowStr(DateUtils.FORMAT_DATE_TIME);
        param.setUpdateTime(now);
		return organizationRespository.updateByPrimaryKeySelective(param);
    }

    public String create(Organization param) {
        String now = DateUtils.getNowStr(DateUtils.FORMAT_DATE_TIME);
        param.setOrgId(idService.gen("ID"));
		param.setCreateTime(now);
		param.setUpdateTime(now);
		param.setStatus(OrganizationConstants.STATUS.OK.num());
        organizationRespository.insert(param);
        return param.getOrgId();
    }

	public Integer delete(String recId, String updateId) {
        String now = DateUtils.getNowStr(DateUtils.FORMAT_DATE_TIME);
        Organization model = new Organization();
        model.setOrgId(recId);
        model.setUpdateId(updateId);
        model.setUpdateTime(now);
        model.setStatus(OrganizationConstants.STATUS.DELETED.num());
        return organizationRespository.updateByPrimaryKeySelective(model);
    }

	public List<Organization> list(Organization organizationParam, PageInfo pageInfo) {
		organizationParam.setStatus(OrganizationConstants.STATUS.OK.num());
        Map<String,Object> params = prepareParams(organizationParam);
        params.put("startIndex", pageInfo.getCurrentStartIndex());
        params.put("pageSize", pageInfo.getPerPageNum());
        return organizationRespository.list(params);
	}

	public Integer count(Organization organizationParam) {
		organizationParam.setStatus(OrganizationConstants.STATUS.OK.num());
        Map<String,Object> params = prepareParams(organizationParam);
        return organizationRespository.count(params);
    }

}