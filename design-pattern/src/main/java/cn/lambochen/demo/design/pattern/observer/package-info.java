package cn.lambochen.demo.design.pattern.observer;

/**
 * 观察者模式
 *
 * Subject（目标主题）：
 *      被观察的目标主题的接口抽象，维护观察者对象列表，并定义注册方法 register 与通知方法 notify。
 * ConcreteSubject（主题实现）：
 *      被观察的目标主题的具体实现类，持有一个属性状态 state，可以有多种实现。
 * Observer（观察者）：
 *      观察者的接口抽象，定义响应方法 update。
 * ConcreteObserver（观察者实现）：
 *      观察者的具体实现类，可以有任意多个子类实现。实现了响应方法 update，收到通知后进行自己独特的处理
 */