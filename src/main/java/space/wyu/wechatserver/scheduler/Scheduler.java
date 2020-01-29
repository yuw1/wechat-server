package space.wyu.wechatserver.scheduler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import space.wyu.wechatserver.config.WechatConfig;
import space.wyu.wechatserver.config.WechatDynamicConfig;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class Scheduler {

    Logger logger = LoggerFactory.getLogger(Scheduler.class);
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Autowired
    private WechatConfig wechatConfig;

    @Scheduled(fixedRate = 5400000)
    public void getAccessToken() {
        String url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=" + wechatConfig.getClientCredential() +
                "&appid=" + wechatConfig.getAppid() + "&secret=" + wechatConfig.getSecret();
        logger.info("Start getting access token time ：" + dateFormat.format(new Date()));
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(url, String.class);
        try {
            JSONObject object = new JSONObject(result);
            String accessToken = (String) object.get("access_token");
            logger.info("AccessToken : " + accessToken);
            WechatDynamicConfig.setAccessToken(accessToken);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        logger.info("Got access token time ：" + dateFormat.format(new Date()));
    }
}
