package exam;

import java.util.Deque;
import java.util.*;

public class fgmeituan522 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        int sum = 0;
        double[] nums = new double[n];
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            nums[i] = num;
            sb.append(num).append('+');
            sum += num;
        }
        sb.deleteCharAt(sb.length() - 1);
        int m = sc.nextInt();
        for (int i = 0; i < m; i++) {
            int pos = sc.nextInt();
            String op = sc.next();
            double tmp = sum;
            tmp -= nums[pos - 1];
            tmp -= nums[pos];
            if ("+".equals(op)) {
                tmp += nums[pos] + nums[pos - 1];
            } else if ("-".equals(op)) {
                tmp += nums[pos - 1] - nums[pos];
            } else if ("*".equals(op)) {
                tmp += nums[pos - 1] * nums[pos];
            } else if ("/".equals(op)) {
                tmp += nums[pos - 1] / nums[pos];
            }
            System.out.println(tmp);
            //System.out.println(String.format("%.1f", tmp));


        }
    }
    //public static double calculate(char[] chars) {
    //    Deque<Double> nums = new LinkedList<>();
    //    Deque<Character> ops = new LinkedList<>();
    //    for (int i = 0; i < chars.length; i++) {
    //        if(chars[i] >= '0' && chars[i] <= '9'){
    //            double tmp = 0;
    //            while(i < chars.length && chars[i] >= '0' && chars[i] <= '9'){
    //                tmp = tmp * 10 + chars[i] - '0';
    //                i++;
    //            }
    //            nums.push(tmp);
    //            i--;
    //        }else{
    //            if(chars[i] == '+' || chars[i] == '-'){
    //                while (ops.size() > 0){
    //                    calc(nums, ops);
    //                }
    //                ops.push(chars[i]);
    //            }else{
    //                while(ops.size() > 0 && ops.peek() != '+' && ops.peek() != '-'){
    //                    calc(nums, ops);
    //                }
    //                ops.push(chars[i]);
    //            }
    //        }
    //    }
    //    while(ops.size() > 0){
    //        calc(nums, ops);
    //    }
    //    return nums.peek();
    //}
    //
    //public static void calc(Deque<Double> nums, Deque<Character> ops){
    //    if(nums.size() < 2){
    //        return;
    //    }
    //    double a = nums.pop();
    //    double b = nums.pop();
    //    char c = ops.pop();
    //    if(c == '+'){
    //        nums.push(b + a);
    //    }else if(c == '-'){
    //        nums.push(b - a);
    //    }else if(c == '*'){
    //        nums.push(b * a);
    //    }else{
    //        nums.push(b / a);
    //    }
    //}
}
