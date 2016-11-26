package study.design.patteran.observer;

import java.util.Observable;
import java.util.Observer;

/**
 * 观察者模式-解决、解耦的钥匙
 * <p>
 * 1.定义了对象之间的一对多的关系，其实就是1对n，当“1”发生变化时，“n”全部得到通知，并更新。
 * 2.观察者模式一个比较经典的应用就是：订阅——发布系统。很容易理解，发布消息时，将消息发送给每个订阅者。我们常用的微信公众号就是典型，
 * 3.当我们关注某个公众号时，每当公众号推送消息时，我们就会去接收到消息，当然了，每个订阅（关注）公众号的的人都能接收到公众号推送的消息。
 * Created by fengyulong on 2016/11/26.
 */

public class Client {
    public static void main(String[] args) {
        DevTechFrontier devTechFrontier = new DevTechFrontier();

        Coder mrsimple = new Coder("mr.simple");
        Coder coder1 = new Coder("coder-1");
        Coder coder2 = new Coder("coder-2");
        Coder coder3 = new Coder("coder-3");

        devTechFrontier.addObserver(mrsimple);
        devTechFrontier.addObserver(coder1);
        devTechFrontier.addObserver(coder2);
        devTechFrontier.addObserver(coder3);

        devTechFrontier.postNewPublication("新的一期开发技术前线周报发布啦！");
    }
}

/**
 * 程序员是观察者
 */
class Coder implements Observer {
    public String name;

    public Coder(String name) {
        this.name = name;
    }

    @Override
    public void update(Observable observable, Object data) {
        System.out.println("Hi, " + name + ", DevTechFrontier 更新啦，内容 ： " + data);
    }

    @Override
    public String toString() {
        return "码农： " + name;
    }
}

/**
 * 有更新是所有的观察者都会接到相应的通知
 */
class DevTechFrontier extends Observable {

    public void postNewPublication(String content) {
        setChanged();
        notifyObservers(content);
    }
}