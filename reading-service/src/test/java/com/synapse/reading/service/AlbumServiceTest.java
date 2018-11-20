package com.synapse.reading.service;

import com.synapse.common.constants.PageInfo;
import com.synapse.reading.model.Album;
import com.synapse.reading.respository.AlbumRespository;
import com.synapse.reading.dto.param.AlbumParam;
import com.synapse.reading.dto.result.AlbumResult;
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
public class AlbumServiceTest {

    private final String createVal = "test";
    private final String updateVal = "test2";

    @MockBean
    private IdService idService;

    @Autowired
    private AlbumService albumService;

    @Test
    public void testFind(){
        String recId = doCreate();
	    Album result = albumService.find(recId);
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
		Album result = albumService.find(recId);
        assertEquals(val,result.getRecId());
        assertEquals(val,result.getName());
        assertEquals(val,result.getIntro());
        assertEquals(val,result.getType());
        assertEquals(val,result.getCover());
        assertEquals(val,result.getPublishStatus());
        assertEquals(val,result.getStatus());
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
		    Album param = new Album();
            param.setName(createVal);
            param.setIntro(createVal);
            param.setType(createVal);
            param.setCover(createVal);
            param.setPublishStatus(createVal);
            param.setStatus(createVal);
            param.setVisitNum(-1L);
            param.setCreateId(createVal);
            param.setCreateTime(createVal);
            param.setUpdateId(createVal);
            param.setUpdateTime(createVal);
		    return albumService.create(param);
    }

    public void doUpdate(String recId){
			Album param = new Album();
	        param.setRecId(recId);
	        param.setName(updateVal);
	        param.setIntro(updateVal);
	        param.setType(updateVal);
	        param.setCover(updateVal);
	        param.setPublishStatus(updateVal);
	        param.setStatus(updateVal);
	        param.setVisitNum(-2L);
	        param.setCreateId(updateVal);
	        param.setCreateTime(updateVal);
	        param.setUpdateId(updateVal);
	        param.setUpdateTime(updateVal);
            albumService.update(param);
    }

    @Test
	public void delete(){
		    Album param = new Album();
            int num = albumService.count(param);
	        String recId = doCreate();
	        int num2 = albumService.count(param);
	        assertEquals(num + 1, num2);
			albumService.delete(recId, "-1");
            int num3 = albumService.count(param);
            assertEquals(num, num3);
	}

    @Test
	public void testList() {
		Album param = new Album();
        PageInfo pageInfo = new PageInfo();
        pageInfo.setPerPageNum(1000000);
        pageInfo.setCurrentPageIndex(1);
        pageInfo.setTotalNum(100000);
		List<Album> results = albumService.list(param,pageInfo);
		int num = results.size();
        String recId = doCreate();
        List<Album> results2 = albumService.list(param,pageInfo);
        int num2 = results2.size();
        assertEquals(num + 1, num2);
	}

    @Test
	public void testCount() {
		    Album param = new Album();
            int num = albumService.count(param);
            doCreate();
            int num2 = albumService.count(param);
	        assertEquals(num + 1, num2);
    }

}