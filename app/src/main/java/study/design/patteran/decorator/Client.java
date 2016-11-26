package study.design.patteran.decorator;

/**
 * 装饰模式
 * <p>
 * 动态的给一个对象添加额外的智者，就增加功能来说，装饰模式比子类继承的方式更灵活。
 * Created by fengyulong on 2016/11/26.
 */

public class Client {
    public static void main(String[] args) {
        Component component = new ConcreteComponent();

        Decorator decorator = new Decorator(component);

        decorator.operate();
    }
}

//抽象类
abstract class Component {
    public abstract void operate();
}

//实现类
class ConcreteComponent extends Component {
    public void operate() {
        //具体的实现
    }

}

//装饰者
class Decorator {
    private Component component;

    public Decorator(Component component) {
        this.component = component;
    }

    public void operate() {
        operateA();
        component.operate();
        operateB();
    }

    public void operateA() {
        //具体操作
    }

    public void operateB() {
        //具体操作
    }
}