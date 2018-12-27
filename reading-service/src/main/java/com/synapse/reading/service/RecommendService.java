package com.synapse.reading.service;

import com.synapse.common.constants.PageInfo;
import com.synapse.reading.model.Recommend;
import com.synapse.reading.respository.RecommendRespository;
import com.synapse.reading.dto.param.RecommendParam;
import com.synapse.reading.dto.result.RecommendResult;
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
 * 推荐 服务实现类
 * </p>
 *
 * @author liuguangfu
 * @since 2018-12-27
 */
@Service
@Transactional
public class RecommendService extends RecommendBaseService {

	@Autowired
	private IdService idService;

    @Autowired
    private RecommendRespository recommendRespository;

    public Recommend find(String recId){
	    return recommendRespository.selectByPrimaryKey(recId);
    }

	public Integer update(Recommend param){
        String now = DateUtils.getNowStr(DateUtils.FORMAT_DATE_TIME);
		return recommendRespository.updateByPrimaryKeySelective(param);
    }

    public String create(Recommend param) {
        String now = DateUtils.getNowStr(DateUtils.FORMAT_DATE_TIME);
        param.setRecId(idService.gen("ID"));
		param.setCreateTime(now);
        recommendRespository.insert(param);
        return param.getRecId();
    }

	public Integer delete(String recId){
        return recommendRespository.deleteByPrimaryKey(recId);
	}

	public List<Recommend> list(Recommend recommendParam, PageInfo pageInfo) {
        Map<String,Object> params = prepareParams(recommendParam);
        params.put("startIndex", pageInfo.getCurrentStartIndex());
        params.put("pageSize", pageInfo.getPerPageNum());
        return recommendRespository.list(params);
	}

	public Integer count(Recommend recommendParam) {
        Map<String,Object> params = prepareParams(recommendParam);
        return recommendRespository.count(params);
    }

}