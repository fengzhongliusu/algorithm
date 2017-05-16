package collections.linkedList;

/**
 * author: cshuo
 * date: 2017/4/12
 * version: 1.0
 * description: 判断两个单链表是否相交于某一点
 */
public class CheckJoin {
    public static void main(String[] args) {
        Node a1 = new Node(1);
        Node a2 = new Node(2);
        Node a3 = new Node(3);
        Node b1 = new Node(1);
        Node c1 = new Node(1);
        Node c2 = new Node(2);

        a1.next = a2;
        a2.next = a3;
        a3.next = c1;
//        c1.next = c2;

        b1.next = c2;

        System.out.println(checkJoin(a1, b1));
        System.out.println(checkJoin2(a1, b1));
    }

    /**
     * 通过求两个链表的长度差，移动较长链表的头指针，保证进行对比时两个链表指针相对位置相同.
     * @param h1
     * @param h2
     * @return
     */
    public static boolean checkJoin(Node h1, Node h2){
        if(h1 == null || h2 == null) return false;
        int len1 = getLen(h1), len2 = getLen(h2);
        Node p1 = h1, p2 = h2;

        int delta = Math.abs(len1-len2);
        if(len1 > len2)
            while (delta-- > 0) p1 = p1.next;
        else if(len1 < len2)
            while(delta -- > 0) p2 = p2.next;

        while(p1 !=null && p2 !=null){
            if(p1 == p2) return true;
            p1 = p1.next;
            p2 = p2.next;
        }
        return false;
    }

    /**
     * @param h1
     * @param h2
     * @return
     * 将一个链表的头尾指针相连形成一个环，再判断另外一个链表是否包含环；若包含，则两个链表汇聚，否则，不汇聚.
     */
    public static boolean checkJoin2(Node h1, Node h2){
        if(h1 == null || h2 == null) return false;
        Node t = h2;
        while(t.next != null) t = t.next;
        t.next = h2;

        return CheckRing.checkRing(h1);
    }

    public static int getLen(Node h){
        int len =0;
        while(h != null){
            h = h.next;
            len++;
        }
        return len;
    }
}
