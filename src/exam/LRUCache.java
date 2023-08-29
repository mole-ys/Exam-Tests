package exam;

import java.util.HashMap;

/**
 * @Auther: ys
 * @Date: 2023/3/6 - 03 - 06 - 10:48
 */
public class LRUCache {

    private Node1 first;
    private Node1 last;
    private HashMap<Integer, Node1> map;
    private int capacity;

    public LRUCache(int capacity) {
        first = new Node1(-1, -1);
        last = new Node1(-1, -1);
        first.next = last;
        last.pre = first;
        map = new HashMap<>();
        this.capacity = capacity;
    }

    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }
        Node1 node = map.get(key);
        removeNode(node);
        addToHead(node);
        return node.val;
    }

    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node1 tmp = map.get(key);
            tmp.val = value;
            removeNode(tmp);
            addToHead(tmp);
        }else {
            Node1 node = new Node1(key, value);
            map.put(key, node);
            addToHead(node);
            if(map.size() > capacity){
                map.remove(last.pre.key);
                removeNode(last.pre);
            }
        }


    }

    private void removeNode(Node1 node){
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    private void addToHead(Node1 node){
        Node1 tmp = first.next;
        first.next = node;
        tmp.pre = node;
        node.pre = first;
        node.next = tmp;
    }


}

class Node1 {
    int key;
    int val;
    public Node1 pre;
    public Node1 next;

    public Node1(){}
    public Node1(int key, int val){
        this.key = key;
        this.val = val;
    }
    public Node1(int val, Node1 pre, Node1 next){
        this.val = val;
        this.pre = pre;
        this.next = next;
    }
}
class Test{
    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        System.out.println(lruCache.get(1));
        lruCache.put(3, 3);
        System.out.println(lruCache.get(2));
        lruCache.put(4, 4);
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(3));
        System.out.println(lruCache.get(4));
    }
}
