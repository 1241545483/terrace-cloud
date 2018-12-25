package com.synapse.reading.service;

import com.synapse.common.constants.PageInfo;
import com.synapse.reading.model.MediaCounts;
import com.synapse.reading.respository.MediaCountsRespository;
import com.synapse.reading.dto.param.MediaCountsParam;
import com.synapse.reading.dto.result.MediaCountsResult;
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
 * 统计播放量 服务测试类
 * </p>
 *
 * @author liuguangfu
 * @since 2018-12-25
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestConfig.class)
@Transactional
public class MediaCountsServiceTest {

    private final String createVal = "A";
    private final String updateVal = "B";

    @MockBean
    private IdService idService;

    @Autowired
    private MediaCountsService mediaCountsService;

    @Test
    public void testFind(){
        String recId = doCreate();
	    MediaCounts result = mediaCountsService.find(recId);
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
		MediaCounts result = mediaCountsService.find(recId);
        assertEquals(val,result.getMediaId());
        assertEquals(val,result.getMediaType());
        assertEquals(val,result.getClicked());
        assertEquals(val,result.getFinished());
        assertEquals(val,result.getCreateId());
    }

    @Test
    public void create() {
	    String recId = doCreate();
	    assertNotNull(recId);
    }

    public String doCreate(){
            Mockito.when(idService.gen(Mockito.anyString())).thenReturn(System.nanoTime() + "");
		    MediaCounts param = new MediaCounts();
            param.setMediaId(createVal);
            param.setMediaType(createVal);
            param.setClicked(createVal);
            param.setFinished(createVal);
            param.setCreateId(createVal);
            param.setCreateTime(createVal);
		    return mediaCountsService.create(param);
    }

    public void doUpdate(String recId){
			MediaCounts param = new MediaCounts();
	        param.setRecId(recId);
	        param.setMediaId(updateVal);
	        param.setMediaType(updateVal);
	        param.setClicked(updateVal);
	        param.setFinished(updateVal);
	        param.setCreateId(updateVal);
	        param.setCreateTime(updateVal);
            mediaCountsService.update(param);
    }

    @Test
	public void delete(){
		    MediaCounts param = new MediaCounts();
            int num = mediaCountsService.count(param);
	        String recId = doCreate();
	        int num2 = mediaCountsService.count(param);
	        assertEquals(num + 1, num2);
		    mediaCountsService.delete(recId);
            int num3 = mediaCountsService.count(param);
            assertEquals(num, num3);
	}

    @Test
	public void testList() {
		MediaCounts param = new MediaCounts();
        PageInfo pageInfo = new PageInfo();
        pageInfo.setPerPageNum(1000000);
        pageInfo.setCurrentPageIndex(1);
        pageInfo.setTotalNum(100000);
		List<MediaCounts> results = mediaCountsService.list(param,pageInfo);
		int num = results.size();
        String recId = doCreate();
        List<MediaCounts> results2 = mediaCountsService.list(param,pageInfo);
        int num2 = results2.size();
        assertEquals(num + 1, num2);
	}

    @Test
	public void testCount() {
		    MediaCounts param = new MediaCounts();
            int num = mediaCountsService.count(param);
            doCreate();
            int num2 = mediaCountsService.count(param);
	        assertEquals(num + 1, num2);
    }

}