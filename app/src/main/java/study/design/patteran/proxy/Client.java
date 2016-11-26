package study.design.patteran.proxy;

/**
 * 代理模式-编程好帮手
 * <p>
 * 为其他类提供一种代理以控制这个对象的访问。
 * <p>
 * 其实代理模式我们平时用的也比较多，其实比较好理解，就是当我们需要对一个对象进行访问时，我们不直接对这个对象进行访问，而是访问这个类的代理类，
 * 代理类能帮我们执行我们想要的操作。代理模式比较容易理解。
 * <p>
 * 举例：诉讼类官司，个人不能直接找法院或者上访，需要聘请律师代理，律师即代理角色
 * Created by fengyulong on 2016/11/26.
 */

public class Client {
    public static void main(String[] args) {
        RealSubject realSubject = new RealSubject();

        ProxySubject proxySubject = new ProxySubject(realSubject);

        proxySubject.visit();
    }
}

//抽象主题类
abstract class Suject {
    public abstract void visit();
}

//真实主题类
class RealSubject extends Suject {
    @Override
    public void visit() {
        System.out.println(" 真实主题");
    }
}

//代理类
class ProxySubject extends Suject {
    private RealSubject realSubject;

    public ProxySubject(RealSubject realSubject) {
        this.realSubject = realSubject;
    }

    @Override
    public void visit() {
        realSubject.visit();
    }
}