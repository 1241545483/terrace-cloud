package com.synapse.reading.service;

import com.synapse.common.constants.PageInfo;
import com.synapse.reading.model.Album;
import com.synapse.reading.respository.AlbumRespository;
import com.synapse.reading.dto.param.AlbumParam;
import com.synapse.reading.dto.result.AlbumResult;
import com.synapse.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.synapse.reading.constants.AlbumConstants;
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
public class AlbumService extends AlbumBaseService {

	@Autowired
	private IdService idService;

    @Autowired
    private AlbumRespository albumRespository;

    public Album find(String recId){
	    return albumRespository.selectByPrimaryKey(recId);
    }

	public Integer update(Album param){
        String now = DateUtils.getNowStr(DateUtils.FORMAT_DATE_TIME);
        param.setUpdateTime(now);
		return albumRespository.updateByPrimaryKeySelective(param);
    }

    public String create(Album param) {
        String now = DateUtils.getNowStr(DateUtils.FORMAT_DATE_TIME);
        param.setRecId(idService.gen("ID"));
		param.setCreateTime(now);
		param.setUpdateTime(now);
		param.setStatus(AlbumConstants.STATUS.OK.num());
        albumRespository.insert(param);
        return param.getRecId();
    }

	public Integer delete(String recId, String updateId) {
        String now = DateUtils.getNowStr(DateUtils.FORMAT_DATE_TIME);
        Album model = new Album();
        model.setRecId(recId);
        model.setUpdateId(updateId);
        model.setUpdateTime(now);
        model.setStatus(AlbumConstants.STATUS.DELETED.num());
        return albumRespository.updateByPrimaryKeySelective(model);
    }

	public List<Album> list(Album albumParam, PageInfo pageInfo) {
		albumParam.setStatus(AlbumConstants.STATUS.OK.num());
        Map<String,Object> params = prepareParams(albumParam);
        params.put("startIndex", pageInfo.getCurrentStartIndex());
        params.put("pageSize", pageInfo.getPerPageNum());
        return albumRespository.list(params);
	}

	public Integer count(Album albumParam) {
        albumParam.setStatus(AlbumConstants.STATUS.OK.num());
        Map<String,Object> params = prepareParams(albumParam);
        return albumRespository.count(params);
    }

    public boolean updatePlayVisitNum(String recId) {
        return albumRespository.updatePlayVisitNum(recId)>0;
    }

    /*
        修改专辑为发布状态
        */
    public boolean albumPublished(String recId) {
        return albumRespository.albumPublished(recId)>0;
    }

    /*
    修改专辑为未发布状态
    */
    public boolean albumUnPublished(String recId) {
        return albumRespository.albumUnPublished(recId)>0;
    }

    public List<Album> listSortByOrderNum(Album albumParam, PageInfo pageInfo) {
        albumParam.setStatus(AlbumConstants.STATUS.OK.num());
        Map<String,Object> params = prepareParams(albumParam);
        params.put("startIndex", pageInfo.getCurrentStartIndex());
        params.put("pageSize", pageInfo.getPerPageNum());
        return albumRespository.listSortByOrderNum(params);
    }



}