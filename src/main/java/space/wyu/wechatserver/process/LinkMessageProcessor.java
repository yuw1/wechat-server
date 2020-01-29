package space.wyu.wechatserver.process;

import org.springframework.beans.factory.annotation.Autowired;
import space.wyu.wechatserver.config.WechatConfig;
import space.wyu.wechatserver.entity.RequestMessageEntity;
import space.wyu.wechatserver.entity.ResponseMessageEntity;
import space.wyu.wechatserver.entity.TextResponseMessageEntity;

import javax.annotation.PostConstruct;

public class LinkMessageProcessor implements MessageProcessor {
    @Autowired
    private static WechatConfig wechatConfig;
    private volatile static LinkMessageProcessor imageMessageProcessor;

    @PostConstruct
    public void init() {
        imageMessageProcessor = this;
        imageMessageProcessor.wechatConfig = this.wechatConfig;
    }

    public static LinkMessageProcessor getEventMessageProcessor() {
        if (imageMessageProcessor == null) {
            synchronized (LinkMessageProcessor.class) {
                if (imageMessageProcessor == null) {
                    imageMessageProcessor = new LinkMessageProcessor();
                }
            }
        }
        return imageMessageProcessor;
    }

    public ResponseMessageEntity process(RequestMessageEntity request) {
        ResponseMessageEntity responseMessageEntity = null;
        String content = "您发送了一条链接：\nTitle: " + request.getTitle() + "\nDescription: " + request.getDescription() +
                "\nUrl: " + request.getUrl();
        responseMessageEntity = new TextResponseMessageEntity(request.getFromUserName(), request.getToUserName(),
                String.valueOf(System.currentTimeMillis() / 1000), "text", content);
        return responseMessageEntity;
    }
}
