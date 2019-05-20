package com.synapse.reading.remote;

import com.synapse.common.constants.PageInfo;
import com.synapse.common.trans.BizTrans;
import com.synapse.common.trans.Result;
import com.synapse.reading.model.RegistEntity;
import com.synapse.user.model.UserInfo;
import com.synapse.user.model.api.UserPwdUpdateModel;
import com.synapse.welcome.model.OrgModel;
import io.swagger.client.model.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

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


    @RequestMapping(value = "/user/v1/user/findBy/{loginName}", method = RequestMethod.GET)
    public Map<String,String> selectByUserNameOrAlais(@PathVariable("loginName") String loginName);


        @RequestMapping(value = "/user/v1/home/mini/bind",method = RequestMethod.POST, produces = "application/json;charset=UTF-8", consumes = "application/json;charset=UTF-8")
    public Result miniHomeBind(@RequestBody Map<String,String> param);

    @RequestMapping(value ="/user/v1/pwd/update",method = RequestMethod.PUT
            , produces = "application/json;charset=UTF-8", consumes = "application/json;charset=UTF-8")
    public BizTrans updateUserPassword(@RequestBody UserPwdUpdateModel userPwdUpdateModel);


    @RequestMapping(value ="/user/v1/pwd/update",method = RequestMethod.GET
            , produces = "application/json;charset=UTF-8", consumes = "application/json;charset=UTF-8")
    public String resetPwd(@RequestParam("userId")String userId,@RequestParam("resetPwd") String resetPwd);


    @RequestMapping(value ="/org/v1/org/byId",method = RequestMethod.GET)
        public String getOrgNamebyId(@RequestParam("orgId")String orgId) ;

    @RequestMapping(value ="/org/v1/org/{orgId}",method = RequestMethod.GET)
    public String getOrgnization(@PathVariable("orgId")String orgId);

    @RequestMapping(value ="/org/v1/addorg",method = RequestMethod.GET)
    public String addOrg(@RequestParam("pId")String pId,@RequestParam("name") String name, @RequestParam("phase")String phase);

    @RequestMapping(value ="/org/v2/organization",method = RequestMethod.PUT,
    produces = "application/json;charset=UTF-8", consumes = "application/json;charset=UTF-8")
    public Integer update(@RequestBody OrgModel orgModel);

    @RequestMapping(value ="/org/v1/search",method = RequestMethod.GET
    ,produces = "application/json;charset=UTF-8", consumes = "application/json;charset=UTF-8")
    public List<OrgModel> searchGroups(@RequestParam("name")String name,@RequestParam("parentOrgId") String parentOrgId) ;


    @RequestMapping(value="/user/v1/schoolmanager", method = RequestMethod.GET
     ,produces = "application/json;charset=UTF-8", consumes = "application/json;charset=UTF-8")
    public Map<String, Object> listSchoolManager(PageInfo page,@RequestParam("orgId")String orgId);

    @RequestMapping(value="/user/v1/modifyuserinfo/{userId}", method = RequestMethod.PUT
     ,produces = "application/json;charset=UTF-8", consumes = "application/json;charset=UTF-8")
    public int modifyUserInfo(@RequestParam("loginname")String loginname, @RequestParam("passwd")String passwd, @PathVariable("userId") String userId);



}

