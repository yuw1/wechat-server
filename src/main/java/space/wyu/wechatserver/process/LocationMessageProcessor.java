package space.wyu.wechatserver.process;

import org.springframework.beans.factory.annotation.Autowired;
import space.wyu.wechatserver.config.WechatConfig;
import space.wyu.wechatserver.entity.RequestMessageEntity;
import space.wyu.wechatserver.entity.ResponseMessageEntity;
import space.wyu.wechatserver.entity.TextResponseMessageEntity;
import space.wyu.wechatserver.util.Weather;

import javax.annotation.PostConstruct;

public class LocationMessageProcessor implements MessageProcessor {
    @Autowired
    private static WechatConfig wechatConfig;
    private volatile static LocationMessageProcessor locationMessageProcessor;

    @PostConstruct
    public void init() {
        locationMessageProcessor = this;
        locationMessageProcessor.wechatConfig = this.wechatConfig;
    }

    public static LocationMessageProcessor getEventMessageProcessor() {
        if (locationMessageProcessor == null) {
            synchronized (LocationMessageProcessor.class) {
                if (locationMessageProcessor == null) {
                    locationMessageProcessor = new LocationMessageProcessor();
                }
            }
        }
        return locationMessageProcessor;
    }

    public ResponseMessageEntity process(RequestMessageEntity request) {
        ResponseMessageEntity responseMessageEntity = null;
        String content = "您发送了地理位置：\nLocation_X: " + request.getLocationX() + "\nLocation_Y: " + request.getLocationY() +
                "\nScale: " + request.getScale() + "\nLabel: " + request.getLabel() + Weather.weather.getWeather(request.getLocationX(), request.getLocationY());
        responseMessageEntity = new TextResponseMessageEntity(request.getFromUserName(), request.getToUserName(),
                String.valueOf(System.currentTimeMillis() / 1000), "text", content);
        return responseMessageEntity;
    }
}
