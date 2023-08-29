package exam;

import java.util.*;

/**
 * @Auther: ys
 * @Date: 2023/3/26 - 03 - 26 - 20:26
 */
public class tencent326 {
    public static void main(String[] args) {
        t2();
    }

    public static void t2(){
        int N = 3;
        String[] a = {"ab", "ca", "ccb"};
        char[][] strs = new char[N][];
        for (int i = 0; i < strs.length; i++) {
            char[] chars = a[i].toCharArray();
            Arrays.sort(chars);
            strs[i] = chars;
        }
        count = 0;
        recursion(N, 0, strs, new HashSet<>());
        System.out.println(count);
    }
    public static int count;
    public static void recursion(int N, int pos, char[][] strs, HashSet<Character> set){
        if(N == pos){
            count++;
            return;
        }
        char[] chars = strs[pos];
        for (int i = 0; i < chars.length; i++) {
            if(i > 1 && chars[i] == chars[i - 1]){continue;}
            if(!set.contains(chars[i])){
                set.add(chars[i]);
                recursion(N, pos + 1, strs, set);
                set.remove(chars[i]);
            }
        }
    }

    static int MOD = 1000000007;
    public static void t4(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        int[] cnt = new int[100001];
        for (int i = 0; i < n; i++) {
            cnt[a[i]]++;
        }
        int[] dp = new int[100001];
        dp[k] = 1;
        for (int i = 2 * k; i <= 100000; i+=k) {
            for (int j = i; j <= 100000; j+=i) {
                dp[i] = (dp[i] + cnt[j]) % MOD;
            }
        }
        int ans = 0;
        for (int i = k; i <= 100000; i+=k) {
            ans = (ans + dp[i]) % MOD;
        }
        System.out.println(ans);
    }
}
