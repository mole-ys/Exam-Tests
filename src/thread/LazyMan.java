package thread;

/**
 * @Auther: ys
 * @Date: 2023/2/25 - 02 - 25 - 21:32
 */
public class LazyMan {

    private static volatile LazyMan lazyMan;

    private static int num = 0;

    private LazyMan(){
        System.out.println("初始化");
        System.out.println(++num);
    }

    public static LazyMan getInstance(){
        if(lazyMan == null){
            synchronized (LazyMan.class){
                if(lazyMan == null){
                    lazyMan = new LazyMan();
                }
            }
        }
        return lazyMan;
    }
}
class test{
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                LazyMan lazyMan = LazyMan.getInstance();
                //System.out.println(lazyMan);
            }).start();
        }
    }
}
