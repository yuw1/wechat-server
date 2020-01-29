package space.wyu.wechatserver;

import org.junit.jupiter.api.Test;
import space.wyu.wechatserver.entity.MusicResponseMessageEntity;
import space.wyu.wechatserver.entity.VideoResponseMessageEntity;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class MusicResponseMessageEntityTest {

    @Test
    public void testXML() throws JAXBException, FileNotFoundException {
        JAXBContext contextObj = JAXBContext.newInstance(MusicResponseMessageEntity.class);

        Marshaller marshallerObj = contextObj.createMarshaller();
        marshallerObj.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        MusicResponseMessageEntity musicResponseMessageEntity =
                new MusicResponseMessageEntity("toUserName","fromUserName","createTime", "msgType",
                        "title", "description", "musicUrl", "hqMusicUrl", "thumbMediaId");

        marshallerObj.marshal(musicResponseMessageEntity, new FileOutputStream("musicResponseMessageEntity.xml"));
    }
}
