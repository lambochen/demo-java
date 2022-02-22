package cn.lambochen.demo.xml.parse.xstream.model;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;

import java.util.List;

/**
 * @author lambochen
 * @date 2022-02-17 12:01
 */
@Data
@XStreamAlias(value = "ListBucketResult")
public class OssObjectListResponseXML {

    @XStreamAlias(value = "IsTruncated")
    private Boolean isTruncated;

    @XStreamAlias(value = "Marker")
    private String marker;

    @XStreamAlias(value = "NextMarker")
    private String nextMarker;

    @XStreamAlias(value = "Contents")
    private List<OssObjectListResponseContentXML> contents;

    @XStreamAlias(value = "Name")
    private String bucketName;

    @XStreamAlias(value = "Prefix")
    private String prefix;

    @XStreamAlias(value = "MaxKeys")
    private Integer maxKeys;

    @XStreamAlias(value = "EncodingType")
    private String encodingType;

}
