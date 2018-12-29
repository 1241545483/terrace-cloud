package com.synapse.reading.service;

import com.synapse.reading.model.MySignin;

import java.util.Map;
import java.util.HashMap;

/**
 * <p>
 * 我的签到 服务实现类
 * </p>
 *
 * @author liuguangfu
 * @since 2018-12-29
 */
public class MySigninBaseService {

	protected Map<String,Object> prepareParams(MySignin mySigninParam) {
        Map<String,Object> params = new HashMap<>();
        if (mySigninParam.getRecId() != null && !mySigninParam.getRecId().trim().equals("")) {
            params.put("recId", mySigninParam.getRecId());
        }
        if (mySigninParam.getPoint() != null) {
            params.put("point", mySigninParam.getPoint());
        }
        if (mySigninParam.getCreateId() != null && !mySigninParam.getCreateId().trim().equals("")) {
            params.put("createId", mySigninParam.getCreateId());
        }
        if (mySigninParam.getCreateTime() != null && !mySigninParam.getCreateTime().trim().equals("")) {
            params.put("createTime", mySigninParam.getCreateTime());
        }
        return params;
    }

}