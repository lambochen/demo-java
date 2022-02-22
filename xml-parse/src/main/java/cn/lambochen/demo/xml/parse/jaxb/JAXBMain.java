package cn.lambochen.demo.xml.parse.jaxb;

import cn.lambochen.demo.xml.parse.jaxb.modle.OssObjectListResponseXML;
import lombok.SneakyThrows;

/**
 * @author lambochen
 * @date 2022-02-22 22:11
 */
public class JAXBMain {

    @SneakyThrows
    public static void main(String[] args) {
        String data = "<ListBucketResult>\n" +
                "    <IsTruncated>false</IsTruncated>\n" +
                "    <Marker>null</Marker>\n" +
                "    <NextMarker></NextMarker>\n" +
                "    <Name>t0-85f9eedc79be3e89-1253176988</Name>\n" +
                "    <Prefix>devops-java/oss/</Prefix>\n" +
                "    <MaxKeys>10</MaxKeys>\n" +
                "    <EncodingType></EncodingType>\n" +
                "</ListBucketResult>";


        OssObjectListResponseXML responseXML = new OssObjectListResponseXML();

        responseXML.setBucketName("bucket name");
        responseXML.setIsTruncated(false);
        responseXML.setPrefix("key prefix");

        String xml = JAXBs.toXML(responseXML);
        System.out.println(xml);

        OssObjectListResponseXML parseXml = JAXBs.fromXML(data, OssObjectListResponseXML.class);
        System.out.println(parseXml);

    }

}
