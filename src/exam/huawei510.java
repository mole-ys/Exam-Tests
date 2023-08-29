package exam;

import java.util.*;

/**
 * @Auther: ys
 * @Date: 2023/5/10 - 05 - 10 - 18:54
 */
public class huawei510 {
    public static void main(String[] args) {
        //String M = "6833023887793076998810418710";
        //String N = "2211";
        //String k = "-";
        Scanner sc = new Scanner(System.in);
        String M = sc.next();
        String N = sc.next();
        String k = sc.next();
        if("+".equals(k)){
            plus(M, N);
        }else if("-".equals(k)){
            minus(M, N);
        }else {
            multi(M, N);
        }
    }

    public static void plus(String M, String N){
        int len = N.length();
        int n = Integer.parseInt(N);
        String ans = "-1";int judgeNum = 0;
        for (int left = 0; left < M.length(); left++) {
            int right = left + 1;
            while (right < left + len + 6 && right < M.length()){
                String str = M.substring(left, right);
                int num = Integer.parseInt(str);
                if(judge(num + n)){
                    if(num + n > judgeNum){
                        judgeNum = num + n;
                        ans = str;
                    }
                }
                right++;
            }
        }
        System.out.println(ans);
    }

    public static void minus(String M, String N){
        int len = N.length();
        int n = Integer.parseInt(N);
        String ans = "-1";int judgeNum = 0;
        for (int left = 0; left < M.length(); left++) {
            int right = left + 1;
            while (right < left + len + 6 && right < M.length()){
                String str = M.substring(left, right);
                int num = Integer.parseInt(str);
                if(judge(num - n)){
                    if(num - n > judgeNum){
                        judgeNum = num - n;
                        ans = str;
                    }
                }
                right++;
            }
        }
        System.out.println(ans);
    }

    public static void multi(String M, String N){
        int len = N.length();
        int n = Integer.parseInt(N);
        String ans = "-1";long judgeNum = 0;
        for (int left = 0; left < M.length(); left++) {
            if(M.charAt(left) == '0'){continue;}
            int right = left + 1;
            while (right < left + len + 2 && right < M.length()){
                String str = M.substring(left, right);
                long num = Integer.parseInt(str);
                if(judge(num * n)){
                    if(num * n > judgeNum){
                        judgeNum = num * n;
                        ans = str;
                    }
                }
                right++;
            }
        }
        System.out.println(ans);
    }

    public static boolean judge(long num){
        long i = num % 10;
        while (num != 0){
            long tmp = num % 10;
            num /= 10;
            if(tmp != i){
                return false;
            }
        }
        return true;
    }

    public static void test(LinkedList<Integer> stack, int num){
        if(stack.isEmpty()){
            stack.add(num);
            return;
        }
        boolean flag = false;
        if(stack.peek() == num){
            stack.pop();
            flag = true;
        }else{
            int sum = 0;
            for(int i = 0; i < stack.size(); i++){
                sum += stack.get(i);
                if(sum > num){
                    break;
                }
                if(sum == num){
                    for(int j = 0; j <= i; j++){
                        stack.pop();
                    }
                    flag = true;
                    break;
                }
            }
        }
        if(flag){
            test(stack, num * 2);
        }else{
            stack.push(num);
        }
    }

    public static void t1(){
        Scanner sc = new Scanner(System.in);
        LinkedList<Integer> stack = new LinkedList<>();
        String str = sc.nextLine();
        String[] strs = str.split(" ");
        for (int i = 0; i < strs.length; i++) {
            test(stack, Integer.parseInt(strs[i]));
        }
        for (int i = 0; i < stack.size(); i++) {
            System.out.println(stack.get(i));
        }
    }

    public static void t2(){}
}
