package space.wyu.wechatserver.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class SubVoiceResponseMessageEntity {
    @XmlElement(name = "MediaId")
    private String mediaId;

    public SubVoiceResponseMessageEntity() {}

    public SubVoiceResponseMessageEntity(String mediaId) {
        this.mediaId = mediaId;
    }
}
