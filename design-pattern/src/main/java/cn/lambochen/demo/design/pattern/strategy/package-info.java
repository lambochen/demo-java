package cn.lambochen.demo.design.pattern.strategy;
/**
 * 策略模式
 *
 * Strategy（策略接口）：
 *      定义通用的策略规范标准，包含在系统环境中并声明策略接口标准。
 * ConcreteStrategy（策略实现）：
 *      实现了策略接口的策略实现类，可以有多种不同的策略实现，但都得符合策略接口定义的规范。
 * Context（系统环境）：
 *      包含策略接口的系统环境，对外提供更换策略实现的方法 setStrategy() 以及执行策略的方法 execute()，其本身并不关心执行的是哪种策略实现。
 **/
