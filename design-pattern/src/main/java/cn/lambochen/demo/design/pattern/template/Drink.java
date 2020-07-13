package cn.lambochen.demo.design.pattern.template;

/**
 * @author lambo.chen.2306@gmail.com
 * @date 2020/7/13
 * @description 饮品，模版类
 **/
public abstract class Drink {

    /**
     * 制作饮品模版方法
     *
     * final 修饰，表示模版不能变动（不能被子类变动），好莱坞原则
     */
    public final void buildDrinkTemplate() {
        // 1. 将水煮沸
        boilingWater();
        // 2. 将水与 原料 进行浸泡
        soakRawMaterial();
        // 3. 倒入水杯
        pour();
        // 4. 加入调味品
        if (flavorHook()) {
            flavor();
        }
    }

    /**
     * 加入调味品，子类实现 【每种饮品加入调味品不一样】
     */
    protected void flavor() {
        System.out.println("4. 加入调味品");
    }
//    protected abstract void flavor();

    /**
     * 2. 将水与 原料 进行浸泡 【每种饮品原料不一样】
     */
    protected abstract void soakRawMaterial();

    /**
     * 将水煮沸， 固定步骤，直接 private 实现即可
     */
    private void boilingWater() {
        System.out.println("1. 将水煮沸");
    }

    /**
     * 倒入杯中，固定步骤
     */
    private void pour() {
        System.out.println("3. 倒入水杯");
    }

    /**
     * 钩子函数，是否需要执行 {@link #flavor()}
     * @return
     */
    protected boolean flavorHook() {
        // 采用默认实现，意味着子类可以不主动实现
        // 这种方式，需要 对应的执行方法 也有默认实现才有意义
        return true;
    }

}
