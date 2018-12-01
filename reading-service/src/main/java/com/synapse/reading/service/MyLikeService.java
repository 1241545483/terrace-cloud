package com.synapse.reading.service;

import com.synapse.common.constants.PageInfo;
import com.synapse.reading.model.MyLike;
import com.synapse.reading.respository.MyLikeRespository;
import com.synapse.reading.dto.param.MyLikeParam;
import com.synapse.reading.dto.result.MyLikeResult;
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
 * 我的点赞 服务实现类
 * </p>
 *
 * @author liuguangfu
 * @since 2018-12-01
 */
@Service
@Transactional
public class MyLikeService extends MyLikeBaseService {

	@Autowired
	private IdService idService;

    @Autowired
    private MyLikeRespository myLikeRespository;

    public MyLike find(String recId){
	    return myLikeRespository.selectByPrimaryKey(recId);
    }

	public Integer update(MyLike param){
        String now = DateUtils.getNowStr(DateUtils.FORMAT_DATE_TIME);
		return myLikeRespository.updateByPrimaryKeySelective(param);
    }

    public String create(MyLike param) {
        String now = DateUtils.getNowStr(DateUtils.FORMAT_DATE_TIME);
        param.setRecId(idService.gen("ID"));
		param.setCreateTime(now);
        myLikeRespository.insert(param);
        return param.getRecId();
    }

	public Integer delete(String recId){
        return myLikeRespository.deleteByPrimaryKey(recId);
	}

	public List<MyLike> list(MyLike myLikeParam, PageInfo pageInfo) {
        Map<String,Object> params = prepareParams(myLikeParam);
        params.put("startIndex", pageInfo.getCurrentStartIndex());
        params.put("pageSize", pageInfo.getPerPageNum());
        return myLikeRespository.list(params);
	}

	public Integer count(MyLike myLikeParam) {
        Map<String,Object> params = prepareParams(myLikeParam);
        return myLikeRespository.count(params);
    }


}