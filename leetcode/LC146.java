package leetcode;

import java.util.HashMap;

/**
 * LRU
 * 思路：双向链表+hashmap<key, node>, 最新的结点放在尾部，满了删除头结点.
 * 时间: O(1);
 */
public class LC146 {
    class Node {
        int key;
        int val;
        Node prev;
        Node next;
        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    Node head, tail;
    HashMap<Integer, Node> map;
    int capacity;

    public LC146(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
    }

    public int get(int key) {
        int rs = -1;
        if (map.containsKey(key)) {
            Node t = map.get(key);
            rs = t.val;
            // 是否是尾结点
            if (t.next != null) {
                t.next.prev = t.prev;
                // 是否是头结点.
                if (t.prev == null) {
                    head = t.next;
                    head.prev = null;
                } else t.prev.next = t.next;
                // 插入到尾部.
                tail.next = t;
                t.prev = tail;
                t.next = null;
                tail = t;
            }
        }
        return rs;
    }

    public void put(int key, int value) {
        // 调用get函数, 存在的话, 直接更新位置.
        int val = get(key);
        if (val != -1) {
            map.get(key).val = value;
            return;
        }
        // 不存在, 重新创建，插入尾部.
        Node node = new Node(key, value);
        if (head == null) head = node;
        else {
            // 达到限制.
            if (map.size() == this.capacity) {
                map.remove(head.key);
                head = head.next;
                if (head != null) head.prev = null;
            }
            tail.next = node;
            node.prev = tail;
        }
        tail = node;
        map.put(key, node);
    }
}
