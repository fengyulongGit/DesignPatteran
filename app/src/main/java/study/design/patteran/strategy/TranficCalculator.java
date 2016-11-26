package study.design.patteran.strategy;

/**
 * 公交出行价格计算器
 * <p>
 * 策略模式-时势造英雄
 * 1.有一系列的算法，将每个算法封装起来（每个算法可以封装到不同的类中），各个算法之间可以替换，策略模式让算法独立于使用它的客户而独立变化。
 * 2.你现在又很多排序算法：冒泡、希尔、归并、选择等等。我们要根据实际情况来选择使用哪种算法，
 * 3.有一种常见的方法是，通过if...else或者case...等条件判断语句来选择。但是这个类的维护成本会变高，维护时也容易发生错误。
 * Created by fengyulong on 2016/11/26.
 */

public class TranficCalculator {
    CalculateStrategy mStrategy;

    public void setStrategy(CalculateStrategy calculateStrategy) {
        this.mStrategy = calculateStrategy;
    }

    public int calculatePrice(int km) {
        return mStrategy.calculatePrice(km);
    }

    public static void main(String[] args) {

        TranficCalculator tranficCalculator = new TranficCalculator();
        tranficCalculator.setStrategy(new BusStrategy());
        System.out.println("公交车乘16公里的价格： " + tranficCalculator.calculatePrice(16));
    }
}
