package cn.lambochen.demo.design.pattern.decorator;

/**
 * 装饰器模式
 *
 * Component（组件接口）：
 *      所有被装饰组件及装饰器对应的接口标准，指定进行装饰的行为方法。
 * ConcreteComponent（组件实现）：
 *      需要被装饰的组件，实现组件接口标准，只具备自身未被装饰的原始特性。
 * Decorator（装饰器）：
 *      装饰器的高层抽象类，同样实现组件接口标准，且包含一个被装饰的组件。
 * ConcreteDecorator（装饰器实现）：
 *      继承自装饰器抽象类的具体子类装饰器，可以有多种实现，在被装饰组件对象的基础上为其添加新的特性。
 */
