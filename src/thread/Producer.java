package thread;

import java.util.concurrent.TimeUnit;

/**
 * @Auther: ys
 * @Date: 2023/2/26 - 02 - 26 - 9:42
 */
public class Producer {

    int num = 0;

    public synchronized void produce() throws InterruptedException {
        while (num != 0){
            this.wait();
        }
        TimeUnit.SECONDS.sleep(1);
        System.out.println(++num);
        this.notifyAll();
    }

    public synchronized void consume() throws InterruptedException {
        while (num == 0){
            this.wait();
        }
        System.out.println(--num);
        this.notifyAll();
    }
}

class test3{
    public static void main(String[] args) {
        Producer producer = new Producer();
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                try {
                    producer.produce();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }).start();
        }

        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                try {
                    producer.consume();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }).start();
        }
    }
}
