package com.synapse.reading.service;

import com.synapse.common.constants.PageInfo;
import com.synapse.reading.model.Book;
import com.synapse.reading.respository.BookRespository;
import com.synapse.reading.dto.param.BookParam;
import com.synapse.reading.dto.result.BookResult;
import com.synapse.reading.constants.BookConstants;
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
 *  服务测试类
 * </p>
 *
 * @author liuguangfu
 * @since 2018-12-27
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestConfig.class)
@Transactional
public class BookServiceTest {

    private final String createVal = "A";
    private final String updateVal = "B";

    @MockBean
    private IdService idService;

    @Autowired
    private BookService bookService;

    @Test
    public void testFind(){
        String recId = doCreate();
	    Book result = bookService.find(recId);
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
		Book result = bookService.find(recId);
        assertEquals(val,result.getName());
        assertEquals(val,result.getIntro());
        assertEquals(val,result.getSlogan());
        assertEquals(val,result.getType());
        assertEquals(val,result.getCover());
        assertEquals(val,result.getBanner());
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
		    Book param = new Book();
            param.setName(createVal);
            param.setIntro(createVal);
            param.setSlogan(createVal);
            param.setType(createVal);
            param.setCover(createVal);
            param.setBanner(createVal);
            param.setPublishStatus(createVal);
            param.setStatus(createVal);
            param.setOrderNum(-1);
            param.setVisitNum(-1L);
            param.setCreateId(createVal);
            param.setCreateTime(createVal);
            param.setUpdateId(createVal);
            param.setUpdateTime(createVal);
		    return bookService.create(param);
    }

    public void doUpdate(String recId){
			Book param = new Book();
	        param.setRecId(recId);
	        param.setName(updateVal);
	        param.setIntro(updateVal);
	        param.setSlogan(updateVal);
	        param.setType(updateVal);
	        param.setCover(updateVal);
	        param.setBanner(updateVal);
	        param.setPublishStatus(updateVal);
	        param.setStatus(updateVal);
	        param.setOrderNum(-2);
	        param.setVisitNum(-2L);
	        param.setCreateId(updateVal);
	        param.setCreateTime(updateVal);
	        param.setUpdateId(updateVal);
	        param.setUpdateTime(updateVal);
            bookService.update(param);
    }

    @Test
	public void delete(){
		    Book param = new Book();
            param.setStatus(BookConstants.STATUS.OK.num());
            int num = bookService.count(param);
	        String recId = doCreate();
	        int num2 = bookService.count(param);
	        assertEquals(num + 1, num2);
			bookService.delete(recId, "-1");
            int num3 = bookService.count(param);
            assertEquals(num, num3);
	}

    @Test
	public void testList() {
		Book param = new Book();
        PageInfo pageInfo = new PageInfo();
        pageInfo.setPerPageNum(1000000);
        pageInfo.setCurrentPageIndex(1);
        pageInfo.setTotalNum(100000);
		List<Book> results = bookService.list(param,pageInfo);
		int num = results.size();
        String recId = doCreate();
        List<Book> results2 = bookService.list(param,pageInfo);
        int num2 = results2.size();
        assertEquals(num + 1, num2);
	}

    @Test
	public void testCount() {
		    Book param = new Book();
            int num = bookService.count(param);
            doCreate();
            int num2 = bookService.count(param);
	        assertEquals(num + 1, num2);
    }

}