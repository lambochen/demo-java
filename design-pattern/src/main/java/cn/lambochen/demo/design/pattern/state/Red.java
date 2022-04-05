package cn.lambochen.demo.design.pattern.state;

import com.sun.org.apache.xerces.internal.impl.dv.xs.YearDV;

/**
 * @author lambochen
 * @date 2022-04-05 22:37
 */
public class Red implements State {
    @Override
    public void switchToGreen(TrafficLight trafficLight) {
        System.out.println("error");
    }

    @Override
    public void switchToYellow(TrafficLight trafficLight) {
        trafficLight.setState(new Yellow());
    }

    @Override
    public void switchToRed(TrafficLight trafficLight) {
        System.out.println("error");
    }
}
