package com.synapse.reading.service.service;

import com.synapse.common.constants.PageInfo;
import com.synapse.reading.model.model.ModelOperate;
import com.synapse.reading.constants.constants.ModelOperateConstants;
import com.synapse.reading.service.service.ModelOperateService;
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
 * 系统模块和code的关系 服务测试类
 * </p>
 *
 * @author liuguangfu
 * @since 2019-05-28
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestConfig.class)
@Transactional
public class ModelOperateServiceTest {

    private final String createVal = "A";
    private final String updateVal = "B";

    @MockBean
    private IdService idService;

    @Autowired
    private ModelOperateService modelOperateService;

    @Test
    public void testFind(){
        String recId = doCreate();
	    ModelOperate result = modelOperateService.find(recId);
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
		ModelOperate result = modelOperateService.find(recId);
        assertEquals(val,result.getModelId());
        assertEquals(val,result.getCode());
        assertEquals(val,result.getDesc());
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
		    ModelOperate param = new ModelOperate();
            param.setModelId(createVal);
            param.setCode(createVal);
            param.setDesc(createVal);
            param.setStatus(createVal);
            param.setCreateId(createVal);
            param.setUpdateId(createVal);
            param.setCreateTime(createVal);
            param.setUpdateTime(createVal);
		    return modelOperateService.create(param);
    }

    public void doUpdate(String recId){
			ModelOperate param = new ModelOperate();
	        param.setRecId(recId);
	        param.setModelId(updateVal);
	        param.setCode(updateVal);
	        param.setDesc(updateVal);
	        param.setStatus(updateVal);
	        param.setCreateId(updateVal);
	        param.setUpdateId(updateVal);
	        param.setCreateTime(updateVal);
	        param.setUpdateTime(updateVal);
            modelOperateService.update(param);
    }

    @Test
	public void delete(){
		    ModelOperate param = new ModelOperate();
            param.setStatus(ModelOperateConstants.STATUS.OK.num());
            int num = modelOperateService.count(param);
	        String recId = doCreate();
	        int num2 = modelOperateService.count(param);
	        assertEquals(num + 1, num2);
			modelOperateService.delete(recId, "-1");
            int num3 = modelOperateService.count(param);
            assertEquals(num, num3);
	}

    @Test
	public void testList() {
		ModelOperate param = new ModelOperate();
        PageInfo pageInfo = new PageInfo();
        pageInfo.setPerPageNum(1000000);
        pageInfo.setCurrentPageIndex(1);
        pageInfo.setTotalNum(100000);
		List<ModelOperate> results = modelOperateService.list(param,pageInfo);
		int num = results.size();
        String recId = doCreate();
        List<ModelOperate> results2 = modelOperateService.list(param,pageInfo);
        int num2 = results2.size();
        assertEquals(num + 1, num2);
	}

    @Test
	public void testCount() {
		    ModelOperate param = new ModelOperate();
            int num = modelOperateService.count(param);
            doCreate();
            int num2 = modelOperateService.count(param);
	        assertEquals(num + 1, num2);
    }

}