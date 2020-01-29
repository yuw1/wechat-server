package space.wyu.wechatserver.process;

import org.springframework.beans.factory.annotation.Autowired;
import space.wyu.wechatserver.config.WechatConfig;
import space.wyu.wechatserver.entity.RequestMessageEntity;
import space.wyu.wechatserver.entity.ResponseMessageEntity;
import space.wyu.wechatserver.entity.TextResponseMessageEntity;

import javax.annotation.PostConstruct;

public class ImageMessageProcessor implements MessageProcessor {
    @Autowired
    private static WechatConfig wechatConfig;
    private volatile static ImageMessageProcessor imageMessageProcessor;

    @PostConstruct
    public void init() {
        imageMessageProcessor = this;
        imageMessageProcessor.wechatConfig = this.wechatConfig;
    }

    public static ImageMessageProcessor getEventMessageProcessor() {
        if (imageMessageProcessor == null) {
            synchronized (ImageMessageProcessor.class) {
                if (imageMessageProcessor == null) {
                    imageMessageProcessor = new ImageMessageProcessor();
                }
            }
        }
        return imageMessageProcessor;
    }

    public ResponseMessageEntity process(RequestMessageEntity request) {
        ResponseMessageEntity responseMessageEntity = null;
        String content = "您发送了一张图片：\nPicUrl: " + request.getPicUrl() + "\nMediaId: " + request.getMediaId();
        responseMessageEntity = new TextResponseMessageEntity(request.getFromUserName(), request.getToUserName(),
                String.valueOf(System.currentTimeMillis() / 1000), "text", content);
        return responseMessageEntity;
    }
}
