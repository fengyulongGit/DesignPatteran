package study.design.patteran.strategy;

/**
 * 公交车价格计算策略
 * Created by fengyulong on 2016/11/26.
 */

public class BusStrategy implements CalculateStrategy {

    /**
     * 公交车，十公里之内一元，超过十公里之后每加一元可以乘坐5公里
     *
     * @param km 公里
     * @return 价格
     */
    @Override
    public int calculatePrice(int km) {
        //超过10公里的总距离
        int extraTotal = km - 10;

        //超过的距离是5公里的倍数
        int extraFactor = extraTotal / 5;

        //超过的距离对5公里取余
        int fraction = extraTotal % 5;

        //价格计算
        int price = 1 + extraFactor;
        return fraction > 0 ? ++price : price;
    }
}
