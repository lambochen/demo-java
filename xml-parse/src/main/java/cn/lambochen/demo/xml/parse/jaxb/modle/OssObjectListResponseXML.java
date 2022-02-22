package cn.lambochen.demo.xml.parse.jaxb.modle;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlList;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * @author lambochen
 * @date 2022-02-17 12:01
 */
@Data
@XmlRootElement(name = "ListBucketResult")
public class OssObjectListResponseXML {

    @XmlElement(name = "IsTruncated")
    private Boolean isTruncated;

    @XmlElement(name = "Marker")
    private String marker;

    @XmlElement(name = "NextMarker")
    private String nextMarker;

//    @XmlList
    @XmlElementWrapper(name = "Contents")
    private List<OssObjectListResponseContentXML> contents;

    @XmlElement(name = "Name")
    private String bucketName;

    @XmlElement(name = "Prefix")
    private String prefix;

    @XmlElement(name = "MaxKeys")
    private Integer maxKeys;

    @XmlElement(name = "EncodingType")
    private String encodingType;

}
