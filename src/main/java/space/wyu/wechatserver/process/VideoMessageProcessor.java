package space.wyu.wechatserver.process;

import org.springframework.beans.factory.annotation.Autowired;
import space.wyu.wechatserver.config.WechatConfig;
import space.wyu.wechatserver.entity.RequestMessageEntity;
import space.wyu.wechatserver.entity.ResponseMessageEntity;
import space.wyu.wechatserver.entity.TextResponseMessageEntity;

import javax.annotation.PostConstruct;

public class VideoMessageProcessor implements MessageProcessor {
    @Autowired
    private static WechatConfig wechatConfig;
    private volatile static VideoMessageProcessor videoMessageProcessor;

    @PostConstruct
    public void init() {
        videoMessageProcessor = this;
        videoMessageProcessor.wechatConfig = this.wechatConfig;
    }

    public static VideoMessageProcessor getEventMessageProcessor() {
        if (videoMessageProcessor == null) {
            synchronized (VideoMessageProcessor.class) {
                if (videoMessageProcessor == null) {
                    videoMessageProcessor = new VideoMessageProcessor();
                }
            }
        }
        return videoMessageProcessor;
    }

    public ResponseMessageEntity process(RequestMessageEntity request) {
        ResponseMessageEntity responseMessageEntity = null;
        String content = "您发送了一个视频：\nMediaId: " + request.getMediaId() + "\nThumbMediaId: " + request.getThumbMediaId();
        responseMessageEntity = new TextResponseMessageEntity(request.getFromUserName(), request.getToUserName(),
                String.valueOf(System.currentTimeMillis() / 1000), "text", content);
        return responseMessageEntity;
    }
}
