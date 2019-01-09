package com.synapse.reading.service;

import com.synapse.common.constants.PageInfo;
import com.synapse.reading.model.IssueAnswer;
import com.synapse.reading.respository.IssueAnswerRespository;
import com.synapse.reading.dto.param.IssueAnswerParam;
import com.synapse.reading.dto.result.IssueAnswerResult;
import com.synapse.reading.constants.IssueAnswerConstants;
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
 * 问题回答 服务测试类
 * </p>
 *
 * @author liuguangfu
 * @since 2019-01-09
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestConfig.class)
@Transactional
public class IssueAnswerServiceTest {

    private final String createVal = "A";
    private final String updateVal = "B";

    @MockBean
    private IdService idService;

    @Autowired
    private IssueAnswerService issueAnswerService;

    @Test
    public void testFind(){
        String recId = doCreate();
	    IssueAnswer result = issueAnswerService.find(recId);
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
		IssueAnswer result = issueAnswerService.find(recId);
        assertEquals(val,result.getIssueId());
        assertEquals(val,result.getItemId());
        assertEquals(val,result.getCreateId());
    }

    @Test
    public void create() {
	    String recId = doCreate();
	    assertNotNull(recId);
    }

    public String doCreate(){
            Mockito.when(idService.gen(Mockito.anyString())).thenReturn(System.nanoTime() + "");
		    IssueAnswer param = new IssueAnswer();
            param.setIssueId(createVal);
            param.setItemId(createVal);
            param.setStatus(createVal);
            param.setCreateId(createVal);
            param.setCreateTime(createVal);
		    return issueAnswerService.create(param);
    }

    public void doUpdate(String recId){
			IssueAnswer param = new IssueAnswer();
	        param.setRecId(recId);
	        param.setIssueId(updateVal);
	        param.setItemId(updateVal);
	        param.setStatus(updateVal);
	        param.setCreateId(updateVal);
	        param.setCreateTime(updateVal);
            issueAnswerService.update(param);
    }

    @Test
	public void delete(){
		    IssueAnswer param = new IssueAnswer();
            param.setStatus(IssueAnswerConstants.STATUS.OK.num());
            int num = issueAnswerService.count(param);
	        String recId = doCreate();
	        int num2 = issueAnswerService.count(param);
	        assertEquals(num + 1, num2);
			issueAnswerService.delete(recId, "-1");
            int num3 = issueAnswerService.count(param);
            assertEquals(num, num3);
	}

    @Test
	public void testList() {
		IssueAnswer param = new IssueAnswer();
        PageInfo pageInfo = new PageInfo();
        pageInfo.setPerPageNum(1000000);
        pageInfo.setCurrentPageIndex(1);
        pageInfo.setTotalNum(100000);
		List<IssueAnswer> results = issueAnswerService.list(param,pageInfo);
		int num = results.size();
        String recId = doCreate();
        List<IssueAnswer> results2 = issueAnswerService.list(param,pageInfo);
        int num2 = results2.size();
        assertEquals(num + 1, num2);
	}

    @Test
	public void testCount() {
		    IssueAnswer param = new IssueAnswer();
            int num = issueAnswerService.count(param);
            doCreate();
            int num2 = issueAnswerService.count(param);
	        assertEquals(num + 1, num2);
    }

}