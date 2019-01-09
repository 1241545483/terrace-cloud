package com.synapse.reading.service;

import com.synapse.common.constants.PageInfo;
import com.synapse.reading.model.Issue;
import com.synapse.reading.respository.IssueRespository;
import com.synapse.reading.dto.param.IssueParam;
import com.synapse.reading.dto.result.IssueResult;
import com.synapse.reading.constants.IssueConstants;
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
 * 观看视频回答题目 服务测试类
 * </p>
 *
 * @author liuguangfu
 * @since 2019-01-09
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestConfig.class)
@Transactional
public class IssueServiceTest {

    private final String createVal = "A";
    private final String updateVal = "B";

    @MockBean
    private IdService idService;

    @Autowired
    private IssueService issueService;

    @Test
    public void testFind(){
        String recId = doCreate();
	    Issue result = issueService.find(recId);
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
		Issue result = issueService.find(recId);
        assertEquals(val,result.getContent());
        assertEquals(val,result.getBelongTo());
        assertEquals(val,result.getBelongToId());
        assertEquals(val,result.getImg1());
        assertEquals(val,result.getImg2());
        assertEquals(val,result.getImg3());
        assertEquals(val,result.getType());
        assertEquals(val,result.getAnalysis());
        assertEquals(val,result.getDifficulty());
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
		    Issue param = new Issue();
            param.setContent(createVal);
            param.setBelongTo(createVal);
            param.setBelongToId(createVal);
            param.setImg1(createVal);
            param.setImg2(createVal);
            param.setImg3(createVal);
            param.setType(createVal);
            param.setAnalysis(createVal);
            param.setDifficulty(createVal);
            param.setStatus(createVal);
            param.setCreateId(createVal);
            param.setCreateTime(createVal);
            param.setUpdateId(createVal);
            param.setUpdateTime(createVal);
		    return issueService.create(param);
    }

    public void doUpdate(String recId){
			Issue param = new Issue();
	        param.setRecId(recId);
	        param.setContent(updateVal);
	        param.setBelongTo(updateVal);
	        param.setBelongToId(updateVal);
	        param.setImg1(updateVal);
	        param.setImg2(updateVal);
	        param.setImg3(updateVal);
	        param.setType(updateVal);
	        param.setAnalysis(updateVal);
	        param.setDifficulty(updateVal);
	        param.setStatus(updateVal);
	        param.setCreateId(updateVal);
	        param.setCreateTime(updateVal);
	        param.setUpdateId(updateVal);
	        param.setUpdateTime(updateVal);
            issueService.update(param);
    }

    @Test
	public void delete(){
		    Issue param = new Issue();
            param.setStatus(IssueConstants.STATUS.OK.num());
            int num = issueService.count(param);
	        String recId = doCreate();
	        int num2 = issueService.count(param);
	        assertEquals(num + 1, num2);
			issueService.delete(recId, "-1");
            int num3 = issueService.count(param);
            assertEquals(num, num3);
	}

    @Test
	public void testList() {
		Issue param = new Issue();
        PageInfo pageInfo = new PageInfo();
        pageInfo.setPerPageNum(1000000);
        pageInfo.setCurrentPageIndex(1);
        pageInfo.setTotalNum(100000);
		List<Issue> results = issueService.list(param,pageInfo);
		int num = results.size();
        String recId = doCreate();
        List<Issue> results2 = issueService.list(param,pageInfo);
        int num2 = results2.size();
        assertEquals(num + 1, num2);
	}

    @Test
	public void testCount() {
		    Issue param = new Issue();
            int num = issueService.count(param);
            doCreate();
            int num2 = issueService.count(param);
	        assertEquals(num + 1, num2);
    }

}