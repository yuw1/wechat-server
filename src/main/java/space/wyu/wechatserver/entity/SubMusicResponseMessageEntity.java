package space.wyu.wechatserver.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class SubMusicResponseMessageEntity {
    @XmlElement(name = "Title")
    private String title;

    @XmlElement(name = "Description")
    private String description;

    @XmlElement(name = "MusicUrl")
    private String musicUrl;

    @XmlElement(name = "HQMusicUrl")
    private String hqMusicUrl;

    @XmlElement(name = "ThumbMediaId")
    private String thumbMediaId;

    public SubMusicResponseMessageEntity() {}

    public SubMusicResponseMessageEntity(String title, String description, String musicUrl, String hqMusicUrl, String thumbMediaId) {
        this.title = title;
        this.description = description;
        this.musicUrl = musicUrl;
        this.hqMusicUrl = hqMusicUrl;
        this.thumbMediaId = thumbMediaId;
    }
}
