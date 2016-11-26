package study.design.patteran.iterator;

/**
 * 责任链模式-使编程更有灵活性
 * 1.使多个对象都有机会处理请求，从而避免请求的发送者和接受者直接的耦合关系，将这些对象连成一条链，并沿这条链传递该请求，直到有对象处理它为止。
 * Created by fengyulong on 2016/11/26.
 */

public class Client {
    public static void main(String[] args) {
        //构造各个领导对象
        GroupLeader groupLeader = new GroupLeader();
        Director director = new Director();
        Manager manager = new Manager();
        Boss boss = new Boss();

        //设置上一级领导处理者对象
        groupLeader.nextHandler = director;
        director.nextHandler = manager;
        manager.nextHandler = boss;

        //发起报账申请
        groupLeader.handleRequest(50000);
    }
}

abstract class Leader {
    protected Leader nextHandler;//上一级领导处理者

    public final void handleRequest(int money) {
        if (money < limit()) {
            handle(money);
        } else {
            if (null != nextHandler) {
                nextHandler.handleRequest(money);
            }
        }
    }

    public abstract int limit();

    public abstract void handle(int money);
}

class GroupLeader extends Leader {
    @Override
    public int limit() {
        return 1000;
    }

    @Override
    public void handle(int money) {
        System.out.println("组长批复报销" + money + "元");
    }
}

class Director extends Leader {
    @Override
    public int limit() {
        return 5000;
    }

    @Override
    public void handle(int money) {
        System.out.println("主管批复报销" + money + "元");
    }
}

class Manager extends Leader {
    @Override
    public int limit() {
        return 10000;
    }

    @Override
    public void handle(int money) {
        System.out.println("经理批复报销" + money + "元");
    }
}

class Boss extends Leader {
    @Override
    public int limit() {
        return Integer.MAX_VALUE;
    }

    @Override
    public void handle(int money) {
        System.out.println("老板批复报销" + money + "元");
    }
}