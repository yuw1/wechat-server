package space.wyu.wechatserver.entity;

import javax.xml.bind.annotation.*;

@XmlRootElement(name="xml")
@XmlAccessorType(XmlAccessType.FIELD)
public class ArticleResponseMessageEntity extends ResponseMessageEntity {

    @XmlElement(name = "ArticleCount")
    private int articleCount;

    @XmlElementWrapper(name="Articles")
    @XmlElement(name = "item")
    private SubArticleResponseMessageEntity[] subArticleResponseMessageEntities;

    public ArticleResponseMessageEntity() {
    }

    public ArticleResponseMessageEntity(String toUserName, String fromUserName, String createTime, String msgType, int articleCount,
                                        SubArticleResponseMessageEntity[] subArticleResponseMessageEntities) {
        super(toUserName, fromUserName, createTime, msgType);
        this.articleCount = articleCount;
        this.subArticleResponseMessageEntities = subArticleResponseMessageEntities;
    }
}
