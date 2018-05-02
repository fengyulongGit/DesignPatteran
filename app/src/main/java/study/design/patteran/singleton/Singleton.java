package study.design.patteran.singleton;

/**
 * 单例模式-应用最广的模式
 * 定义：确保只有一个实例，而且自行实例化并向整个系统提供这个实例
 * 使用场景：避免多个对象消耗过多的资源(IO/数据库等)，或者某种类型的对象有且只有一个(用户信息/系统配置等)
 * Created by fengyulong on 2016/6/12.
 */
public class Singleton {
    private volatile static Singleton instance;//volatile 用来修饰被不同线程访问和修改的变量

    //将默认的构造函数私有化，防止其他类手动new
    private Singleton() {
    }

    public static Singleton getInstance() {
        //Double check
        if (instance == null) {
            synchronized (Singleton.class) {//保证线程安全，避免放在getInstance()进行同步索
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
