package exam;

import java.util.*;

/**
 * @Auther: ys
 * @Date: 2023/3/29 - 03 - 29 - 19:13
 */
public class xiecheng329 {
    public static void main(String[] args) {
        t4();
    }

    //5
    //1 2 2
    //2 3 5
    //3 4 4
    //3 5 3
    public static void t4(){
        Scanner sc = new Scanner(System.in);
        int n = 5;
        int[][] dp = new int[n + 1][n + 1];
        for (int i = 0; i < n - 1; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();
            dp[u][v] = w;
        }
        System.out.println(Arrays.deepToString(dp));
        int ans = 0;
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if(dp[i][j] != 0){
                    int a = Math.max(i, j) - 1;

                }
            }
        }
    }

    public static void budui(){
        Scanner sc = new Scanner(System.in);
        HashMap<Integer, Node2> record = new HashMap<>();
        int n = 5;
        for (int i = 0; i < n - 1; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();
            Node2 node2;
            if(!record.containsKey(u)){
                node2 = new Node2(u, new HashMap<>());
                record.put(u, node2);
            }else{
                node2 = record.get(u);
            }

            Node2 tmp;
            if(!record.containsKey(v)){
                tmp = new Node2(v, new HashMap<>());
                record.put(v, tmp);
            }else{
                tmp = record.get(v);
            }
            node2.map.put(tmp, w);
        }
        System.out.println(record);

    }

}
class Node2 {
    int num;
    Map<Node2, Integer> map;

    public Node2(int num, Map<Node2, Integer> map) {
        this.num = num;
        this.map = map;
    }
}


