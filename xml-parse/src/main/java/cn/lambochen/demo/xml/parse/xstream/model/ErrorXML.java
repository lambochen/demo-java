package cn.lambochen.demo.xml.parse.xstream.model;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;

/**
 * @author lambochen
 * @date 2022-02-22 18:11
 */
@Data
@XStreamAlias(value = "Error")
public class ErrorXML {

    @XStreamAlias(value = "Code")
    private String code;

    @XStreamAlias(value = "Message")
    private String message;

    @XStreamAlias(value = "Resource")
    private String resource;

    @XStreamAlias(value = "RequestId")
    private String requestId;

}
