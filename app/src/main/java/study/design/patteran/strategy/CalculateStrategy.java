package study.design.patteran.strategy;

/**
 * Created by fengyulong on 2016/11/26.
 */

public interface CalculateStrategy {
    /**
     * 按距离计算价格
     *
     * @param km 公里
     * @return 价格
     */
    int calculatePrice(int km);
}
