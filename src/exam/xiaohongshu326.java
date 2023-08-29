package exam;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Auther: ys
 * @Date: 2023/3/26 - 03 - 26 - 15:52
 */
public class xiaohongshu326 {
    public static void main(String[] args) {
        t3();
    }

    public static void t1(){
        int n = 3;
        String s = "def";
        char[] chars = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n',
                'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            sb.append(chars[(s.charAt(i) - 'a' + 23) % 26]);
        }
        System.out.println(sb);
    }

    public static void t2(){
        int[] nums = {1, 3, 5, 4, 2};
        int k = 2;
        int[] sorted = nums.clone();
        Arrays.sort(sorted);
        int count = 0;
        int preMax = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] < preMax){
                count++;
            }else {
                preMax = nums[i];
            }

        }

        int ans = count / (k - 1);
        System.out.println(ans);
        //System.out.println(count % k == 0 ? ans : ans + 1);

    }

    //第一行有一个正整数N(1<=N<=100000)，代表数组的长度。
    //
    //第二行有N个非负整数，范围在0到2^20-1之间，代表数组中的元素。
    //
    //第三行有一个正整数M(1<=M<=100000)，代表操作次数。
    //
    //第四行有M个正整数，代表M次操作中的区间左端点L。
    //
    //第五行有M个正整数，代表M次操作中的区间右端点R。
    //
    //第六行是一个长度为M的字符串，`|`代表操作1，`&`代表操作2，`=`代表操作3。
    //
    //第七行有M个正整数，代表M次操作中的参数X。
    //4
    //5 4 7 4
    //4
    //1 2 3 2
    //4 3 4 2
    //=|&=
    //8 3 6 2
    public static void t3(){
        int N = 4;
        int[] nums = {5, 4, 7, 4};
        int M = 4;
        int[] L = {1, 2, 3, 2};
        int[] R = {4, 3, 4, 2};
        String str = "=|&=";
        int[] X = {8, 3, 6, 2};

        for (int i = 0; i < nums.length; i++) {
            if(str.charAt(i) == '='){
                equals(L[i], R[i], nums, X[i]);
            }
            if(str.charAt(i) == '&'){
                and(L[i], R[i], nums, X[i]);
            }
            if(str.charAt(i) == '|'){
                or(L[i], R[i], nums, X[i]);
            }
        }
        for (int num : nums) {
            System.out.print(num);
        }
    }

    public static void and(int left, int right, int[] nums, int x){
        for (int i = left - 1; i < right; i++) {
            nums[i] &= x;
        }
    }
    public static void or(int left, int right, int[] nums, int x){
        for (int i = left - 1; i < right; i++) {
            nums[i] |= x;
        }
    }
    public static void equals(int left, int right, int[] nums, int x){
        for (int i = left - 1; i < right; i++) {
            nums[i] = x;
        }
    }
}
