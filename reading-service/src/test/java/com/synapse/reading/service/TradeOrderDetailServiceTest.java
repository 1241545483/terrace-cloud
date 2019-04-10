package com.synapse.reading.service;

import com.synapse.common.constants.PageInfo;
import com.synapse.reading.model.TradeOrderDetail;
import com.synapse.reading.respository.TradeOrderDetailRespository;
import com.synapse.reading.dto.param.TradeOrderDetailParam;
import com.synapse.reading.dto.result.TradeOrderDetailResult;
import com.synapse.reading.constants.TradeOrderDetailConstants;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.synapse.reading.remote.IdService;

import com.synapse.reading.TestConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

import static org.junit.Assert.*;

/**
 * <p>
 * 订单详情 服务测试类
 * </p>
 *
 * @author liuguangfu
 * @since 2019-04-10
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestConfig.class)
@Transactional
public class TradeOrderDetailServiceTest {

    private final String createVal = "A";
    private final String updateVal = "B";

    @MockBean
    private IdService idService;

    @Autowired
    private TradeOrderDetailService tradeOrderDetailService;

    @Test
    public void testFind(){
        String recId = doCreate();
	    TradeOrderDetail result = tradeOrderDetailService.find(recId);
        assertNotNull(result);
    }

    @Test
	public void testUpdate(){
        String recId = doCreate();
        checkField(recId, createVal);
	    doUpdate(recId);
        checkField(recId, updateVal);
    }

    private void checkField(String recId, String val){
		TradeOrderDetail result = tradeOrderDetailService.find(recId);
        assertEquals(val,result.getTrateOrderId());
        assertEquals(val,result.getOriginalPrice());
        assertEquals(val,result.getPresentPrice());
        assertEquals(val,result.getName());
        assertEquals(val,result.getProdType());
        assertEquals(val,result.getProdId());
        assertEquals(val,result.getIntro());
        assertEquals(val,result.getPreferentialWay());
        assertEquals(val,result.getCreateId());
        assertEquals(val,result.getUpdateId());
    }

    @Test
    public void create() {
	    String recId = doCreate();
	    assertNotNull(recId);
    }

    public String doCreate(){
            Mockito.when(idService.gen(Mockito.anyString())).thenReturn(System.nanoTime() + "");
		    TradeOrderDetail param = new TradeOrderDetail();
            param.setTrateOrderId(createVal);
            param.setOriginalPrice(createVal);
            param.setPresentPrice(createVal);
            param.setName(createVal);
            param.setProdType(createVal);
            param.setProdId(createVal);
            param.setIntro(createVal);
            param.setPreferentialWay(createVal);
            param.setStatus(createVal);
            param.setCreateId(createVal);
            param.setCreateTime(createVal);
            param.setUpdateId(createVal);
            param.setUpdateTime(createVal);
		    return tradeOrderDetailService.create(param);
    }

    public void doUpdate(String recId){
			TradeOrderDetail param = new TradeOrderDetail();
	        param.setRecId(recId);
	        param.setTrateOrderId(updateVal);
	        param.setOriginalPrice(updateVal);
	        param.setPresentPrice(updateVal);
	        param.setName(updateVal);
	        param.setProdType(updateVal);
	        param.setProdId(updateVal);
	        param.setIntro(updateVal);
	        param.setPreferentialWay(updateVal);
	        param.setStatus(updateVal);
	        param.setCreateId(updateVal);
	        param.setCreateTime(updateVal);
	        param.setUpdateId(updateVal);
	        param.setUpdateTime(updateVal);
            tradeOrderDetailService.update(param);
    }

    @Test
	public void delete(){
		    TradeOrderDetail param = new TradeOrderDetail();
            param.setStatus(TradeOrderDetailConstants.STATUS.OK.num());
            int num = tradeOrderDetailService.count(param);
	        String recId = doCreate();
	        int num2 = tradeOrderDetailService.count(param);
	        assertEquals(num + 1, num2);
			tradeOrderDetailService.delete(recId, "-1");
            int num3 = tradeOrderDetailService.count(param);
            assertEquals(num, num3);
	}

    @Test
	public void testList() {
		TradeOrderDetail param = new TradeOrderDetail();
        PageInfo pageInfo = new PageInfo();
        pageInfo.setPerPageNum(1000000);
        pageInfo.setCurrentPageIndex(1);
        pageInfo.setTotalNum(100000);
		List<TradeOrderDetail> results = tradeOrderDetailService.list(param,pageInfo);
		int num = results.size();
        String recId = doCreate();
        List<TradeOrderDetail> results2 = tradeOrderDetailService.list(param,pageInfo);
        int num2 = results2.size();
        assertEquals(num + 1, num2);
	}

    @Test
	public void testCount() {
		    TradeOrderDetail param = new TradeOrderDetail();
            int num = tradeOrderDetailService.count(param);
            doCreate();
            int num2 = tradeOrderDetailService.count(param);
	        assertEquals(num + 1, num2);
    }

}