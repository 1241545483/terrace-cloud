package com.synapse.reading.service.service;

import com.synapse.common.constants.PageInfo;
import com.synapse.reading.model.model.ModelOperate;
import com.synapse.reading.respository.ModelOperateRespository;
import com.synapse.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.synapse.reading.constants.constants.ModelOperateConstants;
import com.synapse.reading.remote.IdService;

import java.util.List;
import java.util.Map;


/**
 * <p>
 * 系统模块和code的关系 服务实现类
 * </p>
 *
 * @author liuguangfu
 * @since 2019-05-28
 */
@Service
@Transactional
public class ModelOperateService extends ModelOperateBaseService {

	@Autowired
	private IdService idService;

    @Autowired
    private ModelOperateRespository modelOperateRespository;

    public ModelOperate find(String recId){
	    return modelOperateRespository.selectByPrimaryKey(recId);
    }

	public Integer update(ModelOperate param){
        String now = DateUtils.getNowStr(DateUtils.FORMAT_DATE_TIME);
        param.setUpdateTime(now);
		return modelOperateRespository.updateByPrimaryKeySelective(param);
    }

    public String create(ModelOperate param) {
        String now = DateUtils.getNowStr(DateUtils.FORMAT_DATE_TIME);
        param.setRecId(idService.gen("ID"));
		param.setCreateTime(now);
		param.setUpdateTime(now);
		param.setStatus(ModelOperateConstants.STATUS.OK.num());
        modelOperateRespository.insert(param);
        return param.getRecId();
    }

	public Integer delete(String recId, String updateId) {
        String now = DateUtils.getNowStr(DateUtils.FORMAT_DATE_TIME);
        ModelOperate model = new ModelOperate();
        model.setRecId(recId);
        model.setUpdateId(updateId);
        model.setUpdateTime(now);
        model.setStatus(ModelOperateConstants.STATUS.DELETED.num());
        return modelOperateRespository.updateByPrimaryKeySelective(model);
    }

	public List<ModelOperate> list(ModelOperate modelOperateParam, PageInfo pageInfo) {
		modelOperateParam.setStatus(ModelOperateConstants.STATUS.OK.num());
        Map<String,Object> params = prepareParams(modelOperateParam);
        params.put("startIndex", pageInfo.getCurrentStartIndex());
        params.put("pageSize", pageInfo.getPerPageNum());
        return modelOperateRespository.list(params);
	}

	public Integer count(ModelOperate modelOperateParam) {
		modelOperateParam.setStatus(ModelOperateConstants.STATUS.OK.num());
        Map<String,Object> params = prepareParams(modelOperateParam);
        return modelOperateRespository.count(params);
    }

}