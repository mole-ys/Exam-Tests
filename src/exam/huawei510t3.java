package exam;

import java.util.*;

/**
 * @Auther: ys
 * @Date: 2023/5/10 - 05 - 10 - 20:20
 */
public class huawei510t3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();//节点数
        int n = sc.nextInt();//长度
        Node[] nodes = new Node[m + 1];
        for (int i = 0; i < n; i++) {
            int src = sc.nextInt();
            int dst = sc.nextInt();
            int time = sc.nextInt();
            Node node;
            if(nodes[src] == null){
                node = new Node();
                nodes[src] = node;
            }else {
                node = nodes[src];
            }
            if(src == dst){
                node.time = time;
            }else {
                node.map.put(dst, time);
            }
        }
        int start = sc.nextInt();
        calculate(start, nodes, 1, 0);
        System.out.println(count);
        System.out.println(minTime);

    }

    public static int count;
    public static int minTime;
    public static int[] record;


    public static void calculate(int pos, Node[] nodes, int number, int time){
        if(number == nodes.length || nodes[pos].map.isEmpty()){
            //if(count < number){
            //    count = number;
            //    minTime += time;
            //}else if (count == number){
            //    minTime += Math.min(minTime, time + nodes[pos].time);
            //}
            minTime += time;
            return;
        }
        Node node = nodes[pos];
        HashMap<Integer, Integer> map = node.map;
        Set<Integer> dsts = map.keySet();
        for(int i : dsts){
            Integer t = map.get(i);
            calculate(i, nodes, number + 1, time + node.time + t);

        }
    }


}

class Node{
    int time;
    HashMap<Integer, Integer> map;

    public Node(){
        time = 0;
        map = new HashMap<>();
    }
}
