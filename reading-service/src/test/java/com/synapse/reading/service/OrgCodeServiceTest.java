package com.synapse.reading.service;

import com.synapse.common.constants.PageInfo;
import com.synapse.reading.model.OrgCode;
import com.synapse.reading.respository.OrgCodeRespository;
import com.synapse.reading.dto.param.OrgCodeParam;
import com.synapse.reading.dto.result.OrgCodeResult;
import com.synapse.reading.constants.OrgCodeConstants;
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
 * @since 2019-07-08
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestConfig.class)
@Transactional
public class OrgCodeServiceTest {

    private final String createVal = "A";
    private final String updateVal = "B";

    @MockBean
    private IdService idService;

    @Autowired
    private OrgCodeService orgCodeService;

    @Test
    public void testFind(){
        String recId = doCreate();
	    OrgCode result = orgCodeService.find(recId);
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
		OrgCode result = orgCodeService.find(recId);
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
		    OrgCode param = new OrgCode();
            param.setStatus(createVal);
            param.setCreateId(createVal);
            param.setCreateTime(createVal);
            param.setUpdateId(createVal);
            param.setUpdateTime(createVal);
		    return orgCodeService.create(param);
    }

    public void doUpdate(String recId){
			OrgCode param = new OrgCode();
	        param.setOrgCode(Integer.parseInt(recId));
	        param.setStatus(updateVal);
	        param.setCreateId(updateVal);
	        param.setCreateTime(updateVal);
	        param.setUpdateId(updateVal);
	        param.setUpdateTime(updateVal);
            orgCodeService.update(param);
    }

    @Test
	public void delete(){
		    OrgCode param = new OrgCode();
            param.setStatus(OrgCodeConstants.STATUS.OK.num());
            int num = orgCodeService.count(param);
	        String recId = doCreate();
	        int num2 = orgCodeService.count(param);
	        assertEquals(num + 1, num2);
			orgCodeService.delete(recId, "-1");
            int num3 = orgCodeService.count(param);
            assertEquals(num, num3);
	}

    @Test
	public void testList() {
		OrgCode param = new OrgCode();
        PageInfo pageInfo = new PageInfo();
        pageInfo.setPerPageNum(1000000);
        pageInfo.setCurrentPageIndex(1);
        pageInfo.setTotalNum(100000);
		List<OrgCode> results = orgCodeService.list(param,pageInfo);
		int num = results.size();
        String recId = doCreate();
        List<OrgCode> results2 = orgCodeService.list(param,pageInfo);
        int num2 = results2.size();
        assertEquals(num + 1, num2);
	}

    @Test
	public void testCount() {
		    OrgCode param = new OrgCode();
            int num = orgCodeService.count(param);
            doCreate();
            int num2 = orgCodeService.count(param);
	        assertEquals(num + 1, num2);
    }

}