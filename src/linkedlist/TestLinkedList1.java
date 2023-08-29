package linkedlist;

/**
 * @Auther: ys
 * @Date: 2023/2/24 - 02 - 24 - 20:25
 */
public class TestLinkedList1 {
    public static void main(String[] args) {
        Node node = new Node(1, new Node(9, new Node(3, new Node(8))));
        Node node1 = node;
        Node node2 = node.next;
        while (node.next != null){
            Node next = node.next;
            node.next = node.next.next;
            node = next;
        }
        Node dummy = new Node(0, node2);
        Node pre = dummy;
        Node tmp = node2;
        while (node2 != null){
            Node next = node2.next;
            node2.next = pre;
            pre = node2;
            node2 = next;
        }
        dummy.next = null;tmp.next = null;
        System.out.println(pre);
        node2 = pre;
        System.out.println(node1);
        System.out.println(recursion(node1, node2));
    }

    public static Node recursion(Node a, Node b){
        if(a == null){
            return b;
        }
        if(b == null){
            return a;
        }
        if(a.val < b.val){
            a.next = recursion(a.next, b);
            return a;
        }else{
            b.next = recursion(a, b.next);
            return b;
        }
    }
}

class Node {
    Integer val;
    Node next;

    public Node(Integer val) {
        this.val = val;
    }

    public Node( Integer val, Node next) {
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
