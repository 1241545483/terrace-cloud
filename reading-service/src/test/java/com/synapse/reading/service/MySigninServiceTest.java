package com.synapse.reading.service;

import com.synapse.common.constants.PageInfo;
import com.synapse.reading.model.MySignin;
import com.synapse.reading.respository.MySigninRespository;
import com.synapse.reading.dto.param.MySigninParam;
import com.synapse.reading.dto.result.MySigninResult;
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
 * 我的签到 服务测试类
 * </p>
 *
 * @author liuguangfu
 * @since 2018-12-06
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestConfig.class)
@Transactional
public class MySigninServiceTest {

    private final String createVal = "A";
    private final String updateVal = "B";

    @MockBean
    private IdService idService;

    @Autowired
    private MySigninService mySigninService;

    @Test
    public void testFind(){
        String recId = doCreate();
	    MySignin result = mySigninService.find(recId);
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
		MySignin result = mySigninService.find(recId);
        assertEquals(val,result.getCreateId());
    }

    @Test
    public void create() {
	    String recId = doCreate();
	    assertNotNull(recId);
    }

    public String doCreate(){
            Mockito.when(idService.gen(Mockito.anyString())).thenReturn(System.nanoTime() + "");
		    MySignin param = new MySignin();
            param.setPoint(-1);
            param.setCreateId(createVal);
            param.setCreateTime(createVal);
		    return mySigninService.create(param);
    }

    public void doUpdate(String recId){
			MySignin param = new MySignin();
	        param.setRecId(recId);
	        param.setPoint(-2);
	        param.setCreateId(updateVal);
	        param.setCreateTime(updateVal);
            mySigninService.update(param);
    }

    @Test
	public void delete(){
		    MySignin param = new MySignin();
            int num = mySigninService.count(param);
	        String recId = doCreate();
	        int num2 = mySigninService.count(param);
	        assertEquals(num + 1, num2);
		    mySigninService.delete(recId);
            int num3 = mySigninService.count(param);
            assertEquals(num, num3);
	}

    @Test
	public void testList() {
		MySignin param = new MySignin();
        PageInfo pageInfo = new PageInfo();
        pageInfo.setPerPageNum(1000000);
        pageInfo.setCurrentPageIndex(1);
        pageInfo.setTotalNum(100000);
		List<MySignin> results = mySigninService.list(param,pageInfo);
		int num = results.size();
        String recId = doCreate();
        List<MySignin> results2 = mySigninService.list(param,pageInfo);
        int num2 = results2.size();
        assertEquals(num + 1, num2);
	}

    @Test
	public void testCount() {
		    MySignin param = new MySignin();
            int num = mySigninService.count(param);
            doCreate();
            int num2 = mySigninService.count(param);
	        assertEquals(num + 1, num2);
    }

}