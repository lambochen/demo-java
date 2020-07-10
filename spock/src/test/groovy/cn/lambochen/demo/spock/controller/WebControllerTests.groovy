package cn.lambochen.demo.spock.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.web.servlet.MockMvc
import spock.lang.Specification

@AutoConfigureMockMvc
@WebMvcTest
class WebControllerTests extends Specification {

    @Autowired
    private MockMvc mockMvc

    def "when get is performed then the response has status 200 and content is 'Hello'"() {
        expect: "Status is 200 and the response is 'Hello'"
        mockMvc.perform(get("/hello"))
            .andExpect(status().isOk())
            .andReturn()
            .response
            .contentAsString == "Hello"
    }
}
