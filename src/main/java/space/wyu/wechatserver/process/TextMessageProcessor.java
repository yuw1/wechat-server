package space.wyu.wechatserver.process;

import space.wyu.wechatserver.entity.RequestMessageEntity;
import space.wyu.wechatserver.entity.TextResponseMessageEntity;

public class TextMessageProcessor implements MessageProcessor {
    private static final String PREFIX = "您刚才发的消息是：";
    private volatile static TextMessageProcessor textMessageProcessor;

    public static TextMessageProcessor getTextMessageProcessor() {
        if (textMessageProcessor == null) {
            synchronized (TextMessageProcessor.class) {
                if (textMessageProcessor == null) {
                    textMessageProcessor = new TextMessageProcessor();
                }
            }
        }
        return textMessageProcessor;
    }

    public TextResponseMessageEntity process(RequestMessageEntity request) {
        String content = PREFIX + request.getContent();
        TextResponseMessageEntity textResponseMessageEntity = new TextResponseMessageEntity(request.getFromUserName(), request.getToUserName(),
                String.valueOf(System.currentTimeMillis() / 1000), "text", content);
        return textResponseMessageEntity;
    }
}
