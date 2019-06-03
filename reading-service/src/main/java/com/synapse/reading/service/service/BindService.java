package com.synapse.reading.service.service;

import com.synapse.common.constants.PageInfo;
import com.synapse.reading.model.model.Bind;
import com.synapse.reading.respository.BindRespository;
import com.synapse.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.synapse.reading.remote.IdService;

import java.util.List;
import java.util.Map;


/**
 * <p>
 * 储存用户绑定关系表，用户和对应的openId，unionId等 服务实现类
 * </p>
 *
 * @author liuguangfu
 * @since 2019-05-28
 */
@Service
@Transactional
public class BindService extends BindBaseService {

	@Autowired
	private IdService idService;

    @Autowired
    private BindRespository bindRespository;

    public Bind find(String recId){
	    return bindRespository.selectByPrimaryKey(recId);
    }

	public Integer update(Bind param){
        String now = DateUtils.getNowStr(DateUtils.FORMAT_DATE_TIME);
        param.setUpdateTime(now);
		return bindRespository.updateByPrimaryKeySelective(param);
    }

    public String create(Bind param) {
        String now = DateUtils.getNowStr(DateUtils.FORMAT_DATE_TIME);
        param.setRecId(idService.gen("ID"));
		param.setCreateTime(now);
		param.setUpdateTime(now);
        bindRespository.insert(param);
        return param.getRecId();
    }

	public Integer delete(String recId){
        return bindRespository.deleteByPrimaryKey(recId);
	}

	public List<Bind> list(Bind bindParam, PageInfo pageInfo) {
        Map<String,Object> params = prepareParams(bindParam);
        params.put("startIndex", pageInfo.getCurrentStartIndex());
        params.put("pageSize", pageInfo.getPerPageNum());
        return bindRespository.list(params);
	}

	public Integer count(Bind bindParam) {
        Map<String,Object> params = prepareParams(bindParam);
        return bindRespository.count(params);
    }

}