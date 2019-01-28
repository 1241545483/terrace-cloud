package com.synapse.reading.service;

import com.synapse.common.constants.PageInfo;
import com.synapse.reading.model.Topic;
import com.synapse.reading.respository.TopicRespository;
import com.synapse.reading.dto.param.TopicParam;
import com.synapse.reading.dto.result.TopicResult;
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
 * 主题，关联专辑 服务测试类
 * </p>
 *
 * @author liuguangfu
 * @since 2019-01-28
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestConfig.class)
@Transactional
public class TopicServiceTest {

    private final String createVal = "A";
    private final String updateVal = "B";

    @MockBean
    private IdService idService;

    @Autowired
    private TopicService topicService;

    @Test
    public void testFind(){
        String recId = doCreate();
	    Topic result = topicService.find(recId);
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
		Topic result = topicService.find(recId);
        assertEquals(val,result.getName());
        assertEquals(val,result.getBanner());
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
		    Topic param = new Topic();
            param.setName(createVal);
            param.setBanner(createVal);
            param.setOrderNum(-1);
            param.setCreateId(createVal);
            param.setCreateTime(createVal);
            param.setUpdateId(createVal);
            param.setUpdateTime(createVal);
		    return topicService.create(param);
    }

    public void doUpdate(String recId){
			Topic param = new Topic();
	        param.setRecId(recId);
	        param.setName(updateVal);
	        param.setBanner(updateVal);
	        param.setOrderNum(-2);
	        param.setCreateId(updateVal);
	        param.setCreateTime(updateVal);
	        param.setUpdateId(updateVal);
	        param.setUpdateTime(updateVal);
            topicService.update(param);
    }

    @Test
	public void delete(){
		    Topic param = new Topic();
            int num = topicService.count(param);
	        String recId = doCreate();
	        int num2 = topicService.count(param);
	        assertEquals(num + 1, num2);
		    topicService.delete(recId);
            int num3 = topicService.count(param);
            assertEquals(num, num3);
	}

    @Test
	public void testList() {
		Topic param = new Topic();
        PageInfo pageInfo = new PageInfo();
        pageInfo.setPerPageNum(1000000);
        pageInfo.setCurrentPageIndex(1);
        pageInfo.setTotalNum(100000);
		List<Topic> results = topicService.list(param,pageInfo);
		int num = results.size();
        String recId = doCreate();
        List<Topic> results2 = topicService.list(param,pageInfo);
        int num2 = results2.size();
        assertEquals(num + 1, num2);
	}

    @Test
	public void testCount() {
		    Topic param = new Topic();
            int num = topicService.count(param);
            doCreate();
            int num2 = topicService.count(param);
	        assertEquals(num + 1, num2);
    }

}