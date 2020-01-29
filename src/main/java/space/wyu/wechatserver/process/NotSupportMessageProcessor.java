package space.wyu.wechatserver.process;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import space.wyu.wechatserver.config.WechatConfig;
import space.wyu.wechatserver.entity.RequestMessageEntity;
import space.wyu.wechatserver.entity.ResponseMessageEntity;
import space.wyu.wechatserver.entity.TextResponseMessageEntity;

import javax.annotation.PostConstruct;

@Component
public class NotSupportMessageProcessor implements MessageProcessor {
    @Autowired
    private WechatConfig wechatConfig;
    private volatile static NotSupportMessageProcessor notSupportMessageProcessor;

    @PostConstruct
    public void init() {
        notSupportMessageProcessor = this;
        notSupportMessageProcessor.wechatConfig = this.wechatConfig;
    }

    public static NotSupportMessageProcessor getNotSupportMessageProcessor() {
        if (notSupportMessageProcessor == null) {
            synchronized (NotSupportMessageProcessor.class) {
                if (notSupportMessageProcessor == null) {
                    notSupportMessageProcessor = new NotSupportMessageProcessor();
                }
            }
        }
        return notSupportMessageProcessor;
    }

    @Override
    public ResponseMessageEntity process(RequestMessageEntity request) {
        String content = wechatConfig.getNotSupportMessage();
        TextResponseMessageEntity textResponseMessageEntity = new TextResponseMessageEntity(request.getFromUserName(), request.getToUserName(),
                String.valueOf(System.currentTimeMillis() / 1000), "text", content);
        return textResponseMessageEntity;
    }
}
