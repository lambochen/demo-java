package cn.lambochen.demo.xml.parse.jaxb;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;

/**
 * @author lambochen
 * @date 2022-02-22 22:08
 */
public class JAXBs {

    public static String toXML(Object object) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(object.getClass());
        Marshaller m = context.createMarshaller();
        // 设置格式化输出
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

        Writer w = new StringWriter();
        m.marshal(object, w);
        return w.toString();
    }

    public static <T> T fromXML(String xml, Class<T> clazz) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(clazz);
        Unmarshaller um = context.createUnmarshaller();
        StringReader sr = new StringReader(xml);
        return (T) um.unmarshal(sr);
    }
}
