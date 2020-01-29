package space.wyu.wechatserver;

import org.junit.jupiter.api.Test;
import space.wyu.wechatserver.entity.ImageResponseMessageEntity;
import space.wyu.wechatserver.entity.VoiceResponseMessageEntity;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class VoiceResponseMessageEntityTest {

    @Test
    public void testXML() throws JAXBException, FileNotFoundException {
        JAXBContext contextObj = JAXBContext.newInstance(VoiceResponseMessageEntity.class);

        Marshaller marshallerObj = contextObj.createMarshaller();
        marshallerObj.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        VoiceResponseMessageEntity voiceResponseMessageEntity = new VoiceResponseMessageEntity("toUserName","fromUserName","createTime", "msgType", "mediaId");

        marshallerObj.marshal(voiceResponseMessageEntity, new FileOutputStream("voiceResponseMessageEntity.xml"));
    }
}
