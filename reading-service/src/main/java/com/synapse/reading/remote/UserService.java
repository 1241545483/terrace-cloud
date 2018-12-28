package com.synapse.reading.remote;

import com.synapse.user.model.UserInfo;
import io.swagger.client.model.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

/**
 * 根据userList查询用户信息
 * Created by wangyifan on 18-4-14.
 */
@FeignClient(name = "${welcome.url}")
public interface UserService {

    @RequestMapping(value = "/api/v1/selectByUserIdList", method = RequestMethod.GET
            , produces = "application/json;charset=UTF-8", consumes = "application/json;charset=UTF-8")
    ArrayList<UserInfo> selectByUserIdList(@RequestParam("userIdListStr") String userIdListStr);
}
