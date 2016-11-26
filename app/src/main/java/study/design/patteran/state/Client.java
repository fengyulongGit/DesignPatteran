package study.design.patteran.state;

/**
 * 状态模式-随遇而安
 * <p>
 * 1.状态模式中，行为是由状态来决定的，不同状态下有不同行为。状态模式和策略模式的结构几乎是一模一样的，主要是他们表达的目的和本质是不同。
 * 2.状态模式的行为是平行的、不可替换的，策略模式的行为是彼此独立可相互替换的。
 * 3.举个例子把，比如电视，电视有2个状态，一个是开机，一个是关机，开机时可以切换频道，关机时切换频道不做任何响应。
 * Created by fengyulong on 2016/11/26.
 */

public class Client {
    public static void main(String[] args) {
        TvController tvController = new TvController();
        tvController.powerOn();
        tvController.nextChannel();
        tvController.turnUp();

        tvController.powerOff();
        //调高音量，此时不会生效
        tvController.turnUp();
    }
}

interface TvState {
    public void nextChannel();

    public void prevChannel();

    public void turnUp();

    public void turnDown();
}

class PowerOffState implements TvState {
    public void nextChannel() {
    }

    public void prevChannel() {
    }

    public void turnUp() {
    }

    public void turnDown() {
    }

}


class PowerOnState implements TvState {
    public void nextChannel() {
        System.out.println("下一频道");
    }

    public void prevChannel() {
        System.out.println("上一频道");
    }

    public void turnUp() {
        System.out.println("调高音量");
    }

    public void turnDown() {
        System.out.println("调低音量");
    }

}

interface PowerController {
    public void powerOn();

    public void powerOff();
}

class TvController implements PowerController {
    TvState mTvState;

    public void setTvState(TvState tvState) {
        mTvState = tvState;
    }

    public void powerOn() {
        setTvState(new PowerOnState());
        System.out.println("开机啦");
    }

    public void powerOff() {
        setTvState(new PowerOffState());
        System.out.println("关机啦");
    }

    public void nextChannel() {
        mTvState.nextChannel();
    }

    public void prevChannel() {
        mTvState.prevChannel();
    }

    public void turnUp() {
        mTvState.turnUp();
    }

    public void turnDown() {
        mTvState.turnDown();
    }

}