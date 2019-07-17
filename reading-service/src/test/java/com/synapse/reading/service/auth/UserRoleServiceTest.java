package com.synapse.reading.service.auth;

import com.synapse.common.constants.PageInfo;
import com.synapse.reading.model.auth.UserRole;
import com.synapse.reading.service.auth.UserRoleService;
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
 * 阅读这边目前就只有老师，学生 服务测试类
 * </p>
 *
 * @author liuguangfu
 * @since 2019-05-30
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestConfig.class)
@Transactional
public class UserRoleServiceTest {

    private final String createVal = "A";
    private final String updateVal = "B";

    @MockBean
    private IdService idService;

    @Autowired
    private UserRoleService userRoleService;

    @Test
    public void testFind(){
        String recId = doCreate();
	    UserRole result = userRoleService.find(recId);
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
		UserRole result = userRoleService.find(recId);
        assertEquals(val,result.getUserId());
        assertEquals(val,result.getRoleId());
        assertEquals(val,result.getAppKey());
        assertEquals(val,result.getOrgId());
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
		    UserRole param = new UserRole();
            param.setUserId(createVal);
            param.setRoleId(createVal);
            param.setAppKey(createVal);
            param.setOrgId(createVal);
            param.setCreateId(createVal);
            param.setCreateTime(createVal);
            param.setUpdateId(createVal);
            param.setUpdateTime(createVal);
		    return userRoleService.create(param);
    }

    public void doUpdate(String recId){
			UserRole param = new UserRole();
	        param.setRecId(recId);
	        param.setUserId(updateVal);
	        param.setRoleId(updateVal);
	        param.setAppKey(updateVal);
	        param.setOrgId(updateVal);
	        param.setCreateId(updateVal);
	        param.setCreateTime(updateVal);
	        param.setUpdateId(updateVal);
	        param.setUpdateTime(updateVal);
            userRoleService.update(param);
    }

    @Test
	public void delete(){
		    UserRole param = new UserRole();
            int num = userRoleService.count(param);
	        String recId = doCreate();
	        int num2 = userRoleService.count(param);
	        assertEquals(num + 1, num2);
		    userRoleService.delete(recId);
            int num3 = userRoleService.count(param);
            assertEquals(num, num3);
	}

    @Test
	public void testList() {
		UserRole param = new UserRole();
        PageInfo pageInfo = new PageInfo();
        pageInfo.setPerPageNum(1000000);
        pageInfo.setCurrentPageIndex(1);
        pageInfo.setTotalNum(100000);
		List<UserRole> results = userRoleService.list(param,pageInfo);
		int num = results.size();
        String recId = doCreate();
        List<UserRole> results2 = userRoleService.list(param,pageInfo);
        int num2 = results2.size();
        assertEquals(num + 1, num2);
	}

    @Test
	public void testCount() {
		    UserRole param = new UserRole();
            int num = userRoleService.count(param);
            doCreate();
            int num2 = userRoleService.count(param);
	        assertEquals(num + 1, num2);
    }

}
