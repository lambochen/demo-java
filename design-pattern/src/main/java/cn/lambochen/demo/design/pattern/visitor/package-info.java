package cn.lambochen.demo.design.pattern.visitor;

/**
 * 访问者模式
 *
 * Element（元素接口）：
 *      被访问的数据元素接口，定义一个可以接待访问者的行为标准，且所有数据封装类需实现此接口，通常作为泛型并被包含在对象容器中。
 *      @see cn.lambochen.demo.design.pattern.visitor.Acceptable
 * ConcreteElement（元素实现）：
 *      具体数据元素实现类，可以有多个实现，并且相对固定。其 accept 实现方法中调用访问者并将自己 this 传回。
 *      @see cn.lambochen.demo.design.pattern.visitor.Candy
 * ObjectContainer（对象容器）：
 *      包含所有可被访问的数据对象的容器，可以提供数据对象的迭代功能，可以是任意类型的数据结构。
 * Visitor（访问者接口）
 *      可以是接口或者抽象类，定义了一系列访问操作方法以处理所有数据元素，通常为同名的访问方法，并以数据类作为入参来确定哪个重载方法被调用。
 * ConcreteVisitor（访问者实现）：
 *      访问者接口的实现类，可以有多个实现，每个访问者类都需实现所有数据元素类型的访问重载方法。
 * Client：
 *      使用容器并初始化其中各类数据元素，并选择合适的访问者处理容器中的所有数据对象。
 *
 */