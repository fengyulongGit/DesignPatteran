package study.design.patteran.lod;

/**
 * Created by fengyulong on 2016/6/16.
 */
public class Tenant1 {
    public float roomArea;
    public float roomPrice;
    public static final float diffPrice = 100.0001f;
    public static final float diffArea = 0.00001f;

    public void rentRoom(Mediator1 mediator1) {
        System.out.println("租到房间啦！" + mediator1.rentRoom(roomArea, roomPrice));
    }

    //这种设计，就是迪米特原则，只与直接的朋友通信。
}
