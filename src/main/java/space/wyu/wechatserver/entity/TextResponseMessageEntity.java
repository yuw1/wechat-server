package space.wyu.wechatserver.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="xml")
@XmlAccessorType(XmlAccessType.FIELD)
public class TextResponseMessageEntity extends ResponseMessageEntity {
    @XmlElement(name = "Content")
    private String content;

    public TextResponseMessageEntity() {}

    public TextResponseMessageEntity(String toUserName, String fromUserName, String createTime, String msgType, String content) {
        super(toUserName, fromUserName, createTime, msgType);
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    @Override
    public String toString() {
        return "TextResponseMessageEntity{" +
                "content='" + content + '\'' +
                "} " + super.toString();
    }
}
