package collections.linkedList;
import java.util.*;

/**
 * Created by cshuo on 2017/8/11
 * 合并k个有序单链表.
 * 复杂度分析：
 * n: 链表的平均长度，k：链表的个数
 * 复杂度分析：简单的说，该过程和归并排序相同，不同的是归并排序的element是数字，这里的element是链表，数字的比较是O(1)，
 * 而这里链表的比较是O(n)，所以复杂度是O(nklgk);
 *
 * 更详细的从每轮递归看：
 * 第一轮merge次数 k/2, 每次merge复杂度 2n, 复杂度：nk;
 * 第二轮merge次数 k/4, 每次merge复杂度 4n, 复杂度: nk;
 * ......
 * 最后一轮同样是复杂度 nk.
 * 共有lgk轮，所以复杂度nklgk.
 */
public class Kmerge {
    public ListNode mergeKLists(ListNode[] lists) {
        return recursion(lists, 0, lists.length-1);
    }

    /**
     * 类似mergeSort的操作过程.
     */
    public ListNode recursion(ListNode[] lists, int l ,int r) {
        if(l == r) return lists[l];
        if(r < l) return null;
        int mid = (r-l)/2 + l;
        ListNode l1 = recursion(lists, l, mid);
        ListNode l2 = recursion(lists, mid+1, r);
        return merge(l1, l2);
    }

    /**
     * 合并两个单链表
     */
    public ListNode merge(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0), h = head;
        while(l1 != null && l2 !=null) {
            if(l1.val <= l2.val){
                h.next = l1;
                l1 = l1.next;
            } else {
                h.next = l2;
                l2 = l2.next;
            }
            h = h.next;
        }
        h.next = (l1==null?l2:l1);
        return head.next;
    }

    /**
     * for practicing.
     */
    public ListNode exercise(ListNode l1, ListNode l2) {
        return null;
    }

    /**方法二：基于优先级队列, 初始时将各个链表的头结点放入优先级队列，每次更新时把其后元素压入队列.*/
    public ListNode mergeKlists(ListNode[] lists) {
        if(lists == null || lists.length < 1) return null;
        PriorityQueue<ListNode> q = new PriorityQueue(lists.length, new Comparator<ListNode>(){
            @Override
            public int compare(ListNode o1, ListNode o2){
                return o1.val - o2.val;
            }
        });
        ListNode head = new ListNode(0), h = head;
        for(ListNode e: lists)
            if(e != null) q.add(e);
        while(!q.isEmpty()) {
            h.next = q.poll();
            h = h.next;
            if(h.next != null) q.add(h.next);
        }
        return head.next;
    }
}
