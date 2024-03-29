package cn.lambochen.demo.design.pattern.bridge;

/**
 * 桥接模式
 *
 * 可以把桥接模式分为 "抽象方" 与 "实现方" 2 个维度阵营，其中各角色定义如下：
 *
 * Abstraction（抽象方）：
 *      抽象一方的高层接口，多以抽象类形式出现并持有实现方的接口引用。
 * AbstractionImpl（抽象方实现）：
 *      继承自抽象方的具体子类实现，可以有多种实施并在抽象方维度上自由扩展。
 * Implementor（实现方）：
 *      实现一方的接口规范，从抽象方中剥离出来成为另一个维度，独立于抽象方并不受其干扰。
 * ConcreteImplementor（实现方实施）：
 *      实现一方的具体实施类，可以有多个实施并在实现方维度上自由扩展。
 */