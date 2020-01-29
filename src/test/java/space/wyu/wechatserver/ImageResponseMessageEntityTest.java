package space.wyu.wechatserver;

import org.junit.jupiter.api.Test;
import space.wyu.wechatserver.entity.ImageResponseMessageEntity;
import space.wyu.wechatserver.entity.TextResponseMessageEntity;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class ImageResponseMessageEntityTest {

    @Test
    public void testXML() throws JAXBException, FileNotFoundException {
        JAXBContext contextObj = JAXBContext.newInstance(ImageResponseMessageEntity.class);

        Marshaller marshallerObj = contextObj.createMarshaller();
        marshallerObj.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        ImageResponseMessageEntity imageResponseMessageEntity = new ImageResponseMessageEntity("toUserName","fromUserName","createTime", "msgType", "mediaId");

        marshallerObj.marshal(imageResponseMessageEntity, new FileOutputStream("imageResponseMessageEntity.xml"));
    }
}
