package space.wyu.wechatserver.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="xml")
@XmlAccessorType(XmlAccessType.FIELD)
public class MusicResponseMessageEntity extends ResponseMessageEntity {

    @XmlElement(name="Music")
    private SubMusicResponseMessageEntity subMusicResponseMessageEntity;

    public MusicResponseMessageEntity() {
    }

    public MusicResponseMessageEntity(String toUserName, String fromUserName, String createTime, String msgType,
                                      String title, String description, String musicUrl, String hqMusicUrl, String thumbMediaId) {
        super(toUserName, fromUserName, createTime, msgType);
        SubMusicResponseMessageEntity subMusicResponseMessageEntity =
                new SubMusicResponseMessageEntity(title, description, musicUrl, hqMusicUrl, thumbMediaId);
        this.subMusicResponseMessageEntity = subMusicResponseMessageEntity;
    }
}
