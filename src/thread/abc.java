package thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Auther: ys
 * @Date: 2023/3/6 - 03 - 06 - 17:27
 */
public class abc {
    static Lock a = new ReentrantLock();
    static String s = "a";
    public static void main(String[] args) {
        Condition condition1 = a.newCondition();
        Condition condition2 = a.newCondition();
        Condition condition3 = a.newCondition();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                a.lock();
                try{
                    while (!"a".equals(s)){
                        condition1.await();
                    }
                    System.out.println(s);
                    s = "b";
                    condition2.signal();
                }catch (Exception e){
                    e.printStackTrace();
                }finally {
                    a.unlock();
                }
            }

        }).start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                a.lock();
                try{
                    while (!"b".equals(s)){
                        condition2.await();
                    }
                    System.out.println(s);
                    s = "c";
                    condition3.signal();
                }catch (Exception e){
                    e.printStackTrace();
                }finally {
                    a.unlock();
                }
            }

        }).start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                a.lock();
                try{
                    while (!"c".equals(s)){
                        condition3.await();
                    }
                    System.out.println(s);
                    s = "a";
                    condition1.signal();
                }catch (Exception e){
                    e.printStackTrace();
                }finally {
                    a.unlock();
                }
            }

        }).start();
    }
}
