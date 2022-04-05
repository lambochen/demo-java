package cn.lambochen.demo.design.pattern.adapter;

/**
 * @author lambochen
 * @date 2022-04-05 14:03
 * <p>
 * 三相插座
 */
public interface TriplePin {

    /**
     * @param l live 火线
     * @param n null 零线
     * @param e earth 地线
     */
    void electrify(int l, int n, int e);

}
