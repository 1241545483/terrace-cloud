package com.synapse.reading.service;

import com.synapse.common.constants.PageInfo;
import com.synapse.reading.model.IssueItem;
import com.synapse.reading.respository.IssueItemRespository;
import com.synapse.reading.dto.param.IssueItemParam;
import com.synapse.reading.dto.result.IssueItemResult;
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
 * 题目选项 服务测试类
 * </p>
 *
 * @author liuguangfu
 * @since 2019-01-09
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestConfig.class)
@Transactional
public class IssueItemServiceTest {

    private final String createVal = "A";
    private final String updateVal = "B";

    @MockBean
    private IdService idService;

    @Autowired
    private IssueItemService issueItemService;

    @Test
    public void testFind(){
        String recId = doCreate();
	    IssueItem result = issueItemService.find(recId);
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
		IssueItem result = issueItemService.find(recId);
        assertEquals(val,result.getIssueId());
        assertEquals(val,result.getContent());
        assertEquals(val,result.getImg1());
        assertEquals(val,result.getImg2());
        assertEquals(val,result.getImg3());
        assertEquals(val,result.getIsAnswer());
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
		    IssueItem param = new IssueItem();
            param.setIssueId(createVal);
            param.setContent(createVal);
            param.setImg1(createVal);
            param.setImg2(createVal);
            param.setImg3(createVal);
            param.setIsAnswer(createVal);
            param.setCreateId(createVal);
            param.setCreateTime(createVal);
            param.setUpdateId(createVal);
            param.setUpdateTime(createVal);
		    return issueItemService.create(param);
    }

    public void doUpdate(String recId){
			IssueItem param = new IssueItem();
	        param.setRecId(recId);
	        param.setIssueId(updateVal);
	        param.setContent(updateVal);
	        param.setImg1(updateVal);
	        param.setImg2(updateVal);
	        param.setImg3(updateVal);
	        param.setIsAnswer(updateVal);
	        param.setCreateId(updateVal);
	        param.setCreateTime(updateVal);
	        param.setUpdateId(updateVal);
	        param.setUpdateTime(updateVal);
            issueItemService.update(param);
    }

    @Test
	public void delete(){
		    IssueItem param = new IssueItem();
            int num = issueItemService.count(param);
	        String recId = doCreate();
	        int num2 = issueItemService.count(param);
	        assertEquals(num + 1, num2);
		    issueItemService.delete(recId);
            int num3 = issueItemService.count(param);
            assertEquals(num, num3);
	}

    @Test
	public void testList() {
		IssueItem param = new IssueItem();
        PageInfo pageInfo = new PageInfo();
        pageInfo.setPerPageNum(1000000);
        pageInfo.setCurrentPageIndex(1);
        pageInfo.setTotalNum(100000);
		List<IssueItem> results = issueItemService.list(param,pageInfo);
		int num = results.size();
        String recId = doCreate();
        List<IssueItem> results2 = issueItemService.list(param,pageInfo);
        int num2 = results2.size();
        assertEquals(num + 1, num2);
	}

    @Test
	public void testCount() {
		    IssueItem param = new IssueItem();
            int num = issueItemService.count(param);
            doCreate();
            int num2 = issueItemService.count(param);
	        assertEquals(num + 1, num2);
    }

}