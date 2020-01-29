package space.wyu.wechatserver.process;

import org.springframework.beans.factory.annotation.Autowired;
import space.wyu.wechatserver.config.WechatConfig;
import space.wyu.wechatserver.entity.RequestMessageEntity;
import space.wyu.wechatserver.entity.ResponseMessageEntity;
import space.wyu.wechatserver.entity.TextResponseMessageEntity;

import javax.annotation.PostConstruct;

public class EventMessageProcessor implements MessageProcessor {
    @Autowired
    private static WechatConfig wechatConfig;
    private volatile static EventMessageProcessor eventMessageProcessor;

    @PostConstruct
    public void init() {
        eventMessageProcessor = this;
        eventMessageProcessor.wechatConfig = this.wechatConfig;
    }

    public static EventMessageProcessor getEventMessageProcessor() {
        if (eventMessageProcessor == null) {
            synchronized (EventMessageProcessor.class) {
                if (eventMessageProcessor == null) {
                    eventMessageProcessor = new EventMessageProcessor();
                }
            }
        }
        return eventMessageProcessor;
    }

    public ResponseMessageEntity process(RequestMessageEntity request) {
        ResponseMessageEntity responseMessageEntity = null;
        switch (request.getEvent()) {
            case "subscribe":
                responseMessageEntity = SubscribeEventMessageProcessor.process(request);
                break;
            case "SCAN":
                responseMessageEntity = ScanEventMessageProcessor.process(request);
                break;
            case "LOCATION":
                responseMessageEntity = LocationEventMessageProcessor.process(request);
                break;
            case "CLICK":
                responseMessageEntity = ClickEventMessageProcessor.process(request);
                break;
            case "VIEW":
                responseMessageEntity = ViewEventMessageProcessor.process(request);
                break;
            default:
                responseMessageEntity = NotSupportMessageProcessor.getNotSupportMessageProcessor().process(request);
        }
        return responseMessageEntity;
    }

    private static class SubscribeEventMessageProcessor {
        public static TextResponseMessageEntity process(RequestMessageEntity request) {
            TextResponseMessageEntity textResponseMessageEntity = null;
            if (request.getEventKey() == null) {
                String content = "感谢您的关注:)";
                textResponseMessageEntity = new TextResponseMessageEntity(request.getFromUserName(), request.getToUserName(),
                        String.valueOf(System.currentTimeMillis() / 1000), "text", content);

            } else {
                String content = "感谢您通过二维码关注:)\nEventKey: " + request.getEventKey() + "\nticket: " + request.getTicket();
                textResponseMessageEntity = new TextResponseMessageEntity(request.getFromUserName(), request.getToUserName(),
                        String.valueOf(System.currentTimeMillis() / 1000), "text", content);
            }
            return textResponseMessageEntity;
        }
    }

    private static class ScanEventMessageProcessor {
        public static TextResponseMessageEntity process(RequestMessageEntity request) {
            String content = "您已经关注，又扫了一遍二维码:)\nEventKey: " + request.getEventKey() + "\nticket: " + request.getTicket();
            TextResponseMessageEntity textResponseMessageEntity = null;
            textResponseMessageEntity = new TextResponseMessageEntity(request.getFromUserName(), request.getToUserName(),
                    String.valueOf(System.currentTimeMillis() / 1000), "text", content);
            return textResponseMessageEntity;
        }
    }

    private static class LocationEventMessageProcessor {
        public static TextResponseMessageEntity process(RequestMessageEntity request) {
            String content = "您所在的坐标是：\n纬度: " + request.getLatitude() + "\n经度: " + request.getLongitude() + "\n精度: " + request.getPrecision();
            TextResponseMessageEntity textResponseMessageEntity = new TextResponseMessageEntity(request.getFromUserName(), request.getToUserName(),
                    String.valueOf(System.currentTimeMillis() / 1000), "text", content);
            return textResponseMessageEntity;
        }
    }

    private static class ClickEventMessageProcessor {
        public static TextResponseMessageEntity process(RequestMessageEntity request) {
            String content = "您点击了菜单，EventKey: " + request.getEventKey();
            TextResponseMessageEntity textResponseMessageEntity = new TextResponseMessageEntity(request.getFromUserName(), request.getToUserName(),
                    String.valueOf(System.currentTimeMillis() / 1000), "text", content);
            return textResponseMessageEntity;
        }
    }

    private static class ViewEventMessageProcessor {
        public static TextResponseMessageEntity process(RequestMessageEntity request) {
            String content = "您点击了菜单，EventKey: " + request.getEventKey();
            TextResponseMessageEntity textResponseMessageEntity = new TextResponseMessageEntity(request.getFromUserName(), request.getToUserName(),
                    String.valueOf(System.currentTimeMillis() / 1000), "text", content);
            return textResponseMessageEntity;
        }
    }
}
