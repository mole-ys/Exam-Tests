package exam;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

/**
 * @Auther: ys
 * @Date: 2023/4/18 - 04 - 18 - 15:20
 */
public class Midea418 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[][] nums = parseToArray(sc.next());
        System.out.println(Arrays.deepToString(nums));
        int[][] dp = new int[nums.length][nums[0].length];
        dp[0][0] = nums[0][0];
        for (int i = 1; i < nums[0].length; i++) {
            dp[0][i] = dp[0][i - 1] + nums[0][i];
        }
        for (int i = 1; i < nums.length; i++) {
            dp[i][0] = dp[i - 1][0] + nums[i][0];
        }
        for (int i = 1; i < nums.length; i++) {
            for (int j = 1; j < nums[0].length; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + nums[i][j];
            }
        }
        System.out.println(dp[dp.length - 1][dp[0].length - 1]);
    }

    private static int[][] parseToArray(String input){
        String[] lines = input.split("],");
        int[][] inputArray = new int[lines.length][];

        int i = 0;
        for(String line : lines){
            int j = 0;
            String[] elements = line.split(",");
            inputArray[i] = new int[elements.length];
            for(String element : elements){
                inputArray[i][j++] = Integer.valueOf(element.replace("[","").replace("]",""));
            }
            i++;
        }
        return inputArray;
    }


    public static void t2(){

    }



    public static void t3(){
        String s = "9525";
        StringBuilder sb = new StringBuilder();
        HashSet<String> record = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j < s.length(); j++) {
                String tmp = "" + s.charAt(i) + s.charAt(j);
                if(!record.contains(tmp)){
                    record.add(tmp);
                    sb.append(tmp);sb.append(',');
                }
                tmp = "" + s.charAt(j) + s.charAt(i);
                if(!record.contains(tmp)){
                    record.add(tmp);
                    sb.append(tmp);sb.append(',');
                }
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb);
    }
}
