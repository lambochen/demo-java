package cn.lambochen.demo.spock

import org.junit.Assert
import spock.lang.Specification
import spock.lang.Unroll

import java.util.function.Consumer

class CatchUtilTest extends Specification {

    /**
     * 尚存在问题
     */
    @Unroll
    def "testTryDo"() {
        expect:
        try {
            CatchUtil.tryDo(1, { throw new IllegalArgumentException(it.toString()) } as Consumer)
            Assert.fail("not throw exception")
        } catch (Exception e) {
            e.class.name == "java.lang.RuntimeException"
            e.cause.class.name == "java.lang.IllegalArgumentException"
        }
    }

    @Unroll
    def "testTryDo with thrown"() {
        when:
        CatchUtil.tryDo(1, { throw new IllegalArgumentException(it.toString()) } as Consumer)

        then:
        def e = thrown(Exception)
        e.class.name == "java.lang.RuntimeException"
        e.cause.class.name == "java.lang.IllegalArgumentException"
    }

}
