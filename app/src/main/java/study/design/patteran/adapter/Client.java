package study.design.patteran.adapter;

/**
 * 适配器模式-的新用手的"粘合剂"
 * <p>
 * 把一个类的接口变换成客户端所期待的另一个接口，从而使原本因接口不匹配而无法在一起工作的两个类能够在一起工作。
 * <p>
 * Created by fengyulong on 2016/11/26.
 */

public class Client {
    public static void main(String[] args) {
        VoltAdapter adapter = new VoltAdapter();
        System.out.println("输出电压：" + adapter.getVolt5());
    }
}

//target角色
interface FiveVolt {
    public int getVolt5();
}

//需要被转换的对象
class Volt220 {
    public int getVolt220() {
        return 220;
    }
}

//adapter角色，将220v的电压转换为5V的电压
class VoltAdapter extends Volt220 implements FiveVolt {

    @Override
    public int getVolt5() {
        return 5;
    }
}