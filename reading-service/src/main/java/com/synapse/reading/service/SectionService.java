package com.synapse.reading.service;

import com.synapse.common.constants.PageInfo;
import com.synapse.reading.model.Section;
import com.synapse.reading.respository.SectionRespository;
import com.synapse.reading.dto.param.SectionParam;
import com.synapse.reading.dto.result.SectionResult;
import com.synapse.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.synapse.reading.constants.SectionConstants;
import com.synapse.reading.remote.IdService;

import java.util.List;
import java.util.Map;
import java.util.HashMap;


/**
 * <p>
 * 章节 服务实现类
 * </p>
 *
 * @author liuguangfu
 * @since 2019-02-15
 */
@Service
@Transactional
public class SectionService extends SectionBaseService {

	@Autowired
	private IdService idService;

    @Autowired
    private SectionRespository sectionRespository;

    public Section find(String recId){
	    return sectionRespository.selectByPrimaryKey(recId);
    }

	public Integer update(Section param){
        String now = DateUtils.getNowStr(DateUtils.FORMAT_DATE_TIME);
        param.setUpdateTime(now);
		return sectionRespository.updateByPrimaryKeySelective(param);
    }

    public String create(Section param) {
        String now = DateUtils.getNowStr(DateUtils.FORMAT_DATE_TIME);
        param.setRecId(idService.gen("ID"));
		param.setCreateTime(now);
		param.setUpdateTime(now);
		param.setStatus(SectionConstants.STATUS.OK.num());
        sectionRespository.insert(param);
        return param.getRecId();
    }

	public Integer delete(String recId, String updateId) {
        String now = DateUtils.getNowStr(DateUtils.FORMAT_DATE_TIME);
        Section model = new Section();
        model.setRecId(recId);
        model.setUpdateId(updateId);
        model.setUpdateTime(now);
        model.setStatus(SectionConstants.STATUS.DELETED.num());
        return sectionRespository.updateByPrimaryKeySelective(model);
    }

	public List<Section> list(Section sectionParam, PageInfo pageInfo) {
		sectionParam.setStatus(SectionConstants.STATUS.OK.num());
        Map<String,Object> params = prepareParams(sectionParam);
        params.put("startIndex", pageInfo.getCurrentStartIndex());
        params.put("pageSize", pageInfo.getPerPageNum());
        return sectionRespository.list(params);
	}

	public Integer count(Section sectionParam) {
		sectionParam.setStatus(SectionConstants.STATUS.OK.num());
        Map<String,Object> params = prepareParams(sectionParam);
        return sectionRespository.count(params);
    }

}