package exam;

public class WAPINTERVIEW01{
    static class Node {
        int val;
        Node next;
        public Node(int val) {
            this.val = val;
        }
    }
    public static Node reverse(Node h) {
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
    public static Node order(Node h) {
        if(h == null || h.next == null) return h;
        // find mid of the linked list
        Node prev = null, slow = h, fast = h;
        while(fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;
        Node h2 = reverse(slow);
        if(h2 == null) System.out.println("none");

        Node p1 = h, p2 = h2;
        Node pprev = new Node(0);
        while(p1 != null) {
            Node tmp1 = p1.next, tmp2 = p2.next;
            pprev.next = p1;
            p1.next = p2;
            pprev = p1.next;
            p1 = tmp1;
            p2 = tmp2;
        }
        return h;
    }

    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        Node h = order(n1);
        while(h != null) {
            System.out.println(h.val);
            h = h.next;
        }
    }
}