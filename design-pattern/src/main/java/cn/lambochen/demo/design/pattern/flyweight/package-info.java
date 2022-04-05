package cn.lambochen.demo.design.pattern.flyweight;

/**
 * 享元模式
 *
 * Flyweight（享元接口）：
 *      所有元件的高层规范，声明与外蕴状态互动的接口标准。
 * ConcreteFlyweight（享元实现）：
 *      享元接口的元件实现类，自身维护着内蕴状态，且能接受并响应外蕴状态，可以有多个实现，一个享元对象可以被称作一个 "元"。
 * FlyweightFactory（享元工厂）：
 *      用来维护享元对象的工厂，负责对享元对象实例进行创建与管理，并对外提供获取享元对象的服务。
 * Client（客户端）：
 *      享元的使用者，负责维护外蕴状态。
 */