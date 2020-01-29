package space.wyu.wechatserver.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="xml")
@XmlAccessorType(XmlAccessType.FIELD)
public class VideoResponseMessageEntity extends ResponseMessageEntity {

    @XmlElement(name="Video")
    private SubVideoResponseMessageEntity subVideoResponseMessageEntity;

    public VideoResponseMessageEntity() {
    }

    public VideoResponseMessageEntity(String toUserName, String fromUserName, String createTime, String msgType, String mediaId, String title, String description) {
        super(toUserName, fromUserName, createTime, msgType);
        SubVideoResponseMessageEntity subVideoResponseMessageEntity = new SubVideoResponseMessageEntity(mediaId, title, description);
        this.subVideoResponseMessageEntity = subVideoResponseMessageEntity;
    }
}
