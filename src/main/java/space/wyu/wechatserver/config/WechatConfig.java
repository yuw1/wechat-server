package space.wyu.wechatserver.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource(value = "classpath:wechat.properties", encoding = "UTF-8")
@ConfigurationProperties(prefix = "wechat")
public class WechatConfig {
    private String token;
    private String clientCredential;
    private String appid;
    private String secret;
    @Value("notSupportMessage")
    private String notSupportMessage;
    private String weatherKey;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getClientCredential() {
        return clientCredential;
    }

    public void setClientCredential(String clientCredential) {
        this.clientCredential = clientCredential;
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public String getNotSupportMessage() {
        return notSupportMessage;
    }

    public void setNotSupportMessage(String notSupportMessage) {
        this.notSupportMessage = notSupportMessage;
    }

    public String getWeatherKey() {
        return weatherKey;
    }

    public void setWeatherKey(String weatherKey) {
        this.weatherKey = weatherKey;
    }
}
