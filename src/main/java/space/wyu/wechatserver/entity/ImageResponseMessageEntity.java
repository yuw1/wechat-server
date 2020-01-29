package space.wyu.wechatserver.entity;

import javax.xml.bind.annotation.*;

@XmlRootElement(name="xml")
@XmlAccessorType(XmlAccessType.FIELD)
public class ImageResponseMessageEntity extends ResponseMessageEntity {

    @XmlElement(name="Image")
    private SubImageResponseMessageEntity subImageResponseMessageEntity;

    public ImageResponseMessageEntity() {
    }

    public ImageResponseMessageEntity(String toUserName, String fromUserName, String createTime, String msgType, String mediaId) {
        super(toUserName, fromUserName, createTime, msgType);
        SubImageResponseMessageEntity subImageResponseMessageEntity = new SubImageResponseMessageEntity(mediaId);
        this.subImageResponseMessageEntity = subImageResponseMessageEntity;
    }
}
