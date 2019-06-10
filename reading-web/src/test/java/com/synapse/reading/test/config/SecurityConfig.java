package com.synapse.reading.test.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * Created by ivaneye on 17-3-6.
 */
@Configuration("testSecurityConfig")
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        HttpSecurity security = http
                .addFilterAt(testUserAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
        security.headers().frameOptions().sameOrigin().and() // 关闭iframe嵌套限制
                .csrf().disable()  //CSRF（Cross-site request forgery）跨站请求伪造(关闭有风险)
                .authorizeRequests()
                .anyRequest().permitAll();
//                .anyRequest().authenticated();
    }

    @Bean("testUserAuthenticationFilter")
    public UserAuthenticationFilter testUserAuthenticationFilter() throws Exception {
        UserAuthenticationFilter filter = new UserAuthenticationFilter();
        return filter;
    }
}
