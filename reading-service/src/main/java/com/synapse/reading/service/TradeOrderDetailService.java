package com.synapse.reading.service;

import com.synapse.common.constants.PageInfo;
import com.synapse.reading.model.TradeOrderDetail;
import com.synapse.reading.respository.TradeOrderDetailRespository;
import com.synapse.reading.dto.param.TradeOrderDetailParam;
import com.synapse.reading.dto.result.TradeOrderDetailResult;
import com.synapse.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.synapse.reading.constants.TradeOrderDetailConstants;
import com.synapse.reading.remote.IdService;

import java.util.List;
import java.util.Map;
import java.util.HashMap;


/**
 * <p>
 * 订单详情 服务实现类
 * </p>
 *
 * @author liuguangfu
 * @since 2019-04-10
 */
@Service
@Transactional
public class TradeOrderDetailService extends TradeOrderDetailBaseService {

	@Autowired
	private IdService idService;

    @Autowired
    private TradeOrderDetailRespository tradeOrderDetailRespository;

    public TradeOrderDetail find(String recId){
	    return tradeOrderDetailRespository.selectByPrimaryKey(recId);
    }

	public Integer update(TradeOrderDetail param){
        String now = DateUtils.getNowStr(DateUtils.FORMAT_DATE_TIME);
        param.setUpdateTime(now);
		return tradeOrderDetailRespository.updateByPrimaryKeySelective(param);
    }

    public String create(TradeOrderDetail param) {
        String now = DateUtils.getNowStr(DateUtils.FORMAT_DATE_TIME);
        param.setRecId(idService.gen("ID"));
		param.setCreateTime(now);
		param.setUpdateTime(now);
		param.setStatus(TradeOrderDetailConstants.STATUS.OK.num());
        tradeOrderDetailRespository.insert(param);
        return param.getRecId();
    }

	public Integer delete(String recId, String updateId) {
        String now = DateUtils.getNowStr(DateUtils.FORMAT_DATE_TIME);
        TradeOrderDetail model = new TradeOrderDetail();
        model.setRecId(recId);
        model.setUpdateId(updateId);
        model.setUpdateTime(now);
        model.setStatus(TradeOrderDetailConstants.STATUS.DELETED.num());
        return tradeOrderDetailRespository.updateByPrimaryKeySelective(model);
    }

	public List<TradeOrderDetail> list(TradeOrderDetail tradeOrderDetailParam, PageInfo pageInfo) {
		tradeOrderDetailParam.setStatus(TradeOrderDetailConstants.STATUS.OK.num());
        Map<String,Object> params = prepareParams(tradeOrderDetailParam);
        params.put("startIndex", pageInfo.getCurrentStartIndex());
        params.put("pageSize", pageInfo.getPerPageNum());
        return tradeOrderDetailRespository.list(params);
	}

	public Integer count(TradeOrderDetail tradeOrderDetailParam) {
		tradeOrderDetailParam.setStatus(TradeOrderDetailConstants.STATUS.OK.num());
        Map<String,Object> params = prepareParams(tradeOrderDetailParam);
        return tradeOrderDetailRespository.count(params);
    }

}