package exam;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Auther: ys
 * @Date: 2023/4/19 - 04 - 19 - 13:38
 */
public class Midea419 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        StringBuilder sb = new StringBuilder();
        char letter = 'A';
        while(!s.equals("#")){
            s = s.trim();
            String[] split = s.split(":");
            if(s.charAt(0) == '-'){
                sb = new StringBuilder();
                sb.append(split[0]);
                System.out.println(s);
            }else{
                if(letter == split[0].charAt(0)){
                    sb.delete(sb.length() - 3, sb.length());
                }
                sb.append('-');sb.append(split[0]);
                System.out.println("" + sb + ":" + split[1]);
                letter = split[0].charAt(0);
            }
            s = sc.nextLine();
        }
        System.out.println("#");
    }

    public static void t2(){
        String str = "9,9,9,2,2,3,3,1,4,5";
        String[] strs = str.split(",");
        Arrays.sort(strs);
        int[] nums = new int[strs.length];
        for (int i = 0; i < strs.length; i++) {
            nums[i] = Integer.parseInt(strs[i]);
        }
        System.out.println(Arrays.toString(nums));
        int last = Integer.parseInt(strs[strs.length - 1]);
        int a = Integer.MIN_VALUE;int b = Integer.MIN_VALUE;
        for (int i = nums.length - 2; i >= 0; i--) {
            if(!strs[i].equals(strs[strs.length - 1])){
                a = Integer.parseInt(strs[i]) * Integer.parseInt(strs[strs.length - 1]);
                break;
            }
        }
        for (int i = 1; i < strs.length; i++) {
            if(!strs[i].equals(strs[0])){
                b = Integer.parseInt(strs[i]) * Integer.parseInt(strs[0]);
                break;
            }
        }
        System.out.println(Math.max(a, b));
    }
}





