package leetcode;

/**
 * Created by cshuo on 2017/8/11
 * 合并两个有序链表.
 */

public class LC21 {
    /**
     * 不需要重新创建节点...使用原链表中的节点即可.
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode p1 = l1, p2 = l2;
        ListNode head = new ListNode(0), h = head;
        while(p1 != null || p2 != null) {
            if(p1 == null){
                h.next = p2;
                p2 = p2.next;
            }
            else if(p2 == null){
                h.next = p1;
                p1 = p1.next;
            }
            else if(p1.val <= p2.val) {
                h.next = p1;
                p1 = p1.next;
            } else {
                h.next = p2;
                p2 = p2.next;
            }
            h = h.next;
        }
        return head.next;
    }

    /**
     * 更高效的写法.
     */
    public ListNode merge(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0), h = head;
        while(l1 != null && l2 != null) {
            if(l1.val <= l2.val) {
                h.next = l1;
                l1 = l1.next;
            } else {
                h.next = l2;
                l2 = l2.next;
            }
            h = h.next;
        }
        if(l1 != null) h.next = l1;
        if(l2 != null) h.next = l2;
        return head.next;
    }
}
