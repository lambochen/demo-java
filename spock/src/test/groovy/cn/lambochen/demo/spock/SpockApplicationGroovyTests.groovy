package cn.lambochen.demo.spock

import cn.lambochen.demo.spock.controller.WebController
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification

@SpringBootTest
class SpockApplicationGroovyTests extends Specification {

    @Autowired(required = false)
    private WebController webController;

    def "when context is loaded then all expected beans are created"() {
        expect: "the WebController is created"
        webController
    }

}
