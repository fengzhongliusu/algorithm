package sword;

/**
 * Created by cshuo on 2017/7/24
 * 一个链表中包含环，请找出该链表的环的入口结点。
 */
public class EntryOfLoop {
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
        a5.next = a3;
        System.out.println(EntryNodeOfLoop(a1).val);
    }

    public static ListNode EntryNodeOfLoop(ListNode pHead)
    {
        if(pHead == null || pHead.next == null) return null;
        // 同一节点出发，快慢指针必定相遇.
        ListNode fast = pHead, slow = pHead;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if(slow == fast) break;
        }

        // 两个指针分别从头结点和相遇节点出发，两者相遇节点就是环的入口.
        fast = pHead;
        while(fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
