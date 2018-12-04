package com.synapse.reading.service;

import com.synapse.common.constants.PageInfo;
import com.synapse.reading.mapper.MyLikeMapper;
import com.synapse.reading.model.Information;
import com.synapse.reading.model.MyLike;
import com.synapse.reading.respository.InformationRespository;
import com.synapse.reading.dto.param.InformationParam;
import com.synapse.reading.dto.result.InformationResult;
import com.synapse.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.synapse.reading.constants.InformationConstants;
import com.synapse.reading.remote.IdService;

import java.util.List;
import java.util.Map;
import java.util.HashMap;


/**
 * <p>
 * 资讯模块 服务实现类
 * </p>
 *
 * @author liuguangfu
 * @since 2018-12-01
 */
@Service
@Transactional
public class InformationService extends InformationBaseService {

    @Autowired
    private IdService idService;

    @Autowired
    private InformationRespository informationRespository;
    @Autowired
    private MyLikeService myLikeService;


    public Information find(String recId) {
        return informationRespository.selectByPrimaryKey(recId);
    }

    public Integer update(Information param) {
        String now = DateUtils.getNowStr(DateUtils.FORMAT_DATE_TIME);
        param.setUpdateTime(now);
        return informationRespository.updateByPrimaryKeySelective(param);
    }

    public String create(Information param) {
        String now = DateUtils.getNowStr(DateUtils.FORMAT_DATE_TIME);
        param.setRecId(idService.gen("ID"));
        param.setCreateTime(now);
        param.setUpdateTime(now);
        param.setStatus(InformationConstants.STATUS.OK.num());
        informationRespository.insert(param);
        return param.getRecId();
    }

    public Integer delete(String recId, String updateId) {
        String now = DateUtils.getNowStr(DateUtils.FORMAT_DATE_TIME);
        Information model = new Information();
        model.setRecId(recId);
        model.setUpdateId(updateId);
        model.setUpdateTime(now);
        model.setStatus(InformationConstants.STATUS.DELETED.num());
        return informationRespository.updateByPrimaryKeySelective(model);
    }

    public List<Information> list(Information informationParam, PageInfo pageInfo) {
        informationParam.setStatus(InformationConstants.STATUS.OK.num());
        Map<String, Object> params = prepareParams(informationParam);
        params.put("startIndex", pageInfo.getCurrentStartIndex());
        params.put("pageSize", pageInfo.getPerPageNum());
        return informationRespository.list(params);
    }

    public List<InformationResult> listAddIsLike(Information informationParam, PageInfo pageInfo, String userId) {
        informationParam.setStatus(InformationConstants.STATUS.OK.num());
        Map<String, Object> params = prepareParams(informationParam);
        params.put("startIndex", pageInfo.getCurrentStartIndex());
        params.put("pageSize", pageInfo.getPerPageNum());
        params.put("userId", userId);
        return informationRespository.listAddIsLike(params);
    }

    public Integer count(Information informationParam) {
        informationParam.setStatus(InformationConstants.STATUS.OK.num());
        Map<String, Object> params = prepareParams(informationParam);
        return informationRespository.count(params);
    }

    public boolean updateReadNum(String recId) {
        return informationRespository.updateReadNum(recId) > 0;
    }

    public boolean updateLikeAddNum(String recId) {
        return informationRespository.updateLikeAddNum(recId) > 0;
    }

    public boolean updateLikeReduceNum(String recId) {
        return informationRespository.updateLikeReduceNum(recId) > 0;
    }


}