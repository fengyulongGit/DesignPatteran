package study.design.patteran.command;

/**
 * 命令模式-让程序畅通执行
 * <p>
 * 命令模式将每个请求封装成一个对象，从而让用户使用不同的请求把客户端参数化；将请求进行排队或者记录请求日志，以及支持可撤销操作。
 * 1.当我们点击“关机”命令，系统会执行一系列操作，
 * 2.比如暂停事件处理、保存系统配置、结束程序进程、调用内核命令关闭计算机等等，这些命令封装从不同的对象，然后放入到队列中一个个去执行，还可以提供撤销操作。
 * Created by fengyulong on 2016/11/26.
 */

public class Client {
    public static void main(String[] args) {
        Receiver receiver = new Receiver();

        Command command = new ConcreteCommand(receiver);

        Invoker invoker = new Invoker(command);

        invoker.action();
    }

    //总体并不难，只是相对比较繁琐，一个简单的调用关系被解耦成多个部分，一定会增加类的复杂度，但是即便如此，命令模式的结构依然清晰
    //调用逻辑做的如此复杂，是因为开发起来方便，每次增加或者修改功能只需要修改Receiver和Client酒可以了
    //如果开发者不再负责这个项目了，这样的逻辑留给后来者，没人会金额的方便。
    //设计模式由一条重要的原则：对修改的关闭对扩展的开放，大家可以细细体会.
}

/**
 * 接受者
 */
class Receiver {
    public void action() {
        System.out.println("执行具体操作");
    }
}

/**
 * 抽象命令接口
 */
interface Command {
    void execute();
}

/**
 * 具体命令
 */
class ConcreteCommand implements Command {
    private Receiver receiver;

    public ConcreteCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.action();
    }
}

/**
 * 请求者
 */
class Invoker {
    private Command command;

    public Invoker(Command command) {
        this.command = command;
    }

    public void action() {
        command.execute();
    }
}