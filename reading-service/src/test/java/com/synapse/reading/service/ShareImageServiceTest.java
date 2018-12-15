package com.synapse.reading.service;

import com.synapse.common.constants.PageInfo;
import com.synapse.reading.model.ShareImage;
import com.synapse.reading.respository.ShareImageRespository;
import com.synapse.reading.dto.param.ShareImageParam;
import com.synapse.reading.dto.result.ShareImageResult;
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
 * 分享图片 服务测试类
 * </p>
 *
 * @author liuguangfu
 * @since 2018-12-14
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestConfig.class)
@Transactional
public class ShareImageServiceTest {

    private final String createVal = "A";
    private final String updateVal = "B";

    @MockBean
    private IdService idService;

    @Autowired
    private ShareImageService shareImageService;

    @Test
    public void testFind(){
        String recId = doCreate();
	    ShareImage result = shareImageService.find(recId);
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
		ShareImage result = shareImageService.find(recId);
        assertEquals(val,result.getUserId());
        assertEquals(val,result.getShareType());
        assertEquals(val,result.getShareId());
        assertEquals(val,result.getUrl());
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
		    ShareImage param = new ShareImage();
            param.setUserId(createVal);
            param.setShareType(createVal);
            param.setShareId(createVal);
            param.setUrl(createVal);
            param.setCreateId(createVal);
            param.setCreateTime(createVal);
            param.setUpdateId(createVal);
            param.setUpdateTime(createVal);
		    return shareImageService.create(param);
    }

    public void doUpdate(String recId){
			ShareImage param = new ShareImage();
	        param.setRecId(recId);
	        param.setUserId(updateVal);
	        param.setShareType(updateVal);
	        param.setShareId(updateVal);
	        param.setUrl(updateVal);
	        param.setCreateId(updateVal);
	        param.setCreateTime(updateVal);
	        param.setUpdateId(updateVal);
	        param.setUpdateTime(updateVal);
            shareImageService.update(param);
    }

    @Test
	public void delete(){
		    ShareImage param = new ShareImage();
            int num = shareImageService.count(param);
	        String recId = doCreate();
	        int num2 = shareImageService.count(param);
	        assertEquals(num + 1, num2);
		    shareImageService.delete(recId);
            int num3 = shareImageService.count(param);
            assertEquals(num, num3);
	}

    @Test
	public void testList() {
		ShareImage param = new ShareImage();
        PageInfo pageInfo = new PageInfo();
        pageInfo.setPerPageNum(1000000);
        pageInfo.setCurrentPageIndex(1);
        pageInfo.setTotalNum(100000);
		List<ShareImage> results = shareImageService.list(param,pageInfo);
		int num = results.size();
        String recId = doCreate();
        List<ShareImage> results2 = shareImageService.list(param,pageInfo);
        int num2 = results2.size();
        assertEquals(num + 1, num2);
	}

    @Test
	public void testCount() {
		    ShareImage param = new ShareImage();
            int num = shareImageService.count(param);
            doCreate();
            int num2 = shareImageService.count(param);
	        assertEquals(num + 1, num2);
    }

}