package cn.lambochen.demo.design.pattern.strategy;

/**
 * @Author lambo.chen.2306@gmail.com
 * @Date 2020/7/13 21:45
 * @Description TODO
 **/
public class StrategyMain {

    public static void main(String[] args) {
        Duck bigYellow = new BigYellowDuck();
        bigYellow.fly();

        System.out.println("----------\n");

        Duck donaldDuck = new DonaldDuck();
        donaldDuck.fly();
    }
}
