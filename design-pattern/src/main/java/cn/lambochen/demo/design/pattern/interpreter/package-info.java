package cn.lambochen.demo.design.pattern.interpreter;

/**
 * 解释器模式
 *
 * AbstractExpression（抽象表达式）：
 *      定义解释器的标准接口 interpret，所有终极表达式类与非终极表达式类均需实现此接口。
 * TerminalExpression（终极表达式）：
 *      抽象表达式接口的实现类，具有原子性、不可拆分性的表达式。
 * NonTerminalExpression（非终极表达式）：
 *      抽象表达式接口的实现类，包含一个或多个表达式接口引用，所以它所包含的子表达式可以是非终极表达式，也可以是终极表达式。
 * Context（上下文）：
 *      需要被解释的语言类，它包含符合解释器语法规则的具体语言。
 * Client
 *      根据语言的语法解构生成对应的表达式语法树，然后调用根表达式的解释方法得到结果
 */