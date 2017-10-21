package collections.linkedList;

/**
 * author: cshuo
 * date: 2017/4/12
 * version: 1.0
 * description:
 */
public class Reverse {
    public static void main(String[] args) {
        Node a1 = new Node(1);
        Node a2 = new Node(2);
        Node a3 = new Node(3);
        Node a4 = new Node(4);
        Node a5 = new Node(5);
        a1.next = a2;
        a2.next = a3;
        a3.next = a4;
        a4.next = a5;

//        Node h = reverse(a1);
        Node h = reverse2(a1);
        while(h != null){
            System.out.println(h.val);
            h = h.next;
        }
    }

    /**
     * @param h
     * @return
     * 新增一个额外的头结点pp,初始指向原头结点h，p 固定指向原链表的头结点h，每次迭代将链表后面节点插入到pp的后面，即可完成反转，过程如下:
     * pp->1->2->3->4
     * pp->2->1->3->4
     * pp->3->2->1->4
     * pp->4->3->2->1
     */
    public static Node reverse(Node h){
        if(h == null || h.next == null) return h;
        Node pp = new Node(0);
        pp.next = h;
        Node p = h, q;
        while(p.next != null){
            q = p.next;
            p.next = q.next;
            q.next = pp.next;
            pp.next = q;
        }
        return pp.next;
    }


    /**
     * @param h
     * @return
     * 三个指针每次反转两个节点, 指针初始位置如下:
     * @->@->@->@
     * p  q
     *    r
     * 每次迭代指针变化是：
     * r = q.next;
     * q.next = p;   //反转
     * p = q;
     * q = r;
     */
    public static Node reverse2(Node h){
        if(h==null || h.next == null) return h;
        Node p = h, q = h.next, r = h.next;
        h.next = null;
        while(q != null){
            r = q.next;
            q.next = p;
            p = q;
            q = r;
        }
        return p;
    }

    public Node practice(Node h) {
        if(h == null || h.next == null) return h;
        Node p = h, q = h.next, r;
        h.next = null;
        while(q != null) {
            r = q.next;
            q.next = p;
            p = q;
            q = r;
        }
        return p;
    }
}
