package sword;

/**
 * author: cshuo
 * date: 2017/5/1
 * version: 1.0
 * description:
 */
public class FindKthEnd {
    public static void main(String[] args) {
    }

    public ListNode FindKthToTail(ListNode head,int k) {
        ListNode end = head;
        for(int i=0; i<k; i++){
            if(end == null) return null;
            end =  end.next;
        }
        while(end != null){
            head = head.next;
            end = end.next;
        }

        return head;
    }
}
