package sword;

/**
 * author: cshuo
 * date: 2017/5/2
 * version: 1.0
 * description: 合并两个递增链表.
 */
public class MergeLinkList {
    public static void main(String[] args) {
    }

    public ListNode merge(ListNode l1, ListNode l2){
        ListNode head = new ListNode(0), p = head;
        while(l1 !=null || l2 != null){
            if(l1 == null){
                p.next = l2;
                break;
            }
            if(l2 == null){
                p.next = l1;
                break;
            }
            if(l1.val <= l2.val){
                p.next =l1;
                l1 = l1.next;
            } else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }
        return head.next;
    }
}
