package com.synapse.reading.service;

import com.synapse.common.constants.PageInfo;
import com.synapse.reading.model.BaseSystemParameter;
import com.synapse.reading.respository.BaseSystemParameterRespository;
import com.synapse.reading.dto.param.BaseSystemParameterParam;
import com.synapse.reading.dto.result.BaseSystemParameterResult;
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
 *  服务测试类
 * </p>
 *
 * @author wangyifan
 * @since 2018-11-20
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestConfig.class)
@Transactional
public class BaseSystemParameterServiceTest {

    private final String createVal = "A";
    private final String updateVal = "B";

    @MockBean
    private IdService idService;

    @Autowired
    private BaseSystemParameterService baseSystemParameterService;

    @Test
    public void testFind(){
        String recId = doCreate();
	    BaseSystemParameter result = baseSystemParameterService.find(recId);
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
		BaseSystemParameter result = baseSystemParameterService.find(recId);
        assertEquals(val,result.getParameterType());
        assertEquals(val,result.getParameterKey());
        assertEquals(val,result.getParameterName());
        assertEquals(val,result.getParameterValue());
        assertEquals(val,result.getParentParameterType());
        assertEquals(val,result.getParentParameterKey());
        assertEquals(val,result.getAddTime());
    }

    @Test
    public void create() {
	    String recId = doCreate();
	    assertNotNull(recId);
    }

    public String doCreate(){
            Mockito.when(idService.gen(Mockito.anyString())).thenReturn(System.nanoTime() + "");
		    BaseSystemParameter param = new BaseSystemParameter();
            param.setParameterType(createVal);
            param.setParameterKey(createVal);
            param.setParameterName(createVal);
            param.setParameterValue(createVal);
            param.setWeight(-1);
            param.setParentParameterType(createVal);
            param.setParentParameterKey(createVal);
            param.setAddTime(createVal);
            param.setUpdateTime(createVal);
		    return baseSystemParameterService.create(param);
    }

    public void doUpdate(String recId){
			BaseSystemParameter param = new BaseSystemParameter();
	        param.setRecId(recId);
	        param.setParameterType(updateVal);
	        param.setParameterKey(updateVal);
	        param.setParameterName(updateVal);
	        param.setParameterValue(updateVal);
	        param.setWeight(-2);
	        param.setParentParameterType(updateVal);
	        param.setParentParameterKey(updateVal);
	        param.setAddTime(updateVal);
	        param.setUpdateTime(updateVal);
            baseSystemParameterService.update(param);
    }

    @Test
	public void delete(){
		    BaseSystemParameter param = new BaseSystemParameter();
            int num = baseSystemParameterService.count(param);
	        String recId = doCreate();
	        int num2 = baseSystemParameterService.count(param);
	        assertEquals(num + 1, num2);
		    baseSystemParameterService.delete(recId);
            int num3 = baseSystemParameterService.count(param);
            assertEquals(num, num3);
	}

    @Test
	public void testList() {
		BaseSystemParameter param = new BaseSystemParameter();
        PageInfo pageInfo = new PageInfo();
        pageInfo.setPerPageNum(1000000);
        pageInfo.setCurrentPageIndex(1);
        pageInfo.setTotalNum(100000);
		List<BaseSystemParameter> results = baseSystemParameterService.list(param,pageInfo);
		int num = results.size();
        String recId = doCreate();
        List<BaseSystemParameter> results2 = baseSystemParameterService.list(param,pageInfo);
        int num2 = results2.size();
        assertEquals(num + 1, num2);
	}

    @Test
	public void testCount() {
		    BaseSystemParameter param = new BaseSystemParameter();
            int num = baseSystemParameterService.count(param);
            doCreate();
            int num2 = baseSystemParameterService.count(param);
	        assertEquals(num + 1, num2);
    }

}