package com.synapse.reading.service;

import com.synapse.common.constants.PageInfo;
import com.synapse.common.sso.model.User;
import com.synapse.reading.model.Member;
import com.synapse.reading.model.MySignin;
import com.synapse.reading.respository.MemberRespository;
import com.synapse.reading.dto.param.MemberParam;
import com.synapse.reading.dto.result.MemberResult;
import com.synapse.common.utils.DateUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.synapse.reading.remote.IdService;

import java.util.List;
import java.util.Map;
import java.util.HashMap;


/**
 * <p>
 * 用户信息 服务实现类
 * </p>
 *
 * @author liuguangfu
 * @since 2018-12-06
 */
@Service
@Transactional
public class MemberService extends MemberBaseService {

    @Autowired
    private IdService idService;

    @Autowired
    private MemberRespository memberRespository;

    @Autowired
    private MySigninService mySigninService;

    public Member find(String recId) {
        return memberRespository.selectByPrimaryKey(recId);
    }

    public Integer update(Member param) {
        String now = DateUtils.getNowStr(DateUtils.FORMAT_DATE_TIME);
        param.setUpdateTime(now);
        return memberRespository.updateByPrimaryKeySelective(param);
    }

    public boolean addPoint(User user, Integer point) {
        MySignin mySignin = new MySignin();
        mySignin.setCreateId(user.getRecId());
        mySignin.setPoint(point);
        mySigninService.create(mySignin);
        String now = DateUtils.getNowStr(DateUtils.FORMAT_DATE_TIME);
        Member param = memberRespository.selectByPrimaryKey(user.getRecId());
        if (param == null) {
            param = new Member();
            param.setUserId(user.getRecId());
            param.setCreateId(user.getRecId());
            param.setCreateTime(now);
//            param.setUpdateTime(now);
//            param.setUpdateId(param.getCreateId());
//            param.setPoint(0);
            param.setPoint(point);
            memberRespository.insert(param);
            return true;
        } else {
            param.setUpdateId(user.getRecId());
            param.setUpdateTime(now);
            param.setUpdateId(user.getRecId());
            param.setPoint(point);
            param.setUserId(user.getRecId());
            return memberRespository.addPoint(param) > 0;
        }
    }


    public String create(Member param) {
        String now = DateUtils.getNowStr(DateUtils.FORMAT_DATE_TIME);
        param.setUserId(idService.gen("ID"));
        param.setCreateTime(now);
        param.setUpdateTime(now);
        memberRespository.insert(param);
        return param.getUserId();
    }

    public String createByUserId(Member param,User user) {
        if (memberRespository.selectByPrimaryKey(user.getRecId())!=null){
            return user.getRecId();
        }
        String now = DateUtils.getNowStr(DateUtils.FORMAT_DATE_TIME);
        param.setUserId(user.getRecId());
        param.setPoint(0);
        param.setCreateTime(now);
        param.setUpdateTime(now);
        memberRespository.insert(param);
        return param.getUserId();
    }


    public Integer delete(String recId) {
        return memberRespository.deleteByPrimaryKey(recId);
    }

    public List<Member> list(Member memberParam, PageInfo pageInfo) {
        Map<String, Object> params = prepareParams(memberParam);
        params.put("startIndex", pageInfo.getCurrentStartIndex());
        params.put("pageSize", pageInfo.getPerPageNum());
        return memberRespository.list(params);
    }

    public Integer count(Member memberParam) {
        Map<String, Object> params = prepareParams(memberParam);
        return memberRespository.count(params);
    }

}