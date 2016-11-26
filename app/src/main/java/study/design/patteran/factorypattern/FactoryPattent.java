package study.design.patteran.factorypattern;

import android.support.annotation.NonNull;

/**
 * 工厂方法模式-应用最广泛
 * 定义一个创建对象的接口，让子类决定实例化哪个类
 * Created by fengyulong on 2016/11/26.
 */

public class FactoryPattent {
    public static void main(String[] args) {
        MyFactory myFactory = new MyFactory();
        myFactory.createProduct("a");
    }
}

abstract class Product {
    public abstract void method();
}

class ConcreteProductA extends Product {
    @Override
    public void method() {
        System.out.println("我是产品A!");
    }
}

class ConcreteProductB extends Product {
    @Override
    public void method() {
        System.out.println("我是产品B!");
    }
}

abstract class Factory {
    public abstract Product createProduct(@NonNull String type);
}

class MyFactory extends Factory {

    @Override
    public Product createProduct(String type) {
        if ("a".equals(type))
            return new ConcreteProductA();
        else
            return new ConcreteProductB();
    }
}

