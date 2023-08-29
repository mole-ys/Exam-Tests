package exam;

import java.util.Arrays;

/**
 * @Auther: ys
 * @Date: 2023/3/23 - 03 - 23 - 19:24
 */
public class tencentmusic323 {
    public static void main(String[] args) {
        System.out.println(t1());
    }

    public static String t1(){
        //String[] tree = {"-1", "-1", "-1", "#", "-1", "-1"};
        //String[] tree = {"-1", "-1", "#", "-1", "-1"};
        String[] tree = {"-1", "-1", "-1"};
        int n = tree.length;
        int odd = 0;int oddCount = 0;
        int even = 1;int evenCount = 0;
        int times = 1;
        U:while (true){
            if(odd < even){
                for (int i = odd; i < even; i++) {
                    if(i == n){break U;}
                    if(tree[i].equals("-1")){
                        tree[i] = "o";
                        oddCount++;
                    }
                }
                odd += Math.pow(2, times) + 1;
                times++;
            }else {
                for (int i = even; i < odd; i++) {
                    if (i == n) {
                        break U;
                    }
                    if (tree[i].equals("-1")) {
                        tree[i] = "e";
                        evenCount++;
                    }
                }
                even += Math.pow(2, times) + 1;
                times++;
            }
        }
        //System.out.println(oddCount);
        //System.out.println(evenCount);
        //System.out.println(Arrays.toString(tree));
        int sum = 0;
        for (int i = 1; i <= oddCount + evenCount; i++) {
            sum += i;
        }
        int mid = sum / 2;
        int[] nums = new int[oddCount + evenCount + 1];
        for (int i = 1; i < oddCount + evenCount; i++) {
            if(mid - i >= 0){
                nums[i] = 1;
                mid -= i;
            }
        }
        if(mid > 1){
            return "no";
        }
        //System.out.println(Arrays.toString(nums));
        if(oddCount > evenCount){
            int i = 0;int j = 1;
            while (i < tree.length && j < nums.length){
                if(tree[i].equals("o") && nums[j] == 1){
                    tree[i] = String.valueOf(j);
                    i++;j++;
                    continue;
                }
                if(nums[j] == 1){
                    i++;continue;
                }
                if(tree[i].equals("o")){
                    j++;
                }
            }
            i = 0;j = 1;
            while (i < tree.length && j < nums.length){
                if(tree[i].equals("e") && nums[j] == 0){
                    tree[i] = String.valueOf(j);
                    i++;j++;
                    continue;
                }
                if(nums[j] == 0){
                    i++;continue;
                }
                if(tree[i].equals("e")){
                    j++;continue;
                }
                i++;j++;
            }
        }else{
            int i = 0;int j = 1;
            while (i < tree.length && j < nums.length){
                if(tree[i].equals("e") && nums[j] == 1){
                    tree[i] = String.valueOf(j);
                    i++;j++;
                    continue;
                }
                if(nums[j] == 1){
                    i++;continue;
                }
                if(tree[i].equals("e")){
                    j++;
                }
            }
            i = 0;j = 1;
            while (i < tree.length && j < nums.length){
                if(tree[i].equals("o") && nums[j] == 0){
                    tree[i] = String.valueOf(j);
                    i++;j++;
                    continue;
                }
                if(nums[j] == 0){
                    i++;continue;
                }
                if(tree[i].equals("o")){
                    j++;continue;
                }
                i++;j++;
            }
        }
        return Arrays.toString(tree);
    }


}
