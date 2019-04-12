package com.synapse.reading.service;

import com.synapse.common.constants.PageInfo;
import com.synapse.common.sso.model.User;
import com.synapse.reading.model.PurchaseRecord;
import com.synapse.reading.respository.PurchaseRecordRespository;
import com.synapse.reading.dto.param.PurchaseRecordParam;
import com.synapse.reading.dto.result.PurchaseRecordResult;
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
 * 购买记录 服务实现类
 * </p>
 *
 * @author liuguangfu
 * @since 2019-04-09
 */
@Service
@Transactional
public class PurchaseRecordService extends PurchaseRecordBaseService {

	@Autowired
	private IdService idService;

    @Autowired
    private PurchaseRecordRespository purchaseRecordRespository;

    public PurchaseRecord find(String recId){
	    return purchaseRecordRespository.selectByPrimaryKey(recId);
    }

    public PurchaseRecord findPay(String lessonId,User user){
        PurchaseRecord purchaseRecord = new PurchaseRecord();
        purchaseRecord.setLessonId(lessonId);
        purchaseRecord.setUserId(user.getRecId());
        return purchaseRecordRespository.selectByPay(purchaseRecord);
    }

	public Integer update(PurchaseRecord param){
        String now = DateUtils.getNowStr(DateUtils.FORMAT_DATE_TIME);
		return purchaseRecordRespository.updateByPrimaryKeySelective(param);
    }

    public String create(PurchaseRecord param) {
        String now = DateUtils.getNowStr(DateUtils.FORMAT_DATE_TIME);
        param.setRecId(idService.gen("ID"));
		param.setCreateTime(now);
        purchaseRecordRespository.insert(param);
        return param.getRecId();
    }

	public Integer delete(String recId){
        return purchaseRecordRespository.deleteByPrimaryKey(recId);
	}

	public List<PurchaseRecord> list(PurchaseRecord purchaseRecordParam, PageInfo pageInfo) {
        Map<String,Object> params = prepareParams(purchaseRecordParam);
        params.put("startIndex", pageInfo.getCurrentStartIndex());
        params.put("pageSize", pageInfo.getPerPageNum());
        return purchaseRecordRespository.list(params);
	}

	public Integer count(PurchaseRecord purchaseRecordParam) {
        Map<String,Object> params = prepareParams(purchaseRecordParam);
        return purchaseRecordRespository.count(params);
    }

}