package com.synapse.reading.service;

import com.synapse.common.constants.PageInfo;
import com.synapse.reading.model.Section;
import com.synapse.reading.respository.SectionRespository;
import com.synapse.reading.dto.param.SectionParam;
import com.synapse.reading.dto.result.SectionResult;
import com.synapse.reading.constants.SectionConstants;
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
 * 章节 服务测试类
 * </p>
 *
 * @author liuguangfu
 * @since 2019-02-15
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestConfig.class)
@Transactional
public class SectionServiceTest {

    private final String createVal = "A";
    private final String updateVal = "B";

    @MockBean
    private IdService idService;

    @Autowired
    private SectionService sectionService;

    @Test
    public void testFind(){
        String recId = doCreate();
	    Section result = sectionService.find(recId);
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
		Section result = sectionService.find(recId);
        assertEquals(val,result.getName());
        assertEquals(val,result.getIntro());
        assertEquals(val,result.getLessionId());
        assertEquals(val,result.getImage());
        assertEquals(val,result.getBanner());
        assertEquals(val,result.getPublishStatus());
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
		    Section param = new Section();
            param.setName(createVal);
            param.setIntro(createVal);
            param.setLessionId(createVal);
            param.setImage(createVal);
            param.setBanner(createVal);
            param.setPublishStatus(createVal);
            param.setStatus(createVal);
            param.setOrderNum(-1);
            param.setVisitNum(-1L);
            param.setCreateId(createVal);
            param.setCreateTime(createVal);
            param.setUpdateId(createVal);
            param.setUpdateTime(createVal);
		    return sectionService.create(param);
    }

    public void doUpdate(String recId){
			Section param = new Section();
	        param.setRecId(recId);
	        param.setName(updateVal);
	        param.setIntro(updateVal);
	        param.setLessionId(updateVal);
	        param.setImage(updateVal);
	        param.setBanner(updateVal);
	        param.setPublishStatus(updateVal);
	        param.setStatus(updateVal);
	        param.setOrderNum(-2);
	        param.setVisitNum(-2L);
	        param.setCreateId(updateVal);
	        param.setCreateTime(updateVal);
	        param.setUpdateId(updateVal);
	        param.setUpdateTime(updateVal);
            sectionService.update(param);
    }

    @Test
	public void delete(){
		    Section param = new Section();
            param.setStatus(SectionConstants.STATUS.OK.num());
            int num = sectionService.count(param);
	        String recId = doCreate();
	        int num2 = sectionService.count(param);
	        assertEquals(num + 1, num2);
			sectionService.delete(recId, "-1");
            int num3 = sectionService.count(param);
            assertEquals(num, num3);
	}

    @Test
	public void testList() {
		Section param = new Section();
        PageInfo pageInfo = new PageInfo();
        pageInfo.setPerPageNum(1000000);
        pageInfo.setCurrentPageIndex(1);
        pageInfo.setTotalNum(100000);
		List<Section> results = sectionService.list(param,pageInfo);
		int num = results.size();
        String recId = doCreate();
        List<Section> results2 = sectionService.list(param,pageInfo);
        int num2 = results2.size();
        assertEquals(num + 1, num2);
	}

    @Test
	public void testCount() {
		    Section param = new Section();
            int num = sectionService.count(param);
            doCreate();
            int num2 = sectionService.count(param);
	        assertEquals(num + 1, num2);
    }

}