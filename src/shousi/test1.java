package shousi;

import java.util.HashMap;
import java.util.Hashtable;

/**
 * @Auther: ys
 * @Date: 2023/3/15 - 03 - 15 - 9:35
 */
public class test1 {
    public static void main(String[] args) {
        Node node = new Node(1, new Node(2, new Node(3, new Node(4, new Node(5, new Node(6, null))))));
        Node dummy = new Node(0, node);
        Node tmp = node;int count = 0;
        Node pre = dummy;
        while (tmp != null){
            count++;
            tmp = tmp.next;
            if(count == 3){
                pre = kSwap(pre, pre.next, 3);
                pre.next = tmp;
                count = 0;
            }
        }
        System.out.println(dummy);
    }

    public static Node kSwap(Node pre, Node node, int k){
        Node dummy = pre;
        Node tmp = node;
        for (int i = 0; i < k; i++) {
            Node next = node.next;
            node.next = pre;
            pre = node;
            node = next;
        }
        dummy.next = pre;
        tmp.next = null;
        return tmp;
    }

}

class Node{
    public int val;
    Node next;

    public Node(){}

    public Node(int val, Node next) {
        this.next = next;
        this.val = val;
    }

    @Override
    public String toString() {
        return "Node{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}
