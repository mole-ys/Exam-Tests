package threadlocal;

import java.util.concurrent.TimeUnit;

/**
 * @Auther: ys
 * @Date: 2023/3/3 - 03 - 03 - 16:17
 */
public class TestThreadLocal {

    public static void main(String[] args) {
        ThreadLocal<Integer> threadLocal1 = new ThreadLocal<>();
        threadLocal1.set(1);
        ThreadLocal<Integer> threadLocal2 = new ThreadLocal<>();
        threadLocal2.set(2);


        new Thread(() -> {

            //每一个线程可以复用threadLocal对象，存在自己的ThreadLocalMap里,和其他线程完全不影响
            threadLocal1.set(9999);
            System.out.println(threadLocal1.get());

            //threadLocal1.set(threadLocal2.get() + 1);
            //System.out.println("2222" + threadLocal1.get());
            //System.out.println("2222" + threadLocal2.get());
        },"t2").start();

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(threadLocal1.get());
        //System.out.println(threadLocal2.get());
    }
}
