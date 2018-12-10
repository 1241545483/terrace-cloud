package com.synapse.reading.service;

import com.synapse.common.constants.PageInfo;
import com.synapse.reading.model.MySignin;
import com.synapse.reading.respository.MySigninRespository;
import com.synapse.reading.dto.param.MySigninParam;
import com.synapse.reading.dto.result.MySigninResult;
import com.synapse.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.synapse.reading.remote.IdService;

import java.util.List;
import java.util.Map;
import java.util.HashMap;


/**
 * <p>
 * 我的签到 服务实现类
 * </p>
 *
 * @author liuguangfu
 * @since 2018-12-06
 */
@Service
@Transactional
public class MySigninService extends MySigninBaseService {

	@Autowired
	private IdService idService;

    @Autowired
    private MySigninRespository mySigninRespository;

    public MySignin find(String recId){
	    return mySigninRespository.selectByPrimaryKey(recId);
    }

	public Integer update(MySignin param){
        String now = DateUtils.getNowStr(DateUtils.FORMAT_DATE_TIME);
		return mySigninRespository.updateByPrimaryKeySelective(param);
    }

    public String create(MySignin param) {
        String now = DateUtils.getNowStr(DateUtils.FORMAT_DATE_TIME);
        param.setRecId(idService.gen("ID"));
		param.setCreateTime(now);
        mySigninRespository.insert(param);
        return param.getRecId();
    }

	public Integer delete(String recId){
        return mySigninRespository.deleteByPrimaryKey(recId);
	}

	public List<MySignin> list(MySignin mySigninParam, PageInfo pageInfo) {
        Map<String,Object> params = prepareParams(mySigninParam);
        params.put("startIndex", pageInfo.getCurrentStartIndex());
        params.put("pageSize", pageInfo.getPerPageNum());
        return mySigninRespository.list(params);
	}

	public Integer count(MySignin mySigninParam) {
        Map<String,Object> params = prepareParams(mySigninParam);
        return mySigninRespository.count(params);
    }

}