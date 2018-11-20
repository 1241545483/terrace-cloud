package com.synapse.reading;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.ImmutableList;
import com.synapse.common.formatter.Encoder;
import com.synapse.common.json.ObjectMappingCustomer;
import com.synapse.common.sso.interceptor.TokenUserInfoInterceptor;
import com.synapse.common.sso.rest.RestTemplateProxy;
import com.synapse.common.formatter.IdFormatterFactory;
import com.synapse.common.formatter.ResultSerializerIntrospector;
import com.synapse.reading.web.formatter.ShiluDictFormatter;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.socket.config.annotation.EnableWebSocket;

import java.util.List;

/**
 * Created by ivaneye on 17-2-26.
 */
@SpringBootApplication
@EnableTransactionManagement
@EnableEurekaClient
@MapperScan({"com.synapse.reading.mapper", "com.synapse.reading.respository"})
@ComponentScan({"com.synapse.reading", "com.synapse.common.sso", "com.synapse.common.json", "com.synapse.common.web", "com.synapse.common.api.doc"})
@EnableFeignClients
@EnableWebSocket
public class Main extends WebMvcConfigurerAdapter {

    @Value("${cors.origins}")
    private String origins;

    @Value("${salt}")
    private String salt;

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Bean
    @LoadBalanced
    RestTemplate restTemplate() {
        return new RestTemplateProxy();
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

    @Bean
    public TokenUserInfoInterceptor tokenUserInfoInterceptor() {
        return new TokenUserInfoInterceptor();
    }

    @Bean
    RestTemplate restTemplateOut() {
        return new RestTemplate();
    }
    /**
     * 配置拦截器
     *
     * @param registry
     * @author lance
     */
    public void addInterceptors(InterceptorRegistry registry) {
        //todo wangyifan 基于Token的验证
        registry.addInterceptor(new TokenUserInfoInterceptor()).addPathPatterns("/**");
        registry.addInterceptor(new com.synapse.common.sso.interceptor.UserInfoInterceptor()).addPathPatterns("/**");
        //        添加shilu模块的拦截
//        registry.addInterceptor(new AuthIntercepter()).addPathPatterns(arr);
    }
    @Bean
    public Encoder encoder() {
        return new Encoder(salt);
    }
}
