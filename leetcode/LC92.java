package leetcode;

import java.awt.*;

/**
 * author: cshuo
 * date: 2017/4/16
 * version: 1.0
 * description:
 */
public class LC92 {
    public static ListNode reverseBetween(ListNode head, int m, int n){
        if(head == null) return head;
        int count = 0, len = n - m + 1;
        ListNode hh = new ListNode(0);
        hh.next = head;

        while(++count < m){
            hh = hh.next;
        }

        count = 0;
        ListNode p = hh.next, q;
        while(++count < len){
            q = p.next;
            p.next = q.next;
            q.next = hh.next;
            hh.next = q;
        }
        return m == 1? hh.next: head;
    }

    public static void main(String[] args) {
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);
        ListNode a3 = new ListNode(3);
        ListNode a4 = new ListNode(4);
        ListNode a5 = new ListNode(5);
        a1.next = a2;
        a2.next = a3;
        a3.next = a4;
        a4.next = a5;

        ListNode h = reverseBetween(a1, 1, 4);
        while(h != null){
            System.out.println(h.val);
            h = h.next;
        }
    }
}
