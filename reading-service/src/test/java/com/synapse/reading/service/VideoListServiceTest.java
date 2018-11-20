package com.synapse.reading.service;

import com.synapse.common.constants.PageInfo;
import com.synapse.reading.model.VideoList;
import com.synapse.reading.respository.VideoListRespository;
import com.synapse.reading.dto.param.VideoListParam;
import com.synapse.reading.dto.result.VideoListResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
public class VideoListServiceTest {

    private final String createVal = "test";
    private final String updateVal = "test2";

    @Autowired
    private VideoListService videoListService;

    @Test
    public void testFind(){
        String recId = doCreate();
	    VideoList result = videoListService.find(recId);
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
		VideoList result = videoListService.find(recId);
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
	    String recId = doCreate();
	    assertNotNull(recId);
    }

    public String doCreate(){
		    VideoList param = new VideoList();
            param.setName(createVal);
            param.setUrl(createVal);
            param.setBelongTo(createVal);
            param.setBelongToId(createVal);
            param.setPlayNum(-1L);
            param.setCreateId(createVal);
            param.setCreateTime(createVal);
            param.setUpdateId(createVal);
            param.setUpdateTime(createVal);
		    return videoListService.create(param);
    }

    public void doUpdate(String recId){
			VideoList param = new VideoList();
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
            videoListService.update(param);
    }

    @Test
	public void delete(){
		    VideoList param = new VideoList();
            int num = videoListService.count(param);
	        String recId = doCreate();
	        int num2 = videoListService.count(param);
	        assertEquals(num + 1, num2);
		    videoListService.delete(recId);
            int num3 = videoListService.count(param);
            assertEquals(num, num3);
	}

    @Test
	public void testList() {
		VideoList param = new VideoList();
        PageInfo pageInfo = new PageInfo();
        pageInfo.setPerPageNum(1000000);
        pageInfo.setCurrentPageIndex(1);
        pageInfo.setTotalNum(100000);
		List<VideoList> results = videoListService.list(param,pageInfo);
		int num = results.size();
        String recId = doCreate();
        List<VideoList> results2 = videoListService.list(param,pageInfo);
        int num2 = results2.size();
        assertEquals(num + 1, num2);
	}

    @Test
	public void testCount() {
		    VideoList param = new VideoList();
            int num = videoListService.count(param);
            doCreate();
            int num2 = videoListService.count(param);
	        assertEquals(num + 1, num2);
    }

}