package com.synapse.reading.service;

import com.synapse.common.constants.PageInfo;
import com.synapse.reading.model.Expert;
import com.synapse.reading.respository.ExpertRespository;
import com.synapse.reading.dto.param.ExpertParam;
import com.synapse.reading.dto.result.ExpertResult;
import com.synapse.reading.constants.ExpertConstants;
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
 * 专家 服务测试类
 * </p>
 *
 * @author liuguangfu
 * @since 2019-04-09
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestConfig.class)
@Transactional
public class ExpertServiceTest {

    private final String createVal = "A";
    private final String updateVal = "B";

    @MockBean
    private IdService idService;

    @Autowired
    private ExpertService expertService;

    @Test
    public void testFind(){
        String recId = doCreate();
	    Expert result = expertService.find(recId);
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
		Expert result = expertService.find(recId);
        assertEquals(val,result.getUserId());
        assertEquals(val,result.getName());
        assertEquals(val,result.getIntro());
        assertEquals(val,result.getImage());
        assertEquals(val,result.getTitle());
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
		    Expert param = new Expert();
            param.setUserId(createVal);
            param.setName(createVal);
            param.setIntro(createVal);
            param.setImage(createVal);
            param.setTitle(createVal);
            param.setStatus(createVal);
            param.setOrderNum(-1);
            param.setCreateId(createVal);
            param.setCreateTime(createVal);
            param.setUpdateId(createVal);
            param.setUpdateTime(createVal);
		    return expertService.create(param);
    }

    public void doUpdate(String recId){
			Expert param = new Expert();
	        param.setRecId(recId);
	        param.setUserId(updateVal);
	        param.setName(updateVal);
	        param.setIntro(updateVal);
	        param.setImage(updateVal);
	        param.setTitle(updateVal);
	        param.setStatus(updateVal);
	        param.setOrderNum(-2);
	        param.setCreateId(updateVal);
	        param.setCreateTime(updateVal);
	        param.setUpdateId(updateVal);
	        param.setUpdateTime(updateVal);
            expertService.update(param);
    }

    @Test
	public void delete(){
		    Expert param = new Expert();
            param.setStatus(ExpertConstants.STATUS.OK.num());
            int num = expertService.count(param);
	        String recId = doCreate();
	        int num2 = expertService.count(param);
	        assertEquals(num + 1, num2);
			expertService.delete(recId, "-1");
            int num3 = expertService.count(param);
            assertEquals(num, num3);
	}

    @Test
	public void testList() {
		Expert param = new Expert();
        PageInfo pageInfo = new PageInfo();
        pageInfo.setPerPageNum(1000000);
        pageInfo.setCurrentPageIndex(1);
        pageInfo.setTotalNum(100000);
		List<Expert> results = expertService.list(param,pageInfo);
		int num = results.size();
        String recId = doCreate();
        List<Expert> results2 = expertService.list(param,pageInfo);
        int num2 = results2.size();
        assertEquals(num + 1, num2);
	}

    @Test
	public void testCount() {
		    Expert param = new Expert();
            int num = expertService.count(param);
            doCreate();
            int num2 = expertService.count(param);
	        assertEquals(num + 1, num2);
    }

}