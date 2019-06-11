package com.synapse.reading.service;

import com.synapse.common.constants.PageInfo;
import com.synapse.reading.model.Task;
import com.synapse.reading.respository.TaskRespository;
import com.synapse.reading.dto.param.TaskParam;
import com.synapse.reading.dto.result.TaskResult;
import com.synapse.reading.constants.TaskConstants;
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
 * 任务 服务测试类
 * </p>
 *
 * @author liuguangfu
 * @since 2019-06-11
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestConfig.class)
@Transactional
public class TaskServiceTest {

    private final String createVal = "A";
    private final String updateVal = "B";

    @MockBean
    private IdService idService;

    @Autowired
    private TaskService taskService;

    @Test
    public void testFind(){
        String recId = doCreate();
	    Task result = taskService.find(recId);
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
		Task result = taskService.find(recId);
        assertEquals(val,result.getName());
        assertEquals(val,result.getIntro());
        assertEquals(val,result.getStudyType());
        assertEquals(val,result.getStudyId());
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
		    Task param = new Task();
            param.setName(createVal);
            param.setIntro(createVal);
            param.setStudyType(createVal);
            param.setStudyId(createVal);
            param.setStatus(createVal);
            param.setCreateId(createVal);
            param.setCreateTime(createVal);
            param.setUpdateId(createVal);
            param.setUpdateTime(createVal);
		    return taskService.create(param);
    }

    public void doUpdate(String recId){
			Task param = new Task();
	        param.setRecId(recId);
	        param.setName(updateVal);
	        param.setIntro(updateVal);
	        param.setStudyType(updateVal);
	        param.setStudyId(updateVal);
	        param.setStatus(updateVal);
	        param.setCreateId(updateVal);
	        param.setCreateTime(updateVal);
	        param.setUpdateId(updateVal);
	        param.setUpdateTime(updateVal);
            taskService.update(param);
    }

    @Test
	public void delete(){
		    Task param = new Task();
            param.setStatus(TaskConstants.STATUS.OK.num());
            int num = taskService.count(param);
	        String recId = doCreate();
	        int num2 = taskService.count(param);
	        assertEquals(num + 1, num2);
			taskService.delete(recId, "-1");
            int num3 = taskService.count(param);
            assertEquals(num, num3);
	}

    @Test
	public void testList() {
		Task param = new Task();
        PageInfo pageInfo = new PageInfo();
        pageInfo.setPerPageNum(1000000);
        pageInfo.setCurrentPageIndex(1);
        pageInfo.setTotalNum(100000);
		List<Task> results = taskService.list(param,pageInfo);
		int num = results.size();
        String recId = doCreate();
        List<Task> results2 = taskService.list(param,pageInfo);
        int num2 = results2.size();
        assertEquals(num + 1, num2);
	}

    @Test
	public void testCount() {
		    Task param = new Task();
            int num = taskService.count(param);
            doCreate();
            int num2 = taskService.count(param);
	        assertEquals(num + 1, num2);
    }

}