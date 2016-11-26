package study.design.patteran.prototype;

/**
 * Created by fengyulong on 2016/11/26.
 */

public class Client {

    public static void main(String[] args) {
        easyDemo();


    }

    /**
     * 简单示例
     */
    private static void easyDemo() {
        WordDocument originDoc = new WordDocument();
        originDoc.setmText("这是一篇文档");
        originDoc.addImage("图片1");
        originDoc.addImage("图片2");
        originDoc.addImage("图片3");
        originDoc.showDocument();

        WordDocument copyDoc = originDoc.clone();
        copyDoc.showDocument();

        copyDoc.setmText("这是修改过的 Copy文本");
        copyDoc.showDocument();

        originDoc.showDocument();
    }

    /**
     * 深拷贝示例
     */
    private static void deepCopyDemo(){
        WordDocument originDoc = new WordDocument();
        originDoc.setmText("这是一篇文档");
        originDoc.addImage("图片1");
        originDoc.addImage("图片2");
        originDoc.addImage("图片3");
        originDoc.showDocument();

        WordDocument copyDoc = originDoc.clone();
        copyDoc.showDocument();

        copyDoc.setmText("这是修改过的 Copy文本");
        copyDoc.addImage("图片4.jpg");
        copyDoc.showDocument();

        originDoc.showDocument();
    }
}
