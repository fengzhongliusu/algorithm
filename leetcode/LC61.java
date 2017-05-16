package leetcode;

import java.awt.*;

/**
 * author: cshuo
 * date: 2017/4/16
 * version: 1.0
 * description:
 *
 Given a list, rotate the list to the right by k places, where k is non-negative.
 For example:
 Given 1->2->3->4->5->NULL and k = 2,
 return 4->5->1->2->3->NULL.
 * 思路：先成环，在找新的头结点，并将尾节点next置为null。
 */

public class LC61 {
    public static ListNode rotateRight(ListNode head, int k) {
        if(head == null) return head;
        ListNode p = head;
        int len = getLen(p);
        if(k % len == 0) return head;

        while (p.next != null) p = p.next;    //成环
        p.next = head;

        int step = len - k % len;
        ListNode t = head, q = head.next;
        while(--step > 0){
            t = t.next;
            q = q.next;
        }
        t.next = null;
        return q;
    }

    public static int getLen(ListNode h){
        int count = 0;
        while(h != null){
            count++;
            h = h.next;
        }
        return count;
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

        ListNode h = rotateRight(a1, 100);
        while(h != null){
            System.out.println(h.val);
            h = h.next;
        }
    }
}
