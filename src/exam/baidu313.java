package exam;


import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Scanner;
public class baidu313 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while (n-- > 0) {
            int len = sc.nextInt();
            String str = sc.next();
            boolean flag = false;
            int count = 0;
            for (int i = 0; i < str.length(); i++) {
                if (!flag && str.charAt(i) == '1') {
                    count++;
                    flag = true;
                }
                if (str.charAt(i) == '0') {
                    flag = false;
                }
            }
            System.out.println(count);

        }
    }
    //2
    //8 00011101
    //1 0
    public static void t1(){

    }

    public static void t2(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = sc.nextInt();
        }
        int[] B = new int[n];
        for (int i = 0; i < n; i++) {
            B[i] = sc.nextInt();
        }
        long[][] dp = new long[3][n + 1];
        for (int i = 1; i < n + 1; i++) {
            dp[0][i] = Math.max(dp[1][i - 1], dp[2][i - 1]) + A[i - 1];
            dp[1][i] = Math.max(dp[0][i - 1], Math.max(dp[1][i - 1], dp[2][i - 1]));
            dp[2][i] = Math.max(dp[0][i - 1], dp[1][i - 1]) + B[i - 1];
        }
        System.out.println(Math.max(dp[0][n], Math.max(dp[1][n], dp[2][n])));
    }
}
