package com.synapse.reading.service;

import com.synapse.common.constants.PageInfo;
import com.synapse.reading.model.TradeOrder;
import com.synapse.reading.respository.TradeOrderRespository;
import com.synapse.reading.dto.param.TradeOrderParam;
import com.synapse.reading.dto.result.TradeOrderResult;
import com.synapse.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.synapse.reading.constants.TradeOrderConstants;
import com.synapse.reading.remote.IdService;

import java.util.List;
import java.util.Map;
import java.util.HashMap;


/**
 * <p>
 * 订单 服务实现类
 * </p>
 *
 * @author liuguangfu
 * @since 2019-04-10
 */
@Service
@Transactional
public class TradeOrderService extends TradeOrderBaseService {

	@Autowired
	private IdService idService;

    @Autowired
    private TradeOrderRespository tradeOrderRespository;

    public TradeOrder find(String recId){
	    return tradeOrderRespository.selectByPrimaryKey(recId);
    }

    public TradeOrder findByBuyId(String BuyId){
        return tradeOrderRespository.findByBuyId(BuyId);
    }

	public Integer update(TradeOrder param){
        String now = DateUtils.getNowStr(DateUtils.FORMAT_DATE_TIME);
        param.setUpdateTime(now);
		return tradeOrderRespository.updateByPrimaryKeySelective(param);
    }

    public String create(TradeOrder param) {
        String now = DateUtils.getNowStr(DateUtils.FORMAT_DATE_TIME);
        param.setRecId(idService.gen("ID"));
		param.setCreateTime(now);
		param.setUpdateTime(now);
		param.setStatus(TradeOrderConstants.STATUS.OK.num());
        tradeOrderRespository.insert(param);
        return param.getRecId();
    }

	public Integer delete(String recId, String updateId) {
        String now = DateUtils.getNowStr(DateUtils.FORMAT_DATE_TIME);
        TradeOrder model = new TradeOrder();
        model.setRecId(recId);
        model.setUpdateId(updateId);
        model.setUpdateTime(now);
        model.setStatus(TradeOrderConstants.STATUS.DELETED.num());
        return tradeOrderRespository.updateByPrimaryKeySelective(model);
    }

	public List<TradeOrder> list(TradeOrder tradeOrderParam, PageInfo pageInfo) {
		tradeOrderParam.setStatus(TradeOrderConstants.STATUS.OK.num());
        Map<String,Object> params = prepareParams(tradeOrderParam);
        params.put("startIndex", pageInfo.getCurrentStartIndex());
        params.put("pageSize", pageInfo.getPerPageNum());
        return tradeOrderRespository.list(params);
	}

	public Integer count(TradeOrder tradeOrderParam) {
		tradeOrderParam.setStatus(TradeOrderConstants.STATUS.OK.num());
        Map<String,Object> params = prepareParams(tradeOrderParam);
        return tradeOrderRespository.count(params);
    }

}