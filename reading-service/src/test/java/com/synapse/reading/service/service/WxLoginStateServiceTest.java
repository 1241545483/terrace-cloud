package com.synapse.reading.service.service;

import com.synapse.common.constants.PageInfo;
import com.synapse.reading.model.model.WxLoginState;
import com.synapse.reading.constants.constants.WxLoginStateConstants;
import com.synapse.reading.service.service.WxLoginStateService;
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
 *  服务测试类
 * </p>
 *
 * @author liuguangfu
 * @since 2019-05-28
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestConfig.class)
@Transactional
public class WxLoginStateServiceTest {

    private final String createVal = "A";
    private final String updateVal = "B";

    @MockBean
    private IdService idService;

    @Autowired
    private WxLoginStateService wxLoginStateService;

    @Test
    public void testFind(){
        String recId = doCreate();
	    WxLoginState result = wxLoginStateService.find(recId);
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
		WxLoginState result = wxLoginStateService.find(recId);
        assertEquals(val,result.getOpenId());
        assertEquals(val,result.getUnionId());
        assertEquals(val,result.getToken());
        assertEquals(val,result.getStatusDesc());
    }

    @Test
    public void create() {
	    String recId = doCreate();
	    assertNotNull(recId);
    }

    public String doCreate(){
            Mockito.when(idService.gen(Mockito.anyString())).thenReturn(System.nanoTime() + "");
		    WxLoginState param = new WxLoginState();
            param.setOpenId(createVal);
            param.setUnionId(createVal);
            param.setToken(createVal);
            param.setStatus(createVal);
            param.setStatusDesc(createVal);
		    return wxLoginStateService.create(param);
    }

    public void doUpdate(String recId){
			WxLoginState param = new WxLoginState();
	        param.setRecId(recId);
	        param.setOpenId(updateVal);
	        param.setUnionId(updateVal);
	        param.setToken(updateVal);
	        param.setStatus(updateVal);
	        param.setStatusDesc(updateVal);
            wxLoginStateService.update(param);
    }

    @Test
	public void delete(){
		    WxLoginState param = new WxLoginState();
            param.setStatus(WxLoginStateConstants.STATUS.OK.num());
            int num = wxLoginStateService.count(param);
	        String recId = doCreate();
	        int num2 = wxLoginStateService.count(param);
	        assertEquals(num + 1, num2);
			wxLoginStateService.delete(recId, "-1");
            int num3 = wxLoginStateService.count(param);
            assertEquals(num, num3);
	}

    @Test
	public void testList() {
		WxLoginState param = new WxLoginState();
        PageInfo pageInfo = new PageInfo();
        pageInfo.setPerPageNum(1000000);
        pageInfo.setCurrentPageIndex(1);
        pageInfo.setTotalNum(100000);
		List<WxLoginState> results = wxLoginStateService.list(param,pageInfo);
		int num = results.size();
        String recId = doCreate();
        List<WxLoginState> results2 = wxLoginStateService.list(param,pageInfo);
        int num2 = results2.size();
        assertEquals(num + 1, num2);
	}

    @Test
	public void testCount() {
		    WxLoginState param = new WxLoginState();
            int num = wxLoginStateService.count(param);
            doCreate();
            int num2 = wxLoginStateService.count(param);
	        assertEquals(num + 1, num2);
    }

}