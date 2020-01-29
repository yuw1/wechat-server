package space.wyu.wechatserver.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="xml")
@XmlAccessorType(XmlAccessType.FIELD)
public abstract class ResponseMessageEntity {
    @XmlElement(name = "ToUserName", required = true)
    private String toUserName;
    @XmlElement(name = "FromUserName", required = true)
    private String fromUserName;
    @XmlElement(name = "CreateTime", required = true)
    private String createTime;
    @XmlElement(name = "MsgType", required = true)
    private String msgType;

    public ResponseMessageEntity() {}

    public ResponseMessageEntity(String toUserName, String fromUserName, String createTime, String msgType) {
        this.toUserName = toUserName;
        this.fromUserName = fromUserName;
        this.createTime = createTime;
        this.msgType = msgType;
    }

    public String getToUserName() {
        return toUserName;
    }

    public String getFromUserName() {
        return fromUserName;
    }

    public String getCreateTime() {
        return createTime;
    }

    public String getMsgType() {
        return msgType;
    }

    @Override
    public String toString() {
        return "ResponseMessageEntity{" +
                "toUserName='" + toUserName + '\'' +
                ", fromUserName='" + fromUserName + '\'' +
                ", createTime='" + createTime + '\'' +
                ", msgType='" + msgType + '\'' +
                '}';
    }
}
