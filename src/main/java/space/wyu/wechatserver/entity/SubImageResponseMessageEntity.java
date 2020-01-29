package space.wyu.wechatserver.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class SubImageResponseMessageEntity {
    @XmlElement(name = "MediaId")
    private String mediaId;

    public SubImageResponseMessageEntity() {}

    public SubImageResponseMessageEntity(String mediaId) {
        this.mediaId = mediaId;
    }
}
