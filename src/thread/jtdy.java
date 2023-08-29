package thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Auther: ys
 * @Date: 2023/8/28 - 08 - 28 - 10:21
 */
public class jtdy {
    static Lock lock = new ReentrantLock();
    static boolean flag = false;
    public static void main(String[] args) {
        Condition condition = lock.newCondition();
        new Thread(() -> {
            for (int i = 0; i < 100; i = i + 2) {
                lock.lock();
                try {
                    while(flag){
                        condition.await();
                    }
                    System.out.println(i);
                    flag = true;
                    condition.signal();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } finally {
                    lock.unlock();
                }
            }
        }).start();
        new Thread(() -> {
            for (int i = 1; i < 101; i = i + 2) {
                lock.lock();
                try {
                    while(!flag){
                        condition.await();
                    }
                    System.out.println(i);
                    flag = false;
                    condition.signal();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } finally {
                    lock.unlock();
                }

            }
        }).start();
    }
}
