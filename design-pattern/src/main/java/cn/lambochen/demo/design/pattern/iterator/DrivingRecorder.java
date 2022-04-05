package cn.lambochen.demo.design.pattern.iterator;

import java.util.Iterator;

/**
 * @author lambochen
 * @date 2022-04-05 21:32
 * <p>
 * 行车记录仪
 */
public class DrivingRecorder implements Iterable<String> {

    // 当前记录位置
    private int index = -1;

    private String[] records = new String[10];

    public void append(String record) {
        if (index == 9) {
            // 索引重置，从头覆盖
            index = 0;
        } else {
            index++;
        }

        records[index] = record;
    }

    public void display() {
        for (int i = 0; i < 10; i++) {
            System.out.println(i + ":" + records[i]);
        }
    }

    public void displayByOrder() {
        for (int i = index, loopCount = 0; loopCount < 10; i = i == 0 ? 9 : i - 1, loopCount++) {
            System.out.println(records[i]);
        }
    }

    @Override
    public Iterator<String> iterator() {
        return new Itr();
    }

    private class Itr implements Iterator<String> {

        // 迭代器游标，不波及原始集合索引
        int cursor = index;
        int loopCount = 0;

        @Override
        public String next() {
            // 记录即将返回的游标位置
            int i = cursor;
            if (cursor == 0) {
                cursor = 9;
            } else {
                cursor--;
            }

            loopCount++;
            return records[i];
        }

        @Override
        public boolean hasNext() {
            return loopCount < 10;
        }
    }
}
