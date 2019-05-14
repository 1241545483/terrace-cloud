package com.synapse.reading.test.config;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.synapse.common.codec.EncryptTool;
import com.synapse.common.sso.authority.RestGrantedAuthority;
import com.synapse.common.sso.context.UserContext;
import com.synapse.common.sso.model.User;
import com.synapse.common.utils.NetUtils;
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

/**
 * 根据gateway的数据构建User
 */
public class UserAuthenticationFilter extends OncePerRequestFilter {

    @Value("${encrypt.salt}")
    private String salt;

    @Autowired
    private StringRedisTemplate redisTemplate;

    private Gson gson = new Gson();

    private Type type = new TypeToken<User<RestGrantedAuthority>>() {
    }.getType();

    @Override
    protected void doFilterInternal(
            HttpServletRequest req,
            HttpServletResponse resp,
            FilterChain chain) throws ServletException, IOException {

        try {
            ArrayList<GrantedAuthority> grantedAuthorities = new ArrayList<>();
            grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_CREATE_LESSON"));
            User userDetails = new User("159", "鞠九兵", "password", true, grantedAuthorities);
            UserContext.setUser(userDetails);
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                    userDetails, null, userDetails.getAuthorities());
            authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(
                    req));
            logger.info("authenticated user " + userDetails.getUsername() + ", setting security context");
            SecurityContextHolder.getContext().setAuthentication(authentication);
        } catch (Exception e) {
            logger.error("TokenAuthentication Error!", e);
        }

        chain.doFilter(req, resp);
    }
}
