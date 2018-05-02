package study.design.patteran.prototype;

import java.util.ArrayList;

/**
 * 原型模式-程序运行更高效
 * 1.原型设计模式非常简单，就是将一个对象进行拷贝。对于类A实例a，要对a进行拷贝，就是创建一个跟a一样的类型A的实例b，然后将a的属性全部复制到b。
 * 2.什么时候会用到原型模式呢？可以在类的属性特别多，但是又要经常对类进行拷贝的时候可以用原型模式，这样代码比较简洁，而且比较方便。
 * 3.另外要注意的是，还有深拷贝和浅拷贝。深拷贝就是把对象里面的引用的对象也要拷贝一份新的对象，并将这个新的引用对象作为拷贝的对象引用。说的比较绕哈~，
 * 4.举个例子，假设A类中有B类的引用b，现在需要对A类实例进行拷贝，那么深拷贝就是，先对b进行一次拷贝得到nb，然后把nb作为A类拷贝的对象的引用，如此一层一层迭代拷贝，
 * 把所有的引用都拷贝结束。浅拷贝则不是。
 * Created by fengyulong on 2016/11/26.
 */

public class WordDocument implements Cloneable {
    private String mText;
    private ArrayList<String> mImages = new ArrayList<>();

    public WordDocument() {
    }

    public String getmText() {
        return mText;
    }

    public void setmText(String mText) {
        this.mText = mText;
    }

    public ArrayList<String> getmImages() {
        return mImages;
    }

    public void addImage(String img) {
        this.mImages.add(img);
    }

    @Override
    protected WordDocument clone() {
        try {
            //调研native Clone 实现代码
            WordDocument doc = (WordDocument) super.clone();
            doc.mText = this.mText;
            doc.mImages = this.mImages;//浅拷贝
//            doc.mImages = (ArrayList<String>) this.mImages.clone();//深拷贝
            return doc;
        } catch (Exception e) {

        }
        return null;
    }

    public void showDocument(){
        System.out.println("-- Word Content start --");
        System.out.println("Text : " + mText);
        System.out.println("Images List : ");
        for (String imgName : mImages){
            System.out.println("image name : " + imgName);
        }
        System.out.println("-- Word Cotent end --");
    }
}
