package com.synapse.reading.service;

import com.synapse.common.constants.PageInfo;
import com.synapse.reading.model.Audio;
import com.synapse.reading.respository.AudioRespository;
import com.synapse.reading.dto.param.AudioParam;
import com.synapse.reading.dto.result.AudioResult;
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
 * 音频 服务测试类
 * </p>
 *
 * @author wangyifan
 * @since 2018-11-24
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestConfig.class)
@Transactional
public class AudioServiceTest {

    private final String createVal = "A";
    private final String updateVal = "B";

    @MockBean
    private IdService idService;

    @Autowired
    private AudioService audioService;

    @Test
    public void testFind(){
        String recId = doCreate();
	    Audio result = audioService.find(recId);
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
		Audio result = audioService.find(recId);
        assertEquals(val,result.getName());
        assertEquals(val,result.getUrl());
        assertEquals(val,result.getBelongTo());
        assertEquals(val,result.getBelongToId());
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
		    Audio param = new Audio();
            param.setName(createVal);
            param.setUrl(createVal);
            param.setBelongTo(createVal);
            param.setBelongToId(createVal);
            param.setPlayNum(-1L);
            param.setCreateId(createVal);
            param.setCreateTime(createVal);
            param.setUpdateId(createVal);
            param.setUpdateTime(createVal);
		    return audioService.create(param);
    }

    public void doUpdate(String recId){
			Audio param = new Audio();
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
            audioService.update(param);
    }

    @Test
	public void delete(){
		    Audio param = new Audio();
            int num = audioService.count(param);
	        String recId = doCreate();
	        int num2 = audioService.count(param);
	        assertEquals(num + 1, num2);
		    audioService.delete(recId);
            int num3 = audioService.count(param);
            assertEquals(num, num3);
	}

    @Test
	public void testList() {
		Audio param = new Audio();
        PageInfo pageInfo = new PageInfo();
        pageInfo.setPerPageNum(1000000);
        pageInfo.setCurrentPageIndex(1);
        pageInfo.setTotalNum(100000);
		List<Audio> results = audioService.list(param,pageInfo);
		int num = results.size();
        String recId = doCreate();
        List<Audio> results2 = audioService.list(param,pageInfo);
        int num2 = results2.size();
        assertEquals(num + 1, num2);
	}

    @Test
	public void testCount() {
		    Audio param = new Audio();
            int num = audioService.count(param);
            doCreate();
            int num2 = audioService.count(param);
	        assertEquals(num + 1, num2);
    }

}