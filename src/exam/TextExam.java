package exam;

import java.util.*;

/**
 * @Auther: ys
 * @Date: 2023/3/3 - 03 - 03 - 23:37
 */
public class TextExam {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] record = new int[10];
        Arrays.fill(record, 4);
        int[] cards = new int[14];
        for (int i = 0; i < cards.length - 1; i++) {
            int num = sc.nextInt();
            cards[i] = num;
            record[num]--;
        }
        int[] ori = new int[14];
        System.arraycopy(cards,0, ori,0,14);
        for (int i = 1; i <= 9; i++) {
            System.arraycopy(ori,0, cards,0,14);
            if(record[i] != 0){
                cards[13] = i;
            }

            for (int j = 1; j < cards.length; j++) {
                Arrays.sort(cards);
                if(cards[j - 1] == cards[j]){
                    int tmp = cards[j];
                    cards[j - 1] = 0;
                    cards[j] = 0;
                    if(findShun(cards) || findKe(cards)){
                        System.out.println(i);
                    }
                    cards[0] = tmp;
                    cards[1] = tmp;
                }
            }
        }

    }

    public static boolean findKe(int[] cards){
        Arrays.sort(cards);
        int[] dp = new int[14];
        dp[2] = 1;
        for (int i = 3; i < cards.length; i++) {
            if(cards[i] == cards[i - 1]){
                dp[i] = dp[i - 1] + 1;
            }else{
                if(dp[i - 1] != 3){
                    return false;
                }else {
                    dp[i] = 1;
                }
            }
        }
        return true;
    }

    public static boolean findShun(int[] cards){
        Arrays.sort(cards);
        boolean[] flag = new boolean[14];
        flag[0] = true;flag[1] = true;
        int arr = 2;
        while (true){
            int num;
            while (flag[arr]){
                arr++;
                if(arr == flag.length){return true;}
            }
            for (int i = 0; i < 2; i++) {
                flag[arr] = true;
                num = cards[arr];
                while (!(!flag[arr] && cards[arr] == num + 1)){
                    arr++;
                    if(arr == flag.length){return false;}
                }
            }
            flag[arr] = true;
            arr = 2;

        }
    }


    // 动态规划字符串去重
    public static void typo(){
        String s = "yyybeettxjjjpppddsrxxxkkkyyyooowwwwwkyyxxppplllwwwiivvssnrvvvccclyydddhaaayiic";
        int[][] dp = new int[s.length()][2];
        dp[0][0] = 1;
        StringBuilder sb = new StringBuilder();
        sb.append(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            if(s.charAt(i) != s.charAt(i - 1)){
                dp[i][0] = 1;
                if(dp[i - 1][0] >= 2 && dp[i - 1][1] < 2){
                    dp[i][1] = 1;
                }
            }else {
                dp[i][0] = dp[i - 1][0] + 1;
                if(dp[i - 1][1] != 0){
                    dp[i][1] = dp[i - 1][1] + 1;
                }
            }
            if(dp[i][0] <= 2 && dp[i][1] <= 1){
                sb.append(s.charAt(i));
            }
        }
        System.out.println(Arrays.deepToString(dp));
        System.out.println(sb);
    }


    public static void erfen(){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        List<Integer> list = new LinkedList<>();
        list.add(in.nextInt());
        for(int i = 1; i < n; i++){
            int num = in.nextInt();
            int left = 0;int right = list.size();
            while(left < right){
                int mid = left + (right - left) / 2;
                if(list.get(mid) < num){
                    left = mid + 1;
                }else{
                    right = mid;
                }
            }
            if(left < list.size() && list.get(left) == num){
                continue;
            }
            list.add(left, num);
        }
        for(int i = 0; i < list.size(); i++){
            System.out.println(list.get(i));
        }
    }


    //输入例子：
    //
    //aabb
    //3
    //
    //输出例子：
    //
    //aab
    //
    //例子说明：
    //
    //不同的子串依次为：
    //a aa aab aabb ab abb b bb
    //所以答案为aab
    //
    public static void a(){
        String s = "aabb";
        int k = 3;
        priorityQueue = new PriorityQueue<>(k, String::compareTo);
        StringBuilder sb = new StringBuilder();
        construct(sb, s, 0, k, new HashSet<>());
        for (int i = 0; i < k - 1; i++) {
            priorityQueue.poll();
        }
        System.out.println(s.indexOf("c"));
        System.out.println(priorityQueue.peek());
    }
    public static PriorityQueue<String> priorityQueue;
    public static void construct(StringBuilder sb, String s, int pos, int k, HashSet<String> set){
        if(priorityQueue.size() == k){
            return;
        }
        for (int i = 0; i < 26; i++) {
            for (int j = pos; j < s.length(); j++) {
                if(s.charAt(j) == 'a' + i){
                    sb.append(s.charAt(j));
                    if(!set.contains(sb.toString())){
                        set.add(sb.toString());
                        priorityQueue.offer(sb.toString());
                    }
                    construct(sb, s, j + 1, k, set);
                    if(priorityQueue.size() == k){
                        break;
                    }
                    sb.deleteCharAt(sb.length() - 1);
                }
            }
        }

    }

    public static void rob(){
        //输入例子：
        //5 19
        //1 10 20 30 50
        //输出例子：
        //1
        //例子说明：
        //可选方案 (1, 10, 20)
        //int N = 5; int D = 19;
        int N = 4; int D = 3;
        //int[] street = {1, 10, 20, 30, 50};
        int[] street = {1, 2, 3, 4};
        int count = 0;
        for (int i = 0; i < street.length - 2; i++) {
            int left = i; int right = street.length;
            int target = street[i] + D;
            while (left < right){
                int mid = left + (right - left) / 2;
                if(street[mid] < target){
                    left = mid + 1;
                }else {
                    right = mid;
                }
            }
            if(left - i < 2){continue;}
            if(left < street.length && street[left] == target){
                count += ((left - i) * (left - i - 1)) / 2;
            }else {
                count += ((left - i - 1) * (left - i - 2)) / 2;
            }
        }
        System.out.println(count);
    }
}
