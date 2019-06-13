package com.synapse.reading.service;

import com.synapse.common.constants.PageInfo;
import com.synapse.reading.model.UserTaskRecord;
import com.synapse.reading.respository.UserTaskRecordRespository;
import com.synapse.reading.dto.param.UserTaskRecordParam;
import com.synapse.reading.dto.result.UserTaskRecordResult;
import com.synapse.reading.constants.UserTaskRecordConstants;
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
 * 任务接受记录 服务测试类
 * </p>
 *
 * @author liuguangfu
 * @since 2019-06-12
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestConfig.class)
@Transactional
public class UserTaskRecordServiceTest {

    private final String createVal = "A";
    private final String updateVal = "B";

    @MockBean
    private IdService idService;

    @Autowired
    private UserTaskRecordService userTaskRecordService;

    @Test
    public void testFind(){
        String recId = doCreate();
	    UserTaskRecord result = userTaskRecordService.find(recId);
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
		UserTaskRecord result = userTaskRecordService.find(recId);
        assertEquals(val,result.getTaskId());
        assertEquals(val,result.getUserId());
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
		    UserTaskRecord param = new UserTaskRecord();
            param.setTaskId(createVal);
            param.setUserId(createVal);
            param.setStatus(createVal);
            param.setCreateId(createVal);
            param.setCreateTime(createVal);
            param.setUpdateId(createVal);
            param.setUpdateTime(createVal);
		    return userTaskRecordService.create(param);
    }

    public void doUpdate(String recId){
			UserTaskRecord param = new UserTaskRecord();
	        param.setRecId(recId);
	        param.setTaskId(updateVal);
	        param.setUserId(updateVal);
	        param.setStatus(updateVal);
	        param.setCreateId(updateVal);
	        param.setCreateTime(updateVal);
	        param.setUpdateId(updateVal);
	        param.setUpdateTime(updateVal);
            userTaskRecordService.update(param);
    }

    @Test
	public void delete(){
		    UserTaskRecord param = new UserTaskRecord();
            param.setStatus(UserTaskRecordConstants.STATUS.OK.num());
            int num = userTaskRecordService.count(param);
	        String recId = doCreate();
	        int num2 = userTaskRecordService.count(param);
	        assertEquals(num + 1, num2);
			userTaskRecordService.delete(recId, "-1");
            int num3 = userTaskRecordService.count(param);
            assertEquals(num, num3);
	}

    @Test
	public void testList() {
		UserTaskRecord param = new UserTaskRecord();
        PageInfo pageInfo = new PageInfo();
        pageInfo.setPerPageNum(1000000);
        pageInfo.setCurrentPageIndex(1);
        pageInfo.setTotalNum(100000);
		List<UserTaskRecord> results = userTaskRecordService.list(param,pageInfo);
		int num = results.size();
        String recId = doCreate();
        List<UserTaskRecord> results2 = userTaskRecordService.list(param,pageInfo);
        int num2 = results2.size();
        assertEquals(num + 1, num2);
	}

    @Test
	public void testCount() {
		    UserTaskRecord param = new UserTaskRecord();
            int num = userTaskRecordService.count(param);
            doCreate();
            int num2 = userTaskRecordService.count(param);
	        assertEquals(num + 1, num2);
    }

}