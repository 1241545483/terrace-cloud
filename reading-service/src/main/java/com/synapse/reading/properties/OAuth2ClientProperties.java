package com.synapse.gateway.properties;

public class OAuth2ClientProperties {
    /**
     * 第三方应用appId
     */
    private String clientId;
    /**
     * 第三方应用appSecret
     */
    private String clientSecret;

    /**
     * 网关分配给客户端的身份码
     */
    private String authorization;

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }

    public String getAuthorization() {
        return authorization;
    }

    public void setAuthorization(String authorization) {
        this.authorization = authorization;
    }
}
