package com.synapse.reading.service;

import com.synapse.common.constants.PageInfo;
import com.synapse.reading.model.ClassStudentMapping;
import com.synapse.reading.respository.ClassStudentMappingRespository;
import com.synapse.reading.dto.param.ClassStudentMappingParam;
import com.synapse.reading.dto.result.ClassStudentMappingResult;
import com.synapse.reading.constants.ClassStudentMappingConstants;
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
 * 班级和学生的关系 服务测试类
 * </p>
 *
 * @author liuguangfu
 * @since 2019-05-28
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestConfig.class)
@Transactional
public class ClassStudentMappingServiceTest {

    private final String createVal = "A";
    private final String updateVal = "B";

    @MockBean
    private IdService idService;

    @Autowired
    private ClassStudentMappingService classStudentMappingService;

    @Test
    public void testFind(){
        String recId = doCreate();
	    ClassStudentMapping result = classStudentMappingService.find(recId);
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
		ClassStudentMapping result = classStudentMappingService.find(recId);
        assertEquals(val,result.getClassId());
        assertEquals(val,result.getStudentId());
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
		    ClassStudentMapping param = new ClassStudentMapping();
            param.setClassId(createVal);
            param.setStudentId(createVal);
            param.setStatus(createVal);
            param.setCreateId(createVal);
            param.setUpdateId(createVal);
            param.setCreateTime(createVal);
            param.setUpdateTime(createVal);
		    return classStudentMappingService.create(param);
    }

    public void doUpdate(String recId){
			ClassStudentMapping param = new ClassStudentMapping();
	        param.setRecId(recId);
	        param.setClassId(updateVal);
	        param.setStudentId(updateVal);
	        param.setStatus(updateVal);
	        param.setCreateId(updateVal);
	        param.setUpdateId(updateVal);
	        param.setCreateTime(updateVal);
	        param.setUpdateTime(updateVal);
            classStudentMappingService.update(param);
    }

    @Test
	public void delete(){
		    ClassStudentMapping param = new ClassStudentMapping();
            param.setStatus(ClassStudentMappingConstants.STATUS.OK.num());
            int num = classStudentMappingService.count(param);
	        String recId = doCreate();
	        int num2 = classStudentMappingService.count(param);
	        assertEquals(num + 1, num2);
			classStudentMappingService.delete(recId, "-1");
            int num3 = classStudentMappingService.count(param);
            assertEquals(num, num3);
	}

    @Test
	public void testList() {
		ClassStudentMapping param = new ClassStudentMapping();
        PageInfo pageInfo = new PageInfo();
        pageInfo.setPerPageNum(1000000);
        pageInfo.setCurrentPageIndex(1);
        pageInfo.setTotalNum(100000);
		List<ClassStudentMapping> results = classStudentMappingService.list(param,pageInfo);
		int num = results.size();
        String recId = doCreate();
        List<ClassStudentMapping> results2 = classStudentMappingService.list(param,pageInfo);
        int num2 = results2.size();
        assertEquals(num + 1, num2);
	}

    @Test
	public void testCount() {
		    ClassStudentMapping param = new ClassStudentMapping();
            int num = classStudentMappingService.count(param);
            doCreate();
            int num2 = classStudentMappingService.count(param);
	        assertEquals(num + 1, num2);
    }

}