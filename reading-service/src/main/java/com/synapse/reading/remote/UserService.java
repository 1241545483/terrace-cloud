package com.synapse.reading.remote;

import com.synapse.common.trans.BizTrans;
import com.synapse.reading.model.RegistEntity;
import com.synapse.user.model.UserInfo;
import io.swagger.client.model.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 根据userList查询用户信息
 * Created by wangyifan on 18-4-14.
 */
@FeignClient(name = "${welcome.url}")
public interface UserService {

    @RequestMapping(value = "/api/v1/selectByUserIdList", method = RequestMethod.GET
            , produces = "application/json;charset=UTF-8", consumes = "application/json;charset=UTF-8")
    ArrayList<UserInfo> selectByUserIdList(@RequestParam("userIdListStr") String userIdListStr);

    @RequestMapping(value = "/user/v1/shilurepetition", method = RequestMethod.GET
            , produces = "application/json;charset=UTF-8", consumes = "application/json;charset=UTF-8")
    boolean userNameIsExist(@RequestParam("loginName")String loginName) ;

    @RequestMapping(value = "/user/v1/shiluregist", method = RequestMethod.GET
            , produces = "application/json;charset=UTF-8", consumes = "application/json;charset=UTF-8")
    BizTrans shiluregist(@RequestParam Map<String,Object> params) ;

    @RequestMapping(value = "/user/v1/user_id", method = RequestMethod.GET
            , produces = "application/json;charset=UTF-8", consumes = "application/json;charset=UTF-8")
    public BizTrans getUserIdByLoginName(@RequestParam("loginName")String loginName);


    @RequestMapping(value ="/api/v1/modifyUserOrg",method = RequestMethod.GET
            , produces = "application/json;charset=UTF-8", consumes = "application/json;charset=UTF-8")
    public Integer modifyUserOrg(@RequestParam("userId")String userId, @RequestParam("org")String org,@RequestParam("username")String username,@RequestParam("oldMobile")String oldMobile,@RequestParam("mobile")String mobile,@RequestParam("oldIdCard")String oldIdCard,@RequestParam("idCard")String idCard) ;

}
