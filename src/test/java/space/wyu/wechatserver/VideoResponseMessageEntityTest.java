package space.wyu.wechatserver;

import org.junit.jupiter.api.Test;
import space.wyu.wechatserver.entity.VideoResponseMessageEntity;
import space.wyu.wechatserver.entity.VoiceResponseMessageEntity;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class VideoResponseMessageEntityTest {

    @Test
    public void testXML() throws JAXBException, FileNotFoundException {
        JAXBContext contextObj = JAXBContext.newInstance(VideoResponseMessageEntity.class);

        Marshaller marshallerObj = contextObj.createMarshaller();
        marshallerObj.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        VideoResponseMessageEntity videoResponseMessageEntity = new VideoResponseMessageEntity("toUserName","fromUserName","createTime", "msgType", "mediaId", "title", "description");

        marshallerObj.marshal(videoResponseMessageEntity, new FileOutputStream("videoResponseMessageEntity.xml"));
    }
}
