package cn.lambochen.demo.spock

import spock.lang.Specification
import spock.lang.Unroll


class BinarySearchTest extends Specification {

    @Unroll // 平铺所有测试用例
    def "search Test"() {
        expect:
        BinarySearch.search(arr as int[], key) == result

        where:
        arr       | key | result
        []        | 1   | -1
        [1]       | 1   | 0
        [1]       | 2   | -1
        [3]       | 2   | -1
        [1, 2, 9] | 2   | 1
        [1, 2, 9] | 9   | 2
        [1, 2, 9] | 3   | -1
//        null      | 0   | -1
    }


}
