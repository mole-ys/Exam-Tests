package thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Auther: ys
 * @Date: 2023/3/23 - 03 - 23 - 21:15
 */
public class abc2 {

    public static Lock lock = new ReentrantLock();
    public static String str = "a";
    public static Condition a = lock.newCondition();
    public static Condition b = lock.newCondition();
    public static Condition c = lock.newCondition();

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                a();
            }).start();
        }

        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                b();
            }).start();
        }

        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                c();
            }).start();
        }
    }


    public static void a(){
        lock.lock();
        try {
            while (!str.equals("a")){
                a.await();
            }
            System.out.println(str);
            str = "b";
            b.signal();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public static void b(){
        lock.lock();
        try {
            while (!str.equals("b")){
                b.await();
            }
            System.out.println(str);
            str = "c";
            c.signal();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public static void c(){
        lock.lock();
        try {
            while (!str.equals("c")){
                c.await();
            }
            System.out.println(str);
            str = "a";
            a.signal();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}
