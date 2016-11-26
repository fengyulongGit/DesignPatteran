package com.cwoke.study.lod;

import java.util.ArrayList;
import java.util.List;

/**
 * 租房
 * Created by COOLWEN on 2016/6/16.
 */
public class Mediator {
    List<Room> mRooms = new ArrayList<Room>();

    public Mediator() {
        //初始化数据
    }

    public List<Room> getAllRooms() {
        return mRooms;
    }
}
