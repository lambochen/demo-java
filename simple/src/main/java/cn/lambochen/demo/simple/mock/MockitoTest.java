package cn.lambochen.demo.simple.mock;

/**
 * @author lambo.chen
 * @date 2020/11/27
 **/
public class MockitoTest {

    public static void main(String[] args) {
        Calculate calculate = Mockito.mock(Calculate.class);
        Mockito.when(calculate.add(1, 1)).thenReturn(3);

        int res = calculate.add(1, 1);
        System.out.println(res);
    }

    public static class Calculate {
        public int add(int a, int b) {
            return a + b;
        }
    }
}
