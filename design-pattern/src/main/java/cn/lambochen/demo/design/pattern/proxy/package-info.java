package cn.lambochen.demo.design.pattern.proxy;

/**
 * 代理模式
 *
 * Subject（业务接口）：
 *      对业务接口标准的定义与表示。
 * RealSubject（被代理业务）：
 *      需要被代理的实际业务类，实现了业务接口。
 * Proxy（代理）：
 *      同样实现了业务接口标准，包含被代理对象的实例并对其进行管控，对外提供代理后的业务方法。
 * Client（客户端）：
 *      业务的使用者，直接使用代理业务，而非实际业务。
 */