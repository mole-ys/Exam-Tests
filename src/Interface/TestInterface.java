package Interface;

import javax.annotation.Resource;
import java.lang.annotation.Annotation;
import java.lang.annotation.Target;
import java.lang.reflect.AnnotatedType;
import java.sql.SQLOutput;
import java.util.ArrayDeque;
import java.util.Arrays;

/**
 * @Auther: ys
 * @Date: 2023/2/21 - 02 - 21 - 23:19
 *
 * 随便瞎写，想到哪写哪
 *
 * 几个发现：
 * 1、接口中的静态方法必须有body
 * 2、接口中成员变量的public static 可省略，类的public abstract可省略
 * 3、抽象类权限修饰符不写默认是是public类型的...
 * 4、接口中的静态成员变量只能 接口.变量名 获得
 */
public interface TestInterface {

    public static int a = 0;

    default void interfaceMethod(){
        System.out.println("接口中的默认方法！");
    }

    public abstract int add();

    public static int s(){
        System.out.println("这是接口中的静态方法！");
        return 0;
    }
}

abstract class testAbstract{
    int b = 9;

    public void method(){
        System.out.println("抽象类中的实现了的方法！");
    }

    public abstract void method2();
}

class good extends testAbstract implements TestInterface{

    @Override
    public void method2() {
        System.out.println("override了抽象类中的抽象方法!");
    }


    public static void main(String[] args) throws ClassNotFoundException {
        System.out.println(TestInterface.a);
        good good = new good();

        good.method2();
        good.method();
        good.interfaceMethod();
        System.out.println(TestInterface.s());

        Class clazz = Class.forName("Interface.testAbstract");
        Annotation[] annotations = clazz.getAnnotations();
        System.out.println(Arrays.toString(annotations));
    }

    @Override
    public int add() {
        return 0;
    }
}
