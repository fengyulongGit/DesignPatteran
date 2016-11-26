package study.design.patteran.abstractfactorypattern;

/**
 * 抽象工厂模式-创建型设计模式
 * 为创建一组相关或者是相互依赖的对象提供一个接口，而不需要制定他们的具体类
 * Created by fengyulong on 2016/11/26.
 */

public class AbstractFactoryPattern {
}

abstract class AbstractProductA {
    public abstract void method();
}

abstract class AbstractProductB {
    public abstract void method();
}

class ConcreteProductA1 extends AbstractProductA {
    public void method() {
        System.out.println("具体产品A1的方法！");
    }
}

class ConcreteProductA2 extends AbstractProductA {
    public void method() {
        System.out.println("具体产品A2的方法！");
    }
}

class ConcreteProductB1 extends AbstractProductB {
    public void method() {
        System.out.println("具体产品B1的方法！");
    }
}

class ConcreteProductB2 extends AbstractProductB {
    public void method() {
        System.out.println("具体产品B2的方法！");
    }
}

abstract class AbstractFactory {
    public abstract AbstractProductA createProductA();

    public abstract AbstractProductB createProductB();
}

class ConcreteFactory1 extends AbstractFactory {
    public AbstractProductA createProductA() {
        return new ConcreteProductA1();
    }

    public AbstractProductB createProductB() {
        return new ConcreteProductB1();
    }
}

class ConcreteFactory2 extends AbstractFactory {
    public AbstractProductA createProductA() {
        return new ConcreteProductA2();
    }

    public AbstractProductB createProductB() {
        return new ConcreteProductB2();
    }
}