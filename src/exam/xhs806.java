package exam;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Auther: ys
 * @Date: 2023/8/6 - 08 - 06 - 20:02
 */
public class xhs806 {
    public static void main(String[] args) {
        //3
        //5 4
        //1 2 2
        //2 1 3
        //4 1 5
        //int n = 3;
        //int T = 5;int H = 4;
        //int t = 1;int h = 2;int a = 2;

        //2
        //2 2
        //1 33
        //314


        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int T = sc.nextInt();int H = sc.nextInt();
        long[][] dp = new long[H + 1][T + 1];
        for (int i = 0; i < n; i++) {
            int t = sc.nextInt();
            int h = sc.nextInt();
            int a = sc.nextInt();

            for (int j = H; j >= h; j--) {
                for (int k = T; k >= t; k--) {
                    dp[j][k] = Math.max(dp[j - h][k - t] + a, dp[j][k]);
                }
            }
            //System.out.println(Arrays.deepToString(dp));
        }
        System.out.println(dp[H][T]);
    }
}
