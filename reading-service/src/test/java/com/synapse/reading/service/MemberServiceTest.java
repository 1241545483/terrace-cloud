package com.synapse.reading.service;

import com.synapse.common.constants.PageInfo;
import com.synapse.reading.model.Member;
import com.synapse.reading.respository.MemberRespository;
import com.synapse.reading.dto.param.MemberParam;
import com.synapse.reading.dto.result.MemberResult;
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
 * 用户信息 服务测试类
 * </p>
 *
 * @author liuguangfu
 * @since 2018-12-06
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestConfig.class)
@Transactional
public class MemberServiceTest {

    private final String createVal = "A";
    private final String updateVal = "B";

    @MockBean
    private IdService idService;

    @Autowired
    private MemberService memberService;

    @Test
    public void testFind(){
        String recId = doCreate();
	    Member result = memberService.find(recId);
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
		Member result = memberService.find(recId);
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
		    Member param = new Member();
            param.setPoint(-1);
            param.setCreateId(createVal);
            param.setCreateTime(createVal);
            param.setUpdateId(createVal);
            param.setUpdateTime(createVal);
		    return memberService.create(param);
    }

    public void doUpdate(String recId){
			Member param = new Member();
	        param.setUserId(recId);
	        param.setPoint(-2);
	        param.setCreateId(updateVal);
	        param.setCreateTime(updateVal);
	        param.setUpdateId(updateVal);
	        param.setUpdateTime(updateVal);
            memberService.update(param);
    }

    @Test
	public void delete(){
		    Member param = new Member();
            int num = memberService.count(param);
	        String recId = doCreate();
	        int num2 = memberService.count(param);
	        assertEquals(num + 1, num2);
		    memberService.delete(recId);
            int num3 = memberService.count(param);
            assertEquals(num, num3);
	}

    @Test
	public void testList() {
		Member param = new Member();
        PageInfo pageInfo = new PageInfo();
        pageInfo.setPerPageNum(1000000);
        pageInfo.setCurrentPageIndex(1);
        pageInfo.setTotalNum(100000);
		List<Member> results = memberService.list(param,pageInfo);
		int num = results.size();
        String recId = doCreate();
        List<Member> results2 = memberService.list(param,pageInfo);
        int num2 = results2.size();
        assertEquals(num + 1, num2);
	}

    @Test
	public void testCount() {
		    Member param = new Member();
            int num = memberService.count(param);
            doCreate();
            int num2 = memberService.count(param);
	        assertEquals(num + 1, num2);
    }

}