package leetcode;

/**
 * Created by cshuo on 2021/8/9
 */
public class LC148 {
    public ListNode sortList(ListNode head) {
        sort(head, null);
        return head;
    }

    public void sort(ListNode h, ListNode t) {
        if (h == null || h == t) return;
        ListNode p = partition(h, t);
        sort(h, p);
        sort(p.next, t);
    }

    public ListNode partition(ListNode h, ListNode t) {
        ListNode p = h, q = h.next;
        int val = h.val;
        while (q != t) {
            if (q.val < val) {
                p = p.next;
                int tmp = p.val;
                p.val = q.val;
                q.val = tmp;
            }
            q = q.next;
        }
        h.val = p.val;
        p.val = val;
        return p;
    }
}
