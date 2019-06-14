package com.synapse.reading.service.service;

import com.synapse.common.constants.PageInfo;
import com.synapse.reading.model.model.UserRole;
import com.synapse.reading.respository.respository.UserRoleRespository;
import com.synapse.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.synapse.reading.remote.IdService;

import java.util.List;
import java.util.Map;


/**
 * <p>
 * 阅读这边目前就只有老师，学生 服务实现类
 * </p>
 *
 * @author liuguangfu
 * @since 2019-05-30
 */
@Service
@Transactional
public class UserRoleService extends UserRoleBaseService {

	@Autowired
	private IdService idService;

    @Autowired
    private UserRoleRespository userRoleRespository;

    public UserRole find(String recId){
	    return userRoleRespository.selectByPrimaryKey(recId);
    }

    public String getByClassCode(String userId){
        return userRoleRespository.listUserBizRoles(userId);
    }

	public Integer update(UserRole param){
        String now = DateUtils.getNowStr(DateUtils.FORMAT_DATE_TIME);
        param.setUpdateTime(now);
		return userRoleRespository.updateByPrimaryKeySelective(param);
    }

    public String create(UserRole param) {
        String now = DateUtils.getNowStr(DateUtils.FORMAT_DATE_TIME);
        param.setRecId(idService.gen("ID"));
		param.setCreateTime(now);
		param.setUpdateTime(now);
        userRoleRespository.insert(param);
        return param.getRecId();
    }

	public Integer delete(String recId){
        return userRoleRespository.deleteByPrimaryKey(recId);
	}

	public List<UserRole> list(UserRole userRoleParam, PageInfo pageInfo) {
        Map<String,Object> params = prepareParams(userRoleParam);
        params.put("startIndex", pageInfo.getCurrentStartIndex());
        params.put("pageSize", pageInfo.getPerPageNum());
        return userRoleRespository.list(params);
	}

	public Integer count(UserRole userRoleParam) {
        Map<String,Object> params = prepareParams(userRoleParam);
        return userRoleRespository.count(params);
    }

}