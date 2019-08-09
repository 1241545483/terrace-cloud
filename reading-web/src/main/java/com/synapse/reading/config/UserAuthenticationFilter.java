package com.synapse.reading.config;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.synapse.common.codec.EncryptTool;
import com.synapse.common.sso.authority.RestGrantedAuthority;
import com.synapse.common.sso.context.UserContext;
import com.synapse.common.sso.model.User;
import com.synapse.common.utils.NetUtils;
import com.synapse.reading.constants.CommonConstants;
import com.synapse.reading.service.auth.ModelOperateService;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 根据gateway的数据构建User
 */
public class UserAuthenticationFilter extends OncePerRequestFilter {

    @Value("${encrypt.salt}")
    private String salt;

    @Value("${code.appId}")
    private String appId;
    public static final String TOKEN = "ACCESS-TOKEN";

    @Autowired
    private StringRedisTemplate redisTemplate;

    private Gson gson = new Gson();

    private Type type = new TypeToken<User>() {
    }.getType();

    @Override
    public void doFilterInternal(
            HttpServletRequest req,
            HttpServletResponse resp,
            FilterChain chain) throws ServletException, IOException {


        try {
            String authToken = req.getHeader(TOKEN);
            logger.info("authToken------------------!" + authToken);
            if (authToken != null) {
                String token;
                try {
                    token = EncryptTool.decrypt(authToken, salt);
                } catch (Exception e) {
                    token = authToken;
                    // 如果是微信登录，token为openId，不需要解密
                }
                logger.info("token------------------!" + token);
                if (token != null) {
                    Object data = redisTemplate.opsForValue().get(token);//从redis获取UserDetails
                    if (data != null) {
                        User loginUser = gson.fromJson((String) data, type);
//                        if (UserContext.getUser() == null || !UserContext.getUser().getRecId().equals(loginUser.getRecId())) {
                        UserContext.setUser(loginUser);
                        MDC.put("userId", loginUser.getRecId() + "");
                        MDC.put("userName", loginUser.getParams().get("userName") + "");
                        MDC.put("userName", loginUser.getUsername() + "");
//                        MDC.put("token", loginUser.getParams().get("userName") + "");
                        MDC.put("IP", NetUtils.getLocalHost());

                        User userDetails = new User(loginUser.getRecId(), loginUser.getUsername(), "");

                        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                                userDetails, null, userDetails.getAuthorities());
                        authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(
                                req));
                        SecurityContextHolder.getContext().setAuthentication(authentication);
//                        }
                    } else {
                        createAnony(req);
                    }
                } else {
                    createAnony(req);
                }
            } else {
                createAnony(req);
            }
        } catch (Exception e) {
            logger.error("TokenAuthentication Error!", e);
        }
        logger.info("exit UserAuthenticationFilter!");

        chain.doFilter(req, resp);
    }

    private void createAnony(HttpServletRequest req) {
        ArrayList<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        grantedAuthorities.add(new SimpleGrantedAuthority(CommonConstants.anonymousRole));
        User userDetails = new User(CommonConstants.anonymousId, CommonConstants.anonymousName, "", grantedAuthorities);
        UserContext.setUser(userDetails);
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                userDetails, null, userDetails.getAuthorities());
        authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(req));
        logger.info("authenticated user " + userDetails.getUsername() + ", setting security context");
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }
}
