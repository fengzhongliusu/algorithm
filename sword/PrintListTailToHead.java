package sword;

import java.util.ArrayList;

/**
 * author: cshuo
 * date: 2017/5/1
 * version: 1.0
 * description:
 */
public class PrintListTailToHead {
    public static void main(String[] args) {
    }

    public static ArrayList<Integer> printList(ListNode listNode){
        ArrayList<Integer> lt = new ArrayList<>();
        while(listNode != null){
            lt.add(0, listNode.val);
            listNode = listNode.next;
        }
        return lt;
    }
}
