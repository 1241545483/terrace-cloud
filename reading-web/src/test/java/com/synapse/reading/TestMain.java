package com.synapse.reading;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.ImmutableList;
import com.synapse.common.formatter.Encoder;
import com.synapse.common.formatter.IdFormatterFactory;
import com.synapse.common.formatter.ResultSerializerIntrospector;
import com.synapse.common.json.ObjectMappingCustomer;
import com.synapse.common.sso.context.UserContext;
import com.synapse.common.sso.model.User;
import com.synapse.reading.config.SecurityConfig;
import com.synapse.reading.config.UserAuthenticationFilter;
import com.synapse.reading.web.formatter.ShiluDictFormatter;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.socket.config.annotation.EnableWebSocket;

import javax.servlet.Filter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ivaneye on 17-2-26.
 */
@SpringBootApplication
@EnableTransactionManagement
@MapperScan({"com.synapse.reading.mapper", "com.synapse.reading.respository"})
@ComponentScan(value = {"com.synapse.reading.*", "com.synapse.common.json", "com.synapse.common.web", "com.synapse.common.api.doc"}
        , excludeFilters = {@ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = {SecurityConfig.class})})
@EnableAutoConfiguration(excludeName = {"org.springframework.boot.autoconfigure.session.SessionAutoConfiguration",
        "org.springframework.cloud.netflix.eureka.EurekaClientAutoConfiguration"})
@Transactional
@EnableFeignClients
@EnableWebSocket
public class TestMain extends WebMvcConfigurerAdapter {

    @Value("${cors.origins}")
    private String origins;

    @Value("${salt}")
    private String salt;

    @MockBean
    private UserAuthenticationFilter userAuthenticationFilter;

    public static void main(String[] args) {
        SpringApplication.run(TestMain.class, args);
    }

    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public Encoder encoder() {
        return new Encoder(salt);
    }

    @Bean
    public Filter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        String[] origin = origins.split(",");
        for (String o : origin) {
            config.addAllowedOrigin(o);
        }
        config.addAllowedHeader("Origin");
        config.addAllowedHeader("Content-Type");
        config.addAllowedHeader("Accept");
        config.addAllowedHeader("Cache-Control");
        config.addAllowedHeader("Authorization");
        config.addAllowedHeader("token");
        config.addAllowedHeader("X-Requested-With");
        config.addAllowedMethod("POST");
        config.addAllowedMethod("GET");
        config.addAllowedMethod("PUT");
        config.addAllowedMethod("OPTIONS");
        config.addAllowedMethod("DELETE");
        config.addExposedHeader("x-auth-token");
        config.addExposedHeader("x-total-count");
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addFormatterForFieldAnnotation(new IdFormatterFactory(salt));
        super.addFormatters(registry);
    }

    @Bean
    public MappingJackson2HttpMessageConverter jackson2HttpMessageConverter() {
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        ObjectMapper mapper = new ObjectMappingCustomer();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.setAnnotationIntrospector(new ResultSerializerIntrospector(salt, new ShiluDictFormatter()));
        converter.setSupportedMediaTypes(ImmutableList.of(MediaType.TEXT_HTML, MediaType.APPLICATION_JSON));
        converter.setObjectMapper(mapper);
        return converter;
    }

    //添加转换器
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(jackson2HttpMessageConverter());
    }

    /**
     * 配置拦截器
     *
     * @param registry
     * @author lance
     */
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new HandlerInterceptorAdapter() {
            @Override
            public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
                Map<String, List<Map<String, String>>> bizRoles = new HashMap<>();
                List<Map<String, String>> userInfos = new ArrayList<>();
                Map<String, String> roles = new HashMap<>();
                roles.put("bizroleId", "school_manager");
                userInfos.add(roles);
                roles = new HashMap<>();
                roles.put("bizroleId", "admin");
                userInfos.add(roles);
                roles = new HashMap<>();
                roles.put("bizroleId", "area_manager");
                userInfos.add(roles);
                bizRoles.put("SHILU", userInfos);
                UserContext.setUser(new User("516919611287928832", "鞠九兵", "password", true, "1000", "1", bizRoles, "1", null, null, null, "1"));
                return super.preHandle(request, response, handler);
            }
//            @Override
//            public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
//                response.setHeader("Access-Control-Allow-Origin", "*");
//                System.out.println("请求请求.....");
//                response.setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, OPTIONS, DELETE");
//                response.setHeader("Access-Control-Max-Age", "3600");
//            }
        }).addPathPatterns("/**");
    }
}
