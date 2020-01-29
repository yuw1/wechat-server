package space.wyu.wechatserver.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="xml")
@XmlAccessorType(XmlAccessType.FIELD)
public class VoiceResponseMessageEntity extends ResponseMessageEntity {

    @XmlElement(name="Voice")
    private SubVoiceResponseMessageEntity subVoiceResponseMessageEntity;

    public VoiceResponseMessageEntity() {
    }

    public VoiceResponseMessageEntity(String toUserName, String fromUserName, String createTime, String msgType, String mediaId) {
        super(toUserName, fromUserName, createTime, msgType);
        SubVoiceResponseMessageEntity subImageResponseMessageEntity = new SubVoiceResponseMessageEntity(mediaId);
        this.subVoiceResponseMessageEntity = subImageResponseMessageEntity;
    }
}
