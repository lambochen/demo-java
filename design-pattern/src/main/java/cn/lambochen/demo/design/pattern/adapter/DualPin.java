package cn.lambochen.demo.design.pattern.adapter;

/**
 * @author lambochen
 * @date 2022-04-05 14:05
 * <p>
 * 两相插孔接口
 */
public interface DualPin {

    /**
     * @param l live 火线
     * @param n null 零线
     */
    void electrify(int l, int n);

}
