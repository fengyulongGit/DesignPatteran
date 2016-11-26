package study.design.patteran.memento;

/**
 * 备忘录模式-编程中的"后悔药"
 * <p>
 * 在不破坏封闭的前提下，捕获一个对象的内部状态，并在对象之外保存这个状态，这样，以后就可将对象恢复到原先保存的状态中。
 * 其实就是相当于一个提前备份，一旦出现啥意外，能够恢复。像我们平时用的word软件，意外关闭了，它能帮我们恢复。其实就是它自动帮我们备份过。
 * Created by fengyulong on 2016/11/26.
 */

public class Client {
    public static void main(String[] args) {
        CallOfDuty game = new CallOfDuty();
        game.play();

        Caretaker caretaker = new Caretaker();
        caretaker.archive(game.createMemoto());
        game.quit();

        CallOfDuty newGame = new CallOfDuty();
        newGame.restore(caretaker.getMemoto());
    }
}

class CallOfDuty {
    private int mCheckpoint = 1;
    private int mLifeValue = 100;
    private String mWeapon = "沙漠之鹰";

    public void play() {
        System.out.println("玩游戏：" + String.format("第%d关", mCheckpoint) + "奋战杀敌中");
        mLifeValue -= 10;
        System.out.println("进度升级啦");
        mCheckpoint++;
        System.out.println("到达" + String.format("第%d关", mCheckpoint));
    }

    public void quit() {
        System.out.println("----------");
        System.out.println("推出前的游戏属性：" + this.toString());
        System.out.println("退出游戏");
        System.out.println("----------");
    }

    public Memoto createMemoto() {
        Memoto memoto = new Memoto();
        memoto.mCheckpoint = mCheckpoint;
        memoto.mLiftValue = mLifeValue;
        memoto.mWeapon = mWeapon;
        return memoto;
    }

    public void restore(Memoto memoto) {
        this.mCheckpoint = memoto.mCheckpoint;
        this.mLifeValue = memoto.mLiftValue;
        this.mWeapon = memoto.mWeapon;
        System.out.println("回复有的游戏属性：" + this.toString());
    }

    @Override
    public String toString() {
        return "CallOfDuty [mCheckpoint=" + mCheckpoint + ", mLifeValue=" + mLifeValue + ", mWeapon=" + mWeapon + "]";
    }
}

class Memoto {
    public int mCheckpoint;
    public int mLiftValue;
    public String mWeapon;

    @Override
    public String toString() {
        return "Memoto [mCheckpoint=" + mCheckpoint + ", mLifeValue=" + mLiftValue + ", mWeapon=" + mWeapon + "]";
    }
}

class Caretaker {
    Memoto memoto;

    public void archive(Memoto memoto) {
        this.memoto = memoto;
    }

    public Memoto getMemoto() {
        return memoto;
    }
}