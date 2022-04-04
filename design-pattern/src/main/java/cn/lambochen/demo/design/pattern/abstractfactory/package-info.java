package cn.lambochen.demo.design.pattern.abstractfactory;

/**
 * 抽象工厂
 *
 * AbstractProduct1、AbstractProduct2（抽象产品1、抽象产品2）：
 *      产品系列的抽象类
 * ProductA1、ProductA2、ProductB1、ProductB2（产品A不同系列、产品B不同系列）：
 *      继承自抽象产品的产品实体类，其中 ProductA1 与 ProductB1 代表 AbstractProduct1 的产品，类似。
 * AbstractFactory（抽象工厂接口）：
 *      工厂的高层抽象，可以是接口或者抽象类。
 *      抽象工厂对各产品系列的制造标准进行规范化定义，但具体返回哪个产品由具体工厂决定，它并不关心。
 * ConcreteFactoryA、ConcreteFactoryB（工厂实现）：
 *      继承自抽象工厂的各族工厂，需实现抽象工厂所定义的产品系列制造方法，可以扩展多个工厂实现。
 * Client（客户端）：
 *      产品的使用者，只关心制造出的产品系列，具体是哪个产品族由工厂决定。
 */