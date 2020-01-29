package space.wyu.wechatserver.config;

public class WechatDynamicConfig {
    private static String accessToken;

    public static String getAccessToken() {
        return accessToken;
    }

    public static void setAccessToken(String accessToken) {
        WechatDynamicConfig.accessToken = accessToken;
    }
}
