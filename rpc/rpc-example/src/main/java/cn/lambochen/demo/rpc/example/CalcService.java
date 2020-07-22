package cn.lambochen.demo.rpc.example;

/**
 * @Author lambo.chen.2306@gmail.com
 * @Date 2020/7/22 1:26
 * @Description TODO
 **/
public interface CalcService {

    int add(int a, int b);

    int minus(int a, int b);

}

class CalcServiceImpl implements CalcService {

    @Override
    public int add(int a, int b) {
        return a + b;
    }

    @Override
    public int minus(int a, int b) {
        return a - b;
    }
}