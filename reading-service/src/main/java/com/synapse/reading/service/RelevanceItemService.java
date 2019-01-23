package com.synapse.reading.service;

import com.synapse.common.constants.PageInfo;
import com.synapse.reading.model.RelevanceItem;
import com.synapse.reading.respository.RelevanceItemRespository;
import com.synapse.reading.dto.param.RelevanceItemParam;
import com.synapse.reading.dto.result.RelevanceItemResult;
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
 * 书籍与目录对应关系 服务实现类
 * </p>
 *
 * @author liuguangfu
 * @since 2019-01-23
 */
@Service
@Transactional
public class RelevanceItemService extends RelevanceItemBaseService {

	@Autowired
	private IdService idService;

    @Autowired
    private RelevanceItemRespository relevanceItemRespository;

    public RelevanceItem find(String recId){
	    return relevanceItemRespository.selectByPrimaryKey(recId);
    }

	public Integer update(RelevanceItem param){
        String now = DateUtils.getNowStr(DateUtils.FORMAT_DATE_TIME);
        param.setUpdateTime(now);
		return relevanceItemRespository.updateByPrimaryKeySelective(param);
    }

    public String create(RelevanceItem param) {
        String now = DateUtils.getNowStr(DateUtils.FORMAT_DATE_TIME);
        param.setRecId(idService.gen("ID"));
		param.setCreateTime(now);
		param.setUpdateTime(now);
        relevanceItemRespository.insert(param);
        return param.getRecId();
    }

	public Integer delete(String recId){
        return relevanceItemRespository.deleteByPrimaryKey(recId);
	}

	public List<RelevanceItem> list(RelevanceItem relevanceItemParam, PageInfo pageInfo) {
        Map<String,Object> params = prepareParams(relevanceItemParam);
        params.put("startIndex", pageInfo.getCurrentStartIndex());
        params.put("pageSize", pageInfo.getPerPageNum());
        return relevanceItemRespository.list(params);
	}

	public Integer count(RelevanceItem relevanceItemParam) {
        Map<String,Object> params = prepareParams(relevanceItemParam);
        return relevanceItemRespository.count(params);
    }

}