package exam;


import java.util.Arrays;
import java.util.Scanner;

/**
 * @Auther: ys
 * @Date: 2023/4/12 - 04 - 12 - 18:34
 */
public class weizhong412 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 10;
        int[] nums = {-32, 23, -93, -21, 30, 9, 27, -88, 93, 61};
        int[][] dp = new int[2][n + 1];
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            dp[0][i] = Math.max(dp[0][i - 1] + nums[i - 1], 0);
            if(dp[0][i - 1] + nums[i - 1] > 0){
                dp[1][i] = dp[1][i - 1] + nums[i - 1];
            }else{
                dp[1][i] = Math.max(Math.max(dp[1][i - 1], dp[1][i - 1] + nums[i - 1]), dp[0][i - 1]);
            }
            ans = Math.max(ans, dp[1][i]);
        }
        System.out.println(ans);
        System.out.println(Arrays.deepToString(dp));

    }



    public static void t1(){
        int L = 2;int R = 3;
        int X = 8;// X为1的位必须为1
        int Y = 62;// Y为0的位必须为0
        int tmp = X;int pos = 31;
        int[] record = new int[32];
        Arrays.fill(record, -1);
        int maxPos = 0;int countOne = 0;int countZero = 0;
        while (tmp != 0){
            if((tmp & 1) == 1){
                record[pos] = 1;countOne++;
            }
            tmp = tmp >> 1;
            pos--;
        }
        maxPos = 31 - pos;
        tmp = Y;pos = 31;
        while (tmp != 0){
            if((tmp & 1) == 0){
                if(record[pos] == 1){
                    System.out.println(0);
                }
                record[pos] = 0;countZero++;
            }
            tmp = tmp >> 1;
            pos--;
        }
        maxPos = Math.max(maxPos, 31 - pos);
        System.out.println(maxPos);
        System.out.println(Arrays.toString(record));
        int ans = 0;int count = maxPos - countOne - countZero;
        for (int i = L - countOne; i <= R - countOne; i++) {
            int t = i;
            int val = 1;
            while (t > 0){
                val *= (count - t + 1);
                t--;
            }
            t = i;
            while (t > 0){
                val /= t;
                t--;
            }
            ans += val;
        }
        System.out.println(ans);
    }
}
