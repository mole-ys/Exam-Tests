package singlemode;

/**
 * @Auther: ys
 * @Date: 2023/3/9 - 03 - 09 - 15:04
 */
public class Lazy {

    private static volatile Lazy lazy;

    private Lazy(){
        System.out.println("jiazai");
    }

    static class get{
        static final Lazy lazy = new Lazy();
    }

    public static Lazy getInstance(){
        //if(lazy == null){
        //    synchronized (Lazy.class){
        //        if(lazy == null){
        //            lazy = new Lazy();
        //        }
        //    }
        //}
        return get.lazy;
    }
}

class Test{
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                Lazy lazy = Lazy.getInstance();
                System.out.println(lazy);
            }).start();
        }

    }
}
