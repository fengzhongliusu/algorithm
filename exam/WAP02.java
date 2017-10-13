package exam;

import java.util.*;

public class WAP02 {
    static class Node {
        int val;
        Node prev;
        Node next;
        public Node(int val) {this.val = val;}
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
            Node head = null, tail = null;
            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
            int size = 0;
            int n = in.nextInt();
            for(int i=0; i<n; i++) {
                String cmd = in.next();
                if(cmd.equals("pop_back")) {
                    if(size == 0) System.out.println("Error");
                    else {
                        System.out.println(tail.val);
                        pq.remove(new Integer(tail.val));
                        if(tail.prev != null){
                            tail.prev.next = null;
                            tail = tail.prev;
                        }
                        else {
                            tail = null;
                            head = null;
                        }
                        size--;
                    }
                } else if(cmd.equals("pop_front")) {
                    if(size == 0) System.out.println("Error");
                    else {
                        System.out.println(head.val);
                        pq.remove(new Integer(head.val));
                        if(head.next != null){
                            head.next.prev = null;
                            head = head.next;
                        }
                        else {
                            head = null;
                            tail = null;
                        }
                        size--;
                    }
                }
                else if(cmd.equals("reverse")) {
                    reverse(head);
                    Node tmp = head;
                    head = tail;
                    tail = tmp;
                } else if(cmd.equals("push_front")) {
                    Node node = new Node(in.nextInt());
                    pq.add(node.val);
                    if(head == null) {
                        head = node;
                        tail = node;
                    } else {
                        node.next = head;
                        head.prev = node;
                        head = node;
                    }
                    size++;
                } else if(cmd.equals("push_back")) {
                    Node node = new Node(in.nextInt());
                    pq.add(node.val);
                    if(tail == null) {
                        head = node;
                        tail = node;
                    } else {
                        node.prev = tail;
                        tail.next = node;
                        tail = node;
                    }
                    size++;
                } else {
                    System.out.println(size == 0? "Error" : pq.peek());
                }
            }
        }
        in.close();
    }

    public static void reverse(Node h) {
        Node tmp = h;
        while(tmp != null) {
            Node swap = tmp.next;
            tmp.next = tmp.prev;
            tmp.prev = swap;
            tmp = swap;
        }
    }
}
