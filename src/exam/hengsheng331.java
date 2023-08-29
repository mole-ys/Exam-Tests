package exam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @Auther: ys
 * @Date: 2023/3/31 - 03 - 31 - 20:18
 */
public class hengsheng331 {
    public static void main(String[] args) {
        System.out.println(t2());
    }
    public static void t1(){
        int num = 1000;
        for (int i = num; i > 10; i--) {
            int len = 0;
            int tmp = i;
            while(tmp != 0){
                tmp/=10;
                len++;
            }
            tmp = i;
            int sum = 0;
            while (tmp != 0){
                sum += Math.pow(tmp % 10, len);
                tmp /= 10;
            }
            if(sum == i){
                System.out.println(i);
            }
        }
    }
    public static double t2(){
        double[] historyPrices = {1,2,1,2,2,3,2};
        int K = 2;
        int M = 10000;
        int[][][] dp = new int[K * 2][historyPrices.length][2];
        for(int i = 0; i < K * 2; i = i + 2){
            dp[i][0][0] = (int) (M % historyPrices[i]);
            dp[i][0][1] = (int) (M / historyPrices[i]);
        }
        for(int i = 1; i < historyPrices.length; i++){
            if((M / historyPrices[i]) > dp[0][i - 1][1]){
                dp[0][i][1] = (int) (M / historyPrices[i]);
                dp[0][i][0] = (int) (M % historyPrices[i]);
            }else{
                dp[0][i] = dp[0][i - 1];
            }
            if(dp[0][i - 1][1] * historyPrices[i] > dp[1][i - 1][0]){
                dp[1][i][0] = (int) (dp[0][i - 1][1] * historyPrices[i] + dp[0][i - 1][0]);
                dp[1][i][1] = 0;
            }else{
                dp[1][i] = dp[1][i - 1];
            }

            for(int j = 2; j < 2 * K; j = j + 2){
                if((dp[j - 1][i - 1][0] / historyPrices[i]) > dp[j][i - 1][1]){
                    dp[j][i][1] = (int) (dp[j - 1][i - 1][0] / historyPrices[i]);
                    dp[j][i][0] = (int) (dp[j - 1][i - 1][0] % historyPrices[i]);
                }else{
                    dp[j][i] = dp[j][i - 1];
                }

                if(dp[j][i - 1][1] * historyPrices[i] > dp[j + 1][i - 1][0]){
                    dp[j + 1][i][0] = (int) (dp[j][i - 1][1] * historyPrices[i] + dp[j][i - 1][0]);
                    dp[j + 1][i][1] = 0;
                }else{
                    dp[j + 1][i] = dp[j + 1][i - 1];
                }
            }
        }
        return dp[K * 2 - 1][historyPrices.length - 1][0] - M;
    }
}
