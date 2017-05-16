package leetcode;

/*
* delete the Nth node from the end of the list, and return the head
* NOTE: fast and slow pointer.
**/

public class Solution19 {
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fastP = head;
        ListNode cur = head, pre = cur;
        int i = 0;
        while(i++ < n-1){
            fastP = fastP.next;
        }

        while (fastP.next != null){
            fastP = fastP.next;
            pre = cur;
            cur = cur.next;
        }

        if(cur == head)
            return pre.next;
        else{
            pre.next = cur.next;
            return head;
        }
    }

    public static void iterateT(ListNode root){
        while(root != null){
            System.out.print(root.val + " ");
            root = root.next;
        }
    }

    public static void main(String[] args) {
        ListNode t1 = new ListNode(1);
        ListNode t2 = new ListNode(2);
        t1.next = t2;
        ListNode h = Solution19.removeNthFromEnd(t1, 1);
        Solution19.iterateT(h);
    }
}
