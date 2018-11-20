package com.synapse.reading.service;

import com.synapse.common.constants.PageInfo;
import com.synapse.reading.model.MediaList;
import com.synapse.reading.respository.MediaListRespository;
import com.synapse.reading.dto.param.MediaListParam;
import com.synapse.reading.dto.result.MediaListResult;
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
 * @author wangyifan
 * @since 2018-11-20
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestConfig.class)
@Transactional
public class MediaListServiceTest {

    private final String createVal = "test";
    private final String updateVal = "test2";

    @MockBean
    private IdService idService;

    @Autowired
    private MediaListService mediaListService;

    @Test
    public void testFind(){
        String recId = doCreate();
	    MediaList result = mediaListService.find(recId);
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
		MediaList result = mediaListService.find(recId);
        assertEquals(val,result.getRecId());
        assertEquals(val,result.getName());
        assertEquals(val,result.getUrl());
        assertEquals(val,result.getBelongTo());
        assertEquals(val,result.getBelongToId());
        assertEquals(val,result.getCreateId());
        assertEquals(val,result.getUpdateId());
    }

    @Test
    public void create() {
        Mockito.when(idService.gen("read")).thenReturn(System.nanoTime() + "");
	    String recId = doCreate();
	    assertNotNull(recId);
    }

    public String doCreate(){
		    MediaList param = new MediaList();
            param.setName(createVal);
            param.setUrl(createVal);
            param.setBelongTo(createVal);
            param.setBelongToId(createVal);
            param.setPlayNum(-1L);
            param.setCreateId(createVal);
            param.setCreateTime(createVal);
            param.setUpdateId(createVal);
            param.setUpdateTime(createVal);
		    return mediaListService.create(param);
    }

    public void doUpdate(String recId){
			MediaList param = new MediaList();
	        param.setRecId(recId);
	        param.setName(updateVal);
	        param.setUrl(updateVal);
	        param.setBelongTo(updateVal);
	        param.setBelongToId(updateVal);
	        param.setPlayNum(-2L);
	        param.setCreateId(updateVal);
	        param.setCreateTime(updateVal);
	        param.setUpdateId(updateVal);
	        param.setUpdateTime(updateVal);
            mediaListService.update(param);
    }

    @Test
	public void delete(){
		    MediaList param = new MediaList();
            int num = mediaListService.count(param);
	        String recId = doCreate();
	        int num2 = mediaListService.count(param);
	        assertEquals(num + 1, num2);
		    mediaListService.delete(recId);
            int num3 = mediaListService.count(param);
            assertEquals(num, num3);
	}

    @Test
	public void testList() {
		MediaList param = new MediaList();
        PageInfo pageInfo = new PageInfo();
        pageInfo.setPerPageNum(1000000);
        pageInfo.setCurrentPageIndex(1);
        pageInfo.setTotalNum(100000);
		List<MediaList> results = mediaListService.list(param,pageInfo);
		int num = results.size();
        String recId = doCreate();
        List<MediaList> results2 = mediaListService.list(param,pageInfo);
        int num2 = results2.size();
        assertEquals(num + 1, num2);
	}

    @Test
	public void testCount() {
		    MediaList param = new MediaList();
            int num = mediaListService.count(param);
            doCreate();
            int num2 = mediaListService.count(param);
	        assertEquals(num + 1, num2);
    }

}