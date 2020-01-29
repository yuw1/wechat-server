package space.wyu.wechatserver.process;

import org.springframework.beans.factory.annotation.Autowired;
import space.wyu.wechatserver.config.WechatConfig;
import space.wyu.wechatserver.entity.RequestMessageEntity;
import space.wyu.wechatserver.entity.ResponseMessageEntity;
import space.wyu.wechatserver.entity.TextResponseMessageEntity;

import javax.annotation.PostConstruct;

public class VoiceMessageProcessor implements MessageProcessor {
    @Autowired
    private static WechatConfig wechatConfig;
    private volatile static VoiceMessageProcessor voiceMessageProcessor;

    @PostConstruct
    public void init() {
        voiceMessageProcessor = this;
        voiceMessageProcessor.wechatConfig = this.wechatConfig;
    }

    public static VoiceMessageProcessor getEventMessageProcessor() {
        if (voiceMessageProcessor == null) {
            synchronized (VoiceMessageProcessor.class) {
                if (voiceMessageProcessor == null) {
                    voiceMessageProcessor = new VoiceMessageProcessor();
                }
            }
        }
        return voiceMessageProcessor;
    }

    public ResponseMessageEntity process(RequestMessageEntity request) {
        ResponseMessageEntity responseMessageEntity = null;
        String content = "您发送了一条语音：\nMediaId: " + request.getMediaId() + "\nFormat: " + request.getFormat() + "\nRecognition: " + request.getRecognition();
        responseMessageEntity = new TextResponseMessageEntity(request.getFromUserName(), request.getToUserName(),
                String.valueOf(System.currentTimeMillis() / 1000), "text", content);
        return responseMessageEntity;
    }
}
