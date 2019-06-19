package com.synapse.reading.service;

import com.synapse.common.constants.PageInfo;
import com.synapse.reading.model.ApplyForTeacher;
import com.synapse.reading.respository.ApplyForTeacherRespository;
import com.synapse.reading.dto.param.ApplyForTeacherParam;
import com.synapse.reading.dto.result.ApplyForTeacherResult;
import com.synapse.reading.constants.ApplyForTeacherConstants;
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
 * 申请成为老师 服务测试类
 * </p>
 *
 * @author liuguangfu
 * @since 2019-06-19
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestConfig.class)
@Transactional
public class ApplyForTeacherServiceTest {

    private final String createVal = "A";
    private final String updateVal = "B";

    @MockBean
    private IdService idService;

    @Autowired
    private ApplyForTeacherService applyForTeacherService;

    @Test
    public void testFind(){
        String recId = doCreate();
	    ApplyForTeacher result = applyForTeacherService.find(recId);
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
		ApplyForTeacher result = applyForTeacherService.find(recId);
        assertEquals(val,result.getName());
        assertEquals(val,result.getUserId());
        assertEquals(val,result.getReason());
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
		    ApplyForTeacher param = new ApplyForTeacher();
            param.setName(createVal);
            param.setUserId(createVal);
            param.setReason(createVal);
            param.setStatus(createVal);
            param.setCreateId(createVal);
            param.setCreateTime(createVal);
            param.setUpdateId(createVal);
            param.setUpdateTime(createVal);
		    return applyForTeacherService.create(param);
    }

    public void doUpdate(String recId){
			ApplyForTeacher param = new ApplyForTeacher();
	        param.setRecId(recId);
	        param.setName(updateVal);
	        param.setUserId(updateVal);
	        param.setReason(updateVal);
	        param.setStatus(updateVal);
	        param.setCreateId(updateVal);
	        param.setCreateTime(updateVal);
	        param.setUpdateId(updateVal);
	        param.setUpdateTime(updateVal);
            applyForTeacherService.update(param);
    }

    @Test
	public void delete(){
		    ApplyForTeacher param = new ApplyForTeacher();
            param.setStatus(ApplyForTeacherConstants.STATUS.OK.num());
            int num = applyForTeacherService.count(param);
	        String recId = doCreate();
	        int num2 = applyForTeacherService.count(param);
	        assertEquals(num + 1, num2);
			applyForTeacherService.delete(recId, "-1");
            int num3 = applyForTeacherService.count(param);
            assertEquals(num, num3);
	}

    @Test
	public void testList() {
		ApplyForTeacher param = new ApplyForTeacher();
        PageInfo pageInfo = new PageInfo();
        pageInfo.setPerPageNum(1000000);
        pageInfo.setCurrentPageIndex(1);
        pageInfo.setTotalNum(100000);
		List<ApplyForTeacher> results = applyForTeacherService.list(param,pageInfo);
		int num = results.size();
        String recId = doCreate();
        List<ApplyForTeacher> results2 = applyForTeacherService.list(param,pageInfo);
        int num2 = results2.size();
        assertEquals(num + 1, num2);
	}

    @Test
	public void testCount() {
		    ApplyForTeacher param = new ApplyForTeacher();
            int num = applyForTeacherService.count(param);
            doCreate();
            int num2 = applyForTeacherService.count(param);
	        assertEquals(num + 1, num2);
    }

}