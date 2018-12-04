package com.synapse.reading.service;

import com.synapse.common.constants.PageInfo;
import com.synapse.reading.model.MyCollect;
import com.synapse.reading.respository.MyCollectRespository;
import com.synapse.reading.dto.param.MyCollectParam;
import com.synapse.reading.dto.result.MyCollectResult;
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
 * 我的收藏 服务实现类
 * </p>
 *
 * @author liuguangfu
 * @since 2018-12-01
 */
@Service
@Transactional
public class MyCollectService extends MyCollectBaseService {

	@Autowired
	private IdService idService;

    @Autowired
    private MyCollectRespository myCollectRespository;

    public MyCollect find(String recId){
	    return myCollectRespository.selectByPrimaryKey(recId);
    }

	public Integer update(MyCollect param){
        String now = DateUtils.getNowStr(DateUtils.FORMAT_DATE_TIME);
		return myCollectRespository.updateByPrimaryKeySelective(param);
    }

    public String create(MyCollect param) {
        String now = DateUtils.getNowStr(DateUtils.FORMAT_DATE_TIME);
        param.setRecId(idService.gen("ID"));
		param.setCreateTime(now);
        myCollectRespository.insert(param);
        return param.getRecId();
    }

	public Integer delete(String recId){
        return myCollectRespository.deleteByPrimaryKey(recId);
	}

	public List<MyCollect> list(MyCollect myCollectParam, PageInfo pageInfo) {
        Map<String,Object> params = prepareParams(myCollectParam);
        params.put("startIndex", pageInfo.getCurrentStartIndex());
        params.put("pageSize", pageInfo.getPerPageNum());
        return myCollectRespository.list(params);
	}

	public Integer count(MyCollect myCollectParam) {
        Map<String,Object> params = prepareParams(myCollectParam);
        return myCollectRespository.count(params);
    }

}