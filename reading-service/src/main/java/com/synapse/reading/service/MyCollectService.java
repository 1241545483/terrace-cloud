package com.synapse.reading.service;

import com.synapse.common.constants.PageInfo;
import com.synapse.common.sso.model.User;
import com.synapse.reading.model.MyCollect;
import com.synapse.reading.respository.MyCollectRespository;
import com.synapse.reading.dto.param.MyCollectParam;
import com.synapse.reading.dto.result.MyCollectResult;
import com.synapse.common.utils.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.synapse.reading.remote.IdService;

import java.util.List;
import java.util.Map;
import java.util.HashMap;


/**
 * <p>
 * 我的收藏 服务实现类
 * </p>
 *
 * @author liuguangfu
 * @since 2018-12-01
 */
@Service
@Transactional
public class MyCollectService extends MyCollectBaseService {

    @Autowired
    private IdService idService;

    @Autowired
    private MyCollectRespository myCollectRespository;
    private Logger logger = LoggerFactory.getLogger(MyCollectService.class);
    public MyCollect find(String recId) {
        return myCollectRespository.selectByPrimaryKey(recId);
    }

    public Integer update(MyCollect param) {
        String now = DateUtils.getNowStr(DateUtils.FORMAT_DATE_TIME);
        return myCollectRespository.updateByPrimaryKeySelective(param);
    }

    public String create(MyCollect param) {
        String now = DateUtils.getNowStr(DateUtils.FORMAT_DATE_TIME);
        param.setRecId(idService.gen("ID"));
        param.setCreateTime(now);
        myCollectRespository.insert(param);
        return param.getRecId();
    }

    public Integer delete(String recId) {
        return myCollectRespository.deleteByPrimaryKey(recId);
    }

    public boolean deleteCollectByCreateId(String recId, User user) {
        if (myCollectRespository.countIsCollect(recId, user.getRecId()) <= 0) {
            return true;
        }
        return myCollectRespository.deleteCollectByCreateId(recId,user.getRecId()) > 0;
    }

    public List<MyCollect> list(MyCollect myCollectParam, PageInfo pageInfo) {
        Map<String, Object> params = prepareParams(myCollectParam);
        params.put("startIndex", pageInfo.getCurrentStartIndex());
        params.put("pageSize", pageInfo.getPerPageNum());
        return myCollectRespository.list(params);
    }

    public Integer count(MyCollect myCollectParam) {
        Map<String, Object> params = prepareParams(myCollectParam);
        return myCollectRespository.count(params);
    }

    public boolean countIsCollect(String recId, String userId) {
        return myCollectRespository.countIsCollect(recId, userId) > 0;
    }

    public boolean addByCreateId(String recId, User user) {
        if (myCollectRespository.countIsCollect(recId, user.getRecId()) > 0) {
            return true;
        }
        String now = DateUtils.getNowStr(DateUtils.FORMAT_DATE_TIME);
        MyCollect model = new MyCollect();
      //  model.setRecId(idService.gen("ID"));
        model.setRecId("5");
        model.setCreateTime(now);
        model.setCollectId(recId);
        model.setCreateId(user.getRecId());
        model.setCollectType("info");
        try {
            myCollectRespository.insert(model);
            return true;
        } catch (Exception e) {
            logger.error("list  Error",e);
            return false;
        }


    }

}