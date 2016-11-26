package study.design.patteran.flyweight;

import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 享元模式-对象共享，避免创建多对象
 * <p>
 * 使用享元对象有效地支持大量的细粒度对象。
 * <p>
 * 享元模式我们平时接触真的很多，比如Java中的常量池，线程池等。主要是为了重用对象。
 * Created by fengyulong on 2016/11/26.
 */

public class Client {
    public static void main(String[] args) {
        Ticket ticket1 = TicketFactory.getTicket("北京", "青岛");
        ticket1.showTicketInfo("上铺");

        Ticket ticket2 = TicketFactory.getTicket("北京", "青岛");
        ticket1.showTicketInfo("下铺");

        Ticket ticket3 = TicketFactory.getTicket("北京", "青岛");
        ticket1.showTicketInfo("坐票");
    }
}


//接口-展示车票信息
interface Ticket {
    public void showTicketInfo(String bunk);
}

//火车票
class TrainTicket implements Ticket {
    public String from;
    public String to;
    public String bunk;
    public int price;

    TrainTicket(String from, String to) {
        this.from = from;
        this.to = to;
    }

    @Override
    public void showTicketInfo(String bunk) {
        price = new Random().nextInt(300);
        System.out.println("购买从 " + from + " 到 " + to + " 的" + bunk + " 火车票， 价格：" + price);
    }
}

class TicketFactory {
    static Map<String, Ticket> ticketMap = new ConcurrentHashMap<>();

    public static Ticket getTicket(String from, String to) {
        String key = from + "-" + to;
        if (ticketMap.containsKey(key)) {
            System.out.println("使用缓存 ==>" + key);
            return ticketMap.get(key);
        } else {
            System.out.println("创建对象 ==>" + key);
            Ticket ticket = new TrainTicket(from, to);
            ticketMap.put(key, ticket);
            return ticket;
        }
    }
}