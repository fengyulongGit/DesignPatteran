package study.design.patteran.mediator;

/**
 * 中介者模式-"和事佬"
 * <p>
 * 中介者模式包装了一系列对象相互作用的方式，使得这些对象不必相互明显调用，从而使他们可以轻松耦合。
 * 当某些对象之间的作用发生改变时，不会立即影响其他的一些对象之间的作用保证这些作用可以彼此独立的变化，
 * 中介者模式将多对多的相互作用转为一对多的相互作用。
 * <p>
 * 什么时候用中介者模式呢？其实，中介者对象是将系统从网状结构转为以调停者为中心的星型结构。
 * 举个简单的例子，一台电脑包括：CPU、内存、显卡、IO设备。其实，要启动一台计算机，有了CPU和内存就够了。
 * 当然，如果你需要连接显示器显示画面，那就得加显卡，如果你需要存储数据，那就要IO设备，但是这并不是最重要的，
 * 它们只是分割开来的普通零件而已，我们需要一样东西把这些零件整合起来，变成一个完整体，这个东西就是主板。
 * 主板就是起到中介者的作用，任何两个模块之间的通信都会经过主板协调。
 * Created by fengyulong on 2016/11/26.
 */

public class Client {
    public static void main(String[] args) {
        ConcreteMediator concreteMediator = new ConcreteMediator();
        ConcreteColleagueA concreteColleagueA = new ConcreteColleagueA(concreteMediator);
        ConcreteColleagueB concreteColleagueB = new ConcreteColleagueB(concreteMediator);

        concreteMediator.setConcreteColleagueA(concreteColleagueA);
        concreteMediator.setConcreteColleagueB(concreteColleagueB);

        concreteMediator.method();
    }
}

//抽象同事
abstract class Colleague {
    protected Mediator mediator;

    public Colleague(Mediator mediator) {
        this.mediator = mediator;
    }

    public abstract void action();
}

//具体同事A
class ConcreteColleagueA extends Colleague {
    public ConcreteColleagueA(Mediator mediator) {
        super(mediator);
    }

    @Override
    public void action() {
        System.out.println("同事A 将信息递交给中介者处理");
    }
}

//具体同事B
class ConcreteColleagueB extends Colleague {
    public ConcreteColleagueB(Mediator mediator) {
        super(mediator);
    }

    @Override
    public void action() {
        System.out.println("同事B 将信息递交给中介者处理");
    }
}

//抽象中介者
abstract class Mediator {
    protected ConcreteColleagueA concreteColleagueA;
    protected ConcreteColleagueB concreteColleagueB;

    public abstract void method();

    public void setConcreteColleagueA(ConcreteColleagueA concreteColleagueA) {
        this.concreteColleagueA = concreteColleagueA;
    }

    public void setConcreteColleagueB(ConcreteColleagueB concreteColleagueB) {
        this.concreteColleagueB = concreteColleagueB;
    }
}

class ConcreteMediator extends Mediator {
    @Override
    public void method() {
        concreteColleagueA.action();
        concreteColleagueB.action();
    }
}