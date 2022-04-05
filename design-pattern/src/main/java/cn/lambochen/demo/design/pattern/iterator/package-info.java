package cn.lambochen.demo.design.pattern.iterator;

/**
 * 迭代器模式
 *
 * Aggregate（集合接口）：
 *      集合标准接口，一种具备迭代能力的指标。
 * ConcreteAggregate（集合实现）：
 *      实现集合接口 Aggregate 的具体集合类，可以实例化并返回一个迭代器以供外部使用。
 * Iterator（迭代器接口）：
 *      迭代器的接口标准，定义了进行迭代操作所需的一些方法，如 next(), hasNext()。
 * ConcreteIterator（迭代器实现）：
 *      迭代器接口 Iterator 的具体实现类，记录迭代状态并对外部提供所有迭代器功能的实现。
 * Client（客户端）：
 *      集合数据的使用者，需要从集合获取迭代器再进行遍历。
 */