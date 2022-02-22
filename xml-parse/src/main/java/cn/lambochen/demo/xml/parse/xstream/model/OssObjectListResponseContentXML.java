package cn.lambochen.demo.xml.parse.xstream.model;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;

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

    @XStreamAlias(value = "Key")
    private String key;

    @XStreamAlias(value = "LastModified")
    private Date lastModified;

    @XStreamAlias(value = "ETag")
    private String eTag;

    @XStreamAlias(value = "Size")
    private Long size;
}


