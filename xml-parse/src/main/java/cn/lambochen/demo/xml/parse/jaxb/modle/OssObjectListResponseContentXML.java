package cn.lambochen.demo.xml.parse.jaxb.modle;

import lombok.Data;

import javax.xml.bind.annotation.XmlElement;
import java.util.Date;

/**
 * @author lambochen
 * @date 2022-02-17 15:10
 */
@Data
public class OssObjectListResponseContentXML {

    /**
     * <Contents>
     *     <Key>app_name/bucket_name/0cb641b4a3fb16c33fd1735bed4cf3a6 (2).mov</Key>
     *     <LastModified>2022-02-16T03:06:15.000Z</LastModified>
     *     <ETag>&#34;6ecd808d451ae819c7248e8240d2b5d4&#34;</ETag>
     *     <Size>1962248</Size>
     * </Contents>
     */

    @XmlElement(name = "Key")
    private String key;

    @XmlElement(name = "LastModified")
    private Date lastModified;

    @XmlElement(name = "ETag")
    private String eTag;

    @XmlElement(name = "Size")
    private Long size;
}


