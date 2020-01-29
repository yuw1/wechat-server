package space.wyu.wechatserver;

import org.junit.jupiter.api.Test;
import space.wyu.wechatserver.entity.TextResponseMessageEntity;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class TextResponseMessageEntityTest {

    @Test
    public void testXML() throws JAXBException, FileNotFoundException {
        JAXBContext contextObj = JAXBContext.newInstance(TextResponseMessageEntity.class);

        Marshaller marshallerObj = contextObj.createMarshaller();
        marshallerObj.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        TextResponseMessageEntity textResponseMessageEntity = new TextResponseMessageEntity("toUserName","fromUserName","createTime", "msgType", "content");

        marshallerObj.marshal(textResponseMessageEntity, new FileOutputStream("textResponseMessageEntity.xml"));
    }
}
