package cn.lambochen.demo.design.pattern.mediator;

/**
 * 中介模式
 *
 * Mediator（中介）：
 *      共事者之间通信的中介平台接口，定义与共事者的通信标准。
 * ConcreteMediator（中介实现）：
 *      可以有多种实现，持有所有共事者对象的列表，并实现中介定义的通信方法。
 * Colleague（共事者）、ConcreteColleague（共事实现）：
 *      共事者可以有多种共事者实现。共事者持有中介对象的引用，以使其在发送消息时可以调用中介，并由它转发给其他共事者对象。
 *
 */