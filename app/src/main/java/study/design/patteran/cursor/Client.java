package study.design.patteran.cursor;

import java.util.ArrayList;
import java.util.List;

/**
 * 迭代器模式（游标模式
 * <p>
 * 提供一种方法顺序访问一个容器对象中的各个元素，而不需要暴露该对象的内部表示。
 * 相信熟悉Java的你肯定知道，Java中就有迭代器Iterator类，本质上说，它就是用迭代器模式。
 * Created by fengyulong on 2016/11/26.
 */

public class Client {

    public static void main(String[] args) {
        Aggregate<String> a = new ConcreteAggregate<>();
        a.add("Aige");
        a.add("Studio\n");
        a.add("SM");
        a.add(" Brother");
        Iterator<String> i = a.iterator();

        while (i.hanNext()) {
            System.out.println(i.next());
        }
    }
}

interface Iterator<T> {
    boolean hanNext();

    T next();
}

class ConcreteIterator<T> implements Iterator<T> {
    private List<T> list = new ArrayList<>();
    private int cursor = 0;

    public ConcreteIterator(List<T> list) {
        this.list = list;
    }

    @Override
    public boolean hanNext() {
        return cursor != list.size();
    }

    @Override
    public T next() {
        T object = null;
        if (this.hanNext()) {
            object = this.list.get(cursor++);
        }
        return object;
    }
}

interface Aggregate<T> {
    void add(T object);

    void remove(T object);

    Iterator<T> iterator();
}

class ConcreteAggregate<T> implements Aggregate<T> {
    private List<T> list = new ArrayList<>();

    @Override
    public void add(T object) {
        list.add(object);
    }

    @Override
    public void remove(T object) {
        list.remove(object);
    }

    @Override
    public Iterator iterator() {
        return new ConcreteIterator(list);
    }
}