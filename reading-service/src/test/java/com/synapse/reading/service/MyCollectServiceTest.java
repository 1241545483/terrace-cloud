package com.synapse.reading.service;

import com.synapse.common.constants.PageInfo;
import com.synapse.reading.model.MyCollect;
import com.synapse.reading.respository.MyCollectRespository;
import com.synapse.reading.dto.param.MyCollectParam;
import com.synapse.reading.dto.result.MyCollectResult;
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
 * 我的收藏 服务测试类
 * </p>
 *
 * @author liuguangfu
 * @since 2018-12-01
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestConfig.class)
@Transactional
public class MyCollectServiceTest {

    private final String createVal = "A";
    private final String updateVal = "B";

    @MockBean
    private IdService idService;

    @Autowired
    private MyCollectService myCollectService;

    @Test
    public void testFind(){
        String recId = doCreate();
	    MyCollect result = myCollectService.find(recId);
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
		MyCollect result = myCollectService.find(recId);
        assertEquals(val,result.getCollectType());
        assertEquals(val,result.getCollectId());
        assertEquals(val,result.getCreateId());
    }

    @Test
    public void create() {
	    String recId = doCreate();
	    assertNotNull(recId);
    }

    public String doCreate(){
            Mockito.when(idService.gen(Mockito.anyString())).thenReturn(System.nanoTime() + "");
		    MyCollect param = new MyCollect();
            param.setCollectType(createVal);
            param.setCollectId(createVal);
            param.setCreateId(createVal);
            param.setCreateTime(createVal);
		    return myCollectService.create(param);
    }

    public void doUpdate(String recId){
			MyCollect param = new MyCollect();
	        param.setRecId(recId);
	        param.setCollectType(updateVal);
	        param.setCollectId(updateVal);
	        param.setCreateId(updateVal);
	        param.setCreateTime(updateVal);
            myCollectService.update(param);
    }

    @Test
	public void delete(){
		    MyCollect param = new MyCollect();
            int num = myCollectService.count(param);
	        String recId = doCreate();
	        int num2 = myCollectService.count(param);
	        assertEquals(num + 1, num2);
		    myCollectService.delete(recId);
            int num3 = myCollectService.count(param);
            assertEquals(num, num3);
	}

    @Test
	public void testList() {
		MyCollect param = new MyCollect();
        PageInfo pageInfo = new PageInfo();
        pageInfo.setPerPageNum(1000000);
        pageInfo.setCurrentPageIndex(1);
        pageInfo.setTotalNum(100000);
		List<MyCollect> results = myCollectService.list(param,pageInfo);
		int num = results.size();
        String recId = doCreate();
        List<MyCollect> results2 = myCollectService.list(param,pageInfo);
        int num2 = results2.size();
        assertEquals(num + 1, num2);
	}

    @Test
	public void testCount() {
		    MyCollect param = new MyCollect();
            int num = myCollectService.count(param);
            doCreate();
            int num2 = myCollectService.count(param);
	        assertEquals(num + 1, num2);
    }

}