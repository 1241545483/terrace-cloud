package com.synapse.reading.service;

import com.synapse.common.constants.PageInfo;
import com.synapse.reading.model.Recommend;
import com.synapse.reading.respository.RecommendRespository;
import com.synapse.reading.dto.param.RecommendParam;
import com.synapse.reading.dto.result.RecommendResult;
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
 * 推荐 服务测试类
 * </p>
 *
 * @author liuguangfu
 * @since 2018-12-27
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestConfig.class)
@Transactional
public class RecommendServiceTest {

    private final String createVal = "A";
    private final String updateVal = "B";

    @MockBean
    private IdService idService;

    @Autowired
    private RecommendService recommendService;

    @Test
    public void testFind(){
        String recId = doCreate();
	    Recommend result = recommendService.find(recId);
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
		Recommend result = recommendService.find(recId);
        assertEquals(val,result.getRecommendType());
        assertEquals(val,result.getRecommendId());
        assertEquals(val,result.getCreateId());
        assertEquals(val,result.getStartTime());
        assertEquals(val,result.getEndTime());
    }

    @Test
    public void create() {
	    String recId = doCreate();
	    assertNotNull(recId);
    }

    public String doCreate(){
            Mockito.when(idService.gen(Mockito.anyString())).thenReturn(System.nanoTime() + "");
		    Recommend param = new Recommend();
            param.setRecommendType(createVal);
            param.setRecommendId(createVal);
            param.setCreateId(createVal);
            param.setCreateTime(createVal);
            param.setStartTime(createVal);
            param.setEndTime(createVal);
		    return recommendService.create(param);
    }

    public void doUpdate(String recId){
			Recommend param = new Recommend();
	        param.setRecId(recId);
	        param.setRecommendType(updateVal);
	        param.setRecommendId(updateVal);
	        param.setCreateId(updateVal);
	        param.setCreateTime(updateVal);
	        param.setStartTime(updateVal);
	        param.setEndTime(updateVal);
            recommendService.update(param);
    }

    @Test
	public void delete(){
		    Recommend param = new Recommend();
            int num = recommendService.count(param);
	        String recId = doCreate();
	        int num2 = recommendService.count(param);
	        assertEquals(num + 1, num2);
		    recommendService.delete(recId);
            int num3 = recommendService.count(param);
            assertEquals(num, num3);
	}

    @Test
	public void testList() {
		Recommend param = new Recommend();
        PageInfo pageInfo = new PageInfo();
        pageInfo.setPerPageNum(1000000);
        pageInfo.setCurrentPageIndex(1);
        pageInfo.setTotalNum(100000);
		List<Recommend> results = recommendService.list(param,pageInfo);
		int num = results.size();
        String recId = doCreate();
        List<Recommend> results2 = recommendService.list(param,pageInfo);
        int num2 = results2.size();
        assertEquals(num + 1, num2);
	}

    @Test
	public void testCount() {
		    Recommend param = new Recommend();
            int num = recommendService.count(param);
            doCreate();
            int num2 = recommendService.count(param);
	        assertEquals(num + 1, num2);
    }

}