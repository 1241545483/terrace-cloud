package com.synapse.reading.service.service;

import com.synapse.common.constants.PageInfo;
import com.synapse.reading.model.model.RoleModelMapping;
import com.synapse.reading.constants.constants.RoleModelMappingConstants;
import com.synapse.reading.service.service.RoleModelMappingService;
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
 * 系统模块和角色的关系 服务测试类
 * </p>
 *
 * @author liuguangfu
 * @since 2019-05-28
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestConfig.class)
@Transactional
public class RoleModelMappingServiceTest {

    private final String createVal = "A";
    private final String updateVal = "B";

    @MockBean
    private IdService idService;

    @Autowired
    private RoleModelMappingService roleModelMappingService;

    @Test
    public void testFind(){
        String recId = doCreate();
	    RoleModelMapping result = roleModelMappingService.find(recId);
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
		RoleModelMapping result = roleModelMappingService.find(recId);
        assertEquals(val,result.getModelId());
        assertEquals(val,result.getRoleId());
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
		    RoleModelMapping param = new RoleModelMapping();
            param.setModelId(createVal);
            param.setRoleId(createVal);
            param.setStatus(createVal);
            param.setCreateId(createVal);
            param.setUpdateId(createVal);
            param.setCreateTime(createVal);
            param.setUpdateTime(createVal);
		    return roleModelMappingService.create(param);
    }

    public void doUpdate(String recId){
			RoleModelMapping param = new RoleModelMapping();
	        param.setRecId(recId);
	        param.setModelId(updateVal);
	        param.setRoleId(updateVal);
	        param.setStatus(updateVal);
	        param.setCreateId(updateVal);
	        param.setUpdateId(updateVal);
	        param.setCreateTime(updateVal);
	        param.setUpdateTime(updateVal);
            roleModelMappingService.update(param);
    }

    @Test
	public void delete(){
		    RoleModelMapping param = new RoleModelMapping();
            param.setStatus(RoleModelMappingConstants.STATUS.OK.num());
            int num = roleModelMappingService.count(param);
	        String recId = doCreate();
	        int num2 = roleModelMappingService.count(param);
	        assertEquals(num + 1, num2);
			roleModelMappingService.delete(recId, "-1");
            int num3 = roleModelMappingService.count(param);
            assertEquals(num, num3);
	}

    @Test
	public void testList() {
		RoleModelMapping param = new RoleModelMapping();
        PageInfo pageInfo = new PageInfo();
        pageInfo.setPerPageNum(1000000);
        pageInfo.setCurrentPageIndex(1);
        pageInfo.setTotalNum(100000);
		List<RoleModelMapping> results = roleModelMappingService.list(param,pageInfo);
		int num = results.size();
        String recId = doCreate();
        List<RoleModelMapping> results2 = roleModelMappingService.list(param,pageInfo);
        int num2 = results2.size();
        assertEquals(num + 1, num2);
	}

    @Test
	public void testCount() {
		    RoleModelMapping param = new RoleModelMapping();
            int num = roleModelMappingService.count(param);
            doCreate();
            int num2 = roleModelMappingService.count(param);
	        assertEquals(num + 1, num2);
    }

}