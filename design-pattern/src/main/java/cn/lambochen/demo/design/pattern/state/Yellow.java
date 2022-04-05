package cn.lambochen.demo.design.pattern.state;

/**
 * @author lambochen
 * @date 2022-04-05 22:39
 */
public class Yellow implements State {
    @Override
    public void switchToGreen(TrafficLight trafficLight) {
        trafficLight.setState(new Green());
    }

    @Override
    public void switchToYellow(TrafficLight trafficLight) {
        System.out.println("error");
    }

    @Override
    public void switchToRed(TrafficLight trafficLight) {
        trafficLight.setState(new Red());
    }
}
