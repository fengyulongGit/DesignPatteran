package study.design.patteran.interpreter;

import java.util.Stack;

/**
 * 解释器模式-化繁为简的翻译机
 * <p>
 * 1.给定一个语言，定义它的语法，并定义一个解释器，这个解释器用于解析语言
 * 2.从定义中看起来比较抽象，其实，很简单，很容易理解！就是相当于自定义一个格式的文件，然后去解析它。不用理解的那么复杂！
 * Created by fengyulong on 2016/11/26.
 */

public class Client {
    public static void main(String[] args) {
        Calculator calculator = new Calculator("153 + 3589 + 118 - 555 - 597 - 66");
        System.out.println(calculator.calculate());
    }
}

abstract class ArithmeticExpression {
    /**
     * 抽象的解析方法
     * 具体的解析逻辑由具体的子类实现
     *
     * @return 解析得到具体的值
     */
    public abstract int interpret();
}

/**
 * 数字解析器-仅仅为了解释数字
 */
class NumExpression extends ArithmeticExpression {

    private int num;

    public NumExpression(int num) {
        this.num = num;
    }

    @Override
    public int interpret() {
        return num;
    }
}

/**
 * 运算符号抽象解析器-为所有运算符号解析器共性的提取
 */
abstract class OperatorExpression extends ArithmeticExpression {
    protected ArithmeticExpression expression1, expression2;

    public OperatorExpression(ArithmeticExpression expression1, ArithmeticExpression expression2) {
        this.expression1 = expression1;
        this.expression2 = expression2;
    }
}

/**
 * 加法运算
 */
class AdditionExpression extends OperatorExpression {
    public AdditionExpression(ArithmeticExpression expression1, ArithmeticExpression expression2) {
        super(expression1, expression2);
    }

    @Override
    public int interpret() {
        return expression1.interpret() + expression2.interpret();
    }
}

class SubtractionExpression extends OperatorExpression {
    public SubtractionExpression(ArithmeticExpression expression1, ArithmeticExpression expression2) {
        super(expression1, expression2);
    }

    @Override
    public int interpret() {
        return expression1.interpret() - expression2.interpret();
    }
}

class Calculator {
    private Stack<ArithmeticExpression> expressionStack = new Stack<>();

    public Calculator(String expression) {
        ArithmeticExpression expression1, expression2;

        String[] elements = expression.split(" ");

        for (int i = 0; i < elements.length; i++) {

            switch (elements[i].charAt(0)) {
                case '+': {
                    expression1 = expressionStack.pop();
                    expression2 = new NumExpression(Integer.valueOf(elements[++i]));

                    expressionStack.push(new AdditionExpression(expression1, expression2));
                    break;
                }
                case '-': {
                    expression1 = expressionStack.pop();
                    expression2 = new NumExpression(Integer.valueOf(elements[++i]));
                    expressionStack.push(new SubtractionExpression(expression1, expression2));
                    break;
                }
                default: {
                    expressionStack.push(new NumExpression(Integer.valueOf(elements[i])));
                    break;
                }
            }
        }
    }

    public int calculate() {
        return expressionStack.pop().interpret();
    }
}