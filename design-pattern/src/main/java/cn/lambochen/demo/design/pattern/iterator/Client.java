package cn.lambochen.demo.design.pattern.iterator;

import java.util.Iterator;

/**
 * @author lambochen
 * @date 2022-04-05 21:41
 */
public class Client {

    public static void main(String[] args) {
        DrivingRecorder recorder = new DrivingRecorder();

        for (int i = 0; i < 12; i++) {
            recorder.append("video_" + i);
        }

        Iterator<String> itr = recorder.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
    }
}
