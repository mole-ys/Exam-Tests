package singlemode;

import javax.xml.transform.Source;
import java.util.Arrays;
import java.util.HashMap;

/**
 * @Auther: ys
 * @Date: 2023/3/9 - 03 - 09 - 15:11
 */
public class Hungry {

    private static final Hungry HUNGRY = new Hungry();

    private Hungry(){
        System.out.println("jiazai");
    }

    public static Hungry getInstance(){
        return HUNGRY;

    }
}

class Test2{
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                System.out.println(Hungry.getInstance());
            }).start();
        }
        int a = 11111;

    }
}
