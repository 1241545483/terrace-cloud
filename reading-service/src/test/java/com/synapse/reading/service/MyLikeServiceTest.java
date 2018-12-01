package com.synapse.reading.service;

import com.synapse.common.constants.PageInfo;
import com.synapse.reading.model.MyLike;
import com.synapse.reading.respository.MyLikeRespository;
import com.synapse.reading.dto.param.MyLikeParam;
import com.synapse.reading.dto.result.MyLikeResult;
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
 * 我的点赞 服务测试类
 * </p>
 *
 * @author liuguangfu
 * @since 2018-12-01
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestConfig.class)
@Transactional
public class MyLikeServiceTest {

    private final String createVal = "A";
    private final String updateVal = "B";

    @MockBean
    private IdService idService;

    @Autowired
    private MyLikeService myLikeService;

    @Test
    public void testFind(){
        String recId = doCreate();
	    MyLike result = myLikeService.find(recId);
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
		MyLike result = myLikeService.find(recId);
        assertEquals(val,result.getLikeType());
        assertEquals(val,result.getLikeId());
        assertEquals(val,result.getCreateId());
    }

    @Test
    public void create() {
	    String recId = doCreate();
	    assertNotNull(recId);
    }

    public String doCreate(){
            Mockito.when(idService.gen(Mockito.anyString())).thenReturn(System.nanoTime() + "");
		    MyLike param = new MyLike();
            param.setLikeType(createVal);
            param.setLikeId(createVal);
            param.setCreateId(createVal);
            param.setCreateTime(createVal);
		    return myLikeService.create(param);
    }

    public void doUpdate(String recId){
			MyLike param = new MyLike();
	        param.setRecId(recId);
	        param.setLikeType(updateVal);
	        param.setLikeId(updateVal);
	        param.setCreateId(updateVal);
	        param.setCreateTime(updateVal);
            myLikeService.update(param);
    }

    @Test
	public void delete(){
		    MyLike param = new MyLike();
            int num = myLikeService.count(param);
	        String recId = doCreate();
	        int num2 = myLikeService.count(param);
	        assertEquals(num + 1, num2);
		    myLikeService.delete(recId);
            int num3 = myLikeService.count(param);
            assertEquals(num, num3);
	}

    @Test
	public void testList() {
		MyLike param = new MyLike();
        PageInfo pageInfo = new PageInfo();
        pageInfo.setPerPageNum(1000000);
        pageInfo.setCurrentPageIndex(1);
        pageInfo.setTotalNum(100000);
		List<MyLike> results = myLikeService.list(param,pageInfo);
		int num = results.size();
        String recId = doCreate();
        List<MyLike> results2 = myLikeService.list(param,pageInfo);
        int num2 = results2.size();
        assertEquals(num + 1, num2);
	}

    @Test
	public void testCount() {
		    MyLike param = new MyLike();
            int num = myLikeService.count(param);
            doCreate();
            int num2 = myLikeService.count(param);
	        assertEquals(num + 1, num2);
    }

}