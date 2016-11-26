package study.design.patteran.templatemethod;

/**
 * 模板方法模式-抓住问题核心
 * <p>
 * 定义一个操作中的算法框架，而将一些步骤延迟到子类中，使得子类可以不改变一个算法的结构即可重定义该算法的某些特定的步骤。
 * <p>
 * Created by fengyulong on 2016/11/26.
 */

public class Client {
    public static void main(String[] args) {
        AbstractComputer computer = new CoderComputer();
        computer.startUp();

        computer = new MilitaryComputer();
        computer.startUp();
    }
}

abstract class AbstractComputer {
    protected void powerOn() {
        System.out.println("开启电源");
    }

    protected void checkHardware() {
        System.out.println("硬件检查");
    }

    protected void loadOS() {
        System.out.println("载入操作系统");
    }

    protected void login() {
        System.out.println("小白的计算机无验证，直接进入系统");
    }

    public final void startUp() {
        System.out.println("---- 开机 START ----");
        powerOn();
        checkHardware();
        loadOS();
        login();
        System.out.println("---- 开机 END ----");
    }
}

class CoderComputer extends AbstractComputer {
    @Override
    protected void login() {
        System.out.println("程序员只需要进行用户和密码验证就可以了");
    }
}

class MilitaryComputer extends AbstractComputer {

    @Override
    protected void checkHardware() {
        super.checkHardware();
        System.out.println("检查硬件防火墙");
    }

    @Override
    protected void login() {
        System.out.println("进行指纹识别等复杂的用户验证");
    }
}