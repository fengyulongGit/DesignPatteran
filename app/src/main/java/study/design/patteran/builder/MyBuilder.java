package study.design.patteran.builder;

/**
 * Builder模式-自由扩展项目
 * 定义：将一个复杂对象的构建与它的表示分离，使得同样的构建过程可以创建不通的表示
 * 使用场景：
 * 1.相同的方法，不同的执行顺序，产生不同的事件结果时。
 * 2.多个部件或者零件，都可以装配到一个对象中，但是产生的运行结果又不相同时。
 * 3.产品类非常复杂，或则产品类中的调用顺序不同产生了不同的作用。
 * 4.当初始化一个对象特别复杂，如参数多，且很多参数都具有默认值时。
 * Created by fengyulong on 2016/6/16.
 */
public class MyBuilder {
    private int id;
    private String num;

    public MyData build() {
        MyData d = new MyData();
        d.setId(id);
        d.setNum(num);
        return d;
    }

    public MyBuilder setId(int id) {
        this.id = id;
        return this;
    }

    public MyBuilder setNum(String num) {
        this.num = num;
        return this;
    }

    public static void main(String[] args) {
        MyData d = new MyBuilder().setId(10).setNum("hc").build();
    }
}
