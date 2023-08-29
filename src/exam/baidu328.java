package exam;

import java.util.Scanner;

public class baidu328 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();//数组大小
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        String str = sc.next();
        long red = 0;
        long blue = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'R') {
                red += a[i];
            } else {
                blue += a[i];
            }
        }
        System.out.println((red * blue) % 1000000007);
    }
    public static void t1(){
        int n = 3;//数组大小
        int[] a = {1, 2, 3};
        String str = "RBR";

        int ans = 0;
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == 'R'){
                for (int j = 0; j < str.length(); j++) {
                    if(str.charAt(j) == 'B'){
                        ans += a[i] * a[j] % 1000000007;
                    }
                }
            }
        }
        System.out.println(ans);
    }
}
