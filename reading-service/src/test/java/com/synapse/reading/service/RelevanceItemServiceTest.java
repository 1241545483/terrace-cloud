package com.synapse.reading.service;

import com.synapse.common.constants.PageInfo;
import com.synapse.reading.model.RelevanceItem;
import com.synapse.reading.respository.RelevanceItemRespository;
import com.synapse.reading.dto.param.RelevanceItemParam;
import com.synapse.reading.dto.result.RelevanceItemResult;
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
 * 书籍与目录对应关系 服务测试类
 * </p>
 *
 * @author liuguangfu
 * @since 2019-01-23
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestConfig.class)
@Transactional
public class RelevanceItemServiceTest {

    private final String createVal = "A";
    private final String updateVal = "B";

    @MockBean
    private IdService idService;

    @Autowired
    private RelevanceItemService relevanceItemService;

    @Test
    public void testFind(){
        String recId = doCreate();
	    RelevanceItem result = relevanceItemService.find(recId);
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
		RelevanceItem result = relevanceItemService.find(recId);
        assertEquals(val,result.getCategoryId());
        assertEquals(val,result.getItemId());
        assertEquals(val,result.getItemType());
        assertEquals(val,result.getWeight());
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
		    RelevanceItem param = new RelevanceItem();
            param.setCategoryId(createVal);
            param.setItemId(createVal);
            param.setItemType(createVal);
            param.setWeight(createVal);
            param.setCreateId(createVal);
            param.setCreateTime(createVal);
            param.setUpdateId(createVal);
            param.setUpdateTime(createVal);
		    return relevanceItemService.create(param);
    }

    public void doUpdate(String recId){
			RelevanceItem param = new RelevanceItem();
	        param.setRecId(recId);
	        param.setCategoryId(updateVal);
	        param.setItemId(updateVal);
	        param.setItemType(updateVal);
	        param.setWeight(updateVal);
	        param.setCreateId(updateVal);
	        param.setCreateTime(updateVal);
	        param.setUpdateId(updateVal);
	        param.setUpdateTime(updateVal);
            relevanceItemService.update(param);
    }

    @Test
	public void delete(){
		    RelevanceItem param = new RelevanceItem();
            int num = relevanceItemService.count(param);
	        String recId = doCreate();
	        int num2 = relevanceItemService.count(param);
	        assertEquals(num + 1, num2);
		    relevanceItemService.delete(recId);
            int num3 = relevanceItemService.count(param);
            assertEquals(num, num3);
	}

    @Test
	public void testList() {
		RelevanceItem param = new RelevanceItem();
        PageInfo pageInfo = new PageInfo();
        pageInfo.setPerPageNum(1000000);
        pageInfo.setCurrentPageIndex(1);
        pageInfo.setTotalNum(100000);
		List<RelevanceItem> results = relevanceItemService.list(param,pageInfo);
		int num = results.size();
        String recId = doCreate();
        List<RelevanceItem> results2 = relevanceItemService.list(param,pageInfo);
        int num2 = results2.size();
        assertEquals(num + 1, num2);
	}

    @Test
	public void testCount() {
		    RelevanceItem param = new RelevanceItem();
            int num = relevanceItemService.count(param);
            doCreate();
            int num2 = relevanceItemService.count(param);
	        assertEquals(num + 1, num2);
    }

}