package singlemode;

/**
 * @Auther: ys
 * @Date: 2023/3/23 - 03 - 23 - 21:09
 */
public class Lazy3 {

    private static volatile Lazy3 lazy;

    private Lazy3(){
        System.out.println("csh");
    }

    public static Lazy3 getInstance(){
        //if(lazy == null){
        //    synchronized (Lazy3.class){
        //        if(lazy == null){
        //            lazy = new Lazy3();
        //        }
        //    }
        //}
        return a.lazy3;
    }

    static class a{
        public static Lazy3 lazy3 = new Lazy3();
    }
}

class test4{
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                System.out.println(Lazy3.getInstance());
            }).start();
        }
    }
}
