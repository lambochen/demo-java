package cn.lambochen.demo.design.pattern.state;

/**
 * 状态模式
 *
 * State（状态接口）：
 *      定义通用的状态规范标准，其中处理请求方法 handle() 将系统环境 Context 作为参数传入。
 * ConcreteState（状态实现）：
 *      具体的状态实现类，根据系统环境用于表达系统环境 Context 的各个状态，需要符合状态接口的规范。
 * Context（系统环境）：
 *      系统的环境，持有状态接口的引用，以及更新状态方法 setState()，对外暴露请求发起方法 request()
 */