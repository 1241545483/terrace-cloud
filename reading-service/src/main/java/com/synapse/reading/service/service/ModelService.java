package com.synapse.reading.service.service;

import com.synapse.common.constants.PageInfo;
import com.synapse.reading.model.model.Model;
import com.synapse.reading.respository.respository.ModelRespository;
import com.synapse.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.synapse.reading.constants.constants.ModelConstants;
import com.synapse.reading.remote.IdService;

import java.util.List;
import java.util.Map;


/**
 * <p>
 * 系统模块 服务实现类
 * </p>
 *
 * @author liuguangfu
 * @since 2019-05-28
 */
@Service
@Transactional
public class ModelService extends ModelBaseService {

	@Autowired
	private IdService idService;

    @Autowired
    private ModelRespository modelRespository;

    public Model find(String recId){
	    return modelRespository.selectByPrimaryKey(recId);
    }

	public Integer update(Model param){
        String now = DateUtils.getNowStr(DateUtils.FORMAT_DATE_TIME);
        param.setUpdateTime(now);
		return modelRespository.updateByPrimaryKeySelective(param);
    }

    public String create(Model param) {
        String now = DateUtils.getNowStr(DateUtils.FORMAT_DATE_TIME);
        param.setRecId(idService.gen("ID"));
		param.setCreateTime(now);
		param.setUpdateTime(now);
		param.setStatus(ModelConstants.STATUS.OK.num());
        modelRespository.insert(param);
        return param.getRecId();
    }

	public Integer delete(String recId, String updateId) {
        String now = DateUtils.getNowStr(DateUtils.FORMAT_DATE_TIME);
        Model model = new Model();
        model.setRecId(recId);
        model.setUpdateId(updateId);
        model.setUpdateTime(now);
        model.setStatus(ModelConstants.STATUS.DELETED.num());
        return modelRespository.updateByPrimaryKeySelective(model);
    }

	public List<Model> list(Model modelParam, PageInfo pageInfo) {
		modelParam.setStatus(ModelConstants.STATUS.OK.num());
        Map<String,Object> params = prepareParams(modelParam);
        params.put("startIndex", pageInfo.getCurrentStartIndex());
        params.put("pageSize", pageInfo.getPerPageNum());
        return modelRespository.list(params);
	}

	public Integer count(Model modelParam) {
		modelParam.setStatus(ModelConstants.STATUS.OK.num());
        Map<String,Object> params = prepareParams(modelParam);
        return modelRespository.count(params);
    }

}