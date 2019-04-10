package com.synapse.reading.service;

import com.synapse.common.constants.PageInfo;
import com.synapse.reading.model.TradeOrder;
import com.synapse.reading.respository.TradeOrderRespository;
import com.synapse.reading.dto.param.TradeOrderParam;
import com.synapse.reading.dto.result.TradeOrderResult;
import com.synapse.reading.constants.TradeOrderConstants;
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
 * 订单 服务测试类
 * </p>
 *
 * @author liuguangfu
 * @since 2019-04-10
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestConfig.class)
@Transactional
public class TradeOrderServiceTest {

    private final String createVal = "A";
    private final String updateVal = "B";

    @MockBean
    private IdService idService;

    @Autowired
    private TradeOrderService tradeOrderService;

    @Test
    public void testFind(){
        String recId = doCreate();
	    TradeOrder result = tradeOrderService.find(recId);
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
		TradeOrder result = tradeOrderService.find(recId);
        assertEquals(val,result.getName());
        assertEquals(val,result.getIntro());
        assertEquals(val,result.getPayWay());
        assertEquals(val,result.getPrice());
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
		    TradeOrder param = new TradeOrder();
            param.setName(createVal);
            param.setIntro(createVal);
            param.setPayWay(createVal);
            param.setPrice(createVal);
            param.setStatus(createVal);
            param.setCreateId(createVal);
            param.setCreateTime(createVal);
            param.setUpdateId(createVal);
            param.setUpdateTime(createVal);
		    return tradeOrderService.create(param);
    }

    public void doUpdate(String recId){
			TradeOrder param = new TradeOrder();
	        param.setRecId(recId);
	        param.setName(updateVal);
	        param.setIntro(updateVal);
	        param.setPayWay(updateVal);
	        param.setPrice(updateVal);
	        param.setStatus(updateVal);
	        param.setCreateId(updateVal);
	        param.setCreateTime(updateVal);
	        param.setUpdateId(updateVal);
	        param.setUpdateTime(updateVal);
            tradeOrderService.update(param);
    }

    @Test
	public void delete(){
		    TradeOrder param = new TradeOrder();
            param.setStatus(TradeOrderConstants.STATUS.OK.num());
            int num = tradeOrderService.count(param);
	        String recId = doCreate();
	        int num2 = tradeOrderService.count(param);
	        assertEquals(num + 1, num2);
			tradeOrderService.delete(recId, "-1");
            int num3 = tradeOrderService.count(param);
            assertEquals(num, num3);
	}

    @Test
	public void testList() {
		TradeOrder param = new TradeOrder();
        PageInfo pageInfo = new PageInfo();
        pageInfo.setPerPageNum(1000000);
        pageInfo.setCurrentPageIndex(1);
        pageInfo.setTotalNum(100000);
		List<TradeOrder> results = tradeOrderService.list(param,pageInfo);
		int num = results.size();
        String recId = doCreate();
        List<TradeOrder> results2 = tradeOrderService.list(param,pageInfo);
        int num2 = results2.size();
        assertEquals(num + 1, num2);
	}

    @Test
	public void testCount() {
		    TradeOrder param = new TradeOrder();
            int num = tradeOrderService.count(param);
            doCreate();
            int num2 = tradeOrderService.count(param);
	        assertEquals(num + 1, num2);
    }

}