package com.synapse.reading.remote;

import com.synapse.common.trans.BizTrans;
import com.synapse.common.trans.Result;
import com.synapse.user.model.UserInfo;
import com.synapse.user.model.api.UserPwdUpdateModel;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Map;

/**
 * 绑定用户信息
 * Created by wangyifan on 18-4-14.
 */
@FeignClient(name = "${gateway.url}")
public interface BindService {

    @RequestMapping(value = "/wx/mini/bind", method = RequestMethod.POST
            , produces = "application/json;charset=UTF-8", consumes = "application/json;charset=UTF-8")
    public Result miniBind(@RequestBody Map<String,String> param);


}

