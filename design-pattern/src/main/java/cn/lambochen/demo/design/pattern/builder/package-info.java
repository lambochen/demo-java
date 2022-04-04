package cn.lambochen.demo.design.pattern.builder;

/**
 * 建造者模式
 *
 * Product（产品）：
 *  复杂的产品类，构建过程相对复杂，需要其他组件组装而成。
 * Builder（建造者）：
 *  建造者接口，定义了构成产品的各个组件的构建标准，通常有多个步骤。
 * ConcreteBuilder（建造者实现）：
 *  具体的建造者实现类，可以有多种实现，负责产品的组装但不包含整体建造逻辑。
 * Director（指导者）：
 *  持有建造者接口引用的指导者类，指导建造者按一定的逻辑进行建造。
 *
 * PS：{@link cn.lambochen.demo.design.pattern.builder.Product} 实现并非标准建造者模式。
 */