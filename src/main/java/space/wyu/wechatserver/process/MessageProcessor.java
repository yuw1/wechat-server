package space.wyu.wechatserver.process;

import org.springframework.beans.factory.annotation.Autowired;
import space.wyu.wechatserver.config.WechatConfig;
import space.wyu.wechatserver.entity.RequestMessageEntity;
import space.wyu.wechatserver.entity.ResponseMessageEntity;

public interface MessageProcessor {
    ResponseMessageEntity process(RequestMessageEntity request);
}
