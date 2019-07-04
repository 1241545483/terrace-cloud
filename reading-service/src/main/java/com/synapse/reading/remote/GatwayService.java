package com.synapse.reading.remote;

import com.synapse.common.sso.model.User;
import com.synapse.common.trans.Result;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * 绑定用户信息
 * Created by wangyifan on 18-4-14.
 */
@FeignClient(name = "${gateway.url}")
public interface GatwayService {

    @RequestMapping(value = "/user/v1/regist/server", method = RequestMethod.POST
            , produces = "application/json;charset=UTF-8", consumes = "application/json;charset=UTF-8")
    public String create(@RequestBody User user);


    @RequestMapping(value = "/user/v1/userInfo/userName/{userName}", method = RequestMethod.GET)
    public String findByUserName(@PathVariable("userName") String userName);


    @RequestMapping(value = "/user/v1/userInfo/user/{userId}", method = RequestMethod.GET)
    public User findByUserId(@PathVariable("userId") String userId);

}

