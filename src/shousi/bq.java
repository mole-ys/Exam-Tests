package shousi;

import java.util.LinkedList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Auther: ys
 * @Date: 2023/3/23 - 03 - 23 - 20:35
 */
public class bq {

    LinkedList<Integer> list;
    int capacity;
    int size;
    Lock lock;
    Condition full;
    Condition empty;

    public bq(int capacity){
        list = new LinkedList<>();
        size = 0;
        this.capacity = capacity;
        lock = new ReentrantLock();
        full = lock.newCondition();
        empty = lock.newCondition();
    }

    public void offer(int val) {
        lock.lock();
        try {
            list.offer(val);
            if(list.size() == capacity){
                full.await();
            }
            empty.signal();
        }catch (InterruptedException e) {
            throw new RuntimeException(e);
        }finally {
            lock.unlock();
        }
    }

    public int consume(){
        lock.lock();
        try {
            if(list.size() == 0){
                empty.await();
            }
            full.signal();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }finally {
            lock.unlock();
        }
        return list.poll();
    }
}

class test{
    public static void main(String[] args) {
        bq bq = new bq(3);


        new Thread(() -> {
            bq.offer(1);
            bq.offer(1);
            bq.offer(1);
            System.out.println("offer!");
            bq.offer(1);
            System.out.println("offer!");
            bq.offer(1);
            System.out.println("offer!");

            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("延迟offer！");
            bq.offer(1);
        }).start();

        new Thread(() -> {
            System.out.println(bq.consume() + "consume!!!");
            System.out.println(bq.consume() + "consume!!!");
            System.out.println(bq.consume() + "consume!!!");
            System.out.println(bq.consume() + "consume!!!");
            System.out.println(bq.consume() + "consume!!!");
            System.out.println(bq.consume() + "consume!!!");
            //System.out.println(bq.consume() + "consume!!!");
            //System.out.println(bq.consume() + "consume!!!");
            //System.out.println(bq.consume() + "consume!!!");
        }).start();
    }
}