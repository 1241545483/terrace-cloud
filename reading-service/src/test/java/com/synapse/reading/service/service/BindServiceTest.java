package com.synapse.reading.service.service;

import com.synapse.common.constants.PageInfo;
import com.synapse.reading.model.model.Bind;
import com.synapse.reading.service.service.BindService;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.transaction.annotation.Transactional;
import com.synapse.reading.remote.IdService;

import com.synapse.reading.TestConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * <p>
 * 储存用户绑定关系表，用户和对应的openId，unionId等 服务测试类
 * </p>
 *
 * @author liuguangfu
 * @since 2019-05-28
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestConfig.class)
@Transactional
public class BindServiceTest {

    private final String createVal = "A";
    private final String updateVal = "B";

    @MockBean
    private IdService idService;

    @Autowired
    private BindService bindService;

    @Test
    public void testFind(){
        String recId = doCreate();
	    Bind result = bindService.find(recId);
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
		Bind result = bindService.find(recId);
        assertEquals(val,result.getUserId());
        assertEquals(val,result.getPrivide());
        assertEquals(val,result.getOpenId());
        assertEquals(val,result.getUnionId());
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
		    Bind param = new Bind();
            param.setUserId(createVal);
            param.setPrivide(createVal);
            param.setOpenId(createVal);
            param.setUnionId(createVal);
            param.setCreateId(createVal);
            param.setCreateTime(createVal);
            param.setUpdateId(createVal);
            param.setUpdateTime(createVal);
		    return bindService.create(param);
    }

    public void doUpdate(String recId){
			Bind param = new Bind();
	        param.setRecId(recId);
	        param.setUserId(updateVal);
	        param.setPrivide(updateVal);
	        param.setOpenId(updateVal);
	        param.setUnionId(updateVal);
	        param.setCreateId(updateVal);
	        param.setCreateTime(updateVal);
	        param.setUpdateId(updateVal);
	        param.setUpdateTime(updateVal);
            bindService.update(param);
    }

    @Test
	public void delete(){
		    Bind param = new Bind();
            int num = bindService.count(param);
	        String recId = doCreate();
	        int num2 = bindService.count(param);
	        assertEquals(num + 1, num2);
		    bindService.delete(recId);
            int num3 = bindService.count(param);
            assertEquals(num, num3);
	}

    @Test
	public void testList() {
		Bind param = new Bind();
        PageInfo pageInfo = new PageInfo();
        pageInfo.setPerPageNum(1000000);
        pageInfo.setCurrentPageIndex(1);
        pageInfo.setTotalNum(100000);
		List<Bind> results = bindService.list(param,pageInfo);
		int num = results.size();
        String recId = doCreate();
        List<Bind> results2 = bindService.list(param,pageInfo);
        int num2 = results2.size();
        assertEquals(num + 1, num2);
	}

    @Test
	public void testCount() {
		    Bind param = new Bind();
            int num = bindService.count(param);
            doCreate();
            int num2 = bindService.count(param);
	        assertEquals(num + 1, num2);
    }

}