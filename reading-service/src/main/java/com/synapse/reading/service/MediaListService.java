package com.synapse.reading.service;

import com.synapse.common.constants.PageInfo;
import com.synapse.reading.model.MediaList;
import com.synapse.reading.respository.MediaListRespository;
import com.synapse.reading.dto.param.MediaListParam;
import com.synapse.reading.dto.result.MediaListResult;
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
 *  服务实现类
 * </p>
 *
 * @author wangyifan
 * @since 2018-11-20
 */
@Service
@Transactional
public class MediaListService extends MediaListBaseService {

	@Autowired
	private IdService idService;

    @Autowired
    private MediaListRespository mediaListRespository;

    public MediaList find(String recId){
	    return mediaListRespository.selectByPrimaryKey(recId);
    }

	public Integer update(MediaList param){
        String now = DateUtils.getNowStr(DateUtils.FORMAT_DATE_TIME);
        param.setUpdateTime(now);
		return mediaListRespository.updateByPrimaryKeySelective(param);
    }

    public String create(MediaList param) {
        String now = DateUtils.getNowStr(DateUtils.FORMAT_DATE_TIME);
        param.setRecId(idService.gen("ID"));
		param.setCreateTime(now);
		param.setUpdateTime(now);
        mediaListRespository.insert(param);
        return param.getRecId();
    }

	public Integer delete(String recId){
        return mediaListRespository.deleteByPrimaryKey(recId);
	}

	public List<MediaList> list(MediaList mediaListParam, PageInfo pageInfo) {
        Map<String,Object> params = prepareParams(mediaListParam);
        params.put("startIndex", pageInfo.getCurrentStartIndex());
        params.put("pageSize", pageInfo.getPerPageNum());
        return mediaListRespository.list(params);
	}

	public Integer count(MediaList mediaListParam) {
        Map<String,Object> params = prepareParams(mediaListParam);
        return mediaListRespository.count(params);
    }

}