package com.synapse.reading.service.service;

import com.synapse.common.constants.PageInfo;
import com.synapse.reading.model.model.Model;
import com.synapse.reading.constants.constants.ModelConstants;
import com.synapse.reading.service.service.ModelService;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.transaction.annotation.Transactional;
import com.synapse.reading.remote.IdService;

import com.synapse.reading.TestConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * <p>
 * 系统模块 服务测试类
 * </p>
 *
 * @author liuguangfu
 * @since 2019-05-28
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestConfig.class)
@Transactional
public class ModelServiceTest {

    private final String createVal = "A";
    private final String updateVal = "B";

    @MockBean
    private IdService idService;

    @Autowired
    private ModelService modelService;

    @Test
    public void testFind(){
        String recId = doCreate();
	    Model result = modelService.find(recId);
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
		Model result = modelService.find(recId);
        assertEquals(val,result.getMenuId());
        assertEquals(val,result.getOperateDesc());
        assertEquals(val,result.getName());
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
		    Model param = new Model();
            param.setMenuId(createVal);
            param.setOperateDesc(createVal);
            param.setName(createVal);
            param.setStatus(createVal);
            param.setCreateId(createVal);
            param.setCreateTime(createVal);
            param.setUpdateId(createVal);
            param.setUpdateTime(createVal);
		    return modelService.create(param);
    }

    public void doUpdate(String recId){
			Model param = new Model();
	        param.setRecId(recId);
	        param.setMenuId(updateVal);
	        param.setOperateDesc(updateVal);
	        param.setName(updateVal);
	        param.setStatus(updateVal);
	        param.setCreateId(updateVal);
	        param.setCreateTime(updateVal);
	        param.setUpdateId(updateVal);
	        param.setUpdateTime(updateVal);
            modelService.update(param);
    }

    @Test
	public void delete(){
		    Model param = new Model();
            param.setStatus(ModelConstants.STATUS.OK.num());
            int num = modelService.count(param);
	        String recId = doCreate();
	        int num2 = modelService.count(param);
	        assertEquals(num + 1, num2);
			modelService.delete(recId, "-1");
            int num3 = modelService.count(param);
            assertEquals(num, num3);
	}

    @Test
	public void testList() {
		Model param = new Model();
        PageInfo pageInfo = new PageInfo();
        pageInfo.setPerPageNum(1000000);
        pageInfo.setCurrentPageIndex(1);
        pageInfo.setTotalNum(100000);
		List<Model> results = modelService.list(param,pageInfo);
		int num = results.size();
        String recId = doCreate();
        List<Model> results2 = modelService.list(param,pageInfo);
        int num2 = results2.size();
        assertEquals(num + 1, num2);
	}

    @Test
	public void testCount() {
		    Model param = new Model();
            int num = modelService.count(param);
            doCreate();
            int num2 = modelService.count(param);
	        assertEquals(num + 1, num2);
    }

}