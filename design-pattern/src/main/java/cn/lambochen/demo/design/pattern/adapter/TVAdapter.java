package cn.lambochen.demo.design.pattern.adapter;

/**
 * @author lambochen
 * @date 2022-04-05 14:09
 * <p>
 * 电视机专属适配器
 */
public class TVAdapter extends TV implements TriplePin {
    @Override
    public void electrify(int l, int n, int e) {
        super.electrify(l, n);
    }
}
