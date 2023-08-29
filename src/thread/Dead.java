package thread;

/**
 * @Auther: ys
 * @Date: 2023/2/25 - 02 - 25 - 20:58
 */
public class Dead {
    public static void main(String[] args) {
        String lockA = "A";
        String lockB = "B";
        new Thread(() -> {
            synchronized (lockA){
                System.out.println("拿到lockA");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                synchronized (lockB){
                    System.out.println("拿到lockB");
                }
            }
        }).start();
        new Thread(() -> {
            synchronized (lockB){
                System.out.println("拿到lockB");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                synchronized (lockA){
                    System.out.println("拿到lockA");
                }
            }
        }).start();
    }

}
