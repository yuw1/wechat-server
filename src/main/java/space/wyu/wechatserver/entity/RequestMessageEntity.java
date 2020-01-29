package space.wyu.wechatserver.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="xml")
@XmlAccessorType(XmlAccessType.FIELD)
public class RequestMessageEntity {
    @XmlElement(name = "ToUserName", required = true)
    private String toUserName;

    @XmlElement(name = "FromUserName", required = true)
    private String fromUserName;

    @XmlElement(name = "CreateTime", required = true)
    private String createTime;

    @XmlElement(name = "MsgType", required = true)
    private String msgType;

//    普通消息
    @XmlElement(name = "MsgId")
    private String msgId;

//    除文字消息之外的其他普通消息
    @XmlElement(name = "MediaId")
    private String mediaId;

//    文字消息
    @XmlElement(name = "Content")
    private String content;

//    图片消息
    @XmlElement(name = "PicUrl")
    private String picUrl;

//    语音消息
    @XmlElement(name = "Format")
    private String format;

    @XmlElement(name = "Recognition")
    private String recognition;

//    视频消息
    @XmlElement(name = "ThumbMediaId")
    private String thumbMediaId;

//    地理位置消息
    @XmlElement(name = "Location_X")
    private String locationX;

    @XmlElement(name = "Location_Y")
    private String locationY;

    @XmlElement(name = "Scale")
    private String scale;

    @XmlElement(name = "Label")
    private String label;

//    链接消息
    @XmlElement(name = "Title")
    private String title;

    @XmlElement(name = "Description")
    private String description;

    @XmlElement(name = "Url")
    private String url;

//    事件消息
    @XmlElement(name = "Event")
    private String event;

//    扫描二维码事件和点击自定义菜单事件
    @XmlElement(name = "EventKey")
    private String eventKey;

//    扫描二维码事件
    @XmlElement(name = "Ticket")
    private String ticket;

//    上报地理位置事件
    @XmlElement(name = "Latitude")
    private String latitude;

    @XmlElement(name = "Longitude")
    private String longitude;

    @XmlElement(name = "Precision")
    private String precision;

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

    public String getMsgId() {
        return msgId;
    }

    public String getMediaId() {
        return mediaId;
    }

    public String getContent() {
        return content;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public String getFormat() {
        return format;
    }

    public String getRecognition() {
        return recognition;
    }

    public String getThumbMediaId() {
        return thumbMediaId;
    }

    public String getLocationX() {
        return locationX;
    }

    public String getLocationY() {
        return locationY;
    }

    public String getScale() {
        return scale;
    }

    public String getLabel() {
        return label;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getUrl() {
        return url;
    }

    public String getEvent() {
        return event;
    }

    public String getEventKey() {
        return eventKey;
    }

    public String getTicket() {
        return ticket;
    }

    public String getLatitude() {
        return latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public String getPrecision() {
        return precision;
    }

    @Override
    public String toString() {
        return "RequestMessageEntity{" +
                "toUserName='" + toUserName + '\'' +
                ", fromUserName='" + fromUserName + '\'' +
                ", createTime='" + createTime + '\'' +
                ", msgType='" + msgType + '\'' +
                ", msgId='" + msgId + '\'' +
                ", mediaId='" + mediaId + '\'' +
                ", content='" + content + '\'' +
                ", picUrl='" + picUrl + '\'' +
                ", format='" + format + '\'' +
                ", recognition='" + recognition + '\'' +
                ", thumbMediaId='" + thumbMediaId + '\'' +
                ", locationX='" + locationX + '\'' +
                ", locationY='" + locationY + '\'' +
                ", scale='" + scale + '\'' +
                ", label='" + label + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", url='" + url + '\'' +
                ", event='" + event + '\'' +
                ", eventKey='" + eventKey + '\'' +
                ", ticket='" + ticket + '\'' +
                ", latitude='" + latitude + '\'' +
                ", longitude='" + longitude + '\'' +
                ", precision='" + precision + '\'' +
                '}';
    }
}
