package cn.lambochen.demo.design.pattern.prototype;

/**
 * 原型模式
 *
 * Prototype（原型接口）：
 *      声明克隆方法
 * ConcretePrototype（原型实现）：
 *      原型接口的实现类，实现方法中调用 super.clone() 即可得到新克隆的对象。
 * Client（客户端）：
 *      客户端只需调用实现此接口的原型对象方法 clone()，即可轻松地得到一个全新的实例对象。
 */