package study.design.patteran.bridge;

/**
 * 桥接模式-连接两地的交通枢纽
 * <p>
 * 将抽象部分与实现部分分离，使他们独立地进行变化。
 * <p>
 * 其实就是，一个类存在两个维度的变化，且这两个维度都需要进行扩展。
 * Created by fengyulong on 2016/11/26.
 */

public class Client {
    public static void main(String[] args) {
        Ordinary ordinary = new Ordinary();

        Sugar sugar = new Sugar();

        LargeCoffee largeCoffeeOrdinary = new LargeCoffee(ordinary);
        largeCoffeeOrdinary.makeCoffee();

        SmallCoffee smallCoffeeOrdinary = new SmallCoffee(ordinary);
        smallCoffeeOrdinary.makeCoffee();

        LargeCoffee largeCoffeeSugar = new LargeCoffee(sugar);
        largeCoffeeSugar.makeCoffee();

        SmallCoffee smallCoffeeSugar = new SmallCoffee(sugar);
        smallCoffeeSugar.makeCoffee();

        //拓展中杯可实现Coffee
    }
}

//
abstract class Coffee {
    protected CoffeeAddtives coffeeAddtives;

    public Coffee(CoffeeAddtives coffeeAddtives) {
        this.coffeeAddtives = coffeeAddtives;
    }

    public abstract void makeCoffee();
}

abstract class CoffeeAddtives {
    public abstract String addSomething();
}

class LargeCoffee extends Coffee {
    public LargeCoffee(CoffeeAddtives coffeeAddtives) {
        super(coffeeAddtives);
    }

    @Override
    public void makeCoffee() {
        System.out.println("大杯的" + coffeeAddtives.addSomething() + "咖啡");
    }
}

class SmallCoffee extends Coffee {
    public SmallCoffee(CoffeeAddtives coffeeAddtives) {
        super(coffeeAddtives);
    }

    @Override
    public void makeCoffee() {
        System.out.println("小杯的" + coffeeAddtives.addSomething() + "咖啡");
    }
}

class Sugar extends CoffeeAddtives {
    @Override
    public String addSomething() {
        return "加糖";
    }
}

class Ordinary extends CoffeeAddtives {
    @Override
    public String addSomething() {
        return "原味";
    }
}