package leetcode;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

/**
 * Created by cshuo on 2021/9/16
 */
public class LC460 {

    public static void main(String[] args) {
        LC460 test = new LC460(3);
        test.put(1,1);
        test.put(2,2);
        test.put(3,3);
        test.put(4,4);
        System.out.println(test.get(4));
        System.out.println(test.get(3));
        System.out.println(test.get(2));
        System.out.println(test.get(1));
    }

    private static class Node {
        int key;
        int val;
        int counter = 0;
        Node prev = null;
        Node next = null;
        public Node (int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    int capacity;
    Map<Integer, Node> map = new HashMap<>();
    Node head, tail;

    public LC460(int capacity) {
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
        this.capacity = capacity;
    }

    public int get(int key) {
        Node node = getNode(key);
        if (node == null) return -1;
        else return node.val;
    }

    public String decodeString(String s) {
        Queue<Character> q = new ArrayDeque<>();
        for (Character c: s.toCharArray()) q.add(c);
        return build(q);
    }

    public String build(Queue<Character> q) {
        StringBuilder sb = new StringBuilder();
        int num = 0;
        while (!q.isEmpty()) {
            char c = q.poll();
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            } else if (c == '[') {
                String s = build(q);
                for (int i = 0; i < num; i++) {
                    sb.append(s);
                }
            } else if (c == ']') {
                break;
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public Node getNode(int key) {
        Node node = map.get(key);
        if (node == null) return null;
        node.counter += 1;
        Node tmp = node;
        while (tmp != head) {
            if (tmp.counter > node.counter) {
                break;
            }
            tmp = tmp.prev;
        }
        // not change
        if (tmp == node.prev) {
            return node;
        }
        // break at `node` and re-connect
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
        // insert `node` after tmp
        next = tmp.next;
        tmp.next = node;
        node.prev = tmp;
        node.next = next;
        next.prev = node;
        return node;
    }

    public void put(int key, int value) {
        Node node = getNode(key);
        if (node == null) {
            if (map.size() >= capacity) {
                if (capacity == 0) return;
                // remove last
                int rmKey = tail.prev.key;
                Node prev = tail.prev.prev;
                prev.next = tail;
                tail.prev = prev;
                map.remove(rmKey);
            }
            Node newNode = new Node(key, value);
            Node prev = tail.prev;
            prev.next = newNode;
            newNode.prev = prev;
            newNode.next = tail;
            tail.prev = newNode;
            map.put(key, newNode);
            // update position
            getNode(key);
        } else {
            node.val = value;
        }
    }
}
