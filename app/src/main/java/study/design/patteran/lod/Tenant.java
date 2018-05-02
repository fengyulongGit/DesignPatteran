package study.design.patteran.lod;

import java.util.List;

/**
 * Created by fengyulong on 2016/6/16.
 */
public class Tenant {
    public float roomArea;
    public float roomPrice;
    public static final float diffPrice = 100.0001f;
    public static final float diffArea = 0.00001f;

    public void rentRoom(Mediator mediator) {
        List<Room> rooms = mediator.getAllRooms();
        for (Room room : rooms) {
            if (isSuitable(room)) {
                System.out.println("租到房间啦！" + room);
                break;
            }
        }
    }

    //可以拓展到用户类，实现自定义条件
    private boolean isSuitable(Room room) {
        return Math.abs(room.getPrice() - roomPrice) < diffPrice && Math.abs(room.getArea() - roomArea) < diffArea;
    }

    //这种设计，不仅依赖了Mediator类，还频繁的和Room打交道，弱化了中介类的功能，还导致租户和房间的耦合很高，三个类纠缠不清
}
