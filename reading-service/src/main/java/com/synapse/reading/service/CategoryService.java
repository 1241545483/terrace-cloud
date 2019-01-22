package com.synapse.reading.service;

import com.synapse.common.constants.PageInfo;
import com.synapse.reading.model.Category;
import com.synapse.reading.respository.CategoryRespository;
import com.synapse.reading.dto.param.CategoryParam;
import com.synapse.reading.dto.result.CategoryResult;
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
 * 推荐中高考书籍目录（三级） 服务实现类
 * </p>
 *
 * @author liuguangfu
 * @since 2019-01-22
 */
@Service
@Transactional
public class CategoryService extends CategoryBaseService {

	@Autowired
	private IdService idService;

    @Autowired
    private CategoryRespository categoryRespository;

    public Category find(String recId){
	    return categoryRespository.selectByPrimaryKey(recId);
    }

	public Integer update(Category param){
        String now = DateUtils.getNowStr(DateUtils.FORMAT_DATE_TIME);
        param.setUpdateTime(now);
		return categoryRespository.updateByPrimaryKeySelective(param);
    }

    public String create(Category param) {
        String now = DateUtils.getNowStr(DateUtils.FORMAT_DATE_TIME);
        param.setRecId(idService.gen("ID"));
		param.setCreateTime(now);
		param.setUpdateTime(now);
        categoryRespository.insert(param);
        return param.getRecId();
    }

	public Integer delete(String recId){
        return categoryRespository.deleteByPrimaryKey(recId);
	}

	public List<Category> list(Category categoryParam, PageInfo pageInfo) {
        Map<String,Object> params = prepareParams(categoryParam);
        params.put("startIndex", pageInfo.getCurrentStartIndex());
        params.put("pageSize", pageInfo.getPerPageNum());
        return categoryRespository.list(params);
	}

	public Integer count(Category categoryParam) {
        Map<String,Object> params = prepareParams(categoryParam);
        return categoryRespository.count(params);
    }

}