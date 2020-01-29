package space.wyu.wechatserver.process;

import org.springframework.beans.factory.annotation.Autowired;
import space.wyu.wechatserver.config.WechatConfig;
import space.wyu.wechatserver.entity.RequestMessageEntity;
import space.wyu.wechatserver.entity.ResponseMessageEntity;
import space.wyu.wechatserver.entity.TextResponseMessageEntity;

import javax.annotation.PostConstruct;

public class ShortvideoMessageProcessor implements MessageProcessor {
    @Autowired
    private static WechatConfig wechatConfig;
    private volatile static ShortvideoMessageProcessor shortvideoMessageProcessor;

    @PostConstruct
    public void init() {
        shortvideoMessageProcessor = this;
        shortvideoMessageProcessor.wechatConfig = this.wechatConfig;
    }

    public static ShortvideoMessageProcessor getEventMessageProcessor() {
        if (shortvideoMessageProcessor == null) {
            synchronized (ShortvideoMessageProcessor.class) {
                if (shortvideoMessageProcessor == null) {
                    shortvideoMessageProcessor = new ShortvideoMessageProcessor();
                }
            }
        }
        return shortvideoMessageProcessor;
    }

    public ResponseMessageEntity process(RequestMessageEntity request) {
        ResponseMessageEntity responseMessageEntity = null;
        String content = "您发送了一个小视频：\nMediaId: " + request.getMediaId() + "\nThumbMediaId: " + request.getThumbMediaId();
        responseMessageEntity = new TextResponseMessageEntity(request.getFromUserName(), request.getToUserName(),
                String.valueOf(System.currentTimeMillis() / 1000), "text", content);
        return responseMessageEntity;
    }
}
