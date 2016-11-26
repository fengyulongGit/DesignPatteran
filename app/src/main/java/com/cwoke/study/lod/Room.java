package com.cwoke.study.lod;

/**
 * 房间
 * Created by COOLWEN on 2016/6/16.
 */
public class Room {
    private float area;
    private float price;

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getArea() {
        return area;
    }

    public void setArea(float area) {
        this.area = area;
    }

    @Override
    public String toString() {
        return "Room [area=" + area + ", price=" + price + "]";
    }
}
