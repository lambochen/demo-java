package cn.lambochen.demo.simple.functions;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author lambochen
 * @date 2022-03-14 00:04
 */
public class Functions {

    public static void main(String[] args) {

        List<Data> datas = new ArrayList<>();
        datas.add(new Data(1));
        datas.add(new Data(1));
        datas.add(new Data(2));
        datas.add(new Data(2));
        datas.add(new Data(3));

        /**
         * 问：下述代码运行结果是否正确，distinctByKey 方法会被调用几次？
         *
         * 执行顺序：
         * 1. distinctByKey(Data::getId) 得到 Predicate 方法实例
         *      1.1. 初始化 Set，得到 Set 实例
         *      1.2. 返回 Predicate 实例：t -> seen.add(keyExtractor.apply(t)) 【注意，此lambda是直接使用 set 实例】
         * 2. datas.stream().filter(distinctByKey(Data::getId)).collect(Collectors.toList())
         *
         * 由执行顺序知，真实在 stream 运行时，实际上并非是运行 distinctByKey 方法，
         * 而是 t -> seen.add(keyExtractor.apply(t)), Predicate 实例。
         * 故，distinctByKey 方法仅调用一次，Set 实例化一次，stream 运行结果正常
         */
        List<Data> distinctDatas = datas.stream().filter(distinctByKey(Data::getId)).collect(Collectors.toList());

        System.out.println(distinctDatas);
    }

    private static <T> Predicate<T> distinctByKey(Function<? super T, ?> keyExtractor) {
        Set<Object> seen = ConcurrentHashMap.newKeySet();
        return t -> seen.add(keyExtractor.apply(t));
    }

    static class Data {
        Integer id;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public Data() {
        }

        public Data(Integer id) {
            this.id = id;
        }
    }
}
