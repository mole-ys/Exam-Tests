package exam;

import java.util.*;

/**
 * @Auther: ys
 * @Date: 2023/3/18 - 03 - 18 - 9:49
 */
public class meituan318 {
    public static void main(String[] args) {
        t3();
    }

    public static void t1(){

    }

    public static void t2(){
        int N = 8;
        int K = 3;
        int[] nums = {1,2,3,2,1,4,5,1};
        int left = 0;int right = 1;
        int count = 1;
        int ans = 0;
        HashMap<Integer, Integer> hm = new HashMap<>();
        hm.put(nums[left], 1);
        while (right < nums.length){
            if(hm.containsKey(nums[right])){
                hm.put(nums[right], hm.get(nums[right]) + 1);
            }else{
                hm.put(nums[right], hm.getOrDefault(nums[right], 0) + 1);
                while (hm.size() > K){
                    int a = hm.get(nums[left]);
                    if(a != 1){
                        hm.put(nums[left], a - 1);
                    }else{
                        hm.remove(nums[left]);
                    }
                    count--;
                    left++;
                }
            }
            right++;count++;
            ans = Math.max(ans, count);
        }
        System.out.println(ans);
    }
    //样例解释1
    //
    //原来的字符串已经是回文字符串了。但它不是题目条件下可以取得的字典序最小的回文字符串。将第二个字符和第三个字符都改为a可以获得字典序最小的回文字符串。
    //
    //
    //
    //输入样例2
    //
    //abcde
    //
    //输出样例2
    //
    //abcba
    //
    //样例解释2
    //
    //将de改为ba可以获得字典序最小的回文字符串。
    public static void t3(){
        String s = "abka";
        char[] chars = s.toCharArray();
        int left = 0;
        int right = s.length() - 1;
        int count = 2;
        int[] pos = {-1, -1};
        int posi = 0;
        while (left < right){
            if(chars[left] != chars[right]){
                if(chars[left] > chars[right]){
                    chars[left] = chars[right];
                    pos[posi++] = left;
                }else{
                    chars[right] = chars[left];
                    pos[posi++] = right;
                }
                count--;
            }
            left++;
            right--;
        }
        if(left == right && count == 1){
            chars[left] = 'a';
            System.out.println(chars);
        }else{
            left = 0;right = s.length() - 1;
            while (count > 1 && left <= right){
                if(chars[left] != 'a'){
                    chars[left] = 'a';
                    chars[right] = 'a';
                    count -= 2;
                    for (int i = 0; i < 2; i++) {
                        if(pos[i] == left || pos[i] == right){
                            count++;
                        }
                    }
                }
                left++;right--;
            }
            System.out.println(chars);
        }

    }





    public static void t4(){
        int N = 3;
        int X = 5;int Y = 1;
        int[] ori = {4, 3, 6};
        int[] discount = {3, 1, 5};
        Arrays.sort(ori);
        Arrays.sort(discount);
        int count = 0;
        int arr1 = 0;int arr2 = 0;
        int spend = 0;
        while (arr1 < ori.length && arr2 < discount.length){
            if(ori[arr1] <= discount[arr2]){
                if(X - spend < ori[arr1]){
                    break;
                }
                spend += ori[arr1];
                count++;
                arr1++;
            }else if(Y > 0){
                Y--;
                if(X - spend < discount[arr2]){
                    break;
                }
                spend += discount[arr2];
                count++;
                arr2++;
            }
        }
        System.out.println(count);
        System.out.println(spend);
    }
    public static void t5(){

    }
}
