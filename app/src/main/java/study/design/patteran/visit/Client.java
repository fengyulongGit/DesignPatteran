package study.design.patteran.visit;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * 访问者模式
 * <p>
 * 封装一些作用于某种数据结构中各元素的操作，它可以在不改变这个数据结构的前提下定义作用于这些元素的新的操作。
 * 访问者模式是23种设计模式中最复杂的一个，但他的使用率并不高，大部分情况下，我们不需要使用访问者模式，少数特定的场景才需要。
 * Created by fengyulong on 2016/11/26.
 */

public class Client {
    public static void main(String[] args) {
        BusinessReport businessReport = new BusinessReport();
        System.out.println("======= 给CEO看的报表 =======");
        businessReport.showRepore(new CEOVisitor());
        System.out.println("\n======= 给TEO看的报表 =======");
        businessReport.showRepore(new CTOVisitor());
    }
}

//员工基类
abstract class Staff {
    public String name;

    public int kpi;

    public Staff(String name) {
        this.name = name;
        kpi = new Random().nextInt(10);
    }

    public abstract void accept(Visitor visitor);
}

//工程师
class Engineer extends Staff {
    public Engineer(String name) {
        super(name);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public int getCodeLines() {
        return new Random().nextInt(10 * 10000);
    }
}

//经理
class Manager extends Staff {
    private int procucts;

    public Manager(String name) {
        super(name);
        procucts = new Random().nextInt(10);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public int getProcucts() {
        return procucts;
    }
}

//分别对工程师和经idea访问函数
interface Visitor {
    public void visit(Engineer engineer);

    public void visit(Manager manager);
}

//员工业务报表
class BusinessReport {
    List<Staff> staffs = new LinkedList<>();

    public BusinessReport() {
        staffs.add(new Manager("王经理"));
        staffs.add(new Engineer("工程师张三"));
        staffs.add(new Engineer("工程师李四"));
        staffs.add(new Engineer("工程师王五"));
        staffs.add(new Engineer("工程师赵六"));
    }

    public void showRepore(Visitor visitor) {
        for (Staff staff : staffs) {
            staff.accept(visitor);
        }
    }
}

//CEO，只关注业绩
class CEOVisitor implements Visitor {
    @Override
    public void visit(Engineer engineer) {
        System.out.println("工程师：" + engineer.name + ", KPI :" + engineer.kpi);
    }

    @Override
    public void visit(Manager manager) {
        System.out.println("经理：" + manager.name + ", KPI：" + manager.kpi + ", 新产品数量：" + manager.getProcucts());
    }
}

//CTO，只关注业绩
class CTOVisitor implements Visitor {
    @Override
    public void visit(Engineer engineer) {
        System.out.println("工程师：" + engineer.name + ", 代码行数 :" + engineer.getCodeLines());
    }

    @Override
    public void visit(Manager manager) {
        System.out.println("经理：" + manager.name + ", 新产品数量：" + manager.getProcucts());
    }
}