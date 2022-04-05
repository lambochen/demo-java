package cn.lambochen.demo.design.pattern.state;

/**
 * @author lambochen
 * @date 2022-04-05 22:41
 */
public class Client {

    public static void main(String[] args) {
        TrafficLight trafficLight = new TrafficLight();

        trafficLight.switchToGreen();
        trafficLight.switchToRed();
        trafficLight.switchToGreen();
    }
}
