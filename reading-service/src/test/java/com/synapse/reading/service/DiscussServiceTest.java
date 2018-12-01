package com.synapse.reading.service;

import com.synapse.common.constants.PageInfo;
import com.synapse.reading.model.Discuss;
import com.synapse.reading.respository.DiscussRespository;
import com.synapse.reading.dto.param.DiscussParam;
import com.synapse.reading.dto.result.DiscussResult;
import com.synapse.reading.constants.DiscussConstants;
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
 * 评论表 服务测试类
 * </p>
 *
 * @author liuguangfu
 * @since 2018-12-01
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestConfig.class)
@Transactional
public class DiscussServiceTest {

    private final String createVal = "A";
    private final String updateVal = "B";

    @MockBean
    private IdService idService;

    @Autowired
    private DiscussService discussService;

    @Test
    public void testFind(){
        String recId = doCreate();
	    Discuss result = discussService.find(recId);
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
		Discuss result = discussService.find(recId);
        assertEquals(val,result.getCommentType());
        assertEquals(val,result.getCommentId());
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
		    Discuss param = new Discuss();
            param.setCommentType(createVal);
            param.setCommentId(createVal);
            param.setContent(createVal);
            param.setLikeNum(-1L);
            param.setStatus(createVal);
            param.setCreateId(createVal);
            param.setCreateTime(createVal);
		    return discussService.create(param);
    }

    public void doUpdate(String recId){
			Discuss param = new Discuss();
	        param.setRecId(recId);
	        param.setCommentType(updateVal);
	        param.setCommentId(updateVal);
	        param.setContent(updateVal);
	        param.setLikeNum(-2L);
	        param.setStatus(updateVal);
	        param.setCreateId(updateVal);
	        param.setCreateTime(updateVal);
            discussService.update(param);
    }

    @Test
	public void delete(){
		    Discuss param = new Discuss();
            param.setStatus(DiscussConstants.STATUS.OK.num());
            int num = discussService.count(param);
	        String recId = doCreate();
	        int num2 = discussService.count(param);
	        assertEquals(num + 1, num2);
			discussService.delete(recId, "-1");
            int num3 = discussService.count(param);
            assertEquals(num, num3);
	}

    @Test
	public void testList() {
		Discuss param = new Discuss();
        PageInfo pageInfo = new PageInfo();
        pageInfo.setPerPageNum(1000000);
        pageInfo.setCurrentPageIndex(1);
        pageInfo.setTotalNum(100000);
		List<Discuss> results = discussService.list(param,pageInfo);
		int num = results.size();
        String recId = doCreate();
        List<Discuss> results2 = discussService.list(param,pageInfo);
        int num2 = results2.size();
        assertEquals(num + 1, num2);
	}

    @Test
	public void testCount() {
		    Discuss param = new Discuss();
            int num = discussService.count(param);
            doCreate();
            int num2 = discussService.count(param);
	        assertEquals(num + 1, num2);
    }

}