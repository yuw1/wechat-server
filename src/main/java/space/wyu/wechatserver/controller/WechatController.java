package space.wyu.wechatserver.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.*;
import org.springframework.http.MediaType;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import space.wyu.wechatserver.config.WechatConfig;
import space.wyu.wechatserver.entity.RequestMessageEntity;
import space.wyu.wechatserver.entity.ResponseMessageEntity;
import space.wyu.wechatserver.process.*;
import space.wyu.wechatserver.util.Encrypt;

import java.util.Arrays;

@RestController
@EnableAutoConfiguration
public class WechatController {

    Logger logger = LoggerFactory.getLogger(WechatController.class);
    @Autowired
    private WechatConfig wechatConfig;

    @RequestMapping(path = "/", method = RequestMethod.GET)
    String wechatGet(@RequestParam MultiValueMap<String, String> parameters) {
        if (parameters.containsKey("echostr")) {
            String timestamp = parameters.getFirst("timestamp");
            String nonce = parameters.getFirst("nonce");
            String signature = parameters.getFirst("signature");
            String echostr = parameters.getFirst("echostr");
            return checkValid(timestamp, nonce, signature) ? echostr : "Authentication Failed";
        }
        return "Error message!";
    }

    public boolean checkValid(String timestamp, String nonce, String signature) {
        String[] dict = {wechatConfig.getToken(), timestamp, nonce};
        Arrays.sort(dict);
        StringBuilder authStr = new StringBuilder();
        authStr.append(dict[0]).append(dict[1]).append(dict[2]);
        String result = Encrypt.getSha1(authStr.toString());
        logger.info("AuthStr is {} , result is {} , signnature is {}", new String[] {authStr.toString(), result, signature});
        return result.equals(signature);
    }

    @RequestMapping(path = "/", method = RequestMethod.POST, produces = MediaType.APPLICATION_XML_VALUE)
    @ResponseBody
    public Object wechatPost(@RequestBody RequestMessageEntity request) {
        logger.info(request.toString());

        ResponseMessageEntity responseMessageEntity;
        switch (request.getMsgType()) {
            case "text":
                responseMessageEntity = TextMessageProcessor.getTextMessageProcessor().process(request);
                break;
            case "image":
                responseMessageEntity = ImageMessageProcessor.getEventMessageProcessor().process(request);
                break;
            case "voice":
                responseMessageEntity = VoiceMessageProcessor.getEventMessageProcessor().process(request);
                break;
            case "video":
                responseMessageEntity = VideoMessageProcessor.getEventMessageProcessor().process(request);
                break;
            case "shortvideo":
                responseMessageEntity = ShortvideoMessageProcessor.getEventMessageProcessor().process(request);
                break;
            case "location":
                responseMessageEntity = LocationMessageProcessor.getEventMessageProcessor().process(request);
                break;
            case "link":
                responseMessageEntity = LinkMessageProcessor.getEventMessageProcessor().process(request);
                break;
            case "event":
                responseMessageEntity = EventMessageProcessor.getEventMessageProcessor().process(request);
                break;
            default:
                responseMessageEntity = NotSupportMessageProcessor.getNotSupportMessageProcessor().process(request);
        }
        logger.info(responseMessageEntity.toString());
        return  responseMessageEntity;
    }
}