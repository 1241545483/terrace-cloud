package com.synapse.reading.service;

import com.synapse.common.constants.PageInfo;
import com.synapse.reading.model.ClassCode;
import com.synapse.reading.respository.ClassCodeRespository;
import com.synapse.reading.dto.param.ClassCodeParam;
import com.synapse.reading.dto.result.ClassCodeResult;
import com.synapse.reading.constants.ClassCodeConstants;
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
public class ClassCodeServiceTest {

    private final String createVal = "A";
    private final String updateVal = "B";

    @MockBean
    private IdService idService;

    @Autowired
    private ClassCodeService classCodeService;

    @Test
    public void testFind(){
        String recId = doCreate();
	    ClassCode result = classCodeService.find(recId);
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
		ClassCode result = classCodeService.find(recId);
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
		    ClassCode param = new ClassCode();
            param.setStatus(createVal);
            param.setCreateId(createVal);
            param.setCreateTime(createVal);
            param.setUpdateId(createVal);
            param.setUpdateTime(createVal);
		    return classCodeService.create(param);
    }

    public void doUpdate(String recId){
			ClassCode param = new ClassCode();
	        param.setClassCode(Integer.parseInt(recId));
	        param.setStatus(updateVal);
	        param.setCreateId(updateVal);
	        param.setCreateTime(updateVal);
	        param.setUpdateId(updateVal);
	        param.setUpdateTime(updateVal);
            classCodeService.update(param);
    }

    @Test
	public void delete(){
		    ClassCode param = new ClassCode();
            param.setStatus(ClassCodeConstants.STATUS.OK.num());
            int num = classCodeService.count(param);
	        String recId = doCreate();
	        int num2 = classCodeService.count(param);
	        assertEquals(num + 1, num2);
			classCodeService.delete(recId, "-1");
            int num3 = classCodeService.count(param);
            assertEquals(num, num3);
	}

    @Test
	public void testList() {
		ClassCode param = new ClassCode();
        PageInfo pageInfo = new PageInfo();
        pageInfo.setPerPageNum(1000000);
        pageInfo.setCurrentPageIndex(1);
        pageInfo.setTotalNum(100000);
		List<ClassCode> results = classCodeService.list(param,pageInfo);
		int num = results.size();
        String recId = doCreate();
        List<ClassCode> results2 = classCodeService.list(param,pageInfo);
        int num2 = results2.size();
        assertEquals(num + 1, num2);
	}

    @Test
	public void testCount() {
		    ClassCode param = new ClassCode();
            int num = classCodeService.count(param);
            doCreate();
            int num2 = classCodeService.count(param);
	        assertEquals(num + 1, num2);
    }

}