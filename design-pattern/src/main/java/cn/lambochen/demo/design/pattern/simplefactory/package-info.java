package cn.lambochen.demo.design.pattern.simplefactory;

/**
 * 工厂方法
 *
 * Product（产品）：
 *      所有产品的顶级父类，可以是抽象类或者接口。
 * ConcreteProduct（子产品）：
 *      由产品类 Product 派生出的产品子类，可以有多个产品子类。
 * Factory（工厂接口）：
 *      定义工厂方法的工厂接口，当然也可以是抽象类，它使顶级工厂制造方法抽象化、标准统一化。
 * ConcreteFactory（工厂实现）：
 *      实现了工厂接口的工厂实现类，并决定工厂方法中具体返回哪种产品子类的实例。
 */