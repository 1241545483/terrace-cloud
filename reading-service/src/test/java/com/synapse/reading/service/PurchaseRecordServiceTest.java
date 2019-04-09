package com.synapse.reading.service;

import com.synapse.common.constants.PageInfo;
import com.synapse.reading.model.PurchaseRecord;
import com.synapse.reading.respository.PurchaseRecordRespository;
import com.synapse.reading.dto.param.PurchaseRecordParam;
import com.synapse.reading.dto.result.PurchaseRecordResult;
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
 * 购买记录 服务测试类
 * </p>
 *
 * @author liuguangfu
 * @since 2019-04-09
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestConfig.class)
@Transactional
public class PurchaseRecordServiceTest {

    private final String createVal = "A";
    private final String updateVal = "B";

    @MockBean
    private IdService idService;

    @Autowired
    private PurchaseRecordService purchaseRecordService;

    @Test
    public void testFind(){
        String recId = doCreate();
	    PurchaseRecord result = purchaseRecordService.find(recId);
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
		PurchaseRecord result = purchaseRecordService.find(recId);
        assertEquals(val,result.getUserId());
        assertEquals(val,result.getLessonId());
        assertEquals(val,result.getPrice());
        assertEquals(val,result.getPayWay());
        assertEquals(val,result.getOperations());
        assertEquals(val,result.getCreateId());
    }

    @Test
    public void create() {
	    String recId = doCreate();
	    assertNotNull(recId);
    }

    public String doCreate(){
            Mockito.when(idService.gen(Mockito.anyString())).thenReturn(System.nanoTime() + "");
		    PurchaseRecord param = new PurchaseRecord();
            param.setUserId(createVal);
            param.setLessonId(createVal);
            param.setPrice(createVal);
            param.setPayWay(createVal);
            param.setOperations(createVal);
            param.setCreateId(createVal);
            param.setCreateTime(createVal);
		    return purchaseRecordService.create(param);
    }

    public void doUpdate(String recId){
			PurchaseRecord param = new PurchaseRecord();
	        param.setRecId(recId);
	        param.setUserId(updateVal);
	        param.setLessonId(updateVal);
	        param.setPrice(updateVal);
	        param.setPayWay(updateVal);
	        param.setOperations(updateVal);
	        param.setCreateId(updateVal);
	        param.setCreateTime(updateVal);
            purchaseRecordService.update(param);
    }

    @Test
	public void delete(){
		    PurchaseRecord param = new PurchaseRecord();
            int num = purchaseRecordService.count(param);
	        String recId = doCreate();
	        int num2 = purchaseRecordService.count(param);
	        assertEquals(num + 1, num2);
		    purchaseRecordService.delete(recId);
            int num3 = purchaseRecordService.count(param);
            assertEquals(num, num3);
	}

    @Test
	public void testList() {
		PurchaseRecord param = new PurchaseRecord();
        PageInfo pageInfo = new PageInfo();
        pageInfo.setPerPageNum(1000000);
        pageInfo.setCurrentPageIndex(1);
        pageInfo.setTotalNum(100000);
		List<PurchaseRecord> results = purchaseRecordService.list(param,pageInfo);
		int num = results.size();
        String recId = doCreate();
        List<PurchaseRecord> results2 = purchaseRecordService.list(param,pageInfo);
        int num2 = results2.size();
        assertEquals(num + 1, num2);
	}

    @Test
	public void testCount() {
		    PurchaseRecord param = new PurchaseRecord();
            int num = purchaseRecordService.count(param);
            doCreate();
            int num2 = purchaseRecordService.count(param);
	        assertEquals(num + 1, num2);
    }

}