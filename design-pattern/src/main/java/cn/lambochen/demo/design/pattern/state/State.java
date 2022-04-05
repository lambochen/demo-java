package cn.lambochen.demo.design.pattern.state;

/**
 * @author lambochen
 * @date 2022-04-05 22:35
 */
public interface State {

    void switchToGreen(TrafficLight trafficLight);
    void switchToYellow(TrafficLight trafficLight);
    void switchToRed(TrafficLight trafficLight);

}
