package exam;

import com.sun.javafx.robot.FXRobotImage;

import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @Auther: ys
 * @Date: 2023/3/11 - 03 - 11 - 18:47
 */
public class meituan311 {
    public static void main(String[] args) {
        t3();
    }

    public static void t1(){
        String s = "111222333";
        int count = 0;
        for (int i = 1; i < s.length(); i++) {
            if(s.charAt(i) == s.charAt(i - 1)){
                count++;
                i++;
            }
        }
        System.out.println(count);
    }

    //输入样例2
    //
    //3 3 3
    //
    //BBR
    //
    //BRB
    //
    //RBB
    //
    //0 1 10
    //
    //2 10 100
    //
    //10 100 100
    //
    //输出样例2
    //
    //2
    public static void t2(){
        //n = 3; m = 3;k = 3;
        n = 1; m = 7;k = 2;
        //String[] colors = {"BBR", "BRB", "RBB"};
        String[] colors = {"BBRBRBR"};
        //int[][] nums = {{0, 1, 10}, {2, 10, 100}, {10, 100, 100}};
        int[][] nums = {{0, 3, 2, 4, 1, 1, 1}};

        int[][] dp = new int[n + 1][m + 1];
        for (int i = 1; i < m; i++) {
            if(dp[0][i - 1] < 0){continue;}
            if(colors[0].charAt(i) == colors[0].charAt(i - 1)){
                dp[0][i] = dp[0][i - 1] + nums[0][i];
            }else{
                dp[0][i] = dp[0][i - 1] + nums[0][i] - k;
            }
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                int a = 0;int b = 0;
                //向下
                if(dp[i - 1][j] >= 0){
                    if(colors[i].charAt(j) == colors[i - 1].charAt(j)){
                        a = dp[i - 1][j] + nums[i - 1][j - 1];
                    }else{
                        a = dp[i - 1][j] + nums[i - 1][j - 1] - k;
                    }
                }
                if(dp[i][j - 1] >= 0){
                    if(colors[i].charAt(j) == colors[i].charAt(j - 1)){
                        b = dp[i][j - 1] + nums[i - 1][j - 1];
                    }else{
                        b = dp[i][j - 1] + nums[i - 1][j - 1] - k;
                    }
                }
                dp[i][j] = Math.max(a, b);
            }
        }

        System.out.println(ans);
    }
    public static int ans = 0;
    public static int m = 0;
    public static int n = 0;
    public static int k = 0;
    public static void backtrack(int i, int j, String[] colors, int[][] nums, int money){
        if(money < 0){
            return;
        }
        money += nums[i][j];
        ans = Math.max(money, ans);
        if(i + 1 < n){
            if(colors[i].charAt(j) == colors[i + 1].charAt(j)){
                backtrack(i + 1, j, colors, nums, money);
            }else{
                backtrack(i + 1, j, colors, nums, money - k);
            }
        }
        if(j + 1 < m){
            if(colors[i].charAt(j) == colors[i].charAt(j + 1)){
                backtrack(i, j + 1, colors, nums, money);
            }else{
                backtrack(i, j + 1, colors, nums, money - k);
            }
        }



    }

    public static void t3(){
        int[][] intervals = {{1, 3}, {2, 6}, {5, 7}};
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            } else {
                return o1[0] - o2[0];
            }
        });
        for (int[] interval : intervals) {
            pq.add(new int[]{interval[0], 1});
            pq.add(new int[]{interval[1], -1});
        }
        int count = 0;
        int max = 0;
        int a = 0;int pre = 0;
        while (!pq.isEmpty()) {
            int[] poll = pq.poll();
            count += poll[1];
            if(max - 1 == count){
                a += poll[0] - pre + 1;
            }
            if(max < count){
                max = count;
                a = 0;
            }
            if(poll[1] == 1){
                pre = poll[0];
            }
            //max = Math.max(max, count);
        }
        System.out.println(max);
        System.out.println(a);
    }
}
