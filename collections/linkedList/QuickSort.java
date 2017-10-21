package collections.linkedList;

/**
 * Created by cshuo on 2017/8/11
 * 链表的快排序
 * 思路：链表物理结构不变，采用值交换的形式：
 * 使用两个指针，p，q，其中p指向已遍历节点中最后一个小于pivot的节点，q指向当前遍历到的节点;
 * 故交换过程是:若q<pivot, 则{p=p.next, swap(p,q)}。
 * 图片解释：http://blog.csdn.net/wumuzi520/article/details/8078322
 */
public class QuickSort {
    public ListNode sortList(ListNode head) {
        sort(head,null);
        return head;
    }

    public void sort(ListNode h, ListNode t) {
        if(h == null || h == t) return;
        ListNode p = partition(h, t);
        sort(h, p);
        sort(p.next, t);
    }

    public ListNode partition(ListNode h, ListNode t) {
        if(h == t) return t;
        ListNode p = h, q = h.next;
        int val = p.val;

        while(q != t) {
            if(q.val < val) {
                p = p.next;
                int tmp = p.val;
                p.val = q.val;
                q.val = tmp;
            }
            q = q.next;
        }

        int tmp = p.val;
        p.val = h.val;
        h.val = tmp;
        return p;
    }

    /**
     * for practicing
     */
    public ListNode practice(ListNode h, ListNode t) {
        if(h == t) return h;
        ListNode p = h, q = h;
        int pivot = h.val;
        while(q != t) {
            if(q.val < pivot) {
                p = p.next;
                int tmp = p.val;
                p.val = q.val;
                q.val = tmp;
            }
            q = q.next;
        }
        int tmp = p.val;
        p.val = pivot;
        h.val = tmp;
        return p;
    }
}
