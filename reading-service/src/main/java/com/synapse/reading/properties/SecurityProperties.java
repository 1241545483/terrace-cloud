package com.synapse.gateway.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.HashMap;
import java.util.Map;

@ConfigurationProperties(prefix = "shilu.security")
public class SecurityProperties {
    /**
     * OAuth2认证服务器配置
     */
    private OAuth2Properties oauth2 = new OAuth2Properties();

    private Map<String,OAuth2ClientProperties> oauth2Config = new HashMap<String,OAuth2ClientProperties>();

    public OAuth2Properties getOauth2() {
        return oauth2;
    }

    /**
     * 配置参数映射
     * @param oauth2
     */
    public void setOauth2(OAuth2Properties oauth2) {
        this.oauth2 = oauth2;
    }

    public Map<String, OAuth2ClientProperties> getOauth2Config() {
        OAuth2ClientProperties[] clients = oauth2.getClients();
        Map<String,OAuth2ClientProperties> config = new HashMap<String,OAuth2ClientProperties>();
        for (OAuth2ClientProperties oAuth2ClientProperties:clients){
            config.put(oAuth2ClientProperties.getAuthorization(),oAuth2ClientProperties);
        }
        this.oauth2Config = config;
        return oauth2Config;
    }

    public void setOauth2Config(Map<String, OAuth2ClientProperties> oauth2Config) {
        this.oauth2Config = oauth2Config;
    }
}
