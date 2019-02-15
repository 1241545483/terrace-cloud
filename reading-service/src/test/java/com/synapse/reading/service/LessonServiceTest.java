package com.synapse.reading.service;

import com.synapse.common.constants.PageInfo;
import com.synapse.reading.model.Lesson;
import com.synapse.reading.respository.LessonRespository;
import com.synapse.reading.dto.param.LessonParam;
import com.synapse.reading.dto.result.LessonResult;
import com.synapse.reading.constants.LessonConstants;
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
 * 课程 服务测试类
 * </p>
 *
 * @author liuguangfu
 * @since 2019-02-15
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestConfig.class)
@Transactional
public class LessonServiceTest {

    private final String createVal = "A";
    private final String updateVal = "B";

    @MockBean
    private IdService idService;

    @Autowired
    private LessonService lessonService;

    @Test
    public void testFind(){
        String recId = doCreate();
	    Lesson result = lessonService.find(recId);
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
		Lesson result = lessonService.find(recId);
        assertEquals(val,result.getName());
        assertEquals(val,result.getIntro());
        assertEquals(val,result.getPresentation());
        assertEquals(val,result.getImage());
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
		    Lesson param = new Lesson();
            param.setName(createVal);
            param.setIntro(createVal);
            param.setPresentation(createVal);
            param.setImage(createVal);
            param.setBanner(createVal);
            param.setPublishStatus(createVal);
            param.setStatus(createVal);
            param.setOrderNum(-1);
            param.setVisitNum(-1L);
            param.setCreateId(createVal);
            param.setCreateTime(createVal);
            param.setUpdateId(createVal);
            param.setUpdateTime(createVal);
		    return lessonService.create(param);
    }

    public void doUpdate(String recId){
			Lesson param = new Lesson();
	        param.setRecId(recId);
	        param.setName(updateVal);
	        param.setIntro(updateVal);
	        param.setPresentation(updateVal);
	        param.setImage(updateVal);
	        param.setBanner(updateVal);
	        param.setPublishStatus(updateVal);
	        param.setStatus(updateVal);
	        param.setOrderNum(-2);
	        param.setVisitNum(-2L);
	        param.setCreateId(updateVal);
	        param.setCreateTime(updateVal);
	        param.setUpdateId(updateVal);
	        param.setUpdateTime(updateVal);
            lessonService.update(param);
    }

    @Test
	public void delete(){
		    Lesson param = new Lesson();
            param.setStatus(LessonConstants.STATUS.OK.num());
            int num = lessonService.count(param);
	        String recId = doCreate();
	        int num2 = lessonService.count(param);
	        assertEquals(num + 1, num2);
			lessonService.delete(recId, "-1");
            int num3 = lessonService.count(param);
            assertEquals(num, num3);
	}

    @Test
	public void testList() {
		Lesson param = new Lesson();
        PageInfo pageInfo = new PageInfo();
        pageInfo.setPerPageNum(1000000);
        pageInfo.setCurrentPageIndex(1);
        pageInfo.setTotalNum(100000);
		List<Lesson> results = lessonService.list(param,pageInfo);
		int num = results.size();
        String recId = doCreate();
        List<Lesson> results2 = lessonService.list(param,pageInfo);
        int num2 = results2.size();
        assertEquals(num + 1, num2);
	}

    @Test
	public void testCount() {
		    Lesson param = new Lesson();
            int num = lessonService.count(param);
            doCreate();
            int num2 = lessonService.count(param);
	        assertEquals(num + 1, num2);
    }

}