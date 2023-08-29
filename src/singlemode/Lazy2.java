package singlemode;

/**
 * @Auther: ys
 * @Date: 2023/2/25 - 02 - 25 - 22:10
 */
public class Lazy2 {

    private Lazy2(){
        System.out.println("初始化");
    }

    public static Lazy2 getInstance(){
        return create.lazy2;
    }

    public static class create{
        private static final Lazy2 lazy2 = new Lazy2();
    }
}

class test2{
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                Lazy2 lazy2 = Lazy2.getInstance();
                //System.out.println(lazyMan);
            }).start();
        }
    }
}
