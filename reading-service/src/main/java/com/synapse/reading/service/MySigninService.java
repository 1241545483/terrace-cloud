package com.synapse.reading.service;

import com.synapse.common.constants.PageInfo;
import com.synapse.common.sso.model.User;
import com.synapse.common.utils.DateUtils;
import com.synapse.reading.model.MySignin;
import com.synapse.reading.remote.IdService;
import com.synapse.reading.respository.MySigninRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;


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

    public  Integer countByCreateTime(User user){
        String now = DateUtils.getNowStr(DateUtils.FORMAT_DATE);
        String createTime =now+"%";
        System.err.println(now);
       if (mySigninRespository.countByCreateTime(user.getRecId(),createTime)>0){
           return 0;
       }else {
           return 1;
       }
    }

}