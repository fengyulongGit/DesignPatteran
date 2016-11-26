package study.design.patteran.lod;

import java.util.ArrayList;
import java.util.List;

/**
 * 租房-更好的可扩展性
 * Created by fengyulong on 2016/6/16.
 */
public class Mediator1 {
    List<Room> mRooms = new ArrayList<Room>();

    public Mediator1() {
        //初始化数据
    }

    public Room rentRoom(float roomArea, float roomPrice) {
        for (Room room : mRooms) {
            if (isSuitable(room, roomArea, roomPrice)) {
                return room;
            }
        }
        return null;
    }

    private boolean isSuitable(Room room, float roomArea, float roomPrice) {
        return Math.abs(room.getPrice() - roomPrice) < Tenant1.diffPrice && Math.abs(room.getArea() - roomArea) < Tenant1.diffArea;
    }
}
