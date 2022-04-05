package cn.lambochen.demo.design.pattern.adapter;
/**
 * 适配器模式
 *
 * Target（目标接口）：
 *      客户端要使用的目标接口标准。
 * Adapter（适配器）：
 *      实现了目标接口，负责适配（转换）被适配者的接口 specificRequest() 为目标接口 request()。
 * Adaptee（被适配者）：
 *      被适配者的接口标准，目前不能兼容目标接口的问题接口，可以有多种实现类。
 * Client（客户端）：
 *      目标接口的使用者。
 **/
