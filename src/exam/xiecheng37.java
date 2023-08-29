package exam;

import java.util.*;

/**
 * @Auther: ys
 * @Date: 2023/3/7 - 03 - 07 - 18:30
 */
public class xiecheng37 {
    public static void main(String[] args) {

        t2();
    }

    public static void t4(){
        int n = 4;int x = 7;
        int[] price = {2, 2, 6, 2};
        int[] like = {3, 4, 5, 1};
        record = new ArrayList<>();
        set = new HashSet<>();
        backtrack(new ArrayList<>(), x, 0, price, false);
        System.out.println(record);
        int ans = 0;
        for (int i = 0; i < record.size(); i++) {
            List<Integer> list = record.get(i);
            int tmp = 0;
            for (int j = 0; j < list.size(); j++) {
                tmp += like[list.get(j)] ;
            }
            ans = Math.max(ans, tmp);
        }
        System.out.println(ans);
    }
    //flag true 表示半价买了当前这个
    static List<List<Integer>> record;
    static Set<List<Integer>> set;
    public static void backtrack(List<Integer> list, int money, int pos, int[] price, boolean flag){
        if(pos == price.length && !set.contains(list)){
            List<Integer> tmp = new ArrayList<>();
            set.add(tmp);
            record.add(tmp);
        }
        for (int i = pos; i < price.length; i++) {
            //必须之前那个不是半价买的
            if(money - (price[pos] / 2) >= 0 && !flag){
                list.add(pos);
                backtrack(list, money - (price[pos] / 2), i + 1, price, true);
                list.remove(list.size() - 1);

            }
            if(money - price[pos] >= 0){
                list.add(pos);
                backtrack(list, money - price[pos], i + 1, price, false);
                list.remove(list.size() - 1);
            }
            if(money > 0){
                backtrack(list, money, i + 1, price, false);
            }
        }


    }





    public static void t3(){
        int v0 = 0;int x = 1;int y = 2;
        //double t;double t2;
        double a = x;
        double b = v0;
        double c = y;


        double t2 = Math.sqrt(c * a);
        double t1 = (c - b * t2) / (a * t2);
        double minSum = t1 + t2;
        System.out.println("t1 + t2 = " + minSum);
    }


    public static void t2(){
        int n = 6;
        String s = "abcdef";
        s = expand(s, 2, 4);
        //System.out.println(s);
        s = expand(s, 3, 6);
        System.out.println(s);
    }
    public static String expand(String s, int left, int right){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i));
            if(i >= left - 1 && i <= right - 1){
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}
