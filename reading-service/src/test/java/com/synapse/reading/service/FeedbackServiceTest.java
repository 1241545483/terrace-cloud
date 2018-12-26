package com.synapse.reading.service;

import com.synapse.common.constants.PageInfo;
import com.synapse.reading.model.Feedback;
import com.synapse.reading.respository.FeedbackRespository;
import com.synapse.reading.dto.param.FeedbackParam;
import com.synapse.reading.dto.result.FeedbackResult;
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
 * 意见反馈 服务测试类
 * </p>
 *
 * @author liuguangfu
 * @since 2018-12-26
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestConfig.class)
@Transactional
public class FeedbackServiceTest {

    private final String createVal = "A";
    private final String updateVal = "B";

    @MockBean
    private IdService idService;

    @Autowired
    private FeedbackService feedbackService;

    @Test
    public void testFind(){
        String recId = doCreate();
	    Feedback result = feedbackService.find(recId);
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
		Feedback result = feedbackService.find(recId);
        assertEquals(val,result.getContent());
        assertEquals(val,result.getCreateId());
    }

    @Test
    public void create() {
	    String recId = doCreate();
	    assertNotNull(recId);
    }

    public String doCreate(){
            Mockito.when(idService.gen(Mockito.anyString())).thenReturn(System.nanoTime() + "");
		    Feedback param = new Feedback();
            param.setContent(createVal);
            param.setCreateId(createVal);
            param.setCreateTime(createVal);
		    return feedbackService.create(param);
    }

    public void doUpdate(String recId){
			Feedback param = new Feedback();
	        param.setRecId(recId);
	        param.setContent(updateVal);
	        param.setCreateId(updateVal);
	        param.setCreateTime(updateVal);
            feedbackService.update(param);
    }

    @Test
	public void delete(){
		    Feedback param = new Feedback();
            int num = feedbackService.count(param);
	        String recId = doCreate();
	        int num2 = feedbackService.count(param);
	        assertEquals(num + 1, num2);
		    feedbackService.delete(recId);
            int num3 = feedbackService.count(param);
            assertEquals(num, num3);
	}

    @Test
	public void testList() {
		Feedback param = new Feedback();
        PageInfo pageInfo = new PageInfo();
        pageInfo.setPerPageNum(1000000);
        pageInfo.setCurrentPageIndex(1);
        pageInfo.setTotalNum(100000);
		List<Feedback> results = feedbackService.list(param,pageInfo);
		int num = results.size();
        String recId = doCreate();
        List<Feedback> results2 = feedbackService.list(param,pageInfo);
        int num2 = results2.size();
        assertEquals(num + 1, num2);
	}

    @Test
	public void testCount() {
		    Feedback param = new Feedback();
            int num = feedbackService.count(param);
            doCreate();
            int num2 = feedbackService.count(param);
	        assertEquals(num + 1, num2);
    }

}