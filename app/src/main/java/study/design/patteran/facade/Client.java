package study.design.patteran.facade;

/**
 * 外观模式-统一编程接口
 * <p>
 * 要求一个子系统的外部与其内部的通信必须通过一个统一的对象进行。
 * <p>
 * 怎么理解呢，举个例子，我们在启动计算机时，只需按一下开关键，
 * 无需关系里面的磁盘、内存、cpu、电源等等这些如何工作，我们只关心他们帮我启动好了就行。
 * 实际上，由于里面的线路太复杂，我们也没办法去具体了解内部电路如何工作。主机提供唯一一个接口“开关键”给用户就好。
 * 外观模式在开发过程中运用频率非常高，尤其是各种第三方SDK接入，如网络模块
 * 在开发中运用过无数次，只是没有在层面上认识
 * Created by fengyulong on 2016/11/26.
 */

public class Client {
    public static void main(String[] args) {
        MobilePhone mobilePhone = new MobilePhone();
        mobilePhone.takePicture();
        mobilePhone.videoChat();
    }
}

interface Phone {
    public void dail();

    public void hangup();
}

class PhoneImpl implements Phone {
    @Override
    public void dail() {
        System.out.println("打电话");
    }

    @Override
    public void hangup() {
        System.out.println("挂断");
    }
}

interface Camera {
    public void open();

    public void takePicture();

    public void close();
}

class SamsungCamera implements Camera {
    @Override
    public void open() {
        System.out.println("打开相机");
    }

    @Override
    public void takePicture() {
        System.out.println("拍照");
    }

    @Override
    public void close() {
        System.out.println("关闭相机");
    }
}

class MobilePhone {
    private Phone phone = new PhoneImpl();
    private Camera camera = new SamsungCamera();

    public void dail() {
        phone.dail();
    }

    public void videoChat() {
        System.out.println("--> 视频聊天通话中");
        camera.open();
        phone.dail();
    }

    public void hangup() {
        phone.hangup();
    }

    public void takePicture() {
        camera.open();
        camera.takePicture();
    }

    public void closeCamera() {
        camera.close();
    }
}