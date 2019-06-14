package com.synapse.reading.service;

import com.synapse.common.constants.PageInfo;
import com.synapse.reading.model.TaskNote;
import com.synapse.reading.respository.TaskNoteRespository;
import com.synapse.reading.dto.param.TaskNoteParam;
import com.synapse.reading.dto.result.TaskNoteResult;
import com.synapse.reading.constants.TaskNoteConstants;
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
 * 任务笔记 服务测试类
 * </p>
 *
 * @author liuguangfu
 * @since 2019-06-13
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestConfig.class)
@Transactional
public class TaskNoteServiceTest {

    private final String createVal = "A";
    private final String updateVal = "B";

    @MockBean
    private IdService idService;

    @Autowired
    private TaskNoteService taskNoteService;

    @Test
    public void testFind(){
        String recId = doCreate();
	    TaskNote result = taskNoteService.find(recId);
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
		TaskNote result = taskNoteService.find(recId);
        assertEquals(val,result.getNote());
        assertEquals(val,result.getUserId());
        assertEquals(val,result.getTaskId());
        assertEquals(val,result.getImg1());
        assertEquals(val,result.getImg2());
        assertEquals(val,result.getImg3());
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
		    TaskNote param = new TaskNote();
            param.setNote(createVal);
            param.setUserId(createVal);
            param.setTaskId(createVal);
            param.setImg1(createVal);
            param.setImg2(createVal);
            param.setImg3(createVal);
            param.setStatus(createVal);
            param.setCreateId(createVal);
            param.setCreateTime(createVal);
            param.setUpdateId(createVal);
            param.setUpdateTime(createVal);
		    return taskNoteService.create(param);
    }

    public void doUpdate(String recId){
			TaskNote param = new TaskNote();
	        param.setRecId(recId);
	        param.setNote(updateVal);
	        param.setUserId(updateVal);
	        param.setTaskId(updateVal);
	        param.setImg1(updateVal);
	        param.setImg2(updateVal);
	        param.setImg3(updateVal);
	        param.setStatus(updateVal);
	        param.setCreateId(updateVal);
	        param.setCreateTime(updateVal);
	        param.setUpdateId(updateVal);
	        param.setUpdateTime(updateVal);
            taskNoteService.update(param);
    }

    @Test
	public void delete(){
		    TaskNote param = new TaskNote();
            param.setStatus(TaskNoteConstants.STATUS.OK.num());
            int num = taskNoteService.count(param);
	        String recId = doCreate();
	        int num2 = taskNoteService.count(param);
	        assertEquals(num + 1, num2);
			taskNoteService.delete(recId, "-1");
            int num3 = taskNoteService.count(param);
            assertEquals(num, num3);
	}

    @Test
	public void testList() {
		TaskNote param = new TaskNote();
        PageInfo pageInfo = new PageInfo();
        pageInfo.setPerPageNum(1000000);
        pageInfo.setCurrentPageIndex(1);
        pageInfo.setTotalNum(100000);
		List<TaskNote> results = taskNoteService.list(param,pageInfo);
		int num = results.size();
        String recId = doCreate();
        List<TaskNote> results2 = taskNoteService.list(param,pageInfo);
        int num2 = results2.size();
        assertEquals(num + 1, num2);
	}

    @Test
	public void testCount() {
		    TaskNote param = new TaskNote();
            int num = taskNoteService.count(param);
            doCreate();
            int num2 = taskNoteService.count(param);
	        assertEquals(num + 1, num2);
    }

}