package study.design.patteran.builder;

/**
 * 实体
 * Created by fengyulong on 2016/6/16.
 */
public class MyData {

    private int id;
    private String num;

    public void Test() {

    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNum(String num) {
        this.num = num + id;//特殊处理
    }
}
