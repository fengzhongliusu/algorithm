package collections.linkedList;

/**
 * author: cshuo
 * date: 2017/4/12
 * version: 1.0
 * description:
 */
public class CheckRing {

    // 记录交汇点
    private static Node join;

    public static void main(String[] args) {
        Node a1 = new Node(1);
        Node a2 = new Node(2);
        Node a3 = new Node(3);
        Node a4 = new Node(4);
        a1.next = a2;
        a2.next = a3;
        a3.next = a4;
        a4.next = a1;
        if(checkRing(a1)){
            System.out.println("Ring get!!!");
            System.out.println(findEntr(a1).val);
        } else{
            System.out.println("No ring...");
        }

    }

    public static boolean checkRing(Node head){
        if(head == null || head.next == null) return false;
        Node slow = head, fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                join = slow;
                return true;
            }
        }
        return false;
    }

    /**
     * 快慢指针法, 指针相遇, 令一个指针重新指向头结点，两个指针同时移动，步长为1，最后两个指针定相遇于环入口.
     * A+B+kN = 2A+2B
     * kN=A+B, (A = kN - B),
     * A: 头结点到环的入口距离，B: 相遇节点与入口的距离；
     */
    public static Node findEntr(Node head){
        Node p = head, q = join;
        while(p != q){
            p = p.next;
            q = q.next;
        }
        return p;
    }
}
