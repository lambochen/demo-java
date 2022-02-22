package cn.lambochen.demo.xml.parse.xstream;

import cn.lambochen.demo.xml.parse.xstream.model.OssObjectListResponseXML;
import com.thoughtworks.xstream.XStream;

/**
 * @author lambochen
 * @date 2022-02-15 15:06
 */
public abstract class XStreams {

    private static final XStream xStream = new XStream();
    private static final XStream xStreamBindAlias = new XStream();

    static {
        xStream.autodetectAnnotations(true);
//        xStream.processAnnotations(OssObjectListResponseXML.class);

        xStream.allowTypes(new Class[]{OssObjectListResponseXML.class});

        xStreamBindAlias.autodetectAnnotations(true);
    }

    public static <T> T fromXML(String xml, Class<T> clazz, String alias) {
        xStreamBindAlias.alias(alias, clazz);
        return (T) xStreamBindAlias.fromXML(xml);
    }

    public static <T> T fromXML(String xml, Class<T> clazz) {
        return (T) xStream.fromXML(xml);
    }

    public static <T> String toXML(T data, String alias) {
        xStreamBindAlias.alias(alias, data.getClass());
        return xStreamBindAlias.toXML(data);
    }

    public static <T> String toXML(T data) {
        return xStream.toXML(data);
    }

}
