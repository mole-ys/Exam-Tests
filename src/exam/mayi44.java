package exam;

import java.util.HashMap;

/**
 * @Auther: ys
 * @Date: 2023/4/4 - 04 - 04 - 18:55
 */
public class mayi44 {
    public static void main(String[] args) {
        t3();
    }

    public static void t1(){
        int n = 5;
        String str = "HLHHL";
        int q = 3;
        for (int i = 0; i < q; i++) {
            int x = 1;
            int y = 2;
            boolean flag = false;
            if(str.charAt(x - 1) == 'H'){
                flag = true;
            }
            if(flag){
                if(str.charAt(y - 1) == 'L'){
                    System.out.println("liar");
                }else{
                    System.out.println("honester");
                }
            }else{
                System.out.println(str.charAt(y - 1) == 'H' ? "liar" : "honester");
            }
        }
    }

    public static void t2(){

    }

    public static void t3(){
        long l = 15;
        long r = 21;
        long k = 4;


        HashMap<Long, Boolean> record = new HashMap<>();
        int time = 0;
        long sum = 1;
        record.put(1L, true);
        long tmp = 1;
        int len = 0;
        for (int i = 0; i <= r; i++) {
            if(sum >= i){
                if(record.containsKey(i - tmp)){
                    if(i >= l && i <= r){len++;}
                    record.put((long)i, true);
                }
            }else{
                time++;
                tmp *= k;
                record.put(tmp, true);
                sum += tmp;
                if(tmp >= l && tmp <= r){len++;}
            }
        }
        System.out.println(len);
    }


    public static void t32(){
        long l = 15;
        long r = 21;
        long k = 4;

        boolean[] dp = new boolean[(int) r];

    }
}
