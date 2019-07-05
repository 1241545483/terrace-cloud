package com.synapse.reading.controller;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.synapse.common.codec.EncryptTool;
import com.synapse.common.sso.model.User;
import com.synapse.common.trans.Result;
import com.synapse.common.utils.JsonUtils;
import com.synapse.reading.constants.CommonConstants;
import com.synapse.reading.constants.MemberConstants;
import com.synapse.reading.dto.param.RegistParam;
import com.synapse.reading.model.Member;
import com.synapse.reading.model.model.UserRole;
import com.synapse.reading.remote.UserService;
import com.synapse.reading.service.MemberService;
import com.synapse.reading.service.service.BindService;
import com.synapse.reading.service.service.UserRoleService;
import com.synapse.reading.util.AESDecodeUtils;
import com.synapse.reading.web.valid.group.Create;
import io.swagger.annotations.ApiOperation;
import net.logstash.logback.encoder.org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping(value = "/reading")
public class RegistController extends BaseController {

    private static Logger logger = LoggerFactory.getLogger(RegistController.class);
    @Value("${token.encrypt.salt}")
    private String salt;
    @Value("${appid}")
    private String appId;
    @Value("${secret}")
    private String secret;
    @Autowired
    private UserService userService;
    @Autowired
    private MemberService memberService;

    @Autowired
    private BindService bindService;
    @Autowired
    private Gson gson;
    @Autowired
    private StringRedisTemplate redisTemplate;
    @Autowired
    private UserRoleService userRoleService;
    private static Type type = new TypeToken<User>() {
    }.getType();

    @ApiOperation(value = "用户注册，微信端")
    @RequestMapping(value = "/view/v1/membershow/wxregist", method = RequestMethod.POST)
    public Result registByWX(HttpServletRequest request, HttpServletResponse response) {
        try {
            String header = request.getHeader("Authorization");
            String code = request.getParameter("code");
            String userName = request.getParameter("userName");
            String password = request.getParameter("password");
            String encrypData = request.getParameter("encrypData");
            String ivData = request.getParameter("ivData");
            String regWay = request.getParameter("regWay");
            String random = RandomStringUtils.randomNumeric(6);
            String nickName = null;
            Map<String, Object> result = new HashMap<String, Object>();
            if (org.springframework.util.StringUtils.isEmpty(regWay)) {
                nickName = "read" + random;
            } else {
                nickName = request.getParameter("nickName");
            }
            String avatarUrl = null;
            logger.error("------------------------------------appId" + appId);
            logger.error("------------------------------------secret" + secret);
            logger.error("------------------------------------code" + code);
            String url = "https://api.weixin.qq.com/sns/jscode2session?appid=" + appId + "&secret=" + secret + "&js_code=" + code + "&grant_type=authorization_code";
            logger.warn("url--------url-----url" + url);
            Map<String, String> userInfo = getRsp(url);
            logger.info("--------------------------20190628unionid map 1=" + userInfo.get("unionid"));
            logger.info("--------------------------20190628session_key map 1=" + userInfo.get("session_key"));

//            redisTemplate.opsForValue().set(code, userInfo.get("openId"), 72, TimeUnit.HOURS);
            if (org.springframework.util.StringUtils.isEmpty(userInfo.get("unionid"))) {
                String data = null;
                try {
                    data = AESDecodeUtils.decryptPre(encrypData, ivData, userInfo.get("session_key"));
                    Map map = JsonUtils.toObject(data, Map.class);
                    logger.warn("-------------" + JsonUtils.toJson(map));
                    userInfo.put("unionid", (String) map.get("unionId"));
                    logger.info("--------------------------20190628openId map 1=" + (String) map.get("openId"));
                    userInfo.put("openId", (String) map.get("openId"));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            userInfo.put("userName", userName);
            userInfo.put("nickName", nickName);
            userInfo.put("avatarUrl", avatarUrl);
            //todo 20190704 密码暂定为read123 ，后期待修改（增加密码修改功能）
            userInfo.put("password", "read123");
            if (!org.springframework.util.StringUtils.isEmpty(regWay)) {
                userInfo.put("regWay", regWay);
            }
            logger.info("--------------------------20190628openId 1=" + userInfo.get("openId"));
            Map<String, String> judgeMap = bindService.judge4MiniApp(userInfo);
            logger.info("--------------------------judgeMapuserId" + judgeMap.get("userId"));
            //1没有unionId关联的user
            if (judgeMap.get("code").equals("200")) {
                String decryptToken = String.valueOf(System.currentTimeMillis());
                String token = EncryptTool.encrypt(decryptToken, salt);
                String userId = judgeMap.get("userId");
                Member member = memberService.getMember(userId);
                if (member == null) {
                    Member member1 = new Member();
                    member1.setName(userInfo.get("nickName"));
                    member1.setOrganization("-1");
                    member1.setStatus("1");
                    member1.setPoint(0);
                    member1.setUserId(userId);
                    memberService.create(member1);
                    //todo 抽成一个方法，供注册端使用
                    UserRole userRole = new UserRole();
                    userRole.setUserId(userId);
                    userRole.setRoleId(MemberConstants.ROLE.STUDENT.value());
                    //todo appkey直接设置  不知道是否为appId  201906031958
                    userRole.setAppKey(appId);
                    userRole.setCreateId(userId);
                    userRoleService.create(userRole);
                }
                Map<String, Object> memberMap = new HashMap<>();
                User user = new User(userId, userName, "");
                memberMap.put("nickName", userInfo.get("nickName"));
//               memberMap.put("getOrganization",member.getOrganization());
                memberMap.put("avatarUrl", avatarUrl);
                memberMap.put("regWay", regWay);
                memberMap.put("openId", userInfo.get("openid"));
                user.setParams(memberMap);
                user.setUsername(nickName);
                final UserDetails userDetails = user;
                String data = gson.toJson(userDetails, type);
                redisTemplate.opsForValue().set(decryptToken, data, 3000, TimeUnit.HOURS);
                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                        userDetails, null, userDetails.getAuthorities());
                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(
                        request));
                logger.info("authenticated mini user " + userDetails.getUsername() + ", setting security context");
                SecurityContextHolder.getContext().setAuthentication(authentication);
                Map<String, Object> extraParams = new HashMap<String, Object>();
                extraParams.put("token", token);
                extraParams.put("openid", userInfo.get("openid"));
                extraParams.put("unionid", userInfo.get("unionid"));
//                requestParameterWrapper.addParameters(extraParams);
                logger.info("authenticated mini token " + token + ", setting security context");
                return Result.ok(extraParams);
            }
//        }
            return Result.ok(result);
        } catch (Exception e) {
            logger.error("regist error!", e);
            return Result.error(500, e.getMessage());
        }
    }


    public Map<String, String> getRsp(String url) {
        String result = null;
        Map<String, String> map = new HashMap<String, String>();
        RestTemplate restTemplate = new RestTemplate();
        String forObject = restTemplate.getForObject(url, String.class);
        try {
            forObject = new String(forObject.getBytes("ISO-8859-1"), "UTF-8");
            logger.info("forObject = [{}]", forObject);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        map = JsonUtils.toObject(forObject, Map.class);
        logger.warn("==============openId=" + map.get("openId"));
        return map;
    }


    @ApiOperation(value = "用户注册，网页端")
    @RequestMapping(value = "/v1/membershow/regist", method = RequestMethod.POST)
    public Result regist(@RequestBody @Validated(Create.class) RegistParam param) {
        try {
            //判断密码是否正确
            if (param.getPassword() == null || !param.getPassword().equals(param.getPasswordAgain())) {
                return Result.error(CommonConstants.SERVER_ERROR, "两次密码输入不正确。");
            }
            //注册时如果机构为空，则默认为-1
            if (com.synapse.common.utils.StringUtils.trimToEmpty(param.getOrganization()).equals("")) {
                param.setOrganization("-1");
            }
            if (com.synapse.common.utils.StringUtils.trimToEmpty(param.getNickName()).equals("")) {
                param.setNickName(param.getUserName());
            }
            String memberId = memberService.importregist(param);
            //判断是否存在

            Member member = memberService.getMember(memberId);
            if (member != null && "".equals(member)) {
                return Result.error(CommonConstants.SERVER_ERROR, "该账号已存在。");
            }
            if (memberId == null || StringUtils.trimToEmpty(memberId).length() == 0) {
                return Result.error(CommonConstants.SERVER_ERROR, "注册失败。");
            }
            member = memberService.buildMember(param);
            member.setUserId(memberId);
            memberService.create(member);
            UserRole userRole = new UserRole();
            userRole.setUserId(memberId);
            userRole.setRoleId(MemberConstants.ROLE.STUDENT.value());
            //todo appkey直接设置  不知道是否为appId  201906031958
            userRole.setAppKey(appId);
            userRole.setCreateId(memberId);
            userRoleService.create(userRole);
            return Result.ok("1");
        } catch (Exception e) {
            logger.error("regist error!", e);
            return Result.error(500, e.getMessage());
        }
    }


}
