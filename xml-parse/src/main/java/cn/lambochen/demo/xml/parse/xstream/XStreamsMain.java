package cn.lambochen.demo.xml.parse.xstream;

import cn.lambochen.demo.xml.parse.xstream.model.OssObjectListResponseXML;

/**
 * @author lambochen
 * @date 2022-02-22 19:34
 */
public class XStreamsMain {

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

        String xml = XStreams.toXML(responseXML);
        System.out.println(xml);

        OssObjectListResponseXML parseXml = XStreams.fromXML(data, OssObjectListResponseXML.class);
        System.out.println(parseXml);

    }
}
