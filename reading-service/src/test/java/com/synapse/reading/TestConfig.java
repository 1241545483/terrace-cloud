package com.synapse.reading;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

/**
 * Created by ivaneye on 17-2-26.
 */
@SpringBootApplication
@EnableTransactionManagement
@MapperScan({"com.synapse.reading.mapper", "com.synapse.reading.respository"})
@ComponentScan({"com.synapse.reading.*"})
@EnableAutoConfiguration(excludeName = {"org.springframework.boot.autoconfigure.session.SessionAutoConfiguration",
        "org.springframework.cloud.netflix.eureka.EurekaClientAutoConfiguration"})
@Transactional
@EnableFeignClients
public class TestConfig {

    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
