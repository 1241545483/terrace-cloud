//package com.synapse.reading.service.service;
//
//import com.synapse.common.codec.EncryptTool;
//import com.synapse.common.sso.model.User;
//import com.synapse.common.trans.BizTrans;
//import com.synapse.common.trans.BizTransUtils;
//import com.synapse.common.trans.Result;
//import com.synapse.common.utils.JsonUtils;
//import com.synapse.reading.respository.respository.BindRespository;
//import com.synapse.reading.respository.respository.UserRoleRespository;
//import org.apache.commons.lang.RandomStringUtils;
//import org.apache.commons.lang.StringUtils;
//import org.eclipse.jetty.security.LoginService;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.data.redis.core.StringRedisTemplate;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//import org.springframework.util.CollectionUtils;
//import org.springframework.web.client.RestTemplate;
//import org.springframework.web.context.request.ServletWebRequest;
//
//import javax.servlet.http.HttpServletRequest;
//import java.io.UnsupportedEncodingException;
//import java.util.*;
//import java.util.concurrent.TimeUnit;
//
///**
// * @Author:zhanyang
// * @DATE: 2018/5/10
// */
//@Service
//@Transactional
//    public class WeixinService {
//
//    @Value("${wx.app.id}")
//    public String APPID;
//
//    @Value("${wx.app.secret}")
//    public String APP_SECRET;
//
//    @Value("${welcome.url}")
//    private String welcomeUrl;
//
//    @Value("${shilu.url}")
//    private String shiluUrl;
//
//    //师路注册
//    private static String SHILU_REGIST = "/user/v1/shiluregist";
//    private static String SHILU_ADD_MEMBER = "/shilu/v2/member/new";
//    private static String SHILUWEXIN_ADD = "/shilu/v2/shiluwx/new";
//
//    @Autowired
//    private RestTemplate restTemplateOut;
//
//    @Autowired
//    private RestTemplate restTemplate;
//
//    @Autowired
//    private StringRedisTemplate redisTemplate;
//
//    @Autowired
//    private LoginService loginService;
//
//    @Autowired
//    private BindRespository connectionRespository;
//    @Autowired
//    private UserDetailService  userDetailService;
//
//    @Autowired
//    private UserRespository userRespository;
//
//    @Autowired
//    private UserRoleRespository userRoleRespository;
//
//    @Autowired
//    private SmsCodeProcessor smsValidateCodeProcessor;
//
//    private static Logger logger = LoggerFactory.getLogger(WeixinService.class);
//
//    /**
//     * getresp
//     *
//     * @param url
//     * @return
//     */
//    public Map<String, String> getRsp(String url) {
//        String result = null;
//        Map<String, String> map = new HashMap<String, String>();
//        String forObject = restTemplateOut.getForObject(url, String.class);
//        try {
//            forObject = new String(forObject.getBytes("ISO-8859-1"), "UTF-8");
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
//        map = JsonUtils.toObject(forObject, Map.class);
//        return map;
//    }
//
//
//    public Connection isBind(String openId) {
//        List<Connection> eduConnections = connectionRespository.selectByOpenId(openId);
//        if (eduConnections != null && eduConnections.size() > 0) {
//            return eduConnections.get(0);
//        }
//        return null;
//    }
//
//    public Connection isBind2(String unionId) {
//        List<Connection> eduConnections = connectionRespository.selectByUnionId(unionId);
//        if (eduConnections != null && eduConnections.size() > 0) {
//            return eduConnections.get(0);
//        }
//        return null;
//    }
//
//
//    /**
//     * 注册由业务层做，这里只做绑定
//     */
//    public boolean bind(String moblie) {
//
//        return true;
//    }
//
//    public Map<String, Object> judge(String code) {
//        //获取accessToken
//        String getAccessTokenUrl = "https://api.weixin.qq.com/sns/oauth2/access_token?appid="
//                + APPID
//                + "&secret="
//                + APP_SECRET
//                + "&code=" +
//                code
//                + "&grant_type=authorization_code";
//        Map<String, String> rsp = getRsp(getAccessTokenUrl);
//
//        if (null != rsp.get("errcode")) {
//            Map<String, Object> map = new HashMap<String, Object>();
//            map.put("code", 40029);
//            map.put("msg", rsp.get("errmsg"));
//            return map;
//        }
//        try {
//            //将accessToken 存下备用
//            redisTemplate.opsForValue().set(rsp.get("unionid"), rsp.get("access_token"), 7200, TimeUnit.SECONDS);
//            redisTemplate.opsForValue().set(rsp.get("openid"), rsp.get("access_token"), 7200, TimeUnit.SECONDS);
//            //针对之前老师路用微信公众号绑定过的问题，在这里用openID去weChatUser表中去查查到了就往eduConnection中插入一条数据就ok
//            Connection connectionByUnionid = isBind2(rsp.get("unionid"));
//            //如果绑定过
//            if (null != connectionByUnionid) {
//                //构建用户角色信息
//                return buildUserDetailByUserId(connectionByUnionid.getUserId());
//            } else {
//                Connection connection = isBind(rsp.get("openid"));
//                if (null != connection) {
//                    //构建用户角色信息
//                    return buildUserDetailByUserId(connection.getUserId());
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            Map<String, Object> map = new HashMap<String, Object>();
//            map.put("code", 40029);
//            map.put("msg", rsp.get("errmsg"));
//            return map;
//        }
//        Map<String, Object> map = new HashMap<String, Object>();
//        map.put("accessToken", rsp.get("access_token"));
//        map.put("openId", rsp.get("openid"));
//        map.put("unionId", rsp.get("unionid"));
//        map.put("code", 200);
//        return map;
//    }
//
//
//    public Map<String, String> judge4MiniApp(Map<String, String> userInfo) {
//        Map<String, String> map = new HashMap<String, String>();
//        try {
//            if (null == userInfo.get("unionid")) {
//                Connection eduConnection2 = isBind((String) userInfo.get("openid"));
//                if (null != eduConnection2) {
//                    map.put("userId", (String) eduConnection2.getUserId());
//                    map.put("code", "200");
//                    return map;
//                }
//                if (!StringUtils.isEmpty(userInfo.get("decryptMobile"))) {
//                    com.synapse.gateway.model.User decryptMobileUser = userRespository.selectByUserName(userInfo.get("decryptMobile"));
//                    if (decryptMobileUser != null) {
//                        map.put("userId", decryptMobileUser.getUserId());
//                        map.put("code", "200");
//                        return map;
//                    }
//                }
//                if (userInfo.get("regWay") != null) {
//                    String userId = regisNew4MiniAppWithMobile(userInfo.get("nickName"), (String) userInfo.get("unionid"), (String) userInfo.get("openid"), userInfo.get("avatarUrl"), userInfo.get("decryptMobile"), userInfo.get("regWay"));
//                    map.put("userId", userId);
//                    map.put("code", "200");
//                    return map;
//                } else {
//                    String userId = regisNew4MiniAppWithMobile(userInfo.get("nickName"), (String) userInfo.get("unionid"), (String) userInfo.get("openid"), userInfo.get("avatarUrl"), userInfo.get("decryptMobile"));
//                    map.put("userId", userId);
//                    map.put("code", "200");
//                    return map;
//                }
//
//            }
//            Connection connection = isBind2(userInfo.get("unionid"));
//            //如果绑定过
//            if (null != connection) {
//                map.put("userId", (String) connection.getUserId());
//                map.put("code", "200");
//                return map;
//            } else {
//                Connection eduConnection2 = isBind((String) userInfo.get("openid"));
//                if (null != eduConnection2) {
//                    //当小程序登陆有unionId;但是没有找到对应的用户；这时使用openID能找到；则将unionId插入进去；补充之前没有unionId 的记录
//                    eduConnection2.setUnionId(userInfo.get("unionid"));
//                    connectionRespository.updateByPrimaryKeySelective(eduConnection2);
//                    map.put("userId", (String) eduConnection2.getUserId());
//                    map.put("code", "200");
//                    return map;
//                }
//                if (!StringUtils.isEmpty(userInfo.get("decryptMobile"))) {
//                    com.synapse.gateway.model.User decryptMobileUser = userRespository.selectByUserName(userInfo.get("decryptMobile"));
//                    if (decryptMobileUser != null) {
//                        map.put("userId", decryptMobileUser.getUserId());
//                        map.put("code", "200");
//                        return map;
//                    }
//                }
//                if (userInfo.get("regWay") != null) {
//                    String userId = regisNew4MiniAppWithMobile(userInfo.get("nickName"), (String) userInfo.get("unionid"), (String) userInfo.get("openid"), userInfo.get("avatarUrl"), userInfo.get("decryptMobile"), userInfo.get("regWay"));
//                    map.put("userId", userId);
//                    map.put("code", "200");
//                    return map;
//                } else {
//                    String userId = regisNew4MiniAppWithMobile(userInfo.get("nickName"), (String) userInfo.get("unionid"), (String) userInfo.get("openid"), userInfo.get("avatarUrl"), userInfo.get("decryptMobile"));
//                    map.put("userId", userId);
//                    map.put("code", "200");
//                    return map;
//                }
//            }
//        } catch (Exception e) {
//            map.put("code", "500");
//            return map;
//        }
//    }
//
//
//    private Map<String, Object> buildUserDetail(String mobile) {
//        com.synapse.gateway.model.User userInfo = userRespository.selectByUserName(mobile);
//        Map<String, Map<String, String>> bizinfo = new HashMap<String, Map<String, String>>();
//        Map<String, Map<String, String>> dataScope = new HashMap<String, Map<String, String>>();
//        Map<String, List<Map<String, String>>> bizRoles = new HashMap<String, List<Map<String, String>>>();
//        List<String> userTags = new ArrayList<String>();
//        User<SimpleGrantedAuthority> user = new User(userInfo.getUserId(), userInfo.getUserName(), userInfo.getLoginPass(), true, userInfo.getOrgId(), userInfo.getRegWay(), bizRoles, "", bizinfo, dataScope, userTags, userInfo.getUserImg());
//        logger.info("用户登录：{}", user);
//        List<UserRole> userRoleBizList = userRoleRespository.listUserBizRoles(user.getRecId());
//        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
//        for (UserRole userRoleBiz : userRoleBizList) {
//            authorities.add(new SimpleGrantedAuthority(userRoleBiz.getRoleId()));
//        }
//        logger.info("获取用户权限：{}", authorities);
//        Map<String, Object> map = new HashMap<String, Object>();
//        map.put("accessToken", null);
//        map.put("userInfo", userInfo);
//        return map;
//    }
//
//    /**
//     * 绑定用户到系统中
//     *
//     * @param
//     * @param idCard
//     * @param smsCode
//     * @param deviceId
//     * @param openId
//     * @param orgId
//     * @return
//     */
//    public Map<String, Object> bind(HttpServletRequest request, String mobile, String idCard, String smsCode, String deviceId, String openId, String orgId, String unionId) {
//        Map<String, Object> result = new HashMap<String, Object>();
//        //校验手机号码是否在系统中已经有对应用户，有则询问用户是否绑定到系统已有用户
//        com.synapse.gateway.model.User  user = userRespository.selectByUserName(mobile);
//        if (null != user) {
//            result.put("code", 406);
//            result.put("existUser", user);
//            result.put("userId", user.getUserId());
//            result.put("orgId", user.getOrgId());
//            result.put("openId", openId);
//            result.put("unionId", unionId);
//            //询问用户是否绑定到系统已有用户
//            return result;
//        }
//        //todo zhanyang 创建一个普通性质的机构 orgId = 33333
//        //将其组织机构设为未知(orgId= 33333)
//        orgId = "0";
//        String memberId = regisNew(mobile, idCard, smsCode, unionId, openId, orgId);
//        Connection eduConnection = new Connection();
//        eduConnection.setUserId(memberId);
//        eduConnection.setPrivide("weixin");
//        eduConnection.setOpenId(openId);
//        eduConnection.setUnionId(unionId);
//       connectionRespository.insert(eduConnection);
//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        System.out.println("jjjjjjjjjjjjjjjjjjjjjjjjjjj" + eduConnection.getUserId());
//        //构建用户认证信息
//        Map<String, Object> map = null;
//        try {
//            map = buildUserDetailByUserId(memberId);
//        } catch (Exception e) {
//            e.printStackTrace();
//            String nickname = redisTemplate.opsForValue().get(memberId);
//            try {
//                map = buildUserDetail(nickname);
//                map.put("code", 200);
//                return map;
//            } catch (Exception e1) {
//                e1.printStackTrace();
//                map = new HashMap<>();
//                map.put("code", 500);
//                map.put("userId", memberId);
//                return map;
//            }
//        }
//        map.put("code", 200);
//        return map;
//    }
//
//    /**
//     * 绑定到已有用户
//     *
//     * @param
//     * @return
//     */
//    public Map<String, Object> bindUserIsExist(String openId, String unionId, String userId, String smsCode, String deviceId, HttpServletRequest request) {
//        Map<String, Object> map = new HashMap<>();
//        //校验手机验证码是否正确 否则注册失败;重新到完善信息页面发送验证码
//        if (smsCode == null) {
//            map.put("code", 400);
//            map.put("msg", "验证码不能为空");
//            return map;
//        } else {
//            try {
//                smsValidateCodeProcessor.validate(new ServletWebRequest(request));
//            } catch (Exception e) {
//                Map<String, Object> errmap = new HashMap<>();
//                errmap.put("code", 400);
//                System.out.println("*******************************" + e.getMessage());
//                System.out.println("*******************************" + e.getLocalizedMessage());
//                errmap.put("msg", e.getMessage());
//                return errmap;
//            }
//        }
//        try {
//            Connection eduConnection = new Connection();
//            eduConnection.setUserId(userId);
//            eduConnection.setPrivide("weixin");
//            eduConnection.setOpenId(openId);
//            eduConnection.setUnionId(unionId);
//           connectionRespository.insert(eduConnection);
//            map = buildUserDetailByUserId(userId);
//            map.put("code", 200);
//            map.put("msg", "绑定成功");
//            return map;
//        } catch (Exception e) {
//            e.printStackTrace();
//            map.put("code", 500);
//            map.put("msg", "绑定失败");
//            return map;
//        }
//
//    }
//
//    public Map<String, Object> buildUserDetailByUserId(String userId) {
//        com.synapse.gateway.model.User userInfo = userRespository.selectByUserId(userId);
//        if (null == userInfo) {
//            userInfo = userRespository.selectByUserName(userId);
//            if (userInfo == null) {
//                String loginName = redisTemplate.opsForValue().get(userId);
//                userInfo = userRespository.selectByUserName(loginName);
//            }
//        }
//
//        if (null == userInfo) {
//            userInfo = userRespository.selectByUserId(userId);
//        }
//
//        User systemUser = loginService.buildBizUser4Login(null, userInfo.getOrgId(), userInfo.getUserId());
//        List<SimpleGrantedAuthority> authorities = userDetailService.authorities(userInfo.getUserId());
//
//        User<SimpleGrantedAuthority> user = new User<>(userInfo.getUserId(), userInfo.getUserName(), userInfo.getLoginPass(), true, authorities);
//        user.setGroupId(userInfo.getOrgId());
//        user.setRegWay(userInfo.getRegWay());
//        user.setBizRoles(systemUser.getBizRoles());
////        user.setUserType(userInfo.getRegRoletype());
//        user.setBizInfo(systemUser.getBizInfo());
//        user.setDataScope(systemUser.getDataScope());
//        user.setUserTags(systemUser.getUserTags());
//        user.setUserImg(userInfo.getUserImg());
////        user.setPersonId(userInfo.getPersonId());
//        logger.info("User = {}", user);
//
//        Map<String, Object> map = new HashMap<String, Object>();
//        map.put("accessToken", null);
//        map.put("userInfo", user);
//        map.put("code", 200);
//        return map;
//    }
//
//
//    /**
//     * 不绑定到已有账户中，新注册一个用户并绑定
//     *
//     * @param param
//     * @return
//     */
//    public Map<String, Object> bindNew(Map<String, String> param) {
//        Map<String, Object> map = new HashMap();
//        try {
//            //此时不能以手机号作为
//            String memberId = regisNew(param.get("mobile"), param.get("idCard"), null, param.get("unionId"), param.get("openId"), param.get("orgId"));
//            System.out.println("********************************************" + memberId);
//            Connection eduConnection = new Connection();
//            eduConnection.setUserId(memberId);
//            eduConnection.setPrivide("weixin");
//            eduConnection.setOpenId(param.get("openId"));
//            eduConnection.setUnionId(param.get("unionId"));
//            connectionRespository.insert(eduConnection);
//            System.out.println("************************************eduConnectionRespository********ok");
//            map = buildUserDetailByUserId(memberId);
//            map.put("code", 200);
//            map.put("msg", "绑定成功");
//        } catch (Exception e) {
//            e.printStackTrace();
//            map.put("code", 500);
//            map.put("msg", "绑定失败");
//            return map;
//        }
//        return map;
//    }
//
//    /**
//     * 不绑定到已有账户中，新注册一个用户并绑定
//     *
//     * @param
//     * @return
//     */
//    public Map<String, Object> bindNewForNew(String nickname, String openId, String unionId, String avatarUrl) {
//        Map<String, Object> map = new HashMap();
//        try {
//            //此时不能以手机号作为
//            String memberId = regisNew4MiniApp(nickname, unionId, openId, avatarUrl);
//            System.out.println("********************************************" + memberId);
//         Connection eduConnection = new Connection();
//            eduConnection.setUserId(memberId);
//            eduConnection.setPrivide("weixin");
//            eduConnection.setOpenId(openId);
//            eduConnection.setUnionId(unionId);
//            connectionRespository.insert(eduConnection);
//            System.out.println("************************************eduConnectionRespository********ok");
//            map = buildUserDetailByUserId(memberId);
//            map.put("code", 200);
//            map.put("msg", "绑定成功");
//        } catch (Exception e) {
//            e.printStackTrace();
//            map.put("code", 500);
//            map.put("msg", "绑定失败");
//            return map;
//        }
//        return map;
//    }
//
//
//    /**
//     * 注册新用户并返回userId
//     *
//     * @param
//     * @param idCard
//     * @param smsCode
//     * @param
//     * @param openId
//     * @param orgId
//     * @return
//     */
//    public String regisNew(String mobile, String idCard, String smsCode, String unionId, String openId, String orgId) {
//
//        //查询微信用户详细信息；
//        //获取用户详细信息
//        String nickname = null;
//        Map<String, String> socialDetailsInfo = null;
//        try {
//            socialDetailsInfo = getSocialDetailsInfo(unionId, openId);
//            if (socialDetailsInfo != null && "200".equals(socialDetailsInfo.get("code"))) {
//                nickname = socialDetailsInfo.get("nickname");
//            } else {
//                nickname = "weixin_" + RandomStringUtils.randomNumeric(9);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            nickname = "weixin_" + RandomStringUtils.randomNumeric(9);
//        }
//        Map<String, Object> registParam = new HashMap<String, Object>();
//        registParam.put("moblie", nickname);
//        registParam.put("idCard", idCard);
//        //默认机构
//        registParam.put("orgId", 0);
//        //此时系统已经有该手机号，所以不能以mobile作为loginName 但是手机号码又不能不存；因为selectByUserNameOrAlais 方法loginName 比loginAlais优先级高所以loginAlais存手机号
//        registParam.put("loginName", nickname);
//        registParam.put("loginPass", "stsl123456");
//        registParam.put("regRoletype", "teacher");
//        //后期以使用openId拿到
//        registParam.put("userName", nickname);
//        registParam.put("loginAlais", nickname);
//        registParam.put("registFlag", 0);
//
//        System.out.println("********************************************" + CommonConstants.SEP_Q_MARK + buildParametersString(registParam));
//        //首先创建一个edu User;
//        BizTrans<List<LinkedHashMap<String, Object>>> bizTrans =
//                (BizTrans<List<LinkedHashMap<String, Object>>>) restTemplate.getForObject(welcomeUrl + SHILU_REGIST + CommonConstants.SEP_Q_MARK + buildParametersString(registParam), BizTrans.class);
//        Object o = BizTransUtils.parseBizTrans(bizTrans);
//        System.out.println("********************************************" + o);
//        String memberId = (String) o;
//        redisTemplate.opsForValue().set(memberId, nickname, 60, TimeUnit.SECONDS);
//        //调用师路接口创建member;
//        Map<String, Object> memberParam = new HashMap<String, Object>();
//        memberParam.put("moblie", mobile);
//        memberParam.put("idCard", idCard);
//        memberParam.put("organization", orgId);
//        memberParam.put("name", nickname);
//        memberParam.put("officeStatus", 1);
//        memberParam.put("userId", memberId);
//        memberParam.put("memberType", 2);
//        memberParam.put("status", 1);
//        memberParam.put("pic", socialDetailsInfo.get("headimgurl"));
//        Result addMemberResult = restTemplate.getForObject(shiluUrl + SHILU_ADD_MEMBER + CommonConstants.SEP_Q_MARK + buildParametersString(memberParam), Result.class);
//        System.out.println("************************************shufangzhuceok********" + o);
////        WechatUserBind wechatUserBind = new WechatUserBind();
////        wechatUserBind.setOpenId(openId);
////        wechatUserBind.setUnionId(unionId);
//////        BCryptPasswordEncoder encode = new BCryptPasswordEncoder();
//////        Map<String,Object> map = new HashMap<>();
//////        wechatUserBind.setEnPwd(encode.encode("123456"));
////        wechatUserBind.setUserId(Long.parseLong(memberId.trim()));
////        wechatUserBind.setLoginName(nickname);
////        wechatUserBindMapper.insertSelective(wechatUserBind);
//        Map<String, Object> shiluWexinParam = new HashMap<String, Object>();
//        shiluWexinParam.put("openId", openId);
//        shiluWexinParam.put("userId", memberId);
//        shiluWexinParam.put("unionId", unionId);
//        restTemplate.getForObject(shiluUrl + SHILUWEXIN_ADD + CommonConstants.SEP_Q_MARK + buildParametersString(shiluWexinParam), Result.class);
//        return memberId;
//    }
//
//
//    public String regisNew4MiniApp(String nickname, String unionId, String openId, String headimgurl) {
//        Map<String, Object> registParam = new HashMap<String, Object>();
//        registParam.put("moblie", nickname);
//        registParam.put("idCard", null);
//        //默认机构
//        registParam.put("orgId", 0);
//        //此时系统已经有该手机号，所以不能以mobile作为loginName 但是手机号码又不能不存；因为selectByUserNameOrAlais 方法loginName 比loginAlais优先级高所以loginAlais存手机号
//        registParam.put("loginName", nickname);
//        registParam.put("loginPass", "stsl123456");
//        registParam.put("regRoletype", "teacher");
//        //后期以使用openId拿到
//        registParam.put("userName", nickname);
//        registParam.put("loginAlais", nickname);
//        registParam.put("registFlag", 0);
//        //首先创建一个edu User;
//        BizTrans<List<LinkedHashMap<String, Object>>> bizTrans =
//                (BizTrans<List<LinkedHashMap<String, Object>>>) restTemplate.getForObject(welcomeUrl + SHILU_REGIST + CommonConstants.SEP_Q_MARK + buildParametersString(registParam), BizTrans.class);
//        Object o = BizTransUtils.parseBizTrans(bizTrans);
//        String memberId = (String) o;
//        redisTemplate.opsForValue().set(memberId, nickname, 60, TimeUnit.SECONDS);
//        //调用师路接口创建member;
//        Map<String, Object> memberParam = new HashMap<String, Object>();
//        memberParam.put("moblie", "-999");
//        memberParam.put("idCard", null);
//        memberParam.put("organization", "-999");
//        memberParam.put("name", nickname);
//        memberParam.put("officeStatus", 1);
//        memberParam.put("userId", memberId);
//        memberParam.put("memberType", 2);
//        memberParam.put("status", 1);
//        memberParam.put("pic", headimgurl);
//        Result addMemberResult = restTemplate.getForObject(shiluUrl + SHILU_ADD_MEMBER + CommonConstants.SEP_Q_MARK + buildParametersString(memberParam), Result.class);
////        WechatUserBind wechatUserBind = new WechatUserBind();
////        wechatUserBind.setOpenId(openId);
////        wechatUserBind.setUnionId(unionId);
////        wechatUserBind.setUserId(Long.parseLong(memberId.trim()));
////        wechatUserBind.setLoginName(nickname);
////        wechatUserBindMapper.insertSelective(wechatUserBind);
//        Map<String, Object> shiluWexinParam = new HashMap<String, Object>();
//        shiluWexinParam.put("openId", openId);
//        shiluWexinParam.put("userId", memberId);
//        shiluWexinParam.put("unionId", unionId);
//        restTemplate.getForObject(shiluUrl + SHILUWEXIN_ADD + CommonConstants.SEP_Q_MARK + buildParametersString(shiluWexinParam), Result.class);
//      Connection eduConnection = new Connection();
//        eduConnection.setUserId(memberId);
//        eduConnection.setPrivide("weixin");
//        eduConnection.setOpenId(openId);
//        eduConnection.setUnionId(unionId);
//        connectionRespository.insert(eduConnection);
//        return memberId;
//    }
//
//
//    public String regisNew4MiniAppWithMobile(String nickname, String unionId, String openId, String headimgurl, String mobile, String regWay) {
//        Map<String, Object> registParam = new HashMap<String, Object>();
//        registParam.put("moblie", mobile == null ? nickname : mobile);
//        registParam.put("idCard", null);
//        //默认机构
//        registParam.put("orgId", 0);
//        //此时系统已经有该手机号，所以不能以mobile作为loginName 但是手机号码又不能不存；因为selectByUserNameOrAlais 方法loginName 比loginAlais优先级高所以loginAlais存手机号
//        registParam.put("loginName", mobile == null ? nickname : mobile);
//        registParam.put("loginPass", mobile == null ? "stsl123456" : mobile.substring(6, 11));
//        registParam.put("regRoletype", "teacher");
//        //后期以使用openId拿到
//        registParam.put("userName", mobile == null ? nickname : mobile);
//        registParam.put("loginAlais", mobile);
//        registParam.put("registFlag", 0);
//        registParam.put("regWay", regWay);
//        //首先创建一个edu User;
//        BizTrans<List<LinkedHashMap<String, Object>>> bizTrans =
//                (BizTrans<List<LinkedHashMap<String, Object>>>) restTemplate.getForObject(welcomeUrl + SHILU_REGIST + CommonConstants.SEP_Q_MARK + buildParametersString(registParam), BizTrans.class);
//        Object o = BizTransUtils.parseBizTrans(bizTrans);
//        String memberId = (String) o;
//        redisTemplate.opsForValue().set(memberId, nickname, 60, TimeUnit.SECONDS);
//        //调用师路接口创建member;
//        Map<String, Object> memberParam = new HashMap<String, Object>();
//        memberParam.put("mobile", mobile == null ? "-999" : mobile);
//        memberParam.put("idCard", null);
//        memberParam.put("organization", "-999");
//        memberParam.put("name", mobile == null ? nickname : mobile);
//        memberParam.put("officeStatus", 1);
//        memberParam.put("userId", memberId);
//        memberParam.put("memberType", 2);
//        memberParam.put("status", 1);
//        memberParam.put("pic", headimgurl);
//        Result addMemberResult = restTemplate.getForObject(shiluUrl + SHILU_ADD_MEMBER + CommonConstants.SEP_Q_MARK + buildParametersString(memberParam), Result.class);
//      //  WechatUserBind wechatUserBind = new WechatUserBind();
////        wechatUserBind.setOpenId(openId);
////        wechatUserBind.setUnionId(unionId);
////        wechatUserBind.setUserId(Long.parseLong(memberId.trim()));
////        wechatUserBind.setLoginName(nickname);
////        wechatUserBindMapper.insertSelective(wechatUserBind);
//        Map<String, Object> shiluWexinParam = new HashMap<String, Object>();
//        shiluWexinParam.put("openId", openId);
//        shiluWexinParam.put("userId", memberId);
//        shiluWexinParam.put("unionId", unionId);
//        restTemplate.getForObject(shiluUrl + SHILUWEXIN_ADD + CommonConstants.SEP_Q_MARK + buildParametersString(shiluWexinParam), Result.class);
//       Connection eduConnection = new Connection();
//        eduConnection.setUserId(memberId);
//        eduConnection.setPrivide("weixin");
//        eduConnection.setOpenId(openId);
//        eduConnection.setUnionId(unionId);
//       connectionRespository.insert(eduConnection);
//        return memberId;
//    }
//
//    public String regisNew4MiniAppWithMobile(String nickname, String unionId, String openId, String headimgurl, String mobile) {
//        Map<String, Object> registParam = new HashMap<String, Object>();
//        registParam.put("moblie", mobile == null ? nickname : mobile);
//        registParam.put("idCard", null);
//        //默认机构
//        registParam.put("orgId", 0);
//        //此时系统已经有该手机号，所以不能以mobile作为loginName 但是手机号码又不能不存；因为selectByUserNameOrAlais 方法loginName 比loginAlais优先级高所以loginAlais存手机号
//        registParam.put("loginName", mobile == null ? nickname : mobile);
//        registParam.put("loginPass", mobile == null ? "stsl123456" : mobile.substring(6, 11));
//        registParam.put("regRoletype", "teacher");
//        //后期以使用openId拿到
//        registParam.put("userName", mobile == null ? nickname : mobile);
//        registParam.put("loginAlais", mobile);
//        registParam.put("registFlag", 0);
//        //首先创建一个edu User;
//        BizTrans<List<LinkedHashMap<String, Object>>> bizTrans =
//                (BizTrans<List<LinkedHashMap<String, Object>>>) restTemplate.getForObject(welcomeUrl + SHILU_REGIST + CommonConstants.SEP_Q_MARK + buildParametersString(registParam), BizTrans.class);
//        Object o = BizTransUtils.parseBizTrans(bizTrans);
//        String memberId = (String) o;
//        redisTemplate.opsForValue().set(memberId, nickname, 60, TimeUnit.SECONDS);
//        //调用师路接口创建member;
//        Map<String, Object> memberParam = new HashMap<String, Object>();
//        memberParam.put("mobile", mobile == null ? "-999" : mobile);
//        memberParam.put("idCard", null);
//        memberParam.put("organization", "-999");
//        memberParam.put("name", mobile == null ? nickname : mobile);
//        memberParam.put("officeStatus", 1);
//        memberParam.put("userId", memberId);
//        memberParam.put("memberType", 2);
//        memberParam.put("status", 1);
//        memberParam.put("pic", headimgurl);
//        Result addMemberResult = restTemplate.getForObject(shiluUrl + SHILU_ADD_MEMBER + CommonConstants.SEP_Q_MARK + buildParametersString(memberParam), Result.class);
////        WechatUserBind wechatUserBind = new WechatUserBind();
////        wechatUserBind.setOpenId(openId);
////        wechatUserBind.setUnionId(unionId);
////        wechatUserBind.setUserId(Long.parseLong(memberId.trim()));
////        wechatUserBind.setLoginName(nickname);
////        wechatUserBindMapper.insertSelective(wechatUserBind);
//        Map<String, Object> shiluWexinParam = new HashMap<String, Object>();
//        shiluWexinParam.put("openId", openId);
//        shiluWexinParam.put("userId", memberId);
//        shiluWexinParam.put("unionId", unionId);
//        restTemplate.getForObject(shiluUrl + SHILUWEXIN_ADD + CommonConstants.SEP_Q_MARK + buildParametersString(shiluWexinParam), Result.class);
//        Connection eduConnection = new Connection();
//        eduConnection.setUserId(memberId);
//        eduConnection.setPrivide("weixin");
//        eduConnection.setOpenId(openId);
//        eduConnection.setUnionId(unionId);
//        connectionRespository.insert(eduConnection);
//        return memberId;
//    }
//
//    public Map<String, String> getSocialDetailsInfo(String unionId, String openId) {
//        Map<String, String> result = new HashMap<>();
//        //查询微信用户详细信息；
//        String access_token = null;
//        if (null != unionId) {
//            access_token = redisTemplate.opsForValue().get(unionId);
//        }
//        System.out.println("***************************************lailw");
//        if (null == access_token) {
//            access_token = redisTemplate.opsForValue().get(openId);
//        }
//        String getUserInfo = "https://api.weixin.qq.com/sns/userinfo?access_token=" +
//                access_token +
//                "&openid=" +
//                openId +
//                "&lang=zh_CN";
//        try {
//            Map<String, String> userInfo = getRsp(getUserInfo);
//            if (userInfo != null && userInfo.get("nickname") != null) {
//                userInfo.put("code", "200");
//                System.out.println("***************************************lailw" + userInfo);
//                return userInfo;
//
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        result.put("code", "500");
//        return result;
//    }
//
//
//    /**
//     * 组织get的参数
//     *
//     * @param params
//     * @return
//     */
//    private String buildParametersString(Map<String, Object> params) {
//        String parameterString = "";
//        if (null == params || params.size() == 0) {
//            return parameterString;
//        }
//        for (String key : params.keySet()) {
//            Object o = params.get(key);
//            if (o == null) {
//                continue;
//            }
//            if (o instanceof String) {
//                parameterString += (CommonConstants.SEP_AND) + (key + CommonConstants.SEP_EQUAL + o.toString());
//            } else if (o instanceof Integer) {
//                parameterString += (CommonConstants.SEP_AND) + (key + CommonConstants.SEP_EQUAL + String.valueOf((Integer) o));
//            } else if (o instanceof Long) {
//                parameterString += (CommonConstants.SEP_AND) + (key + CommonConstants.SEP_EQUAL + String.valueOf((Long) o));
//            }
//
//        }
//        return parameterString.substring(1, parameterString.length());
//    }
//
//    @Value("${encrypt.salt}")
//    private String salt;
//
//    public int miniBind(Map<String, String> param) {
//        String userId = param.get("userId");
//        String existUserId = param.get("existUserId");
//        String decrypt = EncryptTool.decrypt(userId, salt);
//        String decryptExistUserId = EncryptTool.decrypt(existUserId, salt);
//        com.synapse.gateway.model.User user = userRespository.selectByUserId(decryptExistUserId);
//        logger.info(">>>>>>>=----------------user"+user.getUserId());
//        BCryptPasswordEncoder encode = new BCryptPasswordEncoder();
//        if (null == user) {
//            return 3;
//        }
//        if (!encode.matches(param.get("password"), user.getLoginPass())) {
//            return 2;
//        }
//        List<Connection> eduConnectionList = connectionRespository.selectByUserIdAndOpenId(param.get("openId"),decrypt);
//        logger.info(">>>>>>>----------------eduConnectionList"+eduConnectionList.get(0).getOpenId());
//        Connection connection = eduConnectionList.get(0);
//        connection.setUserId(decryptExistUserId);
//        return connectionRespository.updateByPrimaryKeySelective(connection);
//    }
//
//    /**
//     * @param mobile
//     * @param password
//     * @return 1 用户名密码正确；并返回userId; 2:账户或密码错误
//     */
//    //当小程序用户登陆时填了手机号与密码；就直接绑定
//    public Map<String, Object> whenMiniAppLoginBindCheck(String mobile, String password, String unionId) {
//        Map<String, Object> result = new HashMap<>();
//        com.synapse.gateway.model.User user = userRespository.selectByUserName(mobile);
//        BCryptPasswordEncoder encode = new BCryptPasswordEncoder();
//        if (null == user) {
//            result.put("flag", "2");
//            return result;
//        }
//        if (!encode.matches(password, user.getLoginPass())) {
//            result.put("flag", "2");
//            return result;
//        }
//        result.put("flag", "1");
//        result.put("userId", user.getUserId());
//
//        //当前用户是否已经绑定过；
//        List<Connection> eduConnectionList = connectionRespository.selectByUnionId(unionId);
//        if (!CollectionUtils.isEmpty(eduConnectionList)) {
//            //如果有绑定;
//            Connection connection = eduConnectionList.get(0);
//            //看绑定的用户是不是用户输入的账户和密码对应的用户；
//            if (connection.getUserId().equals(user.getUserId())) {
//                //直接走原来的登陆流程
//                result.put("loginFlag", "1");
//                return result;
//            } else {
//                //走新的登陆流程，即绑定用户输入的账户和密码对应的用户并登陆
//                result.put("loginFlag", "2");
//                return result;
//            }
//        }
//        return result;
//    }
//}
