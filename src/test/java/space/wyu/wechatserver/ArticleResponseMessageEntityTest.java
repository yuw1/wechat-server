package space.wyu.wechatserver;

import org.junit.jupiter.api.Test;
import space.wyu.wechatserver.entity.ArticleResponseMessageEntity;
import space.wyu.wechatserver.entity.SubArticleResponseMessageEntity;
import space.wyu.wechatserver.entity.VideoResponseMessageEntity;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class ArticleResponseMessageEntityTest {

    @Test
    public void testXML() throws JAXBException, FileNotFoundException {
        JAXBContext contextObj = JAXBContext.newInstance(ArticleResponseMessageEntity.class);

        Marshaller marshallerObj = contextObj.createMarshaller();
        marshallerObj.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        SubArticleResponseMessageEntity subArticleResponseMessageEntity1 = new SubArticleResponseMessageEntity("title1", "description1", "picUrl1", "url1");
        SubArticleResponseMessageEntity subArticleResponseMessageEntity2 = new SubArticleResponseMessageEntity("title2", "description2", "picUrl2", "url2");

        SubArticleResponseMessageEntity[] subArticleResponseMessageEntities = {subArticleResponseMessageEntity1, subArticleResponseMessageEntity2};

        ArticleResponseMessageEntity articleResponseMessageEntity = new ArticleResponseMessageEntity("toUserName","fromUserName","createTime", "msgType", 2, subArticleResponseMessageEntities);

        marshallerObj.marshal(articleResponseMessageEntity, new FileOutputStream("articleResponseMessageEntity.xml"));
    }
}
