package com.synapse.reading.service;

import com.synapse.common.constants.PageInfo;
import com.synapse.reading.model.Information;
import com.synapse.reading.respository.InformationRespository;
import com.synapse.reading.dto.param.InformationParam;
import com.synapse.reading.dto.result.InformationResult;
import com.synapse.reading.constants.InformationConstants;
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
 * 资讯模块 服务测试类
 * </p>
 *
 * @author liuguangfu
 * @since 2018-12-01
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestConfig.class)
@Transactional
public class InformationServiceTest {

    private final String createVal = "A";
    private final String updateVal = "B";

    @MockBean
    private IdService idService;

    @Autowired
    private InformationService informationService;

    @Test
    public void testFind(){
        String recId = doCreate();
	    Information result = informationService.find(recId);
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
		Information result = informationService.find(recId);
        assertEquals(val,result.getTitle());
        assertEquals(val,result.getAuthor());
        assertEquals(val,result.getContent());
        assertEquals(val,result.getCover());
        assertEquals(val,result.getPublishStatus());
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
		    Information param = new Information();
            param.setTitle(createVal);
            param.setAuthor(createVal);
            param.setContent(createVal);
            param.setCover(createVal);
            param.setReadNum(-1L);
            param.setLikeNum(-1L);
            param.setPublishStatus(createVal);
            param.setStatus(createVal);
            param.setCreateId(createVal);
            param.setCreateTime(createVal);
            param.setUpdateId(createVal);
            param.setUpdateTime(createVal);
		    return informationService.create(param);
    }

    public void doUpdate(String recId){
			Information param = new Information();
	        param.setRecId(recId);
	        param.setTitle(updateVal);
	        param.setAuthor(updateVal);
	        param.setContent(updateVal);
	        param.setCover(updateVal);
	        param.setReadNum(-2L);
	        param.setLikeNum(-2L);
	        param.setPublishStatus(updateVal);
	        param.setStatus(updateVal);
	        param.setCreateId(updateVal);
	        param.setCreateTime(updateVal);
	        param.setUpdateId(updateVal);
	        param.setUpdateTime(updateVal);
            informationService.update(param);
    }

    @Test
	public void delete(){
		    Information param = new Information();
            param.setStatus(InformationConstants.STATUS.OK.num());
            int num = informationService.count(param);
	        String recId = doCreate();
	        int num2 = informationService.count(param);
	        assertEquals(num + 1, num2);
			informationService.delete(recId, "-1");
            int num3 = informationService.count(param);
            assertEquals(num, num3);
	}

    @Test
	public void testList() {
		Information param = new Information();
        PageInfo pageInfo = new PageInfo();
        pageInfo.setPerPageNum(1000000);
        pageInfo.setCurrentPageIndex(1);
        pageInfo.setTotalNum(100000);
		List<Information> results = informationService.list(param,pageInfo);
		int num = results.size();
        String recId = doCreate();
        List<Information> results2 = informationService.list(param,pageInfo);
        int num2 = results2.size();
        assertEquals(num + 1, num2);
	}

    @Test
	public void testCount() {
		    Information param = new Information();
            int num = informationService.count(param);
            doCreate();
            int num2 = informationService.count(param);
	        assertEquals(num + 1, num2);
    }

}