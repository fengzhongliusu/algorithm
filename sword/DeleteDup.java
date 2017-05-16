package sword;

/**
 * author: cshuo
 * date: 2017/5/2
 * version: 1.0
 * description: 输出有序链表里的重复节点: 链表1->2->3->3->4->4->5 处理后为 1->2->5
 */
public class DeleteDup {
    public static void main(String[] args) {
    }

    public ListNode deleteDup(ListNode head){
        ListNode pHead = new ListNode(0);
        pHead.next = head;
        ListNode p = pHead, q = head;
        ListNode r;
        boolean dupSign;               //标记q起始节点是否重复
        while(q!= null){
            r = q.next;
            dupSign = false;
            while(r != null){
                if(r.val != q.val) break;
                q.next = r.next;       //删除所有与q重复的节点
                r = q.next;
                dupSign = true;
            }
            q = q.next;
            if(dupSign) p.next = q;    //删除q节点
            else p = p.next;           //p, q后移一位
        }
        return pHead.next;
    }
}
