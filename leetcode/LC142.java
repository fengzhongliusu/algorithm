package leetcode;

/**
 * Created by cshuo on 2017/7/28
 * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.

 Note: Do not modify the linked list.
 */
public class LC142 {

    /**
     * 快慢指针法, 指针相遇, 令一个指针重新指向头结点，两个指针同时移动，步长为1，最后两个指针定相遇于环入口.
     * A+B+kN = 2A+2B
     * kN=A+B, (A = kN - B),
     * A: 头结点到环的入口距离，B: 相遇节点与入口的距离；
     */
    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null) return null;
        ListNode slow = head, fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) break;
        }
        if(slow != fast) return null;
        fast = head;
        while(fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
