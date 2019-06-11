package com.synapse.reading.service;

import com.synapse.common.constants.PageInfo;
import com.synapse.reading.model.TaskStudyMapping;
import com.synapse.reading.respository.TaskStudyMappingRespository;
import com.synapse.reading.dto.param.TaskStudyMappingParam;
import com.synapse.reading.dto.result.TaskStudyMappingResult;
import com.synapse.reading.constants.TaskStudyMappingConstants;
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
 * 任务和学习课程的关系 服务测试类
 * </p>
 *
 * @author liuguangfu
 * @since 2019-06-11
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestConfig.class)
@Transactional
public class TaskStudyMappingServiceTest {

    private final String createVal = "A";
    private final String updateVal = "B";

    @MockBean
    private IdService idService;

    @Autowired
    private TaskStudyMappingService taskStudyMappingService;

    @Test
    public void testFind(){
        String recId = doCreate();
	    TaskStudyMapping result = taskStudyMappingService.find(recId);
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
		TaskStudyMapping result = taskStudyMappingService.find(recId);
        assertEquals(val,result.getTaskId());
        assertEquals(val,result.getStudyId());
        assertEquals(val,result.getStudyType());
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
		    TaskStudyMapping param = new TaskStudyMapping();
            param.setTaskId(createVal);
            param.setStudyId(createVal);
            param.setStudyType(createVal);
            param.setStatus(createVal);
            param.setCreateId(createVal);
            param.setUpdateId(createVal);
            param.setCreateTime(createVal);
            param.setUpdateTime(createVal);
		    return taskStudyMappingService.create(param);
    }

    public void doUpdate(String recId){
			TaskStudyMapping param = new TaskStudyMapping();
	        param.setRecId(recId);
	        param.setTaskId(updateVal);
	        param.setStudyId(updateVal);
	        param.setStudyType(updateVal);
	        param.setStatus(updateVal);
	        param.setCreateId(updateVal);
	        param.setUpdateId(updateVal);
	        param.setCreateTime(updateVal);
	        param.setUpdateTime(updateVal);
            taskStudyMappingService.update(param);
    }

    @Test
	public void delete(){
		    TaskStudyMapping param = new TaskStudyMapping();
            param.setStatus(TaskStudyMappingConstants.STATUS.OK.num());
            int num = taskStudyMappingService.count(param);
	        String recId = doCreate();
	        int num2 = taskStudyMappingService.count(param);
	        assertEquals(num + 1, num2);
			taskStudyMappingService.delete(recId, "-1");
            int num3 = taskStudyMappingService.count(param);
            assertEquals(num, num3);
	}

    @Test
	public void testList() {
		TaskStudyMapping param = new TaskStudyMapping();
        PageInfo pageInfo = new PageInfo();
        pageInfo.setPerPageNum(1000000);
        pageInfo.setCurrentPageIndex(1);
        pageInfo.setTotalNum(100000);
		List<TaskStudyMapping> results = taskStudyMappingService.list(param,pageInfo);
		int num = results.size();
        String recId = doCreate();
        List<TaskStudyMapping> results2 = taskStudyMappingService.list(param,pageInfo);
        int num2 = results2.size();
        assertEquals(num + 1, num2);
	}

    @Test
	public void testCount() {
		    TaskStudyMapping param = new TaskStudyMapping();
            int num = taskStudyMappingService.count(param);
            doCreate();
            int num2 = taskStudyMappingService.count(param);
	        assertEquals(num + 1, num2);
    }

}