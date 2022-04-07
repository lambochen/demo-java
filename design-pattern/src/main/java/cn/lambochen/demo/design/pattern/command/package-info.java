package cn.lambochen.demo.design.pattern.command;

/**
 * 命令模式
 *
 * Invoker（命令请求方）：
 *      命令的请求方或发送方，持有命令接口的引用，并控制命令的执行或反向执行操作。
 * Command（命令接口）：
 *      定义命令执行的接口标准，可包括执行与反向执行操作。
 * ConcreteCommand（命令实现）：
 *      命令接口的实现类，可以有任意多个，其执行方法中调用命令执行方所对应的执行方法。
 * Receiver（命令的执行方）：
 *      最终的命令执行方。
 */