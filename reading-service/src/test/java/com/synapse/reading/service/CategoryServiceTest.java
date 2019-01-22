package com.synapse.reading.service;

import com.synapse.common.constants.PageInfo;
import com.synapse.reading.model.Category;
import com.synapse.reading.respository.CategoryRespository;
import com.synapse.reading.dto.param.CategoryParam;
import com.synapse.reading.dto.result.CategoryResult;
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
 * 推荐中高考书籍目录（三级） 服务测试类
 * </p>
 *
 * @author liuguangfu
 * @since 2019-01-22
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestConfig.class)
@Transactional
public class CategoryServiceTest {

    private final String createVal = "A";
    private final String updateVal = "B";

    @MockBean
    private IdService idService;

    @Autowired
    private CategoryService categoryService;

    @Test
    public void testFind(){
        String recId = doCreate();
	    Category result = categoryService.find(recId);
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
		Category result = categoryService.find(recId);
        assertEquals(val,result.getName());
        assertEquals(val,result.getPid());
        assertEquals(val,result.getPpid());
        assertEquals(val,result.getItemId());
        assertEquals(val,result.getItemType());
        assertEquals(val,result.getLevel());
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
		    Category param = new Category();
            param.setName(createVal);
            param.setPid(createVal);
            param.setPpid(createVal);
            param.setItemId(createVal);
            param.setItemType(createVal);
            param.setLevel(createVal);
            param.setCreateId(createVal);
            param.setCreateTime(createVal);
            param.setUpdateId(createVal);
            param.setUpdateTime(createVal);
		    return categoryService.create(param);
    }

    public void doUpdate(String recId){
			Category param = new Category();
	        param.setRecId(recId);
	        param.setName(updateVal);
	        param.setPid(updateVal);
	        param.setPpid(updateVal);
	        param.setItemId(updateVal);
	        param.setItemType(updateVal);
	        param.setLevel(updateVal);
	        param.setCreateId(updateVal);
	        param.setCreateTime(updateVal);
	        param.setUpdateId(updateVal);
	        param.setUpdateTime(updateVal);
            categoryService.update(param);
    }

    @Test
	public void delete(){
		    Category param = new Category();
            int num = categoryService.count(param);
	        String recId = doCreate();
	        int num2 = categoryService.count(param);
	        assertEquals(num + 1, num2);
		    categoryService.delete(recId);
            int num3 = categoryService.count(param);
            assertEquals(num, num3);
	}

    @Test
	public void testList() {
		Category param = new Category();
        PageInfo pageInfo = new PageInfo();
        pageInfo.setPerPageNum(1000000);
        pageInfo.setCurrentPageIndex(1);
        pageInfo.setTotalNum(100000);
		List<Category> results = categoryService.list(param,pageInfo);
		int num = results.size();
        String recId = doCreate();
        List<Category> results2 = categoryService.list(param,pageInfo);
        int num2 = results2.size();
        assertEquals(num + 1, num2);
	}

    @Test
	public void testCount() {
		    Category param = new Category();
            int num = categoryService.count(param);
            doCreate();
            int num2 = categoryService.count(param);
	        assertEquals(num + 1, num2);
    }

}