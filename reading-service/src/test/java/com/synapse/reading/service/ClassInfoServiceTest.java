package com.synapse.reading.service;

import com.synapse.common.constants.PageInfo;
import com.synapse.reading.model.ClassInfo;
import com.synapse.reading.respository.ClassInfoRespository;
import com.synapse.reading.dto.param.ClassInfoParam;
import com.synapse.reading.dto.result.ClassInfoResult;
import com.synapse.reading.constants.ClassInfoConstants;
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
 * @since 2019-05-28
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestConfig.class)
@Transactional
public class ClassInfoServiceTest {

    private final String createVal = "A";
    private final String updateVal = "B";

    @MockBean
    private IdService idService;

    @Autowired
    private ClassInfoService classInfoService;

    @Test
    public void testFind(){
        String recId = doCreate();
	    ClassInfo result = classInfoService.find(recId);
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
		ClassInfo result = classInfoService.find(recId);
        assertEquals(val,result.getClassCode());
        assertEquals(val,result.getIntro());
        assertEquals(val,result.getQrCode());
        assertEquals(val,result.getCover());
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
		    ClassInfo param = new ClassInfo();
            param.setClassCode(createVal);
            param.setIntro(createVal);
            param.setQrCode(createVal);
            param.setCover(createVal);
            param.setStatus(createVal);
            param.setCreateId(createVal);
            param.setCreateTime(createVal);
            param.setUpdateId(createVal);
            param.setUpdateTime(createVal);
		    return classInfoService.create(param);
    }

    public void doUpdate(String recId){
			ClassInfo param = new ClassInfo();
	        param.setRecId(recId);
	        param.setClassCode(updateVal);
	        param.setIntro(updateVal);
	        param.setQrCode(updateVal);
	        param.setCover(updateVal);
	        param.setStatus(updateVal);
	        param.setCreateId(updateVal);
	        param.setCreateTime(updateVal);
	        param.setUpdateId(updateVal);
	        param.setUpdateTime(updateVal);
            classInfoService.update(param);
    }

    @Test
	public void delete(){
		    ClassInfo param = new ClassInfo();
            param.setStatus(ClassInfoConstants.STATUS.OK.num());
            int num = classInfoService.count(param);
	        String recId = doCreate();
	        int num2 = classInfoService.count(param);
	        assertEquals(num + 1, num2);
			classInfoService.delete(recId, "-1");
            int num3 = classInfoService.count(param);
            assertEquals(num, num3);
	}

    @Test
	public void testList() {
		ClassInfo param = new ClassInfo();
        PageInfo pageInfo = new PageInfo();
        pageInfo.setPerPageNum(1000000);
        pageInfo.setCurrentPageIndex(1);
        pageInfo.setTotalNum(100000);
		List<ClassInfo> results = classInfoService.list(param,pageInfo);
		int num = results.size();
        String recId = doCreate();
        List<ClassInfo> results2 = classInfoService.list(param,pageInfo);
        int num2 = results2.size();
        assertEquals(num + 1, num2);
	}

    @Test
	public void testCount() {
		    ClassInfo param = new ClassInfo();
            int num = classInfoService.count(param);
            doCreate();
            int num2 = classInfoService.count(param);
	        assertEquals(num + 1, num2);
    }

}