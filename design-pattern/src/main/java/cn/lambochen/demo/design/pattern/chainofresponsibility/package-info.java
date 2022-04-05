package cn.lambochen.demo.design.pattern.chainofresponsibility;

/**
 * 责任链模式
 *
 * Handler（业务处理者）：
 *      所有业务处理节点的顶层抽象，定义了抽象业务处理方法 handle() 并留给子类实现，
 *      其实体方法 setSuccessor() （注入继任者）则用于责任链的构建。
 * ConcreteHandler（业务处理者实现类）：
 *      实际业务处理的实现类，可以有任意多个，每个都实现了 handle() 方法以处理自己职权范围内的业务，
 *      职权范围之外的事则传递给下一个继任者。
 * Client：
 *      业务申请人，只需要对业务链条的第一个入口节点发起请求即可得到最终响应。
 */