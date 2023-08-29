package thread;

import java.util.concurrent.TimeUnit;

/**
 * @Auther: ys
 * @Date: 2023/2/28 - 02 - 28 - 18:48
 */
public class Dead2 {
    public final static String a = "1";
    public final static String b = "2";


    public static void main(String[] args) {
        new Thread(() -> {
            synchronized (a){
                System.out.println(Thread.currentThread().getName() + "获取到a");
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                synchronized (b){
                    System.out.println(Thread.currentThread().getName() + "获取到b");
                }
            }
        }, "A").start();

        new Thread(() -> {
            synchronized (b){
                System.out.println(Thread.currentThread().getName() + "获取到b");
                synchronized (a){
                    System.out.println(Thread.currentThread().getName() + "获取到a");
                }
            }
        }, "B").start();


    }

}
