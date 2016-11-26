package study.design.patteran.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * 组合模式-物以类聚
 * <p>
 * 将对象组成成树形结构，以表示“部分-整体”的层次结构，使得用户对单个对象和组合对象的使用具有一致性。
 * <p>
 * 比如公司结构
 * Created by fengyulong on 2016/11/26.
 */

public class Client {
    public static void main(String[] args) {
        Component root = new Composite("Root");

        Component branch1 = new Composite("Branch1");
        Component branch2 = new Composite("Branch2");

        Component leaf1 = new Leaf("Leaf1");
        Component leaf2 = new Leaf("Leaf2");

        branch1.addChild(leaf1);
        branch2.addChild(leaf2);

        root.addChild(branch1);
        root.addChild(branch2);

        root.doSomething();
    }
}

//透明的组合模式抽象根节点
abstract class Component {

    protected String name;

    public Component(String name) {
        this.name = name;
    }

    public abstract void doSomething();

    public abstract void addChild(Component component);

    public abstract void removeChild(Component component);

    public abstract Component getChildren(int index);
}

//透明的组合模式具体枝干节点
class Composite extends Component {
    private List<Component> components = new ArrayList<>();

    public Composite(String name) {
        super(name);
    }

    @Override
    public void doSomething() {
        System.out.println(name);
        if (null != components) {
            for (Component component : components) {
                component.doSomething();
            }
        }
    }

    @Override
    public void addChild(Component component) {
        components.add(component);
    }

    @Override
    public void removeChild(Component component) {
        components.remove(component);
    }

    @Override
    public Component getChildren(int index) {
        return components.get(index);
    }
}

//透明的组合模式叶子节点
class Leaf extends Component {
    public Leaf(String name) {
        super(name);
    }

    @Override
    public void doSomething() {
        System.out.println(name);
    }

    @Override
    public void addChild(Component component) {
        throw new UnsupportedOperationException("叶子节点没有子节点");
    }

    @Override
    public void removeChild(Component component) {
        throw new UnsupportedOperationException("叶子节点没有子节点");
    }

    @Override
    public Component getChildren(int index) {
        throw new UnsupportedOperationException("叶子节点没有子节点");
    }
}