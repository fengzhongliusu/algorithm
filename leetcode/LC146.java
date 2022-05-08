package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by cshuo on 2021/8/12
 */
public class LC146 {
    int capacity;
    Map<Integer, Node> map = new HashMap<>();
    Node head;
    Node tail;

    private static class Node {
        Node prev;
        Node next;
        int key;
        int val;
        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }


    public static void main(String[] args) {
    }

    public LC146(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        Node n = map.get(key);
        return get(n);
    }

    private int get(Node n) {
        if (n == null) {
            return -1;
        }
        if (n == head) {
            return n.val;
        }
        if (n.prev != null) {
            n.prev.next = n.next;
        }
        if (n.next != null) {
            n.next.prev = n.prev;
        } else {
            tail = n.prev;
        }
        n.next = head;
        head.prev = n;
        n.prev = null;
        head = n;
        return n.val;
    }

    public void put(int key, int value) {
        Node n = map.get(key);
        if (n == null) {
            n = new Node(key, value);
            if (map.size() == 0) {
                head = n;
                tail = n;
                map.put(key, head);
                return;
            }
            n.next = head;
            head.prev = n;
            head = n;
            map.put(key, head);
            if (map.size() > capacity) {
                map.remove(tail.key);
                tail = tail.prev;
                tail.next = null;
            }
        } else {
            n.val = value;
            get(n);
        }
    }
}
