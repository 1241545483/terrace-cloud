package com.synapse.reading.service.auth;

import com.synapse.common.constants.PageInfo;
import com.synapse.reading.model.auth.Organization;
import com.synapse.reading.constants.auth.OrganizationConstants;
import com.synapse.reading.service.auth.OrganizationService;
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
 * 组织机构 服务测试类
 * </p>
 *
 * @author liuguangfu
 * @since 2019-05-28
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestConfig.class)
@Transactional
public class OrganizationServiceTest {

    private final String createVal = "A";
    private final String updateVal = "B";

    @MockBean
    private IdService idService;

    @Autowired
    private OrganizationService organizationService;

    @Test
    public void testFind(){
        String recId = doCreate();
	    Organization result = organizationService.find(recId);
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
		Organization result = organizationService.find(recId);
        assertEquals(val,result.getOrgName());
        assertEquals(val,result.getOrgNature());
        assertEquals(val,result.getParentOrgId());
        assertEquals(val,result.getOrgLocation());
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
		    Organization param = new Organization();
            param.setOrgName(createVal);
            param.setStatus(createVal);
            param.setOrgNature(createVal);
            param.setParentOrgId(createVal);
            param.setOrgLocation(createVal);
            param.setCreateId(createVal);
            param.setCreateTime(createVal);
            param.setUpdateId(createVal);
            param.setUpdateTime(createVal);
		    return organizationService.create(param);
    }

    public void doUpdate(String recId){
			Organization param = new Organization();
	        param.setOrgId(recId);
	        param.setOrgName(updateVal);
	        param.setStatus(updateVal);
	        param.setOrgNature(updateVal);
	        param.setParentOrgId(updateVal);
	        param.setOrgLocation(updateVal);
	        param.setCreateId(updateVal);
	        param.setCreateTime(updateVal);
	        param.setUpdateId(updateVal);
	        param.setUpdateTime(updateVal);
            organizationService.update(param);
    }

    @Test
	public void delete(){
		    Organization param = new Organization();
            param.setStatus(OrganizationConstants.STATUS.OK.num());
            int num = organizationService.count(param);
	        String recId = doCreate();
	        int num2 = organizationService.count(param);
	        assertEquals(num + 1, num2);
			organizationService.delete(recId, "-1");
            int num3 = organizationService.count(param);
            assertEquals(num, num3);
	}

    @Test
	public void testList() {
		Organization param = new Organization();
        PageInfo pageInfo = new PageInfo();
        pageInfo.setPerPageNum(1000000);
        pageInfo.setCurrentPageIndex(1);
        pageInfo.setTotalNum(100000);
		List<Organization> results = organizationService.list(param,pageInfo);
		int num = results.size();
        String recId = doCreate();
        List<Organization> results2 = organizationService.list(param,pageInfo);
        int num2 = results2.size();
        assertEquals(num + 1, num2);
	}

    @Test
	public void testCount() {
		    Organization param = new Organization();
            int num = organizationService.count(param);
            doCreate();
            int num2 = organizationService.count(param);
	        assertEquals(num + 1, num2);
    }

}
